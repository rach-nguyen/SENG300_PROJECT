import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Reviewer {

	public JFrame frame;
	
	private static String filePath = System.getProperty("user.dir");
	public User loggedIn = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reviewer window = new Reviewer();
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
	public Reviewer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		// Components creation, sizing, setting
		frame = new JFrame();
		frame.setBounds(100, 100, 1060, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);
		
		JButton btnNominations = new JButton("View Nominations");
		btnNominations.setBounds(298, 5, 135, 25);
		btnNominations.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		layeredPane.add(btnNominations);
		
		JButton btnEdit = new JButton("Edit Reviews");
		btnEdit.setBounds(438, 5, 107, 25);
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		layeredPane.add(btnEdit);
		
		JButton btnView = new JButton("View Submissions");
		btnView.setBounds(547, 5, 125, 25);
		btnView.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		layeredPane.add(btnView);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(674, 5, 69, 25);
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		layeredPane.add(btnSubmit);
		
		JPanel nominate = new JPanel();
		nominate.setBackground(Color.BLACK);
		nominate.setBounds(163, 66, 722, 338);
		layeredPane.add(nominate);
		nominate.setLayout(null);
		nominate.setVisible(false);
		
		JLabel lblSelectWhichSubmission = new JLabel("Select which Journal you would like to view nominations from:");
		lblSelectWhichSubmission.setForeground(Color.WHITE);
		lblSelectWhichSubmission.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSelectWhichSubmission.setBounds(12, 13, 392, 16);
		nominate.add(lblSelectWhichSubmission);
		
		JComboBox<String> nJournalBox = new JComboBox<String>();
		nJournalBox.setBounds(12, 65, 145, 22);
		nominate.add(nJournalBox);
		
		JLabel lblNewLabel_1 = new JLabel("Journal");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(22, 42, 56, 16);
		nominate.add(lblNewLabel_1);
		
		Button viewNoms = new Button("Select");
		viewNoms.setBounds(45, 105, 79, 24);
		nominate.add(viewNoms);
		
		JTextArea nominationsT = new JTextArea();
		nominationsT.setLineWrap(true);
		nominationsT.setEditable(false);
		
		JScrollPane nominations = new JScrollPane(nominationsT);
		nominations.setBounds(167, 42, 543, 283);
		nominate.add(nominations);
		
		JLayeredPane submit = new JLayeredPane();
		submit.setBounds(12, 53, 1018, 564);
		layeredPane.add(submit);
		
		JLabel lblEdit = new JLabel("Select Journal:");
		lblEdit.setForeground(Color.WHITE);
		lblEdit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEdit.setBounds(12, 13, 101, 16);
		submit.add(lblEdit);
		
		JComboBox<String> journalBox = new JComboBox<String>();
		journalBox.setBounds(12, 42, 123, 22);
		submit.add(journalBox);
		
		JComboBox<String> submissionBox = new JComboBox<String>();
		submissionBox.setBounds(12, 177, 123, 22);
		submit.add(submissionBox);
		
		JButton btnSub = new JButton("Submit");
		btnSub.setBounds(27, 492, 97, 25);
		submit.add(btnSub);
		
		JTextArea reviewT_1 = new JTextArea();
		reviewT_1.setLineWrap(true);
		
		JScrollPane review_1 = new JScrollPane(reviewT_1);
		review_1.setBounds(152, 13, 856, 541);
		submit.add(review_1);
		
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
		
		JButton btnViewSub = new JButton("View");
		btnViewSub.setBounds(27, 492, 97, 25);
		submit.add(btnViewSub);
		
		JTextArea submissionT_1 = new JTextArea();
		submissionT_1.setLineWrap(true);
		submissionT_1.setEditable(false);
		
		JScrollPane submission_1 =  new JScrollPane(submissionT_1);
		submission_1.setBounds(152, 13, 856, 541);
		submit.add(submission_1);
		
		Button selectJ = new Button("Select");
		selectJ.setBounds(34, 91, 79, 24);
		submit.add(selectJ);
		
		Button selectS = new Button("Select");
		selectS.setBounds(34, 219, 79, 24);
		submit.add(selectS);
		
		Button btnEditView = new Button("view");
		btnEditView.setActionCommand("view");
		btnEditView.setBounds(34, 219, 79, 24);
		submit.add(btnEditView);
		
		JLabel lblSubRev = new JLabel("Submit review");
		lblSubRev.setForeground(Color.WHITE);
		lblSubRev.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSubRev.setBounds(12, 463, 123, 16);
		submit.add(lblSubRev);
		
		Button btnViewRev = new Button("View");
		btnViewRev.setActionCommand("");
		btnViewRev.setBounds(34, 336, 79, 24);
		submit.add(btnViewRev);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1018, 564);
		panel.setVisible(false);
		submit.add(panel);
		// makes all components initially invisible
		lblEdit.setVisible(false);
		journalBox.setVisible(false);
		submissionBox.setVisible(false);
		btnSub.setVisible(false);
		review_1.setVisible(false);
		lblReview.setVisible(false);
		lblSelectReview.setVisible(false);
		reviewBox.setVisible(false);
		btnViewSub.setVisible(false);
		submission_1.setVisible(false);
		selectJ.setVisible(false);
		selectS.setVisible(false);
		btnEditView.setVisible(false);
		lblSubRev.setVisible(false);
		btnViewRev.setVisible(false);
		
		// Buttons
		// opens nomination panel
		btnNominations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nominate.isVisible() == false) {
					nominate.setVisible(true);
					submit.setVisible(false);
					
					btnSub.setVisible(false);
					btnViewSub.setVisible(false);
					reviewBox.setVisible(false);
				} else {
					nominate.setVisible(false);
				}
				// adds journals to journal selection box
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
			}
		});
		// opens Review editing panel
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				submissionBox.removeAllItems();
				reviewBox.removeAllItems();
				
				if (reviewBox.isVisible() == false) {
					nominate.setVisible(false);
					submit.setVisible(true);
					
					lblEdit.setVisible(true);
					journalBox.setVisible(true);
					submissionBox.setVisible(true);
					btnSub.setVisible(true);
					review_1.setVisible(true);
					lblReview.setVisible(true);
					lblSelectReview.setVisible(true);
					reviewBox.setVisible(true);
					btnViewSub.setVisible(false);
					submission_1.setVisible(false);
					selectJ.setVisible(true);
					selectS.setVisible(true);
					btnEditView.setVisible(true);
					lblSubRev.setVisible(false);
					btnViewRev.setVisible(true);
					panel.setVisible(true);
				} else {
					submit.setVisible(false);
					reviewBox.setVisible(false);
				}
				// add journals to journal selection box
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
		// opens submission viewing tab
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				submissionBox.removeAllItems();
				
				if (btnViewSub.isVisible() == false) {
					nominate.setVisible(false);
					submit.setVisible(true);
					
					lblEdit.setVisible(true);
					journalBox.setVisible(true);
					submissionBox.setVisible(true);
					btnSub.setVisible(false);
					review_1.setVisible(true);
					lblReview.setVisible(true);
					lblSelectReview.setVisible(false);
					reviewBox.setVisible(false);
					btnViewSub.setVisible(true);
					submission_1.setVisible(false);
					selectJ.setVisible(true);
					selectS.setVisible(false);
					btnEditView.setVisible(true);
					lblSubRev.setVisible(false);
					btnViewRev.setVisible(false);
					panel.setVisible(true);
				} else {
					submit.setVisible(false);
					btnViewSub.setVisible(false);
				}
				// adds journals to journal selection box
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
		// opens submission tab
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				submissionBox.removeAllItems();
				
				if (lblSubRev.isVisible() == false) {
					nominate.setVisible(false);
					submit.setVisible(true);
					
					lblEdit.setVisible(true);
					journalBox.setVisible(true);
					submissionBox.setVisible(true);
					btnSub.setVisible(true);
					review_1.setVisible(true);
					lblReview.setVisible(true);
					lblSelectReview.setVisible(false);
					reviewBox.setVisible(false);
					btnViewSub.setVisible(false);
					submission_1.setVisible(false);
					selectJ.setVisible(true);
					selectS.setVisible(false);
					btnEditView.setVisible(false);
					lblSubRev.setVisible(true);
					btnViewRev.setVisible(false);
					panel.setVisible(true);
				} else {
					submit.setVisible(false);
					lblSubRev.setVisible(false);
				}
				// adds journals to journal selection box
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
		// writes all of logged in users submission nominations to text field
		viewNoms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> submissions = new ArrayList<String>();
				String journal = nJournalBox.getSelectedItem().toString();
				
				try {
					User.getSubmissions(submissions, journal);
					for (int i = 1; i < submissions.size(); i+=2) {
						FileReader file = new FileReader(filePath + "/src/" + journal + "/" + submissions.get(i) + "Nominations.txt");
						BufferedReader info = new BufferedReader(file);
						String nomed = info.readLine();
						while (nomed != null) {
							if (nomed.equals(loggedIn.getUsername())) {
								nominationsT.append(submissions.get(i));
								nominationsT.append("\n");
							}	
							nomed = info.readLine();
						}
						info.close();
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		// writes Review to selected submissions review folder
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Boolean writeToRev = true;
				ArrayList<String> reviews = new ArrayList<String>();
				
				String journal = journalBox.getSelectedItem().toString();
				String submission = submissionBox.getSelectedItem().toString();
				FileWriter write;	
				try {
					// Ensures reviewers are not written to the reviewer tracking file twice
					User.getReviews(reviews, journal, submission);
					for (int i = 0; i > reviews.size(); i++) {
						if (loggedIn.getUsername().equals(reviews.get(i)))
							writeToRev = false;
					}
					// Review file keeps track of submitted reviews
					if (writeToRev) {
						write = new FileWriter(filePath + "/src/" + journal + "/" + submission + "Reviews/Reviewers.txt", true);
						BufferedWriter info = new BufferedWriter(write);
						info.write(loggedIn.getUsername());
						info.newLine();
						info.close();
					}
					
					FileWriter write_2 = new FileWriter(filePath + "/src/" + journal + "/" + submission + "Reviews/" + loggedIn.getUsername() + ".txt");
					BufferedWriter sub = new BufferedWriter(write_2);
					sub.write(reviewT_1.getText());
					sub.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		// shows all submissions with 4 or less reviews (insuring no review gets more than 4 reviews)
		selectJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> submissions = new ArrayList<String>();
				String journal = journalBox.getSelectedItem().toString();
		
				submissionBox.removeAllItems();
				
				try {
					User.getSubmissions(submissions, journalBox.getSelectedItem().toString());
					for (int i = 0; i < submissions.size(); i += 2) {
						ArrayList<String> reviewers = new ArrayList<String>();
						User.getReviews(reviewers, journal, submissions.get(i));
						if (reviewers.size() < 5)
							submissionBox.addItem(submissions.get(i + 1));
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		// Opens submissions in non editable plane for reviewer viewing
		btnEditView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String journal = journalBox.getSelectedItem().toString();
				String submission = submissionBox.getSelectedItem().toString();
				FileReader read;	
				try {
					read = new FileReader(filePath + "/src/" + journal + "/" + submission + ".txt");
					BufferedReader readSub = new BufferedReader(read);
					String write = readSub.readLine();
					while (write != null) {
						submissionT_1.append(write);
						submissionT_1.append("\n");
						write = readSub.readLine();
					}
					readSub.close();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		// loades all of logged in users written reviews to selection box
		selectS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String journal = journalBox.getSelectedItem().toString();
				String submission = submissionBox.getSelectedItem().toString();
				
				ArrayList<String> reviews = new ArrayList<String>();
				
				reviewBox.removeAll();
				
				try {
					User.getReviews(reviews, journal, submission);
					for (int i = 0; i < reviews.size(); i++) {
						if (reviews.get(i).equals(loggedIn.getUsername()))
							reviewBox.addItem(reviews.get(i));
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		// opens users selected review
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
						reviewT_1.append(write);
						reviewT_1.append("\n");
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
