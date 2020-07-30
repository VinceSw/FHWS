package de.fhws.Programmieren2.Klausurvorbereitungen;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class UserManager implements ObjectManager<User>
{

	@Override
	public void serialize(List<User> userList) throws RuntimeException
	{
		try(FileOutputStream fos = new FileOutputStream("pers.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);)
		{
			for(User u : userList)
			{
				oos.writeObject(u);
				oos.flush();
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}
		

	@Override
	public List<User> deserialize() throws RuntimeException
	{
		User u = null;
		List<User> userList = new ArrayList<User>();
		try(FileInputStream fis = new FileInputStream("pers.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);)
		{
			
			while(true)
			{
				u = (User)ois.readObject();
				userList.add(u);
			}
		}
		catch(EOFException e)
		{
			return userList;
		}
		catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}
}
