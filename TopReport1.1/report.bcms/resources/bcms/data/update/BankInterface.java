package resources.bcms.data.update;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import resources.bcms.data.pub.BcmsBankInfo;
import resources.bcms.data.pub.BcmsRequestInfo;

public class BankInterface extends HttpServlet {
	private HttpServletResponse response = null;
	private HttpServletRequest request = null;
	public static final String BSZT_1 = "1";//提交银行业金融机构对公现金业务统计表（按存款人）数据
	public static final String BSZT_2 = "2";//提交银行业金融机构对公现金业务统计表（按行业归属）数据
	public static final String BSZT_3 = "3";//提交银行业金融机构对私现金业务统计表数据
	public static final String BSZT_4 = "4";//提交银行业金融机构现金库存情况统计表(贵州自提）的数据
	public static final String BSZT_5 = "5";//提交银行业金融机构现金收支总表的数据
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.request = req;
		this.response = resp;	
		String deliveryType = request.getParameter("deliveryType");
		BcmsRequestInfo urlobj = null;
		String url = null;
		JSONObject jobj = new JSONObject();
		//response.setContentType("text/html; charset=utf-8");
		//response.getWriter().write("<script type='text/javascript'>alert('怕是真的走到后台了！');</script>");
		try {
			//查询接口信息表
			ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
			List<BcmsRequestInfo> list = rootDAO.queryByQL2List(" from BcmsRequestInfo");
			//获取·与服务器建立可信传输 接口信息
			urlobj = getUrlObj("6",list);
			//获取接口url
			url = urlobj.getRequestURL();
			//获取商行凭证和商行密钥
			List<BcmsBankInfo> blist = rootDAO.queryByQL2List(" from BcmsBankInfo where id = 1");
			BcmsBankInfo bankinfo = blist.get(0);
			String param = "bankID="+bankinfo.getBankID()+"&secret="+bankinfo.getSecret();
			String reqe = BcmsHttpUtil.sendGet(url, param);
			
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().write("<script type='text/javascript'>alert('"+reqe+"');</script>");
			System.out.println("返回："+reqe);
			//jobj = JSONObject.fromObject(reqe);

			
			
		} catch (Exception e) {
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().write("<script type='text/javascript'>alert('接口报送失败！');</script>");
		}
	}
	
	/**
	 * 通过接口编号获取对应url
	 * @param id
	 * @param list
	 * @return
	 */
	private BcmsRequestInfo getUrlObj(String id,List<BcmsRequestInfo> list){
		BcmsRequestInfo urlobj = null;
		for (BcmsRequestInfo bcmsRequestInfo : list) {
			if(bcmsRequestInfo.getDeliveryType().equals(id)){
				urlobj = bcmsRequestInfo;
			}
		}
		return urlobj;
	}
}
