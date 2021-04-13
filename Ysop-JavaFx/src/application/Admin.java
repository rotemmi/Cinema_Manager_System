package application;
import java.util.ArrayList;

public class Admin extends UserManagement
{
	static Admin admin = new Admin();
	public static Admin getAdmin() 
	{
		return admin;
	}
	private Admin()
	{
		readUsers();
	}

	protected void deleteUser(String userName)
	{
		if(userName.equals(""))
			return;
		for(int i=0;i<users.size();i++)
		{
			if(users.get(i).getUserName().equals(userName))
			{
				users.get(i).deleteOrders();
				CinemaManager.getCinemaManager().writeCinemaList();
				CinemaManager.getCinemaManager().readCinemaFile();
				users.remove(i);
				writeUsers();
				return;
			}   
		}
	}

	protected ArrayList<String> getUserNameList() 
	{
		ArrayList<String> names = new ArrayList<String>();
		readUsers();
		for(User i :users)
		{
			if(i.isAdmin()==false)
				names.add(i.getUserName());
		}
		return names;
	}



}
