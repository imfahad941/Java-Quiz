package qems;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.sql.*;
import Project.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class addNewQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField opt1;
	private JTextField opt2;
	private JTextField opt3;
	private JTextField opt4;
	private JTextField answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addNewQuestion frame = new addNewQuestion();
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
	public addNewQuestion() {
		
		
		setForeground(Color.CYAN);
		setTitle("Add Question");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Question ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 29, 139, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Question :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(45, 94, 104, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Option1 :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(45, 139, 104, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Option 2 :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(45, 184, 104, 34);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Option 3 :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(45, 227, 104, 34);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Option 4 :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(45, 267, 104, 34);
		contentPane.add(lblNewLabel_1_4);
		
		JTextArea question = new JTextArea();
		question.setBounds(159, 72, 528, 58);
		contentPane.add(question);
		
		JLabel qid = new JLabel("00");
		qid.setForeground(Color.RED);
		qid.setFont(new Font("Tahoma", Font.BOLD, 18));
		qid.setBounds(178, 33, 70, 28);
		contentPane.add(qid);
		
		opt1 = new JTextField();
		opt1.setBounds(159, 139, 528, 28);
		contentPane.add(opt1);
		opt1.setColumns(10);
		
		opt2 = new JTextField();
		opt2.setColumns(10);
		opt2.setBounds(159, 190, 528, 28);
		contentPane.add(opt2);
		
		opt3 = new JTextField();
		opt3.setColumns(10);
		opt3.setBounds(159, 233, 528, 28);
		contentPane.add(opt3);
		
		opt4 = new JTextField();
		opt4.setColumns(10);
		opt4.setBounds(159, 273, 528, 28);
		contentPane.add(opt4);
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id =qid.getText();
				String ques =question.getText();
				String option1 =opt1.getText();
				String option2 =opt2.getText();
				String option3 =opt3.getText();
				String opion4 =opt4.getText();
				String ans =answer.getText();
				
				try
				{
					Connection con =ConnectionProvider.getCon();
					PreparedStatement ps =con.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
					ps.setString(1, id);
					ps.setString(2, ques);
					ps.setString(3, option1);
					ps.setString(4, option2);
					ps.setString(5, option3);
					ps.setString(6, opion4);
					ps.setString(7, ans);
					
					ps.executeUpdate();
					
					JFrame frame =new JFrame();
					frame.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(frame, "Successfully Update");
					setVisible(false);
					new addNewQuestion().setVisible(true);
				}
				catch (Exception ex) {
					
					JFrame frame =new JFrame();
					frame.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(frame, ex);
					
				}
				
			}
		});
		save.setFont(new Font("Tahoma", Font.BOLD, 16));
		save.setBounds(251, 388, 104, 41);
		contentPane.add(save);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				question.setText("");
				opt1.setText("");
				opt2.setText("");
				opt3.setText("");
				opt4.setText("");
				answer.setText("");
			}
		});
		clear.setFont(new Font("Tahoma", Font.BOLD, 16));
		clear.setBounds(454, 388, 104, 41);
		contentPane.add(clear);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Answer :");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4_1.setBounds(45, 319, 104, 34);
		contentPane.add(lblNewLabel_1_4_1);
		
		answer = new JTextField();
		answer.setColumns(10);
		answer.setBounds(159, 325, 528, 28);
		contentPane.add(answer);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(addNewQuestion.class.getResource("/qems/pages background admin.jpg")));
		lblNewLabel_2.setBounds(0, 23, 884, 438);
		contentPane.add(lblNewLabel_2);
		
		
		
		try
		{
			Connection con =ConnectionProvider.getCon();
			Statement st =con.createStatement();
			ResultSet rs = st.executeQuery("select count(id) from question");
			if(rs.next())
			{
				int id =rs.getInt(1);
				id++;
				String str =String.valueOf(id);
				qid.setText(str);
			}
			else
			{
				qid.setText("1");
			}
		}
		catch(Exception e)
		{
			JFrame frame =new JFrame();
			frame.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(frame, e);
		}
		
		
		
		
	}
}
