package users.reporters.admin;

import register.RegisterList;
import users.Users;

@SuppressWarnings("serial")
public class Admin extends Users{
	public Admin() throws Exception
	{
		super("admin", "admin", "", "1234567", "", "", "", "");
	}
	public void confirm(String username) throws Exception
	{
		Users u = RegisterList.confirm(username);
		u.confirm();
	}

}
