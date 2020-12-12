/* Κλάση "Επαφή" του ασθενή με γνωρίσματα:
 * 		fullname: Πλήρες όνομα 
 * 		email:	  Λογαριασμός email
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
		return "ΕΠΑΦΗ:" + fullName + "EMAIL" + email;
	}
	
	public static int searchFullName(Patient patient, String fn) {
		int position = -1;
		for (int i=0 ; i<patient.contacts.length ; i++) {
			if (patient.contacts[i] != null) {
				if(patient.contacts[i].fullName.contentEquals(fn)) {
					position = i;
				}
			}
		}
		return position;
	}
	
}
