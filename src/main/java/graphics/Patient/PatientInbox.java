package graphics.Patient;

import java.util.List;
import graphics.ListAll;
import javax.swing.JTable;
import medicalinfo.diseaseandcure.Consult;
import users.LoginedUser;

@SuppressWarnings("serial")
public class PatientInbox extends ListAll {
	
	public PatientInbox() {
	}

	@Override
	protected void make_elements()
	{
		List<Consult> msgs = LoginedUser.getUser().show_all_consult_list();
		elNum = msgs.size();
		
		Object [] columnNames = new Object[]{ "Read", "Title", "From", "Date", "Message"};
        elements = new JTable( new Object[elNum][5], columnNames ) { 
            public boolean isCellEditable(int row, int column) {
				return false;
			}
            
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
         };
        
		for(int i = 0; i < elNum; i++)
		{
			elements.setValueAt(msgs.get(i).isRead(), i, 0);
			elements.setValueAt(msgs.get(i).getTitle(), i, 1);
			elements.setValueAt(msgs.get(i).getAzki(), i, 2);
			elements.setValueAt(msgs.get(i).getDate(), i, 3);
			elements.setValueAt(msgs.get(i).getMsg(), i, 4);
			this.add(new PatientMessage(this.notice, msgs.get(i)), "#" + i);
		}
		

        elements.getColumnModel().getColumn(0).setPreferredWidth(30);
        elements.getColumnModel().getColumn(0).setWidth(30);

        elements.getColumnModel().getColumn(1).setPreferredWidth(60);
        elements.getColumnModel().getColumn(1).setWidth(60);
        
        elements.getColumnModel().getColumn(2).setPreferredWidth(60);
        elements.getColumnModel().getColumn(2).setWidth(60);
        
        elements.getColumnModel().getColumn(3).setPreferredWidth(60);
        elements.getColumnModel().getColumn(3).setWidth(60);
        
        elements.getColumnModel().getColumn(4).setPreferredWidth(180);
        elements.getColumnModel().getColumn(4).setWidth(180);
		
	}
	
	public void update() {
		fill();
	}
}
