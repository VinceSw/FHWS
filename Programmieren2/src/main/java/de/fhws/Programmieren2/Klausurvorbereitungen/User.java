package de.fhws.Programmieren2.Klausurvorbereitungen;

import java.io.Serializable;

public class User implements Serializable, Comparable<User>
{
	private static final long serialVersionUID = 1L;
	
	private final String userName;
	private final transient String pwd;
	
	public User(String userName, String pwd)
	{
		this.userName = userName;
		this.pwd = pwd;
	}
	
	public String getUserName()
	{
		return this.userName;
	}

	public int compareTo(User u)
	{
		return this.userName.compareTo(u.userName);
	}
}
