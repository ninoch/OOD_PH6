package graphics.Admin;

import graphics.ChangePass;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AdminProfile extends JPanel {
	private JTextField name;
	private JTextField familyName;
	private JTextField telephone;
	private CardLayout cl;
	
	public AdminProfile() {
		this.setLayout(new CardLayout());
		this.setSize(new Dimension(480, 400));

		cl = (CardLayout)(this.getLayout());
		JPanel content = new JPanel();
		content.setLayout(null);
		this.add(content, "default");
		this.add(new ChangePass(this.notice), "changePass");
        cl.show(this, "default");
		
		JButton change = new JButton("\u062B\u0628\u062A \u062A\u063A\u06CC\u06CC\u0631\u0627\u062A");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO change attributes 
				AdminProfile.this.setVisible(false);
			}
		});
		change.setBounds(10, 366, 89, 23);
		content.add(change);
		
		JButton changePass = new JButton("\u062A\u063A\u06CC\u06CC\u0631 \u06A9\u0644\u0645\u0647 \u0639\u0628\u0648\u0631");
		changePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        cl.show(AdminProfile.this, "changePass");
			}
		});
		changePass.setBounds(108, 366, 118, 23);
		content.add(changePass);
		
		JLabel label = new JLabel("\u0646\u0627\u0645:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(424, 11, 46, 14);
		content.add(label);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(219, 36, 251, 20);
		name.setText("Your Name Here");
		content.add(name);
		
		JLabel label_1 = new JLabel("\u0646\u0627\u0645 \u062E\u0627\u0646\u0648\u0627\u062F\u06AF\u06CC:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(370, 67, 100, 14);
		content.add(label_1);
		
		familyName = new JTextField();
		familyName.setColumns(10);
		familyName.setBounds(219, 92, 251, 20);
		familyName.setText("Your Family Name Here");
		content.add(familyName);
		
		JLabel label_2 = new JLabel("\u062A\u0644\u0641\u0646:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(424, 123, 46, 14);
		content.add(label_2);
		
		telephone = new JTextField();
		telephone.setColumns(10);
		telephone.setBounds(219, 148, 251, 20);
		telephone.setText("1234567");
		content.add(telephone);
	}
	
	public Callable<Void> notice = new Callable<Void>() {
        public Void call() {
            cl.show(AdminProfile.this, "default");
			return null;
        }
    };
}
