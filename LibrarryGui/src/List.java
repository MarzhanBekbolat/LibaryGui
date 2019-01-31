import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import org.apache.poi.ss.usermodel.Workbook;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import javax.swing.JTextPane;





public class List implements ActionListener{

	private JFrame frame;
	private static Workbook wb;
	private String regex;
	private JTable table;
	private JButton btnListAllBooks;
	private JButton btnSearch;
	private JTextField textBookName;
	private Display display = new Display();
	private MainHome mainHome = new MainHome();
	/**
	 * Launch the application.
	 */
	public static void listOpen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List window = new List();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public List() throws FileNotFoundException, IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException, IOException {
		frame = new JFrame();

		frame.setForeground(new Color(0, 0, 0));

		frame.setBackground(new Color(255, 255, 255));

		//frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));

		frame.getContentPane().setBounds(new Rectangle(1, 0, 0, 0));

		frame.getContentPane().setBackground(new Color(255, 255, 255));

		frame.setBounds(280, 100, 900, 600);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);

		frame.setResizable(false);

		

		JPanel panel = new JPanel();

		panel.setLayout(null);

		panel.setToolTipText("");

		panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		panel.setBackground(new Color(102, 102, 153));

		panel.setBounds(0, 0, 900, 70);

		frame.getContentPane().add(panel);

		

		

		JLabel lblNewLabel = new JLabel("Nazarbayev University Library System");

		lblNewLabel.setForeground(new Color(255, 255, 255));

