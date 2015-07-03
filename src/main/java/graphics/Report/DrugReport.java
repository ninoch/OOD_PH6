package graphics.Report;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("serial")
public class DrugReport extends Report {

	public DrugReport() {

	}
	
	List<Double> getList(Double minl, Double maxl, int dataNumber)
	{
		List<Double> ls = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < dataNumber; i++)
            ls.add(minl + ( (double) random.nextDouble() * (maxl - minl )) );
        return ls;
	}

	@Override
	void make_elements() {
		// TODO Auto-generated method stub
		title = "Drug Number - Time ( day )";
		elements = getList(0.0, 50.0, 20);
		
	}

	@Override
	void set_field() {
		// TODO Auto-generated method stub
		field = "äÇã ÏÇÑæ:";
	}

}
