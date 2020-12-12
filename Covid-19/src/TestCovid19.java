
import java.util.Scanner;

public class TestCovid19 {
	
	static Checks check = new Checks();
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		Mail sndml = new Mail();
		
		Contact contact;
		Patient patient;
		String answer;
		int mainchoice;
		int choice;
		int choice3;
		int contactpos;
		int patientpos;
		String fullname = "";
		String phone;
		String date;
		String mail;

		do {
			
			printChoices();
			mainchoice = menuSelection(1, 5,"�������� �� ������� ��� ����������� ��� ������ �� ����������.");
			
			switch(mainchoice) {
				case 1:
					choice = menuSelection(1, 2, "�������: \n 1 ��� �������� ������ \n 2 ��� �������� ������");
					
					switch (choice) {
						case 1:	
							fullname = inputValue(0,"�������� �� ����� ��� ������:");
							phone = inputValue(3,"�������� �� �������� ��� ������:");	
							date = inputValue(1,"�������� ��� ���������� ��������� ��� ���:");	
							mail = inputValue(2,"�������� �� E-MAIL ��� ������:");
							patient = new Patient(fullname, phone, date, mail);
							answer = inputValue(4,"������ �� ����������� ���� �������� ��������� ������ (��� � ���);");
							if(answer.contentEquals("���")) {
								break;
							}
						case 2:
							if (choice == 2) {
								fullname = inputValue(0,"�������� �� ����� ��� ������ ��� ������ �� �������� ������");
							}
							patient = findPatient(fullname);
							if (patient == null) {
								break;
							}
							do {
								contactpos = patient.getCountC()+1;
								fullname = inputValue(0,"�������� �� ����� ��� " + contactpos + "�� ������ ��� ������:");
								mail = inputValue(2,"�������� �� E-MAIL ��� " + contactpos + "�� ������ ��� ������:");
								patient.addContact(fullname,mail);
								
								answer = inputValue(4,"������ �� �������� ���� �����(��� � ���);");
							}while (!answer.contentEquals("���"));
							
							System.out.println("�������� ��������� ������ ����������");
							patient.sendEmails(sndml);
					}
					break;
				case 2: {
					fullname = inputValue(0, "�������� �� ����� ��� ������");
					patient = findPatient(fullname);
					if (patient == null) {
						break;
					}
					System.out.println(patient.toString());
					
					choice = menuSelection(1, 2, "�������: \n 1 ��� �������� ��������� ������ \n 2 ��� �������� ��������� ������");
					switch (choice) {
						case 1:
							do {
								printPatientModificationChoices();
								choice3 = menuSelection(1, 4, "���� �������� ������ �� ����������;");
								switch (choice3) {
									case 1:
										fullname = inputValue(0, "�������� ��� ����� ������:");
										patient.setFullName(fullname);
										break;
									case 2:
										phone = inputValue(3,"�������� ��� �������� ������:");	
										patient.setPhone(phone);
										break;
									case 3:
										date = inputValue(1,"�������� ��� ���������� ��������� ��� ���:");	
										patient.setDatePos(date);
										break;
									case 4:
										mail = inputValue(2,"�������� ��� E-MAIL ������:");
										patient.setEmail(mail);
										break;
								}
								answer = inputValue(4,"������ �� ���������� ���� �������� ��� ������������� ������ (��� � ���);");
							} while (answer.contentEquals("���"));
							break;
						case 2:
							fullname = inputValue(0,"�������� �� ����� ��� ������.");
							contact = findContact(patient, fullname);
							if (contact == null) {
								break;
							}
							do {
								printContactModificationChoices();
								choice3 = menuSelection(1, 2, "���� �������� ������ �� ����������;");
								switch (choice3) {
								case 1:
									fullname = inputValue(0, "�������� ��� ����� ������:");
									contact.setFullName(fullname);
									break;
								case 2:
									mail = inputValue(2,"�������� ��� E-MAIL ������:");
									contact.setEmail(mail);
									break;
								}
								answer = inputValue(4,"������ �� ���������� ���� �������� ��� ������������� ������ (��� � ���);");
							} while (answer.contentEquals("���"));
							break;
						}
				}
				case 3:
					fullname = inputValue(0, "�������� �� ����� ��� ������");
					patient = findPatient(fullname);
					if (patient == null) {
						break;
					}
					System.out.println(patient.toString());
					break;
				case 4:
					fullname = inputValue(0, "�������� �� ����� ��� ������");
					patientpos = Patient.searchFullName(fullname);
					if (patientpos == -1) {
						System.out.println("�� ������� ������� �� ���� �� �����"); 
					} else {
						answer = inputValue(4,"����� �������� ��� ��� �������� ��� ������ ��� ��� ������ ��� (��� � ���);");
						if (answer.contentEquals("���")) {
							break;
						}
						Patient.patients[patientpos] = null;
						System.out.println("� ������� �����������");
					}
			}	
		} while (mainchoice != 5);
		System.out.println("�� ��������� ������������");
		
	}
	
	
		
		
 
	/*������� ��� ��������� ��� ������ �������� ��� ������������*/
	private static void printChoices() {
		System.out.println("1. �������� ��������� ������ / ������.");
		System.out.println("2. �������� ��������� ������ / ������.");
		System.out.println("3. �������� ������ ��� ������ ���.");
		System.out.println("4. �������� ������ ��� ������ ���.");
		System.out.println("5. ����������� ������������.");
	}
	
	/*������� ��� ��������� ��� �������� ��� ������ ������� �� ��� �������� ��������� ��� �������*/
	public static void printPatientModificationChoices() {
		System.out.println("1. �������� ��������");
		System.out.println("2. �������� ���������.");
		System.out.println("3. �������� ����������� ���������.");
		System.out.println("4. �������� EMAIL.");
	}
	
	/*������� ��� ��������� ��� �������� ��� ������ ������� �� ��� �������� ��������� ��� ������*/
	public static void printContactModificationChoices() {
		System.out.println("1. �������� ��������");
		System.out.println("2. �������� EMAIL.");
	}
	
	/*������� ��� ������� ��� ���������� ��� ������� ��� ������*/
	public static int menuSelection(int min, int max, String prompt) {
		int choice;
		System.out.println(prompt);
		do {
			choice = in.nextInt();
			in.nextLine();
			if(choice<min || choice>max) {
				System.out.println("�������� �� ������� ��������. �������� �������� ���� ��� ������� ���.");
			}
		} while(choice<min || choice>max);	
		return choice;
	}

	/*������� ��� ��� �������� ��������� ��� ������ ����������� �����*/
	public static String inputValue(int code, String prompt) {
		String value;
		boolean flag;
		System.out.println(prompt);
		do {
			value = in.nextLine();
			flag = check.validation(code,value);
			if(!flag) {
				System.out.println("�� ������ ��������. �������� �������� ����:");
			}
		}while (!flag);
		return value;
	}
	
	/*������� ��� ���������� ��� ������ �� ����� fn � null*/
	public static Patient findPatient(String fn) {
		Patient patient = null;
		int patientpos;
		patientpos = Patient.searchFullName(fn);
		if (patientpos == -1) {
			System.out.println("�� ������� ������� �� ���� �� �����"); 
		} else {
			patient = Patient.patients[patientpos];
		}
		return patient;
	}
	
	/*������� ��� ���������� ��� ����� �� ����� fn ��� ������ patient � null*/
	public static Contact findContact(Patient patient, String fn) {
		Contact contact = null;
		int contactpos;
		contactpos = Contact.searchFullName(patient,fn);
		if (contactpos == -1) {
			System.out.println("�� ������� ����� �� ���� �� �����"); 
		} else {
			contact = patient.contacts[contactpos];
		}
		return contact;
	}
	
}