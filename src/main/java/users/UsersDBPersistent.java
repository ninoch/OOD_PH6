package users;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import users.reporters.doctor.Doctor;
import users.reporters.doctor.GeneralDoctor;
import users.reporters.doctor.SpecialDoctor;
import users.reporters.patient.Patient;

import com.jvmhub.tutorial.App;

public class UsersDBPersistent implements UsersDB{

	@SuppressWarnings("unchecked")
	public Users getByUserName(String username2) {
		List<Users> u = App.get_session()
				.createCriteria(Users.class)
				.add(Restrictions.eq("username", username2))
				.list();
		if(u.size() == 0)	return null;
		else return u.get(0);
	}
	@SuppressWarnings("unchecked")
	public List<Users> search_users_by_name(String name, boolean isActive)
	{
		List<Users> u =  App.get_session()
				.createCriteria(Users.class)
				.add(Restrictions.eq("isActivated", isActive))
				.list();
//		App.error("size e by name  " + u.size());
		return find_the_one_contain_this_name(name, u);
	}
	@SuppressWarnings("unchecked")
	public List<Patient> search_patients_by_name(String name, boolean isActive)
	{
		List<Patient> u =  App.get_session()
				.createCriteria(Patient.class)
				.add(Restrictions.eq("isActivated", isActive))
				.add(Restrictions.isNotNull("PersonId"))
				.list();
		for(Patient tmp : u)
			System.err.println(tmp.getName());
		return find_the_one_contain_this_name(name, u);
		
	}
	public void save(Users m) {
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
	public void merge(Users m) {
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
	public boolean login(String username, String password){
		Users u = getByUserName(username);
		if(u == null)
			return false;
		if(u.getPassword().equals(password))
			return true;
		return false;
	}
	@SuppressWarnings("unchecked")
	public List<Doctor> get_doctors_by_name(String name, boolean isGeneral){
		
		List<Doctor> gd ;
		if(isGeneral)
		{
			gd = App.get_session()
					.createCriteria(GeneralDoctor.class)
					.add(Restrictions.eq("isActivated", true))
					.add(Restrictions.isNotNull("DocId"))
					.list();
		}
		else{
			gd = App.get_session()
					.createCriteria(SpecialDoctor.class)
					.add(Restrictions.eq("isActivated", true))
					.add(Restrictions.isNotNull("DocId"))
					.list();
		}
		
		return find_the_one_contain_this_name(name, gd);
	}
	public <E> List<E> find_the_one_contain_this_name(String name, List<E> gd)
	{
		List<E> res = new ArrayList<>();
		for(E tmp: gd){
			String str = ((Users)tmp).getName() + " " + ((Users)tmp).getFamilyname(); 
			if(str.contains(name))
				res.add(tmp);
		}
		return res;
	}
	public List<Patient> get_my_patient(String docUser, String patName){
		 ArrayList<Patient> all = MedicateController.get_doctor_patient(docUser);
		 return find_the_one_contain_this_name(patName, all);	 
	}
	public List<Doctor> searchSpecialDoctors(String name,
			 String specialty) {
			 @SuppressWarnings("unchecked")
			 List <Doctor> res = App.get_session()
			 .createCriteria(SpecialDoctor.class)
			 .add(Restrictions.eq("isActivated", true))
			 .add(Restrictions.eq("specialty", specialty))
			 .list();
			 return find_the_one_contain_this_name(name, res);
	}
}
