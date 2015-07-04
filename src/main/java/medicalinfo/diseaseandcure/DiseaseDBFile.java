package medicalinfo.diseaseandcure;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class DiseaseDBFile implements DiseaseDB {
	private List<Disease> allDis = null;
	
	private List<Disease> readDisease() {
		if(allDis == null)
		{
			allDis = new ArrayList<Disease>();
			
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream("Statics/DB/Disease.ser"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(EOFException e){
				return allDis;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			while(true)
			{
				try {
					Object obj = ois.readObject(); 
					if(obj instanceof Disease)
						allDis.add((Disease)(ois.readObject()));
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
		return allDis;
	}

	private void SaveChanges() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream( new FileOutputStream("Statics/DB/Disease.ser", false));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			oos.writeObject(allDis);
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
	public void save(Disease d) {
		if(allDis == null)
			readDisease();
		allDis.add(d);
		System.err.println("Disease " + d.getName() + " Added to DB! " );
		SaveChanges();
	}
	
	@Override
	public Disease getDisease(String docUser, String patUser, String name) {
		for(Disease d : readDisease())
			if(d.getDocUser().equals(docUser)
					&& d.getPatUser().equals(patUser)
					&& d.getName().equals(name))
				return d;
		return null;
	}

	@Override
	public ArrayList<Disease> getAllDisease(String username2) {
		ArrayList<Disease> ls = new ArrayList<Disease>();
		for(Disease d : readDisease())
			if(d.getPatUser().equals(username2))
				ls.add(d);
		return ls;
	}

	@Override
	public ArrayList<Disease> getDiseaseByDate(String docUser, String name,
			String startDate, String endDate) {
		
		ArrayList<Disease> ls = new ArrayList<Disease>();
		for(Disease d : readDisease())
			if(d.getDocUser().equals(docUser) &&
					d.getName().equals(name) &&
					d.getDate().compareTo(startDate) >= 0 &&
					d.getDate().compareTo(endDate) <= 0 )
				ls.add(d);
		return ls;
	}

	@Override
	public List<Drug> getAllDrugs(long disID) {
		Prescription p = PrescriptionController.find(disID);
		return p.getAllDrugs();
	}

}
