package users.reporters.admin;

import register.RegisterList;
import users.Users;

public class Admin {
	public void confirm(String username) throws Exception
	{
		Users u = RegisterList.confirm(username);
		u.confirm();
	}

}
