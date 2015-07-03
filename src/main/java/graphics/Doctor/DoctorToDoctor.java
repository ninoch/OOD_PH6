package graphics.Doctor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import users.LoginedUser;
import users.UsersDB;
import users.reporters.doctor.Doctor;
import users.reporters.doctor.SpecialDoctor;
import users.reporters.patient.Patient;

import java.awt.Color;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("serial")
public class DoctorToDoctor extends JPanel {
	private JTextField dName;
	private JTextField expert;
	List<Doctor> drs;
	private JTable table;
	private JScrollPane pane;

	public DoctorToDoctor(Callable<Void> notice, Patient patient) {
		this.setLayout(null);
		this.setSize(new Dimension(480, 400));
		
		JLabel label = new JLabel("\u0646\u0627\u0645 \u062E\u0627\u0646\u0648\u0627\u062F\u06AF\u06CC \u067E\u0632\u0634\u06A9:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(326, 11, 144, 14);
		add(label);
		
		dName = new JTextField();
		dName.setBounds(268, 33, 202, 20);
		add(dName);
		dName.setColumns(10);
		
		JLabel label_1 = new JLabel("\u062A\u062E\u0635\u0635:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(110, 11, 144, 14);
		add(label_1);
		
		expert = new JTextField();
		expert.setColumns(10);
		expert.setBounds(52, 33, 202, 20);
		add(expert);
		
		JButton search = new JButton("\u062C\u0633\u062A\u062C\u0648");
		search.setBounds(10, 64, 89, 23);
		add(search);
		 
		// Making Select
        table = new JTable();
        
        
	    pane = new JScrollPane(table);
	    pane.setLocation(20, 100);
	    pane.setSize(450, 244);
	    pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    pane.setVisible(false);
	    
	    JButton send = new JButton("\u0627\u0631\u062C\u0627\u0639 \u0628\u06CC\u0645\u0627\u0631");
	    send.setLocation(20, 355);
	    send.setSize(89, 30);
	    send.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int ind = table.getSelectedRow();
	    		if(ind != -1)
	    		{
	    			((Doctor)LoginedUser.getUser()).make_refr(drs.get(ind).getUsername(), patient.getUsername());
	    			drs.get(ind);
		    		try {
						notice.call();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
	    		}
	    	}
	    });
	    send.setVisible(false);
	    
	    this.add(pane);
	    this.add(send);
	    
	    JLabel warning = new JLabel("\u067E\u0632\u0634\u06A9\u06CC \u06CC\u0627\u0641\u062A \u0646\u0634\u062F.");
	    warning.setForeground(Color.RED);
	    warning.setBounds(109, 73, 144, 14);
	    warning.setVisible(false);
	    add(warning);
	    
	    search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pane.setVisible(false);
				send.setVisible(false);
			    warning.setVisible(false);
			    drs = UsersDB.searchSpecialDoctors(dName.getText(), expert.getText());
			    draw_table();
				pane.setVisible(true);
				send.setVisible(true);
			}
		});

	}
	
	private void draw_table() {
		Object [] columnNames = new Object[]{"Doctor Name", "Doctor ID", "Speciality", "Address"};
		table = new JTable( new Object[drs.size()][4], columnNames ) { 
            public boolean isCellEditable(int row, int column) {
            	return false;
			}
        };
        System.err.println("drs: " + drs.size());
		for(int i = 0; i < drs.size(); i++)
		{
			table.setValueAt(drs.get(i).getName(), i, 0);
			table.setValueAt(drs.get(i).getTel(), i, 1);
			table.setValueAt(((SpecialDoctor)drs.get(i)).getSpecialty(), i, 2);
			table.setValueAt(drs.get(i).getAddress(), i, 3);
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(0).setWidth(80);

		table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setWidth(80);

		table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setWidth(80);
        
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setWidth(200);
        
        this.remove(pane);
        pane = new JScrollPane(table);
	    pane.setLocation(20, 100);
	    pane.setSize(450, 244);
	    pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    pane.setVisible(false);
	    this.add(pane);
	}
}
