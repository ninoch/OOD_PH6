package com.jvmhub.tutorial;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import users.Users;
import users.UsersDB;



public class App {
	private static SessionFactory ourSessionFactory;
    private static ServiceRegistry serviceRegistry;
    public static void main(String[] args) {
		try {
			StartDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Users nazanin = UsersDB.getByUserName("nazanin");
		nazanin.make_a_consult("biorze", "1394/01/03", "salam", "title");
	}

	public static void StartDB() throws Exception {
		try {
            Configuration configuration = new Configuration();
            configuration.configure();
            error("1");
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            error("2");
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }

		
		error("chetori?");
		Session session = ourSessionFactory.openSession();
		error("salam");
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
		
//		AppUser user = new AppUser("firstuser");
//		session.save(user);
//		GeneralDoctor u  = new GeneralDoctor(12134, "kehsani", "salam", "gisha", "986978978958", "kiana", 
//				"ehsani", "chera?", "injuri");
//		GeneralDoctor d = new GeneralDoctor(1212, "hg", "hjg", "jhg", "9879878978977", "jgj", "jgfgh", "jgj", "hgfh");
//		Patient p = new Patient(110001, "vaAleik", "hh", 
//				"kjk", "879980980687", "kjhjk", "kjhjk", "kjhjk", "jkhkj");
//		Doctor doc1 = new GeneralDoctor(6571, "doc1", "123", "hameja", "123456768877", "namedocyek", "famdocyek", "y?", "bashe");
//		Patient p2 = new Patient(76712, "pat1", "123", "ja", "548974239847", "namepayek", "fampayek", "?", "da");
//		
//		
//		Medicate m = new Medicate(d.getUsername(), p.getUsername());
//		MedicateDB.save(m);
//		m = new Medicate(d.getUsername(), p2.getUsername());
//		MedicateDB.save(m);
//		m = new Medicate(doc1.getUsername(), p2.getUsername());
//		MedicateDB.save(m);
//		d.accept_patient(p2);
//		GeneralDoctor d = (GeneralDoctor) UsersDB.getByUserName("biorze");
//		new Consult("biorze", "nazanin", "13920101", "salam khubi");
//		d.accept_patient("nazanin");
//		d.accept_patient("kiana");
//		System.out.println(d.get_unaccepted_requests().size());;
//		ArrayList<Patient> plist =  MedicateDBPersistent.patient_from_doctor("hg", false);
//		for(Patient r : plist)
//		{
//			error(r.getUsername() + " " + r.getName());
//		}
//		new BodyInfo("biorze", "nazanin", 100, 200, 2.4, 10);

	}
	public static Session get_session(){
		return ourSessionFactory.openSession();
	}
	public static void error(String s){
		System.out.println(s);
	}
}
