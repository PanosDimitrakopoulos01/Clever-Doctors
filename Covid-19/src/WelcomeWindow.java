/*Παράθυρο διαλόγου καλωσωρίσματος*/

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class WelcomeWindow extends JDialog {
	
	Color cl = new Color(16, 160, 222);
	Font f = new Font("serif",Font.BOLD + Font.ITALIC, 14);
	
	/*Δράση για την εμφάνιση του παραθύρου MainWindow, με το πάτημα του κουμπιού "Είσοδος στην Εφαρμογή!"*/
	class Action1 implements ActionListener {
		private JDialog parent;

        Action1(JDialog parent) {
            this.parent = parent;
        }
        @Override public void actionPerformed(ActionEvent e) {
        	parent.setVisible(false);
        	MainWindow mw = new MainWindow();
        }
    }
	
	/*Constructor παραθύρου διαλόγου*/
	public WelcomeWindow() {

		setModal(true);
		setTitle("Clever Doctors - Covid-19 Tracking System");
	    setSize(500, 500);
	   
	    setLayout(null);
	    ImageIcon icon = createImageIcon("Covid19.jpg");
	    
		JLabel label1 = new JLabel(icon);
		label1.setBounds(100,10,300,300);	
	    add(label1);
	    JLabel label2 = new JLabel("Καλώς ήρθατε στην εφαρμογή παρακολούθησης επαφών Covid-19", JLabel.CENTER);
		label2.setBounds(50,310,400,100);
		label2.setForeground(cl);
		label2.setFont(f);
	    add(label2);
	    JLabel label3 = new JLabel("της ομάδας Clever-Doctors", JLabel.CENTER);
	    label3.setBounds(50,330,400,100);	
		label3.setForeground(cl);
	    label3.setFont(f);
	    add(label3);
	    
	    JButton b1 = new JButton("Είσοδος στην Εφαρμογή!");
	    b1.setBounds(100,400,300,30);		    add(b1);
	    b1.addActionListener(new Action1(this));
	    
        setVisible(true);
	}
	
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
		return new ImageIcon(imgURL);
		} else {
		System.err.println("Couldn't find file: " + path);
		return null;
		}
	}
}
