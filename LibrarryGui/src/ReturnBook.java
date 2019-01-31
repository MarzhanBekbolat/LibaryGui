import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.apache.poi.ss.usermodel.Workbook;

public class ReturnBook {

	private JFrame frame;
	private static int count;
	private static int number;
	private static Workbook wb;
	private Display display = new Display();
	/**
	 * Launch the application.
	 */
	public static void ReturnBookOpen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook window = new ReturnBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ReturnBook() throws FileNotFoundException, IOException {
	

		frame= new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(470, 300, 466, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	//	frame.setResizable(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(102, 102, 153));
		panel.setBounds(0, 0, 450, 55);
		frame.getContentPane().add(panel);
		
	
		JLabel lblNewLabel = new JLabel("Nazarbayev University Library System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(6, 6, 311, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		panel.add(lblNewLabel);
		frame.getContentPane().add(panel);
		
		
		JLabel lblNewLabel_1 = new JLabel("             Enter ISBN number of the book, that you want to return:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(0, 60, 450, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JTextField IsbnNum = new JTextField();
		IsbnNum.setBackground(new Color(204, 204, 204));
		IsbnNum.setBackground(new Color(204, 204, 204));
		IsbnNum.setBounds(129, 107, 190, 35);
		frame.getContentPane().add(IsbnNum);
		IsbnNum.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(102, 102, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainHome mainHome = new MainHome();
				mainHome.mainHomeOpen();
			}
		});
		btnNewButton.setBounds(229, 237, 90, 35);
		frame.getContentPane().add(btnNewButton);
		//////////////
		

	JButton btnReturn = new JButton("Return");
	btnReturn.setForeground(Color.WHITE);
	btnReturn.setBackground(new Color(102, 102, 153));
	
	btnReturn.addActionListener(new ActionListener() {
	
		public void actionPerformed(ActionEvent e) {	
			try {
				wb = display.openFile();
			}
			catch(IOException e1) {
					e1.printStackTrace();
			}	
			
			Pattern patternISBN = Pattern.compile(".*" + regex(IsbnNum) + ".*");			
			String isbnN=regex(IsbnNum);
			if(isbnN.length() >= 5) {
				for(count=1; count<=wb.getSheetAt(0).getLastRowNum(); count++) {
					Matcher mISBN = patternISBN.matcher(input(wb,count,4));
					if(mISBN.matches()) {
						JOptionPane.showMessageDialog(null, "Book is successfully returned");
						number=count;
						try {
							ModifyStock modifyStock = new ModifyStock();
							modifyStock.ReturnOpen();
						} catch (IOException e1) {
							e1.printStackTrace();
							}
						break;
						}
					if(!mISBN.matches()&& count==wb.getSheetAt(0).getLastRowNum()) {
						JOptionPane.showMessageDialog (null, "Sorry, you can not return, because book with such ISBN number is not available in the library!");   			    		  
				        break;
				     }
					}
				}else {		
				 JOptionPane.showMessageDialog(null, "Invalid ISBN number");					
				 }			
			}
		});
	btnReturn.setBounds(343, 237, 90, 35);
	frame.getContentPane().add(btnReturn);   
	}
	
	int getNumber() {
		return this.number;
	}
	
	public String regex(JTextField text) {
		return text.getText().toString();
	}
	
	public String input(Workbook wb,int row,int cell) {
		return display.getCellText(wb.getSheetAt(0).getRow(row).getCell(cell));
    }	
}
