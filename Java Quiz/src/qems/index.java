package qems;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class index extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
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
	public index() {
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton student = new JButton("Student");
		student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new studentDetail().setVisible(true);
			}
		});
		student.setIcon(new ImageIcon(index.class.getResource("/qems/index student.png")));
		student.setFont(new Font("Tahoma", Font.BOLD, 15));
		student.setBounds(156, 130, 212, 76);
		contentPane.add(student);
		
		JButton admin = new JButton("Admin");
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new loginAdmin().setVisible(true);
			}
		});
		admin.setIcon(new ImageIcon(index.class.getResource("/qems/index admin.png")));
		admin.setFont(new Font("Tahoma", Font.BOLD, 15));
		admin.setBounds(496, 130, 212, 76);
		contentPane.add(admin);
		
		JLabel lblNewLabel = new JLabel("Welcome ");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(271, 11, 257, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(index.class.getResource("/qems/index background.png")));
		lblNewLabel_1.setBounds(0, 0, 784, 380);
		contentPane.add(lblNewLabel_1);
	}
}
