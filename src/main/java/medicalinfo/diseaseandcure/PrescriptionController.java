package medicalinfo.diseaseandcure;

public class PrescriptionController {
	static PrescriptionDB pdb;
	public static void setType(String i) {
		switch (i) {
		case "file":
			pdb = new PrescriptionDBFile();
			break;

		default:
			pdb = new PrescriptionDBPersistent();
			break;
		}
	}
	public static void save(Prescription d){
		pdb.save(d);
	}

	public static Prescription find(Long id){
		return pdb.find(id);
	}

}
