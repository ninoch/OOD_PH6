package graphics;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.Callable;

@SuppressWarnings("serial")
public class ChangePass extends JPanel {
	private JPasswordField lastPass;
	private JPasswordField newPass1;
	private JPasswordField newPass2;
	

	public ChangePass(Callable<Void> notice) {
		this.setLayout(null);
		
		JLabel label = new JLabel("\u0631\u0645\u0632 \u0639\u0628\u0648\u0631 \u0641\u0639\u0644\u06CC:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(318, 21, 122, 14);
		add(label);
		
		lastPass = new JPasswordField();
		lastPass.setBounds(299, 46, 141, 20);
		add(lastPass);
		
		JLabel label_1 = new JLabel("\u0631\u0645\u0632 \u0639\u0628\u0648\u0631 \u062C\u062F\u06CC\u062F:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(318, 77, 122, 14);
		add(label_1);
		
		newPass1 = new JPasswordField();
		newPass1.setBounds(299, 102, 141, 20);
		add(newPass1);
		
		JLabel label_2 = new JLabel("\u062A\u06A9\u0631\u0627\u0631 \u0631\u0645\u0632 \u0639\u0628\u0648\u0631 \u062C\u062F\u06CC\u062F:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(318, 133, 122, 14);
		add(label_2);
		
		newPass2 = new JPasswordField();
		newPass2.setBounds(299, 158, 141, 20);
		add(newPass2);
		
		JButton change = new JButton("\u062B\u0628\u062A");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					notice.call();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		change.setBounds(10, 266, 89, 23);
		add(change);

	}
}
