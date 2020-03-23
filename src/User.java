
public class User {

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
	
	public User() {
	}
}
