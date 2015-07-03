package medicalinfo.diseaseandcure;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.jvmhub.tutorial.App;

public class ConsultDBPersistent implements ConsultDB{

	public void save(Consult m) {
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
	public void merge(Consult m) {
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
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Consult> get_all(String username) {
		ArrayList<Consult> c1, c2;
		c1 = (ArrayList<Consult>) App.get_session()
		.createCriteria(Consult.class)
		.add(Restrictions.eq("azki", username))
		.list();
		c2 = (ArrayList<Consult>) App.get_session()
		.createCriteria(Consult.class)
		.add(Restrictions.eq("towho", username))
		.list();
		c1.addAll(c2);
		return c1;
	}

}
