package qems;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class adminHome extends JFrame {
	public static int open=0;
	private JPanel contentPane;
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminHome frame = new adminHome();
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
	public adminHome() {
		setTitle("Admin Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(377, 10, 2, 2);
		contentPane.add(scrollPane);
		
		JButton btn_add_ques = new JButton("Add New Question");
		btn_add_ques.setForeground(Color.ORANGE);
		btn_add_ques.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					new addNewQuestion().setVisible(true);
					
			}
		});
		btn_add_ques.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_add_ques.setBounds(10, 104, 198, 44);
		contentPane.add(btn_add_ques);
		
		JButton btn_update_ques = new JButton("Update Question");
		btn_update_ques.setForeground(Color.ORANGE);
		btn_update_ques.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new updateQuestion().setVisible(true);
			}
		});
		btn_update_ques.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_update_ques.setBounds(264, 104, 198, 44);
		contentPane.add(btn_update_ques);
		
		JButton btn_all_ques = new JButton("All Questions");
		btn_all_ques.setForeground(Color.ORANGE);
		btn_all_ques.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new allQuestion().setVisible(true);
			}
		});
		btn_all_ques.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_all_ques.setBounds(512, 104, 198, 44);
		contentPane.add(btn_all_ques);
		
		JButton btn_delete_ques = new JButton("Delete Question");
		btn_delete_ques.setForeground(Color.ORANGE);
		btn_delete_ques.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new deleteQuestion().setVisible(true);
			}
		});
		btn_delete_ques.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_delete_ques.setBounds(149, 185, 198, 44);
		contentPane.add(btn_delete_ques);
		
		JButton btn_result = new JButton("Result");
		btn_result.setForeground(Color.ORANGE);
		btn_result.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new allStudentResult().setVisible(true);
			}
		});
		btn_result.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_result.setBounds(404, 185, 198, 44);
		contentPane.add(btn_result);
		
		JButton logout = new JButton("Logout");
		logout.setForeground(Color.ORANGE);
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame =new JFrame();
				frame.setAlwaysOnTop(true);
				int a = JOptionPane.showConfirmDialog(frame,"Do you Really want to Logout?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					setVisible(false);
					new loginAdmin().setVisible(true);
				}
			}
		});
		logout.setFont(new Font("Tahoma", Font.BOLD, 16));
		logout.setBounds(294, 274, 198, 44);
		contentPane.add(logout);
		
		JLabel lblNewLabel = new JLabel("ADMIN HOME");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 41));
		lblNewLabel.setBounds(229, 24, 290, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(adminHome.class.getResource("/qems/index background.png")));
		lblNewLabel_1.setBounds(0, -2, 757, 370);
		contentPane.add(lblNewLabel_1);
	}

}
