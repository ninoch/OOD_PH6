package graphics.Report;

import java.util.List;

import graphics.ListAll;
import medicalinfo.diseaseandcure.Disease;

import javax.swing.JTable;

import users.reporters.patient.Patient;

@SuppressWarnings("serial")
public class IllnessList extends ListAll {

	private Patient patient = null;
	private List<Disease> ls;
	
	public IllnessList() {

	}

	@Override
	protected void make_elements() {
		if(patient == null)
			return;
		ls = patient.get_all_disease(patient.getUsername());
		elNum = ls.size();
		Object [] columnNames = new Object[]{ "Date", "Doctor", "IllnessName"};
        elements = new JTable( new Object[elNum][3], columnNames ) { 
            public boolean isCellEditable(int row, int column) {
				return false;
			}
         };
        
		for(int i = 0; i < elNum; i++)
		{
			elements.setValueAt(ls.get(i).getDate(), i, 0);
			elements.setValueAt(ls.get(i).getDocUser(), i, 1);
			elements.setValueAt(ls.get(i).getName(), i, 2);
			this.add(new Illness(this.notice, ls.get(i)), "#" + i);
		}
	}
	
	public void setPatient(Patient p)
	{
		this.patient = p;
		this.fill();
	}

}
