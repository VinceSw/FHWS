package de.fhws.fiw.Lektion6;
import java.util.Locale;
import java.util.Scanner;

public class Lektion6_Uebung5
{

	public static void main(String[] args)
	{
		Locale.setDefault(new Locale("en", "US"));
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Bitte geben Sie die Basis ein: ");
		double inputBase = Double.valueOf(inputScan.nextLine());
		System.out.print("Bitte geben Sie den Exponenten ein: ");
		int inputExponent = Integer.valueOf(inputScan.nextLine());
		
		System.out.println("Ergebnis: " + 
		raiseToPower(inputBase, inputExponent));
		inputScan.close();
	}
	
	public static double raiseToPower(double base, int exponent)
	{
		double x = base;
		
		if(exponent == 0)
		{
			return 1d;
		}
		else
		{
			x *= raiseToPower(base, --exponent);
		}
		
		return x;
		
	}

}
