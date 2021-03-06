import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Repair extends JFrame {
	
	public JFrame frame;
	Connection con= null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	private JTable table;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Repair frame = new Repair();
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
	public Repair() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE/*JFrame.EXIT_ON_CLOSE*/);
		setBounds(100, 100, 761, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * frame = new JFrame(); frame.setBounds(100, 100, 746, 458);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * frame.getContentPane().setLayout(null);
		 */
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(299, 140, 211, 35);
		contentPane.add(comboBox);
		try {
			con=DB_Connection.getConnection();
			String query2= "Select distinct skill from repair_skills";
			pst=con.prepareStatement(query2);
			rs=pst.executeQuery();
			while(rs.next()) {
				comboBox.addItem(rs.getString("skill"));
			}
					
		} catch (Exception ex) {
			JOptionPane.showInputDialog(this, ex.getMessage());
		}
		
		JLabel lblNewLabel = new JLabel("Find the Names and Numbers of Maintenance Workers Near You!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(114, 33, 532, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Skill Needed");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(210, 150, 79, 15);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(299, 94, 211, 35);
		contentPane.add(comboBox_1);
		try {
			con=DB_Connection.getConnection();
			String query = "Select distinct l_name from loc_month";
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				comboBox_1.addItem(rs.getString("l_name"));
			}
			
		} catch (Exception e) {
			JOptionPane.showInputDialog(this, e.getMessage());
		}
		
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String queryo= "Select r_id, name, rating, shop, contact from view_repair2 where l_id=? AND skill=?";
					con=DB_Connection.getConnection();
					pst=con.prepareStatement(queryo);
					pst.setString(1, (String)comboBox_1.getSelectedItem());
					pst.setString(2,  (String)comboBox.getSelectedItem());
					rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e) {
					JOptionPane.showInputDialog(this, e.getMessage());
				}
			}
		});
		btnNewButton.setBounds(320, 197, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel_2 = new JLabel("Location");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(213, 104, 72, 25);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 250, 665, 135);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}

}
