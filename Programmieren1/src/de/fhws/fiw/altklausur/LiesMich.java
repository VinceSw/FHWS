package de.fhws.fiw.altklausur;
import java.util.Scanner;
public class LiesMich
{
	public static int liesZahl() 
	{
		Scanner inputScan = new Scanner(System.in);
		boolean isNoNumber = false;
		int zahl, result = 0;
		
		do
		{
			isNoNumber = false;
			System.out.println("Bitte geben Sie eine ganze Zahl ein: ");
			char[] inputNumber = inputScan.nextLine().toCharArray();
			result = 0;
			
			
			for(int i = 0; i < inputNumber.length; i++)
			{
				if(inputNumber[i] >=  '0' && inputNumber[i] <= '9')
				{
					zahl = inputNumber[i] - '0';
					result *= 10;
					result += zahl;
				}
				else
				{
					isNoNumber = true;
				}
			}
			
		}while(isNoNumber);
		
		inputScan.close();
		return result;
	}
	
	public static void main(String[] args)
	{
		int num = liesZahl();
		
		System.out.println(num);
	}
}
