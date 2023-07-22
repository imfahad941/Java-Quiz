package qems;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import Project.*
;public class studentDetail extends JFrame {

	private JPanel contentPane;
	private JTextField rollno;
	private JTextField name;
	private JTextField contact;
	private JTextField email;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentDetail frame = new studentDetail();
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
	public studentDetail() {
		setTitle("Student Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Roll No :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 35, 80, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(10, 69, 80, 28);
		contentPane.add(lblName);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGender.setBounds(10, 107, 80, 28);
		contentPane.add(lblGender);
		
		JLabel lblContactNo = new JLabel("Contact No :");
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContactNo.setBounds(10, 146, 107, 28);
		contentPane.add(lblContactNo);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(10, 190, 80, 28);
		contentPane.add(lblEmail);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Others"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(117, 107, 94, 22);
		contentPane.add(comboBox);
		
		rollno = new JTextField();
		rollno.setBounds(117, 35, 221, 26);
		contentPane.add(rollno);
		rollno.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(117, 69, 254, 26);
		contentPane.add(name);
		
		contact = new JTextField();
		contact.setColumns(10);
		contact.setBounds(117, 146, 254, 26);
		contentPane.add(contact);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(117, 190, 254, 26);
		contentPane.add(email);
		
		JTextArea txtrExaminationManagementSystem = new JTextArea();
		txtrExaminationManagementSystem.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtrExaminationManagementSystem.setText(" Examination Management System is managing all \r\n the activities related to examination management \r\n right from receipt of Enrollment Forms and \r\n Examination Forms through the processing of \r\n Results and Certificates and Grading Reports.\r\n\r\n\r\n Thank You :)");
		txtrExaminationManagementSystem.setBounds(411, 35, 446, 181);
		contentPane.add(txtrExaminationManagementSystem);
		
		JButton save = new JButton("Save & Next");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rollNo =rollno.getText();
				String Name =name.getText();
				String gender = (String)comboBox.getSelectedItem();
				String contactno =contact.getText();
				String Email =email.getText();
				String marks="0";
				
				try
				{
					Connection con =ConnectionProvider.getCon();
					PreparedStatement ps =con.prepareStatement("insert into student values(?,?,?,?,?,?)");
					ps.setString(1, rollNo);
					ps.setString(2, Name);
					ps.setString(3, gender);
					ps.setString(4, contactno);
					ps.setString(5, Email);
					ps.setString(6, marks);
					
					ps.executeUpdate();
					JOptionPane.showInternalMessageDialog(null, "Successfully Saved");
					new instructionStudent(rollNo).setVisible(true);
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
				
			}
		});
		save.setFont(new Font("Tahoma", Font.PLAIN, 18));
		save.setBounds(326, 242, 189, 34);
		contentPane.add(save);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(studentDetail.class.getResource("/qems/pages background student.jpg")));
		lblNewLabel_1.setBounds(0, 11, 874, 278);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(studentDetail.class.getResource("/qems/index background.png")));
		lblNewLabel_2.setBounds(0, 310, 874, 240);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(636, 254, 116, 22);
		contentPane.add(btnNewButton);
	}
}
