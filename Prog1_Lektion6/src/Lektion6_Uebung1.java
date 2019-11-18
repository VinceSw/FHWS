import java.util.Scanner;

public class Lektion6_Uebung1
{

	public static void main(String[] args)
	{
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
		int intNumber = (int)inputNumber;
		
		if(inputNumber - intNumber >= 0.5)
		{
			intNumber++; 
		}
		
		return (double)intNumber;
	}
	
	public static double customRound(double inputNumber, int precision)
	{
		int exponent = getExponent(precision);
		
		double result = customRound(inputNumber * exponent);
		result = result / exponent;
		
		return result;
	}
	
	private static int getExponent(int precision)
	{
		//Getting the 
		int exponent = 1;
		
		for(int i = 0; i < precision; i++)
		{
			exponent *= 10;
		}
	
		return exponent;
	}
}
