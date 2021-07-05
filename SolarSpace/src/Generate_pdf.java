

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import com.itextpdf.text.pdf.PdfWriter;

public class Generate_pdf {

	public Generate_pdf() {
		// TODO Auto-generated constructor stub
		String filename="F:\\3-2\\CS F212 DBS\\Project\\report\\report_gen.pdf";
		Document document=new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.open();
		
		PreparedStatement st;
		ResultSet rs;
		
		try {
			document.add(TableBuilder.createTable());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		document.close();
	}
}
