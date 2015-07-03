package graphics.Doctor;

import graphics.ListAll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;

import users.LoginedUser;
import users.Medicate;
import users.MedicateController;
import users.UsersController;
import users.reporters.doctor.GeneralDoctor;
import users.reporters.doctor.SpecialDoctor;
import users.reporters.patient.Patient;

@SuppressWarnings("serial")
public class DoctorConsultationsInbox extends ListAll {

	private JButton remove;
	private JButton accept;
	private List<Medicate> ls;
	
	public DoctorConsultationsInbox() {
		remove = new JButton("Reject");
	    remove.setSize(90, 30);
	    remove.setLocation(280, 360);
	    this.select.add(remove);
	    remove.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
    			warning.setVisible(false);
	    		int ind = elements.getSelectedRow();
	    		if(ind == -1)
	    		{
	    			warning.setVisible(true);
	    		}
	    		else
	    		{
    				((SpecialDoctor) LoginedUser.getUser()).acceptOrReject(ls.get(ind), false);
	    			fill();
	    		}
	    	}
	    });
	    
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
	    			if( LoginedUser.getUser().getType().equals("GeneralDoctor"))
	    				((GeneralDoctor) LoginedUser.getUser()).accept_patient(ls.get(ind).getPatient());
	    			else
	    				((SpecialDoctor) LoginedUser.getUser()).acceptOrReject(ls.get(ind), true);
	    			fill();
	    		}
	    	}
	    });
	}

	@Override
	protected void make_elements() {
		ls = MedicateController.showAllRef(LoginedUser.getUser().getUsername());
		elNum = ls.size();
		
		Object [] columnNames = new Object[]{"Name", "FamilyName", "From"};
        elements = new JTable( new Object[elNum][3], columnNames ) { 
            public boolean isCellEditable(int row, int column) {
				return false;
			}
            /*
            @SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
            */
        };
        for(int i = 0; i < elNum; i++)
 		{
 			// Doctor d = (Doctor) UsersDB.getByUserName();
 			Patient p = (Patient)(UsersController.getByUserName(ls.get(i).getPatient()));
 			// elements.setValueAt(d.getName() + " " + d.getFamilyname(), i, 0);
 			elements.setValueAt(p.getName(), i, 0);
 			elements.setValueAt(p.getFamilyname(), i, 1);
 			this.add(new DoctorShowPatient(this.notice, p), "#" + i);
 		}
	}
}
