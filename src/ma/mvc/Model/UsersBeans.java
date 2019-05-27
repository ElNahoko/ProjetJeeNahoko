package ma.mvc.Model;

public class UsersBeans {
	
	private int ID_User;
	String Username,Password,Type;
	public int getID_User() {
		return ID_User;
	}
	public UsersBeans(String username, String password) {
		super();
		Username = username;
		Password = password;
	}
	public void setID_User(int iD_User) {
		ID_User = iD_User;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public UsersBeans(int iD_User, String username, String password, String type) {
		super();
		ID_User = iD_User;
		Username = username;
		Password = password;
		Type = type;
	}
	public UsersBeans(String username, String password, String type) {
		super();
		Username = username;
		Password = password;
		Type = type;
	}
	

}
