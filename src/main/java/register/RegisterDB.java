package register;

import java.util.ArrayList;

import users.Users;

public class RegisterDB {
	ArrayList<Users> registers = new ArrayList<>();
	public void save(Users r){
		registers.add(r);
	}
	public Users getWithUserName(String username) {
		for(Users u: registers)
		{
			if(username.equals(u.getUsername()))
				return u;
		}
		return null;
	}
	public void remove(Users u) {
		for(int i = 0; i < registers.size(); i++)
		{
			if(registers.get(i).getUsername().equals(u.getUsername()))
				registers.remove(i);
		}
	}
}
