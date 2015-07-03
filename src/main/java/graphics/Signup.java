package graphics;

import graphics.Doctor.DoctorSignup;
import graphics.Patient.PatientSignup;
import graphics.Pharmacy.PharmacySignup;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;

@SuppressWarnings("serial")
public class Signup extends Layout {
	public Signup() {
		setTitle("\u062B\u0628\u062A \u0646\u0627\u0645");
		JPanel guid = new JPanel();

		guid.setLayout(null);
		guid.setSize(new Dimension(480, 400));
		JLabel label = new JLabel("\u0628\u0631\u0627\u06CC \u062B\u0628\u062A \u0646\u0627\u0645\u061B \u0646\u0648\u0639 \u062D\u0633\u0627\u0628 \u06A9\u0627\u0631\u0628\u0631\u06CC \u062E\u0648\u062F \u0631\u0627 \u0627\u0632 \u0645\u0646\u0648\u06CC \u0628\u0627\u0644\u0627 \u0627\u0646\u062A\u062E\u0627\u0628 \u06A9\u0646\u06CC\u062F.");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setLocation(10, 30);
		label.setSize(435, 20);
		label.setForeground(Color.RED);
		guid.add(label);
		
		content.add(guid, "default");
		
		JLabel label_1 = new JLabel("\u062F\u0631 \u063A\u06CC\u0631 \u0627\u06CC\u0646 \u0635\u0648\u0631\u062A\u060C \u0628\u0627 \u0632\u062F\u0646 \"\u0628\u0627\u0632\u06AF\u0634\u062A \u0628\u0647 \u0635\u0641\u062D\u0647 \u0627\u0635\u0644\u06CC\" \u0628\u0647 \u0635\u0641\u062D\u0647 \u0648\u0631\u0648\u062F \u0628\u0627\u0632 \u062E\u0648\u0627\u0647\u06CC\u062F \u06AF\u0634\u062A.");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setBounds(20, 50, 425, 20);
		guid.add(label_1);
		content.add(new PatientSignup(), "patient");
		content.add(new PharmacySignup(), "pharmacy");
		content.add(new DoctorSignup(), "doctor");
		
		// Making Menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 490, 30);
		menu.add(menuBar);
		
		JMenu manage = new JMenu("\u0645\u0646\u0648");
		manage.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(manage);
		
		JMenuItem patient = new JMenuItem("\u0628\u06CC\u0645\u0627\u0631");
		patient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        cl.show(content, "patient");
			}
		});
		
		manage.add(patient);
		
		JMenuItem pharmacy = new JMenuItem("\u062F\u0627\u0631\u0648\u062E\u0627\u0646\u0647");
		pharmacy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        cl.show(content, "pharmacy");
			}
		});
		manage.add(pharmacy);
		
		JMenuItem doctor = new JMenuItem("\u062F\u06A9\u062A\u0631");
		doctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(content, "doctor");
			}
		});
		manage.add(doctor);
		
		JMenuItem logout = new JMenuItem("\u0628\u0627\u0632\u06AF\u0634\u062A \u0628\u0647 \u0635\u0641\u062D\u0647 \u0627\u0635\u0644\u06CC");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Signup.this.dispose();
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		manage.add(logout);

	}

}
