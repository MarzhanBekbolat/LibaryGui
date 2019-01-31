
import java.awt.EventQueue;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//import javax.swing.JFrame;

//import javax.swing.JPanel;

//import javax.swing.JTable;

//import javax.swing.border.EmptyBorder;

import javax.swing.border.LineBorder;
import org.apache.poi.ss.usermodel.Workbook;
import java.awt.Color;

//import javax.swing.JLabel;
//import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

//import javax.swing.JTextField;
//import javax.swing.JTextPane;

import java.awt.event.ActionListener;

import java.io.IOException;

//import java.util.regex.Pattern;

import java.awt.event.ActionEvent;

public class SecondPage extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static Workbook wb;
    private static int count; 
    private int stcNumber;
    private JFrame frame, frame1;
    private static String stcN;
    private static int number=0;
    private Matcher mISBN;
    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Display display = new Display();

	public void SecondPageOpen(){

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondPage window = new SecondPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SecondPage() throws FileNotFoundException, IOException {
		

		frame= new JFrame();

		frame.getContentPane().setBackground(Color.WHITE);

		frame.setBounds(470, 300, 475, 327);

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

		

		

		JLabel lblNewLabel_1 = new JLabel("             Enter ISBN number of the book, that you want to borrow:");

		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		lblNewLabel_1.setBounds(0, 60, 450, 35);

		frame.getContentPane().add(lblNewLabel_1);

		

		

		JTextField IsbnNumber = new JTextField();

		IsbnNumber.setBackground(new Color(204, 204, 204));

		IsbnNumber.setBounds(129, 107, 190, 35);

		frame.getContentPane().add(IsbnNumber);

		IsbnNumber.setColumns(10);

		

		

		JButton btnNewButton = new JButton("Back");

		btnNewButton.setForeground(Color.WHITE);

		btnNewButton.setBackground(new Color(102, 102, 153));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MainHome mainHome = new MainHome();
				mainHome.mainHomeOpen();
				frame.dispose();
			}
		});

		btnNewButton.setBounds(229, 237, 90, 35);

		frame.getContentPane().add(btnNewButton);

		

		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setForeground(Color.WHITE);

		btnNewButton_1.setBackground(new Color(102, 102, 153));

		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					wb = display.openFile();
				}
					catch(IOException e1) {
						e1.printStackTrace();
						}

                 Pattern patternISBN = Pattern.compile(".*" + regex(IsbnNumber) + ".*");
			     String isbn=regex(IsbnNumber);
				
			     if(isbn.length() >= 5) {
			       for(count=1; count<=wb.getSheetAt(0).getLastRowNum(); count++) {  

					        mISBN = patternISBN.matcher(input(wb,count,4));    

			           	if (mISBN.matches()) {					       	   
					    	   Frame1();
					    	   frame.dispose();					    	  
					    	   number=count;
					    	   break;
					       }

				        if(!mISBN.matches()&& count==wb.getSheetAt(0).getLastRowNum()) {
				        	JOptionPane.showMessageDialog (null, "Sorry, book with such ISBN number is not available in the library!");   
				        	break;
				        	}
			       }
			       
				}else {
					 JOptionPane.showMessageDialog(null, "Invalid ISBN number");	
				}

			}

		});


		btnNewButton_1.setBounds(343, 237, 90, 35);

		frame.getContentPane().add(btnNewButton_1);

	}



	    public void Frame1() {

	    	frame1= new JFrame();

			frame1.getContentPane().setBackground(Color.WHITE);

			frame1.setBounds(430, 220, 550, 550);

			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			frame1.getContentPane().setLayout(null);

		//	frame1.setResizable(true);

			

			JPanel panel1 = new JPanel();

			panel1.setLayout(null);

			panel1.setToolTipText("");

			panel1.setBorder(new LineBorder(new Color(0, 0, 0)));

			panel1.setBackground(new Color(102, 102, 153));

			panel1.setBounds(0, 0, 550, 55);

			frame1.getContentPane().add(panel1);

			

		

			JLabel lblNewLabel = new JLabel("Nazarbayev University Library System");

			lblNewLabel.setForeground(new Color(255, 255, 255));

			lblNewLabel.setBounds(6, 6, 311, 40);

			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);

			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));

			panel1.add(lblNewLabel);

			frame1.getContentPane().add(panel1);
			try {
				wb = display.openFile();
			}

				catch(IOException e1) {
					e1.printStackTrace();
					}

			JButton btnIssue1 = new JButton("ISSUE");
			btnIssue1.setForeground(Color.white);

			btnIssue1.setBackground(new Color(102, 102, 153));
			btnIssue1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(stcNumber>0) {
						stcN=Integer.toString(stcNumber);	
						 JOptionPane.showMessageDialog(null, "Book is successfully issued");

						try {
							ModifyStock modifyStock = new ModifyStock();
							modifyStock.IssueOpen();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

					else if(stcNumber==0) {
						 JOptionPane.showMessageDialog(null, "Book is not available!");	
					}
				
				}
			});


			btnIssue1.setBounds(439, 452, 90, 35);

			frame1.getContentPane().add(btnIssue1);

	

		

		JTextPane tAuthor = new JTextPane();

		tAuthor.setLocation(new Point(1, 1));

	//	tAuthor.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		tAuthor.setEditable(false);

		tAuthor.setText("  AUTHOR");

		tAuthor.setBounds(36, 94, 100, 23);

		frame1.getContentPane().add(tAuthor);

		

		JTextPane tTitle = new JTextPane();

		tTitle.setText("  TITLE");

		tTitle.setLocation(new Point(1, 1));

		//tTitle.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		tTitle.setEditable(false);

		tTitle.setBounds(36, 149, 100, 23);

		frame1.getContentPane().add(tTitle);

		

		JTextPane tYear = new JTextPane();

		tYear.setText("  YEAR");

		tYear.setLocation(new Point(1, 1));

		//tYear.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		tYear.setEditable(false);

		tYear.setBounds(36, 194, 100, 23);

		frame1.getContentPane().add(tYear);

		

		JTextPane tIsbn = new JTextPane();

		tIsbn.setText("  ISBN");

		tIsbn.setLocation(new Point(1, 1));

		//tIsbn.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		tIsbn.setEditable(false);

		tIsbn.setBounds(36, 248, 100, 23);

		frame1.getContentPane().add(tIsbn);

		

		JTextPane tPublisher = new JTextPane();

		tPublisher.setText("  PUBLISHER");

		tPublisher.setLocation(new Point(1, 1));

		//tPublisher.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		tPublisher.setEditable(false);

		tPublisher.setBounds(36, 294, 100, 23);

		frame1.getContentPane().add(tPublisher);

		

		JTextPane tLlc = new JTextPane();

		tLlc.setText("  LLC");

		tLlc.setLocation(new Point(1, 1));

		//tLlc.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		tLlc.setEditable(false);

		tLlc.setBounds(36, 347, 100, 23);

		frame1.getContentPane().add(tLlc);

		

		JTextPane tStock = new JTextPane();

		tStock.setText("  STOCK");

		tStock.setLocation(new Point(1, 1));

		//tStock.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		tStock.setEditable(false);

		tStock.setBounds(36, 393, 100, 23);

		frame1.getContentPane().add(tStock);

		

		

		JTextField Author = new JTextField();

		Author.setBackground(new Color(204, 204, 204));

		Author.setBounds(145, 87, 350, 35);

		Author.setEditable(false);

		frame1.getContentPane().add(Author);

		Author.setColumns(10);

		

		JTextField Title = new JTextField();

		Title.setBackground(new Color(204, 204, 204));

		Title.setBounds(145, 137, 350, 35);

		Title.setEditable(false);

		frame1.getContentPane().add(Title);

		Title.setColumns(10);

		

		

		JTextField Year = new JTextField();

		Year.setBackground(new Color(204, 204, 204));

		Year.setBounds(145, 187, 350, 35);

		Year.setEditable(false);

		frame1.getContentPane().add(Year);

		Year.setColumns(10);

		

		JTextField ISBN = new JTextField();

		ISBN.setBackground(new Color(204, 204, 204));

		ISBN.setBounds(145, 237, 350, 35);

		ISBN.setEditable(false);

		frame1.getContentPane().add(ISBN);

		ISBN.setColumns(10);

		

		JTextField Publisher = new JTextField();

		Publisher.setBackground(new Color(204, 204, 204));

		Publisher.setBounds(145, 287, 350, 35);

		Publisher.setEditable(false);

		frame1.getContentPane().add(Publisher);

		Publisher.setColumns(10);

		

		JTextField LLC = new JTextField();

		LLC.setBackground(new Color(204, 204, 204));

		LLC.setBounds(145, 337, 350, 35);

		LLC.setEditable(false);

		frame1.getContentPane().add(LLC);

		LLC.setColumns(10);

		

		JTextField Stock = new JTextField();

		Stock.setBackground(new Color(204, 204, 204));

		Stock.setBounds (145, 387, 350, 35);

		Stock.setEditable(false);

		frame1.getContentPane().add(Stock);

		Stock.setColumns(10);

		

		

		///////

		JButton bottonBack = new JButton("BACK");

		bottonBack.setForeground(new Color(0, 0, 0));

		bottonBack.setBackground(new Color(102, 102, 153));
		bottonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecondPageOpen();
				frame1.dispose();
			}
		});
		
		bottonBack.setBounds(337, 452, 90, 35);

		frame1.getContentPane().add(bottonBack);

		
		String author=input(wb,count,1); 
		    Author.setText(author);	

	    String title=input(wb,count,2); 
			Title.setText(title);	

       String year=input(wb,count,3); 
				Year.setText(year);	

       String Isbn=input(wb,count,4); 
	      		ISBN.setText(Isbn);	
					
       String publisher=input(wb,count,5); 
				Publisher.setText(publisher);	

       String llc=input(wb,count,6); 
			   LLC.setText(llc);	

	   String stock=input(wb,count,7); 
				Stock.setText(stock);

	   stcNumber=Integer.parseInt(stock);
	   this.frame1.setVisible(true);
	   }
	    
	public int getNumber() {
		return this.number;
	}
	public int getCount() {
		return count;
	}

	public String input(Workbook wb,int row,int cell) {
		return display.getCellText(wb.getSheetAt(0).getRow(row).getCell(cell));
	}

	public String regex(JTextField text) {
		return text.getText().toString();
	}
	
	}
