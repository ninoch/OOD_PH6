import users.MedicateController;
import users.UsersController;
import medicalinfo.BodyInfoController;
import medicalinfo.ExerciseController;
import medicalinfo.diseaseandcure.ConsultController;
import medicalinfo.diseaseandcure.DiseaseController;
import medicalinfo.diseaseandcure.DrugDBController;
import medicalinfo.diseaseandcure.PrescriptionController;


public class Setting {

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

