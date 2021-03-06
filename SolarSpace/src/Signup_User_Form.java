import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Signup_User_Form extends JFrame {

	private JPanel contentPane;
	private JTextField tf_firstname;
	private JTextField tf_lastname;
	private JTextField tf_hno;
	private JTextField tf_locality;
	private Choice choiceCity;
	private JTextField tf_city;
	private JTextField tf_pincode;
	private JTextField tf_username;
	private JPasswordField pf_password;
	private JTextField tf_contact;
	
	static String uname = "";
	public static String getUsername() {
		return uname;
	}
	
	static String cname = "";
	public static String getCity() {
		return cname;
	}
	
	public boolean verifyUserFields() {
		String fname = tf_firstname.getText();
		String lname = tf_lastname.getText();
		String hnum = tf_hno.getText();
		String locality = tf_locality.getText();
		String pncd = tf_pincode.getText();
		String u_name = tf_username.getText();
		String pswd = String.valueOf(pf_password.getPassword());
		String contactno = tf_contact.getText();
		
		if (fname.trim().equals("") || lname.trim().equals("") || hnum.trim().equals("") || 
				locality.trim().equals("") || pncd.trim().equals("") || u_name.trim().equals("") ||
				pswd.trim().equals("") || contactno.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "One or More Fields Are Empty");
			return false;
		}
		return true;
	}
	
	public boolean checkUsername(String u_name) {
		PreparedStatement st;
		ResultSet rs;
		boolean exists = false;
		
		try {
			String query = "SELECT * FROM solarspace.user WHERE username = ?";
			st = DB_Connection.getConnection().prepareStatement(query);
			st.setString(1, u_name);
			rs = st.executeQuery();
			
			if (rs.next()) {
				//System.out.println("exists");
				exists = true;
				JOptionPane.showMessageDialog(null, "This Username is Taken, Choose Another One");
			}
		} catch (SQLException err) {
			System.err.println(err);
		}
		
		return exists;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup_User_Form frame = new Signup_User_Form();
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
	public Signup_User_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String cities[] = {"Bengaluru", "Chandigarh", "Chennai", 
				"Dehradun", "Delhi", "Hyderabad", "Jaipur", 
				"Kolkata", "Lucknow", "Mumbai"};
		
		JLabel lbl_firstname = new JLabel("First Name");
		lbl_firstname.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_firstname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_firstname.setBounds(55, 56, 112, 42);
		contentPane.add(lbl_firstname);
		
		JLabel lbl_usersignup = new JLabel("USER SIGN-UP");
		lbl_usersignup.setBounds(210, 10, 138, 22);
		lbl_usersignup.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_usersignup.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lbl_usersignup);
		
		tf_firstname = new JTextField();
		tf_firstname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_firstname.setBounds(224, 57, 282, 42);
		contentPane.add(tf_firstname);
		tf_firstname.setColumns(10);
		
		JLabel lbl_lastname = new JLabel("Last Name");
		lbl_lastname.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_lastname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_lastname.setBounds(55, 108, 112, 42);
		contentPane.add(lbl_lastname);
		
		tf_lastname = new JTextField();
		tf_lastname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_lastname.setColumns(10);
		tf_lastname.setBounds(224, 109, 282, 42);
		contentPane.add(tf_lastname);
		
		JLabel lbl_hno = new JLabel("House No.");
		lbl_hno.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_hno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_hno.setBounds(55, 160, 112, 42);
		contentPane.add(lbl_hno);
		
		tf_hno = new JTextField();
		tf_hno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//numbers only!
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		tf_hno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_hno.setColumns(10);
		tf_hno.setBounds(224, 161, 80, 42);
		contentPane.add(tf_hno);
		
		JLabel lbl_locality = new JLabel("Locality");
		lbl_locality.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_locality.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_locality.setBounds(55, 213, 112, 42);
		contentPane.add(lbl_locality);
		
		tf_locality = new JTextField();
		tf_locality.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_locality.setColumns(10);
		tf_locality.setBounds(224, 214, 282, 42);
		contentPane.add(tf_locality);
		
		JLabel lbl_city = new JLabel("City");
		lbl_city.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_city.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_city.setBounds(55, 265, 112, 22);
		contentPane.add(lbl_city);
		
		choiceCity = new Choice();
		choiceCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		choiceCity.setBounds(224, 265, 226, 42);
		for (int i = 0; i < 10; i++) {
			choiceCity.add(cities[i]);
		}
		contentPane.add(choiceCity);
		
		/*
		 * tf_city = new JTextField(); tf_city.setFont(new Font("Tahoma", Font.PLAIN,
		 * 14)); tf_city.setColumns(10); tf_city.setBounds(224, 266, 282, 42);
		 * contentPane.add(tf_city);
		 */
		
		JLabel lbl_pincode = new JLabel("Pincode");
		lbl_pincode.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_pincode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_pincode.setBounds(55, 297, 112, 42);
		contentPane.add(lbl_pincode);
		
		tf_pincode = new JTextField();
		tf_pincode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//numbers only!
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		tf_pincode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_pincode.setColumns(10);
		tf_pincode.setBounds(224, 298, 282, 42);
		contentPane.add(tf_pincode);
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_username.setBounds(55, 349, 112, 42);
		contentPane.add(lbl_username);
		
		tf_username = new JTextField();
		tf_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_username.setColumns(10);
		tf_username.setBounds(222, 349, 284, 42);
		contentPane.add(tf_username);
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_password.setBounds(55, 401, 112, 42);
		contentPane.add(lbl_password);
		
		pf_password = new JPasswordField();
		pf_password.setToolTipText("");
		pf_password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pf_password.setBounds(222, 401, 284, 42);
		contentPane.add(pf_password);
		
		JLabel lbl_contact = new JLabel("Contact No.");
		lbl_contact.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_contact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_contact.setBounds(55, 453, 112, 42);
		contentPane.add(lbl_contact);
		
		tf_contact = new JTextField();
		tf_contact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//numbers only!
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		tf_contact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_contact.setColumns(10);
		tf_contact.setBounds(222, 453, 284, 42);
		contentPane.add(tf_contact);
		
		JButton btn_toSolar = new JButton("Next");
		btn_toSolar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement st1, st2;
				int rs1 = 0, rs2 = 0;
				
				String f_name = tf_firstname.getText();
				String l_name = tf_lastname.getText();
				int hno = Integer.parseInt(tf_hno.getText());
				String locality = tf_locality.getText();
				String city = choiceCity.getSelectedItem();
				//String city = tf_city.getText().toLowerCase();
				int pincode = Integer.parseInt(tf_pincode.getText());
				String username = tf_username.getText();
				String password = String.valueOf(pf_password.getPassword());
				long contact = Long.parseLong(tf_contact.getText());
				
				uname = username;
				cname = city;
				
				if (verifyUserFields()) {
					if (!checkUsername(username)) {
						String query1 = "INSERT INTO solarspace.user VALUES "
								+ "(?, ?, ?, ?, ?, ?, ?, ?)";
						String query2 = "INSERT INTO solarspace.user_contact VALUES "
								+ "(?, ?)";
						
						try {
							st1 = DB_Connection.getConnection().prepareStatement(query1);
							st1.setString(1, username);
							st1.setString(2, f_name);
							st1.setString(3, l_name);
							st1.setInt(4, hno);
							st1.setString(5, locality);
							st1.setString(6, city);
							st1.setInt(7, pincode);
							st1.setString(8, password);
							rs1 = st1.executeUpdate();
							
							st2 = DB_Connection.getConnection().prepareStatement(query2);
							st2.setString(1, username);
							st2.setLong(2, contact);
							rs2 = st2.executeUpdate();
						} catch (SQLException err) {
							System.err.println(err);
						}
						
						Signup_Solar_Form solar = new Signup_Solar_Form();
						solar.setVisible(true);
						solar.setLocationRelativeTo(null);
						
						//close current page
						dispose();
					}
				}
			}
		});
		btn_toSolar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_toSolar.setBounds(224, 534, 100, 42);
		contentPane.add(btn_toSolar);
	}
}
