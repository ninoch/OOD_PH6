package medicalinfo.diseaseandcure;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.jvmhub.tutorial.App;

public class PrescriptionDBPersistent implements PrescriptionDB{
	public void save(Prescription d) {
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

	public Prescription find(Long id) {
		return (Prescription) App.get_session()
				.createCriteria(Prescription.class)
				.add(Restrictions.eq("DiseaseId", id))
				.list().get(0);
	}
}
