package qems;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class loginAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginAdmin frame = new loginAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernamelabel = new JLabel("Username");
		usernamelabel.setForeground(new Color(47, 38, 121));
		usernamelabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		usernamelabel.setBounds(309, 11, 173, 54);
		contentPane.add(usernamelabel);
		
		JLabel passwordlabel = new JLabel("Password");
		passwordlabel.setForeground(new Color(47, 38, 121));
		passwordlabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		passwordlabel.setBounds(309, 134, 173, 54);
		contentPane.add(passwordlabel);
		
		username = new JTextField();
		username.setBounds(175, 76, 421, 33);
		contentPane.add(username);
		username.setColumns(10);
		
		JCheckBox show_password = new JCheckBox("Show Password");
		show_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(show_password.isSelected())
				{
					passwordField.setEchoChar((char)0);
				}
				else
				{
					passwordField.setEchoChar('*');
				}
			}
		});
		show_password.setFont(new Font("Tahoma", Font.BOLD, 14));
		show_password.setBounds(321, 255, 147, 29);
		contentPane.add(show_password);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.getText().equals("qems") && passwordField.getText().equals("admin") )
				{
						 setVisible(false);
						 new adminHome().setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect Password!!");
				}
			}
		});
		login.setIcon(new ImageIcon(loginAdmin.class.getResource("/qems/login.png")));
		login.setFont(new Font("Tahoma", Font.BOLD, 16));
		login.setBounds(234, 301, 126, 39);
		contentPane.add(login);
		
		JButton back = new JButton("Back");
		back.setIcon(new ImageIcon(loginAdmin.class.getResource("/qems/Back.png")));
		back.setFont(new Font("Tahoma", Font.BOLD, 16));
		back.setBounds(441, 301, 126, 39);
		contentPane.add(back);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 205, 421, 33);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(loginAdmin.class.getResource("/qems/login Background.PNG")));
		lblNewLabel.setBounds(0, 0, 784, 393);
		contentPane.add(lblNewLabel);
	}
}
