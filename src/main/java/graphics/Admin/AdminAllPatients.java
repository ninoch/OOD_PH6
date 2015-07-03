package graphics.Admin;

import java.util.List;

import users.UsersDB;
import users.reporters.patient.Patient;
import graphics.ListAll;
import graphics.Doctor.DoctorShowPatient;

import javax.swing.JTable;

@SuppressWarnings("serial")
public class AdminAllPatients extends ListAll {

	public AdminAllPatients() {

	}
	
	@Override
	protected void make_elements() {
        List<Patient> ls = UsersDB.search_patients_by_name("", true);
		elNum = ls.size();
		
		Object [] columnNames = new Object[]{"ID", "First Name", "Last Name", "Telephone"};
        elements = new JTable( new Object[elNum][4], columnNames ) { 
            public boolean isCellEditable(int row, int column) {
				return false;
			}
        };
		for(int i = 0; i < elNum; i++)
		{
			elements.setValueAt(ls.get(i).getPersonId(), i, 0);
			elements.setValueAt(ls.get(i).getName(), i, 1);
			elements.setValueAt(ls.get(i).getFamilyname(), i, 2);
			elements.setValueAt(ls.get(i).getTel(), i, 3);
			this.add(new DoctorShowPatient(this.notice, ls.get(i)), "#" + i); // TODO
		}
	}
}
