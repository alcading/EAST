package east.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;

import east.utils.tools.DBUtil;

/**
 * 生成金标数据DAO
 * 
 * @author Alca Ding
 */
public class JBDao {
    
	private static final Logger logger = Logger.getLogger(JBDao.class);
	private String zftxdk = "018,041"; // 政府贴息贷款
	private String bankReport_bankCode = ""; // 总行金标报送金融金钩代码
	private Map<String, String> clrClass = null;
	// private Map lntypeMap = null;
	private Map<String, String> lntypeMap = null;

	public JBDao() throws Exception {
		bankReport_bankCode = BaseDao.getJBBankCode();
		clrClass = getDataDicMap(500);// 五级分类
		lntypeMap = getDataDicMap(501);
	}

	public void insertDepositBalance(String monthEndDate) throws Exception {

		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		logger.info("....................处理存款余额信息begin.......................");
		try {

			StringBuffer query = new StringBuffer();
			query.append("insert into DEPB( ");
			//利率取llb内的执行利率  距离起息日期最近的利率
			// 活期对公  
			// 单位活期存款汇总报送  D011 D013
			query.append(
					"select sjrq,JRJGBM,KHLX,CKZHDM,CKXYDM,CPLB,CKXYQSRQ,CKXYDQRQ,CKBZ,sum(CKYE),LLSFGD,LLSP from ( ");
			query.append("select to_date('" + monthEndDate
					+ "','yyyymmdd') as sjrq,case when li.jbcode is not null then li.jbcode else '"
					+ bankReport_bankCode
					+ "' end as JRJGBM,case when hq.kmdh ='210110' then '1' else '0' end as KHLX,null as CKZHDM,null as CKXYDM, ");
			query.append(
					"case when lb.ckcplb is not null then lb.ckcplb else 'D01' end as CPLB,null as CKXYQSRQ,null as CKXYDQRQ,'CNY' as CKBZ, ");
			query.append(
					"hq.zhye as CKYE,'RF02' as LLSFGD, case  when hq.llfdfs='0' then hq.fdll+llb.ll else llb.ll*(1+hq.fdll/100)  end as LLSP ");
			query.append("from hqdgzwj hq ");
			query.append("left join brno_jbcd_link li on hq.dqdh||jgdh = li.brno ");
			query.append("left join ckcplb lb on hq.kmdh = lb.kmdh ");
//			query.append("left join f_temp_llb llb on hq.lldh = llb.lldh ");
			query.append("left join llb llb on hq.lldh = llb.hbzl||llb.llzl||llb.ckqx ");
			query.append(
					"where hq.jlzt not in ('0','2') and hq.kmdh in ('210101','210110') and hq.zhye > 0 and hq.xdcked = 0 ");
			query.append("and llb.sxrq = (select max(x.sxrq) from llb x where x.sxrq <= hq.qxrq and hq.lldh=x.hbzl||x.llzl||x.ckqx  and x.jlzt = '1') ");
			query.append("union all ");
			// 对私活期
			// 活期储蓄存款汇总报送
			// query.append("select
			// sjrq,JRJGBM,KHLX,CKZHDM,CKXYDM,CPLB,CKXYQSRQ,CKXYDQRQ,CKBZ,sum(CKYE),LLSFGD,LLSP
			// from ( ");
			query.append("select to_date('" + monthEndDate
					+ "','yyyymmdd') as sjrq,case when li.jbcode is not null then li.jbcode else '"
					+ bankReport_bankCode
					+ "' end as JRJGBM,'1' as KHLX,null as CKZHDM,null as CKXYDM,case when lb.ckcplb is not null then lb.ckcplb else 'D01' end as CPLB, ");
			query.append(
					"null as CKXYQSRQ,null as CKXYDQRQ,'CNY' as CKBZ,hq.zhye as CKYE,'RF02' as LLSFGD,case  when hq.llfdfs='0' then hq.fdll+llb.ll else llb.ll*(1+hq.fdll/100)  end  as LLSP ");
		           //"null as CKXYQSRQ,null as CKXYDQRQ,'CNY' as CKBZ,hq.zhye as CKYE,'RF02' as LLSFGD, case when hq.fdll >0 then hq.fdll else llb.ll end as LLSP ");
			query.append("from dshqzwj hq ");
			query.append("left join brno_jbcd_link li on hq.dqdh||jgdh = li.brno ");
			query.append("left join ckcplb lb on hq.kmdh = lb.kmdh ");
			//query.append("left join f_temp_llb llb on hq.lldh = llb.lldh ");
			query.append("left join llb llb on hq.lldh = llb.hbzl||llb.llzl||llb.ckqx ");
			query.append("where hq.jlzt not in ('0','2') and hq.kmdh = '211110' and hq.zhye > 0 ");
			query.append("and llb.sxrq = (select max(x.sxrq) from llb x where x.sxrq <= hq.qxrq and hq.lldh=x.hbzl||x.llzl||x.ckqx  and x.jlzt = '1') ");

			query.append("union all ");
			// 内部帐活期储蓄存款
			query.append("select to_date('" + monthEndDate
					+ "','yyyymmdd') as sjrq,case when li.jbcode is not null then li.jbcode else '"
					+ bankReport_bankCode
					+ "' end as JRJGBM,'1' as KHLX,null as CKZHDM,null as CKXYDM,case when lb.ckcplb is not null then lb.ckcplb else 'D01' end as CPLB, ");
			query.append(
					"null as CKXYQSRQ,null as CKXYDQRQ,'CNY' as CKBZ,nb.zhye as CKYE,'RF02' as LLSFGD, case  when nb.llfdfs='0' then nb.fdll+llb.ll else llb.ll*(1+nb.fdll/100) end as LLSP ");
			query.append("from nbzzwj nb ");
			query.append("left join brno_jbcd_link li on nb.dqdh||jgdh = li.brno ");
			query.append("left join ckcplb lb on nb.kmdh = lb.kmdh ");
			//query.append("left join f_temp_llb llb on nb.lldh = llb.lldh ");
			query.append("left join llb llb on nb.lldh = llb.hbzl||llb.llzl||llb.ckqx ");
			query.append("where substr(nb.kmdh,1,4) = '2111' and nb.zhye > 0 ");
			query.append("and llb.sxrq = (select max(x.sxrq) from llb x where x.sxrq <= nb.qxrq and nb.lldh=x.hbzl||x.llzl||x.ckqx  and x.jlzt = '1') ");
			// query.append(") group by
			// sjrq,JRJGBM,KHLX,CKZHDM,CKXYDM,CPLB,CKXYQSRQ,CKXYDQRQ,CKBZ,LLSFGD,LLSP
			// ");
			query.append(") group by sjrq,JRJGBM,KHLX,CKZHDM,CKXYDM,CPLB,CKXYQSRQ,CKXYDQRQ,CKBZ,LLSFGD,LLSP ");
			query.append("union all ");
			// 其他对公活期存款汇 D011
			query.append("select to_date('" + monthEndDate
					+ "','yyyymmdd'),case when li.jbcode is not null then li.jbcode else '" + bankReport_bankCode
					+ "' end,'0',null,null, ");
			query.append("case when lb.ckcplb is not null then lb.ckcplb else 'D01' end ,null,null,'CNY', ");
			query.append("hq.zhye,'RF02', case  when hq.llfdfs='0' then hq.fdll+llb.ll else llb.ll*(1+hq.fdll/100) end ");
			query.append("from hqdgzwj hq ");
			query.append("left join brno_jbcd_link li on hq.dqdh||jgdh = li.brno ");
			query.append("left join ckcplb lb on hq.kmdh = lb.kmdh ");
			//query.append("left join f_temp_llb llb on hq.lldh = llb.lldh ");
			query.append("left join llb llb on hq.lldh = llb.hbzl||llb.llzl||llb.ckqx ");
			query.append(
					"where hq.jlzt not in ('0','2') and substr(hq.kmdh,1,4) ='2126' and hq.zhye > 0 and hq.xdcked = 0 ");
			query.append("and llb.sxrq = (select max(x.sxrq) from llb x where x.sxrq <= hq.qxrq and hq.lldh=x.hbzl||x.llzl||x.ckqx  and x.jlzt = '1') ");
			
			query.append("union all ");
			// --对公协定存款 D051 D052
			query.append("select to_date('" + monthEndDate
					+ "','yyyymmdd'),case when li.jbcode is not null then li.jbcode else '" + bankReport_bankCode
					+ "' end,'0',hq.zhdh,hq.zhdh,'D051', ");
			query.append("null,null,'CNY',hq.zhye,'RF02', case  when hq.llfdfs='0' then hq.fdll+llb.ll else llb.ll*(1+hq.fdll/100) end ");
			query.append("from hqdgzwj hq ");
			query.append("left join brno_jbcd_link li on hq.dqdh||jgdh = li.brno ");
			query.append("left join ckcplb lb on hq.kmdh = lb.kmdh ");
			//query.append("left join f_temp_llb llb on hq.lldh = llb.lldh ");
			query.append("left join llb llb on hq.lldh = llb.hbzl||llb.llzl||llb.ckqx ");
			query.append(
					"where hq.jlzt not in ('0','2') and substr(hq.kmdh,1,4) not in('2203','2315','2141','2301') and hq.kmdh not in ('210102','210103','210104') ");
			query.append("and hq.xdcked > 0 and hq.zhye > 0 and hq.xdcked >= hq.zhye ");
			query.append("and llb.sxrq = (select max(x.sxrq) from llb x where x.sxrq <= hq.qxrq and hq.lldh=x.hbzl||x.llzl||x.ckqx  and x.jlzt = '1') ");
			
			query.append("union all ");
			query.append("select to_date('" + monthEndDate
					+ "','yyyymmdd'),case when li.jbcode is not null then li.jbcode else '" + bankReport_bankCode
					+ "' end,'0',hq.zhdh,hq.zhdh,'D051', ");
			query.append("null,null,'CNY',hq.xdcked,'RF02', case  when hq.llfdfs='0' then hq.fdll+llb.ll else llb.ll*(1+hq.fdll/100) end ");
			query.append("from hqdgzwj hq ");
			query.append("left join brno_jbcd_link li on hq.dqdh||jgdh = li.brno ");
			query.append("left join ckcplb lb on hq.kmdh = lb.kmdh ");
			//query.append("left join f_temp_llb llb on hq.lldh = llb.lldh ");
			query.append("left join llb llb on hq.lldh = llb.hbzl||llb.llzl||llb.ckqx ");
			query.append(
					"where hq.jlzt not in ('0','2') and substr(hq.kmdh,1,4) not in('2203','2315','2141','2301') and hq.kmdh not in ('210102','210103','210104') ");
			query.append("and hq.xdcked > 0 and hq.zhye > 0 and hq.xdcked < hq.zhye ");
			query.append("and llb.sxrq = (select max(x.sxrq) from llb x where x.sxrq <= hq.qxrq and hq.lldh=x.hbzl||x.llzl||x.ckqx  and x.jlzt = '1') ");
			
			query.append("union all ");
			query.append("select to_date('" + monthEndDate
					+ "','yyyymmdd'),case when li.jbcode is not null then li.jbcode else '" + bankReport_bankCode
					+ "' end,'0',hq.zhdh,hq.zhdh,'D052', ");
			query.append(
					"null,null,'CNY', hq.zhye - hq.xdcked,'RF02', case  when hq.llfdfs='0' then hq.fdll+llb.ll else llb.ll*(1+hq.fdll/100) end ");
			query.append("from hqdgzwj hq ");
			query.append("left join brno_jbcd_link li on hq.dqdh||jgdh = li.brno ");
			query.append("left join ckcplb lb on hq.kmdh = lb.kmdh ");
			//query.append("left join f_temp_llb llb on hq.lldh = llb.lldh ");
			query.append("left join llb llb on hq.lldh = llb.hbzl||llb.llzl||llb.ckqx ");
			query.append(
					"where hq.jlzt not in ('0','2') and substr(hq.kmdh,1,4) not in('2203','2315','2141','2301') and hq.kmdh not in ('210102','210103','210104') ");
			query.append("and hq.xdcked > 0 and hq.zhye > 0 and hq.xdcked < hq.zhye ");
			query.append("and llb.sxrq = (select max(x.sxrq) from llb x where x.sxrq <= hq.qxrq and hq.lldh=x.hbzl||x.llzl||x.ckqx  and x.jlzt = '1') ");
			
			query.append("union all ");
			// 其他活期存款
			// query.append("select to_date('"+ monthEndDate+"','yyyymmdd'),case
			// when li.jbcode is not null then li.jbcode else '"+
			// bankReport_bankCode+"' end,'1',hq.zhdh,hq.zhdh,case when
			// lb.ckcplb is not null then lb.ckcplb else 'D01' end, ");
			// query.append("null,null,'CNY',hq.zhye,'RF02', case when hq.fdll
			// >0 then hq.fdll else llb.ll end ");
			// query.append("from dshqzwj hq ");
			// query.append("left join brno_jbcd_link li on hq.dqdh||jgdh =
			// li.brno ");
			// query.append("left join ckcplb lb on hq.kmdh = lb.kmdh ");
			// query.append("left join f_temp_llb llb on hq.lldh = llb.lldh ");
			// query.append("where hq.jlzt not in ('0','2') and hq.kmdh <>
			// '211110' and hq.zhye > 0 ");
			// query.append("union all ");
			// 定期 D012
			query.append("select to_date('" + monthEndDate
					+ "','yyyy-mm-dd'),case when li.jbcode is not null then li.jbcode else '" + bankReport_bankCode
					+ "' end,case when dq.ywdh='002' then '0' else '1' end, ");
			query.append("dq.zhdh,dq.zhdh,case when lb.ckcplb is not null then lb.ckcplb else 'D01' end, ");
			query.append(
					"to_date(dq.qxrq,'yyyymmdd'), case when dq.dqrq > dq.qxrq then to_date(dq.dqrq,'yyyymmdd') when dq.kmdh='211130' then null else null end,'CNY',dq.zhye, ");
			query.append(
					"case when dq.kmdh='210701' then 'RF02' else 'RF01' end, case  when dq.llfdfs='0' then dq.fdll+llb.ll else llb.ll*(1+dq.fdll/100) end ");
			query.append("from dqzwj dq ");
			query.append("left join brno_jbcd_link li on dq.dqdh||dq.jgdh = li.brno ");
			query.append("left join ckcplb lb on dq.kmdh = lb.kmdh ");
			query.append("left join llb llb on dq.lldh = llb.hbzl||llb.llzl||llb.ckqx ");
			query.append(
					"where dq.jlzt not in ('0','2') and substr(dq.kmdh,1,4) in ('2105','2111','2126') and dq.kmdh<>'211130' and dq.zhye > 0 ");
			query.append("and llb.sxrq = (select max(x.sxrq) from llb x where x.sxrq <= dq.qxrq and dq.lldh=x.hbzl||x.llzl||x.ckqx  and x.jlzt = '1') ");
			
			query.append("union all ");
			//D02定活两便存款
			query.append("select to_date('" + monthEndDate
					+ "','yyyy-mm-dd'),case when li.jbcode is not null then li.jbcode else '" + bankReport_bankCode
					+ "' end,case when dq.ywdh='002' then '0' else '1' end, ");
			query.append("dq.zhdh,dq.zhdh,case when lb.ckcplb is not null then lb.ckcplb else 'D01' end, ");
			query.append(
					"to_date(dq.qxrq,'yyyymmdd'), case when dq.dqrq > dq.qxrq then to_date(dq.dqrq,'yyyymmdd') when dq.kmdh='211130' then null else null end,'CNY',dq.zhye, ");
			query.append(
					"case when dq.kmdh='210701' then 'RF02' else 'RF01' end, get_d02ll('" + monthEndDate
					+ "',dq.qxrq) ");
			query.append("from dqzwj dq ");
			query.append("left join brno_jbcd_link li on dq.dqdh||dq.jgdh = li.brno ");
			query.append("left join ckcplb lb on dq.kmdh = lb.kmdh ");
			query.append(
					"where dq.jlzt not in ('0','2') and dq.kmdh='211130' and dq.zhye > 0 ");		
			query.append("union all ");
			// 通知存款 D014定期储蓄存款
			query.append("select to_date('" + monthEndDate
					+ "','yyyy-mm-dd'),case when li.jbcode is not null then li.jbcode else '" + bankReport_bankCode
					+ "' end,case when dq.ywdh='002' then '0' else '1' end, ");
			query.append("dq.zhdh,dq.zhdh,case when lb.ckcplb is not null then lb.ckcplb else 'D01' end, ");
			query.append(
					"to_date(dq.qxrq,'yyyymmdd'), case when dq.dqrq > dq.qxrq then to_date(dq.dqrq,'yyyymmdd') when dq.ckqx='D01' then to_date('19990101','yyyymmdd') when dq.ckqx='D07' then to_date('19990107','yyyymmdd') else null end,'CNY',dq.zhye, ");
			query.append("'RF01', case  when dq.llfdfs='0' then dq.fdll+llb.ll else llb.ll*(1+dq.fdll/100) end ");
			query.append("from dqzwj dq ");
			query.append("left join brno_jbcd_link li on dq.dqdh||dq.jgdh = li.brno ");
			query.append("left join ckcplb lb on dq.kmdh = lb.kmdh ");
			//query.append("left join f_temp_llb llb on dq.lldh = llb.lldh ");
			query.append("left join llb llb on dq.lldh = llb.hbzl||llb.llzl||llb.ckqx ");
			query.append(
					"where dq.jlzt not in ('0','2') and  substr(dq.kmdh,1,4) in ('2112','2107') and dq.zhye > 0  ");
			query.append("and llb.sxrq = (select max(x.sxrq) from llb x where x.sxrq <= dq.qxrq and dq.lldh=x.hbzl||x.llzl||x.ckqx  and x.jlzt = '1') ");
			
			query.append("union all ");

			// 保证金存款2204 D061 D069
			query.append("select to_date('" + monthEndDate
					+ "','yyyymmdd'),case when li.jbcode is not null then li.jbcode else '" + bankReport_bankCode
					+ "' end,'0',hq.zhdh,hq.zhdh, ");
			query.append("case when lb.ckcplb is not null then lb.ckcplb else 'D01' end ,null,null,'CNY', ");
			query.append("hq.zhye,'RF02', case  when hq.llfdfs='0' then hq.fdll+llb.ll else llb.ll*(1+hq.fdll/100) end ");
			query.append("from hqdgzwj hq ");
			query.append("left join brno_jbcd_link li on hq.dqdh||jgdh = li.brno ");
			query.append("left join ckcplb lb on hq.kmdh = lb.kmdh ");
			//query.append("left join f_temp_llb llb on hq.lldh = llb.lldh ");
			query.append("left join llb llb on hq.lldh = llb.hbzl||llb.llzl||llb.ckqx ");
			query.append(
					"where hq.jlzt not in ('0','2') and substr(hq.kmdh,1,4) ='2204' and hq.zhye > 0 and hq.xdcked = 0 ");
			query.append("and llb.sxrq = (select max(x.sxrq) from llb x where x.sxrq <= hq.qxrq and hq.lldh=x.hbzl||x.llzl||x.ckqx  and x.jlzt = '1') ");
			
			query.append("union all ");
			query.append("select to_date('" + monthEndDate
					+ "','yyyy-mm-dd'),case when li.jbcode is not null then li.jbcode else '" + bankReport_bankCode
					+ "' end,case when dq.ywdh='002' then '0' else '1' end, ");
			query.append("dq.zhdh,dq.zhdh,case when lb.ckcplb is not null then lb.ckcplb else 'D01' end, ");
			query.append(
					"to_date(dq.qxrq,'yyyymmdd'), case when dq.dqrq > dq.qxrq then to_date(dq.dqrq,'yyyymmdd') when dq.kmdh='211130' then null else null end,'CNY',dq.zhye, ");
			query.append("'RF01', case when dq.kmdh='211130' then null when dq.llfdfs='0' then dq.fdll+llb.ll else llb.ll*(1+dq.fdll/100) end ");
			query.append("from dqzwj dq ");
			query.append("left join brno_jbcd_link li on dq.dqdh||dq.jgdh = li.brno ");
			query.append("left join ckcplb lb on dq.kmdh = lb.kmdh ");
			//query.append("left join f_temp_llb llb on dq.lldh = llb.lldh ");
			query.append("left join llb llb on dq.lldh = llb.hbzl||llb.llzl||llb.ckqx ");
			query.append("where dq.jlzt not in ('0','2') and substr(dq.kmdh,1,4)='2204' and dq.zhye > 0 ");
			query.append("and llb.sxrq = (select max(x.sxrq) from llb x where x.sxrq <= dq.qxrq and dq.lldh=x.hbzl||x.llzl||x.ckqx  and x.jlzt = '1') ");
			
			query.append(" ) ");
			// query.append("union all ");
			// 内部帐其他存款
			// query.append("select to_date('"+ monthEndDate+"','yyyymmdd'),case
			// when li.jbcode is not null then li.jbcode else '"+
			// bankReport_bankCode+"' end,'0',nb.zhdh,nb.zhdh,case when
			// lb.ckcplb is not null then lb.ckcplb else 'D01' end, ");
			// query.append("null,null,'CNY',nb.zhye,'RF01', case when nb.fdll
			// >0 then nb.fdll when llb.ll >0 then llb.ll else 0 end ");
			// query.append("from nbzzwj nb ");
			// query.append("left join brno_jbcd_link li on nb.dqdh||jgdh =
			// li.brno ");
			// query.append("left join ckcplb lb on nb.kmdh = lb.kmdh ");
			// query.append("left join f_temp_llb llb on nb.lldh = llb.lldh ");
			// query.append("where substr(nb.kmdh,1,4) in ('2128','2203') and
			// nb.zhye > 0 ) ");
			logger.info("处理存款余额SQL:" + query.toString());
			stmt.execute(query.toString());
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			throw new Exception("处理存款余额信息出错:" + e.getMessage(), e);
		} finally {
			DBUtil.close(conn, stmt, null);
		}
		logger.info("....................处理存款余额信息end.......................");

	}

