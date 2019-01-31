import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;


public class MainHome extends JFrame {

     void mainHomeOpen() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainHome window = new MainHome();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        new MainHome();
    }

    /**
     * Create the application.
     */
    public MainHome() {
        getContentPane().setBackground(Color.WHITE);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();

        this.setAutoRequestFocus(false);
        this.setBounds(0, 0, dim.width, dim.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 1360, 739);
        getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnNewButton_4 = new JButton("EXIT");
        btnNewButton_4.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnNewButton_4.setBounds(66, 693, 80, 35);
        panel.add(btnNewButton_4);
        btnNewButton_4.setBackground(Color.WHITE);
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_4.setIcon(null);
        btnNewButton_4.setContentAreaFilled(false);

        JButton btnNewButton_1 = new JButton("LIST");
        btnNewButton_1.setBounds(338, 200, 125, 120);
        btnNewButton_1.setContentAreaFilled(false);
        panel.add(btnNewButton_1);
        btnNewButton_1.setBackground(Color.WHITE);
        btnNewButton_1.setIcon(new ImageIcon("icons8-book-stack-100.png"));
        btnNewButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List.listOpen();
            }
        });

        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);

        JButton btnBorrowreturn = new JButton("BORROW");
        btnBorrowreturn.setBounds(627, 200, 125, 120);
        panel.add(btnBorrowreturn);
        btnBorrowreturn.setBackground(Color.WHITE);
        btnBorrowreturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SecondPage sp;
				try {
					sp = new SecondPage();
					sp.SecondPageOpen();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        btnBorrowreturn.setIcon(new ImageIcon("icons8-borrow-book-100.png"));
        btnBorrowreturn.setContentAreaFilled(false);
        btnBorrowreturn.setHorizontalTextPosition(SwingConstants.CENTER);
        btnBorrowreturn.setVerticalAlignment(SwingConstants.BOTTOM);
        btnBorrowreturn.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnBorrowreturn.setFont(new Font("Tahoma", Font.BOLD, 13));

        JButton btnReturn = new JButton("RETURN");
        btnReturn.setBounds(905, 200, 140, 130);
        panel.add(btnReturn);
        btnReturn.setContentAreaFilled(false);
        btnReturn.setBackground(Color.WHITE);
        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReturnBook.ReturnBookOpen();
            }
        });
        btnReturn.setIcon(new ImageIcon("icons8-return-book-100.png"));
        btnReturn.setHorizontalTextPosition(SwingConstants.CENTER);
        btnReturn.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnReturn.setVerticalAlignment(SwingConstants.BOTTOM);
        btnReturn.setFont(new Font("Tahoma", Font.BOLD, 13));
        
                JButton btnNewButton = new JButton("ADD");
                btnNewButton.setContentAreaFilled(false);
                btnNewButton.setBounds(905, 413, 140, 130);
                panel.add(btnNewButton);
                btnNewButton.setBackground(Color.WHITE);
                btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Add.add();
                    }
                });
                btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
                btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
                btnNewButton.setIcon(new ImageIcon("icons8-add-book-100.png"));
                btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        
                JButton btnDelete = new JButton("DELETE");
                btnDelete.setBounds(627, 413, 140, 130);
                panel.add(btnDelete);
                btnDelete.setBackground(Color.WHITE);
                btnDelete.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Delete.deleteOpen();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                });
                btnDelete.setHorizontalTextPosition(SwingConstants.CENTER);
                btnDelete.setContentAreaFilled(false);
                btnDelete.setIcon(new ImageIcon("DELETE.png"));
                btnDelete.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnDelete.setVerticalAlignment(SwingConstants.BOTTOM);
                btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
        
                JButton btnNewButton_2 = new JButton("EDIT");
                btnNewButton_2.setContentAreaFilled(false);
                btnNewButton_2.setBounds(338, 423, 125, 120);
                panel.add(btnNewButton_2);
                btnNewButton_2.setBackground(Color.WHITE);
                btnNewButton_2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
                            Edit.openEdit();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                });
                btnNewButton_2.setIcon(new ImageIcon("icons8-check-book-100.png"));
                btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
                btnNewButton_2.setVerticalAlignment(SwingConstants.BOTTOM);
                btnNewButton_2.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setToolTipText("");
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBackground(new Color(102, 102, 153));
        panel_1.setBounds(0, 0, 1350, 102);
        panel.add(panel_1);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("C:\\Users\\marzh\\Desktop\\software engineering\\SE_Final_Project\\LibrarryGui\\rsz_logo_white.png"));
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setBackground(Color.WHITE);
        label.setBounds(10, 11, 167, 80);
        panel_1.add(label);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\marzh\\Desktop\\software engineering\\modern-style-white-wood-floor-texture-white-wood-texture-white-wood-wall-texture-16.jpg"));
        lblNewLabel.setBounds(0, 0, 1350, 756);
        panel.add(lblNewLabel);
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        this.setVisible(true);
    }
}