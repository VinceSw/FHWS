package de.fhws.fiw.Lektion4;

import java.io.IOException;
import java.util.Scanner;

public class Lektion4_Uebung5
{

	public static void main(String[] args) throws IOException
	{
		Scanner inputScan = new Scanner(System.in);	
		boolean eingabeUngueltig = true;
		
		while(eingabeUngueltig)
		{
			System.out.println("Bitte geben Sie eine Zahl ein:\t");
			
			int eingabeZahl = Integer.valueOf(inputScan.nextLine());
			int zahlContainer = eingabeZahl;
			int querprodukt = 1;
			
			if(zahlContainer >= 1 && zahlContainer <= 1000000) 
			{
				while(zahlContainer > 0)
				{
					int remainder = zahlContainer % 10;
					querprodukt *= remainder;
					zahlContainer = (int)(zahlContainer / 10); 
				}
				System.out.println("Das Querprodukt der Zahl " + eingabeZahl + " betraegt " + querprodukt);
				eingabeUngueltig = false;
			}
			else
			{
				System.out.println("FEHLER - Zahl ist ungueltig.");
			}
		}
		
		inputScan.close();
	}

}
