package de.fhws.fiw.Lektion7;

public class Lektion7_Euro
{

	public static void main(String[] args)
	{
		System.out.println("Wahrscheinlichkeit: " + getProbablility());
	}

	
	public static double getProbablility()
	{
		int amountTries = 10000;
		int probability = 0;
		int i = 0;
		
		while( i < amountTries)
		{
			double randDesk = Math.round(Math.random());
			int randDrawer = (int)(Math.random()*3+1);
			
			if(randDesk == 1d)
			{
				if(randDrawer == 3)
				{
					probability++;
					i++;
				}
			}
			else
			{
				i++;
			}
		}
		
		System.out.println(probability);
		System.out.println(i);
		System.out.println(amountTries);
		return probability/(double)amountTries;
	}
}
