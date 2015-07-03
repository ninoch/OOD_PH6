package graphics.Patient;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import users.LoginedUser;
import users.UsersDB;
import users.reporters.patient.Patient;
import users.reporters.doctor.Doctor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("serial")
public class PatientSelectDoctor extends JPanel {
	private JTextField name;
	int docNums;
	private JTable table;
	private JScrollPane scrollPane;
	private List<Doctor> ls;

	public PatientSelectDoctor(Callable<Void> notice) {
		this.setLayout(null);
		this.setSize(new Dimension(480, 400));
		
		JLabel label = new JLabel("\u0646\u0627\u0645 \u067E\u0632\u0634\u06A9:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(406, 11, 64, 14);
		add(label);
		
		name = new JTextField();
		name.setBounds(129, 8, 286, 20);
		add(name);
		name.setColumns(10);
		
		fill();
		
		
		JLabel warning = new JLabel("\u067E\u0632\u0634\u06A9\u06CC \u0627\u0646\u062A\u062E\u0627\u0628 \u0646\u0634\u062F\u0647 \u0627\u0633\u062A!");
		warning.setForeground(Color.RED);
		warning.setBounds(129, 370, 200, 14);
		warning.setVisible(false);
		add(warning);
		
		JButton send = new JButton("\u0627\u0631\u0633\u0627\u0644 \u062F\u0631\u062E\u0648\u0627\u0633\u062A");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Patient) LoginedUser.getUser()).choose_general_doctor(ls.get(table.getSelectedRow()).getUsername());
				// TODO
				warning.setVisible(false);
				int ind = table.getSelectedRow();
				if(ind == -1)
					warning.setVisible(true);
				else
				{
					
					scrollPane.setVisible(false);
					send.setVisible(false);
					try {
						notice.call();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		send.setBounds(10, 366, 109, 23);
		send.setVisible(false);
		add(send);
		
		JButton search = new JButton("\u062C\u0633\u062A\u062C\u0648");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    PatientSelectDoctor.this.remove(scrollPane);
				fill();
				repaint();
				scrollPane.setVisible(true);
				send.setVisible(true);
			}
		});
		search.setBounds(10, 7, 89, 23);
		add(search);
	}
	
	private void fill() {
		ls = UsersDB.get_doctors_by_name(name.getText(), true);
		System.err.println("ollllaq: " + name.getText() + " " + ls.size());
		docNums = ls.size();
		
		Object [] columnNames = new Object[]{"Name", "Id", "Telephone", "Address"};
		table = new JTable( new Object[docNums][4], columnNames ) { 
            public boolean isCellEditable(int row, int column) {
            	return false;
			}
        };
        

		table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(0).setWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(1).setWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setWidth(200);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight( 32 );
		table.clearSelection();
		
	    for (int i = 0; i < docNums; i++)
	    {
			table.setValueAt(ls.get(i).getName() + " " + ls.get(i).getFamilyname(), i, 0);
			table.setValueAt(ls.get(i).getDocId(), i, 1);
			table.setValueAt(ls.get(i).getTel(), i, 2);
			table.setValueAt(ls.get(i).getAddress(), i, 3);
	    }
	    
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 36, 460, 319);
		scrollPane.setVisible(false);
		this.add(scrollPane);
	}
}
