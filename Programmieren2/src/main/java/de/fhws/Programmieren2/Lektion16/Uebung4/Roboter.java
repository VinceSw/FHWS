package de.fhws.Programmieren2.Lektion16.Uebung4;

public class Roboter implements IRoboter
{
	public void aufladen()
	{
		System.out.println("Roboter lädt auf...");
	}
	
	public void warten()
	{
		System.out.println("Roboter wartet...");
	}
	
	public void arbeiten()
	{
		System.out.println("Roboter arbeitet...");
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
		
		return reaktion;
	}
}
