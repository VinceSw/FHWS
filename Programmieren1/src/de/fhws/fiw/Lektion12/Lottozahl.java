package de.fhws.fiw.Lektion12;

public class Lottozahl
{
	private int lottozahl;
	Lottozahl next;
	
	public int getLottozahl()
	{
		return lottozahl;
	}
	
	public Lottozahl(int lottozahl)
	{
		if(lottozahl > 0 && lottozahl < 50)
		{
			this.lottozahl = lottozahl;	
		}
		else
		{
			throw new IllegalArgumentException("The lottery number has to be greater than zero and less than fifty!");
		}
	}
}
