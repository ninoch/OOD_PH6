package medicalinfo.diseaseandcure;

import java.util.List;

public interface DrugDB {
	
	public void save(Drug d);

	public List<Drug> getAllDrugs(Long id);

}
