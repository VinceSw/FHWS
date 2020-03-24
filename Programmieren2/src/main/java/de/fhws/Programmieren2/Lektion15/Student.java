package de.fhws.Programmieren2.Lektion15;

public class Student extends Person
{
	protected static final String STUDIERT_STRING = "Der Student studiert.";
	
	@Override
	public void gibTaetigkeitAus()
	{
		System.out.println(STUDIERT_STRING);  
	}
}
