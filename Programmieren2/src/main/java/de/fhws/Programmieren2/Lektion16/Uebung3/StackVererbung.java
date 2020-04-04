package de.fhws.Programmieren2.Lektion16.Uebung3;

import java.util.ArrayList;

//Klasse zum Upload ins e-learning
@SuppressWarnings("all")
public class StackVererbung extends ArrayList<Object> implements Stack
{
	public void push(Object o)
	{
		if(o == null)
			throw new RuntimeException("Invalid Arguement");
		
		this.add(o);
	}
	
	public Object pop()
	{
		if(this.size() < 1)
			throw new RuntimeException("Invalid Arguement");
		
		int lastIndexOfList = this.size()-1;
		Object popObject = this.get(lastIndexOfList);
		
		this.remove(lastIndexOfList);
		
		return popObject;
	}
}
