package de.fhws.Programmieren2.Lektion16.Uebung4;

import java.util.Random;

public class Cyborg implements IMensch, IRoboter
{
	public void essen()
	{
		System.out.println("Cyborg isst...");
	}
	
	public void schlafen()
	{
		System.out.println("Cyborg schläft...");
	}
	
	public void arbeiten()
	{
		System.out.println("Cyborg arbeitet...");
	}
	
	public void aufladen()
	{
		System.out.println("Cyborg lädt auf...");
	}
	
	public void warten()
	{
		System.out.println("Cyborg wartet...");
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
	
	//Kombinierte Entscheidung der Klassen Mensch und Roboter
	public Reaktion entscheide(Gefahrensituation gefahr)
	{
		Mensch m = new Mensch();
		Roboter r = new Roboter();
		Reaktion humanReaction = m.entscheide(gefahr);
		Reaktion robotReaction = r.entscheide(gefahr);
		Reaktion cyborgReaction;
		
		if(humanReaction.equals(robotReaction))
		{
			cyborgReaction = robotReaction;
		}
		else
		{
			//Zufällige Entscheidung zwischen menschlicher und robotischer Reaktion
			Random random = new Random();
			if(random.nextFloat() > 0.49f)
			{
				cyborgReaction = humanReaction;
			}
			else
			{
				cyborgReaction = robotReaction;
			}
		}
		
		return cyborgReaction;
	}
}
