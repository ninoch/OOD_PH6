package users;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import users.reporters.doctor.Doctor;
import users.reporters.patient.Patient;
import users.reporters.doctor.SpecialDoctor;

public class UsersDBFile implements UsersDB {
	private int usersNum = 0;
	private List<Users> allUsers = null;

	private List<Users> readUsers() {
		if(allUsers == null)
		{
			allUsers = new ArrayList<Users>();
			
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream("Statics/DB/Users.ser"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i = 0; i < usersNum; i++)
			{
				try {
					allUsers.add((Users) ois.readObject());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.err.println("User " + allUsers.get(i).getUsername() + " read from DB!");
			}
			try {
				if(ois != null)
					ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return allUsers;
	}
	

	private void SaveChanges() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream( new FileOutputStream("Statics/DB/Users.ser", false));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			oos.writeObject(allUsers);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	
	@Override
	public void save(Users m) {
		if(allUsers == null)
			readUsers();
		allUsers.add(m);
		SaveChanges();
	}
	
	@Override
	public void merge(Users m) {
		if(allUsers == null)
			readUsers();
		for(Users u : allUsers)
			if(u.getUsername().equals(m.getUsername()))
				u = m;
		System.err.println("**********");
		for(int i = 0; i < usersNum; i++)
			System.err.println(allUsers.get(i));
		SaveChanges();
	}
	
	/****************** EASY *******************/
	
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

	@Override
	public Users getByUserName(String username2) {
		List<Users> ls = readUsers();
		for(int i = 0; i < ls.size(); i++)
			if(ls.get(i).getUsername().equals(username2))
				return ls.get(i);
		return null;
	}

	@Override
	public List<Users> search_users_by_name(String name, boolean isActive) {
		List<Users> ls = find_the_one_contain_this_name(name, readUsers());
		List<Users> ans = new ArrayList<Users>();
		for(int i = 0; i < ls.size(); i++)
			if(ls.get(i).getIsActivated() == isActive)
				ans.add(ls.get(i));
		return ans;
	}

	@Override
	public List<Patient> search_patients_by_name(String name, boolean isActive) {
		List<Users> ls = find_the_one_contain_this_name(name, readUsers());
		List<Patient> ans = new ArrayList<Patient>();
		for(int i = 0; i < ls.size(); i++)
			if(ls.get(i).getIsActivated() == isActive && 
			   ls.get(i).getType().equals("Patient"))
				ans.add((Patient)ls.get(i));
		return ans;
	}

	@Override
	public boolean login(String username, String password) {
		List<Users> ls = readUsers();
		if(ls.size() == 0)
			return false;
		for(int i = 0; i < ls.size(); i++)
			if(    ls.get(i).getUsername().equals(username) 
				&& ls.get(i).getPassword().equals(password))
				return true;
		return false;
	}

	@Override
	public List<Doctor> get_doctors_by_name(String name, boolean isGeneral) {
		List<Users> ls = find_the_one_contain_this_name(name, readUsers());
		System.err.println("LS1: " + ls.size());
		List<Doctor> ans = new ArrayList<Doctor>();
		String ttype = "GeneralDoctor";
		if(!isGeneral)
			ttype = "SepecialDoctor";
		
		for(int i = 0; i < ls.size(); i++)
			if(   ls.get(i).getIsActivated() == true 
			   && ls.get(i).getType().equals(ttype))
				ans.add((Doctor)ls.get(i));
		return ans;
	}

	@Override
	public List<Patient> get_my_patient(String docUser, String patName) {
		 ArrayList<Patient> all = MedicateController.get_doctor_patient(docUser);
		 return find_the_one_contain_this_name(patName, all);	 
	}

	@Override
	public List<Doctor> searchSpecialDoctors(String name, String specialty) {
		List<Users> ls = readUsers();
		List<Doctor> ans = new ArrayList<Doctor>();
		for(int i = 0; i < ls.size(); i++)
			if(ls.get(i).getIsActivated() &&
			   ls.get(i).getType().equals("SepecialDoctor") &&
			   ((SpecialDoctor)ls.get(i)).getSpecialty().equals(specialty) && 
			  (ls.get(i).getName().equals(name) || ls.get(i).getFamilyname().equals(name)))
				ans.add((Doctor)ls.get(i));
		return ans;
	}

}
