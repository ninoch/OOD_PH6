package medicalinfo;

import java.util.ArrayList;

public interface BodyInfoDB {

	void save(BodyInfo bodyInfo);

	ArrayList<BodyInfo> get_body_info(String username2);


	ArrayList<BodyInfo> getBloodPressure(String docUser, String startDate,
			String endDate, double low, double high);

	ArrayList<BodyInfo> getBloodSugar(String docUser, String startDate,
			String endDate, int low, int high);

}
