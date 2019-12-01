package de.fhws.fiw.Lektion7;

import java.util.concurrent.CountDownLatch;

public class Lektion7_Euro
{

	public static void main(String[] args)
	{
		System.out.println("Wahrscheinlichkeit: " + getProbablility());
	}

	
	public static double getProbablility()
	{
		int drawer1 = 0;
		int drawer2 = 0;
		int drawer3 = 0;
		int counter1 = 0;
		
		for(int i = 0; i < 10000; i++)
		{
			double randDesk = Math.round(Math.random());
			
			if(randDesk == 1d)
			{
				int randProb = (int)(Math.random()*3+1);
				counter1++;
				switch (randProb)
				{
				case 1:
					drawer1++;
					break;
				case 2:
					drawer2++;
				case 3:
					drawer3++;
				}	
			}
			
		}
		
		System.out.println("-------------------------------------------------");
		System.out.println("Euro in Fach 1: " + drawer1);
		System.out.println("Euro in Fach 2: " + drawer2);
		System.out.println("Euro in Fach 3: " + drawer3);
		System.out.println("Euro in Schreibtisch: " + counter1);
		System.out.println("-------------------------------------------------");
		
		return drawer3/(double)counter1;
	}
}
