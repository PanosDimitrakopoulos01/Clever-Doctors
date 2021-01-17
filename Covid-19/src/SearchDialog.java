import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SearchDialog extends JDialog{
	
	static Checks check = new Checks();
	private static JTextField t1, t2;
	Color red = new Color(255, 0, 0);
	Color black = new Color(0, 0, 0);
	Patient patient;
	Contact contact;
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
				boolean flag;
				flag = check.validation(0,fullname);
	        	if(!flag) {
	        		t1.setForeground(red);
				} else {
					t1.setForeground(black);
				}
	        	if (flag) {
	        		if (patient == null) {
	        			patient = findPatient(t1.getText());
	        			MainWindow.patient = patient;
	        			if (patient == null) {
		        			JOptionPane.showMessageDialog(parent, "�� ������� �������", "Error", JOptionPane.ERROR_MESSAGE);
	        			} else {
	        				parent.dispose();
	        			}	        			
	        		} else {
	        			contact = findContact(patient, t1.getText());
	        			MainWindow.contact = contact;
	        			if (contact == null) {
		        			JOptionPane.showMessageDialog(parent, "�� ������� �����", "Error", JOptionPane.ERROR_MESSAGE);
	        			} else {
	        				parent.dispose();
	        			}	  
	        		}
	        	} else {
	        		JOptionPane.showMessageDialog(parent, "�� ������ ��������", "Error", JOptionPane.ERROR_MESSAGE);
	        	}
	        }
	    }
	 
	public SearchDialog(Patient pat) {
		patient = pat;
		setModal(true);
	    setSize(450, 250);
	    setLayout(null);
	    JLabel l1 = new JLabel("�����: "); 					l1.setBounds(10, 10, 150, 20); add(l1);
	    
	    t1 = new JTextField(); 	t1.setBounds(170, 10, 250, 20); add(t1);
	    
	    JButton b1 = new JButton("�������");
	    b1.setBounds(10,120,150,30);	 add(b1);
	    b1.addActionListener(new Action1(this));
	    JButton b2 = new JButton("���������");
	    b2.setBounds(270,120,150,30);	 add(b2);
	    b2.addActionListener(new Action2(this));
	    
		if (pat == null) {
			setTitle("Clever Doctors - ��������� ������");
		} else {
			setTitle("Clever Doctors - ��������� ������");
		}

		this.setVisible(true);
	} 
	
	/*������� ��� ���������� ��� ������ �� ����� fn � null*/
	public static Patient findPatient(String fn) {
		Patient patient = null;
		int patientpos;
		patientpos = Patient.searchFullName(fn);
		if (patientpos == -1) {
			patient = null;
		} else {
			patient = Patient.patients[patientpos];
		}
		return patient;
	}
	
	/*������� ��� ���������� ��� ����� �� ����� fn ��� ������ patient � null*/
	public static Contact findContact(Patient patient, String fn) {
		Contact contact = null;
		int contactpos;
		contactpos = Contact.searchFullName(patient,fn);
		if (contactpos == -1) {
			contact = null; 
		} else {
			contact = patient.contacts[contactpos];
		}
		return contact;
	}
	
} 

