import java.util.Scanner;
import java.util.Locale;

public class Lektion6_Uebung1
{

	public static void main(String[] args)
	{
		Locale.setDefault(new Locale("en", "US"));
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Bitte geben Sie eine Fließkommazahl ein: ");
		double inputNumber = Double.valueOf(inputScan.nextLine());
		
		System.out.print("\nBitte geben Sie die gewünschte Genauigkeit der Rundung ein: ");
		int precision = Integer.valueOf(inputScan.nextLine());

		if(precision > 0)
		{
			System.out.println(customRound(inputNumber, precision));
		}
		else
		{
			System.out.println(customRound(inputNumber));
		}
		
		inputScan.close();
	}
	
	public static double customRound(double inputNumber)
	{
		long intNumber = (long)inputNumber;
		double difference = inputNumber - intNumber;
		
		if(difference >= 0.5)
		{
			intNumber++; 
		}
		else if(difference <= -0.5)
		{
			intNumber--;
		}
		
		return (double)intNumber;
	}
	
	public static double customRound(double inputNumber, int precision)
	{
		int exponent = getExponent(precision);
		
		double result = customRound(inputNumber * exponent);
		result /= exponent;
		
		return result;
	}
	
	private static int getExponent(int precision)
	{ 
		int exponent = 1;
		
		for(int i = 0; i < precision; i++)
		{
			exponent *= 10;
		}
		return exponent;
	}
}