/*Κλάση που περιέχει την main*/

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestCovid19 {
	static File fl = new File("Covid19.txt");
	
	public static void main(String[] args) {

		if (fl.exists()) {
			readFromFile(fl);
		} else {
			fillTestData();
		}
		new WelcomeWindow();
		saveToFile(fl);
	}
	
	/*Απόθηκευση δεδομένων σε αρχείο*/
	private static void saveToFile(File fl) {
		try (var out =
				new ObjectOutputStream(new FileOutputStream(fl))) {
			out.writeInt(Patient.countP);
			for(int i = 0 ;i < Patient.countP ;i++) {
				if(Patient.patients[i] != null) {
					Patient.patients[i].toFile(out);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file " + e.getMessage());
		} catch (IOException e) {
		    System.err.println("Error reading byte: " + e.getMessage());
		}
	}
	
	/*Ανάγνωση δεδομένων από αρχείο*/
	private static void readFromFile(File fl) {
		int count;
		try (var in =
				new ObjectInputStream(new FileInputStream(fl))) {
			count = in.readInt();
			for(int i = 0 ;i < count ;i++) {
				Patient patient = new Patient(" ", " ", " ", " ");
				patient.fromFile(in);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file " + e.getMessage());
		} catch (IOException e) {
		    System.err.println("Error reading byte: " + e.getMessage());
		}
	}
	
	/*Συμπλήρωση με δοκιμαστικά δεδομένα*/
	public static void fillTestData() {
		Patient patient;
		patient = new Patient("Θωμάς Παπαστεργιάδης","6976752011","29/11/2020","mail1@gmail.com");		
		patient.addContact("Μαριλένα Δούκα", "probrain2001@gmail.com");                                                                           
		patient.addContact("Πάτροκλος Πατρινός", "probrain2001@gmail.com");                                                                             
		patient.addContact("Ελένη Πολυδόρου", "probrain2001@gmail.com");                                                                          
		                                                                                                
		patient = new Patient("Αθηνά Οικονομάκου"   ,"6948349785","15/08/2020","mail2@gmail.com");      
		patient.addContact("Γιώργος Καλαμπούκας", "probrain2001@gmail.com");                                                                           
		patient.addContact("Γεράσιμος Δορλής","probrain2001@gmail.com");                                                                          
		                                                                                                
		patient = new Patient("Αφοι Παπαθανασίου"   ,"6945599889","07/05/2020","mail3@gmail.com");
		patient.addContact("Αναστασία Παυλίδου" , "probrain2001@gmail.com");
		patient.addContact("Στεφανία Νικολοπούλου", "probrain2001@gmail.com"); 


		patient = new Patient("Βασίλης Αυλωνίτης"   ,"6943452011","29/07/2020","mail4@gmail.com");
		patient.addContact("Χάρης Αντωνιάδης", "probrain2001@gmail.com");

		patient = new Patient("Χριστίνα Αργύρη"     ,"6943333385","17/06/2011","mail5@gmail.com");
		patient.addContact("Γιάννης Παπαδόπουλος" , "probrain2001@gmail.com");
		patient.addContact("Βασίλης Γκίνης"       , "probrain2001@gmail.com");
		patient.addContact("Κατερίνα Τσούτσουρα"  , "probrain2001@gmail.com");


		patient = new Patient("Βασίλης Αυλωνίτης"   ,"6955599889","19/04/2012","mail6@gmail.com");
		patient.addContact("Κατερίνα Λάσκαρη", "probrain2001@gmail.com");
		patient.addContact("Σπυριδούλα Γερονικολού", "probrain2001@gmail.com");
		patient.addContact("Ειρήνη Σέββα", "probrain2001@gmail.com");

		patient = new Patient("Νίκος Πολυτραμής"    ,"6677777811","17/06/2013","mail7@gmail.com");
		patient.addContact("Γιάννης Χρήστου", "probrain2001@gmail.com");

		patient = new Patient("Αλαφούζος Μιχάλης"   ,"6946669785","11/04/2012","mail8@gmail.com");
		patient.addContact("Σοφία Σπανού", "probrain2001@gmail.com");
		patient.addContact("Θωμαϊς Διαμαντή", "probrain2001@gmail.com");
		patient.addContact("Μάριος Τριανταφυλλίδης", "probrain2001@gmail.com");

		patient = new Patient("Παπαδάτος Κλέωπας"   ,"6955599889","17/09/2013","mail9@gmail.com");
		patient.addContact("Σέβη Μίχου"           , "probrain2001@gmail.com");
		patient.addContact("Μιχάλης Παπαδόπουλος" , "probrain2001@gmail.com");

	}
}