package medicalinfo.diseaseandcure;

import java.util.ArrayList;
import java.util.List;

import users.MedicateController;

public class DiseaseController {
	static DiseaseDB ddb = new DiseaseDBPersistent();

	public static ArrayList<Disease> get_all_disease(String username,
			String username2) {
		if(!MedicateController.has_access(username, username2))
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
		return ddb.getAllDisease(username2);
	}

	public static void save(Disease disease) {
		//TODO check authentication
		ddb.save(disease);
	}

	public static Disease getDisease(String docUser, String patUser,
			String disName) {
		return ddb.getDisease(docUser, patUser, disName);
	}
	public static ArrayList<Disease> getDiseaseByDate(String name, 
			String startDate, String endDate){
		return ddb.getDiseaseByDate("", name, startDate, endDate);
	}
	
	public static List<Drug> getAllDrugs(long disID){
		return ddb.getAllDrugs(disID);
	}

	 
}
