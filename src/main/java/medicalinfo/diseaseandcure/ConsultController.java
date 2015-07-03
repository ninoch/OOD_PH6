package medicalinfo.diseaseandcure;

import java.util.ArrayList;

import users.MedicateController;

public class ConsultController {
	static ConsultDB cdb = new ConsultDBPersistent();

	public static void save(Consult consult) {
		if(!MedicateController.is_medicating(consult.getTowho(), consult.getAzki()) && 
				!MedicateController.is_medicating(consult.getAzki(), consult.getTowho()) )
			try {
				throw new Exception("Doctor is not medicating thisPatient");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		cdb.save(consult);
	}

	public static void merge(Consult consult) {
		cdb.merge(consult);
	}

	public static ArrayList<Consult> get_all_consult(String username) {
		return cdb.get_all(username);
	}


}
