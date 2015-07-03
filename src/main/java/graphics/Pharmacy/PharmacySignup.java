package graphics.Pharmacy;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Color;

@SuppressWarnings("serial")
public class PharmacySignup extends JPanel {
	private JTextField PQ;
	private JTextField PA;
	private JPasswordField pass;
	private JPasswordField pass2;
	public PharmacySignup() {
		this.setLayout(null);
		this.setSize(new Dimension(480, 400));
		
		
		JTextField name;
		JLabel label_2;
		JTextField id;
		JLabel label_3;
		JTextField tell;
		
		name = new JTextField();
		name.setBounds(323, 29, 147, 20);
		this.add(name);
		name.setColumns(10);
		
		JLabel label = new JLabel("\u0646\u0627\u0645 \u062F\u0627\u0631\u0648\u062E\u0627\u0646\u0647:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(371, 11, 99, 20);
		this.add(label);
		
		label_2 = new JLabel("\u067E\u0631\u0648\u0627\u0646\u0647 \u062A\u0627\u0633\u06CC\u0633 \u062F\u0627\u0631\u0648\u062E\u0627\u0646\u0647:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(323, 60, 147, 20);
		this.add(label_2);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(323, 85, 147, 20);
		this.add(id);
		
		label_3 = new JLabel("\u062A\u0644\u0641\u0646 \u062A\u0645\u0627\u0633:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(98, 112, 99, 20);
		this.add(label_3);
		
		tell = new JTextField();
		tell.setColumns(10);
		tell.setBounds(48, 143, 147, 20);
		this.add(tell);
		
		JButton add = new JButton("\u062B\u0628\u062A");
		add.setBounds(10, 332, 89, 23);
		this.add(add);
		
		JButton back = new JButton("\u0628\u0627\u0632\u06AF\u0634\u062A");
		back.setBounds(10, 366, 89, 23);
		this.add(back);
		
		JTextArea address = new JTextArea();
		address.setBounds(215, 147, 255, 90);
		this.add(address);
		
		JLabel label_4 = new JLabel("\u0622\u062F\u0631\u0633:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(371, 116, 99, 20);
		this.add(label_4);
		
		JLabel label_1 = new JLabel("\u0633\u0648\u0627\u0644 \u0627\u0645\u0646\u06CC\u062A\u06CC:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(371, 248, 99, 20);
		add(label_1);
		
		PQ = new JTextField();
		PQ.setColumns(10);
		PQ.setBounds(215, 266, 255, 20);
		add(PQ);
		
		JLabel label_5 = new JLabel("\u067E\u0627\u0633\u062E \u0627\u0645\u0646\u06CC\u062A\u06CC:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(371, 297, 99, 20);
		add(label_5);
		
		PA = new JTextField();
		PA.setColumns(10);
		PA.setBounds(215, 315, 255, 20);
		add(PA);
		
		JLabel label_6 = new JLabel("\u062A\u06A9\u0631\u0627\u0631 \u06A9\u0644\u0645\u0647 \u0639\u0628\u0648\u0631:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(96, 223, 99, 20);
		add(label_6);
		
		JLabel label_7 = new JLabel("\u06A9\u0644\u0645\u0647 \u0639\u0628\u0648\u0631:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(98, 174, 99, 20);
		add(label_7);
		
		pass = new JPasswordField();
		pass.setBounds(48, 192, 149, 20);
		add(pass);
		
		pass2 = new JPasswordField();
		pass2.setBounds(48, 248, 149, 20);
		add(pass2);
		
		JLabel warning = new JLabel("\u062E\u0637\u0627 \u062F\u0631 \u062B\u0628\u062A \u0646\u0627\u0645!");
		warning.setForeground(Color.RED);
		warning.setBounds(109, 370, 230, 14);
		warning.setVisible(false);
		add(warning);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				warning.setVisible(false);
				// DO SOMTHING HERE TODO
				if(name.getText().equals("warning"))
					warning.setVisible(true);
				else
					PharmacySignup.this.setVisible(false);
				
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PharmacySignup.this.setVisible(false);
			}
		});
	}
}
