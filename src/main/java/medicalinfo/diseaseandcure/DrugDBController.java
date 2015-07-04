package medicalinfo.diseaseandcure;

import java.util.List;

public class DrugDBController {
	
	static DrugDB ddb;
	
	public static void setType(String i) {
		switch (i) {
		case "file":
			ddb = new DrugDBFile();
			break;

		default:
			ddb = new DrugDBPersistent();
			break;
		}
	}
	
	public static void save(Drug drug) {
		ddb.save(drug);
	}

	public static List<Drug> getAllDrugs(Long id) {
		return ddb.getAllDrugs(id);
	}

}
