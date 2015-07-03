package medicalinfo.diseaseandcure;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.jvmhub.tutorial.App;

public class DrugDB {

	public static void save(Drug d) {
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
	public static List<Drug> getAllDrugs(Long id) {
		return App.get_session()
				.createCriteria(Drug.class)
				.add(Restrictions.eq("PresId", id))
				.list();
	}

}
