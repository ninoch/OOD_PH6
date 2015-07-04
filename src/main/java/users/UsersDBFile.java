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
	FileInputStream fin;
	FileOutputStream fout;
	ObjectOutputStream oos;   
	ObjectInputStream ois;
	
	public UsersDBFile() {
		try {
			fin = new FileInputStream("Statics/DB/Users.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fout = new FileOutputStream("Statics/DB/Users.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			oos = new ObjectOutputStream(fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		try {
			ois = new ObjectInputStream(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private List<Users> readUsers() {
		System.err.println("Usernum: " + usersNum);
		if(usersNum == 0)
			return null;
		List<Users> ls = new ArrayList<Users>();
		try{   
			try {
				ois = new ObjectInputStream(fin);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i = 0; i < usersNum; i++)
			{
				ls.add((Users) ois.readObject());
				System.err.println("User " + ls.get(i).getUsername() + " read from DB!");
			}
			ois.close();
			return ls;
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
		return null;
	}
	
	public <E> List<E> find_the_one_contain_this_name(String name, List<E> gd)
	{
		if(gd == null)
			return null;
		List<E> res = new ArrayList<>();
		for(E tmp: gd){
			String str = ((Users)tmp).getName() + " " + ((Users)tmp).getFamilyname(); 
			if(str.contains(name))
				res.add(tmp);
		}
		return res;
	}

	@Override
	public void save(Users m) {
		try{
			oos.writeObject(m);
			System.err.println("User " + m.getUsername() + " Added to DB!");
			usersNum ++;
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
	}
	
	private void SaveChanges(List<Users> ls) {
		// CLEAR THE FILE
		try {
			oos.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			oos = new ObjectOutputStream(fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < ls.size(); i++)
			save(ls.get(i));
	}

	@Override
	public Users getByUserName(String username2) {
		List<Users> ls = readUsers();
		if(ls == null)
			return null;
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
	public void merge(Users m) {
		List<Users> ls = readUsers();
		if(ls == null)
			return;
		for(int i = 0; i < ls.size(); i++)
			if(ls.get(i).getUsername().equals(m.getUsername()))
				ls.set(i, m);
		SaveChanges(ls);
	}

	@Override
	public boolean login(String username, String password) {
		List<Users> ls = readUsers();
		if(ls == null)
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> searchSpecialDoctors(String name, String specialty) {
		List<Users> ls = readUsers();
		if(ls == null)
			return null;
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
