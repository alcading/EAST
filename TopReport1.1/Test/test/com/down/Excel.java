package test.com.down;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.junit.Test;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class Excel {
	@Test
	public void ExcelTest() {
		DownExcel downExcel=new DownExcel();
		downExcel.writeExcel("d:/test1.xls");	
	}
	@Test
	public void PdfTest(){	
		// 创建一个文档对象
		Document doc = new Document();		
		try {
			// 定义输出位置并把文档对象装入输出对象中
			PdfWriter.getInstance(doc, new FileOutputStream("d:/hello.pdf"));
			// 打开文档对象
			doc.open();
			doc.add(new Paragraph("HelloWorld"));
			doc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}	
	}
}
