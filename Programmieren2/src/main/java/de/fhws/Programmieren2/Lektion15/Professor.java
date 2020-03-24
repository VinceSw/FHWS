package de.fhws.Programmieren2.Lektion15;

public class Professor extends Person
{
	protected static final String LEHRT_STRING = "Der Professor lehrt.";
	
	@Override
	public void gibTaetigkeitAus()
	{
		System.out.println(LEHRT_STRING);
	}
}
