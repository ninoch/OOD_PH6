package graphics.Report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import medicalinfo.diseaseandcure.Disease;
import medicalinfo.diseaseandcure.DiseaseController;

@SuppressWarnings("serial")
public class IllnessReport extends Report {
	private JTextField illnessName;
	private JTextField fromDate;
	private JTextField toDate;
	
	public IllnessReport() {
		JLabel label = new JLabel("نام بیماری");
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
		
	}
	
	
	List<Integer> getList(String name, String startDate, String endDate)
	{
		ArrayList<Disease> ills = DiseaseController.getDiseaseByDate(name, startDate, endDate);
		Collections.sort(ills, new Comparator<Disease>() {
            public int compare(Disease a, Disease b) {
                return a.getDate().compareTo(b.getDate());
            }
        });
		List<String> dates = new ArrayList<String>();
		for(int i = 0; i < ills.size(); i++)
			dates.add(ills.get(i).getDate());
		return make_array(dates);
	}

	@Override
	void make_elements() {
		elements = getList(illnessName.getText(), fromDate.getText(), toDate.getText());
		
	}


	@Override
	boolean check_inputs() {
		if(illnessName.getText().equals("") 
				|| fromDate.getText().length() != 10 
				|| toDate.getText().length() != 10)
			return false;
		return true;
	}
}