	public void insertPLoanBalance(String monthEndDate) throws Exception {

		Connection conn = DBUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		logger.info("....................处理个人贷款余额信息(loan_bal_message)begin.......................");
		stmt = conn.createStatement();
		StringBuffer dbSql = new StringBuffer();
		dbSql.append(
				"select  clb.lnco,cui.idno,clb.brcd,clb.lncino,clb.lnid,cli.isdate,clb.duedt,clc.tedate,clb.curcd ,clb.lnbal,clb.irchgmod,clb.usdintrate,cli.guatcode,clb.lnstat,clc.clr_class,clc.ext_cnt,cli.lntype,cli.cocontractno,get_sxje(cli.custcd,'2') as sxje,case when cli.usageno='5' then '01' when cli.usageno='6' then '02' else '03' end as sxbz  ");
		dbSql.append("from  loaninfo cli,tla_lncino_base clb,loancino clc,  customer_info cui ");
		dbSql.append("where ");
		dbSql.append(
				" clb.lnco = cli.contractno and clb.lncino=clc.cino and clb.custno=cui.custcd and clb.lnstat not in ('V') and clb.clrflg<>'1' and clb.lnbal>0 and clb.lnid not in ('101101','150101') ");
		// and clb.brcd in ('90801','90802')
		// and clb.acbrcd in ('90801','90802')

		dbSql.append("order by clb.lnco ");

		String assureInfo = "select seqno from assureinfo where contractno= ? ";

		String mortagageinfo = "select mort_type from mortagage  where contractno= ? ";

		String termchange = "select apptype,status,new_tedate  from term_chg_apply where contractno= ? ";

		String bankCodeInfo = "select jbcode from BRNO_JBCD_LINK where brno = ? ";

		String intrateInfo = "select first 1 intrate  from intrate where intratecd='540'  and  term='199' and effect_date<= ?  order by effect_date  desc  ";

		String sxMessage = "select lldh, qsrq,llfdfs,fdll  from zzdkmxb mx   where substr(mx.dkzh,0,5) ||''|| substr(mx.dkzh,11,6)||''||mx.xh = ?   ";

		String insertData = "insert into LOAB values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		// ----------------------PreparedStatement 余额取值 BEGIN----------
		PreparedStatement ps_assureinfo = conn.prepareStatement(assureInfo);
		PreparedStatement ps_mortagageinfo = conn.prepareStatement(mortagageinfo);
		PreparedStatement ps_termchange = conn.prepareStatement(termchange);
		PreparedStatement ps_bankCodeInfo = conn.prepareStatement(bankCodeInfo);
		PreparedStatement ps_intrateInfo = conn.prepareStatement(intrateInfo);
		PreparedStatement ps_sxMessage = conn.prepareStatement(sxMessage);
		PreparedStatement ps_insertData = conn.prepareStatement(insertData);

		// ----------------------PreparedStatement 信息取值 END----------

		// ----------------------ResultSet 信息取值 BEGIN----------

		ResultSet rs_termchange = null;
		ResultSet rs_bankCodeInfo = null;
		ResultSet rs_assureinfo = null;
		ResultSet rs_mortagageinfo = null;
		ResultSet rs_intrateInfo = null;
		ResultSet rs_sxMessage = null;

		// ----------------------ResultSet 余额取值 END----------
		String globalCino = "";
		try {
			String MonthLastDay = monthEndDate;
			System.out.println("[" + dbSql.toString() + "]");
			Date tsp1 = new Date();
			rs = stmt.executeQuery(dbSql.toString());
			Date tsp2 = new Date();
			System.out.println("sql run time1:" + (tsp2.getTime() - tsp1.getTime()));

			while (rs.next()) {

				String contractno = "";
				String brno = ""; // 金融机构编码
				String cust_type = "1"; // 客户类型
				String lncino = ""; // 借款人代码
				String cino = ""; // cocontractno
				String indus_type = "1"; // 贷款主体行业类别 1
				String reg_place = ""; // 注册地 无需填写
				String invest_element = ""; // 投资经济成分 无需填写
				String compa_scale = ""; // 企业规模 无需填写
				String lnid = ""; // 产品类别
				// String industry = "100"; // 贷款实际投向
				String industry = "9800"; // 贷款实际投向（2018）
				String isdate = ""; // 贷款发放日期
				String tedate = ""; // 贷款到期日期
				String extdate = ""; // 展期到期日期
				String curcd = ""; // 币种
				double lnbal = 0.0; // 贷款余额
				String irchgmod = ""; // 利率是否固定 irchgmod
				double intrate = 0.0; // 利率水平 usdintrate
				String guattype = ""; // 担保方式
				String lnstat = ""; // 贷款状态 正常、展期、逾期。
				String clr_class = ""; // 贷款质量 （WJFLZT）
				String last_upd_date = MonthLastDay; // 数据日期
				String lntype = "";
				boolean ext_flag = false; // 是否展期
				boolean con_flag = false; // 是否缩期
				String cocontractno = "";
				contractno = rs.getString("lnco").trim();
				lncino = rs.getString("idno").trim().trim();
				cino = rs.getString("lncino").trim();
				globalCino = cino;
				cocontractno = rs.getString("cocontractno").trim();
				lntype = rs.getString("lntype").trim();
				isdate = rs.getString("isdate");
				tedate = rs.getString("duedt");// 贷款到期日期
				clr_class = rs.getString("clr_class");
				String brcode = rs.getString("brcd");// 机构号
				double sxje=0.0;//授信金额
				String sxbz="";//属性标志
				ps_bankCodeInfo.setString(1, brcode);
				rs_bankCodeInfo = ps_bankCodeInfo.executeQuery();
				if (rs_bankCodeInfo.next())
					brno = rs_bankCodeInfo.getString("jbcode");
				ps_termchange.setString(1, contractno);
				rs_termchange = ps_termchange.executeQuery();
				// 判断展期缩期 apptype 44-助学贷款展期 ; status 1-审批同意结束
				while (rs_termchange.next()) {
					// if (("1".equals(rs_termchange.getString("status")))
					// && ("44".equals(rs_termchange.getString("apptype")))) {
					if (("44".equals(rs_termchange.getString("apptype")))) {
						ext_flag = true;// 展期
						extdate = rs_termchange.getString("new_tedate");// 展期到期日
						break;
					}
					if (("1".equals(rs_termchange.getString("status")))
							&& ("38".equals(rs_termchange.getString("apptype")))) {
						con_flag = true;// 缩期
						break;
					}
				}
//				if (ext_flag) {
//					// Date exttdt = rs.getDate("tedate");
//					// extdate = DateUtil.dateToString(exttdt); // 展期到期日
//					extdate = rs.getString("tedate");
//				}
				curcd = rs.getString("curcd");
				lnbal = rs.getDouble("lnbal");
				irchgmod = rs.getString("irchgmod");
				if ("0".equals(irchgmod.trim())) {
					irchgmod = "RF01"; // 固定利率方式
				} else {
					irchgmod = "RF02";
				}

				if (contractno.substring(0, 2).equals("gd") || !"666".equals(lntype)) {
					intrate = rs.getDouble("usdintrate");
				} else { // 邯郸授信卡类业务
					ps_sxMessage.setString(1, cino);
					rs_sxMessage = ps_sxMessage.executeQuery();
					if (rs_sxMessage.next()) {
						// String lldh = "";
						// String llfdfs = "";
						Double fdll = 0.0;
						// lldh = rs_sxMessage.getString("lldh");
						// Date qsrq = rs_sxMessage.getDate("qsrq");// 贷款起始日期
						// Date qsrq =
						// DataFormat.ConvertDate1(rs_sxMessage.getString("qsrq"));
						// llfdfs = rs_sxMessage.getString("llfdfs");
						fdll = rs_sxMessage.getDouble("fdll");
						ps_intrateInfo.setString(1, rs_sxMessage.getString("qsrq"));
						rs_intrateInfo = ps_intrateInfo.executeQuery();
						if (rs_intrateInfo.next()) {
							if (fdll > 0) {
								intrate = rs_intrateInfo.getDouble("intrate");
								intrate = intrate * (1 + fdll / 100);
							} else {
								intrate = rs_intrateInfo.getDouble("intrate");
							}
						}
					} else {
						;
					}

				}

				guattype = rs.getString("guatcode");
				/*
				 * A 质押贷款 B 抵押贷款 B01 房地产抵押贷款 B99 其他抵押贷款 C 保证贷款 C01 联保贷款 C99
				 * 其他保证贷款 D 信用/免担保贷款 E 组合担保 Z 其他
				 */
				switch (guattype.charAt(0)) {
				case '1': {
					guattype = "A";
				}
					break;
				case '2': {
					ps_mortagageinfo.setString(1, cocontractno);
					rs_mortagageinfo = ps_mortagageinfo.executeQuery();
					if (rs_mortagageinfo.next()) {
						if ("1".equals(rs_mortagageinfo.getString("mort_type").trim())
								|| "2".equals(rs_mortagageinfo.getString("mort_type").trim())
								|| "3".equals(rs_mortagageinfo.getString("mort_type").trim())) {
							guattype = "B01"; // 房地产抵押贷款
						} else {
							guattype = "B99"; // 其它抵押贷款
						}
					} else {
						guattype = "B";
					}
				}
					break;
				case '3': {
					ps_assureinfo.setString(1, cocontractno);
					rs_assureinfo = ps_assureinfo.executeQuery();
					if (rs_assureinfo.next()) {
						if (rs_assureinfo.getInt("seqno") > 1) {
							guattype = "C01"; // 联保贷款
						} else {
							guattype = "C99";
						}

					} else {
						guattype = "C";
					}
				}
					break;
				case '4': {
					guattype = "D";
				}
					break;
				case '5':
				case '6': {
					guattype = "E";
				}
					break;
				default: {
					guattype = "Z";
				}
					break;
				}

				lnstat = rs.getString("lnstat");

				if (zftxdk.indexOf(lntype) != -1 // 贷款类型 区分下岗失业贷款
						&& DataFormat.ConvertDate1(MonthLastDay)
								.before(DataFormat.ConvertDate1(rs.getString("duedt")))) {// 政府贴息贷款，而且没有到期的
					lnstat = "0";
					clr_class = "0";
				}

				if ("0".equals(lnstat.trim())) {
					lnstat = "FS01"; // 正常
				} else if ("1".equals(lnstat.trim()) || "2".equals(lnstat.trim())) {
					lnstat = "FS03";// 逾期
				} else if ("E".equals(lnstat.trim())) {
					lnstat = "FS01";
				}
				if (ext_flag) {// 展期
					lnstat = "FS02";
				}
				if (con_flag) {// 缩期
					lnstat = "FS09";
				}

				if (!DataFormat.isEmpty(contractno)) {
					// 业务种类细分
					lnid = getTypedetail(lntype, conn); // 与征信接口统一的贷款
					if (DataFormat.isEmpty(lnid)) {
						lnid = "99";
					}
					if (lntype.equalsIgnoreCase("018") || lntype.equalsIgnoreCase("035")) {
						lnid = "41"; // 与征信接口不统一的两种贷款
					}
					// lnid = String.valueOf(lntypeMap.get(lnid.trim()));// 501
					lnid = lntypeMap.get(lnid.trim());// 501
					// add by weigang.lv 为空的默认给消费类型
					if (DataFormat.isEmpty(lnid)) {
						lnid = "F0219";
					}
					if (lntype.equals("001") || lntype.equals("050")) {
						lnid = "F99";
					}
					sxje=rs.getDouble("sxje");//授信金额
					//usageno（贷款用途代码：1.个人住房消费；2.个人住房按揭；3.购自用车；4.住房装修；5.个体工商户生产经营；6.小微企业主生产经营；7.其他生产经营；8.其他消费；A.国家助学贷款；B.一般商业性助学贷款；）
					sxbz=rs.getString("sxbz");//属性标志
					ps_insertData.setDate(1, (java.sql.Date) DataFormat.ConvertDate1(last_upd_date));
					ps_insertData.setString(2,
							brno == null || brno.trim().length() < 1 ? bankReport_bankCode : brno.trim());
					ps_insertData.setString(3, cust_type);
					ps_insertData.setString(4, lncino);
					ps_insertData.setString(5, indus_type);
					ps_insertData.setString(6, reg_place);
					ps_insertData.setString(7, invest_element);
					ps_insertData.setString(8, compa_scale);
					ps_insertData.setString(9, cino);
					ps_insertData.setString(10, lnid);
					ps_insertData.setString(11, industry);
					ps_insertData.setDate(12, (java.sql.Date) DataFormat.ConvertDate1(isdate));
					ps_insertData.setDate(13, (java.sql.Date) DataFormat.ConvertDate1(tedate));
					if ("".equals(extdate)) {
						ps_insertData.setDate(14, null); // 展期日期
					} else {
						ps_insertData.setDate(14, (java.sql.Date) DataFormat.ConvertDate1(extdate));// 展期日期
					}
					ps_insertData.setString(15, curcd);
					ps_insertData.setBigDecimal(16, new BigDecimal(lnbal).setScale(2, BigDecimal.ROUND_HALF_UP));
					ps_insertData.setString(17, irchgmod);
					ps_insertData.setBigDecimal(18, new BigDecimal(intrate).setScale(5, BigDecimal.ROUND_HALF_UP));
					ps_insertData.setString(19, guattype);
					ps_insertData.setString(20, String.valueOf(clrClass.get(clr_class.trim())));
					ps_insertData.setString(21, lnstat);
					ps_insertData.setBigDecimal(22, new BigDecimal(sxje).setScale(2, BigDecimal.ROUND_HALF_UP));
					ps_insertData.setString(23, sxbz);
					ps_insertData.execute();
				}
			}
			conn.commit();
		} catch (Exception e) {
			System.out.println("处理借据失败 : " + globalCino);
			conn.rollback();
			throw new Exception("插入个人余额信息出错:" + e.getMessage(), e);
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (rs_assureinfo != null)
				rs_assureinfo.close();
			if (ps_assureinfo != null)
				ps_assureinfo.close();
			if (rs_mortagageinfo != null)
				rs_mortagageinfo.close();
			if (ps_mortagageinfo != null)
				ps_mortagageinfo.close();
			if (rs_bankCodeInfo != null)
				rs_bankCodeInfo.close();
			if (ps_bankCodeInfo != null)
				ps_bankCodeInfo.close();
			if (rs_intrateInfo != null)
				rs_intrateInfo.close();
			if (ps_intrateInfo != null)
				ps_intrateInfo.close();
			if (rs_sxMessage != null)
				rs_sxMessage.close();
			if (ps_sxMessage != null)
				ps_sxMessage.close();
			if (rs_termchange != null)
				rs_termchange.close();
			if (ps_termchange != null)
				ps_termchange.close();
			DBUtil.close(conn, null, null);
		}
		logger.info("....................处理个人贷款余额信息(loan_bal_message)end.......................");
	}

