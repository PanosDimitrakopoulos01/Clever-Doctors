import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ContactDialog extends JDialog{
	
	static Checks check = new Checks();
	private static JTextField t1, t2;
	Color red = new Color(255, 0, 0);
	Color black = new Color(0, 0, 0);
	Patient patient;
	Mail sndml = new Mail();
	
	 class Action1 implements ActionListener {
	        private JDialog parent;

	        Action1(JDialog parent) {
	            this.parent = parent;
	        }
	        @Override public void actionPerformed(ActionEvent e) {
	            parent.dispose();
	        }
	    }
	 
	 class Action2 implements ActionListener {
		 private JDialog parent;

	        Action2(JDialog parent) {
	            this.parent = parent;
	        }
	        @Override public void actionPerformed(ActionEvent e) {
	        	String fullname = t1.getText();
	        	String mail = t2.getText();
				boolean flag, OKFlag;
				OKFlag = true;
				flag = check.validation(0,fullname);
	        	if(!flag) {
	        		t1.setForeground(red);
				} else {
					t1.setForeground(black);
				}
	        	OKFlag = OKFlag && flag;

	        	flag = check.validation(2,mail);
	        	if(!flag) {
	        		t2.setForeground(red);
				} else {
					t2.setForeground(black);
				}
	        	OKFlag = OKFlag && flag;
	        	if (OKFlag) {
	        		patient.addContact(fullname, mail);
	        		patient.sendEmails(sndml);
	        	} else {
	        		JOptionPane.showMessageDialog(parent, "Μη Έκγυρη Εισαγωγή", "Error", JOptionPane.ERROR_MESSAGE);
	        	}
	        }
	    }
	 
	public ContactDialog(Patient pat, Contact con) {
		patient = pat;
		setModal(true);
	    setSize(450, 250);
	    setLayout(null);
	    JLabel l1 = new JLabel("Όνομα: "); 					l1.setBounds(10, 10, 150, 20); add(l1);
	    JLabel l2 = new JLabel("E-mail: "); 				l2.setBounds(10, 35, 150, 20); add(l2);
	    
	    t1 = new JTextField(); 	t1.setBounds(170, 10, 250, 20); add(t1);
	    t2 = new JTextField(); 	t2.setBounds(170, 35, 250, 20); add(t2);
	    
	    JButton b1 = new JButton("Έξοδος");
	    b1.setBounds(10,120,150,30);	 add(b1);
	    b1.addActionListener(new Action1(this));
	    JButton b2 = new JButton("Αποθήκευση");
	    b2.setBounds(270,120,150,30);	 add(b2);
	    b2.addActionListener(new Action2(this));
	    
		if (con == null) {
			setTitle("Clever Doctors - Εισαγωγή Νέας Επαφής");
		} else {
			setTitle("Clever Doctors - Διόρθωση Στοιχείων Επαφής");
			t1.setText(con.getFullName());
			t2.setText(con.getEmail());
		}

		this.setVisible(true);
	} 
	

	
} 

