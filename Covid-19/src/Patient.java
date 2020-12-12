import java.util.Arrays;

/* ����� "�������" �� ����������:
 * 		patients[]
 * 		countP:
 * 		fullname: ������ ����� 
 * 		phone:	  ��������
 * 		datePos:  ���������� ��� ����������� ������� ���� ��
 * 		email:	  ����������� email
 * 		Contacts[]:
 * 		countC:
 */
public class Patient {

	protected static Patient patients[] = new Patient[1000];
	protected static int countP = 0;
	protected Contact contacts[] = new Contact[100];
	private int countC = 0;
	private String fullName;
	private String phone;
	private String datePos;
	private String email;
	private int id = 0;
	
	/* Constructor */
	public Patient(String fullName, String phone, String datePos, String email) {
		this.fullName = fullName;
		this.phone = phone;
		this.datePos = datePos;
		this.email = email;
		if(patients[countP] == null) {
			patients[countP] = this;
		}
		this.id = Patient.countP;
		Patient.countP += 1;
		
	}
	
	
	/* Setters/Getters */
	public int getId() {
		return id;
	}
	public int getCountC() {
		return countC;
	}
	public void setCountC(int countC) {
		this.countC = countC;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDatePos() {
		return datePos;
	}
	public void setDatePos(String datePos) {
		this.datePos = datePos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	/* ������� ��� ���������� ����������� ����� Contact ��� �� ��������� ���� */
	public void addContact( String fullName, String email) {
		Contact con = new Contact(fullName, email);
		if(patients[this.id] != null) {
			patients[this.id].contacts[countC] = con;
			this.countC += 1;
		}
	}
	
	public void sendEmails(Mail sndml) {
		for(int i=0 ; i<this.countC ; i++) {
			if(this.contacts[i] != null) {
				sndml.Send(this.contacts[i].getEmail());
			}
		}
	}
	
	/* ������� ���������� ������������� ������ */
	public static int searchFullName(String fn) {
		int position = -1;
		for (int i=0 ; i<patients.length ; i++) {
			if (patients[i] != null) {
				if(patients[i].fullName.contentEquals(fn)) {
					position = i;
				}
			}
		}
		return position;
	}


	@Override
	public String toString() {
		return "ID: " + id + "\n�������: " +  fullName + "\n��������: " + phone
				+ "\n���������� ���������: " + datePos + "\nEMAIL: " + email + "\n������: " + Arrays.toString(contacts);
		
	}
	
	
	
}
