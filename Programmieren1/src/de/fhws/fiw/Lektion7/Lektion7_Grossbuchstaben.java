package de.fhws.fiw.Lektion7;

import java.util.Scanner;
import java.util.Locale;

public class Lektion7_Grossbuchstaben
{

	public static void main(String[] args)
	{
		Locale.setDefault(new Locale("en", "US"));
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Bitte geben Sie eine Zeichenfolge ein: ");
		char[] inputCharArray = inputScan.nextLine().trim().toCharArray();
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("Korrigierter String: " + inGrossbuchstaben(inputCharArray));

		inputScan.close();
	}

	public static String inGrossbuchstaben(char[] input)
	{
		for(int i = 0; i < input.length; i++)
		{
			if(input[i] >= 97 && input[i] <= 122)
			{
				input[i] = Character.toUpperCase(input[i]);
			}
		}
		
		return String.valueOf(input);
	}
}
