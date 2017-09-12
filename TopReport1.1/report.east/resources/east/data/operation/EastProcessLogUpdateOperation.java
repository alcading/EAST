package resources.east.data.operation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.engine.SessionFactoryImplementor;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import resources.east.data.pub.EastProcessLog;

public class EastProcessLogUpdateOperation extends BaseOperation {

	private static final HtLog htlog=HtLogFactory.getLogger(EastProcessLogUpdateOperation.class);
	public static final String ID = "EastProcessLogUpdateOperation";
	public static final String CMD = "CMD";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	private ROOTDAO rootDao ;

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
	
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String)context.getAttribute(CMD);
		EastProcessLog processLog = (EastProcessLog) context.getAttribute(IN_PARAM);
//		if(CMD_DELETE.equalsIgnoreCase(cmd)){
//			deleteLog( processLog);
//		 }	
		EastVerifyManual();
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
	}
	

	
    public void deleteLog(EastProcessLog processLog) throws CommonException{
		
		rootDao = ROOTDAOUtils.getROOTDAO();		
		try {
			rootDao.delete(processLog);

		} catch (Exception e) {
			// TODO: handle exception
			ExceptionUtil.throwCommonException("删除WhjBranchInfo实体类不存在");
		}
	}

	private Boolean isExists(String id) {
		rootDao = ROOTDAOUtils.getROOTDAO();
		EastProcessLog processLog;
		try {
			processLog = rootDao.query(EastProcessLog.class,id);
			if(processLog ==null){
				return false;
			}
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			htlog.info(this.getClass().getName()+"判断实体是否重复出错");
			e.printStackTrace();
		}
		
		return true;
	}

	
	public void EastVerifyManual(){
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		SessionFactory sf = rootdao.getSessionFactory();
		ConnectionProvider cp = ((SessionFactoryImplementor) sf).getConnectionProvider();
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		String proc = null;
		try {
			conn = cp.getConnection();
			proc = "{Call EAST_DATECHK}";
			call = conn.prepareCall(proc);
			htlog.info(" execute "+proc);
			//int parLen = getCallableStaParLen(detail,parsList);
			 call.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if (call!=null) {
				try {
					call.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				if(cp!=null){
					try {
						cp.closeConnection(conn);
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		}
	}

}