	public void insertPLoanAccrual(String monthStartDate, String monthEndDate) throws Exception {

		Connection conn = DBUtil.getConnection();
		logger.info("....................处理个人贷款贷款发生额信息(loan_incurr_message)begin.......................");
		StringBuffer dbSql = new StringBuffer();
		dbSql.append(
				"select  clb.lnco,cui.idno,clb.brcd,clb.lncino,clb.lnid,cli.isdate,clb.opdt,clb.duedt,clc.tedate,clb.clsdt,clc.trsf_date,clb.curcd ,clb.lnamt,clb.irchgmod,clb.usdintrate,cli.guatcode,clb.lnstat,clc.clr_class,clc.ext_cnt,cli.lntype,cli.cocontractno,clb.clrflg,lcm.data_mode,get_sxje(cli.custcd,'2') as sxje,case when cli.usageno='5' then '01' when cli.usageno='6' then '02' else '03' end as sxbz ");// ,
		dbSql.append(
				"from  loaninfo cli,tla_lncino_base clb,loancino clc  left join loancino_mode lcm on clc.cino=lcm.cino,  customer_info cui  ");
		dbSql.append("where ");
		dbSql.append(
				"  clb.lnco = cli.contractno and clb.lncino=clc.cino and clb.custno=cui.custcd  and ( clb.lncino in ( select lncino from tla_lnrtnlog ctl  where ctl.rtndt between ? and ?  and  ctl.rtnamt<>0 )  or clb.opdt>= ? ) and clb.lnbal>=0 and clb.lnid not in ('101101','150101')  ");
		// and clb.acbrcd in ('90801','90802')
		// and clb.lnstat != 'V' and clb.lnstat != 'C' and clb.clrflg<>'1'
		dbSql.append("order by clb.lnco ");

		String assureInfo = "select seqno from assureinfo where contractno= ? ";

		String mortagageinfo = "select mort_type from mortagage  where contractno= ? ";

		String termchange = "select apptype,status  from term_chg_apply where contractno= ? ";
		// 金融机构代码
		String bankCodeInfo = "select jbcode from BRNO_JBCD_LINK where brno = ? ";
		// BEGIN----------------------------
		// // 实际还款金额+rtngmint
		String sumrtnamt_rtnint = "select  sum(rtnamt) rtnamt from tla_lnrtnlog where (lncino= ? or lncino= ?) and rtndt between ? and ? ";

		String intrateInfo = "select first 1 intrate  from intrate where intratecd='540'  and  term='199' and effect_date<= ?  order by effect_date  desc  ";

		String sxMessage = "select lldh, qsrq,llfdfs,fdll  from zzdkmxb mx   where substr(mx.dkzh,0,5) ||''|| substr(mx.dkzh,11,6)||''||mx.xh = ?   ";

		String insertData = "insert into LOAF values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		String insertDataF = "insert into LOAF values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		// ---------------------------------发生额取值SQL
		// END----------------------------

		// ----------------------PreparedStatement 发生额取值 BEGIN----------
		PreparedStatement ps_results = conn.prepareStatement(dbSql.toString());
		PreparedStatement ps_assureinfo = conn.prepareStatement(assureInfo);
		PreparedStatement ps_mortagageinfo = conn.prepareStatement(mortagageinfo);
		PreparedStatement ps_termchange = conn.prepareStatement(termchange);
		PreparedStatement ps_bankCodeInfo = conn.prepareStatement(bankCodeInfo);
		PreparedStatement ps_sumrtnamtRtnint = conn.prepareStatement(sumrtnamt_rtnint);

		PreparedStatement ps_intrateInfo = conn.prepareStatement(intrateInfo);
		PreparedStatement ps_sxMessage = conn.prepareStatement(sxMessage);
		PreparedStatement ps_insertData = conn.prepareStatement(insertData);
		PreparedStatement ps_insertDataF = conn.prepareStatement(insertDataF);
		// ----------------------PreparedStatement 信息取值 END----------

		// ----------------------ResultSet 信息取值 BEGIN----------
		ResultSet rs = null;
		ResultSet rs_sumrtnamtRtnint = null;
		ResultSet rs_assureinfo = null;
		ResultSet rs_mortagageinfo = null;
		ResultSet rs_termchange = null;
		ResultSet rs_bankCodeInfo = null;
		ResultSet rs_intrateInfo = null;
		ResultSet rs_sxMessage = null;

		// ----------------------ResultSet 发生额取值 END----------
		String globalCino = "";
		try {
			System.out.println("[" + dbSql.toString() + "]");
			// 取本月第一天
			// String monFirsint = DateUtil.dateToString(DateUtil
			// .getFirstDate(DataFormat.ConvertDate(monthEndDate)));
			// 取本月最后一天
			String monLast = monthEndDate;
			String MonthLastDay = monthEndDate;
			Date tsp1 = new Date();
			ps_results.setDate(1, (java.sql.Date) DataFormat.ConvertDate1(monthStartDate));
			ps_results.setDate(2, (java.sql.Date) DataFormat.ConvertDate1(monLast));
			// ps_results.setDate(3,
			// (java.sql.Date) DataFormat.ConvertDate(monFirsint));
			ps_results.setString(3, monthStartDate);
			rs = ps_results.executeQuery();
			Date tsp2 = new Date();
			System.out.println("sql run time1:" + (tsp2.getTime() - tsp1.getTime()));
			while (rs.next()) {
				String contractno = "";
				String brno = ""; // 金融机构编码
				String cust_type = "1"; // 客户类型
				String lncino = ""; // 借款人代码
				String cino = "";
				String indus_type = "1"; // 贷款主体行业类别 1
				String reg_place = ""; // 注册地 无需填写
				String invest_element = ""; // 投资经济成分 无需填写
				String compa_scale = ""; // 企业规模 无需填写
				String lnid = ""; // 产品类别
				// String industry = "100"; // 贷款实际投向
				String industry = "9800"; // 贷款实际投向（2018）
				String isdate = ""; // 贷款发放日期
				String opdt = ""; // 贷款放款日期
				String tedate = ""; // 贷款到期日期
				String trsfDate = ""; // 展期到期日期
				String curcd = ""; // 币种
				double accountAmount = 0.0; // 发生额
				double payAmount = 0.0; // 放款金额
				String irchgmod = ""; // 利率是否固定 irchgmod
				double intrate = 0.0; // 利率水平 usdintrate
				String guattype = ""; // 担保方式
				String lnstat = ""; // 贷款状态 正常、核销、剥离、转让
				String dataMode = "";// 贷款状态 （新表loancino_mode） 1.剥离 2.转让 3.重组调整
										// 4.转抵债资产
				String last_upd_date = MonthLastDay; // 数据日期
				String lntype = "";
				boolean ext_flag = false;
				String isClrFlg = ""; // 结清标志
				String cocontractno = "";
				contractno = rs.getString("lnco");
				isClrFlg = rs.getString("clrflg");
				lncino = rs.getString("idno");
				cino = rs.getString("lncino");
				globalCino = cino;
				cocontractno = rs.getString("cocontractno");
				lntype = rs.getString("lntype");
				isdate = rs.getString("isdate");
				opdt = rs.getString("opdt");
				tedate = rs.getString("duedt");
				curcd = rs.getString("curcd");
				irchgmod = rs.getString("irchgmod");
				payAmount = rs.getDouble("lnamt");
				String brcode = rs.getString("brcd");// 机构号
				double sxje=0.0;//授信金额
				//usageno（贷款用途代码：1.个人住房消费；2.个人住房按揭；3.购自用车；4.住房装修；5.个体工商户生产经营；6.小微企业主生产经营；7.其他生产经营；8.其他消费；A.国家助学贷款；B.一般商业性助学贷款；）
				String sxbz="";//属性标志  
				ps_bankCodeInfo.setString(1, brcode);
				rs_bankCodeInfo = ps_bankCodeInfo.executeQuery();
				if (rs_bankCodeInfo.next())
					brno = rs_bankCodeInfo.getString("jbcode");
				boolean issxFlg = false; // 是否是授信卡类 邯郸
				issxFlg = contractno.substring(0, 2).equals("gd") || !"666".equals(lntype);
				if ("0".equals(irchgmod.trim())) {
					irchgmod = "RF01"; // 固定利率方式
				} else {
					irchgmod = "RF02";
				}
				if (issxFlg) {
					intrate = rs.getDouble("usdintrate");
				} else {
					ps_sxMessage.setString(1, cino);
					rs_sxMessage = ps_sxMessage.executeQuery();
					if (rs_sxMessage.next()) {
						// String lldh = "";
						// String llfdfs = "";
						Double fdll = 0.0;
						// lldh = rs_sxMessage.getString("lldh");
						// Date qsrq = rs_sxMessage.getDate("qsrq");
						// Date qsrq =
						// DataFormat.ConvertDate1(rs_sxMessage.getString("qsrq"));
						// llfdfs = rs_sxMessage.getString("llfdfs");
						fdll = rs_sxMessage.getDouble("fdll");
						ps_intrateInfo.setString(1, rs_sxMessage.getString("qsrq"));
						rs_intrateInfo = ps_intrateInfo.executeQuery();
						if (rs_intrateInfo.next()) {
							if (fdll > 0) {
								intrate = rs_intrateInfo.getDouble("intrate");
								intrate = intrate * (1 + fdll / 100);
							} else {
								intrate = rs_intrateInfo.getDouble("intrate");
							}
						}
					} else {
						;
					}
				}

				guattype = rs.getString("guatcode");
				/*
				 * A 质押贷款 B 抵押贷款 B01 房地产抵押贷款 B99 其他抵押贷款 C 保证贷款 C01 联保贷款 C99
				 * 其他保证贷款 D 信用/免担保贷款 E 组合担保 Z 其他
				 */
				switch (guattype.charAt(0)) {
				case '1': {
					guattype = "A";
				}
					break;
				case '2': {
					ps_mortagageinfo.setString(1, cocontractno);
					rs_mortagageinfo = ps_mortagageinfo.executeQuery();
					if (rs_mortagageinfo.next()) {
						if ("1".equals(rs_mortagageinfo.getString("mort_type").trim())
								|| "2".equals(rs_mortagageinfo.getString("mort_type").trim())
								|| "3".equals(rs_mortagageinfo.getString("mort_type").trim())) {
							guattype = "B01"; // 房地产抵押贷款
						} else {
							guattype = "B99"; // 其它抵押贷款
						}
					} else {
						guattype = "B";
					}
				}
					break;
				case '3': {
					ps_assureinfo.setString(1, cocontractno);
					rs_assureinfo = ps_assureinfo.executeQuery();
					if (rs_assureinfo.next()) {
						if (rs_assureinfo.getInt("seqno") > 1) {
							guattype = "C01"; // 联保贷款
						} else {
							guattype = "C99";
						}

					} else {
						guattype = "C";
					}
				}
					break;
				case '4': {
					guattype = "D";
				}
					break;
				case '5':
				case '6': {
					guattype = "E";
				}
					break;
				default: {
					guattype = "Z";
				}
					break;
				}

				ps_termchange.setString(1, contractno);
				rs_termchange = ps_termchange.executeQuery();
				while (rs_termchange.next()) {
					if (("1".equals(rs_termchange.getString("status")))
							&& ("44".equals(rs_termchange.getString("apptype")))) {
						ext_flag = true;
						break;
					}
				}

				boolean offFlg = false; // 是否核销

				lnstat = rs.getString("lnstat");
				dataMode = rs.getString("data_mode");
				if (zftxdk.indexOf(lntype) != -1 // 贷款类型 区分下岗失业贷款
						&& DataFormat.ConvertDate1(MonthLastDay)
								.before(DataFormat.ConvertDate1(rs.getString("duedt")))) {// 政府贴息贷款，而且没有到期的
					lnstat = "0";
				}

				if ("0".equals(lnstat.trim()) || "C".equals(lnstat.trim())) {
					lnstat = "FS01"; // 正常
				} else if ("1".equals(lnstat.trim()) || "2".equals(lnstat.trim())) {
					lnstat = "FS01";
				} else if ("E".equals(lnstat.trim())) {
					lnstat = "FS04";// 核销
					offFlg = true;
				} else if ("1".equals(dataMode.trim())) {
					lnstat = "FS05";// 剥离
				} else if ("2".equals(dataMode.trim())) {
					lnstat = "FS06";// 转让
				} else if ("3".equals(dataMode.trim())) {
					lnstat = "FS07";// 重组
				} else if ("4".equals(dataMode.trim())) {
					lnstat = "FS08";// 以物抵债
				}

				if (ext_flag) {
					lnstat = "FS02";// 展期
				}

				if ("1".equals(isClrFlg) || offFlg) { // 结清,核销
					if (issxFlg) {
						trsfDate = rs.getString("clsdt");
					} else {
						trsfDate = rs.getString("trsf_date");
					}
					// clrFlg = "0";
				}
				ps_sumrtnamtRtnint.setString(1, cino.trim());
				ps_sumrtnamtRtnint.setString(2, cino.trim());
				ps_sumrtnamtRtnint.setDate(3, (java.sql.Date) DataFormat.ConvertDate1(monthStartDate));
				ps_sumrtnamtRtnint.setDate(4, (java.sql.Date) DataFormat.ConvertDate1(monLast));
				rs_sumrtnamtRtnint = ps_sumrtnamtRtnint.executeQuery();
				if (rs_sumrtnamtRtnint.next()) {
					accountAmount = rs_sumrtnamtRtnint.getDouble("rtnamt");
				} else {
					// 台帐表中无记录,读取核算期供表
				}
				rs_sumrtnamtRtnint.close();

				// 业务种类细分
				lnid = getTypedetail(lntype, conn);
				if (DataFormat.isEmpty(lnid)) {
					lnid = "99";
				}
				lnid = getTypedetail(lntype, conn); // 与征信接口统一的贷款
				if (DataFormat.isEmpty(lnid)) {
					lnid = "99";
				}
				if (lntype.equalsIgnoreCase("018") || lntype.equalsIgnoreCase("035")) {
					lnid = "41"; // 与征信接口不统一的两种贷款
				}
				// lnid = String.valueOf(lntypeMap.get(lnid.trim()));// 501
				lnid = lntypeMap.get(lnid.trim());// 501
				// add by weigang.lv 为空的默认给消费类型
				if (DataFormat.isEmpty(lnid)) {
					lnid = "F0219";
				}
				if (lntype.equals("001") || lntype.equals("050")) {
					lnid = "F99";
				}
				sxje=rs.getDouble("sxje");//授信金额
				sxbz=rs.getString("sxbz");//属性标志				
				// 数据入库
				if (!DataFormat.isEmpty(contractno) && accountAmount != 0) {

					ps_insertData.setDate(1, (java.sql.Date) DataFormat.ConvertDate1(last_upd_date));
					ps_insertData.setString(2,
							brno == null || brno.trim().length() < 1 ? bankReport_bankCode : brno.trim());
					ps_insertData.setString(3, cust_type);
					ps_insertData.setString(4, lncino);
					ps_insertData.setString(5, indus_type);
					ps_insertData.setString(6, reg_place);
					ps_insertData.setString(7, invest_element);
					ps_insertData.setString(8, compa_scale);
					ps_insertData.setString(9, cino);
					ps_insertData.setString(10, lnid);
					ps_insertData.setString(11, industry);
					ps_insertData.setDate(12, (java.sql.Date) DataFormat.ConvertDate1(isdate));
					ps_insertData.setDate(13, (java.sql.Date) DataFormat.ConvertDate1(tedate));
					if ("".equals(trsfDate)) {
						ps_insertData.setDate(14, null); // 展期日期
					} else {
						ps_insertData.setDate(14, (java.sql.Date) DataFormat.ConvertDate1(trsfDate));// 展期日期
					}
					ps_insertData.setString(15, curcd);
					ps_insertData.setBigDecimal(16,
							new BigDecimal(accountAmount).setScale(2, BigDecimal.ROUND_HALF_UP));
					ps_insertData.setString(17, irchgmod);
					ps_insertData.setBigDecimal(18, new BigDecimal(intrate).setScale(5, BigDecimal.ROUND_HALF_UP));
					ps_insertData.setString(19, guattype);
					ps_insertData.setString(20, lnstat);
					ps_insertData.setString(21, "0");// 收回贷款
					ps_insertData.setBigDecimal(22, new BigDecimal(sxje).setScale(2, BigDecimal.ROUND_HALF_UP));
					ps_insertData.setString(23, sxbz);
					ps_insertData.execute();
				}

				// 判断是否本月放的款，本月放的则会多一条发生额，放款信息
				if (!DataFormat.isEmpty(contractno)
						&& DateUtil.stringToDate2(opdt).compareTo(DateUtil.stringToDate2(monthStartDate)) >= 0) // 判断是否本月放的款
				{
					ps_insertDataF.setDate(1, (java.sql.Date) DataFormat.ConvertDate1(last_upd_date));
					ps_insertDataF.setString(2,
							brno == null || brno.trim().length() < 1 ? bankReport_bankCode : brno.trim());
					ps_insertDataF.setString(3, cust_type);
					ps_insertDataF.setString(4, lncino);
					ps_insertDataF.setString(5, indus_type);
					ps_insertDataF.setString(6, reg_place);
					ps_insertDataF.setString(7, invest_element);
					ps_insertDataF.setString(8, compa_scale);
					ps_insertDataF.setString(9, cino);
					ps_insertDataF.setString(10, lnid);
					ps_insertDataF.setString(11, industry);
					ps_insertDataF.setDate(12, (java.sql.Date) DataFormat.ConvertDate1(isdate));
					ps_insertDataF.setDate(13, (java.sql.Date) DataFormat.ConvertDate1(tedate));
					if ("".equals(trsfDate)) {
						ps_insertDataF.setDate(14, null); // 展期日期
					} else {
						ps_insertDataF.setDate(14, (java.sql.Date) DataFormat.ConvertDate1(trsfDate));// 展期日期
					}
					ps_insertDataF.setString(15, curcd);
					ps_insertDataF.setBigDecimal(16, new BigDecimal(payAmount).setScale(2, BigDecimal.ROUND_HALF_UP));
					ps_insertDataF.setString(17, irchgmod);
					ps_insertDataF.setBigDecimal(18, new BigDecimal(intrate).setScale(5, BigDecimal.ROUND_HALF_UP));
					ps_insertDataF.setString(19, guattype);
					ps_insertDataF.setString(20, lnstat);
					ps_insertDataF.setString(21, "1");// 发放贷款
					ps_insertDataF.setBigDecimal(22, new BigDecimal(sxje).setScale(2, BigDecimal.ROUND_HALF_UP));
					ps_insertDataF.setString(23, sxbz);
					ps_insertDataF.execute();
				}
			}
			conn.commit();
		} catch (Exception e) {
			System.out.println("处理借据失败 : " + globalCino);
			conn.rollback();
			throw new Exception("插入个人发生额信息出错:" + e.getMessage(), e);
		} finally {
			if (rs != null)
				rs.close();
			if (ps_results != null)
				ps_results.close();
			if (rs_sumrtnamtRtnint != null)
				rs_sumrtnamtRtnint.close();
			if (rs_assureinfo != null)
				rs_assureinfo.close();
			if (rs_mortagageinfo != null)
				rs_mortagageinfo.close();
			if (rs_termchange != null)
				rs_termchange.close();
			if (rs_bankCodeInfo != null)
				rs_bankCodeInfo.close();
			if (ps_sumrtnamtRtnint != null)
				ps_sumrtnamtRtnint.close();
			if (ps_termchange != null)
				ps_termchange.close();
			if (ps_bankCodeInfo != null)
				ps_bankCodeInfo.close();
			if (ps_intrateInfo != null)
				ps_intrateInfo.close();
			if (ps_sxMessage != null)
				ps_sxMessage.close();
			DBUtil.close(conn, null, null);
		}
		logger.info("....................处理个人贷款发生额信息(loan_incurr_message)end.......................");
	}

