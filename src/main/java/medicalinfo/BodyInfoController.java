package medicalinfo;

import java.util.ArrayList;

import users.MedicateController;

public class BodyInfoController {
	static BodyInfoDB bid = new BodyInfoDBPersistent();

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
}
