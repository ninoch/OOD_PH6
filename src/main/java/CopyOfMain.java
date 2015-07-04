import graphics.LoginUI;






import java.awt.EventQueue;

import users.Medicate;
import users.MedicateController;
import users.UsersController;
import users.reporters.doctor.Doctor;
import users.reporters.doctor.GeneralDoctor;
import users.reporters.patient.Patient;

public class CopyOfMain {
	public static void main(String[] args) throws Exception {
		Setting.setDBType("file");
		UsersController.save(new Patient(1, "nazanin", "123", "Tehran, Iran, Azadi", "0231021", "nazanin", "alipourfard"				
				+ "", "salam?", "khubam"));

		GeneralDoctor saeed = new GeneralDoctor(23, "salione", "123", "Tehran, Iran, Azadi", "0231021", "saeedreza", "alipourfard", "salam?", "khubam");
		
		UsersController.save(saeed);
		saeed.setIsActivated(true);
		UsersController.merge(saeed);
		
		for(Patient u : UsersController.search_patients_by_name("naz", false))
			System.err.println(u.getName() + " " + u.getFamilyname());
		
		for(Doctor d : UsersController.get_doctors_by_name("saeed", false))
			System.err.println(d.getName() + " " + d.getFamilyname());
		
		for(Doctor d : UsersController.get_doctors_by_name("ali", true))
			System.err.println(d.getName() + " " + d.getFamilyname());
		
		Medicate mtest = new Medicate("salione", "nazanin");
		MedicateController.save(mtest);
		System.err.println("first");
		for(Doctor d : MedicateController.findAllDoctors("nazanin", true))
			System.err.println(d.getName());
		mtest.setIsAccepted(true);
		MedicateController.merge(mtest);

		System.err.println("second");
		for(Doctor d : MedicateController.findAllDoctors("nazanin", true))
			System.err.println(d.getName());
		
		MedicateController.remove(mtest);
		System.err.println("third");
		for(Patient p : MedicateController.patient_from_doctor("saeedreza", false))
			System.err.println(p.getName());
		
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
	}
}
