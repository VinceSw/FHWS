package de.fhws.fiw.Lektion4;

import java.util.Scanner;

public class Lektion4_Uebung2
{

	public static void main(String[] args) throws InterruptedException
	{
		Scanner inputScan = new Scanner(System.in);
		System.out.println("Bitte Falldauer in Sekunden eingeben: ");
		int duration = 0;
		
		if (inputScan.hasNextInt())
		{
			duration = Integer.valueOf(inputScan.nextLine());
			
			double distance = 0d;
			double acceleration = 9.80665d;
			
			for(int i = 1; i <= duration ; i++)
			{
				distance = (0.5d * acceleration * Math.pow(i, 2));
				
				Thread.sleep(1000);
				if(i == 1 ||(i - 1) % 5 == 0 ) 
				{
					System.out.println("Nach " + i + " Sekunden zurückgelegte Strecke: " + distance);
				}
			}
		}
		else
		{
			System.out.println("Ihre Eingabe war ungültig");
		}
		
		inputScan.close();
	}
}