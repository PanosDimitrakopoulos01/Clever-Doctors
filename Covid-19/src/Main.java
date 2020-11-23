package covid;
import java.util.Scanner;

public class Main {

	public static void main (String[]args) {
		String answer = "";
		int count1 = 0;
		String fullname;
		String code;
		String date;
		String mail;
		do {
			Scanner in = new Scanner(System.in);
			boolean flag;
			System.out.println("Εισάγετε το ονοματεπόνηυμο του ασθενούς");
			do {
				fullname = in.nextLine();
				flag = Checks.validation(0,fullname);
				if(!flag) {
					System.out.println("Εισάγετε ξανά σωστά το όνομα του ασθενούς");
				}
			}while (!flag);
			System.out.println("Εισάγετε τον κωδικό του ασθενούς");
			do {
				code = in.nextLine();
				flag = Checks.validation(4,code);
				if(!flag) {
					System.out.println("Εισάγετε ξανά σωστά τον κωδικό του ασθενούς");
				}
			}while (!flag);
			System.out.println("Εισάγετε την ημερομηνία που βγήκε θετικό το κρούσμα στον ιό");
			do {
				date = in.nextLine();
				flag = Checks.validation(1,date);
				if(!flag) {
					System.out.println("Εισάγετε ξανά σωστά την ημερομηνία");
				}
			}while (!flag);
			System.out.println("Εισάγετε το email του ασθενούς");
			do {
				mail = in.nextLine();
				flag = Checks.validation(2,mail);
				if(!flag) {
					System.out.println("Εισάγετε ξανά σωστά το email");
				}
			}while (!flag);
			Patients patient = new Patient(fullname, code, date, mail);
			do {
				int count = 0;
				System.out.printf("Εισάγεται το όνομα της", count+1, "ης επαφής του ασθενούς");
				do {
					name = in.nextLine();
					flag = Checks.validation(0,name);
					if(!flag) {
						System.out.println("Εισάγετε ξανά σωστά το όνομα της επαφής");
					}
				}while (!flag);
				System.out.printf("Εισάγετε το email της", count+1, "ης επαφής του ασθενούς");
				do {
					mail = in.nextLine();
					flag = Checks.validation(2,mail);
					if(!flag) {
						System.out.println("Εισάγετε ξανά σωστά το email");
					}	
				}while (!flag);
				patient[count1].addContact[count];
				count ++;
				System.out.println("Έχει άλλες επαφές ο ασθενής; ΝΑΙ ή ΟΧΙ");
				answer = in.nextLine();
				while (answer != "ΝΑΙ" && answer != "ΟΧΙ") {
					System.out.println("Δώστε μία σωστή απάντηση");
				}
			}while (answer == "ΟΧΙ");
			System.out.println("Θέλετε να εισάγεται τα στοιχεία επόμενου ασθενούς; ΝΑΙ ή ΟΧΙ");
			answer = in.nextLine();
			while (answer != "ΝΑΙ" && answer != "ΟΧΙ") {
				System.out.println("Δώστε μία σωστή απάντηση");				
			}
		}while (answer1 == "ΟΧΙ");
	}
}
	
