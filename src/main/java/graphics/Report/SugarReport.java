package graphics.Report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import medicalinfo.BodyInfo;
import medicalinfo.BodyInfoController;

@SuppressWarnings("serial")
public class SugarReport extends Report{
	private JTextField minSug;
	private JTextField maxSug;
	private JTextField fromDate;
	private JTextField toDate;
	
	public SugarReport() {
		JLabel label = new JLabel("ÍÏÇÞá ÞäÏ Îæä:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(315, 5, 155, 28);
		select.add(label);

		minSug = new JTextField();
		minSug.setBounds(243, 30, 227, 20);
		select.add(minSug);
		minSug.setColumns(10);
		
		JLabel lbl = new JLabel("ÍÏÇ˜ËÑ ÞäÏ Îæä:");
		lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl.setBounds(315, 55, 155, 28);
		select.add(lbl);

		maxSug = new JTextField();
		maxSug.setBounds(243, 80, 227, 20);
		select.add(maxSug);
		maxSug.setColumns(10);
		
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
		
	}

	List<Integer> getList(int minl, int maxl, String fromDate, String toDate)
	{
		ArrayList<BodyInfo> sugr = BodyInfoController.getBloodSugar(fromDate, toDate, minl, maxl);
		Collections.sort(sugr, new Comparator<BodyInfo>() {
            public int compare(BodyInfo a, BodyInfo b) {
                return a.getDate().compareTo(b.getDate());
            }
        });
		List<String> dates = new ArrayList<String>();
		for(int i = 0; i < sugr.size(); i++)
			dates.add(sugr.get(i).getDate());
		return make_array(dates);
	}

	@Override
	void make_elements() {
		// TODO Auto-generated method stub
		title = "Drug Number - Time ( day )";
		elements = getList(Integer.parseInt(minSug.getText()), Integer.parseInt(maxSug.getText()), fromDate.getText(), toDate.getText());
		
	}


	@Override
	boolean check_inputs() {
		if(minSug.getText().equals("")
				|| maxSug.getText().equals("")
				|| fromDate.getText().length() != 10 
				|| toDate.getText().length() != 10)
			return false;
		return true;
	}
}
