package graphics.Admin;

import java.util.List;

import graphics.ListAll;
import graphics.Doctor.DoctorProfile;

import javax.swing.JTable;

import users.UsersController;
import users.reporters.doctor.Doctor;
import users.reporters.doctor.SpecialDoctor;

@SuppressWarnings("serial")
public class AdminAllDoctors extends ListAll {
	
	public AdminAllDoctors() {

	}

	@Override
	protected void make_elements() {
		List<Doctor> ls = UsersController.get_doctors_by_name("", true);
		ls.addAll(UsersController.get_doctors_by_name("", false));
		elNum = ls.size();
		
		Object [] columnNames = new Object[]{"ID", "First Name", "Last Name", "Speciality"};
		
        elements = new JTable( new Object[elNum][4], columnNames ) { 
            public boolean isCellEditable(int row, int column) {
				return false;
			}
        };
		for(int i = 0; i < elNum; i++)
		{
			elements.setValueAt(ls.get(i).getDocId(), i, 0);
			elements.setValueAt(ls.get(i).getName(), i, 1);
			elements.setValueAt(ls.get(i).getFamilyname(), i, 2);
			if(ls.get(i).getType().equals("GeneralDoctor"))
				elements.setValueAt("", i, 3);
			else
				elements.setValueAt(((SpecialDoctor) ls.get(i)).getSpecialty(), i, 3);
			this.add(new DoctorProfile(), "#" + i); // TODO
		}
	}
}
