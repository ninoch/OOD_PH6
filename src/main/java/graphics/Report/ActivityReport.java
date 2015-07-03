package graphics.Report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import medicalinfo.Exercise;
import medicalinfo.ExerciseController;

@SuppressWarnings("serial")
public class ActivityReport extends Report {
	private JTextField minCal;
	private JTextField maxCal;
	private JTextField fromDate;
	private JTextField toDate;
	
	public ActivityReport() {
		JLabel label = new JLabel("حداقل کالری:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(315, 5, 155, 28);
		select.add(label);

		minCal = new JTextField();
		minCal.setBounds(243, 30, 227, 20);
		select.add(minCal);
		minCal.setColumns(10);
		
		JLabel lbl = new JLabel("حداکثر کالری:");
		lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl.setBounds(315, 55, 155, 28);
		select.add(lbl);

		maxCal = new JTextField();
		maxCal.setBounds(243, 80, 227, 20);
		select.add(maxCal);
		maxCal.setColumns(10);
		
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
	
	List<Integer> getList(int minl, int maxl, String startDate, String endDate)
	{
		ArrayList<Exercise> exes = ExerciseController.getExerciseByDate(minl, maxl, startDate, endDate);
		Collections.sort(exes, new Comparator<Exercise>() {
            public int compare(Exercise a, Exercise b) {
                return a.getDate().compareTo(b.getDate());
            }
        });
		List<String> dates = new ArrayList<String>();
		for(int i = 0; i < exes.size(); i++)
			dates.add(exes.get(i).getDate());
		return make_array(dates);
	}

	@Override
	void make_elements() {
		// TODO Auto-generated method stub
		title = "Illness Number - Time ( day )"; 
		elements = getList(Integer.parseInt(minCal.getText()), Integer.parseInt(maxCal.getText()),
						   fromDate.getText(), toDate.getText());
		
	}

	@Override
	boolean check_inputs() {
		if(minCal.getText().equals("")
				|| maxCal.getText().equals("")
				|| fromDate.getText().length() != 10 
				|| toDate.getText().length() != 10)
			return false;
		return true;
	}
}
