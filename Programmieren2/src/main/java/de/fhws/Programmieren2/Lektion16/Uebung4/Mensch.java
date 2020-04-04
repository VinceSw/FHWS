package de.fhws.Programmieren2.Lektion16.Uebung4;

import java.util.Random;

public class Mensch implements IMensch
{
	public void essen()
	{
		System.out.println("Mensch isst...");
	}
	
	public void schlafen()
	{
		System.out.println("Mensch schläft...");
	}
	
	public void arbeiten()
	{
		System.out.println("Mensch arbeitet...");
	}
	
	public Reaktion autofahren(Gefahrensituation gefahr)
	{
		Reaktion reaktion;
		
		if(gefahr != null)
		{
			reaktion = entscheide(gefahr);
		}
		else
		{
			reaktion = null;
		}
		
		return reaktion;
	}
	
	public Reaktion entscheide(Gefahrensituation gefahr)
	{
		Reaktion reaktion;
		Random random = new Random();
		boolean isDetermined = (random.nextFloat() > 0.24f);
		
		if(isDetermined)
		{
			switch (gefahr)
			{
			case GEFAHR_LINKS:
				reaktion = Reaktion.RECHTS;
				break;
			case GEFAHR_RECHTS:
				reaktion = Reaktion.LINKS;
				break;
			case GEFAHR_VORNE:
				reaktion = Reaktion.BREMSEN;
				break;
			default:
				throw new RuntimeException("Invalid Arguement");
			}
		}
		else
		{
			reaktion = Reaktion.UNENTSCHIEDEN;
		}
		
		return reaktion;
	}
}
