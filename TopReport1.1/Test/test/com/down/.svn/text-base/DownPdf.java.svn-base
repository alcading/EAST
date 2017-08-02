package test.com.down;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class DownPdf {
	public static void main(String[] args) throws DocumentException {
		// 创建一个文档对象
		Document doc = new Document();
		float[] widths = {0.1f,0.1f,0.05f,0.65f};
		PdfPTable table = new PdfPTable(widths);
		for(int i=0;i<8;i++){
		   PdfPCell cell = new PdfPCell();
		   cell.addElement(new Paragraph("aaa"));
		   table.addCell(cell);
		}
		
		try {
			// 定义输出位置并把文档对象装入输出对象中
			PdfWriter.getInstance(doc, new FileOutputStream("d:/hello.pdf"));
			// 打开文档对象
			doc.open();
			// 加入文字“Hello World”
			doc.add(table);
			// 关闭文档对象，释放资源
			doc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
