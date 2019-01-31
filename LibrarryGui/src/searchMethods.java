import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

import org.apache.poi.ss.usermodel.Workbook;

public class searchMethods {
	private Display display = new Display();

	public int countNum(Workbook wb,JTextField textAuthor, JTextField textTitle,JTextField textYear,JTextField textISBN,JTextField textPublish,JTextField textLLC) {
	
		 int count=0;
		  Pattern patternAuthor = Pattern.compile(".*" + regex(textAuthor) + ".*");
		  Pattern patternTitle = Pattern.compile(".*" + regex(textTitle) + ".*");
		  Pattern patternYear = Pattern.compile(".*" + regex(textYear) + ".*");
		  Pattern patternISBN = Pattern.compile(".*" + regex(textISBN) + ".*");
		  Pattern patternPublish = Pattern.compile(".*" + regex(textPublish) + ".*");
		  Pattern patternLLC = Pattern.compile(".*" + regex(textLLC) + ".*");

         for(int j=1; j<=wb.getSheetAt(0).getLastRowNum(); j++) {
	       Matcher mAuthor = patternAuthor.matcher(input(wb,j,1));
	       Matcher mTitle = patternTitle.matcher(input(wb,j,2));
	       Matcher mYear = patternYear.matcher(input(wb,j,3));
	       Matcher mISBN = patternISBN.matcher(input(wb,j,4));
	       Matcher mPublish = patternPublish.matcher(input(wb,j,5));
	       Matcher mLLC = patternLLC.matcher(input(wb,j,6));
	      if(mAuthor.matches()&&mTitle.matches()&&mYear.matches()&&mISBN.matches()&&mPublish.matches()&&mLLC.matches()) {
		   count++;
	      }
    }
         
         return count;
	}
	
	public String [][] findBooks(Workbook wb,int count, JTextField textAuthor, JTextField textTitle,JTextField textYear,JTextField textISBN,JTextField textPublish,JTextField textLLC){
		 String [] [] findBooks = new String [count][7];
		 Pattern patternAuthor = Pattern.compile(".*" + regex(textAuthor) + ".*");
		  Pattern patternTitle = Pattern.compile(".*" + regex(textTitle) + ".*");
		  Pattern patternYear = Pattern.compile(".*" + regex(textYear) + ".*");
		  Pattern patternISBN = Pattern.compile(".*" + regex(textISBN) + ".*");
		  Pattern patternPublish = Pattern.compile(".*" + regex(textPublish) + ".*");
		  Pattern patternLLC = Pattern.compile(".*" + regex(textLLC) + ".*");
          int bookRow=0;
			for(int i=0; i<=wb.getSheetAt(0).getLastRowNum(); i++) {
			       Matcher mAuthor = patternAuthor.matcher(input(wb,i,1));
			       Matcher mTitle = patternTitle.matcher(input(wb,i,2));
			       Matcher mYear = patternYear.matcher(input(wb,i,3));
			       Matcher mISBN = patternISBN.matcher(input(wb,i,4));
			       Matcher mPublish = patternPublish.matcher(input(wb,i,5));
			       Matcher mLLC = patternLLC.matcher(input(wb,i,6));
			      if(mAuthor.matches()&&mTitle.matches()&&mYear.matches()&&mISBN.matches()&&mPublish.matches()&&mLLC.matches()) {
			    	  for(int k=0; k<7; k++) {
			    		  findBooks [bookRow][k] = display.returnResult(i, wb)[k];
						}
			    	  bookRow++;
			      }
			}
			
			return findBooks;
	}
	
	public String regex(JTextField text) {
		return text.getText().toString().toLowerCase();
	}
	
	public String input(Workbook wb,int row,int cell) {
		return display.getCellText(wb.getSheetAt(0).getRow(row).getCell(cell)).toLowerCase();
	}
}
