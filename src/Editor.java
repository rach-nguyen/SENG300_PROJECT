import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editor {

	JFrame frame;
	private JTextField createText;
	
	private static String filePath = System.getProperty("user.dir");
	
	public void writeAccepted(String submission, String filepath) throws FileNotFoundException{
		try {
			FileWriter write = new FileWriter(filePath + "/src/Accepted.txt", true);
			BufferedWriter info = new BufferedWriter(write);
			info.write(submission);
			info.newLine();
			info.write(filepath);
			info.newLine();
			info.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editor window = new Editor();
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
	public Editor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);
		
		JButton btnView = new JButton("View Journals");
		btnView.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnView.setBounds(340, 5, 111, 25);
		layeredPane.add(btnView);
		
		JButton btnCreate = new JButton("Create Journal");
		btnCreate.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCreate.setBounds(456, 5, 115, 25);
		layeredPane.add(btnCreate);
		
		JButton btnCollect = new JButton("Collect Submissions");
		btnCollect.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCollect.setBounds(576, 5, 145, 25);
		layeredPane.add(btnCollect);
		
		JPanel collect = new JPanel();
		collect.setBackground(Color.BLACK);
		collect.setBounds(323, 125, 417, 246);
		layeredPane.add(collect);
		collect.setLayout(null);
		collect.setVisible(false);
		
		JLabel lblSelectJournalA = new JLabel("Select Journal");
		lblSelectJournalA.setForeground(Color.WHITE);
		lblSelectJournalA.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSelectJournalA.setBounds(23, 13, 90, 16);
		collect.add(lblSelectJournalA);
		
		JComboBox<String> journalBoxA = new JComboBox<String>();
		journalBoxA.setBounds(12, 42, 113, 22);
		collect.add(journalBoxA);
		
		JButton selectJBtnA = new JButton("Select");
		selectJBtnA.setBounds(20, 88, 97, 25);
		collect.add(selectJBtnA);
		
		JLabel lblSelectSubmission = new JLabel("Select Submission");
		lblSelectSubmission.setForeground(Color.WHITE);
		lblSelectSubmission.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSelectSubmission.setBounds(12, 169, 113, 16);
		collect.add(lblSelectSubmission);
		
		JComboBox<String> submissionBoxA = new JComboBox<String>();
		submissionBoxA.setBounds(12, 200, 113, 22);
		collect.add(submissionBoxA);
		
		JButton acceptBtn = new JButton("Accept Selection");
		acceptBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		acceptBtn.setBounds(214, 41, 145, 25);
		collect.add(acceptBtn);
		
		JLabel lblNewLabel = new JLabel("Note: Acceptions can only be ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(189, 92, 216, 16);
		collect.add(lblNewLabel);
		
		JLabel lblOnTheFollowing = new JLabel("made on the following days:");
		lblOnTheFollowing.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblOnTheFollowing.setForeground(Color.WHITE);
		lblOnTheFollowing.setBounds(189, 109, 216, 16);
		collect.add(lblOnTheFollowing);
		
		JLabel lblJuneth = new JLabel("June 30th");
		lblJuneth.setForeground(Color.WHITE);
		lblJuneth.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblJuneth.setBounds(189, 138, 216, 16);
		collect.add(lblJuneth);
		
		JLabel lblDecemberst = new JLabel("December 31st");
		lblDecemberst.setForeground(Color.WHITE);
		lblDecemberst.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDecemberst.setBounds(189, 170, 216, 16);
		collect.add(lblDecemberst);
		
		JPanel view = new JPanel();
		view.setBackground(Color.BLACK);
		view.setBounds(176, 66, 736, 506);
		layeredPane.add(view);
		view.setLayout(null);
		view.setVisible(false);
		
		JComboBox<String> journalBox = new JComboBox<String>();
		journalBox.setBounds(12, 42, 113, 22);
		view.add(journalBox);
		
		JButton selectJBtn = new JButton("Select");
		selectJBtn.setBounds(20, 88, 97, 25);
		view.add(selectJBtn);
		
		JComboBox<String> submissionBox = new JComboBox<String>();
		submissionBox.setBounds(12, 328, 113, 22);
		view.add(submissionBox);
		
		JButton viewSbtn = new JButton("View");
		viewSbtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		viewSbtn.setBounds(20, 374, 97, 25);
		view.add(viewSbtn);
		
		JLabel lblSelectJournal = new JLabel("Select Journal");
		lblSelectJournal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSelectJournal.setForeground(Color.WHITE);
		lblSelectJournal.setBounds(23, 13, 90, 16);
		view.add(lblSelectJournal);
		
		JLabel lblViewSubmission = new JLabel("View Submission");
		lblViewSubmission.setForeground(Color.WHITE);
		lblViewSubmission.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblViewSubmission.setBounds(16, 299, 104, 16);
		view.add(lblViewSubmission);
		
		JTextArea displaySub = new JTextArea();
		displaySub.setLineWrap(true);
		displaySub.setEditable(false);
		displaySub.setBounds(131, 13, 595, 483);
		view.add(displaySub);
		
		JPanel create = new JPanel();
		create.setBackground(Color.BLACK);
		create.setBounds(340, 208, 381, 176);
		layeredPane.add(create);
		create.setLayout(null);
		create.setVisible(false);
		
		JLabel createLabel = new JLabel("Journal Name");
		createLabel.setBounds(148, 13, 84, 19);
		createLabel.setForeground(Color.WHITE);
		createLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		create.add(createLabel);
		
		createText = new JTextField();
		createText.setBounds(123, 58, 135, 34);
		create.add(createText);
		createText.setColumns(10);
		
		JButton createBttn = new JButton("Create Journal");
		createBttn.setBounds(123, 121, 135, 25);
		create.add(createBttn);
		
		// Buttons handlers
		
		// opens create panel, closes all others
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if (create.isVisible() == false) {
					view.setVisible(false);
					create.setVisible(true);
					collect.setVisible(false);
				} else {
					create.setVisible(false);
				}
			}
		});
		// opens view panel, closes all others
		// add journal options to combobox
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if (view.isVisible() == false) {
					view.setVisible(true);
					create.setVisible(false);
					collect.setVisible(false);
				} else {
					view.setVisible(false);
				}
				
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
		// opens collect panel, closes all others
		// add journal options to combobox
		btnCollect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if (collect.isVisible() == false) {
					view.setVisible(false);
					create.setVisible(false);
					collect.setVisible(true);
				} else {
					collect.setVisible(false);
				}
				
				ArrayList<String> journals = new ArrayList<String>();
				try {
					User.getJournals(journals);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				journalBoxA.removeAllItems();
				for (int i = 0; i < journals.size(); i++) {
					journalBoxA.addItem(journals.get(i));
				}
			}
		});
		// bring up submissions to selected journal in view panel
		selectJBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> subs = new ArrayList<String>();
				try {
					User.getSubmissions(subs,journalBox.getSelectedItem().toString());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				submissionBox.removeAllItems();
				for (int i = 0; i < subs.size(); i++) {
					submissionBox.addItem(subs.get(i));
				}
			}
		});
		// displays selected submission
		viewSbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sub = submissionBox.getSelectedItem().toString();
				String journal = journalBox.getSelectedItem().toString();
				try {
					BufferedReader read = new BufferedReader(new FileReader(filePath + "/src/" + journal + "/" + sub +".txt"));
					String line = read.readLine();
					while (line != null) {
						displaySub.append(line + "\n");
						line = read.readLine();
					}
					read.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		// bring up submissions to selected journal in collect panel
		selectJBtnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> subs = new ArrayList<String>();
				try {
					User.getSubmissions(subs,journalBoxA.getSelectedItem().toString());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				submissionBoxA.removeAllItems();
				for (int i = 0; i < subs.size(); i++) {
					submissionBoxA.addItem(subs.get(i));
				}
			}
		});
		// writes file path and name to accepted text file
		acceptBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date()); 
				String year = new SimpleDateFormat("yyyy").format(new Date()); 
				if (currentDate == ("31-12-" + year) || currentDate == ("30-6-" + year)) {
					try {
						String sub = submissionBoxA.getSelectedItem().toString();
						String journal = journalBoxA.getSelectedItem().toString();
						writeAccepted(sub, "(your SENG java folder location)" + "/src/" + journal + "/" + sub + ".pdf");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				} else {
					// show visual not correct date message (not implemented)
					System.out.print("wrong date");
				}
			}
		});
		// creates new journal folder
		createBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newJournalPath = filePath + "/src/" + createText.getText();
				File journal = new File(newJournalPath);
				Boolean made = journal.mkdir();
				if (made) {
					// success message
					System.out.print("Journal created");
					// Creates new journal folder with Submission text file
					try {
						FileWriter write = new FileWriter(filePath + "/src/Journals.txt", true);
						BufferedWriter info = new BufferedWriter(write);
						info.write(createText.getText());
						info.newLine();
						info.close();
						File subs = new File(newJournalPath + "/Submissions.txt");
						FileWriter newSubs = new FileWriter(subs, true);
						BufferedWriter writeNewSubs = new BufferedWriter(newSubs);
						writeNewSubs.write("");
						writeNewSubs.close();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					// fail message (not implemented)
					System.out.print("Journal not created");
				}
			}
		});
	}
}
