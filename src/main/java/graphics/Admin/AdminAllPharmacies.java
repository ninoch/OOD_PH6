package graphics.Admin;

import graphics.ListAll;
import graphics.Pharmacy.PharmacyProfile;

import javax.swing.JTable;

@SuppressWarnings("serial")
public class AdminAllPharmacies extends ListAll {
	

	public AdminAllPharmacies() {

	}
	
	@Override
	protected void make_elements() {
		elNum = 20;
		Object [] columnNames = new Object[]{ "Name", "Telephone", "Address"};
        elements = new JTable( new Object[elNum][3], columnNames ) { 
            public boolean isCellEditable(int row, int column) {
				return false;
			}
         };
        
		for(int i = 0; i < elNum; i++)
		{
			elements.setValueAt("PharmacyName #" + i, i, 0);
			elements.setValueAt("021778899" + i, i, 1);
			elements.setValueAt("Tehran, PharmacyAddress #" + i, i, 2);
			this.add(new PharmacyProfile(), "#" + i);
		}
		

        elements.getColumnModel().getColumn(0).setPreferredWidth(80);
        elements.getColumnModel().getColumn(0).setWidth(80);

        elements.getColumnModel().getColumn(1).setPreferredWidth(60);
        elements.getColumnModel().getColumn(1).setWidth(60);
        

        elements.getColumnModel().getColumn(2).setPreferredWidth(200);
        elements.getColumnModel().getColumn(2).setWidth(200);
	}
}
