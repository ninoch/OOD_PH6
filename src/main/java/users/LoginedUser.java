package users;

import users.Users;

public class LoginedUser {
	private static Users user;
	private boolean first = true;

	public LoginedUser(Users _user)
	{
		if(first)
		{
			user = _user;
			first = false;
		}
	}
	
	public static Users getUser() {
		return user;
	}
}
