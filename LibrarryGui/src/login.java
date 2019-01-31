import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

    private JFrame frame;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login window = new login();
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
    public login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(300, 25, 683, 587);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(32, 28, 617, 94);
        frame.getContentPane().add(panel);
        panel.setBackground(new Color(102, 102, 153));
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("WELCOME");
        lblNewLabel.setFont(new Font("Californian FB", Font.BOLD, 33));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(188, 21, 218, 62);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(102, 102, 153), 8));
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(32, 117, 617, 406);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 14));
        textField.setBounds(97, 123, 361, 46);
        panel_1.add(textField);
        textField.setColumns(10);


        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordField.setBounds(97, 209, 361, 46);
        panel_1.add(passwordField);

        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String user_name = textField.getText().toString();
                String passward = passwordField.getText().toString();
                if (user_name.equals("group") && passward.equals("helios")) {
                    MainHome mH = new MainHome();
                    mH.mainHomeOpen();
                }
                else
                    JOptionPane.showMessageDialog(null, "Username or/and password is wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(new Color(102, 102, 153));
        btnNewButton.setFont(new Font("Californian FB", Font.BOLD, 17));
        btnNewButton.setBounds(344, 300, 114, 35);
        panel_1.add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("rsz_purpleuser.png"));
        lblNewLabel_1.setBounds(462, 116, 40, 53);
        panel_1.add(lblNewLabel_1);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("rsz_log_in_purple_hexagon.png"));
        label.setBounds(462, 209, 46, 53);
        panel_1.add(label);
    }
}