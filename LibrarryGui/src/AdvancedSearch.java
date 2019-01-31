import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Workbook;


public class AdvancedSearch  extends searchMethods{
	private JTextField textAuthor;
	private JTextField textTitle;
	private JTextField textYear;
	private JTextField textISBN;
	private JTextField textPublish;
	private JTextField textLLC;
	private Workbook wb;
	private JFrame frame;
	private Display display = new Display();

	public static void AdvancedSearchOpen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdvancedSearch window = new AdvancedSearch();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private AdvancedSearch() throws FileNotFoundException, IOException {
		try {
			wb = display.openFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame= new JFrame();

		frame.getContentPane().setBackground(Color.WHITE);

		frame.setBounds(400, 120, 580, 500);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);

	    frame.setResizable(false);

		

		JPanel panel = new JPanel();

		panel.setLayout(null);

		panel.setToolTipText("");

		panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		panel.setBackground(new Color(102, 102, 153));

		panel.setBounds(0, 0, 580, 55);

		frame.getContentPane().add(panel);

		

	

		JLabel lblNewLabel = new JLabel("Nazarbayev University Library System");

		lblNewLabel.setForeground(new Color(255, 255, 255));

		lblNewLabel.setBounds(6, 6, 311, 40);

		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);

		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));

		panel.add(lblNewLabel);

		frame.getContentPane().add(panel);

		

		

		textAuthor = new JTextField();

		textAuthor.setBackground(new Color(204, 204, 204));

		textAuthor.setBounds(145, 87, 350, 35);
		textAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));

		frame.getContentPane().add(textAuthor);

		textAuthor.setColumns(10);

		

		textTitle = new JTextField();

		textTitle.setBackground(new Color(204, 204, 204));
		textTitle.setFont(new Font("Tahoma", Font.BOLD, 14));

		textTitle.setBounds(145, 137, 350, 35);

		frame.getContentPane().add(textTitle);

		textTitle.setColumns(10);

		

		textYear = new JTextField();

		textYear.setBackground(new Color(204, 204, 204));
		textYear.setFont(new Font("Tahoma", Font.BOLD, 14));

		textYear.setBounds(145, 187, 350, 35);

		frame.getContentPane().add(textYear);

		textYear.setColumns(10);

		

		textISBN = new JTextField();

		textISBN.setBackground(new Color(204, 204, 204));
		textISBN.setFont(new Font("Tahoma", Font.BOLD, 14));

		textISBN.setBounds(145, 237, 350, 35);

		frame.getContentPane().add(textISBN);

		textISBN.setColumns(10);

		

		textPublish = new JTextField();

		textPublish.setBackground(new Color(204, 204, 204));
		textPublish.setFont(new Font("Tahoma", Font.BOLD, 14));

		textPublish.setBounds(145, 287, 350, 35);

		frame.getContentPane().add(textPublish);

		textPublish.setColumns(10);

		

		textLLC = new JTextField();

		textLLC.setBackground(new Color(204, 204, 204));
		textLLC.setFont(new Font("Tahoma", Font.BOLD, 14));

		textLLC.setBounds(145, 337, 350, 35);

		frame.getContentPane().add(textLLC);

		textLLC.setColumns(10);
		
		JTextPane txtpnAuthor = new JTextPane();

		txtpnAuthor.setLocation(new Point(1, 1));

	//	txtpnAuthor.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		txtpnAuthor.setEditable(false);

		txtpnAuthor.setText("  AUTHOR");

		txtpnAuthor.setBounds(36, 94, 100, 23);

		frame.getContentPane().add(txtpnAuthor);

		

		JTextPane txtpnTitle = new JTextPane();

		txtpnTitle.setLocation(new Point(1, 1));

	//	txtpnTitle.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		txtpnTitle.setEditable(false);

		txtpnTitle.setText("  TITLE");

		txtpnTitle.setBounds(36, 149, 100, 23);

		frame.getContentPane().add(txtpnTitle);

		

		JTextPane txtpnYear = new JTextPane();

		txtpnYear.setLocation(new Point(1, 1));

		//txtpnYear.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		txtpnYear.setEditable(false);

		txtpnYear.setText("  YEAR");

		txtpnYear.setBounds(36, 194, 100, 23);

		frame.getContentPane().add(txtpnYear);

		

		JTextPane txtpnIsbn = new JTextPane();

		txtpnIsbn.setLocation(new Point(1, 1));

	//	txtpnIsbn.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		txtpnIsbn.setEditable(false);

		txtpnIsbn.setText("  ISBN");

		txtpnIsbn.setBounds(36, 248, 100, 23);

		frame.getContentPane().add(txtpnIsbn);

		

		JTextPane txtpnPublisher = new JTextPane();

		txtpnPublisher.setLocation(new Point(1, 1));

	//	txtpnPublisher.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		txtpnPublisher.setEditable(false);

		txtpnPublisher.setText("  PUBLISHER");

		txtpnPublisher.setBounds(36, 294, 100, 23);

		frame.getContentPane().add(txtpnPublisher);

		

		JTextPane txtpnLlc = new JTextPane();

		txtpnLlc.setLocation(new Point(1, 1));

	//	txtpnLlc.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		txtpnLlc.setEditable(false);

		txtpnLlc.setText("  LLC");

		txtpnLlc.setBounds(36, 347, 100, 23);

		frame.getContentPane().add(txtpnLlc);

		
		
		JButton btnSearch = new JButton("SEARCH");

		btnSearch.setForeground(Color.WHITE);

		btnSearch.setBackground(new Color(102,102,153));

	//	btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnSearch.setBounds(439, 405, 90, 35);

		frame.getContentPane().add(btnSearch);

		
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                  String [] column_header = new String [7];
					column_header = display.returnResult(0, wb);
				 //AdvancedSearch aS= new AdvancedSearch();
				   int count=count();
					
					  // Number of elements in table should be 
			           if(count==0) {
			        	   JOptionPane.showMessageDialog(null, "There is no such book in library","Not found", JOptionPane.INFORMATION_MESSAGE);
			           }
			           
			           else {
			          String [] [] findBooks = new String [count][7];
			           findBooks =finBook();
						
						JFrame frameTable = new JFrame();
						Toolkit tk = Toolkit.getDefaultToolkit();
				 		Dimension dim = tk.getScreenSize();
				 		frameTable.getContentPane().setBackground(Color.WHITE);
				 		frameTable.setBounds(0, 0, dim.width, dim.height);
				 		frameTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 		frameTable.getContentPane().setLayout(null);
				 		frameTable.setResizable(false);
				 		
				 		JPanel panel = new JPanel();
						panel.setLayout(null);
						panel.setToolTipText("");
						panel.setBorder(new LineBorder(new Color(0, 0, 0)));
						panel.setBackground(new Color(102,102,153));
						panel.setBounds(0, 0, 1395, 105);
						frameTable.getContentPane().add(panel);
						
						JLabel label_1 = new JLabel("");
						label_1.setIcon(new ImageIcon("rsz_logo_white.png"));
						label_1.setVerticalTextPosition(SwingConstants.BOTTOM);
						label_1.setVerticalAlignment(SwingConstants.TOP);
						label_1.setForeground(Color.WHITE);
						label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
						label_1.setBackground(Color.WHITE);
						label_1.setBounds(20, 11, 167, 85);
						panel.add(label_1);
						JButton back = new JButton("Back");
						//back.setIcon(new ImageIcon("BACK.png"));
						back.setForeground(new Color(255,255, 255));
						back.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								AdvancedSearchOpen();
								frameTable.dispose();
							}
						});
						back.setBackground(new Color(102, 102, 153));
						back.setFont(new Font("Tahoma", Font.BOLD, 11));
						back.setBounds(15, 655, 114, 45);
						frameTable.getContentPane().add(back);
						JTable table2 = new JTable();
						table2 = new JTable( findBooks, column_header);
						table2.setFont(new Font("Verdana", Font.PLAIN, 13));
				        JScrollPane scrollPane2 = new JScrollPane();
				        scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				        scrollPane2.setBounds(20, 200, 1325, 450);
				        frameTable.getContentPane().add(scrollPane2);
				        scrollPane2.setViewportView(table2);
				        frameTable.setVisible(true);
			           }
			
			}
			
		});
		
		JButton button = new JButton("BACK");

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				List.listOpen();

			}

		});

		//button.setIcon(new ImageIcon("BACK.png"));

		button.setForeground(Color.WHITE);

		//button.setFont(new Font("Tahoma", Font.BOLD, 11));

		button.setBackground(new Color(102, 102, 153));

		button.setBounds(337, 405, 90, 35);

		frame.getContentPane().add(button);

		frame.setResizable(false);
	}
	
	public int count() {
		
		return super.countNum(wb,textAuthor, textTitle, textYear, textISBN, textPublish, textLLC);
	}
	
	public String [][] finBook(){
		return super.findBooks(wb,count(), textAuthor, textTitle, textYear, textISBN, textPublish, textLLC);
	}
	
}
