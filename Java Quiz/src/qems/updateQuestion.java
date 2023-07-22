package qems;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import Project.*
;
import javax.swing.ImageIcon;public class updateQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField opt1;
	private JTextField opt2;
	private JTextField opt3;
	private JTextField opt4;
	private JTextArea question;
	private JTextField answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateQuestion frame = new updateQuestion();
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
	public updateQuestion() {
		setTitle("Update Question");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Question ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 30, 133, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Question :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(35, 93, 108, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Option 1  :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(35, 149, 108, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Option 2 :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(35, 190, 108, 40);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Option 3:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(35, 232, 108, 40);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Option 4 :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(35, 274, 108, 40);
		contentPane.add(lblNewLabel_1_4);
		
		JTextField qid = new JTextField("");
		qid.setFont(new Font("Tahoma", Font.BOLD, 16));
		qid.setBounds(197, 39, 96, 31);
		contentPane.add(qid);
		
		JButton search = new JButton("Search");
		search.setIcon(new ImageIcon(updateQuestion.class.getResource("/qems/search.png")));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = qid.getText();
				
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st =con.createStatement();
					ResultSet rs =st.executeQuery("select *from question where id='"+id+"'");
					if(rs.next())
					{
						question.setText(rs.getString(2));
						opt1.setText(rs.getString(3));
						opt2.setText(rs.getString(4));
						opt3.setText(rs.getString(5));
						opt4.setText(rs.getString(6));
						answer.setText(rs.getString(7));
						
						qid.setEditable(false);
					}
					else
					{
						JFrame frame =new JFrame();
						frame.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(frame, "Question id does not exist!!");
					}
				}
				catch(Exception ex)
				{
					JFrame frame =new JFrame();
					frame.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(frame, ex);
				}
			}
			
		});
		search.setFont(new Font("Tahoma", Font.BOLD, 18));
		search.setBounds(359, 43, 154, 27);
		contentPane.add(search);
		
		 question = new JTextArea();
		question.setBounds(173, 81, 650, 59);
		contentPane.add(question);
		
		opt1 = new JTextField();
		opt1.setBounds(173, 157, 650, 31);
		contentPane.add(opt1);
		opt1.setColumns(10);
		
		opt2 = new JTextField();
		opt2.setColumns(10);
		opt2.setBounds(173, 198, 650, 31);
		contentPane.add(opt2);
		
		opt3 = new JTextField();
		opt3.setColumns(10);
		opt3.setBounds(173, 240, 650, 31);
		contentPane.add(opt3);
		
		opt4 = new JTextField();
		opt4.setColumns(10);
		opt4.setBounds(173, 282, 650, 31);
		contentPane.add(opt4);
		
		JButton update = new JButton("Update");
		update.setIcon(new ImageIcon(updateQuestion.class.getResource("/qems/Update Question.png")));
		update.addActionListener(new ActionListener() {
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
					PreparedStatement ps =con.prepareStatement("update question set name=?,opt1=?,opt2=?,opt3=?,opt4=?,answer=? where id=?");
					ps.setString(1, ques);
					ps.setString(2, option1);
					ps.setString(3, option2);
					ps.setString(4, option3);
					ps.setString(5, opion4);
					ps.setString(6, ans);
					ps.setString(7, id);
					
					ps.executeUpdate();
					
					JFrame frame =new JFrame();
					frame.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(frame, "Suucessfully Updated");
					setVisible(false);
					new updateQuestion().setVisible(true);
					
					
					
				}
				catch(Exception ex)
				{
					JFrame frame =new JFrame();
					frame.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(frame, ex);
					
					
				}
			}
		});
		update.setFont(new Font("Tahoma", Font.BOLD, 16));
		update.setBounds(277, 380, 179, 59);
		contentPane.add(update);
		
		JButton clear = new JButton("Clear");
		clear.setIcon(new ImageIcon(updateQuestion.class.getResource("/qems/clear.png")));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				qid.setText("");
				question.setText("");
				opt1.setText("");
				opt2.setText("");
				opt3.setText("");
				opt4.setText("");
				answer.setText("");
				qid.setEditable(true);
				
			}
		});
		clear.setFont(new Font("Tahoma", Font.BOLD, 16));
		clear.setBounds(574, 380, 179, 59);
		contentPane.add(clear);
		
		JLabel ans_label = new JLabel("Answer");
		ans_label.setFont(new Font("Tahoma", Font.BOLD, 18));
		ans_label.setBounds(35, 325, 108, 40);
		contentPane.add(ans_label);
		
		answer = new JTextField();
		answer.setColumns(10);
		answer.setBounds(173, 324, 650, 31);
		contentPane.add(answer);
	}

}
