package de.fhws.Programmieren2.Lektion16.Uebung3;

import java.util.ArrayList;

@SuppressWarnings("all")
public class StackAttribute implements Stack
{
	ArrayList<Object> objectList = new ArrayList<Object>();
	
	public StackAttribute()
	{
	}
	
	public StackAttribute(ArrayList<Object> oList)
	{
		this.objectList = oList;
	}
	
	public void push(Object o)
	{
		if(o == null)
			throw new RuntimeException("Invalid Arguement");
		
		objectList.add(o);
	}
	
	
	public Object pop()
	{
		if(objectList.size() < 1)
			throw new RuntimeException("Invalid Arguement");
		
		int lastIndexOfList = objectList.size()-1;
		Object popObject = objectList.get(lastIndexOfList);
		
		objectList.remove(lastIndexOfList);
		
		return popObject;
	}
}
