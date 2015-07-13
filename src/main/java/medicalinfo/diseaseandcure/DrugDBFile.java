package medicalinfo.diseaseandcure;

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

public class DrugDBFile implements DrugDB {
	List<Drug> allDrugs = null;
	
	@SuppressWarnings("unchecked")
	private List<Drug> readDrugs() {
		if(allDrugs == null)
		{
			allDrugs = new ArrayList<Drug>();
			
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream("Statics/DB/Drug.ser"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(EOFException e){
				return allDrugs;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			while(true)
			{
				try {
					Object obj = ois.readObject(); 
					if(obj instanceof ArrayList)
						allDrugs.addAll((Collection<? extends Drug>) obj);
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
		return allDrugs;
	}

	private void SaveChanges() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream( new FileOutputStream("Statics/DB/Drug.ser", false));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			oos.writeObject(allDrugs);
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
	public void save(Drug d) {
		if(allDrugs == null)
			readDrugs();
		allDrugs.add(d);
		System.err.println("Drug " + d.getName() + " Added to DB! " );
		SaveChanges();
	}

	@Override
	public List<Drug> getAllDrugs(Long id) {
		List<Drug> ls = new ArrayList<Drug>();
		for(Drug d : readDrugs())
			if(d.getPresId() == id)
				ls.add(d);
		return ls;
	}

}
