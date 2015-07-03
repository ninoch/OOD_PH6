package graphics.Doctor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import users.reporters.doctor.GeneralDoctor;
import users.reporters.doctor.SpecialDoctor;

import java.awt.Color;

@SuppressWarnings("serial")
public class DoctorSignup extends JPanel {
	private JTextField DQ;
	private JTextField DA;
	private JPasswordField pass;
	private JPasswordField pass2;
	private JTextField specialty;
	private JTextField username;
	private JTextField name;
	private JTextField familyName;
	private JTextField id;
	private JTextField tell;
	private JTextArea address;
	
	private void clear_all() {
		pass.setText("");
		pass2.setText("");
		DQ.setText("");
		DA.setText("");
		username.setText("");
		name.setText("");
		familyName.setText("");
		tell.setText("");
		id.setText("");
		address.setText("");
		specialty.setText("");
	}

	@SuppressWarnings("deprecation")
	public DoctorSignup() {
		this.setLayout(null);
		this.setSize(new Dimension(480, 400));

		JLabel label_1;
		JLabel label_2;
		JLabel label_3;
		
		name = new JTextField();
		name.setBounds(323, 68, 147, 20);
		this.add(name);
		name.setColumns(10);
		
		JLabel label = new JLabel("\u0646\u0627\u0645:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(371, 50, 99, 20);
		this.add(label);
		
		label_1 = new JLabel("\u0646\u0627\u0645 \u062E\u0627\u0646\u0648\u0627\u062F\u06AF\u06CC:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(214, 50, 99, 20);
		this.add(label_1);
		
		familyName = new JTextField();
		familyName.setColumns(10);
		familyName.setBounds(166, 68, 147, 20);
		this.add(familyName);
		
		label_2 = new JLabel("\u0634\u0645\u0627\u0631\u0647 \u0646\u0638\u0627\u0645 \u067E\u0632\u0634\u06A9\u06CC:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(371, 99, 99, 20);
		this.add(label_2);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(323, 117, 147, 20);
		this.add(id);
		
		label_3 = new JLabel("\u062A\u0644\u0641\u0646 \u062A\u0645\u0627\u0633 \u0645\u0637\u0628:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(96, 179, 99, 20);
		this.add(label_3);
		
		tell = new JTextField();
		tell.setColumns(10);
		tell.setBounds(48, 198, 147, 20);
		this.add(tell);
		
		JButton add = new JButton("\u062B\u0628\u062A");
		add.setBounds(10, 332, 89, 23);
		this.add(add);
		
		JButton back = new JButton("\u0628\u0627\u0632\u06AF\u0634\u062A");
		back.setBounds(10, 366, 89, 23);
		this.add(back);
		
		address = new JTextArea();
		address.setBounds(215, 202, 255, 52);
		this.add(address);
		
		JLabel label_4 = new JLabel("\u0622\u062F\u0631\u0633 \u0645\u0637\u0628:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(371, 179, 99, 20);
		this.add(label_4);
		
		JLabel label_5 = new JLabel("\u0633\u0648\u0627\u0644 \u0627\u0645\u0646\u06CC\u062A\u06CC:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(371, 265, 99, 20);
		add(label_5);
		
		DQ = new JTextField();
		DQ.setColumns(10);
		DQ.setBounds(215, 283, 255, 20);
		add(DQ);
		
		JLabel label_6 = new JLabel("\u067E\u0627\u0633\u062E \u0627\u0645\u0646\u06CC\u062A\u06CC:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(371, 317, 99, 20);
		add(label_6);
		
		DA = new JTextField();
		DA.setColumns(10);
		DA.setBounds(215, 335, 255, 20);
		add(DA);
		
		JLabel label_7 = new JLabel("\u06A9\u0644\u0645\u0647 \u0639\u0628\u0648\u0631:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(214, 12, 99, 20);
		add(label_7);
		
		JLabel label_8 = new JLabel("\u062A\u06A9\u0631\u0627\u0631 \u06A9\u0644\u0645\u0647 \u0639\u0628\u0648\u0631:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(58, 11, 99, 20);
		add(label_8);
		
		pass = new JPasswordField();
		pass.setBounds(166, 30, 147, 20);
		add(pass);
		
		pass2 = new JPasswordField();
		pass2.setBounds(10, 30, 147, 20);
		add(pass2);
		
		JLabel warning = new JLabel("\u062E\u0637\u0627 \u062F\u0631 \u062B\u0628\u062A \u0646\u0627\u0645!");
		warning.setForeground(Color.RED);
		warning.setBounds(109, 370, 318, 14);
		warning.setVisible(false);
		add(warning);
		
		JLabel label_9 = new JLabel("\u062A\u062E\u0635\u0635:");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(214, 99, 99, 20);
		add(label_9);
		
		specialty = new JTextField();
		specialty.setColumns(10);
		specialty.setBounds(166, 117, 147, 20);
		add(specialty);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(323, 29, 147, 20);
		add(username);
		
		JLabel label_10 = new JLabel("\u0646\u0627\u0645 \u06A9\u0627\u0631\u0628\u0631\u06CC:");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(371, 11, 99, 20);
		add(label_10);
		

		username.setNextFocusableComponent(pass);
		pass.setNextFocusableComponent(pass2);
		pass2.setNextFocusableComponent(name);
		name.setNextFocusableComponent(familyName);
		familyName.setNextFocusableComponent(id);
		id.setNextFocusableComponent(specialty);
		specialty.setNextFocusableComponent(address);
		address.setNextFocusableComponent(tell);
		tell.setNextFocusableComponent(DQ);
		DQ.setNextFocusableComponent(DA);
		
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
					warning.setText("Doctor id must be integer");
					warning.setVisible(true);
					return;
				}
				try {
					if(specialty.getText().equals(""))
						new GeneralDoctor(num, username.getText(), pass.getText(), address.getText(), tell.getText(), name.getText(), familyName.getText(), DQ.getText(), DA.getText());
					else
						new SpecialDoctor(specialty.getText(), num, username.getText(), pass.getText(), address.getText(), tell.getText(), name.getText(), familyName.getText(), DQ.getText(), DA.getText());
				} catch (Exception e) {
					warning.setText(e.getMessage());
					warning.setVisible(true);
					return;
				}
				System.err.println(name.getText());
				clear_all();
				DoctorSignup.this.setVisible(false);
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear_all();
				DoctorSignup.this.setVisible(false);
			}
		});
	}
}
