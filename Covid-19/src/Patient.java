
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
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	public void addContact(String firstName, String lastName, String email) {
		Contact con = new Contact(firstName, lastName, email);
		contacts[countC] = con;
		countC += 1;
	}
	
	
	
}
