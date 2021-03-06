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
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Signup_Solar_Form extends JFrame {

	private JPanel contentPane;
	private JTextField p_ids[] = new JTextField[10];
//	private JTextField tf_panel1;
	private JLabel lbl_quantity;
	private JLabel lbl_solar_reg;
	private JLabel lbl_panel2;
//	private JTextField tf_panel2;
	private JLabel lbl_panel3;
//	private JTextField tf_panel3;
	private JLabel lbl_panel4;
//	private JTextField tf_panel4;
	private JLabel lbl_panel5;
//	private JTextField tf_panel5;
	private JLabel lbl_panel6;
//	private JTextField tf_panel6;
	private JLabel lbl_panel7;
//	private JTextField tf_panel7;
	private JLabel lbl_panel8;
//	private JTextField tf_panel8;
	private JLabel lbl_panel9;
//	private JTextField tf_panel9;
	private JLabel lbl_panel10;
//	private JTextField tf_panel10;
	private JButton btn_toAppliances;
	
	boolean checkPanelAlreadyExists(int pid) {
		PreparedStatement st;
		ResultSet rs;
		boolean exists = false;
		
		try {
			String query = "SELECT * FROM solarspace.spanel_user WHERE sid = ?";
			st = DB_Connection.getConnection().prepareStatement(query);
			st.setInt(1, pid);
			rs = st.executeQuery();
			
			if (rs.next()) {
				exists = true;
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
					Signup_Solar_Form frame = new Signup_Solar_Form();
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
	public Signup_Solar_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int panel_ids[] = new int[10];
		
		JLabel lbl_panel1 = new JLabel("Panel 1 ID");
		lbl_panel1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_panel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_panel1.setBounds(157, 102, 112, 36);
		contentPane.add(lbl_panel1);
		
		p_ids[0] = new JTextField();
		p_ids[0].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String inp = p_ids[0].getText();
				if (inp.compareTo("") != 0) {
					panel_ids[0] = Integer.parseInt(inp);
				}
			}
		});
		p_ids[0].addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//numbers only!
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		p_ids[0].setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_ids[0].setColumns(10);
		p_ids[0].setBounds(314, 100, 45, 42);
		contentPane.add(p_ids[0]);
		
		lbl_quantity = new JLabel("No. of Solar Panels");
		lbl_quantity.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_quantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_quantity.setBounds(126, 53, 143, 36);
		contentPane.add(lbl_quantity);
		
		lbl_solar_reg = new JLabel("SOLAR PANELS REGISTRATION");
		lbl_solar_reg.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_solar_reg.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_solar_reg.setBounds(90, 10, 365, 36);
		contentPane.add(lbl_solar_reg);
		
		JSpinner spinner_quantity = new JSpinner();
		spinner_quantity.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner_quantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner_quantity.setBounds(314, 54, 45, 36);
		contentPane.add(spinner_quantity);
		
		lbl_panel2 = new JLabel("Panel 2 ID");
		lbl_panel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_panel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_panel2.setBounds(157, 150, 112, 36);
		contentPane.add(lbl_panel2);
		
		p_ids[1] = new JTextField();
		p_ids[1].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String inp = p_ids[1].getText();
				if (inp.compareTo("") != 0) {
					panel_ids[1] = Integer.parseInt(inp);
				}
			}
		});
		p_ids[1].addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//numbers only!
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		p_ids[1].setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_ids[1].setColumns(10);
		p_ids[1].setBounds(314, 148, 45, 42);
		contentPane.add(p_ids[1]);
		
		lbl_panel3 = new JLabel("Panel 3 ID");
		lbl_panel3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_panel3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_panel3.setBounds(157, 198, 112, 36);
		contentPane.add(lbl_panel3);
		
		p_ids[2] = new JTextField();
		p_ids[2].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String inp = p_ids[2].getText();
				if (inp.compareTo("") != 0) {
					panel_ids[2] = Integer.parseInt(inp);
				}
			}
		});
		p_ids[2].addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//numbers only!
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		p_ids[2].setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_ids[2].setColumns(10);
		p_ids[2].setBounds(314, 196, 45, 42);
		contentPane.add(p_ids[2]);
		
		lbl_panel4 = new JLabel("Panel 4 ID");
		lbl_panel4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_panel4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_panel4.setBounds(157, 246, 112, 36);
		contentPane.add(lbl_panel4);
		
		p_ids[3] = new JTextField();
		p_ids[3].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String inp = p_ids[3].getText();
				if (inp.compareTo("") != 0) {
					panel_ids[3] = Integer.parseInt(inp);
				}
			}
		});
		p_ids[3].addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//numbers only!
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		p_ids[3].setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_ids[3].setColumns(10);
		p_ids[3].setBounds(314, 244, 45, 42);
		contentPane.add(p_ids[3]);
		
		lbl_panel5 = new JLabel("Panel 5 ID");
		lbl_panel5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_panel5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_panel5.setBounds(157, 294, 112, 36);
		contentPane.add(lbl_panel5);
		
		p_ids[4] = new JTextField();
		p_ids[4].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String inp = p_ids[4].getText();
				if (inp.compareTo("") != 0) {
					panel_ids[4] = Integer.parseInt(inp);
				}
			}
		});
		p_ids[4].addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//numbers only!
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		p_ids[4].setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_ids[4].setColumns(10);
		p_ids[4].setBounds(314, 292, 45, 42);
		contentPane.add(p_ids[4]);
		
		lbl_panel6 = new JLabel("Panel 6 ID");
		lbl_panel6.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_panel6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_panel6.setBounds(157, 342, 112, 36);
		contentPane.add(lbl_panel6);
		
		p_ids[5] = new JTextField();
		p_ids[5].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String inp = p_ids[5].getText();
				if (inp.compareTo("") != 0) {
					panel_ids[5] = Integer.parseInt(inp);
				}
			}
		});
		p_ids[5].addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//numbers only!
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		p_ids[5].setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_ids[5].setColumns(10);
		p_ids[5].setBounds(314, 340, 45, 42);
		contentPane.add(p_ids[5]);
		
		lbl_panel7 = new JLabel("Panel 7 ID");
		lbl_panel7.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_panel7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_panel7.setBounds(157, 390, 112, 36);
		contentPane.add(lbl_panel7);
		
		p_ids[6] = new JTextField();
		p_ids[6].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String inp = p_ids[6].getText();
				if (inp.compareTo("") != 0) {
					panel_ids[6] = Integer.parseInt(inp);
				}
			}
		});
		p_ids[6].addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//numbers only!
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		p_ids[6].setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_ids[6].setColumns(10);
		p_ids[6].setBounds(314, 388, 45, 42);
		contentPane.add(p_ids[6]);
		
		lbl_panel8 = new JLabel("Panel 8 ID");
		lbl_panel8.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_panel8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_panel8.setBounds(157, 438, 112, 36);
		contentPane.add(lbl_panel8);
		
		p_ids[7] = new JTextField();
		p_ids[7].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String inp = p_ids[7].getText();
				if (inp.compareTo("") != 0) {
					panel_ids[7] = Integer.parseInt(inp);
				}
			}
		});
		p_ids[7].addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//numbers only!
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		p_ids[7].setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_ids[7].setColumns(10);
		p_ids[7].setBounds(314, 436, 45, 42);
		contentPane.add(p_ids[7]);
		
		lbl_panel9 = new JLabel("Panel 9 ID");
		lbl_panel9.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_panel9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_panel9.setBounds(157, 486, 112, 36);
		contentPane.add(lbl_panel9);
		
		p_ids[8] = new JTextField();
		p_ids[8].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String inp = p_ids[8].getText();
				if (inp.compareTo("") != 0) {
					panel_ids[8] = Integer.parseInt(inp);
				}
			}
		});
		p_ids[8].addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//numbers only!
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		p_ids[8].setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_ids[8].setColumns(10);
		p_ids[8].setBounds(314, 484, 45, 42);
		contentPane.add(p_ids[8]);
		
		lbl_panel10 = new JLabel("Panel 10 ID");
		lbl_panel10.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_panel10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_panel10.setBounds(157, 534, 112, 36);
		contentPane.add(lbl_panel10);
		
		p_ids[9] = new JTextField();
		p_ids[9].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String inp = p_ids[9].getText();
				if (inp.compareTo("") != 0) {
					panel_ids[9] = Integer.parseInt(inp);
				}
			}
		});
		p_ids[9].addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//numbers only!
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		p_ids[9].setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_ids[9].setColumns(10);
		p_ids[9].setBounds(314, 532, 45, 42);
		contentPane.add(p_ids[9]);
		
		
		
		btn_toAppliances = new JButton("Next");
		btn_toAppliances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quantity = (int) spinner_quantity.getValue();
				String city = Signup_User_Form.getCity();
				//String city = tf_city.getText();
				String uname = Signup_User_Form.getUsername();
				
				int flag = 0;
				for (int i = 0; i < quantity; i++) {
					int current_pid = Integer.parseInt(p_ids[i].getText());
					if (current_pid > 50) {
						flag = 1;
						JOptionPane.showMessageDialog(null, "Panel IDs must be below 50");
						break;
					}
					else if (checkPanelAlreadyExists(current_pid)) {
						flag = 1;
						JOptionPane.showMessageDialog(null, "This Panel ID Already Exists, Enter Another One");
						break;
					}
				}
				if (flag == 0) {
					for (int i = 0; i < quantity; i++) {
						PreparedStatement st;
						int rs;
						String query = "INSERT INTO solarspace.spanel_user VALUES "
								+ "(?, ?, ?)";
						try {
							st = DB_Connection.getConnection().prepareStatement(query);
							st.setInt(1, Integer.parseInt(p_ids[i].getText()));
							st.setString(2, uname);
							st.setString(3, city);
							
							rs = st.executeUpdate();
							/*
							 * if (rs != 0) { Signup_Appliances_Form appl = new Signup_Appliances_Form();
							 * appl.setVisible(true); appl.setLocationRelativeTo(null);
							 * 
							 * //close current page dispose(); }
							 */	
						} catch (SQLException err) {
							System.err.println(err);
						}
					}
					Signup_Appliances_Form appl = new Signup_Appliances_Form();
					appl.setVisible(true);
					appl.setLocationRelativeTo(null);
					
					//close current page
					dispose();
				}
			}
		});
		btn_toAppliances.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_toAppliances.setBounds(237, 584, 100, 42);
		contentPane.add(btn_toAppliances);
	}
}
