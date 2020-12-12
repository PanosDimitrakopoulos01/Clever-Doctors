
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
			mainchoice = menuSelection(1, 5,"еисацете то моулеяо тгс диадийасиас поу хекете ма ейтекесете.");
			
			switch(mainchoice) {
				case 1:
					choice = menuSelection(1, 2, "патгсте: \n 1 циа еисацыцг асхемг \n 2 циа еисацыцг епажгс");
					
					switch (choice) {
						case 1:	
							fullname = inputValue(0,"еисацете то омола тоу асхемг:");
							phone = inputValue(3,"еисацете то тгкежымо тоу асхемг:");	
							date = inputValue(1,"еисацете тгм глеяолгмиа ейдгкысгс тоу иоу:");	
							mail = inputValue(2,"еисацете то E-MAIL тоу асхемг:");
							patient = new Patient(fullname, phone, date, mail);
							answer = inputValue(4,"хекете ма пяовыягсете стгм еисацыцг стоивеиым епажым (маи ╧ ови);");
							if(answer.contentEquals("ови")) {
								break;
							}
						case 2:
							if (choice == 2) {
								fullname = inputValue(0,"еисацете то омола тоу асхемг поу хекете ма еисацете епажес");
							}
							patient = findPatient(fullname);
							if (patient == null) {
								break;
							}
							do {
								contactpos = patient.getCountC()+1;
								fullname = inputValue(0,"еисацете то омола тгс " + contactpos + "гс епажгс тоу асхемг:");
								mail = inputValue(2,"еисацете то E-MAIL тгс " + contactpos + "гс епажгс тоу асхемг:");
								patient.addContact(fullname,mail);
								
								answer = inputValue(4,"хекете ма еисацете аккг епажг(маи ╧ ови);");
							}while (!answer.contentEquals("ови"));
							
							System.out.println("аутолатг емглеяысг епажым йяоуслатос");
							patient.sendEmails(sndml);
					}
					break;
				case 2: {
					fullname = inputValue(0, "еисацете то омола тоу асхемг");
					patient = findPatient(fullname);
					if (patient == null) {
						break;
					}
					System.out.println(patient.toString());
					
					choice = menuSelection(1, 2, "патгсте: \n 1 циа диояхысг стоивеиым асхемг \n 2 циа диояхысг стоивеиым епажгс");
					switch (choice) {
						case 1:
							do {
								printPatientModificationChoices();
								choice3 = menuSelection(1, 4, "поио стоивеио хекете ма диояхысете;");
								switch (choice3) {
									case 1:
										fullname = inputValue(0, "еисацете мео омола асхемг:");
										patient.setFullName(fullname);
										break;
									case 2:
										phone = inputValue(3,"еисацете мео тгкежымо асхемг:");	
										patient.setPhone(phone);
										break;
									case 3:
										date = inputValue(1,"еисацете меа глеяолгмиа ейдгкысгс тоу иоу:");	
										patient.setDatePos(date);
										break;
									case 4:
										mail = inputValue(2,"еисацете мео E-MAIL асхемг:");
										patient.setEmail(mail);
										break;
								}
								answer = inputValue(4,"хекете ма диояхысете акко стоивеио тоу суцйейяилемоу асхемг (маи ╧ ови);");
							} while (answer.contentEquals("ови"));
							break;
						case 2:
							fullname = inputValue(0,"еисацете то омола тгс епажгс.");
							contact = findContact(patient, fullname);
							if (contact == null) {
								break;
							}
							do {
								printContactModificationChoices();
								choice3 = menuSelection(1, 2, "поио стоивеио хекете ма диояхысете;");
								switch (choice3) {
								case 1:
									fullname = inputValue(0, "еисацете мео омола епажгс:");
									contact.setFullName(fullname);
									break;
								case 2:
									mail = inputValue(2,"еисацете мео E-MAIL епажгс:");
									contact.setEmail(mail);
									break;
								}
								answer = inputValue(4,"хекете ма диояхысете акко стоивеио тгс суцйейяилемгс епажгс (маи ╧ ови);");
							} while (answer.contentEquals("ови"));
							break;
						}
				}
				case 3:
					fullname = inputValue(0, "еисацете то омола тоу асхемг");
					patient = findPatient(fullname);
					if (patient == null) {
						break;
					}
					System.out.println(patient.toString());
					break;
				case 4:
					fullname = inputValue(0, "еисацете то омола тоу асхемг");
					patientpos = Patient.searchFullName(fullname);
					if (patientpos == -1) {
						System.out.println("де бяехгйе асхемгс ле ауто то омола"); 
					} else {
						answer = inputValue(4,"еисте сицоуяои циа тгм диацяажг тоу асхемг йаи тым епажым тоу (маи ╧ ови);");
						if (answer.contentEquals("ови")) {
							break;
						}
						Patient.patients[patientpos] = null;
						System.out.println("о асхемгс диацяажтгйе");
					}
			}	
		} while (mainchoice != 5);
		System.out.println("то пяоцяалла теялатистгйе");
		
	}
	
	
		
		
 
	/*лщХОДОР ПОУ ЕЛЖАМъФЕИ ТИР ЙЩЯИЕР ЕПИКОЦщР ТОУ ПЯОЦЯэЛЛАТОР*/
	private static void printChoices() {
		System.out.println("1. еисацыцг стоивеиым асхемг / епажгс.");
		System.out.println("2. диояхысг стоивеиым асхемг / епажгс.");
		System.out.println("3. елжамисг асхемг йаи епажым тоу.");
		System.out.println("4. диацяажг асхемг йаи епажым тоу.");
		System.out.println("5. теялатислос пяоцяаллатос.");
	}
	
	/*лщХОДОР ПОУ ЕЛЖАМъФЕИ ТИР ЕПИКОЦщР ТОУ ВЯчСТГ СВЕТИЙэ ЛЕ ТГМ ДИЭЯХЫСГ СТОИВЕъЫМ ТЫМ АСХЕМЧМ*/
	public static void printPatientModificationChoices() {
		System.out.println("1. диояхысг омолатос");
		System.out.println("2. диояхысг тгкежымоу.");
		System.out.println("3. диояхысг глеяолгмиас диацмысгс.");
		System.out.println("4. диояхысг EMAIL.");
	}
	
	/*лщХОДОР ПОУ ЕЛЖАМъФЕИ ТИР ЕПИКОЦщР ТОУ ВЯчСТГ СВЕТИЙэ ЛЕ ТГМ ДИЭЯХЫСГ СТОИВЕъЫМ ТЫМ ЕПАЖЧМ*/
	public static void printContactModificationChoices() {
		System.out.println("1. диояхысг омолатос");
		System.out.println("2. диояхысг EMAIL.");
	}
	
	/*лщХОДОР ПОУ ЕКщЦВЕИ ЙАИ ЕПИСТЯщЖЕИ ТГМ ЕПИКОЦч ТОУ ВЯчСТГ*/
	public static int menuSelection(int min, int max, String prompt) {
		int choice;
		System.out.println(prompt);
		do {
			choice = in.nextInt();
			in.nextLine();
			if(choice<min || choice>max) {
				System.out.println("еисацыцг лг ецйуягс епикоцгс. паяайакы еисацете нама тгм епикоцг сас.");
			}
		} while(choice<min || choice>max);	
		return choice;
	}

	/*лщХОДОР ЦИА ТГМ ЕИСАЦЫЦч СТОИВЕъЫМ ЙАИ щКЕЦВО ЕЦЙУЯЭТГТАР АУТЧМ*/
	public static String inputValue(int code, String prompt) {
		String value;
		boolean flag;
		System.out.println(prompt);
		do {
			value = in.nextLine();
			flag = check.validation(code,value);
			if(!flag) {
				System.out.println("лг ецйуяг еисацыцг. паяайакы еисацете нама:");
			}
		}while (!flag);
		return value;
	}
	
	/*лщХОДОР ПОУ ЕПИСТЯщЖЕИ ТОМ АСХЕМч ЛЕ ЭМОЛА fn ч null*/
	public static Patient findPatient(String fn) {
		Patient patient = null;
		int patientpos;
		patientpos = Patient.searchFullName(fn);
		if (patientpos == -1) {
			System.out.println("де бяехгйе асхемгс ле ауто то омола"); 
		} else {
			patient = Patient.patients[patientpos];
		}
		return patient;
	}
	
	/*лщХОДОР ПОУ ЕПИСТЯщЖЕИ ТГМ ЕПАЖч ЛЕ ЭМОЛА fn ТОУ АСХЕМч patient ч null*/
	public static Contact findContact(Patient patient, String fn) {
		Contact contact = null;
		int contactpos;
		contactpos = Contact.searchFullName(patient,fn);
		if (contactpos == -1) {
			System.out.println("де бяехгйе епажг ле ауто то омола"); 
		} else {
			contact = patient.contacts[contactpos];
		}
		return contact;
	}
	
}