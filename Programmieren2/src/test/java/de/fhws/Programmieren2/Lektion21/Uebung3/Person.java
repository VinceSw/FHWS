package de.fhws.Programmieren2.Lektion21.Uebung3;

public class Person
{
	String name, firstName;

	public Person(String name, String firstName)
	{
		this.name = name;
		this.firstName = firstName;
	}

	@Override
	public String toString()
	{
		return firstName + " " + name;
	}
}
