package graphics.Patient;


import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import medicalinfo.diseaseandcure.Consult;
import users.LoginedUser;
import users.MedicateController;
import users.reporters.doctor.Doctor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.Callable;
import java.awt.Color;

@SuppressWarnings("serial")
public class PatientSendMessage extends JPanel {
	private JTextField title;
	private List<Doctor> dr;
	private JTextField date;
	private JLabel warning;
	private JComboBox<String> to;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PatientSendMessage(Callable<Void> notice) {
		this.setLayout(null);
		this.setSize(new Dimension(480, 400));
		
		to = new JComboBox();
		to.setBounds(169, 11, 211, 20);
		this.add(to);
		
		JLabel lblNewLabel = new JLabel("\u0627\u0646\u062A\u062E\u0627\u0628 \u067E\u0632\u0634\u06A9:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(390, 14, 80, 14);
		add(lblNewLabel);
		
		title = new JTextField();
		title.setBounds(169, 42, 211, 20);
		add(title);
		title.setColumns(10);
		
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
		
		JButton send = new JButton("\u0627\u0631\u0633\u0627\u0644");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ind = to.getSelectedIndex();
				if(ind == -1)
					warning.setVisible(true);
				else
				{
					warning.setVisible(false);
					new Consult(LoginedUser.getUser().getUsername(), dr.get(ind).getUsername(), date.getText(), message.getText(), title.getText());
					try {
						notice.call();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		send.setBounds(10, 328, 89, 23);
		add(send);
		
		JLabel label_2 = new JLabel("\u062A\u0627\u0631\u06CC\u062E \u0627\u0645\u0631\u0648\u0632 ( \u0641\u0631\u0645\u062A \u062F\u0631\u0633\u062A 1394/01/04 ):");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(259, 328, 211, 14);
		add(label_2);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(259, 353, 211, 20);
		add(date);
		
		warning = new JLabel("No doc selected");
		warning.setForeground(Color.RED);
		warning.setBounds(109, 353, 140, 31);
		add(warning);
		warning.setVisible(false);
		
		update();
	}
	
	public void update() {
		// LoginedUser.getUser();
		dr = MedicateController.findAllDoctors(LoginedUser.getUser().getUsername(), true);
		
		for(int i = 0; i < dr.size(); i++)
			to.addItem(dr.get(i).getName());
		
		this.repaint();
	}
}
