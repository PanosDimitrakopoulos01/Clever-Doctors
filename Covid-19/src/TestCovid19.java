import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class TestCovid19 {
	static File fl = new File("Covid19.txt");
	
	public static void main(String[] args) {
		Contact contact;
		Patient patient;

		patient = new Patient("гага агагаг", "1234567890","15/2/2020","adad@gmail.com");
		patient.addContact("памс агагга", "12panos21@gmail.com");

		
		if (fl.exists()) {
			readFromFile(fl);
		}
		new MainWindow();
		saveToFile(fl);
	}
	
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
	
}