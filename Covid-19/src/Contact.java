
public class Contact {

	private String firstName;
	private String lastName;
	private String email;
	
	public Contact(String fullName, String email) {
		this.fullName = fullName;
		this.email = email;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFirstName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
