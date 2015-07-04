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

public class PrescriptionDBFile implements PrescriptionDB {
	List<Prescription> allPres = null;
	
	private List<Prescription> readPrescriptions() {
		if(allPres == null)
		{
			allPres = new ArrayList<Prescription>();
			
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream("Statics/DB/Prescription.ser"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(EOFException e){
				return allPres;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			while(true)
			{
				try {
					Object obj = ois.readObject(); 
					if(obj instanceof Prescription)
						allPres.add((Prescription)(ois.readObject()));
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
		return allPres;
	}

	private void SaveChanges() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream( new FileOutputStream("Statics/DB/Prescription.ser", false));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			oos.writeObject(allPres);
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
	public void save(Prescription d) {
		if(allPres == null)
			readPrescriptions();
		d.setId(allPres.size() + 1);
		allPres.add(d);
		System.err.println("Prescription " + d.getDate() + " Added to DB! " );
		SaveChanges();
	}

	@Override
	public Prescription find(Long id) {
		for(Prescription p : readPrescriptions())
			if(p.getId() == id)
				return p;
		return null;
	}

}
