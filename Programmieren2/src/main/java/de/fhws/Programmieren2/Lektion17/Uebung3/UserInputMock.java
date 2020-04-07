package de.fhws.Programmieren2.Lektion17.Uebung3;

import java.util.ArrayList;

public class UserInputMock implements LineProvider
{
	private ArrayList<String> UserInputMock;
	
	public UserInputMock(String initialInputMock)
	{
		UserInputMock = new ArrayList<String>();
		this.UserInputMock.add(initialInputMock);
	}
	
	public void setUserInputMock(String UserInputMock)
	{
		this.UserInputMock.add(UserInputMock);
	}
	
	@Override
	public String nextLine()
	{
		String result = "";
		try
		{
			result = this.UserInputMock.get(0);
			this.UserInputMock.remove(0);
		}
		catch(RuntimeException e)
		{
			result = "";
		}
		
		return result;
	}
}
