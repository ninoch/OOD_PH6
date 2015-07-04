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
public class PressureReport extends Report{
	private JTextField minPres;
	private JTextField maxPres;
	private JTextField fromDate;
	private JTextField toDate;
	
	public PressureReport() {
		JLabel label = new JLabel("حداقل فشار خون:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(315, 5, 155, 28);
		select.add(label);

		minPres = new JTextField();
		minPres.setBounds(243, 30, 227, 20);
		select.add(minPres);
		minPres.setColumns(10);
		
		JLabel lbl = new JLabel("حداکثر فشار خون:");
		lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl.setBounds(315, 55, 155, 28);
		select.add(lbl);

		maxPres = new JTextField();
		maxPres.setBounds(243, 80, 227, 20);
		select.add(maxPres);
		maxPres.setColumns(10);
		
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
		ArrayList<BodyInfo> press = BodyInfoController.getBloodPressure(fromDate, toDate, minl, maxl);
		Collections.sort(press, new Comparator<BodyInfo>() {
            public int compare(BodyInfo a, BodyInfo b) {
                return a.getDate().compareTo(b.getDate());
            }
        });
		List<String> dates = new ArrayList<String>();
		for(int i = 0; i < press.size(); i++)
			dates.add(press.get(i).getDate());
		return make_array(dates);
	}

	@Override
	void make_elements() {
		elements = getList(Integer.parseInt(minPres.getText()), Integer.parseInt(maxPres.getText()), fromDate.getText(), toDate.getText());
		
	}

	@Override
	boolean check_inputs() {
		if(minPres.getText().equals("")
				|| maxPres.getText().equals("")
				|| fromDate.getText().length() != 10 
				|| toDate.getText().length() != 10)
			return false;
		return true;
	}
}
