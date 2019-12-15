package de.fhws.fiw.Lektion7;

import java.util.Scanner;
import java.util.Locale;

public class Lektion7_ArithMittel
{

	public static void main(String[] args)
	{
		Locale.setDefault(new Locale("en", "US"));
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Bitte geben Sie die Anzahl der einzugebenden Werte ein: ");
		int amountValues = Integer.valueOf(inputScan.nextLine());
		
		if(amountValues > 0)
		{
			double[] inputValues = new double[amountValues];
			inputValues = getValues(amountValues, inputScan);
			
			System.out.println("Kleinster Wert:\t\t" + getMinValue(inputValues));
			System.out.println("Groesster Wert:\t\t" + getMaxValue(inputValues));
			System.out.println("Arithmetisches Mittel:\t" + getArithmeticMean(inputValues));	
			System.out.println("Standardabweichung:\t" + getStandardDeviation(inputValues));
		}
		else
		{
			inputScan.close();
			throw new IllegalArgumentException("Die Anzahl der einzugebenden "
					+ "Werte muss größer 0 sein!");
		}
		
		inputScan.close();
	}
	
	/**
	 * Gets a certain amount of values from input.
	 * @param amount of values that should be requested.
	 * @param inputScan a scanner object that is used to get the input
	 * @return
	 */
	private static double[] getValues(int amount, Scanner inputScan)
	{
		double[] inputValues = new double[amount];
		
		for(int i = 0; i < amount; i++)
		{
			System.out.print((i + 1) + ". Wert: ");
			inputValues[i] = Double.valueOf(inputScan.nextLine());
		}
		
		return inputValues;
	}
	
	/**
	 * Calculates the arithmetic mean of all values of an array.
	 * @param values array containing the values from which the mean should be calculated from.
	 * @return arithmetic mean of all values of an array.
	 */
	public static double getArithmeticMean(double[] values)
	{
		double sum = 0d;
			
		for(double x : values)
		{
			sum += x; 
		}

		return sum / values.length;
	}
	
	/**
	 * Calculates the standard deviation.
	 * @param values array containing the values from which the standard deviation should be calculated from.
	 * @return standard deviation of all values of an array.
	 */
	public static double getStandardDeviation(double[] values)
	{
		double arithMean = getArithmeticMean(values);
		
		double sum = 0d;
				
		for(double x : values)
		{
			sum += Math.pow(x - arithMean, 2); 
		}

		return Math.sqrt(sum / values.length);
	}
	
	/**
	 * determines the smallest value of an array.
	 * @param values array of values that should be evaluated.
	 * @return Smallest value of an array
	 */
	public static double getMinValue(double[] values)
	{
		double min = values[0];
	   for(int i = 1; i < values.length; i++) 
		{
			if (values[i] < min) 
			{
		 		min = values[i];
	 		}
		}
	   return min;
	}
	
	/**
	 * determines the biggest value of an array.
	 * @param values array of values that should be evaluated.
	 * @return biggest value of an array.
	 */
	public static double getMaxValue(double[] values)
	{
		double max = values[0];
	   for(int i = 1; i < values.length; i++) 
		{
			if (values[i] > max) 
			{
		 		max = values[i];
	 		}
		}
	   return max;
	}
}