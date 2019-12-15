package de.fhws.fiw.Lektion6;
import java.util.Scanner;

public class Lektion6_Uebung4
{

	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Bitte geben Sie die zu untersuchende Zahl ein: ");
		int inputNumber = Integer.valueOf(inputScan.nextLine());
		
		if(checkPrimeNumber(inputNumber))
		{
			System.out.println("Die eingegebene Zahl ist eine Primzahl");
		}
		else
		{
			System.out.println("Die eingegebene Zahl ist keine Primzahl");
		}

	}
	
	public static boolean checkPrimeNumber(int inputNumber)
	{
		boolean isPrimeNumber = true;
		int j = 2;
		
		for(int k = 2; k <= Math.sqrt(inputNumber); k++)
		{
			if(inputNumber % k == 0)
			{
				isPrimeNumber = false;
			}
		}	
		
		return isPrimeNumber;
	}
}
