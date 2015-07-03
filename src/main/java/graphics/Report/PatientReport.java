package graphics.Report;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

@SuppressWarnings("serial")
public class PatientReport extends JPanel {

	private CardLayout cl;
	private JPanel select;
	
	public PatientReport(Callable<Void> notic) {
		this.setLayout(new CardLayout());
		this.setSize(new Dimension(480, 400));
		
		GraphPanel chart = new GraphPanel(null, "", this.notice);
		this.add(chart, "chart");

		select = new JPanel();
		select.setLayout(null);
		select.setSize(new Dimension(480, 400));
		this.add(select, "default");
		

        cl = (CardLayout)(this.getLayout());
        cl.show(this, "default");
		
		JLabel label = new JLabel("\u0641\u0639\u0627\u0644\u06CC\u062A \u0628\u062F\u0646\u06CC:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(313, 69, 157, 25);
		select.add(label);
		
		JLabel label_1 = new JLabel("\u0648\u0636\u0639\u06CC\u062A \u062C\u0633\u0645\u0627\u0646\u06CC:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(83, 69, 157, 25);
		select.add(label_1);
		
		JButton height = new JButton("\u0642\u062F");
		height.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        chart.drawNewChart(getList(50.0, 200.0, 30), "Height ( cm ) - Time ( day )");
				cl.show(PatientReport.this, "chart");
			}
		});
		height.setBounds(121, 105, 119, 55);
		select.add(height);
		
		JButton weight = new JButton("\u0648\u0632\u0646");
		weight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        chart.drawNewChart(getList(20.0, 200.0, 30), "Weight ( cm ) - Time ( day )");
				cl.show(PatientReport.this, "chart");
			}
		});
		weight.setBounds(121, 171, 119, 55);
		select.add(weight);
		
		JButton oxyjen = new JButton("\u0645\u06CC\u0627\u0646\u06AF\u06CC\u0646 \u0627\u06A9\u0633\u06CC\u0698\u0646");
		oxyjen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        chart.drawNewChart(getList(1.0, 60.0, 30), "Oxyjen ( liter / minute ) - Time ( day )");
				cl.show(PatientReport.this, "chart");
			}
		});
		oxyjen.setBounds(351, 105, 119, 55);
		select.add(oxyjen);
		
		JButton energy = new JButton("\u0645\u06CC\u0627\u0646\u06AF\u06CC\u0646 \u0627\u0646\u0631\u0698\u06CC");
		energy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        chart.drawNewChart(getList(50.0, 200.0, 40), "Energy ( cal / minute ) - Time ( day )");
				cl.show(PatientReport.this, "chart");
			}
		});
		energy.setBounds(351, 171, 119, 55);
		select.add(energy);
		
		JButton beat = new JButton("\u0645\u06CC\u0627\u0646\u06AF\u06CC\u0646 \u0636\u0631\u0628\u0627\u0646 \u0642\u0644\u0628");
		beat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        chart.drawNewChart(getList(5.0, 60.0, 30), "Beat ( bpm ) - Time ( day )");
				cl.show(PatientReport.this, "chart");
			}
		});
		beat.setBounds(351, 237, 119, 55);
		select.add(beat);
		
		JButton back = new JButton("\u0628\u0627\u0632\u06AF\u0634\u062A");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					notic.call();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		back.setBounds(10, 334, 119, 55);
		select.add(back);
	}
	
	List<Double> getList(Double minl, Double maxl, int dataNumber)
	{
		List<Double> ls = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < dataNumber; i++)
            ls.add(minl + ( (double) random.nextDouble() * (maxl - minl )) );
        return ls;
	}

	public Callable<Void> notice = new Callable<Void>() {
        public Void call() {
            cl.show(PatientReport.this, "default");
			return null;
        }
    };
}
