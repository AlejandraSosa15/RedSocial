package email;

public class UserData {

	private String userName;
	private String password;
	
	
	public UserData() {
	
		this.userName = "dorihat123@gmail.com";
		this.password = "contrasena1";
		
	}
	
	//Get atributos
	public String getUserName() {
		return this.userName;
	}
	
	public String getPassword() {
		return this.password;
	}
	//Set atributos
	public void setUserName(String userName) {
		this.userName=userName;
	}

	public void setPassword(String password) {
		this.password=password;
	}
	
}
