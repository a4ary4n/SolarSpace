import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.lang.Object;

import org.jfree.chart.ChartFrame;

import org.jfree.data.general.DefaultPieDataset;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;


public class Dashboard_Form extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String username;
	Connection con= null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String txt;
	float txt2;
	float txt3;
	
	int num;
	double p_gen;
	double p_consumed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String username = " ";
					Dashboard_Form frame = new Dashboard_Form(username);
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
	public Dashboard_Form(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1118, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(431, 28, 102, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Sign Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login_Form login = new Login_Form();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBounds(494, 422, 152, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Generate Report");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Generate_pdf rep = new Generate_pdf();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.setBounds(303, 422, 152, 51);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Looking for \r\nRepairs?");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Repair_Page repair_page = new Repair_Page();
				Repair repair_page = new Repair();
				repair_page.setVisible(true);
				repair_page.setLocationRelativeTo(null);
				
			}
		});
		btnNewButton_2.setBounds(689, 422, 152, 51);
		contentPane.add(btnNewButton_2);
		
		table = new JTable();
		table.setBounds(101, 144, 199, -71);
		contentPane.add(table);
		
		
		try {
			String query = "Select first_name from solarspace.user where username=?";
			con = DB_Connection.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, username);
			rs=pst.executeQuery();
			if(rs.next()) {
				txt = rs.getString(1);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
		
		JLabel lblNewLabel_1 = new JLabel(txt);
		lblNewLabel_1.setBackground(Color.GREEN);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1.setBounds(533, 25, 152, 34);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(451, 94, 195, 34);
		contentPane.add(comboBox);
		try {
			PreparedStatement pst2;
			ResultSet rs5;
			String query2="Select * from spanel_user where uname=?";
			con=DB_Connection.getConnection();
			pst2=con.prepareStatement(query2);
			pst2.setString(1, username);
			rs5=pst2.executeQuery();
			while(rs5.next()) {
				int abe = rs5.getInt("sid");
				comboBox.addItem(abe);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		JLabel lblNewLabel_2 = new JLabel("Choose Solar Panel");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(283, 95, 158, 38);
		contentPane.add(lblNewLabel_2);
		
		
		
		JTextField lblNewLabel_3 = new JTextField();
		lblNewLabel_3.setText("Solar Panel "+comboBox.getSelectedItem()+" generated "+txt2+" kilowatt hours in the last 12 months");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(283, 144, 513, 21);
		contentPane.add(lblNewLabel_3);
		String txt4;
		
		
		
		JTextField lblNewLabel_4 = new JTextField();
		lblNewLabel_4.setText("Your solar panel  its peers by "+txt3+ " kilowatt-hours.");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(283, 176, 513, 24);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("%age Power consumed coming from Solar Panels");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				PreparedStatement pss3;
				PreparedStatement pss4;
				PreparedStatement pss5;
				ResultSet rss3;
				ResultSet rss4;
				
				String query6 = "Select sum(power*quantity)*12 as tot_power from view1 where username=?";
				String query7 = "Select sum(actual_power) from panel_month where pid in (Select sid from spanel_user where uname=?)";
				con = DB_Connection.getConnection();
				
				pss4=con.prepareStatement(query6);
				pss4.setString(1,username);
				rss3=pss4.executeQuery();
				pss5=con.prepareStatement(query7);
				pss5.setString(1, username);
				rss4=pss5.executeQuery();
				if(rss3.next()) {
					p_gen=rss3.getDouble(1);
					
				}
				if(rss4.next()) {
					p_consumed=rss4.getDouble(1);
				}
				
				DefaultPieDataset data = new DefaultPieDataset();
				double val = p_gen - p_consumed;
					
					/*
					 * if(val < 0) { val=p_gen; } else { val=p_consumed-p_gen; }
					 */
					
				data.setValue("Power Coming from outside", val);
				data.setValue("Power Generated by Solar Panels", p_gen);
				JFreeChart chart = ChartFactory.createPieChart(
			            "Share of Power Coming From Solar Panels",
			            data,
			            true, 
			            true,
			            false
			        );
				ChartFrame frame = new ChartFrame("First", chart);
		        frame.pack();
		        frame.setVisible(true);
				
			} catch (Exception e) {
				JOptionPane.showInputDialog(this, e.getMessage());
			}}
		});
		btnNewButton_3.setBounds(406, 302, 363, 40);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Comparing Efficiency of your Solar Panels");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PreparedStatement pss6;
					PreparedStatement pss7;
					DefaultCategoryDataset data2 = new DefaultCategoryDataset();
					
					
					
					String query14= "Select pid, pow2/pow as eff from solarspace.view4 where pid in (select sid from solarspace.spanel_user where uname = ?)";
					con=DB_Connection.getConnection();
					
					
					
					PreparedStatement pss9=con.prepareStatement(query14);
					pss9.setString(1, username);
					rs=pss9.executeQuery();
					
					while(rs.next()) {
						double newval = rs.getDouble("eff");
						String pidd = Integer.toString(rs.getInt("pid"));
						data2.setValue(newval, "Efficiency", pidd);
					}
					JFreeChart chart2 = ChartFactory.createBarChart("Efficiency of Solar Panels", "Panel ID", "Efficiency", data2);
					CategoryPlot p =chart2.getCategoryPlot();
					p.setRangeGridlinePaint(Color.BLACK);
					ChartFrame frame = new ChartFrame("Monthly Power Generated", chart2);
					frame.setVisible(true);
					frame.setSize(900, 700);
					
									
				} catch (Exception e) {
					JOptionPane.showInputDialog(this, e.getMessage());
				}
			}
		});
		btnNewButton_4.setBounds(406, 353, 363, 40);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_7 = new JButton("Check");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement pss;
				PreparedStatement pss2;
				ResultSet rss;
				ResultSet rss2;
				String txt4;
				num = (int)comboBox.getSelectedItem();
				try {
				String query3="Select sum(actual_power) as poww from panel_month where pid=?";
				String query4="Select avg(actual_power)*12 as poww2 from panel_month where pid in (Select sid from spanel_user where lname IN (Select lname from spanel_user where sid=?))";
				con=DB_Connection.getConnection();
				pss=con.prepareStatement(query3);
				pss2=con.prepareStatement(query4);
				pss.setInt(1, num);
				pss2.setInt(1, num);
				rss=pss.executeQuery();
				rss2=pss2.executeQuery();
				if(rss.next()) {
					txt2=rss.getFloat("poww");
				}
				if(rss2.next()) {
					txt3=rss2.getFloat("poww2");
				}
				
				if(txt3>=txt2) {
		            
					txt4="Under-performed";
				}
				else { 
					
					txt4="Over-performed";}
				
				lblNewLabel_3.setText("Solar Panel "+comboBox.getSelectedItem()+" generated "+txt2+" kilowatt hours in the last 12 months");
				lblNewLabel_4.setText("Your solar panel "+txt4+" its peers by "+txt3+ " kilowatt-hours.");
				
			} catch (Exception ex) {
				JOptionPane.showInputDialog(this, ex.getMessage());
			}
			}
		}) ;
		
		btnNewButton_7.setBounds(656, 100, 89, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_5 = new JButton("See Monthly Power Generation");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				double value;
				String monthname;
				PreparedStatement psnew;
				ResultSet rsnew;
				DefaultCategoryDataset datasett = new DefaultCategoryDataset();
				String queryx="Select * from panel_month where pid = ?";
				con=DB_Connection.getConnection();
				psnew=con.prepareStatement(queryx);
				psnew.setInt(1,(int)comboBox.getSelectedItem());
				rsnew=psnew.executeQuery();
				while(rsnew.next()) {
					value=rsnew.getDouble("actual_power");
					monthname=rsnew.getString("month");
					datasett.setValue(value, "Power Generated", monthname);
				}
				JFreeChart chart2 = ChartFactory.createBarChart("Monthly Power Generated by Solar Panel", "Month", "Power in KWh", datasett);
				CategoryPlot p =chart2.getCategoryPlot();
				p.setRangeGridlinePaint(Color.BLACK);
				ChartFrame frame = new ChartFrame("Monthly Power Generated", chart2);
				frame.setVisible(true);
				frame.setSize(900, 700);
						
			} catch (Exception e) {
				JOptionPane.showInputDialog(this, e.getMessage());
				}
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_5.setBounds(406, 247, 363, 40);
		contentPane.add(btnNewButton_5);
	}}
