package medicalinfo.diseaseandcure;


public interface PrescriptionDB {
	public void save(Prescription d);

	public Prescription find(Long id); 
}
