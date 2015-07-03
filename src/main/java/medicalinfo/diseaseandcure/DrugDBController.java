package medicalinfo.diseaseandcure;

import java.util.List;

public class DrugDBController {
	
	static DrugDB ddb = new DrugDBPersistent();
	
	public static void save(Drug drug) {
		ddb.save(drug);
	}

	public static List<Drug> getAllDrugs(Long id) {
		return ddb.getAllDrugs(id);
	}

}
