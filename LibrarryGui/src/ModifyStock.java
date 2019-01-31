
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;

public class ModifyStock {
	private static Workbook wb;
	private Display display = new Display();
	
	public void IssueOpen() throws IOException {
		try {
			wb = display.openFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		SecondPage sp = new SecondPage();
        String str = display.getCellText(wb.getSheetAt(0).getRow(sp.getNumber()).getCell(7));
        int stock = Integer.parseInt(str);
         --stock;
		
         wb.getSheetAt(0).getRow(sp.getNumber()).getCell(7).setCellValue(stock);
	    FileOutputStream outFile = new FileOutputStream("lmsdb.xls");
        wb.write(outFile);
        outFile.close();
	}

public void ReturnOpen() throws IOException {
	try {
		wb = display.openFile();
	} catch (IOException e) {
		e.printStackTrace();
	}	
	
	ReturnBook rb = new ReturnBook();
     String stck = display.getCellText(wb.getSheetAt(0).getRow(rb.getNumber()).getCell(7));
 
     int stockNumber = Integer.parseInt(stck);
     
     ++stockNumber;
	
    wb.getSheetAt(0).getRow(rb.getNumber()).getCell(7).setCellValue(stockNumber);
   
    FileOutputStream outFile = new FileOutputStream("lmsdb.xls");
    
    wb.write(outFile);
    wb.close();
    outFile.close();
  
   }
}