package graphics.Patient;

import java.util.List;
import graphics.ListAll;
import graphics.Doctor.DoctorProfile;
import javax.swing.JTable;
import users.LoginedUser;
import users.MedicateController;
import users.reporters.doctor.Doctor;

@SuppressWarnings("serial")
public class PatientsAllDoctors extends ListAll {

	public PatientsAllDoctors() {
	}

	@Override
	protected void make_elements() {
		List<Doctor> ls = MedicateController.findAllDoctors(LoginedUser.getUser().getUsername(), true);
		elNum = ls.size();
		System.err.println("SIZEEE : " + ls.size());
		Object [] columnNames = new Object[]{"Name", "Id", "Telephone", "Address"};
        elements = new JTable( new Object[elNum][4], columnNames ) { 
            public boolean isCellEditable(int row, int column) {
				return false;
			}
        };
		for(int i = 0; i < elNum; i++)
		{
			elements.setValueAt(ls.get(i).getName() + " " + ls.get(i).getFamilyname(), i, 0);
			elements.setValueAt(ls.get(i).getDocId(), i, 1);
			elements.setValueAt(ls.get(i).getTel(), i, 2);
			elements.setValueAt(ls.get(i).getAddress(), i, 3);
			this.add(new DoctorProfile(), "#" + i); // TODO
		}
	}

	public void update() {
		fill();
	}
}
