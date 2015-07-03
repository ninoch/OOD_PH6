package graphics.Doctor;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import users.UsersDB;
import users.reporters.patient.Patient;
import medicalinfo.diseaseandcure.Consult;

@SuppressWarnings("serial")
public class DoctorMessage extends JPanel {
	private JPanel def;
	private CardLayout cl;
	private JLabel senderName;
	private JLabel lblMessageTitleHere;
	private JTextArea message;
	
	public DoctorMessage(Callable<Void> notice, Consult c) {
		
		this.setSize(new Dimension(480, 400));
		this.setLayout(new CardLayout());
		def = new JPanel();
		def.setLayout(null);
		def.setSize(new Dimension(480, 400));
		cl =  (CardLayout)(this.getLayout());
		
		DoctorToPatient top = new DoctorToPatient(this.notice, null, null);
		
		this.add(def, "default");
		this.add(top, "reply");
        cl.show(this, "default");
		
		JLabel label = new JLabel("\u0641\u0631\u0633\u062A\u0646\u062F\u0647:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(396, 11, 74, 14);
		def.add(label);

	    senderName = new JLabel();
		senderName.setHorizontalAlignment(SwingConstants.RIGHT);
		senderName.setBounds(182, 11, 238, 14);
		def.add(senderName);
		
		message = new JTextArea();
		message.setFont(new Font("Tahoma", Font.PLAIN, 12));
		message.setEditable(false);
		message.setBounds(10, 67, 460, 288);
		def.add(message);
		
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
		def.add(back);
		
		JLabel label_1 = new JLabel("\u0639\u0646\u0648\u0627\u0646:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(424, 36, 46, 14);
		def.add(label_1);
		
		lblMessageTitleHere = new JLabel();
		lblMessageTitleHere.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMessageTitleHere.setBounds(182, 36, 238, 14);
		def.add(lblMessageTitleHere);
		
		JButton reply = new JButton("\u067E\u0627\u0633\u062E");
		System.err.println("reply ro sakhtam");
		reply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient pat = (Patient) UsersDB.getByUserName(c.getAzki());
				top.update(pat, c.getTitle());
				cl.show(DoctorMessage.this, "reply");
			}
		});
		reply.setBounds(94, 366, 89, 23);
		def.add(reply);
		if(c != null)
			update(c);
	}

	
	public Callable<Void> notice = new Callable<Void>() {
        public Void call() {
            cl.show(DoctorMessage.this, "default");
			return null;
        }
    };
    
    public void update(Consult c) {
    	c.setRead(true);
    	senderName.setText(c.getAzki());
    	lblMessageTitleHere.setText(c.getTitle());
    	message.setText(c.getMsg());
    }
}
