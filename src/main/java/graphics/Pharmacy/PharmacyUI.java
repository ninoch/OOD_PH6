package graphics.Pharmacy;

import graphics.BackGroundImage;
import graphics.Layout;
import graphics.LoginUI;
import graphics.Report.DrugReport;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PharmacyUI extends Layout {

	public PharmacyUI() {
		setTitle("\u0645\u062F\u06CC\u0631\u06CC\u062A \u062F\u0627\u0631\u0648\u062E\u0627\u0646\u0647");

		DrugReport drugReport = new DrugReport();
		// Adding contents
		content.add(new BackGroundImage("img/pharmacy.jpg"), "default");
		content.add(new PharmacyProfile(), "profile");
		content.add(new PharmacyDrugSell(), "sell");
		content.add(drugReport, "drugReport");
		
		// Making Pharmacy Menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 490, 30);
		menu.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u06AF\u0632\u0627\u0631\u0634 \u06AF\u06CC\u0631\u06CC");
		menuBar.add(mnNewMenu);
		
		JMenuItem viewReport = new JMenuItem("\u0645\u0634\u0627\u0647\u062F\u0647");
		viewReport.addActionListener(new ActionListener() {
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
		mnNewMenu.add(viewReport);
		
		JMenu manage = new JMenu("\u0645\u062F\u06CC\u0631\u06CC\u062A");
		manage.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(manage);
		
		JMenuItem profile = new JMenuItem("\u067E\u0631\u0648\u0641\u0627\u06CC\u0644");
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        cl.show(content, "profile");
			}
		});
		
		manage.add(profile);
		
		JMenuItem sell = new JMenuItem("\u062B\u0628\u062A \u0641\u0631\u0648\u0634 \u062F\u0627\u0631\u0648");
		sell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        cl.show(content, "sell");
			}
		});
		manage.add(sell);
		
		JMenuItem logout = new JMenuItem("\u062E\u0631\u0648\u062C");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PharmacyUI.this.dispose();
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
