package qems;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.sql.*;
import Project.*;
import net.proteanit.sql.DbUtils;

public class allStudentResult extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allStudentResult frame = new allStudentResult();
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
	public allStudentResult() {
		JFrame f=new JFrame();     
		f.setTitle("Result");
	    JTable jt=new JTable();    
	  
	    jt.setBounds(30,80,200,300);          
	    JScrollPane sp=new JScrollPane(jt);    
	    f.getContentPane().add(sp);          
	    f.setSize(900,500);    
	    f.setVisible(true);  
		
	    
	    try
	    {
	    	Connection con =ConnectionProvider.getCon();
	    	Statement  st =con.createStatement();
	    	ResultSet rs =st.executeQuery("select *from student");
	    	//jt.setAutoResizeMode(jt.AUTO_RESIZE_OFF);
	    	jt.setModel(DbUtils.resultSetToTableModel(rs));
	    	
	    }
		catch(Exception e)
	    {
			JOptionPane.showMessageDialog(null, e);
	    }
	}
}
