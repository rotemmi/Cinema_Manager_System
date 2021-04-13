package application;


public class Login extends UserManagement
{
	static Login login = new Login();

	private Login()
	{
		super();
	}
	
	public static Login getLogin()
	{
		return login;
	}
	protected int authentication(String userName,String passWord)
	{
		readUsers();
		for(User i :users)
		{
			if (i.getUserName().equals(userName))
			{
				if(i.getPassword().equals(MD5.getMd5(passWord))) 
				{
					if(i.isAdmin())
					{
						return 1;
					}
					else
					{
						currentUser = i;
						return -1;
					}
				}
				return 2;
			}
		}
		return 0;
	}
}