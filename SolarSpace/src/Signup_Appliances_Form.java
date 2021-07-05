import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Choice;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Signup_Appliances_Form extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup_Appliances_Form frame = new Signup_Appliances_Form();
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
	public Signup_Appliances_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Choice appl[] = new Choice[10];
		JSpinner spinners[] = new JSpinner[10];
		
		String appliances[] = {"AC", "Ceiling Fan", "Computer/PC/Laptop", 
				"Microwave Oven", "Refrigerator", "Washing Machine", 
				"Television", "Water Heater", "Tubelight", "Light Bulb"};
		int aids[] = new int[10];
		int quants[] = new int[10];
		
		JLabel lbl_appliances_reg = new JLabel("APPLIANCES REGISTRATION");
		lbl_appliances_reg.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_appliances_reg.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_appliances_reg.setBounds(108, 10, 365, 36);
		contentPane.add(lbl_appliances_reg);
		
		JLabel lbl_quantity = new JLabel("No. of Appliances");
		lbl_quantity.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_quantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_quantity.setBounds(23, 61, 120, 22);
		contentPane.add(lbl_quantity);
		
		JSpinner spinner0 = new JSpinner();
		spinner0.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner0.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner0.setBounds(182, 57, 47, 26);
		contentPane.add(spinner0);
		
		JLabel lbl_appl1 = new JLabel("Appliance 1");
		lbl_appl1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appl1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_appl1.setBounds(61, 93, 82, 22);
		contentPane.add(lbl_appl1);
		
		appl[0] = new Choice();
		appl[0].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				aids[0] = appl[0].getSelectedIndex() + 1;
			}
		});
		appl[0].setFont(new Font("Tahoma", Font.PLAIN, 14));
		appl[0].setBounds(182, 93, 252, 18);
		for (int i = 0; i < 10; i++)
			appl[0].add(appliances[i]);
		contentPane.add(appl[0]);
		
		spinners[0] = new JSpinner();
		spinners[0].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				quants[0] = (int) spinners[0].getValue();
				int t = (int) spinners[0].getModel().getValue();
				System.out.println(t);
			}
		});
		spinners[0].setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinners[0].setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinners[0].setBounds(423, 92, 47, 26);
		contentPane.add(spinners[0]);
		
		JLabel lbl_appl2 = new JLabel("Appliance 2");
		lbl_appl2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appl2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_appl2.setBounds(61, 126, 82, 22);
		contentPane.add(lbl_appl2);
		
		appl[1] = new Choice();
		appl[1].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				aids[1] = appl[1].getSelectedIndex() + 1;
			}
		});
		appl[1].setFont(new Font("Tahoma", Font.PLAIN, 14));
		appl[1].setBounds(182, 126, 252, 18);
		for (int i = 0; i < 10; i++)
			appl[1].add(appliances[i]);
		contentPane.add(appl[1]);
		
		spinners[1] = new JSpinner();
		spinners[1].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				quants[1] = (int) spinners[1].getValue(); 
			}
		});
		spinners[1].setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinners[1].setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinners[1].setBounds(423, 125, 47, 26);
		contentPane.add(spinners[1]);
		
		JLabel lbl_appl3 = new JLabel("Appliance 3");
		lbl_appl3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appl3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_appl3.setBounds(61, 159, 82, 22);
		contentPane.add(lbl_appl3);
		
		appl[2] = new Choice();
		appl[2].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				aids[2] = appl[2].getSelectedIndex() + 1;
			}
		});
		appl[2].setFont(new Font("Tahoma", Font.PLAIN, 14));
		appl[2].setBounds(182, 159, 252, 18);
		for (int i = 0; i < 10; i++)
			appl[2].add(appliances[i]);
		contentPane.add(appl[2]);
		
		spinners[2] = new JSpinner();
		spinners[2].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				quants[2] = (int) spinners[2].getValue(); 
			}
		});
		spinners[2].setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinners[2].setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinners[2].setBounds(423, 158, 47, 26);
		contentPane.add(spinners[2]);
		
		JLabel lbl_appl4 = new JLabel("Appliance 4");
		lbl_appl4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appl4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_appl4.setBounds(61, 192, 82, 22);
		contentPane.add(lbl_appl4);
		
		appl[3] = new Choice();
		appl[3].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				aids[3] = appl[3].getSelectedIndex() + 1;
			}
		});
		appl[3].setFont(new Font("Tahoma", Font.PLAIN, 14));
		appl[3].setBounds(182, 192, 252, 18);
		for (int i = 0; i < 10; i++)
			appl[3].add(appliances[i]);
		contentPane.add(appl[3]);
		
		spinners[3] = new JSpinner();
		spinners[3].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				quants[3] = (int) spinners[3].getValue(); 
			}
		});
		spinners[3].setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinners[3].setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinners[3].setBounds(423, 191, 47, 26);
		contentPane.add(spinners[3]);
		
		JLabel lbl_appl5 = new JLabel("Appliance 5");
		lbl_appl5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appl5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_appl5.setBounds(61, 225, 82, 22);
		contentPane.add(lbl_appl5);
		
		appl[4] = new Choice();
		appl[4].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				aids[4] = appl[4].getSelectedIndex() + 1;
			}
		});
		appl[4].setFont(new Font("Tahoma", Font.PLAIN, 14));
		appl[4].setBounds(182, 225, 252, 18);
		for (int i = 0; i < 10; i++)
			appl[4].add(appliances[i]);
		contentPane.add(appl[4]);
		
		spinners[4] = new JSpinner();
		spinners[4].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				quants[4] = (int) spinners[4].getValue(); 
			}
		});
		spinners[4].setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinners[4].setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinners[4].setBounds(423, 224, 47, 26);
		contentPane.add(spinners[4]);
		
		spinners[5] = new JSpinner();
		spinners[5].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				quants[5] = (int) spinners[5].getValue(); 
			}
		});
		spinners[5].setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinners[5].setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinners[5].setBounds(423, 257, 47, 26);
		contentPane.add(spinners[5]);
		
		appl[5] = new Choice();
		appl[5].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				aids[5] = appl[5].getSelectedIndex() + 1;
			}
		});
		appl[5].setFont(new Font("Tahoma", Font.PLAIN, 14));
		appl[5].setBounds(182, 258, 252, 18);
		for (int i = 0; i < 10; i++)
			appl[5].add(appliances[i]);
		contentPane.add(appl[5]);
		
		JLabel lbl_appl6 = new JLabel("Appliance 6");
		lbl_appl6.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appl6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_appl6.setBounds(61, 258, 82, 22);
		contentPane.add(lbl_appl6);
		
		JLabel lbl_appl7 = new JLabel("Appliance 7");
		lbl_appl7.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appl7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_appl7.setBounds(61, 291, 82, 22);
		contentPane.add(lbl_appl7);
		
		appl[6] = new Choice();
		appl[6].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				aids[6] = appl[6].getSelectedIndex() + 1;
			}
		});
		appl[6].setFont(new Font("Tahoma", Font.PLAIN, 14));
		appl[6].setBounds(182, 291, 252, 18);
		for (int i = 0; i < 10; i++)
			appl[6].add(appliances[i]);
		contentPane.add(appl[6]);
		
		spinners[6] = new JSpinner();
		spinners[6].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				quants[6] = (int) spinners[6].getValue(); 
			}
		});
		spinners[6].setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinners[6].setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinners[6].setBounds(423, 290, 47, 26);
		contentPane.add(spinners[6]);
		
		spinners[7] = new JSpinner();
		spinners[7].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				quants[7] = (int) spinners[7].getValue(); 
			}
		});
		spinners[7].setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinners[7].setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinners[7].setBounds(423, 323, 47, 26);
		contentPane.add(spinners[7]);
		
		appl[7] = new Choice();
		appl[7].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				aids[7] = appl[7].getSelectedIndex() + 1;
			}
		});
		appl[7].setFont(new Font("Tahoma", Font.PLAIN, 14));
		appl[7].setBounds(182, 324, 252, 18);
		for (int i = 0; i < 10; i++)
			appl[7].add(appliances[i]);
		contentPane.add(appl[7]);
		
		JLabel lbl_appl8 = new JLabel("Appliance 8");
		lbl_appl8.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appl8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_appl8.setBounds(61, 324, 82, 22);
		contentPane.add(lbl_appl8);
		
		JLabel lbl_appl9 = new JLabel("Appliance 9");
		lbl_appl9.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appl9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_appl9.setBounds(64, 360, 82, 22);
		contentPane.add(lbl_appl9);
		
		appl[8] = new Choice();
		appl[8].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				aids[8] = appl[8].getSelectedIndex() + 1;
			}
		});
		appl[8].setFont(new Font("Tahoma", Font.PLAIN, 14));
		appl[8].setBounds(185, 360, 252, 18);
		for (int i = 0; i < 10; i++)
			appl[8].add(appliances[i]);
		contentPane.add(appl[8]);
		
		spinners[8] = new JSpinner();
		spinners[8].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				quants[8] = (int) spinners[8].getValue(); 
			}
		});
		spinners[8].setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinners[8].setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinners[8].setBounds(426, 359, 47, 26);
		contentPane.add(spinners[8]);
		
		JLabel lbl_appl10 = new JLabel("Appliance 10");
		lbl_appl10.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appl10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_appl10.setBounds(64, 393, 82, 22);
		contentPane.add(lbl_appl10);
		
		appl[9] = new Choice();
		appl[9].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				aids[9] = appl[9].getSelectedIndex() + 1;
			}
		});
		appl[9].setFont(new Font("Tahoma", Font.PLAIN, 14));
		appl[9].setBounds(185, 393, 252, 18);
		for (int i = 0; i < 10; i++)
			appl[9].add(appliances[i]);
		contentPane.add(appl[9]);
		
		spinners[9] = new JSpinner();
		spinners[9].addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				quants[9] = (int) spinners[9].getValue(); 
			}
		});
		spinners[9].setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinners[9].setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinners[9].setBounds(426, 392, 47, 26);
		contentPane.add(spinners[9]);
		
		JButton btn_reg = new JButton("Register");
		btn_reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ap_quantity = (int) spinner0.getValue();
				String uname = Signup_User_Form.getUsername();
				
				for (int i = 0; i < ap_quantity; i++) {
					//int aid = aids[i];
					int aid = appl[i].getSelectedIndex() + 1;
					int quant = (int) spinners[i].getValue();
					//int quant = quants[i];
					PreparedStatement st;
					int rs;
					String query = "INSERT INTO solarspace.appliance_user VALUES "
							+ "(?, ?, ?)";
					try {
						st = DB_Connection.getConnection().prepareStatement(query);
						st.setString(1, uname);
						st.setInt(2, aid);
						st.setInt(3, quant);
						
						rs = st.executeUpdate();
					} catch (SQLException err) {
						System.err.println(err);
					}
				}
				
				JOptionPane.showMessageDialog(null, "Your Account Has Been Created");
				Login_Form login = new Login_Form();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				
				//close current page
				dispose();
			}
		});
		btn_reg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_reg.setBounds(182, 428, 132, 42);
		contentPane.add(btn_reg);
		
		
	}
}
