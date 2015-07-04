package graphics.Report;


import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import medicalinfo.diseaseandcure.Disease;
import medicalinfo.diseaseandcure.DiseaseController;
import medicalinfo.diseaseandcure.Drug;
import users.LoginedUser;
import users.reporters.doctor.Doctor;
import users.reporters.patient.Patient;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("serial")
public class Illness extends JPanel {
	private JTextField date;
	private JTextField illnessName;
	private JTable table;
	private JTextField DrugUse;
	private JTextField DrugName;
	private JLabel label_2;
	private JLabel label_4;
	private JLabel label_6;
	private Disease diseas = null;
	private Patient patient = null;
	private DefaultTableModel model;
	private JTextArea illnessDescription;
	private JButton add, addDrug;
	
	void make_design(Callable<Void> notice) {

		this.setSize(new Dimension(480, 400));
		this.setLayout(null);
		
		JLabel label = new JLabel("\u062A\u0627\u0631\u06CC\u062E \u062B\u0628\u062A:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(278, 67, 192, 14);
		add(label);
		
		date = new JTextField();
		date.setHorizontalAlignment(SwingConstants.LEFT);
		date.setColumns(10);
		date.setBounds(288, 86, 182, 20);
		add(date);
		
		JLabel label_1 = new JLabel("\u0646\u0627\u0645 \u0628\u06CC\u0645\u0627\u0631\u06CC:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(278, 11, 192, 14);
		add(label_1);
		
		illnessName = new JTextField();
		// illnessName.setText("Allergic rhinit"); // if it is patient
		illnessName.setColumns(10);
		illnessName.setBounds(288, 36, 182, 20);
		add(illnessName);
		
		
		model = new DefaultTableModel(); 
		table = new JTable(model); 
		// Create columns
		model.addColumn("DrugName"); 
		model.addColumn("#s");
		// model.addRow(new Object[] { "nasonex", "2 per day", "1" } ); // if it is patient
		// model.addRow(new Object[] { "antihistamine", "once a day", "6" } ); // if it is patient
      
        table.setRowHeight( 32 );

	    JScrollPane pane = new JScrollPane(table);
	    pane.setSize(460, 142);
	    pane.setLocation(10, 155);
	    pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    pane.setMinimumSize(new Dimension(460, 200));
	    pane.setMaximumSize(new Dimension(460, 200));
	    pane.setPreferredSize(new Dimension(460, 200));
	    this.add( pane );
	    

		illnessDescription = new JTextArea();
		// if it is patient
		// illnessDescription.setText("\u0639\u0637\u0633\u0647 \u062F\u0631 \u0641\u0635\u0644 \u0628\u0647\u0627\u0631\u060C \u0622\u0628\u0631\u06CC\u0632\u0634 \u0628\u06CC\u0646\u06CC \u0645\u062F\u0627\u0648\u0645.");
		illnessDescription.setBounds(10, 36, 262, 108);
		add(illnessDescription);
		
		DrugUse = new JTextField();
		DrugUse.setColumns(10);
		DrugUse.setBounds(245, 333, 160, 20);
		add(DrugUse);
		
		DrugName = new JTextField();
		DrugName.setColumns(10);
		DrugName.setBounds(245, 302, 160, 20);
		add(DrugName);
		
		add = new JButton("\u062B\u0628\u062A");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(diseas == null)
				{
					Doctor dr = ((Doctor)LoginedUser.getUser());
					dr.add_disease(patient.getUsername(), illnessName.getText(), illnessDescription.getText(), date.getText());
					for(int i = 0; i < table.getRowCount(); i++)
					{
						// Add Use
						dr.add_drug(illnessName.getText(), patient.getUsername(), table.getModel().getValueAt(i, 0).toString(), Integer.parseInt(table.getModel().getValueAt(i, 1).toString()));
						System.err.println("here " + i);
					}
				}
				/*
				else {
					
				}
				*/
				// TODO
				clear();
				try {
					notice.call();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add.setBounds(10, 366, 89, 23);
		add(add);
		
		JLabel label_3 = new JLabel("\u062F\u0627\u0631\u0648\u0647\u0627:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(278, 130, 192, 14);
		add(label_3);
		
		addDrug = new JButton("\u0627\u0641\u0632\u0648\u062F\u0646 \u062F\u0627\u0631\u0648");
		addDrug.setBounds(146, 366, 89, 23);
		addDrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(DrugName.getText().equals("") == false && DrugUse.getText().equals("") == false)
					model.addRow(new Object[]{DrugName.getText(), DrugUse.getText()});
			}
		});
		add(addDrug);
		
		label_2 = new JLabel("\u0646\u0627\u0645 \u062F\u0627\u0631\u0648:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(415, 303, 55, 14);
		add(label_2);
		
		label_4 = new JLabel("\u0637\u0631\u06CC\u0642\u0647 \u0645\u0635\u0631\u0641:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(399, 336, 71, 14);
		add(label_4);
		
		label_6 = new JLabel("\u062A\u0648\u0636\u06CC\u062D\u0627\u062A:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(80, 11, 192, 14);
		add(label_6);
	}
	
	public Illness(Callable<Void> notice, Patient patient) {
		make_design(notice);
		clear();
		this.patient = patient;
	}

	public Illness(Callable<Void> notice, Disease _d) {
		make_design(notice);
		setDisease(_d);
	}
	
	private void clear() {
		date.setText("");
		illnessName.setText("");
		illnessDescription.setText("");		
		DrugUse.setText("");
		DrugName.setText("");
		
		date.setEnabled(true);
		illnessName.setEnabled(true);
		illnessDescription.setEnabled(true);
		DrugUse.setEnabled(true);
		DrugName.setEnabled(true);
		add.setVisible(true);
		addDrug.setVisible(true);
		
		for(int i = table.getRowCount() - 1; i >= 0; i--)
			model.removeRow(i);
	}

	public void setDisease(Disease _d)
	{
		this.diseas = _d;
		List<Drug> drugs = DiseaseController.getAllDrugs(diseas.getId());
		date.setText(diseas.getDate());
		illnessName.setText(diseas.getName());
		illnessDescription.setText(diseas.getSyptoms());
		for(int i = 0; i < drugs.size(); i++)
			model.addRow(new Object[]{drugs.get(i).getName(), drugs.get(i).getDose()});
		
		date.setEnabled(false);
		illnessName.setEnabled(false);
		illnessDescription.setEnabled(false);
		DrugUse.setEnabled(false);
		DrugName.setEnabled(false);
		add.setVisible(false);
		addDrug.setVisible(false);
		
		this.repaint();
	}
}
