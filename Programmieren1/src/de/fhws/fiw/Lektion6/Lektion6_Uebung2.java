package de.fhws.fiw.Lektion6;
import java.util.Scanner;
import java.util.Locale;

public class Lektion6_Uebung2
{

	public static void main(String[] args)
	{
		Locale.setDefault(new Locale("en", "US"));
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Bitte geben Sie eine Zahl ein: ");
		int inputNumber = Integer.valueOf(inputScan.nextLine());
		
		double fak = getFaculty(inputNumber);
		
		System.out.println("Fakultät von " + inputNumber + ":\t" + fak);
		inputScan.close();
	}
	
	public static double getFaculty(int inputNumber)
	{
		double result = 1d; 
		
		for(int i = 1; i <= inputNumber; i++)
		{
			result *= i;
		}
		
		return result;
	}

}
