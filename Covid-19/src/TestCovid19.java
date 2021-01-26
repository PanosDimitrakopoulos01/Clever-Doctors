/*����� ��� �������� ��� main*/

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
	
	/*���������� ��������� �� ������*/
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
	
	/*�������� ��������� ��� ������*/
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
	
	/*���������� �� ����������� ��������*/
	public static void fillTestData() {
		Patient patient;
		patient = new Patient("����� ��������������","6976752011","29/11/2020","mail1@gmail.com");		
		patient.addContact("�������� �����", "probrain2001@gmail.com");                                                                           
		patient.addContact("��������� ��������", "probrain2001@gmail.com");                                                                             
		patient.addContact("����� ���������", "probrain2001@gmail.com");                                                                          
		                                                                                                
		patient = new Patient("����� �����������"   ,"6948349785","15/08/2020","mail2@gmail.com");      
		patient.addContact("������� �����������", "probrain2001@gmail.com");                                                                           
		patient.addContact("��������� ������","probrain2001@gmail.com");                                                                          
		                                                                                                
		patient = new Patient("���� ������������"   ,"6945599889","07/05/2020","mail3@gmail.com");
		patient.addContact("��������� ��������" , "probrain2001@gmail.com");
		patient.addContact("�������� ������������", "probrain2001@gmail.com"); 


		patient = new Patient("������� ���������"   ,"6943452011","29/07/2020","mail4@gmail.com");
		patient.addContact("����� ����������", "probrain2001@gmail.com");

		patient = new Patient("�������� ������"     ,"6943333385","17/06/2011","mail5@gmail.com");
		patient.addContact("������� ������������" , "probrain2001@gmail.com");
		patient.addContact("������� ������"       , "probrain2001@gmail.com");
		patient.addContact("�������� ����������"  , "probrain2001@gmail.com");


		patient = new Patient("������� ���������"   ,"6955599889","19/04/2012","mail6@gmail.com");
		patient.addContact("�������� �������", "probrain2001@gmail.com");
		patient.addContact("���������� �����������", "probrain2001@gmail.com");
		patient.addContact("������ �����", "probrain2001@gmail.com");

		patient = new Patient("����� ����������"    ,"6677777811","17/06/2013","mail7@gmail.com");
		patient.addContact("������� �������", "probrain2001@gmail.com");

		patient = new Patient("��������� �������"   ,"6946669785","11/04/2012","mail8@gmail.com");
		patient.addContact("����� ������", "probrain2001@gmail.com");
		patient.addContact("������ ��������", "probrain2001@gmail.com");
		patient.addContact("������ ���������������", "probrain2001@gmail.com");

		patient = new Patient("��������� �������"   ,"6955599889","17/09/2013","mail9@gmail.com");
		patient.addContact("���� �����"           , "probrain2001@gmail.com");
		patient.addContact("������� ������������" , "probrain2001@gmail.com");

	}
}