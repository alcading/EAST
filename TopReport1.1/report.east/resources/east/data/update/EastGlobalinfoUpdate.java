package resources.east.data.update;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.framework.util.DateUtil;

import resource.bean.pub.Globalinfo;
import resource.dao.pub.GlobalinfoDAO;

public class EastGlobalinfoUpdate extends HttpServlet {
	private HttpServletResponse response = null;
	private HttpServletRequest request = null;
	
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
			globalinfo.setLbhdate(DateUtil.getLastDateL(date));
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
