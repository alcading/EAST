package com.huateng.ebank.business.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelTable {
	private Hashtable columnsById = new Hashtable();
	private Hashtable columnsByName = new Hashtable();
	private List table = new LinkedList();
	private Workbook currentWorkbook = null;
	
	private void loadWorkbook(String filepath){
		try {
			currentWorkbook = Workbook.getWorkbook(new File(filepath));
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadWorkbook(InputStream inputStream){
		try {
			currentWorkbook = Workbook.getWorkbook(inputStream);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	
	public void loadSheet(Workbook workbook, int sheetNumber){
		Sheet sheet = workbook.getSheet(0);
		int rowCount = sheet.getRows();
		int colCount = sheet.getColumns();
		for(int i=0; i<colCount; i++){
			Cell colTlt = sheet.getCell(i,0);
			String title = colTlt.getContents();
			columnsById.put(new Integer(i), title);
			columnsByName.put(title, new Integer(i));
		}
		//------modified by HuangWeijing 20091116 JIRA:BMS-2222 begin
		for(int i=1; i<rowCount; i++){
			//加入空行标识
			boolean blankRow = true;
			List rowList = new ArrayList();
			for(int j=0; j<colCount; j++){
				Cell cell = sheet.getCell(j, i);
				String cellCont = cell.getContents();
				if(cellCont!=null && !cellCont.equals("")) {
					//若一行中有某一格不为空，则该行不是空行
					blankRow = false;
				}
				rowList.add(cellCont);
			}
			if(!blankRow) {
				//如果不是空行则将该行加入表格
				table.add(rowList);
			}
		}
		//------modified by HuangWeijing 20091116 JIRA:BMS-2222 end
	}
	
	public void loadSheet(int sheetNumber){
		this.loadSheet(currentWorkbook, sheetNumber);
	}
	
	public void print(){
		if(table.size()==0)
			return;
		int colCount = ((List)table.get(0)).size();
		for(int i=0; i<colCount; i++){
			String colStr = (String) columnsById.get(new Integer(i));
			System.out.print(colStr+"\t");
		}
		System.out.println();
		
		for(int i=0; i<table.size(); i++){
			List row = (List) table.get(i);
			for(int j=0; j<row.size(); j++){
				String cellStr = (String) row.get(j);
				System.out.print(cellStr+"\t");
			}
			System.out.println();
		}
	}
	
	public List Row(int rowIdx){
		return (List)table.get(rowIdx);
	}
	
	public String Cell(int rowIdx, int colIdx){
		return (String)((List)table.get(rowIdx)).get(colIdx);
	}
	
	public String Cell(int rowIdx, String colName){
		int colIdx = (Integer)columnsByName.get(colName);
		return Cell(rowIdx, colIdx);
	}

	public Workbook getCurrentWorkbook() {
		return currentWorkbook;
	}
	
	public int getRowCount()
	{
		return table.size();
	}
	
	public int getColumnCount()
	{
		return columnsByName.size();
	}
	
	public int getColumnName(String colName){
		Integer colIdx = (Integer) columnsByName.get(colName);
		if(colIdx == null)
			return 0;
		else
			return colIdx;
	}
}
