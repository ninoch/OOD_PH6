import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import users.MedicateController;
import users.UsersController;
import medicalinfo.BodyInfoController;
import medicalinfo.ExerciseController;
import medicalinfo.diseaseandcure.ConsultController;
import medicalinfo.diseaseandcure.DiseaseController;
import medicalinfo.diseaseandcure.DrugDBController;
import medicalinfo.diseaseandcure.PrescriptionController;


public class Setting {
	
	static{
		try {
			Scanner s = new Scanner(new File("Statics/setting.txt"));
			String type = s.next();
			System.err.println(type);
			setDBType(type);
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	      
		
	}

	public static void setDBType(String i) {
		ConsultController.setType(i);
		DiseaseController.setType(i);
		DrugDBController.setType(i);
		PrescriptionController.setType(i);
		BodyInfoController.setType(i);
		ExerciseController.setType(i);
		MedicateController.setType(i);
		UsersController.setType(i);
	}

}

