package resources.east.data.update;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.framework.util.DateUtil;

import resource.bean.pub.Globalinfo;
import resource.bean.pub.SystemBszq;
import resource.dao.pub.GlobalinfoDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

public class EastGlobalinfoUpdate extends HttpServlet {
	private HttpServletResponse response = null;
	private HttpServletRequest request = null;
	public static final String BSZQ_1 = "1";//日报
	public static final String BSZQ_2 = "2";//月报
	public static final String BSZQ_3 = "3";//季报
	public static final String BSZQ_4 = "4";//半年报
	public static final String BSZQ_5 = "5";//年报
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.request = req;
		this.response = resp;	
		String sjrq = request.getParameter("sjrq");
		try {
			GlobalinfoDAO dao=BaseDAOUtils.getGlobalinfoDAO();
			Globalinfo globalinfo = dao.findById(1);
			DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.US);
			Date date = df.parse(sjrq);
			ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
			List<SystemBszq> bszqList = rootDAO.queryByQL2List(" from SystemBszq where id = '1'");
			SystemBszq bszq = bszqList.get(0);
			if(bszq.getBszq().equals(this.BSZQ_1)){//达州和雅安East为日报
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				calendar.add(calendar.DATE, -1);
				globalinfo.setLbhdate(calendar.getTime());
			}
			if(bszq.getBszq().equals(this.BSZQ_2)){
				globalinfo.setLbhdate(DateUtil.getLastDateL(date));
			}
			globalinfo.setBhdate(date);
			globalinfo.setTbsdy(date);
			dao.update(globalinfo);
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().write("<script type='text/javascript'>alert('工作日期修改成功！');</script>");
		} catch (Exception e) {
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().write("<script type='text/javascript'>alert('工作日期修改失败！');</script>");
		}
	}
}
