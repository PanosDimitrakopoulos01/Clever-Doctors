import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

/* ����� "�����" ��� ������ �� ����������:
 * 		fullname: ������ ����� 
 * 		email:	  ����������� email
 */
public class Contact {

	private String fullName;
	private String email;
	
	/* Constructor */
	public Contact(String fullName, String email) {
		this.fullName = fullName;
		this.email = email;
	}
	
	/* Setters/Getters */
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "�����:" + fullName + "EMAIL" + email;
	}
	
	/*������� ��� ������� �� ����� ���� ������ ��� ���������� �� ���� ��� ���� ������*/
	public static int searchFullName(Patient patient, String fn) {
		int position = -1;
		for (int i = 0 ; i < patient.countC ; i++) { 
			if(patient.contacts[i].fullName.contentEquals(fn)) {
				position = i;
			}
		}
		return position;
	}
	
	/*������� ��� ������ �� �������� ��� ������ ��� ������*/
	public void toFile(ObjectOutputStream fl) {
		try {
			fl.writeObject(this.fullName);
			fl.writeObject(this.email);
		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error writing to file " + e.getMessage());
		}
	}
	
	/*������� ��� �������� �� �������� ��� ������ ��� �� ������*/
	public void fromFile(ObjectInputStream fl) {
		try {
			this.fullName = (String) fl.readObject();
			this.email = (String) fl.readObject();
		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error reading from file " + e.getMessage());
		}catch (ClassNotFoundException e) {
			
		}
	}
}
