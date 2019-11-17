import java.util.Scanner;

public class Lektion6_Uebung1
{

	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Bitte geben Sie eine Fließkommazahl ein: ");
		double inputZahl = Double.valueOf(inputScan.nextLine());
		
		System.out.print("\nBitte geben Sie die gewünschte Genauigkeit der Rundung ein: ");
		if(inputScan.hasNextInt())
		{
			int precision = Integer.valueOf(inputScan.nextLine());
	
			if(precision > 0)
			{
				System.out.println(customRound(inputZahl, precision));
			}
		}
		else
		{
			System.out.println(customRound(inputZahl));
		}
		
		inputScan.close();
	}
	
	public static double customRound(double a)
	{
		int testVar = (int)a;
		
		if(a - testVar >= 0.5)
		{
			testVar++; 
		}
		
		return testVar;
	}
	
	public static double customRound(double a, int precision)
	{
		double exponent = getExponent(precision);
		
		return exponent;
	}
	
	public static double getExponent(int precision)
	{
		double exponent = 1;
		
		for(int i = 0; i < precision; i++)
		{
			exponent /= 10;
		}
		
		return exponent;
	}

}
