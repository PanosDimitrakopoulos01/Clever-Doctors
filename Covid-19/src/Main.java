package covid;
import java.util.Scanner;

public class Main {

	public static void main (String[]args) {
		String answer;
		String answer1;
		int count1;
		count1 = 0;
		do {
			Patient [] patients = new Patient[count1];
			Scanner in = new Scanner(System.in);
			boolean flag;
			System.out.println("Εισάγετε το ονοματεπόνηυμο του ασθενούς");
			do {
				String fullname = in.nextLine();
				flag = Checks.validation(0,fullname);
				if(!flag) {
					System.out.println("Εισάγετε ξανά σωστά το όνομα του ασθενούς");
				}
				patients[count1].name = fullname;
			}while (!flag);
			System.out.println("Εισάγετε τον κωδικό του ασθενούς");
			do {
				String code = in.nextLine();
				flag = Checks.validation(4,code);
				if(!flag) {
					System.out.println("Εισάγετε ξανά σωστά τον κωδικό του ασθενούς");
				}
				patients[count1].id = code;
			}while (!flag);
			System.out.println("Εισάγετε την ημερομηνία που βγήκε θετικό το κρούσμα στον ιό");
			System.out.println("Απαιτείται να είναι της μορφής xx/xx");
			do {
				String date = in.nextLine();
				flag = Checks.validation(1,date);
				if(!flag) {
					System.out.println("Εισάγετε ξανά σωστά την ημερομηνία");
				}
				patients[count1].datePos = date;
			}while (!flag);
			System.out.println("Εισάγετε το email του ασθενούς");
			do {
				String mail = in.nextLine();
				flag = Checks.validation(2,mail);
				if(!flag) {
					System.out.println("Εισάγετε ξανά σωστά το email");
				}
				patients[count1].email = mail;
			}while (!flag);
			do {
				int count = 0;
				Contact [] contacts = new Contact[count];
				System.out.printf("Εισάγεται το όνομα της", count+1, "ης επαφής του ασθενούς");
				do {
					String name = in.nextLine();
					flag = Checks.validation(0,name);
					if(!flag) {
						System.out.println("Εισάγετε ξανά σωστά το όνομα της επαφής");
					}
					contacts[count].fullName = name;
				}while (!flag);
				System.out.printf("Εισάγετε το email της", count+1, "ης επαφής του ασθενούς");
				do {
					String mail = in.nextLine();
					flag = Checks.validation(2,mail);
					if(!flag) {
						System.out.println("Εισάγετε ξανά σωστά το email");
					}	
					contacts[count].email = mail;
				}while (!flag);
				count ++;
				patients[count1].contacts[count]=contacts[count];
				System.out.println("Έχει άλλες επαφές ο ασθενής; ΝΑΙ ή ΟΧΙ");
				answer = in.nextLine();
				while (answer != "ΝΑΙ" && answer != "ΟΧΙ") {
					System.out.println("Δώστε μία σωστή απάντηση");
				}
			}while (answer == "ΟΧΙ");
			System.out.println("Θέλετε να εισάγεται τα στοιχεία επόμενου ασθενούς; ΝΑΙ ή ΟΧΙ");
			answer1 = in.nextLine();
			while (answer1 != "ΝΑΙ" && answer1 != "ΟΧΙ") {
				System.out.println("Δώστε μία σωστή απάντηση");				
			}
		}while (answer1 == "ΟΧΙ");
	}
}
	
