package de.fhws.fiw.Lektion3;

import java.io.IOException;
import java.util.Scanner;

public class Lektion3_Uebung5
{

	public static void main(String[] args) throws IOException
	{
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("Enter the matriculation number to be verified: ");
		String matNr = inputScan.nextLine();
		String matPrefix = matNr.substring(0, 2);
		
		if(matNr.trim().length() == 7 && (matPrefix.equals("50") || matPrefix.equals("51") || matPrefix.equals("61")))
		{
			System.out.println("As the matriculation number begins with 50, 51 or 61 and has a length of 7 digits, it is valid.");
			
		}
		else
		{
			System.out.println("The number you entered was not a valid matriculation number.");
		}
		System.out.print("\nMatriculation number: \t" + matNr + "\nPrefix: \t\t" + matPrefix);
		
		
		inputScan.close();
	}
}
