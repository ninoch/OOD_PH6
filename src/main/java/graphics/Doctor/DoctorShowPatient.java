package graphics.Doctor;
import graphics.Report.ActivityList;
import graphics.Report.Health;
import graphics.Report.HealthList;
import graphics.Report.Illness;
import graphics.Report.IllnessList;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.concurrent.Callable;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import users.reporters.patient.Patient;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DoctorShowPatient extends JPanel {
	private JTextField name;
	private JTextField familyName;
	private CardLayout cl;
	private JPanel select;
	private Patient patient;

	public DoctorShowPatient(Callable<Void> notice, Patient patient) {
		this.setLayout(new CardLayout());
		this.setSize(new Dimension(480, 400));
		
		HealthList hl = new HealthList();
		IllnessList il = new IllnessList();
		ActivityList al = new ActivityList();
		
		this.add(new Health(this.notice, patient), "health");
		this.add(new Illness(this.notice, patient), "illness");
		this.add(new DoctorToDoctor(this.notice, patient), "consult");
		this.add(hl, "healthList");
		this.add(il, "illnessList");
		this.add(al, "activityList");

		select = new JPanel();
		select.setLayout(null);
		select.setSize(new Dimension(480, 400));
		this.add(select, "default");
		

        cl = (CardLayout)(this.getLayout());
        cl.show(this, "default");
		
		JLabel label = new JLabel("\u0646\u0627\u0645 \u0628\u06CC\u0645\u0627\u0631:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(247, 11, 223, 14);
		select.add(label);
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setText(patient.getName());
		name.setEditable(false);
		name.setBounds(247, 36, 223, 20);
		select.add(name);
		name.setColumns(10);
		
		JLabel label_1 = new JLabel("\u06A9\u062F \u0645\u0644\u06CC:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(247, 67, 223, 14);
		select.add(label_1);
		
		JLabel label_2 = new JLabel("\u0646\u0627\u0645 \u062E\u0627\u0646\u0648\u0627\u062F\u06AF\u06CC \u0628\u06CC\u0645\u0627\u0631:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(14, 11, 223, 14);
		select.add(label_2);
		
		familyName = new JTextField();
		familyName.setHorizontalAlignment(SwingConstants.RIGHT);
		familyName.setText(patient.getFamilyname());
		familyName.setEditable(false);
		familyName.setColumns(10);
		familyName.setBounds(14, 36, 223, 20);
		select.add(familyName);
		
		JLabel label_3 = new JLabel("\u0645\u0634\u0627\u0647\u062F\u0647 \u0648\u0636\u0639\u06CC\u062A \u0633\u0644\u0627\u0645\u062A:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(318, 162, 152, 14);
		select.add(label_3);
		
		JButton activity = new JButton("\u0641\u0639\u0627\u0644\u06CC\u062A \u0628\u062F\u0646\u06CC");
		activity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				al.setPatient(patient);
		        cl.show(DoctorShowPatient.this, "activityList");
			}
		});
		activity.setBounds(337, 187, 133, 42);
		select.add(activity);
		
		JButton health = new JButton("\u0648\u0636\u0639\u06CC\u062A \u062C\u0633\u0645\u0627\u0646\u06CC");
		health.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hl.setPatient(patient);
		        cl.show(DoctorShowPatient.this, "healthList");
			}
		});
		health.setBounds(337, 240, 133, 42);
		select.add(health);
		
		JButton illness = new JButton("\u0628\u06CC\u0645\u0627\u0631\u06CC \u0648 \u0646\u0633\u062E\u0647");
		illness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				il.setPatient(patient);
		        cl.show(DoctorShowPatient.this, "illnessList");
			}
		});
		illness.setBounds(337, 293, 133, 42);
		select.add(illness);
		
		JButton back = new JButton("\u0628\u0627\u0632\u06AF\u0634\u062A");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					notice.call();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		back.setBounds(51, 347, 69, 42);
		select.add(back);
		
		JButton consult = new JButton("\u0627\u0631\u062C\u0627\u0639 \u0628\u06CC\u0645\u0627\u0631");
		consult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(DoctorShowPatient.this, "consult");
			}
		});
		consult.setBounds(194, 187, 133, 42);
		select.add(consult);
		
		JLabel label_4 = new JLabel("\u0639\u0645\u0644\u06CC\u0627\u062A \u0631\u0648\u06CC \u0628\u06CC\u0645\u0627\u0631:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(194, 162, 133, 20);
		select.add(label_4);
		
		JButton addDisease = new JButton("\u062B\u0628\u062A \u0628\u06CC\u0645\u0627\u0631\u06CC \u0648 \u0646\u0633\u062E\u0647");
		addDisease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(DoctorShowPatient.this, "illness");
			}
		});
		addDisease.setBounds(194, 293, 133, 42);
		select.add(addDisease);
		
		JButton addHealth = new JButton("\u062B\u0628\u062A \u0648\u0636\u0639\u06CC\u062A \u0628\u062F\u0646\u06CC");
		addHealth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(DoctorShowPatient.this, "health");
			}
		});
		addHealth.setBounds(194, 240, 133, 42);
		select.add(addHealth);
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	protected Callable<Void> notice = new Callable<Void>() {
        public Void call() {
            cl.show(DoctorShowPatient.this, "default");
			return null;
        }
    };
}
