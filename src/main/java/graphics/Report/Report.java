package graphics.Report;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("serial")
public abstract class Report extends JPanel {
	private CardLayout cl;
	private JLabel warning;
	
	protected String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	protected String title = "# of patient - Time ( month )";
	protected List<Integer> elements;
	protected JPanel select;

	public Report() {
		
	    warning = new JLabel("Error in inputs!");
	    warning.setHorizontalAlignment(SwingConstants.CENTER);
	    warning.setForeground(Color.RED);
	    warning.setBounds(20, 334, 450, 14);
	    warning.setVisible(false);
    
		this.setLayout(new CardLayout());
		this.setSize(new Dimension(480, 400));
		
		select = new JPanel();
		select.setLayout(null);
		select.setSize(new Dimension(480, 400));
	    select.add(warning);
		
		GraphPanel chart = new GraphPanel(null, "", this.notice);

		cl = (CardLayout)(this.getLayout());
		this.add(select, "default");
		this.add(chart, "chart");
		
		cl.show(this, "default");
		
		JButton button = new JButton("\u0646\u0645\u0627\u06CC\u0634");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				warning.setVisible(false);
				if(check_inputs())
				{
					make_elements();
					chart.drawNewChart(elements, title);
					cl.show(Report.this, "chart");
				}
				else
				{
					warning.setVisible(true);
				}
			}
		});
		button.setBounds(10, 343, 89, 46);
		select.add(button);
	}
	
	public Callable<Void> notice = new Callable<Void>() {
        public Void call() {
            cl.show(Report.this, "default");
			return null;
        }
    };
    
    public List<Integer> make_array(List<String> dates){
    	System.err.println("make_arrays" + dates.size());
    	if(dates.size() == 0)
    		return new ArrayList<Integer>();
		int minYear = Integer.parseInt(dates.get(0).substring(0, 4));
		int maxYear = Integer.parseInt(dates.get(dates.size() - 1).substring(0, 4));
		List<Integer> ls = new ArrayList<Integer>();
		int ind = 0;
		for(int i = minYear; i <= maxYear; i++) {
			for(int j = 0; j < months.length; j++)
			{
				int t = 0;
				while(ind < dates.size() 
						&& Integer.parseInt(dates.get(ind).substring(0, 4)) == i 
						&& dates.get(ind).substring(5, 7).equals(months[j]))
				{
					t++;
					ind ++;
				}
				ls.add(Integer.valueOf(t));
				if(ind == dates.size())
					break;
			}
		}
		for(int i = 0; i < ls.size(); i++)
			System.err.println(ls.get(i));
        return ls;
    }
	
	abstract void make_elements();
	abstract boolean check_inputs();
}
