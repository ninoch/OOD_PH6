package graphics.Patient;


import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import users.LoginedUser;
import users.reporters.patient.Patient;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.concurrent.Callable;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class PatientAddActivity extends JPanel {
	private JTextField date;
	private JTextField ToHour;
	private JTextField FromHour;
	private JTextField Callery;
	private JTextField Duration;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PatientAddActivity(Callable<Void> notice) {
		this.setLayout(null);
		this.setSize(new Dimension(480, 400));
		
		JLabel label_1 = new JLabel("\u062A\u0627\u0631\u06CC\u062E \u0627\u0645\u0631\u0648\u0632 ( \u0641\u0631\u0645\u062A \u0642\u0627\u0628\u0644 \u0642\u0628\u0648\u0644 1394/01/02 ):");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(254, 314, 216, 14);
		add(label_1);
		
		date = new JTextField();
		date.setBounds(264, 339, 206, 20);
		add(date);
		date.setColumns(10);
		

		JLabel warning = new JLabel();
		warning.setText("warning");
		warning.setForeground(Color.RED);
		warning.setBounds(109, 370, 120, 14);
		warning.setVisible(false);
		add(warning);
		
		JButton add = new JButton("\u062B\u0628\u062A");
		add.setBounds(10, 366, 89, 23);
		add(add);
		
		ToHour = new JTextField();
		ToHour.setColumns(10);
		ToHour.setBounds(264, 283, 206, 20);
		add(ToHour);
		
		JLabel label_2 = new JLabel("تا ساعت:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(254, 258, 216, 14);
		add(label_2);
		
		FromHour = new JTextField();
		FromHour.setColumns(10);
		FromHour.setBounds(264, 227, 206, 20);
		add(FromHour);
		
		JLabel label_3 = new JLabel("از ساعت:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(254, 202, 216, 14);
		add(label_3);
		
		Callery = new JTextField();
		Callery.setColumns(10);
		Callery.setBounds(264, 174, 206, 20);
		add(Callery);
		
		JLabel label = new JLabel("میزان کالری مصرفی:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(254, 149, 216, 14);
		add(label);
		
		Duration = new JTextField();
		Duration.setColumns(10);
		Duration.setBounds(264, 127, 206, 20);
		add(Duration);
		
		JLabel label_4 = new JLabel("مدت زمان:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(254, 102, 216, 14);
		add(label_4);
		
		JComboBox ExType = new JComboBox();
		ExType.setModel(new DefaultComboBoxModel(new String[] {"پیاده روی", "دو", "کوهنوردی", "دوچرخه سواری"}));
		ExType.setSelectedIndex(0);
		ExType.setEditable(true);
		ExType.setBounds(264, 57, 206, 20);
		add(ExType);
		
		JLabel label_5 = new JLabel("نوع فعالیت:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(254, 30, 216, 14);
		add(label_5);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ttype = ExType.getSelectedItem().toString();
				((Patient)LoginedUser.getUser()).addExercise(ttype, Integer.parseInt(Duration.getText()), FromHour.getText(), ToHour.getText(), Integer.parseInt(Callery.getText()), date.getText());
				try {
					notice.call();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
}
