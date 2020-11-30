import java.util.Scanner;

public class delete {
	public static void main (String[]args) {
 Scanner input = new Scanner(System.in);
   int answer;
    int x=-1;
    int y;
    int i=0;
	do {
		do{
    System.out.print("If you want to delete a patient Press 1 "
    		+ "If you want to delete the fullname of the patient Press 2 "
    		+ "If you want to delete the dates of the patient Press 3"
    		+ "If you want to delete the id of the patient Press 4 "
    		+ "If you want to delete the email of the patient Press 5 "
    		+ "else press 0");
                answer = input.nextInt();
		}while(answer!=0 ||answer!=1 || answer!=2 ||answer!=3 ||answer!=4 ||answer!=5 );
		      Patient [] patients = new Patient[i];
		      do {
         		 System.out.print("type the firstname");
        	      String  fname = input.nextLine(); 
        	       for ( i=0; i< patients.length; i++) {
        	            if (patients[i].equals(fname)) {
        				   x=i;
        		
        			}
        		  }
        	       
        	   }while(x!=-1);
              switch (answer) {
             case 1:
           	       
           	  
            	  patients[x]= null;
            	  break;
            	  
             case 2:
            	   patient[x].setFullname()= null;
                break;
             case 3:
      	            patient[x].setDates()= null;
               break;
             case 4:
            	
            	 patient[x].setId()=null; 
               
               break;
             case 5:
      	            patients[x].setEmail=null;
            	 
               break;
            
           case 0:
               break;
           }
             
   } while (answer!=0);
	 x=-1;
	 do {
	 do {
	   System.out.print("If you want to delete a Contact  Press 1 "
	    		+ "If you want to delete the fullName of the Contact  Press 2 "
	    		+ "If  you want to delete the email of the Contact  Press 3 "
	    		+ "else press 0");
	                answer = input.nextInt();
			}while(answer!=0 ||answer!=1 || answer!=2 ||answer!=3 ||answer!=4  );
	                Contact  [] contacts  = new Contact [i];
	              System.out.println("Write the fullname");
	            	 
	            	 do {
	           	      String  firstname = input.nextLine(); 
	           	       for ( i=0; i< contacts.length; i++) {
	           			   if (contacts[i].equals(firstname)) {
	           				   x=i;
	           				   
	           			}
	           		  }
	           	       
	           	   }while(x!=-1);
	             switch(answer) {
	             case 1:
	            	contacts[x]=null;
	            	  break;
	             case 2:
	            	    contacts.getFullName[x]=null;
	                break;
	             case 3:
	                    contacts.getEmail[x] = null;
	               break;
	             
	             
	           case 0:
	               break;
	           }
	             
	  } while (answer!=0);
 }}
