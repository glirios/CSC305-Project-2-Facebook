
public class LoginModel {

	private String username = "admin";
	private String password = "admin";
	
	LoginModel()	{
		reset();
	}
	
	public void setPassword(String value) {
		password = value;
	}
	
	public void setUsername(String value) {
		username = value;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword()	{
		return password;
	}
	
	public void reset()	{
		username = "admin";
		password = "admin";
	}
}
