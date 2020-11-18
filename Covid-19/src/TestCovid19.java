import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class TestCovid19 {

	public static void main(String[] args) {
		
	//	loadDriver();
		Connection conn = null;
		Checks check = new Checks();
		Scanner in = new Scanner(System.in);
		
		String answer;
		boolean flag;
		
		
		
		
		

		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://databases.000webhost.com:3306/id15409111_covid19ts", "id15409111_probrain", "qLbXp8KA<DVILf"); 

		    do
			{
				System.out.println("Εισάγετε τα στοιχεία του ασθενή!");
				
				System.out.println("Εισάγετε τo όνομα του ασθενή:");
				do {
					String fullName = in.nextLine();
					flag = check.validation(0, fullName);
					if(!flag) {
						System.out.println("Μη έγκυρη εισαγωγή. Εισάγετε ξανά τo όνομα του ασθενή:");
					}
				} while(!flag);
				
				System.out.println("Εισάγετε τo τηλέφωνο του ασθενή:");
				do {
					String phone = in.nextLine();
					flag = check.validation(3, phone);
					if(!flag) {
						System.out.println("Μη έγκυρη εισαγωγή. Εισάγετε ξανά τo τηλέφωνο του ασθενή:");
					}
				} while(!flag);
		
				
				
				
				
				
			} while (true);


		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		
		
	
		
		
	}
	
	public static void loadDriver() {
		try {
			//Class.forName("org.mariadb.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
        	System.out.println("No Driver loaded");
     }
	}
}
