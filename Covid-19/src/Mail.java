/* Kλάση που χρησιμοποιείται για την αποστολή email με γνώρισμα:
 * 		ses: Συνεδρία
 */

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.*;

public class Mail { 
	
	private Session ses;
	final String senderEmail= "probrain2001@gmail.com";
	final String password = "2020team_Covid!";
	
	/* Constructor */
	public Mail() {
		Properties props = new Properties();
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		this.ses = Session.getInstance(props,
		new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, password);
			}
		});

	}
	
	/* Μέθοδος που στέλνει ενημερωτικό email
	 * 		mail: Ο λογαριασμός στον οποίο γίνεται η αποστολή
	 */
	public void Send(String mail) {
		
		try {
			 Message message = new MimeMessage(this.ses);
			 message.setFrom(new InternetAddress(this.senderEmail));
			 message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mail));
			 message.setSubject("Ειδοποίηση Επαφής Covid-19");		
			 message.setText("Σας ενημερώνουμε ότι έχετε έρθει σε επαφή με επιβεβαιωμένο κρούσμα του Covid-19 εντός των τελευταίων 15 ημερών.");
			 
			 Transport.send(message);
			 
			 System.out.println("Done");
			 
			}catch (MessagingException e) {
				
				throw new RuntimeException(e);
				}
			
			}
}
