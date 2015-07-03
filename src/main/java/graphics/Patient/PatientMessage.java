package graphics.Patient;


import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;

import medicalinfo.diseaseandcure.Consult;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.concurrent.Callable;

@SuppressWarnings("serial")
public class PatientMessage extends JPanel {
	private JTextArea message;
	private JLabel title;
	private JLabel date;
	private JLabel doctorName;
	
	public PatientMessage(Callable<Void> notice, Consult cons) {
		this.setLayout(null);
		this.setSize(new Dimension(480, 400));
	
		JLabel label = new JLabel("\u0641\u0631\u0633\u062A\u0646\u062F\u0647:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(396, 11, 74, 14);
		add(label);
		
		doctorName = new JLabel("\u062F\u06A9\u062A\u0631 \u0641\u0644\u0627\u0646\u06CC");
		doctorName.setHorizontalAlignment(SwingConstants.RIGHT);
		doctorName.setBounds(182, 11, 238, 14);
		add(doctorName);
		
		message = new JTextArea();
		message.setFont(new Font("Tahoma", Font.PLAIN, 12));
		message.setText(cons.getMsg());
		message.setEditable(false);
		message.setBounds(10, 67, 460, 288);
		add(message);
		
		JButton back = new JButton("\u0628\u0627\u0632\u06AF\u0634\u062A");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					notice.call();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		back.setBounds(10, 366, 74, 23);
		add(back);
		
		JLabel label_1 = new JLabel("\u0639\u0646\u0648\u0627\u0646:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(424, 36, 46, 14);
		add(label_1);
		
		title = new JLabel("\u06CC\u06A9 \u067E\u06CC\u063A\u0627\u0645 \u062C\u0627\u0644\u0628");
		title.setHorizontalAlignment(SwingConstants.RIGHT);
		title.setBounds(239, 36, 181, 14);
		add(title);
		title.setText(cons.getTitle());
		
		JLabel lblNewLabel = new JLabel("\u062A\u0627\u0631\u06CC\u062E:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(192, 36, 39, 14);
		add(lblNewLabel);
		
		date = new JLabel("1394/01/02");
		date.setHorizontalAlignment(SwingConstants.RIGHT);
		date.setBounds(10, 36, 181, 14);
		add(date);
		

		if(cons != null)
			set_msg(cons);
	}
	
	void set_msg(Consult cons){
		doctorName.setText(cons.getAzki());
		message.setText(cons.getMsg());
		title.setText(cons.getTitle());
		date.setText(cons.getDate());
		cons.setRead(true);
	}
}
