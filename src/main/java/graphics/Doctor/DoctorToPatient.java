package graphics.Doctor;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import medicalinfo.diseaseandcure.Consult;
import users.LoginedUser;
import users.reporters.patient.Patient;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DoctorToPatient extends JPanel {
	private JTextField date;
	private JLabel title;
	private Patient patient;
	
	public DoctorToPatient(Callable<Void> notice, Patient p, String _title) {
		this.setLayout(null);
		this.setSize(new Dimension(480, 400));
		
		JLabel label = new JLabel("\u0639\u0646\u0648\u0627\u0646 \u067E\u06CC\u0627\u0645:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(390, 39, 80, 14);
		add(label);
		
		JLabel label_1 = new JLabel("\u0645\u062A\u0646 \u067E\u06CC\u0627\u0645:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(390, 77, 80, 14);
		add(label_1);
		
		JTextArea message = new JTextArea();
		message.setBounds(10, 102, 460, 215);
		add(message);
		
		JButton back = new JButton("\u0628\u0627\u0632\u06AF\u0634\u062A");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				try {
					notice.call();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		back.setBounds(10, 366, 89, 23);
		add(back);

		title = new JLabel();
		title.setHorizontalAlignment(SwingConstants.RIGHT);
		title.setBounds(135, 39, 267, 14);
		add(title);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(259, 369, 211, 20);
		add(date);
		
		JLabel label_2 = new JLabel("\u062A\u0627\u0631\u06CC\u062E \u0627\u0645\u0631\u0648\u0632 ( \u0641\u0631\u0645\u062A \u062F\u0631\u0633\u062A 1394/01/04 ):");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(259, 344, 211, 14);
		add(label_2);
		
		JButton send = new JButton("\u0627\u0631\u0633\u0627\u0644");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// int ind = to.getSelectedIndex();
				// System.err.println(to.getSelectedItem() + " is selected");
				new Consult(LoginedUser.getUser().getUsername(), patient.getUsername(), date.getText(), message.getText(), title.getText());
				// TODO
				try {
					notice.call();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		send.setBounds(10, 328, 89, 23);
		add(send);
		
		if(patient != null)
			update(p, _title);
	}
	
	public void update(Patient p, String t) {
		this.patient = p;
		title.setText(t);
	}
}
