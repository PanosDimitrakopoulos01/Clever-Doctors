/* Παράθυρο Διαλόγου για την εισαγωγή και διόρθωση στοιχείων ασθενή*/

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PatientDialog extends JDialog{
	
	static Checks check = new Checks();
	private static JTextField t1, t2, t3, t4;
	JButton b1, b2, b3;
	Color red = new Color(255, 0, 0);
	Color black = new Color(0, 0, 0);
	Patient patient;
	Contact contact;
	boolean newPatient;
	
	/*Δράση για το κλείσιμο του παραθύρου, με το πάτημα του κουμπιού "Έξοδος"*/
	class Action1 implements ActionListener {
	        private JDialog parent;

	        Action1(JDialog parent) {
	            this.parent = parent;
	        }
	        @Override public void actionPerformed(ActionEvent e) {
	            parent.dispose();
	        }
	    }
	 
	/*Δράση για την αποθήκευση των δεδομένων, με το πάτημα του κουμπιού "Αποθήκευση"*/
	 class Action2 implements ActionListener {
		 private JDialog parent;

	        Action2(JDialog parent) {
	            this.parent = parent;
	        }
	        @Override public void actionPerformed(ActionEvent e) {
	        	String fullname = t1.getText();
	        	String date = t3.getText();	
	        	String mail = t4.getText();
	        	String phone = t2.getText();	
				boolean flag, OKFlag;
				// Validation δεδομένων, σε περίπτωση σφάλματος το πεδίο με το σφάλμα γίνεται κόκκινο
				//και δεν επιτρέπεται η αποθήκευση
				OKFlag = true;
				flag = check.validation(0,fullname);
	        	if(!flag) {
	        		t1.setForeground(red);
				} else {
					t1.setForeground(black);
				}
	        	OKFlag = OKFlag && flag;
	        	
	        	flag = check.validation(3,phone);
	        	if(!flag) {
	        		t2.setForeground(red);
				} else {
					t2.setForeground(black);
				}
	        	OKFlag = OKFlag && flag;
	        	
	        	flag = check.validation(1,date);
	        	if(!flag) {
	        		t3.setForeground(red);
				} else {
					t3.setForeground(black);
				}
	        	OKFlag = OKFlag && flag;
	        	
	        	flag = check.validation(2,mail);
	        	if(!flag) {
	        		t4.setForeground(red);
				} else {
					t4.setForeground(black);
				}
	        	OKFlag = OKFlag && flag;
	        	if (OKFlag) {
	        		patient = new Patient(fullname, phone, date, mail);
	        		b2.setEnabled(false);
	        		b3.setEnabled(true);
	        	} else {
	        		JOptionPane.showMessageDialog(parent, "Μη Έκγυρη Εισαγωγή", "Error", JOptionPane.ERROR_MESSAGE);
	        	}
	        }
	    }
	 
	 /*Δράση για την εμφάνιση του ContactDialog για την διόρθωση στοιχείων επαφής
	  (αφού πρώτα γίνει αναζήτηση), με το πάτημα του κουμπιού "Διόρθωση Επαφών"*/
	 class Action3 implements ActionListener {
	        @Override public void actionPerformed(ActionEvent e) {
	        	if (!newPatient) {
	        		SearchDialog sd = new SearchDialog(patient);
	        		contact = MainWindow.contact;
	        	}
	        	ContactDialog pd = new ContactDialog(patient, contact);
	        	if (newPatient) {
	        		t1.setText("");
	        		t2.setText("");
	        		t3.setText("");
	        		t4.setText("");
	        		patient = null;
	        	}
        		b2.setEnabled(true);

	        }
	    }
	
	/*Constructor παραθύρου διαλόγου*/
	public PatientDialog(Patient pat) {
		newPatient = (pat == null);
		patient = pat;
		setModal(true);
	    setSize(450, 250);
	    setLayout(null);
	    JLabel l1 = new JLabel("Όνομα: "); 					l1.setBounds(10, 10, 150, 20); add(l1);
	    JLabel l2 = new JLabel("Τηλέφωνο: "); 				l2.setBounds(10, 35, 150, 20); add(l2);
	    JLabel l3 = new JLabel("Ημερομηνία Εκδήλωσης: "); 	l3.setBounds(10, 60, 150, 20); add(l3);
	    JLabel l4 = new JLabel("E-mail: "); 				l4.setBounds(10, 85, 150, 20); add(l4);
	    
	    t1 = new JTextField(); 	t1.setBounds(170, 10, 250, 20); add(t1);
	    t2 = new JTextField(); 	t2.setBounds(170, 35, 250, 20); add(t2);
	    t3 = new JTextField(); 	t3.setBounds(170, 60, 250, 20); add(t3);
	    t4 = new JTextField(); 	t4.setBounds(170, 85, 250, 20); add(t4);
	    
	    b1 = new JButton("Έξοδος");
	    b1.setBounds(10,120,150,30);	 add(b1);
	    b1.addActionListener(new Action1(this));
	    b2 = new JButton("Αποθήκευση");
	    b2.setBounds(270,120,150,30);	 add(b2);
	    b2.addActionListener(new Action2(this));
	    b3 = new JButton();
	    b3.setBounds(270,160,150,30);	 add(b3);
	    b3.addActionListener(new Action3());
	    
		if (pat == null) {
			setTitle("Clever Doctors - Εισαγωγή Νέου Ασθενή");
			b3.setText("Εισαγωγή Επαφών");
			b3.setEnabled(false);
		} else {
			setTitle("Clever Doctors - Διόρθωση Στοιχείων Ασθενή");
			t1.setText(pat.getFullName());
			t2.setText(pat.getPhone());
			t3.setText(pat.getDatePos());
			t4.setText(pat.getEmail());
			b3.setText("Διόρθωση Επαφών");
		}

		this.setVisible(true);
	} 
	

	
}
