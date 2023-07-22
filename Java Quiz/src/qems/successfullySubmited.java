package qems;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class successfullySubmited extends JFrame {

	private JPanel contentPane;
	public JLabel markslabel;
	public String Marks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					successfullySubmited frame = new successfullySubmited("Marks");
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
	public successfullySubmited(String marks) {
		
		
		
		setTitle("Marks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		markslabel = new JLabel("Marks Obtained : 10");
		markslabel.setFont(new Font("Tahoma", Font.BOLD, 48));
		markslabel.setBounds(168, 121, 706, 67);
		contentPane.add(markslabel);
		
		
	this.Marks ="Marks Obtained :"+marks;
	markslabel.setText(Marks);
	
		
		JLabel lblSuccessfullyUpdated = new JLabel("Successfully Updated");
		lblSuccessfullyUpdated.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblSuccessfullyUpdated.setBounds(168, 208, 527, 67);
		contentPane.add(lblSuccessfullyUpdated);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(successfullySubmited.class.getResource("/qems/pages background student.jpg")));
		lblNewLabel.setBounds(0, 56, 884, 292);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(successfullySubmited.class.getResource("/qems/index background.png")));
		lblNewLabel_1.setBounds(0, 0, 884, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(successfullySubmited.class.getResource("/qems/index background.png")));
		lblNewLabel_1_1.setBounds(0, 348, 884, 113);
		contentPane.add(lblNewLabel_1_1);
	}

}
