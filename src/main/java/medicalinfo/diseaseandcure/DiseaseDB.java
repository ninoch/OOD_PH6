package medicalinfo.diseaseandcure;

import java.util.ArrayList;
import java.util.List;

public interface DiseaseDB {
	public Disease getDisease(String docUser, String patUser, String name);
	public void save(Disease d);
	public ArrayList<Disease> getAllDisease(String username2);
	ArrayList<Disease> getDiseaseByDate(String docUser, String name,
			String startDate, String endDate);
	public List<Drug> getAllDrugs(long disID);
}
