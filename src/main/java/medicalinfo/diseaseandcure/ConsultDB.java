package medicalinfo.diseaseandcure;

import java.util.ArrayList;

public interface ConsultDB {

	void save(Consult consult);

	void merge(Consult consult);

	ArrayList<Consult> get_all(String username);

}
