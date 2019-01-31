import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Edit extends searchMethods {

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
	public static int x;
	static int bookRow = 0;

	/**

	 * Launch the application.

	 * @throws IOException 

	 * @throws FileNotFoundException 

	 */

	public static void openEdit() throws FileNotFoundException, IOException {

		wb = new HSSFWorkbook(new FileInputStream("lmsdb.xls"));
		x = wb.getSheetAt(0).getLastRowNum();
		System.out.println("TEST");
		System.out.println(x);
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Edit window = new Edit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public Edit() {
		
		initialize();
	}


	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(300, 200, 965, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);	

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(102, 102, 153));
		panel.setBounds(0, 0, 965, 55);
		frame.getContentPane().add(panel);

		JLabel lblNewLab = new JLabel("Nazarbayev University Library System");
		lblNewLab.setForeground(new Color(255, 255, 255));
		lblNewLab.setBounds(6, 6, 311, 40);
		lblNewLab.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLab.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		panel.add(lblNewLab);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("AUTHOR");
		lblNewLabel.setBounds(38, 98, 71, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("TITLE");
		lblNewLabel_1.setBounds(38, 138, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("YEAR");
		lblNewLabel_2.setBounds(38, 172, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("ISBN");
		lblNewLabel_3.setBounds(38, 218, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("PUBLISHER");
		lblNewLabel_4.setBounds(38, 258, 71, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("LLC");
		lblNewLabel_5.setBounds(38, 298, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblStock = new JLabel("STOCK");
		lblStock.setBounds(38, 338, 46, 14);
		frame.getContentPane().add(lblStock);

		textAuthor = new JTextField();
		textAuthor.setBounds(121, 91, 237, 28);
		textAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAuthor.setBackground(new Color(204, 204, 204));
		frame.getContentPane().add(textAuthor);
		textAuthor.setColumns(10);

		textTitle = new JTextField();
		textTitle.setColumns(10);
		textTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
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

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				

                      String [] column_header = new String [7];
                      Display display = new Display();
				      column_header = display.returnResult(0, wb);
					  // Number of elements in table should be 
					  int count=count();
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

		JButton btnBack = new JButton("Back");
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

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(102, 102, 153));
		btnUpdate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {				

						int lastRowNum = wb.getSheetAt(0).getLastRowNum();
					    if(bookRow >= 0 && bookRow <= lastRowNum){

					    	wb.getSheetAt(0).getRow(bookRow).getCell(1).setCellValue(textAuthor.getText());
					    	wb.getSheetAt(0).getRow(bookRow).getCell(2).setCellValue(textTitle.getText());
					    	wb.getSheetAt(0).getRow(bookRow).getCell(3).setCellValue(textYear.getText());
					    	wb.getSheetAt(0).getRow(bookRow).getCell(4).setCellValue(textISBN.getText());
					    	wb.getSheetAt(0).getRow(bookRow).getCell(5).setCellValue(textPublish.getText());
					    	wb.getSheetAt(0).getRow(bookRow).getCell(6).setCellValue(textLLC.getText());
					    	wb.getSheetAt(0).getRow(bookRow).getCell(7).setCellValue(textStock.getText());
					    }   

						try {
							outFile = new FileOutputStream("lmsdb.xls");
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

				        try {
							wb.write(outFile);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

				        try {
							outFile.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();

						}
				        int i = table.getSelectedRow();

		                if(i >= 0){
		                	
		                	
		                   table.setValueAt(textAuthor.getText(), i, 0);
		                   table.setValueAt(textTitle.getText(), i, 1);
		                   table.setValueAt(textYear.getText(), i, 2);
		                   table.setValueAt(textISBN.getText(), i, 3);
		                   table.setValueAt(textPublish.getText(), i, 4);
		                   table.setValueAt(textLLC.getText(), i, 5);
		                   table.setValueAt(textStock.getText(), i, 6);
		                   
		                }
		                else{
		                    System.out.println("Update Error");
		                }
		                
		                Object[] options = {"Ok"};
		                int input =JOptionPane.showOptionDialog(null, "Book has been successfully updated", "The title", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			             
		                if(input == JOptionPane.OK_OPTION)
		                {
		                    try {
								openEdit();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                }

			}

		});

		btnUpdate.setBounds(150, 394, 90, 35);

		frame.getContentPane().add(btnUpdate);

		

		Object[] columns = {"Author","Title","Year", "ISBN", "Publisher", "LLC", "Stock"};

        final DefaultTableModel model1 = new DefaultTableModel();

        model1.setColumnIdentifiers(columns);

        

        JScrollPane scrollPane = new JScrollPane();

        scrollPane.setBounds(420, 96, 510, 334);

        frame.getContentPane().add(scrollPane);

        

        table_1 = new JTable();

        scrollPane.setViewportView(table_1);

        

        // set the model to the table

        table_1.setModel(model1);

		

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

		        for(int i = 1; i <= x; i++) {

					String str = wb.getSheetAt(0).getRow(i).getCell(2).getStringCellValue();

					if(str.equalsIgnoreCase(textTitle.getText())) {

						bookRow = i;

					}

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