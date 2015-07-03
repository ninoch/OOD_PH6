package graphics.DocAdminCommons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.Callable;

import graphics.ListAll;
import graphics.Doctor.DoctorShowPatient;

import javax.swing.JButton;
import javax.swing.JTable;

import users.UsersDB;
import users.reporters.patient.Patient;

@SuppressWarnings("serial")
public class PatientsSearchResault extends ListAll {

	private JButton back;
	private String query;

	public PatientsSearchResault(Callable<Void> notice) {
		query = new String("");
		System.err.println("query is here" + " " + query);
		back = new JButton("»«“ê‘ ");
	    back.setSize(90, 30);
	    back.setLocation(280, 360);
	    this.select.add(back);
	    back.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
    			try {
					notice.call();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	}
	
	public void setQuery(String query)
	{
		this.query = query;
		fill();
	}

	@Override
	protected void make_elements() {
		System.err.println("olllaqq: " + query);
		List<Patient> ls = UsersDB.search_patients_by_name(this.query, true);
		elNum = ls.size();
		System.err.println(ls.size());
		
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
/*
	CardLayout cl;
	JPanel all;
	JButton[][] btns;
	
	public DoctorsSearchResault(int pnum) {
			this.setSize(new Dimension(480, 400));
			this.setLayout(new CardLayout());
			all = new JPanel();
			cl =  (CardLayout)(this.getLayout());
			btns = new JButton[pnum][5];
			
			this.add(all, "default");
			this.add(new PatientProfile(), "profile");
			this.add(new ReportActivity(), "activity");
			this.add(new ReportHealth(), "health");
			this.add(new ReportIllness(), "illness");
			
	        cl.show(this, "default");
	        
			all.setSize(new Dimension(480, 400));
	        Object [] columnNames = new Object[]{ "Name", "Family", "ID", "Profile", "Health", "Ilness", "Activity", "Archive"};
	        JTable table = new JTable( new Object[pnum][8], columnNames ) { 
	            public TableCellRenderer getCellRenderer( int row, int column ) {
	                return new addMyButton();
	            }
	            public boolean isCellEditable(int row, int column) {
    				return true;
    			}
	         };
	         
	        table.setRowHeight( 32 );

		    JScrollPane pane = new JScrollPane();
		    pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		    pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		    pane.setViewportView(table);
		    pane.setMinimumSize(new Dimension(460, 380));
		    pane.setMaximumSize(new Dimension(460, 380));
		    pane.setPreferredSize(new Dimension(460, 380));
		    all.add( pane );
	}
	class addMyButton extends JPanel implements TableCellRenderer 
	{
	        public Component getTableCellRendererComponent(
	                            final JTable table, Object value,
	                            boolean isSelected, boolean hasFocus,
	                            int row, int column) {
	        		if(column == 0)
	        		{
	        			this.add(new JLabel("name" + row));
	        		}
	        		if(column == 1)
	        		{
	    	        	this.add(new JLabel("fname"));
	        		}
	        		if(column == 2)
	        		{
	    	        	this.add(new JLabel("32131"));
	        		}
	        		if(column == 3)
	        		{
	        			JButton btn = new JButton();
		                btn.setText("Show");
		                btn.addActionListener(new ActionListener() {
		        			public void actionPerformed(ActionEvent e) {
		        				System.err.println("here");
		        				cl.show(DoctorsSearchResault.this, "profile");
		        			}
		        		});
				    	this.add(btn);
	        		}
	        		if(column == 4)
	        		{
	        			JButton btn = new JButton();
	        			btn.setText("Report");
	        			btn.addActionListener(new ActionListener() {
		        			public void actionPerformed(ActionEvent e) {
		        				cl.show(DoctorsSearchResault.this, "health");
		        			}
		        		});
				    	this.add(btn);
	        		}
		        	if(column == 5)
		        	{
		        		JButton btn = new JButton();
		        		btn.setText("Report");
		        		btn.addActionListener(new ActionListener() {
		        			public void actionPerformed(ActionEvent e) {
		        				cl.show(DoctorsSearchResault.this, "illness");
		        			}
		        		});
				    	this.add(btn);
	        		}
			        if(column == 6)
			        {
			        	JButton btn = new JButton();
			        	btn.setText("Report");
			        	btn.addActionListener(new ActionListener() {
		        			public void actionPerformed(ActionEvent e) {
		        				cl.show(DoctorsSearchResault.this, "activity");
		        			}
		        		});
				    	this.add(btn);
	        		}
				    if(column == 7)
				    {
				    	JButton btn = new JButton();
				    	btn.setText("Archive");
				    	btn.addActionListener(new ActionListener() {
		        			public void actionPerformed(ActionEvent e) {
		        				// TODO Archive patient
		        			}
		        		});
				    	this.add(btn);
	        		}
	                return this;
	        }
	}
*/
}
