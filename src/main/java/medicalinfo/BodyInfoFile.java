package medicalinfo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BodyInfoFile implements BodyInfoDB {
	private List<BodyInfo> allInfos = null;
	
	@SuppressWarnings("unchecked")
	private List<BodyInfo> readInfos() {
		if(allInfos == null)
		{
			allInfos = new ArrayList<BodyInfo>();
			
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream("Statics/DB/BodyInfo.ser"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(EOFException e){
				return allInfos;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			while(true)
			{
				try {
					Object obj = ois.readObject(); 
					if(obj instanceof ArrayList)
						allInfos.addAll((Collection<? extends BodyInfo>) obj);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch(EOFException e){
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				if(ois != null)
					ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return allInfos;
	}

	private void SaveChanges() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream( new FileOutputStream("Statics/DB/BodyInfo.ser", false));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			oos.writeObject(allInfos);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	@Override
	public void save(BodyInfo bodyInfo) {
		if(allInfos == null)
			readInfos();
		allInfos.add(bodyInfo);
		System.err.println("Body info " + bodyInfo.getDate() + " Added to DB! " );
		SaveChanges();
	}

	@Override
	public ArrayList<BodyInfo> get_body_info(String username2) {
		ArrayList<BodyInfo> ls = new ArrayList<BodyInfo>();
		for(BodyInfo b : readInfos())
			if(b.getPatUser().equals(username2))
				ls.add(b);
		return ls;
	}

	@Override
	public ArrayList<BodyInfo> getBloodPressure(String docUser,
			String startDate, String endDate, double low, double high) {
		ArrayList<BodyInfo> ls = new ArrayList<BodyInfo>();
		for(BodyInfo b : readInfos())
			if(b.getDocUser().equals(docUser)
					&& b.getDate().compareTo(startDate) >= 0
					&& b.getDate().compareTo(endDate) <= 0
					&& b.getBloodPressure() >= low
					&& b.getBloodPressure() <= high
					)
				ls.add(b);
		return ls;
	}

	@Override
	public ArrayList<BodyInfo> getBloodSugar(String docUser, String startDate,
			String endDate, int low, int high) {
		ArrayList<BodyInfo> ls = new ArrayList<BodyInfo>();
		for(BodyInfo b : readInfos())
			if(b.getDocUser().equals(docUser)
					&& b.getDate().compareTo(startDate) >= 0
					&& b.getDate().compareTo(endDate) <= 0
					&& b.getBloodSugar() >= low
					&& b.getBloodSugar() <= high
					)
				ls.add(b);
		return ls;
	}

}
