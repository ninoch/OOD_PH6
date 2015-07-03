package medicalinfo.diseaseandcure;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.jvmhub.tutorial.App;

public class DiseaseDBPersistent implements DiseaseDB {
	

	@SuppressWarnings("unchecked")
	public Disease getDisease(String docUser, String patUser, String name) {
		List<Disease> u = App.get_session()
				.createCriteria(Disease.class)
				.add(Restrictions.eq("name", name))
				.add(Restrictions.eq("patUser", patUser))
				.add(Restrictions.eq("docUser", docUser))
				.list();
		if(u.size() == 0)	return null;
		else return u.get(0);
	}
	public void save(Disease d) {
		Session session = null;
        Transaction tx = null;
        try {
            session = App.get_session();
            tx = session.beginTransaction();

            session.save(d);

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
	public ArrayList<Disease> getAllDisease(String username2) {
		return (ArrayList<Disease>) App.get_session()
		.createCriteria(Disease.class)
		.add(Restrictions.eq("patUser", username2))
		.list();
	}
	public List<Drug> getAllDrugs(long disID){
		Prescription p = PrescriptionDB.find(disID);
		return p.getAllDrugs();
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Disease> getDiseaseByDate(String docUser, String name, String startDate,
			String endDate) {
		return (ArrayList<Disease>) App.get_session()
		.createCriteria(Disease.class)
		.add(Restrictions.eq("docUser", docUser))
		.add(Restrictions.eq("name", name))
		.add(Restrictions.ge("date", startDate))
		.add(Restrictions.le("date", endDate))
		.list();
	}

}
