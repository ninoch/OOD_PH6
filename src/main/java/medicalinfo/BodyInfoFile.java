package medicalinfo;

import java.util.ArrayList;

public class BodyInfoFile implements BodyInfoDB {

	@Override
	public void save(BodyInfo bodyInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<BodyInfo> get_body_info(String username2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BodyInfo> getBloodPressure(String docUser,
			String startDate, String endDate, double low, double high) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BodyInfo> getBloodSugar(String docUser, String startDate,
			String endDate, int low, int high) {
		// TODO Auto-generated method stub
		return null;
	}

}
