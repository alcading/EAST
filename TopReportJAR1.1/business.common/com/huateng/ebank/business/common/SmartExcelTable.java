package com.huateng.ebank.business.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class SmartExcelTable {
	private List smartTable = new LinkedList();
	private Workbook currentWorkbook = null;
	private Integer rowCount;
	private Integer columnCount;

	private void loadWorkbook(String filepath){
		try {
			currentWorkbook = Workbook.getWorkbook(new File(filepath));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadWorkbook(InputStream inputStream){
		try {
			currentWorkbook = Workbook.getWorkbook(inputStream);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void open(String filepath){
		loadWorkbook(filepath);
		this.loadSheet(currentWorkbook, 0);
	}

	public void open(InputStream inputStream){
		loadWorkbook(inputStream);
		this.loadSheet(currentWorkbook, 0);
	}

	public void open(String filepath,Integer sheetNumber){
		loadWorkbook(filepath);
		this.loadSheet(currentWorkbook, sheetNumber);
	}

	public void open(InputStream inputStream, Integer sheetNumber){
		loadWorkbook(inputStream);
		this.loadSheet(currentWorkbook, sheetNumber);
	}

	public void open(String filepath,String sheetName){
		loadWorkbook(filepath);
		this.loadSheet(currentWorkbook, sheetName);
	}

	public void open(InputStream inputStream, String sheetName){
		loadWorkbook(inputStream);
		this.loadSheet(currentWorkbook, sheetName);
	}

	public void loadSheet(Workbook workbook, int sheetNumber){

		Sheet sheet = workbook.getSheet(sheetNumber);
		rowCount = sheet.getRows();
		columnCount = sheet.getColumns();

		for(int i=0; i<rowCount; i++){
			List rowList = new ArrayList();
			for(int j=0; j<columnCount; j++){
				Cell cell = sheet.getCell(j, i);
				String cellContent = cell.getContents().trim();
				rowList.add(cellContent);
			}
			smartTable.add(rowList);
		}
	}
	public void loadSheet(Workbook workbook, String sheetName){

		Sheet sheet = workbook.getSheet(sheetName);
		rowCount = sheet.getRows();
		columnCount = sheet.getColumns();

		for(int i=0; i<rowCount; i++){
			List rowList = new ArrayList();
			for(int j=0; j<columnCount; j++){
				Cell cell = sheet.getCell(j, i);
				String cellContent = cell.getContents().trim();
				rowList.add(cellContent);
			}
			smartTable.add(rowList);
		}
	}
	public void loadSheet(int sheetNumber){
		this.loadSheet(currentWorkbook, sheetNumber);
	}

	public List Row(int rowIdx){
		return (List)smartTable.get(rowIdx);
	}

	public String Cell(int rowIdx, int colIdx){
		return (String)((List)smartTable.get(rowIdx)).get(colIdx);
	}


	public Workbook getCurrentWorkbook() {
		return currentWorkbook;
	}

	public List getSmartTable() {
		return smartTable;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public Integer getColumnCount() {
		return columnCount;
	}

}
