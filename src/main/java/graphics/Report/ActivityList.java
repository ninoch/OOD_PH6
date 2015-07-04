package graphics.Report;

import graphics.ListAll;
import java.util.List;
import javax.swing.JTable;
import medicalinfo.Exercise;
import users.reporters.patient.Patient;

@SuppressWarnings("serial")
public class ActivityList extends ListAll {

	private Patient patient = null;
	private List<Exercise> ls;

	public ActivityList() {

	}

	@Override
	protected void make_elements() {
		if(patient == null)
			return;

		ls = patient.get_all_exercise(patient.getUsername());
		
		elNum = ls.size();
		Object [] columnNames = new Object[]{ "Date", "Duration(minutes)"};
        elements = new JTable( new Object[elNum][2], columnNames ) { 
            public boolean isCellEditable(int row, int column) {
				return false;
			}
         };
        
		for(int i = 0; i < elNum; i++)
		{
			elements.setValueAt(ls.get(i).getDate(), i, 0);
			elements.setValueAt(ls.get(i).getMinutes(), i, 1);
			this.add(new Activity(this.notice, ls.get(i)), "#" + i);
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
