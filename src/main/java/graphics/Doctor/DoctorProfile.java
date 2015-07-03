package graphics.Doctor;

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
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class DoctorProfile extends JPanel {
	
	private JTextField name;
	private JTextField familyName;
	private JTextField dId;
	private JTextField telephone;
	private JTextField DQ;
	private JTextField DA;
	private CardLayout cl;
	
	public DoctorProfile() {
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
				DoctorProfile.this.setVisible(false);
			}
		});
		change.setBounds(10, 366, 89, 23);
		content.add(change);
		
		JButton changePass = new JButton("\u062A\u063A\u06CC\u06CC\u0631 \u06A9\u0644\u0645\u0647 \u0639\u0628\u0648\u0631");
		changePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        cl.show(DoctorProfile.this, "changePass");
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
		name.setBounds(251, 36, 219, 20);
		name.setText("Your Name Here");
		content.add(name);
		
		JLabel label_1 = new JLabel("\u0646\u0627\u0645 \u062E\u0627\u0646\u0648\u0627\u062F\u06AF\u06CC:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(141, 11, 100, 14);
		content.add(label_1);
		
		familyName = new JTextField();
		familyName.setColumns(10);
		familyName.setBounds(10, 36, 231, 20);
		familyName.setText("Your Family Name Here");
		content.add(familyName);
		
		JLabel label_2 = new JLabel("\u0634\u0645\u0627\u0631\u0647 \u0646\u0638\u0627\u0645 \u067E\u0632\u0634\u06A9\u06CC:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(370, 67, 100, 14);
		content.add(label_2);
		
		dId = new JTextField();
		dId.setColumns(10);
		dId.setBounds(251, 92, 219, 20);
		dId.setText("3219");
		content.add(dId);
		
		JLabel label_3 = new JLabel("\u062A\u0644\u0641\u0646 \u0645\u0637\u0628:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(157, 125, 84, 14);
		content.add(label_3);
		
		telephone = new JTextField();
		telephone.setText("1234567");
		telephone.setColumns(10);
		telephone.setBounds(22, 150, 219, 20);
		content.add(telephone);
		
		JLabel label_4 = new JLabel("\u0633\u0648\u0627\u0644 \u0627\u0645\u0646\u06CC\u062A\u06CC:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(357, 235, 113, 14);
		content.add(label_4);
		
		DQ = new JTextField();
		DQ.setText("Your Question Here");
		DQ.setColumns(10);
		DQ.setBounds(219, 260, 251, 20);
		content.add(DQ);
		
		JLabel label_5 = new JLabel("\u062C\u0648\u0627\u0628 \u0627\u0645\u0646\u06CC\u062A\u06CC:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(370, 291, 100, 14);
		content.add(label_5);
		
		DA = new JTextField();
		DA.setText("Your Answer Here");
		DA.setColumns(10);
		DA.setBounds(219, 316, 251, 20);
		content.add(DA);
		
		JLabel label_6 = new JLabel("\u0622\u062F\u0631\u0633 \u0645\u0637\u0628:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(370, 125, 100, 14);
		content.add(label_6);
		
		JTextArea address = new JTextArea();
		address.setBounds(251, 154, 219, 70);
		content.add(address);

	}
	public Callable<Void> notice = new Callable<Void>() {
        public Void call() {
            cl.show(DoctorProfile.this, "default");
			return null;
        }
    };

}
