package graphics.Doctor;

import graphics.BackGroundImage;
import graphics.Layout;
import graphics.LoginUI;
import graphics.Report.DrugReport;
import graphics.Report.IllnessReport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class DoctorUI extends Layout {

	public DoctorUI() {
		setTitle("\u0645\u062F\u06CC\u0631\u06CC\u062A \u0628\u06CC\u0645\u0627\u0631");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DoctorPatientSearch searchPanel = new DoctorPatientSearch();
		IllnessReport illReportPanel = new IllnessReport();
		DrugReport drugReportPanel = new DrugReport();
		DoctorInbox inboxPat = new DoctorInbox();
		DoctorConsultationsInbox consultInbox = new DoctorConsultationsInbox();
		
		content.add(new BackGroundImage("img/doctor.jpg"), "default");
		content.add(new DoctorProfile(), "profile");
		content.add(inboxPat, "patientsInbox");
		content.add(consultInbox, "consultationsInbox");
		content.add(searchPanel, "psearch");
		DoctorPatientSearchResult search_res = new DoctorPatientSearchResult(this.notice);
		content.add(search_res, "showall");
		content.add(illReportPanel, "illnessReport");
		content.add(drugReportPanel, "drugReport");
		content.add(new EditPrescription(this.notice), "editPrescription");
		
		// Making Patient menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 490, 30);
		menu.add(menuBar);
		
		JMenu menu_1 = new JMenu("\u06AF\u0632\u0627\u0631\u0634 \u06AF\u06CC\u0631\u06CC");
		menuBar.add(menu_1);
		
		JMenuItem illnessReport = new JMenuItem("\u0628\u06CC\u0645\u0627\u0631\u06CC \u0647\u0627");
		illnessReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					illReportPanel.notice.call();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cl.show(content, "illnessReport");
			}
		});
		menu_1.add(illnessReport);
		
		JMenuItem drugsReport = new JMenuItem("\u062F\u0627\u0631\u0648 \u0647\u0627");
		drugsReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					drugReportPanel.notice.call();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cl.show(content, "drugReport");
			}
		});
		menu_1.add(drugsReport);
		
		JMenu menu = new JMenu("\u0628\u06CC\u0645\u0627\u0631\u0627\u0646");
		menuBar.add(menu);
		
		JMenuItem search = new JMenuItem("\u062C\u0633\u062A\u062C\u0648");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					searchPanel.notice.call();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cl.show(content, "psearch");
			}
		});
		menu.add(search);
		
		JMenuItem showAll = new JMenuItem("\u062A\u0645\u0627\u0645 \u0628\u06CC\u0645\u0627\u0631\u0627\u0646");
		showAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search_res.setQuery("");
				cl.show(content, "showall");
			}
		});
		menu.add(showAll);
		
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
				DoctorUI.this.dispose();
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JMenu inbox = new JMenu("\u0635\u0646\u062F\u0648\u0642");
		manage.add(inbox);
		
		JMenuItem consultationMessages = new JMenuItem("\u062F\u0631\u062E\u0648\u0627\u0633\u062A \u067E\u0630\u06CC\u0631\u0634");
		consultationMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultInbox.fill();
				cl.show(content, "consultationsInbox");
			}
		});
		inbox.add(consultationMessages);
		
		JMenuItem patientsMessage = new JMenuItem("\u062F\u0631\u062E\u0648\u0627\u0633\u062A \u0645\u0634\u0627\u0648\u0631\u0647");
		patientsMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inboxPat.update();
				cl.show(content, "patientsInbox");
			}
		});
		inbox.add(patientsMessage);
		manage.add(logout);
	}

}
