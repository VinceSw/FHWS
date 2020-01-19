package de.fhws.fiw.Lektion12;

public class Personenknoten
{
	private int age;
	private String lastname;
	Personenknoten prev;
	Personenknoten next;
	
	public Personenknoten(int age, String lastname)
	{
		this.age = age;
		this.lastname = lastname;
	}
	
	public Personenknoten(int age, String lastname, Personenknoten prev, Personenknoten next)
	{
		this.age = age;
		this.lastname = lastname;
		this.prev = prev;
		this.next = next;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public String getLastname()
	{
		return this.lastname;
	}
	
	public Personenknoten getPrevious()
	{
		return this.prev;
	}
	
	public Personenknoten getNext()
	{
		return this.next;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	
	public void setPrevious(Personenknoten prev)
	{
		this.prev = prev;
	}
	
	public void setNext(Personenknoten next)
	{
		this.next = next;
	}

}
