package graphics.Doctor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

@SuppressWarnings("serial")
public class EditPrescription extends JPanel {
	private JTextField id;
	private JTable table;
	private JTextField DrugNum;
	private JTextField DrugUse;
	private JTextField DrugName;
	private JLabel label_2;
	private JLabel label_4;
	private JLabel label_5;
	private JButton search;
	private JLabel warning;
	private JButton removeDrug;

	public EditPrescription(Callable<Void> notice) {
		this.setSize(new Dimension(480, 400));
		this.setLayout(null);
		
		JLabel label_1 = new JLabel("شماره نسخه:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(278, 11, 192, 14);
		add(label_1);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(288, 36, 182, 20);
		add(id);
		
		
		DefaultTableModel model = new DefaultTableModel(); 
		table = new JTable(model); 
		// Create columns
		model.addColumn("DrugName"); 
		model.addColumn("Use"); 
		model.addColumn("#s");
		model.addRow(new Object[] { "nasonex", "2 per day", "1" } ); // if it is patient
		model.addRow(new Object[] { "antihistamine", "once a day", "6" } ); // if it is patient
      
        table.setRowHeight( 32 );
        
        JPanel show = new JPanel();
        show.setLayout(null);
        show.setSize(new Dimension(480, 300));
        show.setLocation(0, 100);
        show.setVisible(false);
        this.add(show);

	    JScrollPane pane = new JScrollPane(table);
	    pane.setSize(460, 142);
	    pane.setLocation(10, 33);
	    pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    pane.setMinimumSize(new Dimension(460, 200));
	    pane.setMaximumSize(new Dimension(460, 200));
	    pane.setPreferredSize(new Dimension(460, 200));
	    show.add( pane );
		
		JButton add = new JButton("\u062B\u0628\u062A");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				try {
					notice.call();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add.setBounds(10, 266, 89, 23);
		show.add(add);
		
		JLabel label_3 = new JLabel("\u062F\u0627\u0631\u0648\u0647\u0627:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(278, 11, 192, 14);
		show.add(label_3);
		
		JButton addDrug = new JButton("\u0627\u0641\u0632\u0648\u062F\u0646 \u062F\u0627\u0631\u0648");
		addDrug.setBounds(146, 266, 89, 23);
		addDrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(DrugName.getText().equals("") == false && DrugUse.getText().equals("") == false && DrugNum.getText().equals("") == false)
					model.addRow(new Object[]{DrugName.getText(), DrugUse.getText(), DrugNum.getText()});
			}
		});
		show.add(addDrug);
		
		DrugNum = new JTextField();
		DrugNum.setColumns(10);
		DrugNum.setBounds(245, 266, 160, 20);
		show.add(DrugNum);
		
		DrugUse = new JTextField();
		DrugUse.setColumns(10);
		DrugUse.setBounds(245, 233, 160, 20);
		show.add(DrugUse);
		
		DrugName = new JTextField();
		DrugName.setColumns(10);
		DrugName.setBounds(245, 202, 160, 20);
		show.add(DrugName);
		
		label_2 = new JLabel("\u0646\u0627\u0645 \u062F\u0627\u0631\u0648:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(415, 203, 55, 14);
		show.add(label_2);
		
		label_4 = new JLabel("\u0637\u0631\u06CC\u0642\u0647 \u0645\u0635\u0631\u0641:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(399, 236, 71, 14);
		show.add(label_4);
		
		label_5 = new JLabel("\u062A\u0639\u062F\u0627\u062F:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(415, 266, 55, 14);
		show.add(label_5);
		
		removeDrug = new JButton("حذف دارو");
		removeDrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ind = table.getSelectedRow();
				if(ind != -1)
				{
					DefaultTableModel modelT = ( DefaultTableModel ) table.getModel();  
					modelT.removeRow(ind);
				}
			}
		});
		removeDrug.setBounds(10, 186, 89, 23);
		show.add(removeDrug);
		
		search = new JButton("جستجو");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				warning.setVisible(false);
				show.setVisible(false);
				if(id.getText().equals(""))
				{
					warning.setVisible(true);
				}
				else
				{
					show.setVisible(true);
				}
			}
		});
		search.setBounds(10, 35, 89, 23);
		this.add(search);
		
		warning = new JLabel("نسخه مورد نظر یافت نشد");
		warning.setForeground(Color.RED);
		warning.setBounds(109, 36, 173, 20);
		warning.setVisible(false);
		this.add(warning);
	}

}
