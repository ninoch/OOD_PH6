package graphics.Pharmacy;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PharmacyDrugSell extends JPanel {

	public PharmacyDrugSell() {
		this.setLayout(null);
		this.setVisible(true);
		
		JLabel label = new JLabel("\u0634\u0645\u0627\u0631\u0647 \u0646\u0633\u062E\u0647:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(381, 11, 75, 19);
		this.add(label);
		
		JTextField dId = new JTextField();
		dId.setBounds(254, 41, 202, 19);
		this.add(dId);
		dId.setColumns(10);
		
		JLabel notFound = new JLabel("\u0646\u0633\u062E\u0647 \u0645\u0648\u0631\u062F \u0646\u0638\u0631\u060C \u062F\u0631 \u0633\u06CC\u0633\u062A\u0645 \u062B\u0628\u062A \u0646\u0634\u062F\u0647 \u0627\u0633\u062A.");
		notFound.setForeground(Color.RED);
		notFound.setBounds(138, 71, 237, 19);
		notFound.setVisible(false);
		this.add(notFound);
		
		// Here for iterate drugs TODO
		/*
		int drugNums = 6;
		JPanel panel = new JPanel();
		JCheckBox[] drugs = new JCheckBox[drugNums];
		for(int i = 0; i < drugNums; i++)
		{
			drugs[i] = new JCheckBox("\u062F\u0627\u0631\u0648\u06CC \u0634\u0645\u0627\u0631\u0647" + (i + 1));
			drugs[i].setBounds(235 , 115 + 25 * i, 97, 23);
			panel.add(drugs[i]);
		}
		*/

		int drugNums = 10;
		Object [] columnNames = new Object[]{"DrugName", "Dose", "#s", "Sell"};
        JTable table = new JTable( new Object[drugNums][4], columnNames ) { 
            public boolean isCellEditable(int row, int column) {
            	if(column < 3)
            		return false;
            	return true;
			}
            
            @SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
	    JScrollPane pane = new JScrollPane(table);
	    pane.setLocation(10, 105);
	    pane.setSize(460, 250);
	    pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    pane.setVisible(false);
	    this.add(pane);
				
		JButton add = new JButton("\u062B\u0628\u062A \u0641\u0631\u0648\u0634");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				notFound.setVisible(false);	
				pane.setVisible(false);
				add.setVisible(false);	
				PharmacyDrugSell.this.setVisible(false);
				/*
				for(int i = 0; i < drugNums; i++)
					if((boolean) table.getValueAt(i, 3))
						System.err.println(i + " ");
				*/
			}
		});
		add.setBounds(10, 366, 89, 23);
		add.setVisible(false);
		this.add(add);
				
		
		
		JButton showDrugs = new JButton("\u0646\u0645\u0627\u06CC\u0634 \u062F\u0627\u0631\u0648\u0647\u0627");
		showDrugs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < drugNums; i++)
				{
					table.setValueAt("Drug #" + i, i, 0);
					table.setValueAt(100 * i, i, 1);
					table.setValueAt(2 + i, i, 2);
					table.setValueAt(false, i, 3);
				}
				if(dId.getText().equals(""))
				{
					pane.setVisible(false);
					add.setVisible(false);	
					notFound.setVisible(true);	
				}
				else
				{
					notFound.setVisible(false);	
					pane.setVisible(true);
					add.setVisible(true);	
				}
			}
		});
		showDrugs.setBounds(76, 40, 110, 23);
		this.add(showDrugs);
		this.setVisible(true);
	}
}
