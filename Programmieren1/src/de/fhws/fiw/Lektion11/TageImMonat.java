package de.fhws.fiw.Lektion11;

import java.util.Scanner;

public class TageImMonat
{

	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		boolean isValid = true;
		
		do
		{
			System.out.print("Bitte geben Sie einen Monat ein: ");
			String monat = inputScan.nextLine();
			
			try
			{
				System.out.println(tageImMonat(monat));
				isValid = true;
			} 
			catch(RuntimeException e)
			{
				System.out.println("Es trat ein Fehler auf: " +  e.getMessage());
				isValid = false;
			}
		}while(!isValid);
		
		inputScan.close();
	}
	
	public static int tageImMonat(String monat)
	{
		int tage;
		switch(monat) 
		{
			case "Februar":
				tage = 28;
			break;
			case "April":
			case "Juni":
			case "September":
			case "November":
				tage = 30;
			break;
			case "Januar":
			case "März":
			case "Mai":
			case "Juli":
			case "August":
			case "Oktober":
			case "Dezember":
				tage = 31;
			break;
			default:
			throw new RuntimeException("falscher Monatsname");
		}
		return tage;
	}

}
