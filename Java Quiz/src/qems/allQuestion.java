package qems;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.sql.*;
import Project.*;

import net.proteanit.sql.*;


public class allQuestion extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allQuestion frame = new allQuestion();
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
	public allQuestion() {
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		setTitle("All Questions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);*/
		
		
		JFrame f=new JFrame();    
		    /*String data[][]={ {"101","Amit","670000"},    
		                          {"102","Jai","780000"},    
		                          {"101","Sachin","700000"}};    
		    String column[]={"ID","NAME","SALARY"};      */   
		    JTable jt=new JTable();    
		   /* jt.setModel(new DefaultTableModel(
		    	new Object[][] {
		    		{null, null, null, null, null, "", null},
		    		{null, null, null, null, null, null, null},
		    		{null, null, null, null, null, null, null},
		    		{null, null, null, null, null, null, null},
		    		{null, null, null, null, null, null, null},
		    	},
		    	new String[] {
		    		"ID", "Question", "Option 1", "Option 2", "Option 3", "Option 4", "Answer"
		    	}
		    ) {
		    	Class[] columnTypes = new Class[] {
		    		String.class, String.class, String.class, String.class, String.class, String.class, String.class
		    	};
		    	public Class getColumnClass(int columnIndex) {
		    		return columnTypes[columnIndex];
		    	}
		    });*/
		    jt.setBounds(30,80,200,300);          
		    JScrollPane sp=new JScrollPane(jt);    
		    f.getContentPane().add(sp);          
		    f.setSize(900,500);    
		    f.setVisible(true);    
		    
		    
		    try
		    {
		    	Connection con=ConnectionProvider.getCon();
		    	Statement st =con.createStatement();
		    	ResultSet rs=st.executeQuery("select *from question");
		    	jt.setModel(DbUtils.resultSetToTableModel(rs));
		    }
		    catch(Exception e)
		    {
		    	JOptionPane.showMessageDialog(null, e);
		    	
		    }
		    
		    
	}
}
