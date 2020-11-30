import java.util.regex.*;

public class Checks {
	
	private static String nameRegex = "[Á-Ù]{3,} [Á-Ù]{3,}";
	private static String dateRegex = "[1-31]"+ "/"+"[1-12]";
	private static String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"; 
	private static String phoneRegex = "[0-9]{10,10}";

	public boolean validation(int code, String value) {
		String regX = "";
		
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
		}
		Pattern pat = Pattern.compile(regX); 
		if (value == null) {
            return false; 
		}
        return pat.matcher(value).matches(); 
	}
}
