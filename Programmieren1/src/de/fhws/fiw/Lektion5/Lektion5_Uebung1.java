package de.fhws.fiw.Lektion5;

public class Lektion5_Uebung1
{

	public static void main(String[] args)
	{
		int k = 1;
		double quotientValue = 0.0d;
		double ergebnis = 0d;
		
		do
		{
			quotientValue = 1.0d / Math.pow(k, 2);
			k++;
			ergebnis += quotientValue;
			System.out.println(6 * ergebnis);
			
		}while(quotientValue > 1E-5);
		
		

	}

}
