/* Παράθυρο Διαλόγου μενού επιλογών προγράμματος*/

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainWindow extends JDialog {
	public static Patient patient;
	public static Contact contact;
	
	/*Δράση για την εμφάνιση του PatientDialog για την εισαγωγή στοιχείων ασθενούς, 
	  με το πάτημα του κουμπιού "1. ΕΙΣΑΓΩΓΗ ΣΤΟΙΧΕΙΩΝ ΑΣΘΕΝΗ / ΕΠΑΦΗΣ."*/
	class Action1 implements ActionListener {
	        @Override public void actionPerformed(ActionEvent e) {
	            PatientDialog pd = new PatientDialog(null);
	        }
	    }
	/*Δράση για την εμφάνιση του PatientDialog για την διόρθωση στοιχείων ασθενούς
	  (αφού πρώτα γίνει αναζήτηση), με το πάτημα του κουμπιού "2. ΔΙΟΡΘΩΣΗ ΣΤΟΙΧΕΙΩΝ ΑΣΘΕΝΗ / ΕΠΑΦΗΣ."*/
	class Action2 implements ActionListener {
	        @Override public void actionPerformed(ActionEvent e) {
	            SearchDialog sd = new SearchDialog(null);
	        	if (patient != null) {
	        		PatientDialog pd = new PatientDialog(patient);
	        	}
	        }
	    }
	    
	/*Δράση για την εμφάνιση του PatientDialog για την εμφάνιση στοιχείων ασθενούς,
	  (αφού πρώτα γίνει αναζήτηση), με το πάτημα του κουμπιού "3. ΕΜΦΑΝΙΣΗ ΑΣΘΕΝΗ ΚΑΙ ΕΠΑΦΩΝ ΤΟΥ."*/
	class Action3 implements ActionListener {
	        @Override public void actionPerformed(ActionEvent e) {
	        	SearchDialog sd = new SearchDialog(null);
	        	if (patient != null) {
	        		DisplayDialog pd = new DisplayDialog(patient);
	        	}
	        }
	    }
	 
	/*Δράση για τη διαγραφή ασθενούς (αφού πρώτα γίνει αναζήτηση), 
	  με το πάτημα του κουμπιού "4. ΔΙΑΓΡΑΦΗ ΑΣΘΕΝΗ ΚΑΙ ΕΠΑΦΩΝ ΤΟΥ.*/
	class Action4 implements ActionListener {
		 private JDialog parent;

	        Action4(JDialog parent) {
	            this.parent = parent;
	        }
	        @Override public void actionPerformed(ActionEvent e) {
	        	SearchDialog sd = new SearchDialog(null);
	        	if (patient != null) {
	        		int patientpos = Patient.searchFullName(patient.getFullName());
					Patient.deletePatient(patientpos);
					patient = null;
	        		JOptionPane.showMessageDialog(parent, "Ο Ασθενής Διαγράφηκε Επιτυχώς", "Information", JOptionPane.INFORMATION_MESSAGE);
	        	}
	        }
	    }
	 
	/*Δράση για το κλείσιμο του παραθύρου, με το πάτημα του κουμπιού "5. ΤΕΡΜΑΤΙΣΜΟΣ ΠΡΟΓΡΑΜΜΑΤΟΣ."*/
	class Action5 implements ActionListener {
	       private JDialog parent;

	        Action5(JDialog parent) {
	            this.parent = parent;
	        }
	        @Override public void actionPerformed(ActionEvent e) {
	            parent.dispose();
	        }
	    }
	
	/*Constructor παραθύρου*/
	public MainWindow() {
		setModal(true);
		setTitle("Clever Doctors - Covid-19 Tracking System");
	    setSize(500, 250);
	   
	    setLayout(null);
	    JButton b1 = new JButton("1. ΕΙΣΑΓΩΓΗ ΣΤΟΙΧΕΙΩΝ ΑΣΘΕΝΗ / ΕΠΑΦΗΣ.");
	    b1.setBounds(100,10,300,30);		    add(b1);
	    b1.addActionListener(new Action1());
	    JButton b2 = new JButton("2. ΔΙΟΡΘΩΣΗ ΣΤΟΙΧΕΙΩΝ ΑΣΘΕΝΗ / ΕΠΑΦΗΣ.");
	    b2.setBounds(100,50,300,30);		    add(b2);
	    b2.addActionListener(new Action2());
	    JButton b3 = new JButton("3. ΕΜΦΑΝΙΣΗ ΑΣΘΕΝΗ ΚΑΙ ΕΠΑΦΩΝ ΤΟΥ.");
	    b3.setBounds(100,90,300,30);		    add(b3);
	    b3.addActionListener(new Action3());
	    JButton b4 = new JButton("4. ΔΙΑΓΡΑΦΗ ΑΣΘΕΝΗ ΚΑΙ ΕΠΑΦΩΝ ΤΟΥ.");
	    b4.setBounds(100,130,300,30);		    add(b4);
	    b4.addActionListener(new Action4(this));
	    JButton b5 = new JButton("5. ΤΕΡΜΑΤΙΣΜΟΣ ΠΡΟΓΡΑΜΜΑΤΟΣ.");
	    b5.setBounds(100,170,300,30);		    add(b5);
	    b5.addActionListener(new Action5(this));
    
        setVisible(true);
	}
}
