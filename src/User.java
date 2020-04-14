import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class User {
	
	private static String filePath = System.getProperty("user.dir");

	private String username;
	private String password;
	private String accsessLevel;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccsessLevel() {
		return accsessLevel;
	}
	public void setAccsessLevel(String accsessLevel) {
		this.accsessLevel = accsessLevel;
	}
	
	public User(String user, String pass, String acc) {
		this.username = user;
		this.password = pass;
		this.accsessLevel = acc;
	}
	
	public static ArrayList<User> getUsers(ArrayList<User> users) throws FileNotFoundException {
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
	
	public static void getJournals(ArrayList<String> journals) throws FileNotFoundException {
		try {
			BufferedReader info = new BufferedReader(new FileReader(filePath + "/src/Journals.txt"));
			String journal = info.readLine();
			while (journal != null) {
				journals.add(journal);
				journal = info.readLine();
			}
			info.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getSubmissions(ArrayList<String> submissions, String journal) throws FileNotFoundException {
		try {
			BufferedReader info = new BufferedReader(new FileReader(filePath + "/src/" + journal + "/Submissions.txt"));
			String sub = info.readLine();
			while (sub != null) {
				submissions.add(sub);
				sub = info.readLine();
			}
			info.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getReviews(ArrayList<String> reviews, String journal, String submission) throws FileNotFoundException {
		try {
			BufferedReader info = new BufferedReader(new FileReader(filePath + "/src/" + journal + "/" + submission + "Reviews/Reviewers.txt"));
			String sub = info.readLine();
			while (sub != null) {
				reviews.add(sub);
				sub = info.readLine();
			}
			info.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public User() {
	}
}