	public void insertCLoanBalance(String monthEndDate) throws Exception {

		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		logger.info("....................处理对公贷款余额信息begin.......................");
		try {
			// 日期为yyyymmdd varchar2
			StringBuffer query = new StringBuffer();
			query.append(
					"insert into LOAB(select to_date(b.bbrq,'yyyymmdd'),case when li.jbcode is not null then li.jbcode else '"
							+ bankReport_bankCode + "' end, ");
			query.append("case when l.cuskind='1' then '0' when l.cuskind='2' then '1' end, ");
			// query.append("substr(b.qydm,0,8)||substr(b.qydm,10,10),upper(b.hy1),case
			// when length(b.zjhm) = 18 then substr(b.zjhm,3,6) else
			// substr(b.zjhm,1,6) end, ");
			query.append(
					"b.zjhm,upper(b.hy1),case when length(b.zjhm) = 18 then substr(b.zjhm,3,6) else substr(b.zjhm,1,6) end, ");
			query.append(
					"case when b.org_level2 is not null then b.org_level2 when b.qysyzxz='1' then 'A01' when b.qysyzxz='2' then 'A01' when b.qysyzxz='3' then 'A02' when b.qysyzxz='4' then 'A02' ");
			query.append(
					"when b.qysyzxz='5' then 'A02' when b.qysyzxz='6' then 'A02' when b.qysyzxz='7' then 'B01' when b.qysyzxz='8' then 'B01' ");
			query.append(
					"when b.qysyzxz='9' then 'B03' when b.qysyzxz='10' then 'B03' when b.qysyzxz='11' then 'B03' when b.qysyzxz='12' then 'B02' ");
			query.append(
					"when b.qysyzxz='13' then 'B02' when b.qysyzxz='14' then 'A01' when b.qysyzxz='15' then 'A01' else  'B01' end, ");
			query.append(
					"case when b.qygm='0' then 'CS01' when b.qygm='1' then 'CS01' when b.qygm='2' then 'CS02' when b.qygm='3' then 'CS03' when b.qygm='5' then 'CS04' else 'CS05' end, ");
			query.append(
					"trim(d.duebillno), case when b.dklx＝'1' then 'F022' when b.dklx＝'2' then 'F023' when b.dklb＝'37' then 'F99' else 'F05' end, ");
			// query.append("upper(substr(nvl(b.dktx2,b.hy2),1,3)),
			// to_date(b.dksq,'yyyymmdd'), to_date(b.dkzq,'yyyymmdd'),
			// to_date(d.extensiondate,'yyyymmdd'), 'CNY',
			// ''||round(d.dbrestsum,2)||'', case when b.fdb is null or b.fdb＝0
			// then 'RF01' else 'RF02' end, ");
			query.append(
					"substr(t.columnvalue,2,4), to_date(d.duebilldate,'yyyymmdd'), to_date(d.dbmaturedate,'yyyymmdd'), to_date(d.extensiondate,'yyyymmdd'), 'CNY', ''||round(d.dbrestsum,2)||'', case  when b.fdb is null or b.fdb＝0 then 'RF01' else 'RF02' end, ");
			query.append(
					"''||round(d.duebillrate,5)||'', case when s.assettype is not null then s.assettype when b.dbfs='23' then 'A' when b.dbfs='100' then 'D' when b.dbfs='210' then 'C99' else 'Z' end, ");
			query.append(
					"case when b.dkfl4='11' then 'FQ01' when b.dkfl4='21' then 'FQ02' when b.dkfl4='30' then 'FQ03' when b.dkfl4='40' then 'FQ04' else 'FQ05' end, ");
			query.append("case when b.zqbz='1' then 'FS02' when b.dkfl3 in('2','3','4') then 'FS03' else 'FS01' end, get_sxje(l.cusid,'1'),'' ");
			query.append(
					"from loan l left join loaninvest t on l.appid=t.appid and t.serinum='5',loanduebill d left join (select appid,assettype,row_number()over(partition by appid order by assettype) as num from(select distinct s.appid,case when s.assettype in('220101','220102','220103','220104','2206','2205') then 'B01' else 'B99' end as assettype from security s where s.securitykind='22')) s on s.appid=d.appid and s.num=1,b101 b left join BRNO_JBCD_LINK li on b.bmhh = li.bmhh,ind_levelcatalog ind,dkhzwj dk ");
			query.append(
					"where l.ContractNo=b.dkht and l.appid=d.appid and b.hy1=ind.ind_levelcode and d.dueBillNo=dk.jjh and dk.dkxz not in('8','Q','W') and l.loantype='1'  and l.appopkind != 37 and ");
			query.append("b.dkye !='0.00'  and b.bbrq = ? ) ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, monthEndDate);
			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			throw new Exception("处理对公贷款余额信息出错:" + e.getMessage(), e);
		} finally {
			DBUtil.close(conn, stmt, null);
		}
		logger.info("....................处理对公贷款余额信息end.......................");
	}

	public void insertCLoanAccrual(String monthStartDate, String monthEndDate) throws Exception {

		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		logger.info("....................处理对公贷款发生额信息begin.......................");
		try {
			// 日期为yyyymmdd varchar2
			StringBuffer query = new StringBuffer();
			query.append(
					"insert into LOAF(select to_date(b.bbrq,'yyyymmdd'),case when li.jbcode is not null then li.jbcode else '"
							+ bankReport_bankCode + "' end, ");
			query.append("case when l.cuskind='1' then '0' when l.cuskind='2' then '1' end, ");
			// query.append("substr(b.qydm,0,8)||substr(b.qydm,10,10),upper(b.hy1),case
			// when length(b.zjhm) = 18 then substr(b.zjhm,3,6) else
			// substr(b.zjhm,1,6) end, ");
			query.append(
					"b.zjhm,upper(b.hy1),case when length(b.zjhm) = 18 then substr(b.zjhm,3,6) else substr(b.zjhm,1,6) end, ");
			query.append(
					"case when b.org_level2 is not null then b.org_level2 when b.qysyzxz='1' then 'A01' when b.qysyzxz='2' then 'A01' when b.qysyzxz='3' then 'A02' when b.qysyzxz='4' then 'A02' ");
			query.append(
					"when b.qysyzxz='5' then 'A02' when b.qysyzxz='6' then 'A02' when b.qysyzxz='7' then 'B01' when b.qysyzxz='8' then 'B01' ");
			query.append(
					"when b.qysyzxz='9' then 'B03' when b.qysyzxz='10' then 'B03' when b.qysyzxz='11' then 'B03' when b.qysyzxz='12' then 'B02' ");
			query.append(
					"when b.qysyzxz='13' then 'B02' when b.qysyzxz='14' then 'A01' when b.qysyzxz='15' then 'A01' else  'B01' end, ");
			query.append(
					"case when b.qygm='0' then 'CS01' when b.qygm='1' then 'CS01' when b.qygm='2' then 'CS02' when b.qygm='3' then 'CS03' when b.qygm='5' then 'CS04' else 'CS04' end, ");
			// query.append("trim(d.duebillno), case when dklx＝'1' then 'F022'
			// when dklx＝'2' then 'F023' when b.dklb='1' then 'F022' when
			// b.dklb＝'37' then 'F99' else 'F05' end,
			// upper(substr(nvl(b.dktx2,b.hy2),1,3)),
			// to_date(b.dksq,'yyyymmdd'), to_date(b.dkzq,'yyyymmdd'), ");
			query.append(
					"trim(d.duebillno), case when dklx＝'1' then 'F022' when dklx＝'2' then 'F023' when b.dklb='1' then 'F022' when b.dklb＝'37' then 'F99' else 'F05' end, substr(t.columnvalue,2,4), to_date(d.duebilldate,'yyyymmdd'), to_date(d.dbmaturedate,'yyyymmdd'), ");
			// query.append("case when acc.opbriefcode='022' then
			// to_date(acc.lastupdatedate,'yyyymmdd') when acc.opbriefcode='322'
			// then to_date(acc.lastupdatedate,'yyyymmdd') else
			// to_date(d.realmaturedate,'yyyymmdd') end, ");
			// 贷款实际终止日期
			query.append("case  when d.DBRestSum=0 then to_date(d.realmaturedate,'yyyymmdd') end, ");
			query.append(
					"'CNY', ''||round(acc.occursum,2)||'', case when dk.jxbz='1' then  'RF01' else 'RF02' end, ''||round(d.duebillrate,5)||'', ");
			query.append(
					"case when s.assettype is not null then s.assettype when b.dbfs='23' then 'A' when b.dbfs='100' then 'D' when b.dbfs='210' then 'C99' else 'Z' end, 'FS01', ");
			query.append("case when acc.creditdebitflag='1' then '1' else '0' end , get_sxje(l.cusid,'1'),'' ");
			query.append(
					"from loan l left join loaninvest t on l.appid=t.appid and t.serinum='5',loanduebill d left join (select appid,assettype,row_number()over(partition by appid order by assettype) as num from(select distinct s.appid,case when s.assettype in('220101','220102','220103','220104','2206','2205') then 'B01' else 'B99' end as assettype from security s where s.securitykind='22')) s on s.appid=d.appid and s.num=1,b101 b left join BRNO_JBCD_LINK li on b.bmhh = li.bmhh,accountentry acc,dkhzwj dk ");
			query.append(
					"where l.ContractNo=b.dkht and l.appid=d.appid and l.appid=acc.appid and d.dueBillNo=dk.jjh and dk.dkxz not in('8','Q','W') and l.loantype='1'  and l.appopkind != 37 and ");
			query.append(
					"acc.occurdate between ? and ? and b.bbrq = ? and acc.duebillno = d.dueBillNo and acc.opflag='1' )");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, monthStartDate);
			stmt.setString(2, monthEndDate);
			stmt.setString(3, monthEndDate);
			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			throw new Exception("处理对公贷款发生额信息出错:" + e.getMessage(), e);
		} finally {
			DBUtil.close(conn, stmt, null);
		}
		logger.info("....................处理对公贷款发生额信息end.......................");
	}

