package de.fhws.fiw.Lektion3;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Lektion3_Übung2 {

	public static void main(String[] args) throws IOException
	{
		Locale.setDefault(new Locale("en", "US"));
		//Generieren/Deklarieren von Objekten und Variablen 
		Scanner inputScan = new Scanner(System.in);
		float dmPizza1 = 0f, dmPizza2 = 0f;
		float flaechePizza1, flaechePizza2;
		float preisPizza1 = 0f, preisPizza2 = 0f;
		final float PI = (float)Math.PI;
		float preisProFlaeche1, preisProFlaeche2;

		//Einlesen der Parameter über den Scanner mit Validierung, ob es sich bei der Eingabe um einen gültigen
		//Durchmesser handelt
		System.out.print("Bitte geben Sie den Durchmesser für die erste Pizza ein: ");
		if(inputScan.hasNext("26".trim()) || inputScan.hasNext("28".trim()) 
				|| inputScan.hasNext("30".trim()))
		{
			dmPizza1 = Float.valueOf(inputScan.nextLine());
			System.out.print("Bitte geben Sie den Preis für die erste Pizza ein: ");
			preisPizza1 = Float.valueOf(inputScan.nextLine());
			System.out.print("Bitte geben Sie den Durchmesser der zweiten Pizza ein: ");

			if(inputScan.hasNext("26".trim()) || inputScan.hasNext("28".trim()) 
					|| inputScan.hasNext("30".trim()))
			{
				dmPizza2 = Float.valueOf(inputScan.nextLine());
				System.out.print("Bitte geben Sie den Preis für die zweite Pizza ein: ");
				preisPizza2 = Float.valueOf(inputScan.nextLine());
				
				System.out.println("-----------------------------------------------------------------------------");
				
				//Berechnen der Fläche beider Pizzen
				flaechePizza1 = (float) (PI * Math.pow((dmPizza1/2), 2));
				flaechePizza2 = (float) (PI * Math.pow((dmPizza2/2), 2));
				
				//Berechnen des Preises pro "cm²"
				preisProFlaeche1 = (preisPizza1/flaechePizza1);
				preisProFlaeche2 = (preisPizza2/flaechePizza2);
				
				//Ausgabe des Ergebnises je nach Größen-/Preisverhältnis
				if( preisProFlaeche1 < preisProFlaeche2 )
				{
					System.out.print("Da der Preis pro cm² für Pizza 1 bei " + preisProFlaeche1 +"€ liegt, ist ");
					System.out.print("Sie gegenüber der zweiten Pizza mit " + preisProFlaeche2 + "€ pro cm² günstiger.");
				}
				else
				{
					System.out.print("Da der Preis pro cm² für Pizza 2 bei " + preisProFlaeche2 +"€ liegt, ist ");
					System.out.print("Sie gegenüber der ersten Pizza mit " + preisProFlaeche1 + "€ pro cm² günstiger.");
				}
			}
			else
			{
				System.out.println("Bitte geben Sie einen gültigen Durchmesser für Pizza 1 ein. (26, 28, 30)");
			}	
		}
		else
		{
			System.out.println("Bitte geben Sie einen gültigen Durchmesser für Pizza 1 ein. (26, 28, 30)");
		}
		
		//Schließen des Scanners
		inputScan.close();
	}
}
