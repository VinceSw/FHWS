package de.fhws.fiw.Lektion4;

import java.util.Scanner;

public class Lektion4_Uebung3
{

	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		System.out.println("Bitte zu untersuchende Zahl eingeben: ");
		int checkNum = Integer.valueOf(inputScan.nextLine());
		boolean isPrimeNumber = true;
		int j = 2;
		
		for(int k = 2; k <= Math.sqrt(checkNum); k++)
		{
			if(checkNum % k == 0)
			{
				isPrimeNumber = false;
			}
		}
		
		if(isPrimeNumber)
		{
			System.out.println("Die Zahl " + checkNum + " ist eine Primzahl\n");
		}
		else
		{
			System.out.println("Die Zahl " + checkNum + " ist keine Primzahl\n");
		}
		isPrimeNumber = true;
		
		
		while(j <= checkNum)
		{
			//Suchen nach einem Teiler zwischen 2 und der Wurzel der eingegebenen Zahl -> Zeitersparnis bei großen Zahlen immens
			//Bis zur Zahl 1.000.000 getestet
			for(int i = 2; i <= Math.sqrt(j); i++)
			{
				if(j % i == 0)
				{
					isPrimeNumber = false;
				}
			}
			
			//Falls kein Teiler gefunden wurde -> Ausgabe
			if(isPrimeNumber)
			{
				System.out.println("Die Zahl " + j + " ist eine Primzahl");
			}
			
			//Zurücksetzen des Flags auf Ursprungszustand
			isPrimeNumber = true;
			j++;
		}
		
		inputScan.close();
	}
}
