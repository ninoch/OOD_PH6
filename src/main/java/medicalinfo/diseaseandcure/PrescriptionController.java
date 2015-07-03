package medicalinfo.diseaseandcure;

public class PrescriptionController {
	static PrescriptionDB pdb = new PrescriptionDBPersistent();
	public static void save(Prescription d){
		pdb.save(d);
	}

	public static Prescription find(Long id){
		return pdb.find(id);
	}

}
