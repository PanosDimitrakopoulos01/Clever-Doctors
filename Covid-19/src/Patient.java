
public class Patient {

	private Patient patients[];
	private static int countP = 0;
	private String firstName;
	private String lastName;
	private int id;
	private int datePos;
	private String email;
	private Contact contacts[];
	private int countC = 0;
	
	public Patient(String firstName, String lastName, int id, int datePos, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.datePos = datePos;
		this.email = email;
		patients[countP] = this;
		countP += 1;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFirstName(String fullName) {
		this.fullName = fullName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDatePos() {
		return datePos;
	}
	public void setDatePos(int datePos) {
		this.datePos = datePos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addContact(String fullName, String email) {
		Contact con = new Contact(fullName, email);
		contacts[countC] = con;
		countC += 1;
	}
	
	
	
}
