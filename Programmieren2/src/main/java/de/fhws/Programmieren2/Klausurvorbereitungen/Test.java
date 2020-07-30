package de.fhws.Programmieren2.Klausurvorbereitungen;

import java.util.ArrayList;
import java.util.List;

public class Test
{
	public static void main(String[] args)
	{
		User u1 = new User("vince", "test123");
		User u2 = new User("test2", "test321");
		User u3 = new User("test3", "test321");
		
		List<User> userList = new ArrayList<>();
		userList.add(u1);
		userList.add(null);
		userList.add(u2);
		userList.add(u3);
		
		
		UserManager um = new UserManager();
		um.serialize(userList);
		
		List<User> uL2 = um.deserialize();
		
		for(User u : uL2)
		{
			if(u != null)
				System.out.println(u.getUserName());
		}
	}
}
