package graphics.Report;

import graphics.ListAll;

import javax.swing.JTable;

import users.LoginedUser;
import users.UsersDB;
import users.reporters.patient.Patient;
import medicalinfo.BodyInfo;

import java.util.List;

@SuppressWarnings("serial")
public class HealthList extends ListAll {
	private Patient patient = null;
	private List<BodyInfo> ls;
	
	public HealthList() {

	}

	@Override
	protected void make_elements() {
		if(patient == null)
			return;
		ls = LoginedUser.getUser().get_all_body_info(patient.getUsername());
		elNum = ls.size();
		Object [] columnNames = new Object[]{ "Date", "Doctor"};
        elements = new JTable( new Object[elNum][2], columnNames ) { 
            public boolean isCellEditable(int row, int column) {
				return false;
			}
         };
        
		for(int i = 0; i < elNum; i++)
		{
			elements.setValueAt(ls.get(i).getDate(), i, 0);
			elements.setValueAt(UsersDB.getByUserName(ls.get(i).getDocUser()).getName(), i, 1);
			this.add(new Health(this.notice, ls.get(i)), "#" + i);
		}
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient2) {
		this.patient = patient2;
		this.fill();
	}
}
