

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;



public class TableBuilder {
	
	public static PdfPTable createTable() throws DocumentException {

        
		
        PdfPTable table1 = new PdfPTable(1);
        PdfPTable table2 = new PdfPTable(2);
        // set the width of the table to 100% of page
        table1.setWidthPercentage(90);
        table2.setWidthPercentage(50);     
        
		String username = Login_Form.getUsername();
		
		PreparedStatement st;
		ResultSet rs;
		PreparedStatement st2;
		ResultSet rs2;
		String query2="Select first_name,last_name,city from solarspace.user where username=?";
		String fname = null,lname = null,city = null;
	 	
    	try {
    		
			st2 = DB_Connection.getConnection().prepareStatement(query2);
			st2.setString(1, username);
			  rs2 = st2.executeQuery();
			  while(rs2.next()) {
				  fname=rs2.getString("first_name");
				  lname=rs2.getString("last_name");
				  city=rs2.getString("city");
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Paragraph para=new Paragraph("Name: " +fname+" "+lname);
    	Paragraph para1=new Paragraph("City: "+ city);
    	
    	
        
        
        
        
      
		
	

       

        // ----------------Table Header "Title"----------------
        // font
        Font font = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLACK);
        // create header cell
        PdfPCell cell = new PdfPCell(new Phrase("Solar Space Efficieny Report",font));
        // set Column span "1 cell = 6 cells width"
        cell.setColspan(2);
        // set style
        Style.headerCellStyle(cell);
        // add to table
        table1.addCell(cell);
        PdfPCell cell1=new PdfPCell(para);
        cell1.setColspan(2);
        cell1.setBorder(0);
        cell1.setBorderColor(null);
         table1.addCell(cell1);
         
         PdfPCell cell2=new PdfPCell(para1);
         cell2.setColspan(2);
         cell2.setBorder(0);
         cell2.setBorderColor(null);
          table1.addCell(cell2);
          
         PdfPCell cells = new PdfPCell(new Phrase(""));
         cells.setBorder(0);
         cells.setBorderColor(null);
         table1.addCell(cells);
         table1.addCell(cells);
         table1.addCell(cells);
         table1.addCell(cells);
         table1.addCell(cells);
         table1.addCell(cells);
         table1.addCell(cells);
         table1.addCell(cells);
         table1.addCell(cells);
         table1.addCell(cells);
         table1.addCell(cells);
         table1.addCell(cells);
        //-----------------Table Cells Label/Value------------------

        // Table header
        table2.addCell(createValueCell("Panel ID"));
        table2.addCell(createValueCell("Efficiency"));
        

        //Connection conn;
        
		
		//username and password from the form
	
		
		String query= "Select pid, pow2/pow as eff from solarspace.view4 where pid in (select sid from solarspace.spanel_user where uname = ?)";
        
        
        try {
        
        	
 
        	
        	st = DB_Connection.getConnection().prepareStatement(query);
            
            st.setString(1, username);
            
            
            rs = st.executeQuery();
            
            while (rs.next()) {
            	table2.addCell(createLabelCell(String.valueOf(rs.getInt("pid"))));
            	table2.addCell(createLabelCell(String.valueOf(rs.getDouble("eff")*100) + "%"));
            }
            JOptionPane.showMessageDialog(null, "Report Generated");
            
        } catch (SQLException err) {
        	System.err.println(err);
        }
        System.out.println("table created.");
        table1.addCell(table2);
        return table1;
	}
    

    // create cells
    private static PdfPCell createLabelCell(String text){
        // font
        Font font = new Font(FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);

        // create cell
        PdfPCell cell = new PdfPCell(new Phrase(text,font));

        // set style
        Style.labelCellStyle(cell);
        return cell;
    }

    // create cells
    private static PdfPCell createValueCell(String text){
        // font
        Font font = new Font(FontFamily.TIMES_ROMAN, 15, Font.NORMAL, BaseColor.BLACK);

        // create cell
        PdfPCell cell = new PdfPCell(new Phrase(text,font));

        // set style
        Style.tableHeaderCellStyle(cell);
        return cell;
    }
    
    
}
