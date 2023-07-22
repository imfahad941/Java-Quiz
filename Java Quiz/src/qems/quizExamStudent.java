package qems;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.sql.*;
import Project.*;
import javax.swing.*;
import java.awt.*;

public class quizExamStudent extends JFrame {

	private JPanel contentPane;
	public String questionId="1";
	public String answer;
	public int min=0;
	public int sec=0;
	public int marks=0;
	Timer time;
	JRadioButton radiobtn1,radiobtn2,radiobtn3,radiobtn4;
	JButton next,submitbtn;
	JLabel q_no,question;
	private JLabel lblNewLabel_1;
	private JLabel rollno;
	public static String Rollno;
	ButtonGroup bg;
	
	
	
	public void answerCheck()
	{
		String studentAnswer="";
		if(radiobtn1.isSelected())
		{
			studentAnswer=radiobtn1.getText();
		}
		else if(radiobtn2.isSelected())
		{
			studentAnswer=radiobtn2.getText();
		}
		else if(radiobtn3.isSelected())
		{
			studentAnswer=radiobtn3.getText();
		}
		else if(radiobtn4.isSelected())
		{
			studentAnswer=radiobtn4.getText();
		}
		
		
		if(studentAnswer.equals(answer))
		{
			marks=marks+1;
			String marks1=String.valueOf(marks);
		}
		
		
		//question number change
		
		int qid =Integer.parseInt(questionId);
		qid=qid+1;
		bg.clearSelection();
		questionId=String.valueOf(qid);
		
		//For last question
		
		if(questionId.equals("10"))
		{
			next.setVisible(false);
		}
		
	}
	
	public void question()
	{
		
		try
		{
			Connection con = ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs =st.executeQuery("select *from question where id='"+questionId+"'");
			while(rs.next())
			{
				q_no.setText(rs.getString(1));
				question.setText(rs.getString(2));
				radiobtn1.setText(rs.getString(3));
				radiobtn2.setText(rs.getString(4));
				radiobtn3.setText(rs.getString(5));
				radiobtn4.setText(rs.getString(6));
				answer=rs.getString(7);
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	
	public void submit()
	{
		
		answerCheck();
		try
		{
			Connection con =ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("update student set marks='"+marks+"' where rollNo='"+Rollno+"' ");
			String marks1 =String.valueOf(marks);
			
			
			setVisible(false);
			new successfullySubmited(marks1).setVisible(true);
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quizExamStudent frame = new quizExamStudent(Rollno);
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
	public quizExamStudent(String rollNo) {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(quizExamStudent.class.getResource("/qems/index student.png")));
		setForeground(new Color(0, 0, 0));
		setTitle("Quiz");
		this.Rollno = rollNo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total Time :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(650, 11, 115, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblMinutes = new JLabel("10 Minutes");
		lblMinutes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMinutes.setBounds(769, 11, 115, 31);
		contentPane.add(lblMinutes);
		
		JLabel lblTotalTaken = new JLabel("Time Taken :");
		lblTotalTaken.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalTaken.setBounds(650, 53, 127, 31);
		contentPane.add(lblTotalTaken);
		
		JLabel minute = new JLabel("00 ");
		minute.setForeground(Color.RED);
		minute.setFont(new Font("Tahoma", Font.BOLD, 18));
		minute.setBounds(779, 53, 37, 31);
		contentPane.add(minute);
		
		q_no = new JLabel("1 .");
		q_no.setFont(new Font("Tahoma", Font.BOLD, 18));
		q_no.setBounds(10, 86, 37, 31);
		contentPane.add(q_no);
		
		question = new JLabel("Demo");
		question.setFont(new Font("Tahoma", Font.BOLD, 18));
		question.setBounds(57, 80, 474, 42);
		contentPane.add(question);
		
		radiobtn1 = new JRadioButton("New radio button");
		radiobtn1.setFont(new Font("Tahoma", Font.BOLD, 14));
		radiobtn1.setBounds(57, 132, 194, 42);
		contentPane.add(radiobtn1);
		
		radiobtn2 = new JRadioButton("New radio button");
		radiobtn2.setFont(new Font("Tahoma", Font.BOLD, 14));
		radiobtn2.setBounds(57, 185, 194, 42);
		contentPane.add(radiobtn2);
		
		radiobtn3 = new JRadioButton("New radio button");
		radiobtn3.setFont(new Font("Tahoma", Font.BOLD, 14));
		radiobtn3.setBounds(57, 241, 194, 42);
		contentPane.add(radiobtn3);
		
		radiobtn4 = new JRadioButton("New radio button");
		radiobtn4.setFont(new Font("Tahoma", Font.BOLD, 14));
		radiobtn4.setBounds(57, 293, 194, 42);
		contentPane.add(radiobtn4);
		
		bg =new ButtonGroup();
		bg.add(radiobtn1);
		bg.add(radiobtn2);
		bg.add(radiobtn3);
		bg.add(radiobtn4);
		
		next = new JButton("Next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answerCheck();
				question();
			}
		});
		next.setFont(new Font("Tahoma", Font.BOLD, 16));
		next.setBounds(276, 370, 102, 36);
		contentPane.add(next);
		
		submitbtn = new JButton("Submit");
		submitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a =JOptionPane.showConfirmDialog(null, "Do you Really want to Submit?");
				if(a==0)
				{
					answerCheck();
					submit();
				}
			}
		});
		submitbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		submitbtn.setBounds(555, 370, 102, 36);
		contentPane.add(submitbtn);
		
		JLabel seconds = new JLabel("00");
		seconds.setForeground(Color.RED);
		seconds.setFont(new Font("Tahoma", Font.BOLD, 18));
		seconds.setBounds(837, 53, 37, 31);
		contentPane.add(seconds);
		
		lblNewLabel_1 = new JLabel("Roll No :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(27, 11, 81, 31);
		contentPane.add(lblNewLabel_1);
		
		rollno = new JLabel("Roll No :");
		rollno.setFont(new Font("Tahoma", Font.BOLD, 18));
		rollno.setBounds(111, 11, 81, 31);
		contentPane.add(rollno);
		
		JLabel seconds_1 = new JLabel(":");
		seconds_1.setForeground(Color.RED);
		seconds_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		seconds_1.setBounds(814, 53, 15, 31);
		contentPane.add(seconds_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(quizExamStudent.class.getResource("/qems/pages background student.jpg")));
		lblNewLabel_2.setBounds(0, 11, 884, 450);
		contentPane.add(lblNewLabel_2);
		
		//Setting questions and options with question number
		
		try
		{
			Connection con = ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs =st.executeQuery("select *from question where id='"+questionId+"'");
			while(rs.next())
			{
				q_no.setText(rs.getString(1));
				question.setText(rs.getString(2));
				radiobtn1.setText(rs.getString(3));
				radiobtn2.setText(rs.getString(4));
				radiobtn3.setText(rs.getString(5));
				radiobtn4.setText(rs.getString(6));
				answer=rs.getString(7);
			}
			
			ResultSet rs1 =st.executeQuery("select *from student where rollNo='"+Rollno+"' ");
			while(rs1.next())
			{
				rollno.setText(rs1.getString(1));
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		//Time Program
		setLocationRelativeTo(this);
		 time=new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seconds.setText(String.valueOf(sec));
				minute.setText(String.valueOf(min));
				
				if(sec==60)
				{
					sec=0;
					min++;
					
					if(min==10)   
					{
						time.stop();
						answerCheck();
						submit();
						setVisible(false);
					}
				}
				sec++;
				
			}
		});
		 
		time.start();
	}
}
