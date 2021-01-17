import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;


public class DisplayDialog extends JDialog{
	
	static Checks check = new Checks();
	private static JTextField t1, t2, t3, t4;
	JButton b1, b2, b3;
	Color red = new Color(255, 0, 0);
	Color black = new Color(0, 0, 0);
	Patient patient;
	Contact contact;
	boolean newPatient;
	
	 class Action1 implements ActionListener {
	        private JDialog parent;

	        Action1(JDialog parent) {
	            this.parent = parent;
	        }
	        @Override public void actionPerformed(ActionEvent e) {
	            parent.dispose();
	        }
	    }

	public DisplayDialog(Patient pat) {
		setModal(true);
	    setSize(450, 450);
	    setLayout(null);
	    setTitle("Clever Doctors - Εμφάνιση Στοιχείων Ασθενή");
	    JTextArea a = new JTextArea(pat.toString());
	    a.setBounds(10, 10, 350, 250);
	    add(a);
	    
	    b1 = new JButton("Έξοδος");
	    b1.setBounds(10,360,150,30);	 add(b1);
	    b1.addActionListener(new Action1(this));
	   	
		this.setVisible(true);
	} 

}
