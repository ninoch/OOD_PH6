package medicalinfo;

import java.util.ArrayList;

import users.LoginedUser;
import users.MedicateController;
import users.Users;

public class BodyInfoController {
	static BodyInfoDB bid;
	public static void setType(String i) {
		switch (i) {
		case "file":
			bid = new BodyInfoFile();
			break;

		default:
			bid = new BodyInfoDBPersistent();
			break;
		}
	}
	public static void save(BodyInfo bodyInfo) {
		if(!MedicateController.is_medicating(bodyInfo.getDocUser(), bodyInfo.getPatUser()))
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			bid.save(bodyInfo);
	}

	public static ArrayList<BodyInfo> get_all_body_info(String username,
			String username2) {
		if(!MedicateController.has_access(username, username2)){
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return bid.get_body_info(username2);
			
	}
	public static ArrayList<BodyInfo> getBloodSugar(String startDate,
			String endDate, int low, int high){
		 Users a = LoginedUser.getUser();
		return bid.getBloodSugar(a.getUsername(), startDate, endDate, low, high);
	}
	public static ArrayList<BodyInfo> getBloodPressure(String startDate,
			String endDate, double low, double high){
		Users a = LoginedUser.getUser();
		return bid.getBloodPressure(a.getUsername(), startDate, endDate, low, high);
	}
}
