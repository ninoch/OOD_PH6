package graphics.Patient;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import users.reporters.patient.Patient;

import java.awt.Color;

@SuppressWarnings("serial")
public class PatientSignup extends JPanel {
	private JPasswordField pass;
	private JPasswordField pass2;
	private JTextField QP;
	private JTextField AP;
	private JTextField username;
	private JTextField familyName;
	private JTextField name;
	private JTextField id;
	private JTextField tell;
	
	private void clear_all() {
		pass.setText("");
		pass2.setText("");
		QP.setText("");
		AP.setText("");
		username.setText("");
		name.setText("");
		familyName.setText("");
		tell.setText("");
		id.setText("");
	}

	@SuppressWarnings("deprecation")
	public PatientSignup() {
		this.setLayout(null);
		this.setSize(new Dimension(480, 400));
		
		JLabel label_1;
		JLabel label_2;
		JLabel label_3;
		
		name = new JTextField();
		name.setBounds(323, 129, 147, 20);
		this.add(name);
		name.setColumns(10);
		
		JLabel label = new JLabel("\u06A9\u0644\u0645\u0647 \u0639\u0628\u0648\u0631:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(371, 60, 99, 20);
		this.add(label);
		
		label_1 = new JLabel("\u062A\u06A9\u0631\u0627\u0631 \u06A9\u0644\u0645\u0647 \u0639\u0628\u0648\u0631:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(165, 60, 99, 20);
		this.add(label_1);
		
		familyName = new JTextField();
		familyName.setColumns(10);
		familyName.setBounds(117, 129, 147, 20);
		this.add(familyName);
		
		label_2 = new JLabel("\u06A9\u062F \u0645\u0644\u06CC:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(165, 160, 99, 20);
		this.add(label_2);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(117, 178, 147, 20);
		this.add(id);
		
		label_3 = new JLabel("\u062A\u0644\u0641\u0646 \u062A\u0645\u0627\u0633:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(371, 159, 99, 20);
		this.add(label_3);
		
		tell = new JTextField();
		tell.setColumns(10);
		tell.setBounds(323, 178, 147, 20);
		this.add(tell);
		
		JButton add = new JButton("\u062B\u0628\u062A");
		add.setBounds(10, 332, 89, 23);
		this.add(add);
		
		JButton back = new JButton("\u0628\u0627\u0632\u06AF\u0634\u062A");
		back.setBounds(10, 366, 89, 23);
		this.add(back);
		
		pass = new JPasswordField();
		pass.setBounds(323, 78, 147, 20);
		add(pass);
		
		pass2 = new JPasswordField();
		pass2.setBounds(117, 79, 147, 20);
		add(pass2);
		
		JLabel label_4 = new JLabel("\u0646\u0627\u0645:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(371, 111, 99, 20);
		add(label_4);
		
		JLabel label_5 = new JLabel("\u0646\u0627\u0645 \u062E\u0627\u0646\u0648\u0627\u062F\u06AF\u06CC:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(165, 110, 99, 20);
		add(label_5);
		
		JLabel label_6 = new JLabel("\u0633\u0648\u0627\u0644 \u0627\u0645\u0646\u06CC\u062A\u06CC:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(165, 209, 305, 20);
		add(label_6);
		
		QP = new JTextField();
		QP.setColumns(10);
		QP.setBounds(117, 227, 353, 20);
		add(QP);
		
		JLabel label_7 = new JLabel("\u067E\u0627\u0633\u062E \u0627\u0645\u0646\u06CC\u062A\u06CC:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(165, 258, 305, 20);
		add(label_7);
		
		AP = new JTextField();
		AP.setColumns(10);
		AP.setBounds(117, 277, 353, 20);
		add(AP);
		
		JLabel warning = new JLabel("\u062E\u0637\u0627 \u062F\u0631 \u062B\u0628\u062A \u0646\u0627\u0645!");
		warning.setForeground(Color.RED);
		warning.setBounds(109, 370, 177, 14);
		warning.setVisible(false);
		add(warning);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(323, 29, 147, 20);
		add(username);
		
		JLabel label_8 = new JLabel("\u0646\u0627\u0645 \u06A9\u0627\u0631\u0628\u0631\u06CC:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(371, 11, 99, 20);
		add(label_8);
		
		username.setNextFocusableComponent(pass);
		pass.setNextFocusableComponent(pass2);
		pass2.setNextFocusableComponent(name);
		name.setNextFocusableComponent(familyName);
		familyName.setNextFocusableComponent(tell);
		tell.setNextFocusableComponent(id);
		id.setNextFocusableComponent(QP);
		QP.setNextFocusableComponent(AP);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				warning.setVisible(false);
				if(pass.getText().equals(pass2.getText()) == false)
				{
					warning.setText("Password mismatch!");
					warning.setVisible(true);
					return;
				}
				if(pass.getText().length() < 3)
				{
					warning.setText("Password have at least 3 charachters");
					warning.setVisible(true);
					return;
				}
				int num;
				try
				{
					num = Integer.parseInt(id.getText());		
				}
				catch(NumberFormatException nfe)  {
					warning.setText("Patient id must be integer");
					warning.setVisible(true);
					return;
				}
				try {
					new Patient(num, username.getText(), pass.getText(), "", tell.getText(), name.getText(), familyName.getText(), QP.getText(), AP.getText());
				} catch (Exception e) {
					warning.setText(e.getMessage());
					warning.setVisible(true);
					return;
				}
				clear_all();
				PatientSignup.this.setVisible(false);
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear_all();
				PatientSignup.this.setVisible(false);
			}
		});
	}
}
