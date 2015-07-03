package graphics.Report;


import java.awt.Dimension;


import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import users.LoginedUser;
import users.reporters.doctor.Doctor;
import users.reporters.patient.Patient;
import medicalinfo.BodyInfo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.Callable;

@SuppressWarnings("serial")
public class Health extends JPanel {
	private JTextField weight;
	private JTextField value;
	private JTextField date;
	private JTextField pressure;
	private JTextField sugar;
	private BodyInfo info = null;
	private Patient patient = null;
	
	private void make_design(Callable<Void> notice) {
		this.setSize(new Dimension(480, 400));
		this.setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel();
		// Create a couple of columns 
		model.addColumn("value"); 
		model.addColumn("variable");
	    
		weight = new JTextField();
		weight.setText("");
		weight.setBounds(304, 84, 166, 20);
		add(weight);
		weight.setColumns(10);
		
		JLabel lblKg = new JLabel("وزن ( kg ):");
		lblKg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKg.setBounds(304, 63, 166, 14);
		add(lblKg);
		
		JLabel lblCm = new JLabel("قد ( cm ) :");
		lblCm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCm.setBounds(304, 11, 166, 14);
		add(lblCm);
		
		value = new JTextField();
		value.setText("");
		value.setColumns(10);
		value.setBounds(304, 32, 166, 20);
		add(value);
		
		date = new JTextField();
		date.setText("");
		date.setColumns(10);
		date.setBounds(304, 356, 166, 20);
		add(date);
		
		JLabel label_3 = new JLabel("\u062A\u0627\u0631\u06CC\u062E:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(261, 331, 209, 14);
		add(label_3);
		
		JButton addAll = new JButton("\u062B\u0628\u062A");
		addAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(info == null)
				{
					int h = Integer.parseInt(value.getText());
					int w = Integer.parseInt(weight.getText());
					float p = Float.parseFloat(pressure.getText());
					int s = Integer.parseInt(sugar.getText());
					String dt = date.getText();
					((Doctor) LoginedUser.getUser()).insert_body_info(patient.getUsername(), h, w, p, s, dt);
					clear();
				}
				/*
				else
				{
					BodyInfoController.merge();
				}*/
				try {
					notice.call();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		addAll.setBounds(29, 355, 89, 23);
		add(addAll);
		
		JLabel ds = new JLabel("فشار خون ( mmHg ) :\r\n\r\n");
		ds.setHorizontalAlignment(SwingConstants.RIGHT);
		ds.setBounds(314, 115, 156, 14);
		add(ds);
		
		pressure = new JTextField();
		pressure.setText("");
		pressure.setColumns(10);
		pressure.setBounds(304, 136, 166, 20);
		add(pressure);
		
		JLabel label_2 = new JLabel("\u0642\u0646\u062F \u062E\u0648\u0646 :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(314, 167, 156, 14);
		add(label_2);
		
		sugar = new JTextField();
		sugar.setText("");
		sugar.setColumns(10);
		sugar.setBounds(304, 188, 166, 20);
		add(sugar);
	}
	
	public Health(Callable<Void> notice, Patient p) {
		make_design(notice);
		this.patient = p;
	}

	public Health(Callable<Void> notice, BodyInfo _info) {
		make_design(notice);
		set_info(_info);
	}
	
	private void clear() {
		pressure.setText("");
		sugar.setText("");
		date.setText("");
		weight.setText("");
		value.setText("");
	}
	

	public void set_info(BodyInfo i)
	{
		this.info = i;
		pressure.setText(String.valueOf(info.getBloodPressure()));
		sugar.setText(String.valueOf(info.getBloodSugar()));
		date.setText(info.getDate());
		weight.setText(String.valueOf(info.getWeight()));
		value.setText(String.valueOf(info.getHeight()));
	}
}
