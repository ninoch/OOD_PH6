package graphics.Report;

import graphics.ListAll;

import javax.swing.JTable;

@SuppressWarnings("serial")
public class ActivityList extends ListAll {

	public ActivityList() {

	}

	@Override
	protected void make_elements() {
		elNum = 9;
		Object [] columnNames = new Object[]{ "Date", "Duration(minutes)"};
        elements = new JTable( new Object[elNum][2], columnNames ) { 
            public boolean isCellEditable(int row, int column) {
				return false;
			}
         };
        
		for(int i = 0; i < elNum; i++)
		{
			elements.setValueAt("1394/01/0" + ( i + 1 ), i, 0);
			elements.setValueAt(120 + i, i, 1);
			this.add(new Activity(this.notice), "#" + i);
		}
       
	}

}
