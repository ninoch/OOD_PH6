package com.jvmhub.tutorial;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.jvmhub.tutorial.entity.AppUser;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

	public void testApp() {
		Session session = ourSessionFactory.openSession();
		session.beginTransaction();

		AppUser user = new AppUser("firstuser");
		session.save(user);

		session.getTransaction().commit();
		session.close();
	}
}
