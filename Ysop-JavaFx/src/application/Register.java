package application;

public class Register extends  UserManagement
{
	static Register register = new Register();
	private Register()
	{
		super();
	}
	public static Register getRegister() {
		return register;
	}


	protected boolean findUserName(String userName)
	{

		for(User i :users)
		{
			if (i.getUserName().equals(userName))
			{
				return true;
			}
		}
		return false;
	}

	protected int signUp(String firstName,String lastName,String userName,String password,String creditCard)
	{
		readUsers();
		if(firstName.equals("") || lastName.equals("")  ||  userName.equals("") || password.equals("") || creditCard.equals(""))
			return -1;

		if(!findUserName(userName))
		{
			String passwordMD5 = MD5.getMd5(password);
			String creditCardMD5= MD5.getMd5(creditCard);
			User user=new User(firstName, lastName, userName, passwordMD5, creditCardMD5, false);
			addUser(user);
			return 1;
		}
		return 0;
	}



}

/*
protected boolean findUser()
{

for(User i :users)
{
	if (i.getFirstName().equals(this.getFirstName()) && i.getlastName().equals(this.getlastName())&&i.getPassword().equals(this.getPassword()))
		return true;
	}

return false;
}
 */
