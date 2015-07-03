package users.reporters.admin;

public class User {
	private static User user = new User();
	
	int type;
	final int Admin = 1;
	final int Pharmacy = 2;
	final int Patient = 3;
	final int Doctor = 4;
	
	private User()
	{
		
	}
	
	public static User getInstance() 
	{
		return user;
	}
	protected static void demoMethod() {
		System.out.println("salam");
	}

}
