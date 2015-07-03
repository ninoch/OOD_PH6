package graphics.Patient;

import graphics.BackGroundImage;
import graphics.Layout;
import graphics.LoginUI;
import graphics.Report.ActivityList;
import graphics.Report.HealthList;
import graphics.Report.IllnessList;
import graphics.Report.PatientReport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import users.LoginedUser;
import users.reporters.patient.Patient;

@SuppressWarnings("serial")
public class PatientUI extends Layout {
	
	public PatientUI() {
		setTitle("\u0645\u062F\u06CC\u0631\u06CC\u062A \u0628\u06CC\u0645\u0627\u0631");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PatientReport patiReport = new PatientReport(this.notice);
		HealthList hl = new HealthList();
		IllnessList il = new IllnessList();
		PatientInbox pinbox = new PatientInbox();
		
		content.add(new BackGroundImage("img/patient.gif"), "default");
		content.add(new PatientProfile(), "profile");
		content.add(pinbox, "inbox");
		content.add(new PatientSendMessage(this.notice), "send");
		content.add(new PatientsAllDoctors(), "alldocs");
		content.add(new PatientSelectDoctor(this.notice), "changedoc");
		content.add(new PatientAddActivity(this.notice), "activity");
		content.add(new ActivityList(), "activityReport");
		content.add(il, "illnessReport");
		content.add(hl, "healthReport");
		content.add(patiReport, "patientReport");
		
		// Making Patient menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 490, 30);
		menu.add(menuBar);
		
		JMenu veiwReports = new JMenu("\u06AF\u0632\u0627\u0631\u0634 \u06AF\u06CC\u0631\u06CC");
		menuBar.add(veiwReports);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u0645\u0634\u0627\u0647\u062F\u0647");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					patiReport.notice.call();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cl.show(content, "patientReport");
			}
		});
		veiwReports.add(mntmNewMenuItem_1);
		
		JMenu menu_1 = new JMenu("\u067E\u0632\u0634\u06A9\u0627\u0646");
		menuBar.add(menu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u062A\u063A\u06CC\u06CC\u0631 \u067E\u0632\u0634\u06A9 \u0639\u0645\u0648\u0645\u06CC");
		menu_1.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(content, "changedoc");
			}
		});
		
		JMenuItem allDoctors = new JMenuItem("\u0645\u0634\u0627\u0647\u062F\u0647 \u067E\u0632\u0634\u06A9\u0627\u0646");
		menu_1.add(allDoctors);
		allDoctors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(content, "alldocs");
			}
		});
		
		JMenu users = new JMenu("\u0648\u0636\u0639\u06CC\u062A \u0633\u0644\u0627\u0645\u062A");
		menuBar.add(users);
		
		JMenuItem activityReport = new JMenuItem("\u0641\u0639\u0627\u0644\u06CC\u062A \u0628\u062F\u0646\u06CC");
		users.add(activityReport);
		activityReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(content, "activityReport");
			}
		});
		
		JMenuItem healthReport = new JMenuItem("\u0648\u0636\u0639\u06CC\u062A \u062C\u0633\u0645\u0627\u0646\u06CC");
		users.add(healthReport);
		healthReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hl.setPatient((Patient) ( LoginedUser.getUser()));
				cl.show(content, "healthReport");
			}
		});
		
		JMenuItem illnessReport = new JMenuItem("\u0633\u0627\u0628\u0642\u0647 \u0628\u06CC\u0645\u0627\u0631\u06CC \u0648 \u062F\u0627\u0631\u0648");
		users.add(illnessReport);
		illnessReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				il.setPatient((Patient)(LoginedUser.getUser()));
				cl.show(content, "illnessReport");
			}
		});
		
		JMenu manage = new JMenu("\u0645\u062F\u06CC\u0631\u06CC\u062A");
		menuBar.add(manage);
		
		JMenuItem profile = new JMenuItem("\u067E\u0631\u0648\u0641\u0627\u06CC\u0644");
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(content, "profile");
			}
		});
		manage.add(profile);
		
		JMenuItem logout = new JMenuItem("\u062E\u0631\u0648\u062C");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientUI.this.dispose();
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem inbox = new JMenuItem("\u0635\u0646\u062F\u0648\u0642 \u062F\u0631\u06CC\u0627\u0641\u062A");
		inbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pinbox.update();
				cl.show(content, "inbox");
			}
		});
		manage.add(inbox);
		
		JMenuItem menuItem = new JMenuItem("\u0627\u0631\u0633\u0627\u0644 \u067E\u06CC\u0627\u0645");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(content, "send");
			}
		});
		manage.add(menuItem);
		
		JMenuItem activity = new JMenuItem("\u062B\u0628\u062A \u0641\u0639\u0627\u0644\u06CC\u062A \u0628\u062F\u0646\u06CC");
		manage.add(activity);
		activity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(content, "activity");
			}
		});
		manage.add(logout);
	}
	
	List<Double> getList(Double minl, Double maxl, int dataNumber)
	{
		List<Double> ls = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < dataNumber; i++)
            ls.add(minl + ( (double) random.nextDouble() * (maxl - minl )) );
        return ls;
	}

}
