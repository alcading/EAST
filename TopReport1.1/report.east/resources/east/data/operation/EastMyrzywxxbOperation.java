package resources.east.data.operation;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resources.east.data.pub.EastMyrzywxxb;
import resources.east.data.service.EastMyrzywxxbService;

public class EastMyrzywxxbOperation extends BaseOperation {

	public static final String ID = "EastMyrzywxxbOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";

	@Override
	public void afterProc(OperationContext context) throws CommonException {

	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {

	}

	@Override
	public void execute(OperationContext context) throws CommonException {

		String cmd = (String) context.getAttribute(CMD);
		EastMyrzywxxb eastMyrzywxxb = (EastMyrzywxxb) context.getAttribute(IN_PARAM);

		EastMyrzywxxbService eastMyrzywxxbService = EastMyrzywxxbService.getInstance();

		if (CMD_INSERT.equalsIgnoreCase(cmd)) {
			eastMyrzywxxbService.addEntity(eastMyrzywxxb);
		} else if (CMD_UPDATE.equalsIgnoreCase(cmd)) {
			eastMyrzywxxbService.modEntity(eastMyrzywxxb);
		} else if (CMD_DELETE.equalsIgnoreCase(cmd)) {
			eastMyrzywxxbService.removeEntity(eastMyrzywxxb);
		}
	}

}
