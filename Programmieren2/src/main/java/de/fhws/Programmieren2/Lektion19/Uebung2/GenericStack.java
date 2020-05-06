package de.fhws.Programmieren2.Lektion19.Uebung2;

import java.util.ArrayList;

public class GenericStack<E>
{
	private ArrayList<E> objectList = new ArrayList<>();
	
	public static void main(String[] args)
	{
		GenericStack<String> s = new GenericStack<>();
		s.push("Hallo");
		s.push("Welt");
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
	
	public void push(E o)
	{
		if(o == null)
			throw new RuntimeException("Invalid Arguement");
		
		objectList.add(o);
	}
	
	
	public E pop()
	{
		if(objectList.size() < 1)
			throw new RuntimeException("Invalid Arguement");
		
		int lastIndexOfList = objectList.size()-1;
		E popObject = objectList.get(lastIndexOfList);
		
		objectList.remove(lastIndexOfList);
		
		return popObject;
	}
}
