package medicalinfo;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.jvmhub.tutorial.App;

public class BodyInfoDBPersistent implements BodyInfoDB {

	@Override
	public void save(BodyInfo bodyInfo) {
		Session session = null;
        Transaction tx = null;
        try {
            session = App.get_session();
            tx = session.beginTransaction();

            session.save(bodyInfo);

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
	public ArrayList<BodyInfo> get_body_info(String username2) {
		return (ArrayList<BodyInfo>) App.get_session()
				.createCriteria(BodyInfo.class)
				.add(Restrictions.eq("patUser", username2))
				.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<BodyInfo> getBloodSugar(String docUser, String startDate,
			String endDate, int low, int high) {
		return (ArrayList<BodyInfo>) App.get_session()
				.createCriteria(BodyInfo.class)
				.add(Restrictions.eq("docUser", docUser))
				.add(Restrictions.ge("date", startDate))
				.add(Restrictions.le("date", endDate))
				.add(Restrictions.ge("bloodSugar", low))
				.add(Restrictions.le("bloodSugar", high))
				.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<BodyInfo> getBloodPressure(String docUser, String startDate,
			String endDate, double low, double high) {
		return (ArrayList<BodyInfo>) App.get_session()
				.createCriteria(BodyInfo.class)
				.add(Restrictions.eq("docUser", docUser))
				.add(Restrictions.ge("date", startDate))
				.add(Restrictions.le("date", endDate))
				.add(Restrictions.ge("bloodPressure", low))
				.add(Restrictions.le("bloodPressure", high))
				.list();
	}

}
