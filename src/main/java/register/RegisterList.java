package register;
import users.Users;


public class RegisterList {
	
	static RegisterDB pdb = new RegisterDB();
	public static void add(Users u)
	{
		pdb.save(u);
	}
	public static Users confirm(String username) throws Exception
	{
		Users u = pdb.getWithUserName(username);
		if(u== null)
			throw new Exception("User not found");
		pdb.remove(u);
		return u;
	}

}
