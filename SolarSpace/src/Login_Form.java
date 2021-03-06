import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Login_Form extends JFrame {

	private JPanel contentPane;
	private JTextField tf_username;
	private JPasswordField pf_password;
	
	static String uname = "";
	public static String getUsername() {
		return uname;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Form frame = new Login_Form();
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
	public Login_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setLocationRelativeTo(null);
		
		JLabel lblSignin = new JLabel("SIGN-IN");
		lblSignin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignin.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblSignin, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		tf_username = new JTextField();
		tf_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_username.setBounds(132, 27, 284, 42);
		panel.add(tf_username);
		tf_username.setColumns(10);
		
		pf_password = new JPasswordField();
		pf_password.setToolTipText("");
		pf_password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pf_password.setBounds(132, 79, 284, 42);
		panel.add(pf_password);
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_username.setBounds(10, 27, 112, 42);
		panel.add(lbl_username);
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_password.setBounds(10, 79, 112, 42);
		panel.add(lbl_password);
		
		JButton btn_signin = new JButton("Sign-In");
		btn_signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement st;
				ResultSet rs;
				
				//username and password from the form
				String username = tf_username.getText();
				uname = username;
				String password = String.valueOf(pf_password.getPassword());
				
				if (!username.isBlank() && !password.isBlank()) {
					String query = "SELECT * FROM solarspace.user WHERE username = ? AND password = ?";
			        
			        try {
			            st = DB_Connection.getConnection().prepareStatement(query);
			            
			            st.setString(1, username);
			            st.setString(2, password);
			            
			            rs = st.executeQuery();
			            
			            if (rs.next()) {
			                //dashboard
			                Dashboard_Form dashboard = new Dashboard_Form(username);
			                dashboard.setVisible(true);
			                dashboard.setLocationRelativeTo(null);
			                
			                //close the current form
			                dispose();
			                
			            } else {
			                //invalid credentials
			                JOptionPane.showMessageDialog(null, "Invalid username/password", "Login Error", 2);
			            }
			        } catch (SQLException err) {
			        	System.err.println(err);
			        }
				}
				else {
					JOptionPane.showMessageDialog(null, "Username and password must be non-empty", "Empty username/password", 2);
				}
			}
		});
		btn_signin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_signin.setBounds(132, 143, 132, 42);
		panel.add(btn_signin);
		
		JLabel lbl_register = new JLabel("New here? Sign-up!");
		lbl_register.setForeground(Color.BLUE);
		lbl_register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Signup_User_Form reg = new Signup_User_Form();
				reg.setVisible(true);
				reg.setLocationRelativeTo(null);
				//close current page
				dispose();
			}
		});
		lbl_register.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_register.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_register.setBounds(132, 195, 132, 15);
		panel.add(lbl_register);
	}
}
