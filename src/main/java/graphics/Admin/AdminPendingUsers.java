package graphics.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import graphics.ListAll;
import graphics.Doctor.DoctorProfile;
import graphics.Doctor.DoctorShowPatient;

import javax.swing.JButton;
import javax.swing.JTable;

import users.Users;
import users.UsersController;
import users.reporters.patient.Patient;

@SuppressWarnings("serial")
public class AdminPendingUsers extends ListAll {
	private JButton accept;
	List<Users> ls;
	
	public AdminPendingUsers() {
		
	    accept = new JButton("Accept");
	    accept.setSize(90, 30);
	    accept.setLocation(180, 360);
	    this.select.add(accept);
	    accept.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
    			warning.setVisible(false);
	    		int ind = elements.getSelectedRow();
	    		if(ind == -1)
	    		{
	    			warning.setVisible(true);
	    		}
	    		else
	    		{
	    			Users rm = UsersController.getByUserName(ls.get(ind).getUsername());
	    			rm.setIsActivated(true);
	    			UsersController.merge(rm);
	    			fill();
	    		}
	    	}
	    });
	    
	}

	@Override
	protected void make_elements() {
		ls = UsersController.search_users_by_name("", false);
		elNum = ls.size();
		
		Object [] columnNames = new Object[]{"Type", "First Name", "Last Name", "Username"};
        elements = new JTable( new Object[elNum][4], columnNames ) { 
            public boolean isCellEditable(int row, int column) {
				return false;
			}
        };
		for(int i = 0; i < elNum; i++)
		{
			elements.setValueAt(ls.get(i).getType(), i, 0);
			elements.setValueAt(ls.get(i).getName(), i, 1);
			elements.setValueAt(ls.get(i).getFamilyname(), i, 2);
			elements.setValueAt(ls.get(i).getUsername(), i, 3);
			if(ls.get(i).getType().equals("Patient"))
				this.add(new DoctorShowPatient(notice, (Patient) ls.get(i)), "#" + i); // TODO
			else // Doctors
				this.add(new DoctorProfile(), "#" + i); // TODO
		}
	}
}
