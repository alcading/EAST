package east.special.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import east.utils.tools.DBUtil;
import east.vo.DGHQCKFHZMXJLVO;



public class UpdateAndQuery {
	/**
	 * DGHQCKFHZMXJL
	 * 查对方账号
	 * @return
	 */
		public void updateDfzh() {
	        Connection conn = DBUtil.getConnection();
	        StringBuffer querySql = new StringBuffer();
	        StringBuffer updateSql = new StringBuffer();
	        querySql.append("select distinct zhdh ,cpzxh ,cpznxh ,yefx from cpwj  ");
	        updateSql.append("update  cpwj set flbz=? where CPZXH=? and yefx=? and zhdh<>?");
	        PreparedStatement pstmtQ = null;
	        PreparedStatement pstmtU = null;
	        ResultSet rs = null;
	        try {
	            pstmtQ = conn.prepareStatement(querySql.toString());
	            pstmtU=conn.prepareStatement(updateSql.toString());
	            rs = pstmtQ.executeQuery();
	            List<DGHQCKFHZMXJLVO> VoList0 = new ArrayList<DGHQCKFHZMXJLVO>();
	            List<DGHQCKFHZMXJLVO> VoList1 = new ArrayList<DGHQCKFHZMXJLVO>();
	            //借方
	            DGHQCKFHZMXJLVO v0 =null;
	            int count = 0;
	            //贷方
	            DGHQCKFHZMXJLVO v1 =null;
	            v0= new DGHQCKFHZMXJLVO();
	            v1=new DGHQCKFHZMXJLVO();
	            while (rs.next()) {
	                if("0".equals(rs.getString("YEFX"))){
	                    v0.setDFZH(rs.getString("ZHDH"));
	                    v0.setZJYLSH(rs.getString("CPZXH"));
	                    v0.setBCXH(rs.getString("CPZNXH"));
	                    v0.setJDBZ(rs.getString("YEFX"));
	                    pstmtU.setString(1, v0.getDFZH());
	                    pstmtU.setString(2, v0.getZJYLSH());
	                    pstmtU.setString(3, "1");
	                    pstmtU.setString(4, v0.getDFZH());
	                    pstmtU.addBatch();
	                } else{
	                    v1.setDFZH(rs.getString("ZHDH"));
	                    v1.setZJYLSH(rs.getString("CPZXH"));
	                    v1.setBCXH(rs.getString("CPZNXH"));
	                    v1.setJDBZ(rs.getString("YEFX"));
	                    pstmtU.setString(1, v1.getDFZH());
	                    pstmtU.setString(2, v1.getZJYLSH());
	                    pstmtU.setString(3, "0");
	                    pstmtU.setString(4, v1.getDFZH());
	                    pstmtU.addBatch();
	                }
	                count ++;
	                if (count % 1000 == 0) {
	                    pstmtU.executeBatch();
	                    pstmtU.clearBatch();
	                    System.out.println(count);
	                }
	            }
	            pstmtU.executeBatch();
	            pstmtU.clearBatch();
	            System.out.println(count);
	            rs.close();
	            conn. commit();
	            pstmtQ.close();
	            pstmtU.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.close(conn, pstmtQ, rs);
	            DBUtil.close(conn, pstmtU, rs);
	        }
	    }
		//用于第一次报送
		public void updateDfzh1() {
	        Connection conn = DBUtil.getConnection();
	        StringBuffer querySql = new StringBuffer();
	        StringBuffer updateSql = new StringBuffer();
	        querySql.append("select distinct zhdh ,cpzxh ,cpznxh ,yefx from cpwj  where kmdh in (select k.kmdh from kmdhb k where k.kmcc='0') and BCZBZ='0' and cbbz='0'");
	        updateSql.append("update  cpwj set flbz=? where CPZXH=? and yefx=? and zhdh<>?");
	        PreparedStatement pstmtQ = null;
	        PreparedStatement pstmtU = null;
	        ResultSet rs = null;
	        try {
	            pstmtQ = conn.prepareStatement(querySql.toString());
	            pstmtU=conn.prepareStatement(updateSql.toString());
	            rs = pstmtQ.executeQuery();
	            List<DGHQCKFHZMXJLVO> VoList0 = new ArrayList<DGHQCKFHZMXJLVO>();
	            List<DGHQCKFHZMXJLVO> VoList1 = new ArrayList<DGHQCKFHZMXJLVO>();
	            //借方
	            DGHQCKFHZMXJLVO v0 =null;
	            int count = 0;
	            //贷方
	            DGHQCKFHZMXJLVO v1 =null;
	            v0= new DGHQCKFHZMXJLVO();
	            v1=new DGHQCKFHZMXJLVO();
	            while (rs.next()) {
	                if("0".equals(rs.getString("YEFX"))){
	                    v0.setDFZH(rs.getString("ZHDH"));
	                    v0.setZJYLSH(rs.getString("CPZXH"));
	                    v0.setBCXH(rs.getString("CPZNXH"));
	                    v0.setJDBZ(rs.getString("YEFX"));
	                    pstmtU.setString(1, v0.getDFZH());
	                    pstmtU.setString(2, v0.getZJYLSH());
	                    pstmtU.setString(3, "1");
	                    pstmtU.setString(4, v0.getDFZH());
	                    pstmtU.addBatch();
	                } else{
	                    v1.setDFZH(rs.getString("ZHDH"));
	                    v1.setZJYLSH(rs.getString("CPZXH"));
	                    v1.setBCXH(rs.getString("CPZNXH"));
	                    v1.setJDBZ(rs.getString("YEFX"));
	                    pstmtU.setString(1, v1.getDFZH());
	                    pstmtU.setString(2, v1.getZJYLSH());
	                    pstmtU.setString(3, "0");
	                    pstmtU.setString(4, v1.getDFZH());
	                    pstmtU.addBatch();
	                }
	                count ++;
	                if (count % 1000 == 0) {
	                    pstmtU.executeBatch();
	                    pstmtU.clearBatch();
	                    System.out.println(count);
	                }
	            }
	            pstmtU.executeBatch();
	            pstmtU.clearBatch();
	            System.out.println(count);
	            rs.close();
	            conn. commit();
	            pstmtQ.close();
	            pstmtU.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.close(conn, pstmtQ, rs);
	            DBUtil.close(conn, pstmtU, rs);
	        }
	    }
		/**
		 * 用于修改274 定活两便类型贷款的利率
		 */
		public void updateDqzwjLldh() {
	        Connection conn = DBUtil.getConnection();
	        StringBuffer querySql = new StringBuffer();
	        StringBuffer updateSql = new StringBuffer();
	        querySql.append("select distinct zhdh ,jyrq,lldh from dqzwj  where  ywdh='274'  and jlzt<>'0'");
	        updateSql.append("update  dqzwj set lldh=? where zhdh=?");
	        PreparedStatement pstmtQ = null;
	        PreparedStatement pstmtU = null;
	        ResultSet rs = null;
	        try {
	            pstmtQ = conn.prepareStatement(querySql.toString());
	            pstmtU=conn.prepareStatement(updateSql.toString());
	            rs = pstmtQ.executeQuery();         
	            String zhdh=null;
	            String jyrq = null; 
	            String lldh=null;
	            String newlldh=null;
	            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
	            String date=df.format(new Date());
	            int qx=0;
	            int count = 0;
	            //人民币定活两便储蓄，由银行发给存单，不确定存期，随时可取，五十元起存。
	            //利息按支取日挂牌的同档次存期整存整取定期利率打六折计息，三个月以下的按支取日挂牌的活期利率计息，一年存期以上的按一年整存整取定期利率打六折计息。业务种类代号为274。
	            while (rs.next()) {
	            	zhdh=rs.getString("ZHDH");
					lldh=rs.getString("LLDH");
					jyrq = df.format(rs.getDate("JYRQ"));
					qx=(Integer.parseInt(date.substring(0, 4))-Integer.parseInt(jyrq.substring(0, 4)))*12+(Integer.parseInt(date.substring(4, 6))-Integer.parseInt(jyrq.substring(4, 6)));
					if(qx>3&&qx<6){
						lldh="01102M03";
					}else if(qx>6&&qx<12){
						lldh="01102M06";
					}else if(qx>12&&qx<24){
						lldh="01102Y01";
					}else if(qx>24&&qx<36){
						lldh="01102Y02";
					}else if(qx>36&&qx<60){
						lldh="01102Y03";
					}else if(qx>60){
						lldh="01102Y05";
					}else{
						lldh="01101000";
					}
					pstmtU.setString(1, lldh);
					pstmtU.setString(2, zhdh);
					pstmtU.addBatch();
					count++;
					if (count % 1000 == 0) {
						pstmtU.executeBatch();
						pstmtU.clearBatch();
						System.out.println(count);
					}
	            }
	            pstmtU.executeBatch();
	            pstmtU.clearBatch();
	            System.out.println(count);
	            rs.close();
	            conn. commit();
	            pstmtQ.close();
	            pstmtU.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
			} finally {
	            DBUtil.close(conn, pstmtQ, rs);
	            DBUtil.close(conn, pstmtU, rs);
	        }
	    }
		//用于第一次报送
		public void updateDfzh2() {
	        Connection conn = DBUtil.getConnection();
	        StringBuffer updateSql = new StringBuffer();
	        updateSql.append("update  cpwj set flbz=zhdh where kmdh  not in (select k.kmdh from kmdhb k where k.kmcc='0') and BCZBZ='0' and cbbz='0'");
	        PreparedStatement pstmtU = null;
	        ResultSet rs = null;
	        try {
	            pstmtU=conn.prepareStatement(updateSql.toString());
	            pstmtU.execute();
	            pstmtU.clearBatch();
	            rs.close();
	            conn. commit();
	            pstmtU.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.close(conn, pstmtU, rs);
	        }
	    }
		public void updateGh() {
			Connection conn = DBUtil.getConnection();
			StringBuffer querySql = new StringBuffer();
			StringBuffer updateSql = new StringBuffer();
			try {
				conn.prepareStatement("update gyb set zddh=gydh").execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			querySql.append("select distinct gh ,gyh ,xm ,nbjgh from ygb  ");
			updateSql.append("update  gyb set zddh=? where gydh=?  ");
			PreparedStatement pstmtQ = null;
			PreparedStatement pstmtU = null;
			ResultSet rs = null;
			try {
				pstmtQ = conn.prepareStatement(querySql.toString());
				rs = pstmtQ.executeQuery();
				Map<String, String> map = new HashMap<String, String>();
				int count = 1;
				pstmtU=conn.prepareStatement(updateSql.toString());
				while (rs.next()) {
					pstmtU.setString(1, rs.getString("GH")); // 根据键来取对应的值
					pstmtU.setString(2, rs.getString("GYH"));
					pstmtU.addBatch();
					if (count % 500 == 0) {
						pstmtU.executeBatch();
					}	
				}
				if (count % 500 != 0) {
					pstmtU.executeBatch();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, pstmtQ, rs);
				DBUtil.close(conn, pstmtU, rs);
			}

		}
		
		public void shieldData(){
			Connection conn = DBUtil.getConnection();
			StringBuffer queryFlg = new StringBuffer();
			StringBuffer deleteSql =null;// new StringBuffer();
			queryFlg.append("select  distinct flg from ex_data  ");	
			PreparedStatement pstmtFlg = null;
			ResultSet rs = null;
			try {
				pstmtFlg = conn.prepareStatement(queryFlg.toString());
				rs = pstmtFlg.executeQuery();
				char flg;
		
				//公贷账号0,公贷客户号1,个人客户账号2,个人客户号3,内部账号4,对公贷款5,个人贷款6
				while(rs.next()){
					flg=rs.getString("FLG").charAt(0);

					switch (flg) {
					case '0'://公贷账号
						conn.prepareStatement("delete hqdgzwj  where zhdh in (select contents from ex_data where flg='0')").executeUpdate();
						conn.prepareStatement("delete cpwj  where zhdh in (select contents from ex_data where flg='0')").executeUpdate();
						break;
					case '1'://公贷客户号
						conn.prepareStatement("delete dgkhxxwj  where khdh in (select contents from ex_data where flg='1')").executeUpdate();
						conn.prepareStatement("delete customer  where trim(externalcusid) in (select contents from ex_data where flg='1')").executeUpdate();				
						break;
					case '2'://个人客户账号
						conn.prepareStatement("delete dshqzwj where  zhdh in (select contents from ex_data where flg='2')").executeUpdate();
						conn.prepareStatement("delete hqdgzwj where  zhdh in (select contents from ex_data where flg='2')").executeUpdate();
						break;
					case '3'://个人客户号
						conn.prepareStatement("delete coustomer_info  where custcd in (select contents from ex_data where flg='3')").executeUpdate();
						conn.prepareStatement("delete customer_relation_info  where custno in (select contents from ex_data where flg='3') or custcd in (select contents from ex_data where flg='2')").executeUpdate();						
						conn.prepareStatement("delete assureinfo where custcd in (select contents from ex_data where flg='3')").executeUpdate();
						conn.prepareStatement("delete dkhzwj where zhdh in (select contents from ex_data where flg='3')").executeUpdate();
						conn.prepareStatement("delete dskhb where dk.zjzl||dk.zjhm  in (select contents from ex_data where flg='3')").executeUpdate();
						break;
					case '4'://内部账号
						conn.prepareStatement("delete   nbzzwj where zhdh in (select contents from ex_data where flg='4')").executeUpdate();
						conn.prepareStatement("delete   cpwj where zhdh in (select contents from ex_data where flg='4')").executeUpdate();
						break;
					case '5'://对公贷款
						conn.prepareStatement("delete   dkhzwj where htbh in (select contents from ex_data where flg='5')").executeUpdate();
						conn.prepareStatement("delete   acceptancedraft where appid in (select contents from ex_data where flg='5')").executeUpdate();
						conn.prepareStatement("delete   loan where contractno in (select contents from ex_data where flg='5')").executeUpdate();
						break;
					case '6'://个人贷款
						conn.prepareStatement("delete   dkhzwj where htbh in (select contents from ex_data where flg='6')").executeUpdate();
						conn.prepareStatement("delete   loan where contractno in (select contents from ex_data where flg='6')").executeUpdate();				
						break;
						
					default:
						break;
					}
					/**
					 * 个人账号需要删除
					 *cpwj; dshqzwj  ;dqzwj; dskhxxwj ; hqdgzwj ; dkhzwj 
					 * customer_relation_info ; tla_lncino_base ;assureinfo;monitordtl;lnhtr;customer_info;credit_info,dskhb
				    *   dgkhxxwj   ;acceptancedraft;loan;customer; security ;dbextension;loansort2list; LoanCheck  ;dgkhxxwj  
					 */		
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.close(conn, pstmtFlg, rs);
			}


		}

		
}
