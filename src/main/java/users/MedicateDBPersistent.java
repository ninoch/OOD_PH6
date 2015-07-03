package users;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import users.reporters.doctor.Doctor;
import users.reporters.patient.Patient;

import com.jvmhub.tutorial.App;

public class MedicateDBPersistent implements MedicateDB{
	public ArrayList<Patient> patient_from_doctor(String doctor, boolean isaccept)
	{
		ArrayList<Patient> res = new ArrayList<>();
		List<Medicate> m = get_medicate_doctor(doctor, isaccept);
		for(Medicate tmp: m){
			res.add( (Patient) UsersDB.getByUserName(tmp.getPatient()));
		}
		return res;
	}
	@SuppressWarnings("unchecked")
	public List<Medicate> get_medicate_doctor(String doctor, boolean isaccept)
	{
		return App.get_session()
				.createCriteria(Medicate.class)
				.add(Restrictions.eq("toDoctorUser", doctor))
				.add(Restrictions.eq("isAccepted", isaccept))
				.list();
	}

	public Medicate find_medicate(String doctor, String patient) {
		List<Medicate> m = get_medicate_doctor(doctor, false);
		for(Medicate tmp:m){
			if(tmp.getPatient().equals(patient))
				return tmp;
		}
		return null;
	}
	
	public Medicate find_medicate(String from, String to, String patient)
	{
		List<Medicate> m = get_medicate_doctor(to, false);
		for(Medicate tmp:m){
			if(tmp.getPatient().equals(patient) &&
			   tmp.getFromDoctor().equals(from))
				return tmp;
		}
		return null;
	}
	
	public ArrayList<Patient> get_doctor_patient(String docName){
		 ArrayList<Patient> paccept = patient_from_doctor(docName, true);
		 ArrayList<Patient> pnot = patient_from_doctor(docName, false);
		 ArrayList<Patient> result = new ArrayList<>();
		 
		 result.addAll(paccept);
		 result.addAll(pnot);
		 
		 return result;
	}

	public void save(Medicate m) {
		Session session = null;
        Transaction tx = null;
        try {
            session = App.get_session();
            tx = session.beginTransaction();

            session.save(m);

            tx.commit();
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            throw new RuntimeException(ex);
        } finally {
            if (session != null)
                session.close();
        }
	}
	public void merge(Medicate m) {
		Session session = null;
        Transaction tx = null;
        try {
            session = App.get_session();
            tx = session.beginTransaction();

            session.merge(m);

            tx.commit();
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            throw new RuntimeException(ex);
        } finally {
            if (session != null)
                session.close();
        }
	}
	public Medicate find_general_doctor(String patientUser) {
		@SuppressWarnings("unchecked")
		List<Medicate> m = App.get_session()
				.createCriteria(Medicate.class)
				.add(Restrictions.eq("patientUser", patientUser))
				.add(Restrictions.eq("isAccepted", true))
				.list();
		for(Medicate tmp:m)
		{
			Users d =  UsersDB.getByUserName(tmp.getToDoctor());
			if(d.getType().equals("GeneralDoctor"))
			{
				return tmp;
			}
		}
		return null;
	}
	public void remove(Medicate m) {
		Session session = null;
        Transaction tx = null;
        try {
            session = App.get_session();
            tx = session.beginTransaction();

            session.delete(m);

            tx.commit();
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            throw new RuntimeException(ex);
        } finally {
            if (session != null)
                session.close();
        }
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Medicate> findAllRefs(String username) {
		return (ArrayList<Medicate>) App.get_session()
		.createCriteria(Medicate.class)
		.add(Restrictions.isNotNull("toDoctorUser"))
		.add(Restrictions.eq("toDoctorUser", username))
		.add(Restrictions.eq("isAccepted", false))
		.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Doctor> findAllDoctors(String patUser, boolean accepted){
		List<Medicate> m = App.get_session()
		 .createCriteria(Medicate.class)
		 .add(Restrictions.eq("patientUser", patUser))
		 .add(Restrictions.eq("isAccepted", accepted))
		 .list();
		 ArrayList<Doctor> res = new ArrayList<>();
		 for(Medicate tmp:m){
		 res.add((Doctor) UsersDB.getByUserName(tmp.getToDoctor()));
		 }
		 return res;
	}
}
