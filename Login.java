import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class Login {
	
	private static String filePath = System.getProperty("user.dir");

	private JFrame frame;
	private JTextField username;
	private JPasswordField passwordField;
	private JTextField enterUser;
	private JPasswordField createPassword;
	private JPasswordField reEnterPass;

	public ArrayList<User> getUsers(ArrayList<User> users) throws FileNotFoundException {
		try {
			BufferedReader info = new BufferedReader(new FileReader(filePath + "/src/UserInfo.txt"));
			String user = "";
			while (user != null) {
				user = info.readLine();
				String pass = info.readLine();
				String authority = info.readLine();
				users.add(new User(user,pass,authority));
			}
			info.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void writeInfo(String user, String pass, String authority) throws FileNotFoundException{
		try {
			FileWriter write = new FileWriter(filePath + "/src/UserInfo.txt", true);
			BufferedWriter info = new BufferedWriter(write);
			info.newLine();
			info.write(user);
			info.newLine();
			info.write(pass);
			info.newLine();
			info.write(authority);
			info.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public Login() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(153, 51, 51));
		panel.setBounds(0, 0, 782, 453);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JPanel signUpPanel = new JPanel();
		signUpPanel.setBackground(new Color(0, 0, 51));
		signUpPanel.setBounds(250, 13, 283, 427);
		panel.add(signUpPanel);
		signUpPanel.setLayout(null);
		signUpPanel.setVisible(false);
		
		JLabel lblUser = new JLabel("Username");
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setBounds(98, 25, 86, 24);
		lblUser.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		signUpPanel.add(lblUser);
		
		enterUser = new JTextField();
		enterUser.setBounds(53, 62, 177, 24);
		signUpPanel.add(enterUser);
		enterUser.setColumns(10);
		
		JLabel enterPassword = new JLabel("Password");
		enterPassword.setForeground(new Color(255, 255, 255));
		enterPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		enterPassword.setBounds(98, 102, 86, 24);
		signUpPanel.add(enterPassword);
		
		createPassword = new JPasswordField();
		createPassword.setBounds(53, 138, 177, 24);
		signUpPanel.add(createPassword);
		
		JLabel lblRePass = new JLabel("Re-enter Password");
		lblRePass.setForeground(new Color(255, 255, 255));
		lblRePass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblRePass.setBounds(66, 186, 151, 24);
		signUpPanel.add(lblRePass);
		
		reEnterPass = new JPasswordField();
		reEnterPass.setBounds(53, 222, 177, 24);
		signUpPanel.add(reEnterPass);
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(12, 389, 80, 25);
		signUpPanel.add(cancel);
		
		JButton confirmSignUp = new JButton("Sign-up");
		confirmSignUp.setBounds(191, 389, 80, 25);
		signUpPanel.add(confirmSignUp);
		
		JRadioButton rdbtnResearcher = new JRadioButton("Researcher");
		rdbtnResearcher.setBounds(12, 286, 104, 25);
		signUpPanel.add(rdbtnResearcher);
		
		JRadioButton rdbtnReviewer = new JRadioButton("Reviewer");
		rdbtnReviewer.setBounds(12, 329, 86, 25);
		signUpPanel.add(rdbtnReviewer);
		
		JLabel lblInsctructions = new JLabel("Select one of the following:");
		lblInsctructions.setForeground(Color.WHITE);
		lblInsctructions.setBounds(12, 261, 172, 16);
		signUpPanel.add(lblInsctructions);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(352, 125, 78, 24);
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblUsername);
		
		username = new JTextField();
		username.setBounds(327, 162, 128, 24);
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassword.setBounds(352, 207, 78, 24);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(327, 247, 128, 22);
		panel.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(302, 379, 71, 25);
		panel.add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign-up");
		btnSignUp.setBounds(405, 379, 78, 25);
		panel.add(btnSignUp);
		
		// Button Actions
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUpPanel.setVisible(true);
				btnLogin.setVisible(false);
				btnSignUp.setVisible(false);
				username.setVisible(false);
				passwordField.setVisible(false);
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUpPanel.setVisible(false);
				btnLogin.setVisible(true);
				btnSignUp.setVisible(true);
				username.setVisible(true);
				passwordField.setVisible(true);
			}
		});
		
		confirmSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<User> users = new ArrayList<User>();
				boolean taken = false;
				try {
					getUsers(users);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				String user = enterUser.getText();
				if (user.length() > 0) {
					for (int i = 0; i < users.size(); i++) {
						if (user.equals(users.get(i).getUsername())) {
							taken = true;
							break;
						}
					}
				} else {
					//message saying Username must be longer than 1 character
				}
				if (taken == false) {
					boolean researcher = rdbtnResearcher.isSelected();
					boolean reviewer = rdbtnReviewer.isSelected();
					if (researcher != reviewer) {
						String pass1 = new String(createPassword.getPassword());
						String pass2 = new String(reEnterPass.getPassword());
						if (pass1.equals(pass2) && reviewer) {
							try {
								writeInfo(user, pass1, "REVIEWER");
								// Confirmation message
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						} else if (pass1.equals(pass2) && researcher){
							try {
								writeInfo(user, pass1, "RESEARCHER");
								// Confirmation message
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						} else {
							//show message passwords must match
						}
					} else {
						// show message saying choose one only
					}
				} else {
					// show message saying choose another name
				}
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<User> users = new ArrayList<User>();
				boolean isPasswordCorrect = false;
				String userAccessLevel = "";
				try {
					getUsers(users);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				String enteredUser = username.getText();
				char[] enteredPassword = passwordField.getPassword();
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getUsername().equals(enteredUser)) {
						for (int j = 0; j < users.get(i).getPassword().length(); j++) {
							try {
								if (enteredPassword[j] != users.get(i).getPassword().charAt(j)) {
									isPasswordCorrect = false;
									break;
								}
							} catch (IndexOutOfBoundsException e1) {
								isPasswordCorrect = false;
								break;
							} 
							isPasswordCorrect = true;
							userAccessLevel = users.get(i).getAccsessLevel();
						}
						break;
					}
				}
				if (isPasswordCorrect && userAccessLevel.equals("EDITOR")) {
					System.out.print(userAccessLevel);
					try {
						Editor log = new Editor();
						log.frame.setVisible(true);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}		
			}
		});
	}
}
