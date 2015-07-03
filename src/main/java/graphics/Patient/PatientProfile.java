package graphics.Patient;

import graphics.ChangePass;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import users.LoginedUser;
import users.reporters.patient.*;

@SuppressWarnings("serial")
public class PatientProfile extends JPanel {
	private JTextField name;
	private JTextField familyName;
	private JTextField pId;
	private JTextField telephone;
	private JTextField PQ;
	private JTextField PA;
	private CardLayout cl;
	
	public PatientProfile() {
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
				PatientProfile.this.setVisible(false);
			}
		});
		change.setBounds(10, 366, 89, 23);
		content.add(change);
		
		JButton changePass = new JButton("\u062A\u063A\u06CC\u06CC\u0631 \u06A9\u0644\u0645\u0647 \u0639\u0628\u0648\u0631");
		changePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        cl.show(PatientProfile.this, "changePass");
			}
		});
		changePass.setBounds(108, 366, 118, 23);
		content.add(changePass);
		
		JLabel label = new JLabel("\u0646\u0627\u0645:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(424, 11, 46, 14);
		content.add(label);
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setColumns(10);
		name.setBounds(219, 36, 251, 20);
		name.setText((LoginedUser.getUser()).getName());
		content.add(name);
		
		JLabel label_1 = new JLabel("\u0646\u0627\u0645 \u062E\u0627\u0646\u0648\u0627\u062F\u06AF\u06CC:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(370, 67, 100, 14);
		content.add(label_1);
		
		familyName = new JTextField();
		familyName.setHorizontalAlignment(SwingConstants.RIGHT);
		familyName.setColumns(10);
		familyName.setBounds(219, 92, 251, 20);
		familyName.setText((LoginedUser.getUser()).getFamilyname());
		content.add(familyName);
		
		JLabel label_2 = new JLabel("\u06A9\u062F \u0645\u0644\u06CC:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(370, 123, 100, 14);
		content.add(label_2);
		
		pId = new JTextField();
		pId.setHorizontalAlignment(SwingConstants.LEFT);
		pId.setColumns(10);
		pId.setBounds(219, 148, 251, 20);
		pId.setText(String.valueOf(((Patient)LoginedUser.getUser()).getPersonId()));
		content.add(pId);
		
		JLabel label_3 = new JLabel("\u062A\u0644\u0641\u0646:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(424, 179, 46, 14);
		content.add(label_3);
		
		telephone = new JTextField();
		telephone.setHorizontalAlignment(SwingConstants.LEFT);
		telephone.setText(((Patient)LoginedUser.getUser()).getTel());
		telephone.setColumns(10);
		telephone.setBounds(219, 204, 251, 20);
		content.add(telephone);
		
		JLabel label_4 = new JLabel("\u0633\u0648\u0627\u0644 \u0627\u0645\u0646\u06CC\u062A\u06CC:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(357, 235, 113, 14);
		content.add(label_4);
		
		PQ = new JTextField();
		PQ.setHorizontalAlignment(SwingConstants.RIGHT);
		PQ.setText(((Patient)LoginedUser.getUser()).getForgetQuestion());
		PQ.setColumns(10);
		PQ.setBounds(219, 260, 251, 20);
		content.add(PQ);
		
		JLabel label_5 = new JLabel("\u062C\u0648\u0627\u0628 \u0627\u0645\u0646\u06CC\u062A\u06CC:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(370, 291, 100, 14);
		content.add(label_5);
		
		PA = new JTextField();
		PA.setHorizontalAlignment(SwingConstants.RIGHT);
		PA.setText(((Patient)LoginedUser.getUser()).getForgetAnswer());
		PA.setColumns(10);
		PA.setBounds(219, 316, 251, 20);
		content.add(PA);
	}
	public Callable<Void> notice = new Callable<Void>() {
        public Void call() {
            cl.show(PatientProfile.this, "default");
			return null;
        }
    };
}
