import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JScrollPane;

public class Researcher {

	JFrame frame;
	
	private static String filePath = System.getProperty("user.dir");
	public User loggedIn = new User();
	private JLabel lblToEdit;
	private JTextField subName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Researcher window = new Researcher();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Researcher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		// window components and sizing/ moving
		frame = new JFrame();
		frame.setBounds(100, 100, 1060, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);
		
		JButton btnNominate = new JButton("Nominate Reviewer");
		btnNominate.setBounds(298, 5, 135, 25);
		btnNominate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		layeredPane.add(btnNominate);
		
		JButton btnView = new JButton("View Reviews");
		btnView.setBounds(438, 5, 107, 25);
		btnView.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		layeredPane.add(btnView);
		
		JButton btnEdit = new JButton("Edit Submission");
		btnEdit.setBounds(550, 5, 119, 25);
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		layeredPane.add(btnEdit);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(674, 5, 69, 25);
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		layeredPane.add(btnSubmit);
		lblToEdit = new JLabel("Submission to edit:");
		lblToEdit.setForeground(Color.WHITE);
		lblToEdit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblToEdit.setBounds(12, 138, 112, 16);
		lblToEdit.setVisible(false);
		
		JPanel nominate = new JPanel();
		nominate.setBackground(Color.BLACK);
		nominate.setBounds(163, 66, 722, 338);
		layeredPane.add(nominate);
		nominate.setLayout(null);
		nominate.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Select up to 3 reviewers to nominate:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 184, 213, 16);
		nominate.add(lblNewLabel);
		
		JLabel lblSelectWhichSubmission = new JLabel("Select which submission you would like to nominate reviewers for:");
		lblSelectWhichSubmission.setForeground(Color.WHITE);
		lblSelectWhichSubmission.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSelectWhichSubmission.setBounds(12, 13, 392, 16);
		nominate.add(lblSelectWhichSubmission);
		
		JComboBox<String> nJournalBox = new JComboBox<String>();
		nJournalBox.setBounds(12, 65, 145, 22);
		nominate.add(nJournalBox);
		
		JComboBox<String> reviewBox_1 = new JComboBox<String>();
		reviewBox_1.setBounds(12, 249, 145, 22);
		nominate.add(reviewBox_1);
		
		JComboBox<String> reviewBox_2 = new JComboBox<String>();
		reviewBox_2.setBounds(169, 249, 145, 22);
		nominate.add(reviewBox_2);
		
		JComboBox<String> reviewBox_3 = new JComboBox<String>();
		reviewBox_3.setBounds(326, 249, 145, 22);
		nominate.add(reviewBox_3);
		
		JButton btnNewButton = new JButton("Nominate");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(564, 248, 97, 25);
		nominate.add(btnNewButton);
		
		JComboBox<String> nSubbox = new JComboBox<String>();
		nSubbox.setBounds(235, 65, 145, 22);
		nominate.add(nSubbox);
		
		JLabel lblNewLabel_1 = new JLabel("Journal");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(22, 42, 56, 16);
		nominate.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Submission");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(235, 42, 79, 16);
		nominate.add(lblNewLabel_1_1);
		
		Button selectJournal = new Button("Select");
		selectJournal.setBounds(45, 105, 79, 24);
		nominate.add(selectJournal);
		
		JLayeredPane submit = new JLayeredPane();
		submit.setBounds(12, 53, 1018, 564);
		layeredPane.add(submit);
		
		JLabel lblSub = new JLabel("Journal to submit to:");
		lblSub.setForeground(Color.WHITE);
		lblSub.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSub.setBounds(12, 13, 123, 16);
		submit.add(lblSub);
		
		JLabel lblEdit = new JLabel("Select Journal:");
		lblEdit.setForeground(Color.WHITE);
		lblEdit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEdit.setBounds(12, 13, 101, 16);
		submit.add(lblEdit);
		
		JComboBox<String> journalBox = new JComboBox<String>();
		journalBox.setBounds(12, 42, 123, 22);
		submit.add(journalBox);
		submit.add(lblToEdit);
		
		JComboBox<String> submissionBox = new JComboBox<String>();
		submissionBox.setBounds(12, 177, 123, 22);
		submit.add(submissionBox);
		
		JButton btnSub = new JButton("Submit");
		btnSub.setBounds(27, 492, 97, 25);
		submit.add(btnSub);
		
		JTextArea submissionT = new JTextArea();
		submissionT.setLineWrap(true);
		
		JScrollPane submission = new JScrollPane(submissionT);
		submission.setBounds(152, 13, 856, 541);
		submit.add(submission);
		
		JLabel lblReview = new JLabel("Select submission:");
		lblReview.setForeground(Color.WHITE);
		lblReview.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblReview.setBounds(12, 138, 112, 16);
		submit.add(lblReview);
		
		JLabel lblSelectReview = new JLabel("Select Review:");
		lblSelectReview.setForeground(Color.WHITE);
		lblSelectReview.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSelectReview.setBounds(12, 269, 112, 16);
		submit.add(lblSelectReview);
		
		JComboBox<String> reviewBox = new JComboBox<String>();
		reviewBox.setBounds(12, 298, 123, 22);
		submit.add(reviewBox);
		
		JButton btnViewRev = new JButton("View");
		btnViewRev.setBounds(27, 492, 97, 25);
		submit.add(btnViewRev);
		
		JTextArea reviewT = new JTextArea();
		reviewT.setLineWrap(true);
		reviewT.setEditable(false);
		
		JScrollPane review =  new JScrollPane(reviewT);
		review.setBounds(152, 13, 856, 541);
		submit.add(review);
		
		Button selectJ = new Button("Select");
		selectJ.setBounds(34, 91, 79, 24);
		submit.add(selectJ);
		
		Button selectS = new Button("Select");
		selectS.setBounds(34, 219, 79, 24);
		submit.add(selectS);
		
		JLabel lblSubName = new JLabel("Submission name");
		lblSubName.setForeground(Color.WHITE);
		lblSubName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSubName.setBounds(12, 138, 123, 16);
		submit.add(lblSubName);
		
		subName = new JTextField();
		subName.setBounds(12, 177, 123, 22);
		submit.add(subName);
		subName.setColumns(10);
		
		Button btnEditView = new Button("view");
		btnEditView.setActionCommand("view");
		btnEditView.setBounds(34, 219, 79, 24);
		submit.add(btnEditView);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1018, 564);
		panel.setVisible(false);
		submit.add(panel);
		// makes panels and components initially invisible
		lblSub.setVisible(false);
		lblEdit.setVisible(false);
		journalBox.setVisible(false);
		submissionBox.setVisible(false);
		btnSub.setVisible(false);
		submission.setVisible(false);
		lblReview.setVisible(false);
		lblSelectReview.setVisible(false);
		reviewBox.setVisible(false);
		btnViewRev.setVisible(false);
		review.setVisible(false);
		selectJ.setVisible(false);
		selectS.setVisible(false);
		lblSubName.setVisible(false);
		subName.setVisible(false);
		btnEditView.setVisible(false);
		
		// Buttons
		// opens nomination panel
		btnNominate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//makes nomination visible and all other panels not
				if (nominate.isVisible() == false) {
					nominate.setVisible(true);
					submit.setVisible(false);
					
					btnSub.setVisible(false);
					btnViewRev.setVisible(false);
					lblToEdit.setVisible(false);
				} else {
					nominate.setVisible(false);
				}
				// loads journal selection box
				ArrayList<String> journals = new ArrayList<String>();
				try {
					User.getJournals(journals);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				nJournalBox.removeAllItems();
				for (int i = 0; i < journals.size(); i++) {
					nJournalBox.addItem(journals.get(i));
				}
				// loads Reviewer nomination options
				ArrayList<User> users = new ArrayList<User>();
				try {
					User.getUsers(users);
					
					reviewBox_1.removeAllItems();
					reviewBox_2.removeAllItems();
					reviewBox_3.removeAllItems();
					
					reviewBox_1.addItem("");
					reviewBox_2.addItem("");
					reviewBox_3.addItem("");
					
					for (int i = 0; i < users.size(); i++) {
						if (users.get(i).getAccsessLevel().equals("REVIEWER")) {
							reviewBox_1.addItem(users.get(i).getUsername());
							reviewBox_2.addItem(users.get(i).getUsername());
							reviewBox_3.addItem(users.get(i).getUsername());
							
						}
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		// loads Review viewing panel
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Makes review panel components visible and all others invisible
				if (btnViewRev.isVisible() == false) {
					nominate.setVisible(false);
					submit.setVisible(true);
					
					lblSub.setVisible(false);
					lblEdit.setVisible(true);
					journalBox.setVisible(true);
					lblToEdit.setVisible(false);
					submissionBox.setVisible(true);
					btnSub.setVisible(false);
					submission.setVisible(false);
					lblReview.setVisible(true);
					lblSelectReview.setVisible(true);
					reviewBox.setVisible(true);
					btnViewRev.setVisible(true);
					review.setVisible(true);
					selectJ.setVisible(true);
					selectS.setVisible(true);
					lblSubName.setVisible(false);
					subName.setVisible(false);
					btnEditView.setVisible(false);
					panel.setVisible(true);
				} else {
					submit.setVisible(false);
					btnViewRev.setVisible(false);
				}
				// loads journal selection box
				ArrayList<String> journals = new ArrayList<String>();
				try {
					User.getJournals(journals);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				journalBox.removeAllItems();
				for (int i = 0; i < journals.size(); i++) {
					journalBox.addItem(journals.get(i));
				}
			}
		});
		// loads editing panel makes all other elements invisible
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblToEdit.isVisible() == false) {
					nominate.setVisible(false);
					submit.setVisible(true);
					
					lblSub.setVisible(false);
					lblEdit.setVisible(true);
					journalBox.setVisible(true);
					lblToEdit.setVisible(true);
					submissionBox.setVisible(true);
					btnSub.setVisible(true);
					submission.setVisible(true);
					lblReview.setVisible(false);
					lblSelectReview.setVisible(false);
					reviewBox.setVisible(false);
					btnViewRev.setVisible(false);
					review.setVisible(false);
					selectJ.setVisible(true);
					selectS.setVisible(false);
					lblSubName.setVisible(false);
					subName.setVisible(false);
					btnEditView.setVisible(true);
					panel.setVisible(true);
				} else {
					submit.setVisible(false);
					lblToEdit.setVisible(false);
				}
				// loads journal box
				ArrayList<String> journals = new ArrayList<String>();
				try {
					User.getJournals(journals);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				journalBox.removeAllItems();
				for (int i = 0; i < journals.size(); i++) {
					journalBox.addItem(journals.get(i));
				}
			}
		});
		// loads submission panel, makes all other elements invisible
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblSub.isVisible() == false) {
					nominate.setVisible(false);
					submit.setVisible(true);
					
					subName.removeAll();
					
					lblSub.setVisible(true);
					lblEdit.setVisible(false);
					journalBox.setVisible(true);
					lblToEdit.setVisible(false);
					submissionBox.setVisible(false);
					btnSub.setVisible(true);
					submission.setVisible(true);
					lblReview.setVisible(false);
					lblSelectReview.setVisible(false);
					reviewBox.setVisible(false);
					btnViewRev.setVisible(false);
					review.setVisible(false);
					selectJ.setVisible(false);
					selectS.setVisible(false);
					lblSubName.setVisible(true);
					subName.setVisible(true);
					btnEditView.setVisible(false);
					panel.setVisible(true);
				} else {
					submit.setVisible(false);
					lblSub.setVisible(false);
				}
				
				subName.removeAll();
				// loads journal box with all journals
				ArrayList<String> journals = new ArrayList<String>();
				try {
					User.getJournals(journals);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				journalBox.removeAllItems();
				for (int i = 0; i < journals.size(); i++) {
					journalBox.addItem(journals.get(i));
				}
			}
		});
		// loads all submissions in selected journal to submission box
		selectJournal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> submissions = new ArrayList<String>();
				
				nSubbox.removeAllItems();
				
				try {
					User.getSubmissions(submissions, nJournalBox.getSelectedItem().toString());
					for (int i = 0; i < submissions.size(); i += 2) {
						if (submissions.get(i).equals(loggedIn.getUsername())) {
							nSubbox.addItem(submissions.get(i + 1));
						}
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		// writes submission and submission info to txt file
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Boolean writeToSub = true;
				ArrayList<String> submissions = new ArrayList<String>();
				String journal = journalBox.getSelectedItem().toString();
				// writes file to submission text file
				// Submission.txt tracks all submission and there authors
				FileWriter write;	
				try {
					// insures no submission with the same submission name are written twice
					// by the same user
					User.getSubmissions(submissions, journal);
					for (int i = 0; i > submissions.size(); i+=2) {
						if (loggedIn.getUsername().equals(submissions.get(i))) {
							if (subName.getText().equals(submissions.get(i + 1)))
								writeToSub = false;
						}
					}
					// Writes submission info to submission file
					if (writeToSub) {
						write = new FileWriter(filePath + "/src/" + journal + "/" + "Submissions.txt", true);
						BufferedWriter info = new BufferedWriter(write);
						info.write(loggedIn.getUsername());
						info.newLine();
						info.write(subName.getText());
						info.newLine();
						info.close();
						// creates folder for reviews on first submission of a given submission name and user
						String newSubReviewFolder = filePath + "/src/" + journal + "/" + subName.getText() + "Reviews";
						File reviewFolder = new File(newSubReviewFolder);
						Boolean made = reviewFolder.mkdir();
						if (made) 
							System.out.print("Folder made");
						// creates file to keep track of reviewers
						File revs = new File(newSubReviewFolder + "/Reviewers.txt");
						FileWriter newRevs = new FileWriter(revs, true);
						BufferedWriter writeNewSubs = new BufferedWriter(newRevs);
						writeNewSubs.write("");
						writeNewSubs.close();
					}
					// Writes submission to a text file
					FileWriter write_2 = new FileWriter(filePath + "/src/" + journal + "/" + subName.getText() + ".txt");
					BufferedWriter sub = new BufferedWriter(write_2);
					sub.write(submissionT.getText());
					sub.close();
					// Creates reviewer nomination text file
					FileWriter write_3 = new FileWriter(filePath + "/src/" + journal + "/" + subName.getText() + "Nominations.txt", true);
					write_3.write("");
					write_3.close();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		// writes submission to submission box for a given journal
		selectJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> submissions = new ArrayList<String>();
		
				submissionBox.removeAllItems();
				
				try {
					User.getSubmissions(submissions, journalBox.getSelectedItem().toString());
					for (int i = 0; i < submissions.size(); i += 2) {
						if (submissions.get(i).equals(loggedIn.getUsername())) {
							submissionBox.addItem(submissions.get(i + 1));
						}
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		// Writes Selected user orginally made submission to text area
		btnEditView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String journal = journalBox.getSelectedItem().toString();
				String submission = submissionBox.getSelectedItem().toString();
				FileReader read;	
				try {
					read = new FileReader(filePath + "/src/" + journal + "/" + submissionBox.getSelectedItem() + ".txt");
					BufferedReader readSub = new BufferedReader(read);
					String write = readSub.readLine();
					while (write != null) {
						submissionT.append(write);
						submissionT.append("\n");
						write = readSub.readLine();
					}
					readSub.close();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				subName.setText(submission);
			}
		});
		// Writes researchers selected reviewers to nomination file
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String journal = nJournalBox.getSelectedItem().toString();
				String submission = nSubbox.getSelectedItem().toString();
				
				try {
					FileWriter info = new FileWriter(filePath + "/src/" + journal + "/" + submission + "Nominations.txt");
					BufferedWriter write = new BufferedWriter(info);
					write.write(reviewBox_1.getSelectedItem().toString());
					write.newLine();
					write.write(reviewBox_2.getSelectedItem().toString());
					write.newLine();
					write.write(reviewBox_3.getSelectedItem().toString());
					write.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		// adds reviews for selected submission to review selection box
		selectS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String journal = journalBox.getSelectedItem().toString();
				String submission = submissionBox.getSelectedItem().toString();
				
				ArrayList<String> reviews = new ArrayList<String>();
				
				reviewBox.removeAll();
				
				try {
					User.getReviews(reviews, journal, submission);
					for (int i = 0; i < reviews.size(); i++) {
						reviewBox.addItem(reviews.get(i));
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		// displays selected review
		btnViewRev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String journal = journalBox.getSelectedItem().toString();
				String submission = submissionBox.getSelectedItem().toString();
				String review = reviewBox.getSelectedItem().toString();
				
				try {
					FileReader info = new FileReader(filePath + "/src/" + journal + "/" + submission + "Reviews/" + review + ".txt");
					BufferedReader read = new BufferedReader(info);
					String write = read.readLine();
					while (write != null) {
						reviewT.append(write);
						reviewT.append("\n");
						 write = read.readLine();
					}
					read.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