	public void deleteJBBatchData(String monthEndDate) throws Exception {

		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		logger.info("....................删除已跑批数据begin.......................");
		try {
			String depositBalanceSql = "delete from DEPB where SJRQ= to_date('" + monthEndDate + "','yyyymmdd') ";
			String loanBalanceSql = "delete from LOAB where SJRQ = to_date('" + monthEndDate + "','yyyymmdd') ";
			String loanAccrualSql = "delete from LOAF where SJRQ = to_date('" + monthEndDate + "','yyyymmdd') ";

			stmt.execute(depositBalanceSql);
			stmt.execute(loanBalanceSql);
			stmt.execute(loanAccrualSql);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			throw new Exception("insert Column error!===" + e.getMessage(), e);
		} finally {
			DBUtil.close(conn, stmt, null);
		}
		logger.info("....................删除已跑批数据end.......................");

	}

	// 业务种类细分转换
	private String getTypedetail(String lnid, Connection conn) throws Exception {
		if (DataFormat.isEmpty(lnid)) {
			return lnid;
		}
		StringBuffer sqlstr = new StringBuffer();
		sqlstr.append("select misc from lntype_info ");
		sqlstr.append("where lntype = '");
		sqlstr.append(lnid);
		sqlstr.append("'");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sqlstr.toString());
		String rtnstr = "";
		while (rs.next()) {
			rtnstr = rs.getString("misc");
		}
		DBUtil.close(null, stmt, rs);
		return rtnstr;
	}

	/*
	 * @title :根据传入的参数转换为相应的个人余额信息标准
	 * 
	 * @param 数据库连接,内部数据字典值,数据字典映射ID
	 * 
	 * @return 个人余额类型
	 */
	private Map<String, String> getDataDicMap(int data_dic_map_id) {
		String outcode = "";
		String incode = "";
		Map<String, String> map = new HashMap<String, String>();
		String sql = "select incode , outcode from data_dic_map where map_type='" + data_dic_map_id + "'";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				incode = DataFormat.trim(rs.getString(1));
				outcode = DataFormat.trim(rs.getString(2));
				map.put(incode, outcode);
			}

		} catch (SQLException e) {
			logger.info("获取data_dic_map信息出错:" + e.getMessage());
		} finally {
			DBUtil.close(null, stmt, rs);
		}
		return map;
	}
}