		lblNewLabel.setBounds(6, 15, 311, 40);

		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);

		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));

		panel.add(lblNewLabel);

		frame.getContentPane().add(panel);

		

		

		btnSearch = new JButton("Quick Search");

		btnSearch.setForeground(Color.WHITE);

		btnSearch.setBorder(new LineBorder(Color.WHITE, 2));

		btnSearch.addActionListener(this);

		btnSearch.setBackground(new Color(102, 102, 153));

		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnSearch.setBounds(752, 22, 112, 31);

		panel.add(btnSearch);

		

		

		textBookName = new JTextField();

		textBookName.setToolTipText("book name");

		textBookName.setBackground(new Color(255, 255, 255));
		textBookName.setFont(new Font("Tahoma", Font.BOLD, 14));

		textBookName.setBounds(477, 21, 251, 31);

		panel.add(textBookName);

		textBookName.setBorder(new LineBorder(new Color(102, 0, 0)));

		

		JButton btnNewButton = new JButton("Advansed search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdvancedSearch.AdvancedSearchOpen();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));

		btnNewButton.setContentAreaFilled(false);

		btnNewButton.setBackground(new Color(102, 102, 153));

		btnNewButton.setForeground(Color.WHITE);

		btnNewButton.setBounds(325, 23, 140, 29);

		panel.add(btnNewButton);

		frame.getContentPane().add(panel);

		

		JButton btnBack = new JButton("BACK");

		//btnBack.setIcon(new ImageIcon("BACK.png"));

		btnBack.setForeground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 MainHome mH = new MainHome();
                 mH.mainHomeOpen();
			}
		});
		btnBack.setBackground(new Color(102, 102, 153));

		//	btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));

			btnBack.setBounds(18,525,90, 35);

			frame.getContentPane().add(btnBack);

			

			JPanel panel_1 = new JPanel();

			panel_1.setBackground(new Color(102, 102, 153));

			panel_1.setBounds(0, 70, 900, 54);

			frame.getContentPane().add(panel_1);

			panel_1.setLayout(null);

			//btnListAllBooks.setFont(new Font901, 4", Font.BOLD, 12));

			

			JTextPane txtpnsortDescending = new JTextPane();

			txtpnsortDescending.setBounds(258, 11, 113, 32);

			panel_1.add(txtpnsortDescending);

			txtpnsortDescending.setText("|Sort descending");

			txtpnsortDescending.setForeground(Color.WHITE);
			txtpnsortDescending.setFont(new Font("Tahoma", Font.BOLD, 12));

			//txtpnsortDescen427g.setFont(new Font("Tahoma", Font.BOLD, 12));

			txtpnsortDescending.setEditable(false);

			txtpnsortDescending.setBackground(new Color(102, 102, 153));

			

			JComboBox<String> comboBox_1 = new JComboBox<String>();

			comboBox_1.setBounds(383, 11, 87, 21);

			panel_1.add(comboBox_1);

			comboBox_1.setToolTipText("Sort by");

			comboBox_1.setName("");

			comboBox_1.setForeground(Color.WHITE);

			comboBox_1.setBackground(new Color(102, 102, 153));

			//comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 12));

			comboBox_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

			comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Author", "Title","Year", "Publisher", "ISBN", "LLC", "Stock"}));

			

			

			JTextPane txtpnSortBy = new JTextPane();

			txtpnSortBy.setBounds(500, 11, 105, 32);

			panel_1.add(txtpnSortBy);

			txtpnSortBy.setBackground(new Color(102, 102, 153));

			txtpnSortBy.setForeground(Color.WHITE);

			txtpnSortBy.setEditable(false);

			txtpnSortBy.setFont(new Font("Tahoma", Font.BOLD, 12));

			txtpnSortBy.setText("|Sort ascending");

			JComboBox<String> comboBox = new JComboBox<String>();

			comboBox.setBounds(617, 11, 87, 21);

			panel_1.add(comboBox);

			comboBox.setBackground(new Color(102, 102, 153));

			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Author","Title","Year", "Publisher", "ISBN", "LLC", "Stock"}));

			comboBox.setForeground(Color.WHITE);

			//comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));

			comboBox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

			comboBox.setName("");

			comboBox.setToolTipText("Sortd");		

			

			 btnListAllBooks = new JButton("| List all books");

			 btnListAllBooks.setBounds(736, 4, 113, 32);

			 panel_1.add(btnListAllBooks);

			 btnListAllBooks.setBorder(new LineBorder(Color.WHITE, 2));

			 btnListAllBooks.setBackground(new Color(102, 102, 153));

			 btnListAllBooks.addActionListener(this);

			 btnListAllBooks.setForeground(Color.WHITE);		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = (String) comboBox.getSelectedItem();//get the selected item    
	                switch (s) {//check for a match
	                    case "Author":
            				jTable(header(), sortedBook(1, 0,'A'), table);
	                    	break;
	                    	
	                    case "Title":
	                    	jTable(header(), sortedBook(2, 1,'A'), table);
	                        break;
	                    case "Year":
	                    	jTable(header(), sortedBook(3, 2,'A'), table);                        
	                        break; 
	                    case "Publisher":
	                    	jTable(header(), sortedBook(5, 4,'A'), table);                         
	                        break;
	                    case "ISBN":
	                    	jTable(header(), sortedBook(4, 3,'A'), table);
	                    	break;
	                    case "LLC":
	                    	jTable(header(), sortedBook(6, 5,'A'), table);
	                    	break;
	                    case "Stock":
	                    	jTable(header(), sortedBook(7, 6,'A'), table);
	                    	break;
	                }
			}
		});
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = (String) comboBox_1.getSelectedItem();//get the selected item    
	                switch (s) {//check for a match
	                    case "Author":
            				jTable(header(), sortedBook(1, 0,'D'), table);
	                    	break;
	                    	
	                    case "Title":
	                    	jTable(header(), sortedBook(2, 1,'D'), table);
	                        break;
	                    case "Year":
	                    	jTable(header(), sortedBook(3, 2,'D'), table);                        
	                        break; 
	                    case "Publisher":
	                    	jTable(header(), sortedBook(5, 4,'D'), table);                         
	                        break;
	                    case "ISBN":
	                    	jTable(header(), sortedBook(4, 3,'D'), table);
	                    	break;
	                    case "LLC":
	                    	jTable(header(), sortedBook(6, 5,'D'), table);
	                    	break;
	                    case "Stock":
	                    	jTable(header(), sortedBook(7, 6,'D'), table);
	                    	break;
	                }
			}
		});
		
	}
	
	
	
	public void jTable(String [] column, String [] [] list, JTable table) {
		table = new JTable(list, column);
		table.setFont(new Font("Verdana", Font.PLAIN, 13));

        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setBounds(20, 140, 850, 370);
        frame.getContentPane().add(scrollPane2,0);
        scrollPane2.setViewportView(table);
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnListAllBooks) { 
			//table2.setVisible(false);
			try {
				wb = display.openFile();
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
	       
		
			String [] [] books = new String [wb.getSheetAt(0).getLastRowNum()][7];
			for(int i=0; i<wb.getSheetAt(0).getLastRowNum(); i++) {
				for(int j=0; j<7; j++) {
					books [i][j] = display.returnResult(i+1, wb)[j];
		
				}
			}
			jTable(header(), books, table);
		
		}
	
		else if(e.getSource()==btnSearch) {
			regex = textBookName.getText().toString().toLowerCase();
			try {
				wb = display.openFile();
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			
			
				  // Number of elements in table should be 
				  int count=0;
				  Pattern pattern = Pattern.compile(".*" + regex + ".*");
		          String row = new String();
		          for(int j=1; j<=wb.getSheetAt(0).getLastRowNum(); j++) {
			      row = display.getCellText(wb.getSheetAt(0).getRow(j).getCell(2));
			       Matcher mRow = pattern.matcher(row.toLowerCase());
			      if(mRow.matches()) {
				   count++;
			      }
		     }
		          if(count==0) {
		        	   JOptionPane.showMessageDialog(null, "There is no such book in library","Not found", JOptionPane.INFORMATION_MESSAGE);
		           }
		          else {
		          String [] [] findBooks = new String [count][7];
		          int bookRow=0;
					for(int i=0; i<wb.getSheetAt(0).getLastRowNum()+1; i++) {
						 row = display.getCellText(wb.getSheetAt(0).getRow(i).getCell(2));
					       Matcher mRow = pattern.matcher(row.toLowerCase());
					      if(mRow.matches()) {
					    	  for(int k=0; k<7; k++) {
					    		  findBooks [bookRow][k] = display.returnResult(i, wb)[k];
								}
					    	  bookRow++;
					      }
					}
					jTable(header(), findBooks, table);
		          }
	  }

	}
	public String [] header() {
		try {
			wb = display.openFile();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
    	String [] column_header1 = new String [7];
    	column_header1 = display.returnResult(0, wb);
    	return column_header1;
	}
	
	
	public String [][] sortedBook(int toList, int toColumn, char order){
		try {
			wb = display.openFile();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		String [][] sortedBooks3 = new String [wb.getSheetAt(0).getLastRowNum()][7];
		int i3;
		ArrayList<String[]> lt3=display.list(wb);
		ArrayList<String> listTitle3=returnList(toList, order);
		Boolean equal3;
		if(toList==3) {
			int num3=0;
			while(listTitle3.size()>0) {
				 equal3=true;
				i3=0;
				while(equal3) {
					if(listTitle3.get(0).equals((lt3).get(0)[toColumn].replaceAll("[^0-9.]", ""))) {
						equal3 =false;		
					}
					else {
					i3++;
					if(listTitle3.get(0).replaceAll("[^0-9.]", "").equals((lt3).get(i3)[toColumn].replaceAll("[^0-9.]", ""))) {
						equal3 =false;		
					}
					}
					
				}
				for(int j=0; j<7; j++) {
					sortedBooks3[num3][j] = lt3.get(i3)[j];
				}
				
				listTitle3.remove(0);
				lt3.remove(i3);
				num3++;
			}
		}
		else {
			int num3=0;
		while(listTitle3.size()>0) {
			 equal3=true;
			i3=0;
			while(equal3) {
				if(listTitle3.get(0).equals((lt3).get(0)[toColumn])) {
					equal3 =false;		
				}
				else {
				i3++;
				if(listTitle3.get(0).equals((lt3).get(i3)[toColumn])) {
					equal3 =false;		
				}
				}
				
			}
			for(int j=0; j<7; j++) {
				sortedBooks3[num3][j] = lt3.get(i3)[j];
			}
			
			listTitle3.remove(0);
			lt3.remove(i3);
			num3++;
		}
		}
		return sortedBooks3;
	}
	
	public ArrayList<String> returnList(int toList, char order){
		ArrayList<String> listTitle3=display.listTitle(wb, toList);
		if(order=='A')
			return listTitle3;
		else {
			ArrayList<String> reverse=listTitle3;
			Collections.reverse(reverse);
			return reverse;
	}
	}
	
	
}
