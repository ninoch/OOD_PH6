package graphics.Admin;

import graphics.BackGroundImage;
import graphics.Layout;
import graphics.LoginUI;
import graphics.DocAdminCommons.PatientSearch;
import graphics.Report.DrugReport;
import graphics.Report.IllnessReport;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminUI extends Layout {
	
	public AdminUI() {
		setTitle("\u0645\u062F\u06CC\u0631\u06CC\u062A");
		
		IllnessReport illReport = new IllnessReport();
		DrugReport drugReport = new DrugReport();
		AdminPendingUsers allPendings = new AdminPendingUsers();
		AdminAllPatients allPatients = new AdminAllPatients();
		AdminAllDoctors allDoctors = new AdminAllDoctors();
		PatientSearch searchPanel = new PatientSearch();
		
		// Adding contents
		content.add(new BackGroundImage("img/admin.jpg"), "default");
		content.add(new AdminProfile(), "profile");
		content.add(new AdminAllPharmacies(), "phars");
		content.add(allDoctors, "docs");
		content.add(allPatients, "patis");
		content.add(illReport, "illnessReport");
		content.add(drugReport, "drugReport");
		content.add(allPendings, "pendings");
		content.add(searchPanel, "psearch");
		
		
		// Making Admin Menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 490, 30);
		menu.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u06AF\u0632\u0627\u0631\u0634 \u06AF\u06CC\u0631\u06CC");
		menuBar.add(mnNewMenu);
		
		JMenuItem getIllnessReport = new JMenuItem("\u0628\u06CC\u0645\u0627\u0631\u06CC \u0647\u0627");
		getIllnessReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					illReport.notice.call();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cl.show(content, "illnessReport");
			}
		});
		mnNewMenu.add(getIllnessReport);
		
		JMenuItem getDrugReport = new JMenuItem("\u062F\u0627\u0631\u0648 \u0647\u0627");
		getDrugReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					drugReport.notice.call();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cl.show(content, "drugReport");
			}
		});
		mnNewMenu.add(getDrugReport);
		
		JMenu users = new JMenu("\u06A9\u0627\u0631\u0628\u0631\u0627\u0646");
		menuBar.add(users);
		
		JMenuItem drugs = new JMenuItem("\u062F\u0627\u0631\u0648\u062E\u0627\u0646\u0647 \u0647\u0627");
		drugs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(content, "phars");
			}
		});
		users.add(drugs);
		
		JMenuItem doctors = new JMenuItem("\u067E\u0632\u0634\u06A9\u0627\u0646");
		doctors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allDoctors.fill();
				cl.show(content, "docs");
			}
		});
		
		JMenu menu = new JMenu("\u0628\u06CC\u0645\u0627\u0631\u0627\u0646");
		users.add(menu);
		
		JMenuItem patients = new JMenuItem("\u062A\u0645\u0627\u0645 \u0628\u06CC\u0645\u0627\u0631\u0627\u0646");
		menu.add(patients);
		
		JMenuItem patientSearch = new JMenuItem("\u062C\u0633\u062A\u062C\u0648\u06CC \u0628\u06CC\u0645\u0627\u0631");
		patientSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					searchPanel.notice.call();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cl.show(content, "psearch");
			}
		});
		menu.add(patientSearch);
		patients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allPatients.fill();
				cl.show(content, "patis");
			}
		});
		users.add(doctors);
		
		JMenuItem pendings = new JMenuItem("\u06A9\u0627\u0631\u0628\u0631\u0627\u0646 \u062A\u0627\u06CC\u06CC\u062F \u0646\u0634\u062F\u0647");
		pendings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allPendings.fill();
				cl.show(content, "pendings");
			}
		});
		users.add(pendings);
		
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
				AdminUI.this.dispose();
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
