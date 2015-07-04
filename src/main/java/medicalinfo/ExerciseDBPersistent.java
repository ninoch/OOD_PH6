package medicalinfo;


import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.jvmhub.tutorial.App;

public class ExerciseDBPersistent implements ExerciseDB {

	public void save(Exercise m) {
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
	public void merge(Exercise m) {
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
	public ArrayList<Exercise> getExerciseByDate( int low,
			int high, String startDate, String endDate) {
		return (ArrayList<Exercise>) App.get_session()
				.createCriteria(Exercise.class)
				.add(Restrictions.ge("date", startDate))
				.add(Restrictions.le("date", endDate))
				.add(Restrictions.ge("calory", low))
				.add(Restrictions.le("calory", high))
				.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Exercise> getAllExercise(String username) {
		return (ArrayList<Exercise>) App.get_session()
				.createCriteria(Exercise.class)
				.add(Restrictions.eq("patUser", username))
				.list();
	}

}
