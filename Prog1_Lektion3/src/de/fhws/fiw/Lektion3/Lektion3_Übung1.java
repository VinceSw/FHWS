package de.fhws.fiw.Lektion3;

import java.io.IOException;
import java.util.Scanner;

public class Lektion3_Übung1 {

	public static void main(String[] args) throws IOException 
	{
		Scanner inputScan = new Scanner(System.in);
		String ergebnisText;
		String antwort;
		
		do
		{
			System.out.print("Bitte geben Sie eine ganzzahlige Zahl ein: ");
			int inputZahl = Integer.parseInt(inputScan.nextLine());
			
			if(inputZahl % 7 == 0)
			{
				ergebnisText = "Die eingegebene Zahl \"" + inputZahl + "\" ist ganzzahlig durch 7 teilbar.";
			}
			else
			{
				ergebnisText = "Die eingegebene Zahl \"" + inputZahl + "\" ist nicht ganzzahlig durch 7 teilbar.";
			}
			
			System.out.println(ergebnisText);	
			System.out.print("Wollen Sie noch eine Zahl überprüfen? (J/N): ");
			antwort = inputScan.nextLine().toUpperCase().trim();
		}while(antwort.equals("J"));
		
		inputScan.close();
	}

}
