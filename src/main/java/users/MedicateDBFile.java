package users;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import users.reporters.doctor.Doctor;
import users.reporters.patient.Patient;

public class MedicateDBFile implements MedicateDB {
	private int mediNums = 0;
	private List<Medicate> allMedicates = null;
	
	
	private List<Medicate> readMedicates() {
		if(allMedicates == null)
		{
			allMedicates = new ArrayList<Medicate>();
			
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream("Statics/DB/Medicate.ser"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(EOFException e){
				return allMedicates;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			for(int i = 0; i < mediNums; i++)
			{
				try {
					allMedicates.add((Medicate) ois.readObject());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.err.println("Medicate " + allMedicates.get(i).getToDoctor() + " " + allMedicates.get(i).getPatient() + " read from DB!");
			}
			try {
				if(ois != null)
					ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return allMedicates;
	}

	private void SaveChanges() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream( new FileOutputStream("Statics/DB/Medicate.ser", false));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			oos.writeObject(allMedicates);
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
	public void save(Medicate m) {
		if(allMedicates == null)
			readMedicates();
		allMedicates.add(m);
		System.err.println("Medicate " + m.getPatient() + " Added to DB! " );
		SaveChanges();
	}
	
	@Override
	public void merge(Medicate m) {
		if(allMedicates == null)
			readMedicates();
		for(Medicate el : allMedicates)
			if(el.getPatient().equals(m.getPatient()) 
					&& el.getToDoctor().equals(m.getToDoctor()))
				el = m;
		System.err.println("**********");
		for(int i = 0; i < mediNums; i++)
			System.err.println(allMedicates.get(i).getPatient());
		SaveChanges();
	}

	@Override
	public void remove(Medicate m) {
		if(allMedicates == null)
			readMedicates();
		for(int i = 0; i < allMedicates.size(); i++)
			if(allMedicates.get(i).getPatient().equals(m.getPatient()) 
				&& allMedicates.get(i).getToDoctor().equals(m.getToDoctor()))
			{
				allMedicates.remove(i);
				break;
			}
		System.err.println("**********");
		for(int i = 0; i < mediNums; i++)
			System.err.println(allMedicates.get(i).getPatient());
		SaveChanges();
	}
	/****************** EASY *******************/
	
	@Override
	public ArrayList<Patient> patient_from_doctor(String doctor,
			boolean isaccept) {

		ArrayList<Patient> res = new ArrayList<>();
		List<Medicate> m = get_medicate_doctor(doctor, isaccept);
		for(Medicate tmp: m){
			res.add( (Patient) UsersController.getByUserName(tmp.getPatient()));
		}
		return res;
	}

	@Override
	public List<Medicate> get_medicate_doctor(String doctor, boolean isaccept) {
		List<Medicate> ls = readMedicates();
		List<Medicate> ans = new ArrayList<Medicate>();
		for(int i = 0; i < ls.size(); i++)
			if(ls.get(i).getIsAccepted() == isaccept
			&& ls.get(i).getToDoctor().equals(doctor))
				ans.add(ls.get(i));
		return ans;
	}

	@Override
	public Medicate find_medicate(String doctor, String patient) {
		List<Medicate> ls = readMedicates();
		for(int i = 0; i < ls.size(); i++)
			if(ls.get(i).getPatient().equals(patient)
			&& ls.get(i).getToDoctor().equals(doctor))
				return ls.get(i);
		return null;
	}

	@Override
	public Medicate find_medicate(String from, String to, String patient) {
		List<Medicate> ls = readMedicates();
		for(int i = 0; i < ls.size(); i++)
			if(ls.get(i).getPatient().equals(patient)
					&& ls.get(i).getFromDoctor().equals(from)
					&& ls.get(i).getToDoctor().equals(to))
				return ls.get(i);
		return null;
	}

	@Override
	public ArrayList<Patient> get_doctor_patient(String docName) {
		 ArrayList<Patient> paccept = patient_from_doctor(docName, true);
		 ArrayList<Patient> pnot = patient_from_doctor(docName, false);
		 ArrayList<Patient> result = new ArrayList<>();
		 
		 result.addAll(paccept);
		 result.addAll(pnot);
		 
		 return result;
	}

	@Override
	public Medicate find_general_doctor(String patientUser) {
		for(Medicate m : readMedicates())
			if(m.getPatient().equals(patientUser)
					&& m.getIsAccepted() == true
					&& UsersController.getByUserName(m.getToDoctor()).getType().equals("GeneralDoctor"))
				return m;
		return null;
	}

	@Override
	public ArrayList<Medicate> findAllRefs(String username) {
		ArrayList<Medicate> ls = new ArrayList<Medicate>();
		for(Medicate m : readMedicates())
			if(m.getToDoctor().equals(username)
					&& m.getIsAccepted() == false)
				ls.add(m);
		return ls;
	}

	@Override
	public ArrayList<Doctor> findAllDoctors(String patUser, boolean accepted) {
		ArrayList<Doctor> ls = new ArrayList<Doctor>();
		for(Medicate m : readMedicates())
			if(m.getPatient().equals(patUser) 
					&& m.getIsAccepted() == accepted)
				ls.add((Doctor) UsersController.getByUserName(m.getToDoctor()));
		return ls;
	}

}
