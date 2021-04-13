package application;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public abstract class UserManagement
{
	private String filename = "user.txt"; 
	protected  ArrayList<User> users =new ArrayList<>();	
	public static User currentUser;
	protected  UserManagement()
	{

	}
	public void addUser(User u) 
	{
		users.add(u);
		writeUsers();
	}

	@SuppressWarnings("unchecked")
	protected void readUsers()
	{
		ObjectInputStream inputStream=null;
		try {
			inputStream=new ObjectInputStream(new FileInputStream(filename));
			users=(ArrayList<User>) inputStream.readObject();

		} 
		catch(IOException | ClassNotFoundException e) 
		{

			String passwordMD5 = MD5.getMd5("admin");
			String creditCardMD5= MD5.getMd5("");
			User admin = new User("Admin","admin","Admin",passwordMD5,creditCardMD5,true);
			addUser(admin);
		}	
	}

	protected void writeUsers()
	{	
		ObjectOutputStream outputStream=null;
		try	{

			outputStream=new ObjectOutputStream(new FileOutputStream(filename));
			outputStream.writeObject(users);

		}
		catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}
}
