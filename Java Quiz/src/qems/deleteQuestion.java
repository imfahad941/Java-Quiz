package qems;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import Project.ConnectionProvider;
import javax.swing.ImageIcon;
public class deleteQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField qid;
	private JTextField opt1;
	private JTextField opt2;
	private JTextField opt3;
	private JTextField opt4;
	private JTextField answer;
	private JTextArea question;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteQuestion frame = new deleteQuestion();
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
	public deleteQuestion() {
		setTitle("Delete Question");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Question ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 49, 142, 25);
		contentPane.add(lblNewLabel);
		
		qid = new JTextField();
		qid.setBounds(175, 49, 131, 25);
		contentPane.add(qid);
		qid.setColumns(10);
		
		JButton search = new JButton("Search");
		search.setIcon(new ImageIcon(deleteQuestion.class.getResource("/qems/search.png")));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = qid.getText();
				try
				{
					Connection con =ConnectionProvider.getCon();
					Statement st=con.createStatement();
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
		search.setFont(new Font("Tahoma", Font.BOLD, 16));
		search.setBounds(332, 49, 131, 23);
		contentPane.add(search);
		
		JLabel lblNewLabel_1 = new JLabel("Question :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(32, 97, 120, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Option 1 :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(32, 141, 120, 33);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Option 2 :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(32, 185, 120, 33);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Option 3 :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(32, 229, 120, 33);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Option 4 :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_4.setBounds(32, 284, 120, 33);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Answer :");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_5.setBounds(32, 335, 120, 33);
		contentPane.add(lblNewLabel_1_5);
		
		JButton delete = new JButton("Delete");
		delete.setIcon(new ImageIcon(deleteQuestion.class.getResource("/qems/delete Question.png")));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=qid.getText();
				
				try
				{
					Connection con =ConnectionProvider.getCon();
					PreparedStatement ps=con.prepareStatement("delete from question where id=?");
					ps.setString(1, id);
					ps.executeUpdate();
					
					JFrame frame =new JFrame();
					frame.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(frame, "Successfully Deleted");
					setVisible(false);
					new deleteQuestion().setVisible(true);
				}
				catch(Exception ex)
				{
					JFrame frame =new JFrame();
					frame.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(frame, ex);
					
				}
				
			}
		});
		delete.setFont(new Font("Tahoma", Font.BOLD, 16));
		delete.setBounds(272, 382, 163, 53);
		contentPane.add(delete);
		
		opt1 = new JTextField();
		opt1.setColumns(10);
		opt1.setBounds(175, 141, 610, 25);
		contentPane.add(opt1);
		
		opt2 = new JTextField();
		opt2.setColumns(10);
		opt2.setBounds(175, 185, 610, 25);
		contentPane.add(opt2);
		
		opt3 = new JTextField();
		opt3.setColumns(10);
		opt3.setBounds(175, 229, 610, 25);
		contentPane.add(opt3);
		
		opt4 = new JTextField();
		opt4.setColumns(10);
		opt4.setBounds(175, 278, 610, 25);
		contentPane.add(opt4);
		
		answer = new JTextField();
		answer.setColumns(10);
		answer.setBounds(175, 335, 610, 25);
		contentPane.add(answer);
		
		question = new JTextArea();
		question.setBounds(175, 85, 610, 42);
		contentPane.add(question);
		
		JButton clear = new JButton("Clear");
		clear.setIcon(new ImageIcon(deleteQuestion.class.getResource("/qems/clear.png")));
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
		clear.setBounds(498, 382, 163, 53);
		contentPane.add(clear);
	}
}
