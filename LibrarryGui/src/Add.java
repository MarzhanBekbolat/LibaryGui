import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class Add {

    private JTextField textAuthor;
    private JTextField textTitle;
    private JTextField textYear;
    private JTextField textISBN;
    private JTextField textPublisher;
    private JTextField textLLC;
    private Workbook wb;
    JFrame frame;
    private JTextField textStock;



    public static void add() {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    Add window = new Add();

                    window.frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        });

    }



    public Add() throws FileNotFoundException, IOException {

        addBook();

    }



    private void addBook() throws FileNotFoundException, IOException {



        frame = new JFrame();
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(470, 65, 580, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        //	frame.setResizable(true);



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
        textAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));
        textAuthor.setBounds(145, 87, 350, 35);
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



        textPublisher = new JTextField();
        textPublisher.setBackground(new Color(204, 204, 204));
        textPublisher.setFont(new Font("Tahoma", Font.BOLD, 14));
        textPublisher.setBounds(145, 287, 350, 35);
        frame.getContentPane().add(textPublisher);
        textPublisher.setColumns(10);



        textLLC = new JTextField();
        textLLC.setBackground(new Color(204, 204, 204));
        textLLC.setFont(new Font("Tahoma", Font.BOLD, 14));
        textLLC.setBounds(145, 337, 350, 35);
        frame.getContentPane().add(textLLC);
        textLLC.setColumns(10);



        textStock = new JTextField();
        textStock.setBackground(new Color(204, 204, 204));
        textStock.setFont(new Font("Tahoma", Font.BOLD, 14));
        textStock.setBounds(145, 387, 350, 35);
        frame.getContentPane().add(textStock);
        textStock.setColumns(10);



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



        JTextPane txtpnStock = new JTextPane();
        txtpnStock.setLocation(new Point(1, 1));
        //	txtpnStock.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        txtpnStock.setEditable(false);
        txtpnStock.setText("  STOCK");
        txtpnStock.setBounds(36, 393, 100, 23);
        frame.getContentPane().add(txtpnStock);


        final JButton btnAdd = new JButton("ADD");
    	btnAdd.setForeground(Color.WHITE);
    	btnAdd.setBackground(new Color(102, 102, 153));
        btnAdd.setBounds(439, 452, 90, 35);
        frame.getContentPane().add(btnAdd);



        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if (arg0.getSource() == btnAdd) {
                    try {
                        FileInputStream inputStream = new FileInputStream(new File("lmsdb.xls"));
                        Workbook workbook = WorkbookFactory.create(inputStream);

                        Sheet sheet = workbook.getSheetAt(0);

                        Object[] bookData = {
                            textAuthor.getText(),
                            textTitle.getText(),
                            textYear.getText(),
                            textISBN.getText(),

                            textPublisher.getText(),
                            textLLC.getText(),
                            textStock.getText()
                        };


                        int rowCount = sheet.getLastRowNum();
                        Row row = sheet.createRow(++rowCount);
                        int columnCount = 0;
                        Cell cell = row.createCell(columnCount);
                        cell.setCellValue(rowCount + 2);



                        for (Object field: bookData) {
                            cell = row.createCell(++columnCount);
                            if (field instanceof String) {
                                cell.setCellValue((String) field);
                            } else if (field instanceof Integer) {
                                cell.setCellValue((Integer) field);
                            }
                        }
                        
                        if (textTitle.getText().isEmpty() || textYear.getText().isEmpty() || textISBN.getText().isEmpty() || 
                        		textPublisher.getText().isEmpty() || textLLC.getText().isEmpty() || textStock.getText().isEmpty()) { 	
                            JOptionPane.showMessageDialog(null, "Verify that all fields are filled");
                        }
                        if (!textYear.getText().matches("^[0-9]+$") && textYear.getText() != null) {
                            JOptionPane.showMessageDialog(null, "Year must be a number");
                        }
                        if (!textStock.getText().matches("^[0-9]+$") && textStock.getText() != null) {
                            JOptionPane.showMessageDialog(null, "Stock must be a number");
                        }



                        if ((textYear.getText().matches("^[0-9]+$") || textYear.getText() == null) &&
                            (textStock.getText().matches("^[0-9]+$") || textStock.getText() == null) && 
                            !(textTitle.getText().isEmpty() || textYear.getText().isEmpty() || textISBN.getText().isEmpty() || 
                            		textPublisher.getText().isEmpty() || textLLC.getText().isEmpty() || textStock.getText().isEmpty())) {
                            inputStream.close();


                            FileOutputStream outputStream = new FileOutputStream("lmsdb.xls");
                            workbook.write(outputStream);
                            workbook.close();
                            outputStream.close();
                            JOptionPane.showMessageDialog(null, "Book has been successfully added");

                        }


                    } catch (IOException | EncryptedDocumentException | InvalidFormatException ex) {

                        ex.printStackTrace();

                    }

                }

            }



        });



        JButton button = new JButton("BACK");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 MainHome mH = new MainHome();
                 mH.mainHomeOpen();
            }

        });

        //button.setIcon(new ImageIcon("C:\\Users\\marzh\\Desktop\\software engineering\\BACK.png"));

    	button.setForeground(Color.WHITE);
    	button.setBackground(new Color(102, 102, 153));
        button.setBounds(337, 452, 90, 35);
        frame.getContentPane().add(button);
    }


    public String input(Workbook wb, int row, int cell) {
        Display display = new Display();
        return display.getCellText(wb.getSheetAt(0).getRow(row).getCell(cell)).toLowerCase();
    }

    public String regex(JTextField text) {
        return text.getText().toString().toLowerCase();
    }

}