package test.com.down;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class DownExcel {
	
	  public static void writeExcel(String fileName){
	         WritableWorkbook wwb = null;
	          try {
	             wwb = Workbook.createWorkbook(new File(fileName));
	          } catch (IOException e) {
	             e.printStackTrace();
	         }
	          if(wwb!=null){
	             WritableSheet ws = wwb.createSheet("sheet1", 0);
	              for(int i=0;i<10;i++){
	                  for(int j=0;j<5;j++){
	                     //第一个参数表示列，第二个表示行
	                	  Label labelC=null;
	                	  if(i==j){
	                		  WritableFont wfc = new WritableFont(WritableFont.ARIAL, 10,
		                			  WritableFont.NO_BOLD, false,
		                			  UnderlineStyle.NO_UNDERLINE,Colour.RED);
		                	 WritableCellFormat wcfFC = new WritableCellFormat(wfc);
		                     labelC = new Label(j, i, "这是第"+(i+1)+"行，第"+(j+1)+"列",wcfFC);
	                	  }else if(i==0||j==0){
	                		  WritableFont wf = new WritableFont(WritableFont.TIMES, 18,
	                				  WritableFont.BOLD, true);
	                				  WritableCellFormat wcfF = new WritableCellFormat(wf);
	                		  labelC = new Label(j, i, "这是第"+(i+1)+"行，第"+(j+1)+"列",wcfF);
	                	  }else{
		                	  labelC = new Label(j, i, "这是第"+(i+1)+"行，第"+(j+1)+"列");
	                	  }
	                      try {
	                         ws.addCell(labelC);
	                      } catch (RowsExceededException e) {
	                         e.printStackTrace();
	                      } catch (WriteException e) {
	                         e.printStackTrace();
	                     }
	                 }
	             }	 
	              try {	      
	                 wwb.write();
	                 wwb.close();
	              } catch (IOException e) {
	                 e.printStackTrace();
	              } catch (WriteException e) {
	                 e.printStackTrace();
	             }
	         }
	     } 	
}
