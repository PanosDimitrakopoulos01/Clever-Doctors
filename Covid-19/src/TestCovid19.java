import java.util.Scanner;

public class TestCovid19 {

	public static void main(String[] args) {
		
	
		Checks check = new Checks();
		Scanner in = new Scanner(System.in);
		
		String answer;
		boolean flag;
		
		
 

		    do
			{
				System.out.println("ÅéóÜãåôå ôá óôïé÷åßá ôïõ áóèåíÞ!");
				
				System.out.println("ÅéóÜãåôå ôo üíïìá ôïõ áóèåíÞ:");
				do {
					String fullName = in.nextLine();
					flag = check.validation(0, fullName);
					if(!flag) {
						System.out.println("Ìç Ýãêõñç åéóáãùãÞ. ÅéóÜãåôå îáíÜ ôo üíïìá ôïõ áóèåíÞ:");
					}
				} while(!flag);
				
				System.out.println("ÅéóÜãåôå ôo ôçëÝöùíï ôïõ áóèåíÞ:");
				do {
					String phone = in.nextLine();
					flag = check.validation(3, phone);
					if(!flag) {
						System.out.println("Ìç Ýãêõñç åéóáãùãÞ. ÅéóÜãåôå îáíÜ ôo ôçëÝöùíï ôïõ áóèåíÞ:");
					}
				} while(!flag);
		
				
				
				
				
				
			} while (true);


		
		
	
	
		
		
	}
	
     }
	}
}
