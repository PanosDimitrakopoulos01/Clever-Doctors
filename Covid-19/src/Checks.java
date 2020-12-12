/* Κλάση που χρησιμοποιείται για τον έλεγχο της εγκυρότητας των τιμών που εισάγει ο χρήστης.*/
import java.util.regex.*;

public class Checks {
	
	private final static String nameRegex = "[Α-Ω]{3,} [Α-Ω]{3,}";
	private final static String dateRegex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
	private final static String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"; 
	private final static String phoneRegex = "[0-9]{10,10}";
	private final static String answerRegex = "^(?:ΝΑΙ|ΟΧΙ)$";
	
	/* Παράμετροι συνάρτησης:
	 * 		code:	δηλώνει τον τύπο του ελέγχου που θα γίνει
	 * 				0: Έλεγχος Ονόματος
	 * 				1: Έλεγχος Ημερομηνίας
	 * 				2: Έλεγχος email
	 * 				3: Έλεγχος Αριθμού Τηλεφώνου
	 * 				4: Έλεγχος Απάντησης ΝΑΙ/ΟΧΙ
	 * 		value:	η τιμή που εισάγεται από τον χρήστη και ελέγχεται
	 */
	public boolean validation(int code, String value) {
		String regX = null;
		
		switch(code) {
		case 0:
			regX = nameRegex;
			break;
		case 1:
			regX = dateRegex;
			break;
		case 2:
			regX = emailRegex;
			break;
		case 3:
			regX = phoneRegex;
			break;
		case 4:
			regX = answerRegex;
		}
		Pattern pat = Pattern.compile(regX); 
		if (value == null) {
            return false; 
		}
        return pat.matcher(value).matches(); 
	}
}
