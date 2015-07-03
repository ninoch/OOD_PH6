package graphics.Report;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("serial")
public abstract class Report extends JPanel {
	private JTextField illnessName;
	private JTextField fromDate;
	private JTextField toDate;
	private JPanel select;
	private CardLayout cl;
	
	protected String title;
	protected List<Double> elements;
	protected String field;

	public Report() {
		set_field();
		this.setLayout(new CardLayout());
		this.setSize(new Dimension(480, 400));
		
		select = new JPanel();
		select.setLayout(null);
		select.setSize(new Dimension(480, 400));
		
		GraphPanel chart = new GraphPanel(null, "", this.notice);

		cl = (CardLayout)(this.getLayout());
		this.add(select, "default");
		this.add(chart, "chart");
		
		cl.show(this, "default");
		
		JLabel label = new JLabel(field);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(315, 11, 155, 28);
		select.add(label);
		
		illnessName = new JTextField();
		illnessName.setBounds(243, 50, 227, 20);
		select.add(illnessName);
		illnessName.setColumns(10);
		
		JLabel label_1 = new JLabel("\u0627\u0632 \u062A\u0627\u0631\u06CC\u062E:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(315, 107, 155, 28);
		select.add(label_1);
		
		fromDate = new JTextField();
		fromDate.setColumns(10);
		fromDate.setBounds(243, 146, 227, 20);
		select.add(fromDate);
		
		JLabel label_2 = new JLabel("\u062A\u0627 \u062A\u0627\u0631\u06CC\u062E:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(315, 177, 155, 28);
		select.add(label_2);
		
		toDate = new JTextField();
		toDate.setColumns(10);
		toDate.setBounds(243, 216, 227, 20);
		select.add(toDate);
		
		JButton button = new JButton("\u0646\u0645\u0627\u06CC\u0634");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				make_elements();
				chart.drawNewChart(elements, title);
				cl.show(Report.this, "chart");
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
	
	abstract void make_elements();
	abstract void set_field();

}
