package de.fhws.fiw.Lektion7;

import java.util.Scanner;

public class Lektion7_Sinus
{

	public static void main(String[] args)
	{
		System.out.println("********************* Sinus-Rechner *********************");
		Scanner inputScan = new Scanner(System.in);
	   System.out.print("Bitte geben Sie eine Zahl ein: ");
	   double inputNumber = Double.valueOf(inputScan.nextLine());
	   
	   System.out.println("Sinus:\t" + sin(inputNumber));
	   System.out.println("Math.sin():\t" +  Math.sin(inputNumber));
	   
	   inputScan.close();
	}
	
	/**
	 *  Calculates the sine of the entered number x.
	 * @param x real number (in RAD) from which the sine is to be calculated.
	 * @return Result of the calculation; Real number between -1 and 1 (including both).
	 */
	public static double sin(double x)
	{
		double sum = x;
		double addend = 1d; 
		double numerator = x;  		//Entspricht x^1
		double denumerator = 1d; 	//Entspricht 1 fakultät
		
		for(int k = 3; addend > 1E-15 || addend < -1E-15 ; k+=2)
		{
			numerator *= -x * x;
			denumerator *= k * (k-1);
			addend = numerator / denumerator;
			sum +=  addend;
		}
		
		return sum;
	}
}
