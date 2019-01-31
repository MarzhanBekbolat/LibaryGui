import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Delete extends searchMethods{



	private JFrame frame;
	private JTextField textAuthor;
	private JTextField textTitle;
	private JTextField textYear;
	private JTextField textISBN;
	private JTextField textPublish;
	private JTextField textLLC;
	private JTextField textStock;
	private static Workbook wb;
	private JTable table;
	private JTable table_1;
	private FileOutputStream outFile;
	private static int x;
	private JPanel panel = new JPanel();
    private JPanel panel1;    
    private Display display = new Display();

    

    

    

	public static void deleteOpen() throws FileNotFoundException, IOException {

		wb = new HSSFWorkbook(new FileInputStream("lmsdb.xls"));

		x = wb.getSheetAt(0).getLastRowNum();

		System.out.println("TEST");

		System.out.println(x);

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Delete window = new Delete();

					window.frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}



	/**

	 * Create the application.

	 */

	public Delete() {

		initialize();

	}



	/**

	 * Initialize the contents of the frame.

	 */

	private void initialize() {

		frame = new JFrame();

		frame.getContentPane().setBackground(Color.WHITE);

		frame.setBounds(300, 200, 965, 480);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);

		

		panel1 = new JPanel();

		panel1.setLayout(null);

		panel1.setToolTipText("");

		panel1.setBorder(new LineBorder(new Color(0, 0, 0)));

		panel1.setBackground(new Color(102, 102, 153));

		panel1.setBounds(0, 0, 965, 55);

		frame.getContentPane().add(panel1);

		

		JLabel lblNewLabNU = new JLabel("Nazarbayev University Library System");

		lblNewLabNU.setForeground(new Color(255, 255, 255));

		lblNewLabNU.setBounds(6, 6, 311, 40);

		lblNewLabNU.setHorizontalAlignment(SwingConstants.LEFT);

		lblNewLabNU.setFont(new Font("Times New Roman", Font.PLAIN, 17));

		panel1.add(lblNewLabNU);

		frame.getContentPane().add(panel1);

		

		JLabel lblNewLabelAU = new JLabel("AUTHOR");

		lblNewLabelAU.setBounds(38, 98, 71, 14);

		frame.getContentPane().add(lblNewLabelAU);

		

		JLabel lblNewLabel_1TL = new JLabel("TITLE");

		lblNewLabel_1TL.setBounds(38, 138, 46, 14);

		frame.getContentPane().add(lblNewLabel_1TL);

		

		JLabel lblNewLabel_2YR = new JLabel("YEAR");

		lblNewLabel_2YR.setBounds(38, 172, 46, 14);

		frame.getContentPane().add(lblNewLabel_2YR);

		

		JLabel lblNewLabel_3Isbn = new JLabel("ISBN");

		lblNewLabel_3Isbn.setBounds(38, 218, 46, 14);

		frame.getContentPane().add(lblNewLabel_3Isbn);

		

		JLabel lblNewLabel_4P = new JLabel("PUBLISHER");

		lblNewLabel_4P.setBounds(38, 258, 71, 14);

		frame.getContentPane().add(lblNewLabel_4P);

		

		JLabel lblNewLabel_5LLC = new JLabel("LLC");

		lblNewLabel_5LLC.setBounds(38, 298, 46, 14);

		frame.getContentPane().add(lblNewLabel_5LLC);

		

		JLabel lblStock1 = new JLabel("STOCK");

		lblStock1.setBounds(38, 338, 46, 14);

		frame.getContentPane().add(lblStock1);

		

		textAuthor = new JTextField();

		textAuthor.setBounds(121, 91, 237, 28);
		textAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));

		textAuthor.setBackground(new Color(204, 204, 204));

		frame.getContentPane().add(textAuthor);

		textAuthor.setColumns(10);

		

		textTitle = new JTextField();
		textTitle.setFont(new Font("Tahoma", Font.BOLD, 14));

		textTitle.setColumns(10);

		textTitle.setBackground(new Color(204, 204, 204));

		textTitle.setBounds(121, 131, 237, 28);

		frame.getContentPane().add(textTitle);

		

		textYear = new JTextField();

		textYear.setColumns(10);
		textYear.setFont(new Font("Tahoma", Font.BOLD, 14));

		textYear.setBackground(new Color(204, 204, 204));

		textYear.setBounds(121, 171, 237, 28);

		frame.getContentPane().add(textYear);

		

		textISBN = new JTextField();

		textISBN.setColumns(10);
		textISBN.setFont(new Font("Tahoma", Font.BOLD, 14));

		textISBN.setBackground(new Color(204, 204, 204));

		textISBN.setBounds(121, 211, 237, 28);

		frame.getContentPane().add(textISBN);

		

		textPublish = new JTextField();

		textPublish.setColumns(10);
		textPublish.setFont(new Font("Tahoma", Font.BOLD, 14));

		textPublish.setBackground(new Color(204, 204, 204));

		textPublish.setBounds(121, 251, 237, 28);

		frame.getContentPane().add(textPublish);

		

		textLLC = new JTextField();

		textLLC.setColumns(10);
		textLLC.setFont(new Font("Tahoma", Font.BOLD, 14));

		textLLC.setBackground(new Color(204, 204, 204));

		textLLC.setBounds(121,291, 237, 28);

		frame.getContentPane().add(textLLC);

		

		textStock = new JTextField();

		textStock.setColumns(10);
		textStock.setFont(new Font("Tahoma", Font.BOLD, 14));

		textStock.setBackground(new Color(204, 204, 204));

		textStock.setBounds(121,331, 237, 28);

		frame.getContentPane().add(textStock);

		

		table = new JTable();

        final DefaultTableModel model = new DefaultTableModel();

				

		JButton btnSearch = new JButton("SEARCH");

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                      String [] column_header = new String [7];
				      column_header = display.returnResult(0, wb);
					  // Number of elements in table should be 		
					  int count = count();
					  if(count==0) {
			        	   JOptionPane.showMessageDialog(null, "There is no such book in library","Not found", JOptionPane.INFORMATION_MESSAGE);
			           }					 
					  else {
						  String [] [] findBooks = new String [count][7];
				          findBooks =finBook();
							
					        table = new JTable(findBooks, column_header);
							table.setFont(new Font("Verdana", Font.PLAIN, 13));
					        JScrollPane scrollPane2 = new JScrollPane();
					        scrollPane2.setViewportView(table);
					        scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					        scrollPane2.setBounds(420, 96, 510, 334);
					        frame.getContentPane().add(scrollPane2,0);
					        setTextField(table);

					  }
			}

		});

		

		

		btnSearch.setBounds(268, 394, 90, 35);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(102, 102, 153));

		frame.getContentPane().add(btnSearch);

		

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 MainHome mH = new MainHome();
                 mH.mainHomeOpen();
			}
		});

		btnBack.setBounds(23, 394, 90, 35);
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(102, 102, 153));
		frame.getContentPane().add(btnBack);

		

		JButton btnDelete = new JButton("DELETE");

		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int bookRow = 0;
				for(int i = 1; i <= x; i++) {
					String str = wb.getSheetAt(0).getRow(i).getCell(2).getStringCellValue();
					if(str.equalsIgnoreCase(textTitle.getText())) {
						bookRow = i;
						break;
					}
				}	

						int lastRowNum = wb.getSheetAt(0).getLastRowNum();
					    if(bookRow >= 0 && bookRow < lastRowNum){
					    	wb.getSheetAt(0).shiftRows(bookRow+1,lastRowNum, -1);
					    	wb.getSheetAt(0).removeRow((HSSFRow) wb.getSheetAt(0).getRow(lastRowNum));
					    }

					    if(bookRow == lastRowNum){
					        HSSFRow removingRow = (HSSFRow) wb.getSheetAt(0).getRow(bookRow);
					        if(removingRow != null){
					            wb.getSheetAt(0).removeRow(removingRow);
					        }
					    }

						try {
							outFile = new FileOutputStream("lmsdb.xls");
						} catch (FileNotFoundException e2) {
							e2.printStackTrace();
						}

				        try {
							wb.write(outFile);
						} catch (IOException e1) {
							e1.printStackTrace();
						}

				        try {
							outFile.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}

                        Object[] options = {"OK"};
		                int input =JOptionPane.showOptionDialog(null, "Book has been successfully deleted", "The title", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); 
		             
		                if(input == JOptionPane.OK_OPTION)
		                {
		                    try {
								deleteOpen();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                }
		                

			}
		});

		btnDelete.setBounds(150, 394, 90, 35);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(102, 102, 153));

		frame.getContentPane().add(btnDelete);

		

		Object[] columns = {"Author","Title","Year", "ISBN", "Publisher", "LLC", "Stock"};

        final DefaultTableModel model1 = new DefaultTableModel();

        model1.setColumnIdentifiers(columns);

        

        JScrollPane scrollPane = new JScrollPane();

        scrollPane.setBounds(420, 96, 510, 334); //409, 41, 510, 334

        frame.getContentPane().add(scrollPane);

        

        table_1 = new JTable();

        scrollPane.setViewportView(table_1);

        

        // set the model to the table

        table_1.setModel(model1);

        panel.setBackground(new Color(102, 102, 153));

        panel.setBounds(0, 0, 949, 31);

        frame.getContentPane().add(panel);

		

	}


	public void setTextField(final JTable table){

		table.addMouseListener(new MouseAdapter(){

		    public void mouseClicked(MouseEvent evnt) {

		        if (evnt.getClickCount() == 1) {

		           int row = table.getSelectedRow();

						textAuthor.setText(table.getModel().getValueAt(row, 0).toString());

						textTitle.setText(table.getModel().getValueAt(row, 1).toString());

						textYear.setText(table.getModel().getValueAt(row, 2).toString());

						textISBN.setText(table.getModel().getValueAt(row, 3).toString());

						textPublish.setText(table.getModel().getValueAt(row, 4).toString()); 

						textLLC.setText(table.getModel().getValueAt(row, 5).toString());

						textStock.setText(table.getModel().getValueAt(row, 6).toString()); 

		         }

		        

		     }

		});

		}
	
	public int count() {
		return super.countNum(wb,textAuthor, textTitle, textYear, textISBN, textPublish, textLLC);
	}
	
	public String [][] finBook(){
		return super.findBooks(wb,count(), textAuthor, textTitle, textYear, textISBN, textPublish, textLLC);
	}

}