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


public class ConsultDBFile implements ConsultDB {
	private List<Consult> allCons = null;

	private List<Consult> readConsults() {
		if(allCons == null)
		{
			allCons = new ArrayList<Consult>();
			
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream("Statics/DB/Consult.ser"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(EOFException e){
				return allCons;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			while(true)
			{
				try {
					Object obj = ois.readObject(); 
					if(obj instanceof Consult)
						allCons.add((Consult)(ois.readObject()));
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
		return allCons;
	}

	private void SaveChanges() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream( new FileOutputStream("Statics/DB/Consult.ser", false));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			oos.writeObject(allCons);
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
	public void save(Consult consult) {
		if(allCons == null)
			readConsults();
		allCons.add(consult);
		System.err.println("Consult " + consult.getMsg() + " Added to DB! " );
		SaveChanges();
	}

	@Override
	public void merge(Consult consult) {
		if(allCons == null)
			readConsults();
		for(Consult el : allCons)
			if(el.getAzki().equals(consult.getAzki())
					&& el.getTowho().equals(consult.getTowho()))
				el = consult;
		SaveChanges();
	}

	@Override
	public ArrayList<Consult> get_all(String username) {
		ArrayList<Consult> ls = new ArrayList<Consult>();
		for(Consult c : readConsults())
			if(c.getTowho().equals(username))
				ls.add(c);
		return ls;
	}

}
