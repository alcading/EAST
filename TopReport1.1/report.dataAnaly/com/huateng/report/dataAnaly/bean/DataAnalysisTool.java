package com.huateng.report.dataAnaly.bean;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.engine.SessionFactoryImplementor;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;


/**
 * 数据分析可继承工具类
 * @author NING-PENG
 *
 */
public class DataAnalysisTool {

	public ConnectionProvider getConnectionProvider(){
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		SessionFactory sf = rootdao.getSessionFactory();
		ConnectionProvider cp = ((SessionFactoryImplementor) sf).getConnectionProvider();
		return cp;
	}

	public Connection getConnection(ConnectionProvider cp) throws SQLException{
		return cp.getConnection();
	}

	public void closeConnection(ConnectionProvider cp,Connection conn) throws SQLException{
		if (conn != null) {
			if (cp != null) {
				cp.closeConnection(conn);
			} else {
				// ignore
			}
		}
	}
}
