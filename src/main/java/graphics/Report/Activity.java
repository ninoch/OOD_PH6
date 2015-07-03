package graphics.Report;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Activity extends JPanel {
	private JTextField oxyjen;
	private JTextField energy;
	private JTextField date;
	private JTextField heartBeat;
	private JTextField time;

	public Activity(Callable<Void> notice) {
		this.setSize(new Dimension(480, 400));
		this.setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel();
		// Create a couple of columns 
		model.addColumn("value"); 
		model.addColumn("variable");
	    
		oxyjen = new JTextField();
		oxyjen.setEditable(false);
		oxyjen.setText("45");
		oxyjen.setBounds(304, 84, 166, 20);
		add(oxyjen);
		oxyjen.setColumns(10);
		
		JLabel lblKg = new JLabel("میانگین اکسیژن مصرف شده ( liter / minute ):");
		lblKg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKg.setBounds(215, 63, 255, 14);
		add(lblKg);
		
		JLabel lblCm = new JLabel("میانگین انرژی مصرف شده ( cal / minute ): ");
		lblCm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCm.setBounds(261, 11, 209, 14);
		add(lblCm);
		
		energy = new JTextField();
		energy.setEditable(false);
		energy.setText("105");
		energy.setColumns(10);
		energy.setBounds(304, 32, 166, 20);
		add(energy);
		
		date = new JTextField();
		date.setEditable(false);
		date.setText("1394/01/13");
		date.setColumns(10);
		date.setBounds(304, 356, 166, 20);
		add(date);
		
		JLabel label_3 = new JLabel("تاریخ:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(261, 331, 209, 14);
		add(label_3);
		
		JButton back = new JButton("بازگشت");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				try {
					notice.call();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		back.setBounds(29, 355, 89, 23);
		add(back);
		
		JLabel ds = new JLabel("میانگین ضربان قلب ( bpm ):");
		ds.setHorizontalAlignment(SwingConstants.RIGHT);
		ds.setBounds(314, 115, 156, 14);
		add(ds);
		
		heartBeat = new JTextField();
		heartBeat.setEditable(false);
		heartBeat.setText("9");
		heartBeat.setColumns(10);
		heartBeat.setBounds(304, 136, 166, 20);
		add(heartBeat);
		
		JLabel label_2 = new JLabel("مدت زمان فعالیت ( minute ):");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(314, 167, 156, 14);
		add(label_2);
		
		time = new JTextField();
		time.setEditable(false);
		time.setText("15");
		time.setColumns(10);
		time.setBounds(304, 188, 166, 20);
		add(time);

	}

}
