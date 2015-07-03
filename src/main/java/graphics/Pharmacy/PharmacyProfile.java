package graphics.Pharmacy;

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
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PharmacyProfile extends JPanel {
	private JTextField name;
	private JTextField dId;
	private JTextField telephone;
	private JTextField DQ;
	private JTextField DA;
	private CardLayout cl;
	
	public PharmacyProfile() {
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
				PharmacyProfile.this.setVisible(false);
			}
		});
		change.setBounds(10, 366, 89, 23);
		content.add(change);
		
		JButton changePass = new JButton("\u062A\u063A\u06CC\u06CC\u0631 \u06A9\u0644\u0645\u0647 \u0639\u0628\u0648\u0631");
		changePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(PharmacyProfile.this, "changePass");
			}
		});
		changePass.setBounds(109, 366, 109, 23);
		content.add(changePass);
		
		JLabel label = new JLabel("\u0646\u0627\u0645:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(424, 11, 46, 14);
		content.add(label);
		
		name = new JTextField();
		name.setText("\u062F\u0627\u0631\u0648\u062E\u0627\u0646\u0647 \u0634\u0631\u06CC\u0641");
		name.setBounds(219, 36, 251, 20);
		content.add(name);
		name.setColumns(10);
		
		JLabel label_1 = new JLabel("\u067E\u0631\u0648\u0627\u0646\u0647 \u062A\u0627\u0633\u06CC\u0633:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(381, 67, 89, 14);
		content.add(label_1);
		
		dId = new JTextField();
		dId.setText("1234567890");
		dId.setColumns(10);
		dId.setBounds(219, 92, 251, 20);
		content.add(dId);
		
		JLabel label_2 = new JLabel("\u0622\u062F\u0631\u0633:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(424, 123, 46, 14);
		content.add(label_2);
		
		JLabel label_3 = new JLabel("\u062A\u0644\u0641\u0646:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(154, 123, 46, 14);
		content.add(label_3);
		
		telephone = new JTextField();
		telephone.setText("02166778899");
		telephone.setColumns(10);
		telephone.setBounds(10, 148, 190, 20);
		content.add(telephone);
		
		JLabel label_4 = new JLabel("\u0633\u0648\u0627\u0644 \u0627\u0645\u0646\u06CC\u062A\u06CC:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(381, 235, 89, 14);
		content.add(label_4);
		
		DQ = new JTextField();
		DQ.setText("\u0627\u0633\u0645 \u06AF\u0631\u0628\u0647 \u062A \u0686\u06CC\u0647\u061F");
		DQ.setColumns(10);
		DQ.setBounds(219, 260, 251, 20);
		content.add(DQ);
		
		JLabel label_5 = new JLabel("\u067E\u0627\u0633\u062E \u0627\u0645\u0646\u06CC\u062A\u06CC:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(381, 291, 89, 14);
		content.add(label_5);
		
		DA = new JTextField();
		DA.setText("\u067E\u06CC\u0634\u0648");
		DA.setColumns(10);
		DA.setBounds(219, 316, 251, 20);
		content.add(DA);
		
		JTextArea address = new JTextArea();
		address.setText("\u062A\u0647\u0631\u0627\u0646\u060C \u062E\u06CC\u0627\u0628\u0627\u0646 \u0622\u0632\u0627\u062F\u06CC\u060C \u062F\u0627\u0646\u0634\u06AF\u0627\u0647 \u0634\u0631\u06CC\u0641");
		address.setBounds(219, 148, 251, 76);
		content.add(address);

	}

	public Callable<Void> notice = new Callable<Void>() {
        public Void call() {
            cl.show(PharmacyProfile.this, "default");
			return null;
        }
    };
}
