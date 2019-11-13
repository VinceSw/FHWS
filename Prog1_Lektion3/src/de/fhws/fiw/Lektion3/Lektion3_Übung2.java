package de.fhws.fiw.Lektion3;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Lektion3_�bung2 {

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

		//Einlesen der Parameter �ber den Scanner mit Validierung, ob es sich bei der Eingabe um einen g�ltigen
		//Durchmesser handelt
		System.out.print("Bitte geben Sie den Durchmesser f�r die erste Pizza ein: ");
		if(inputScan.hasNext("26".trim()) || inputScan.hasNext("28".trim()) 
				|| inputScan.hasNext("30".trim()))
		{
			dmPizza1 = Float.valueOf(inputScan.nextLine());
			System.out.print("Bitte geben Sie den Preis f�r die erste Pizza ein: ");
			preisPizza1 = Float.valueOf(inputScan.nextLine());
			System.out.print("Bitte geben Sie den Durchmesser der zweiten Pizza ein: ");

			if(inputScan.hasNext("26".trim()) || inputScan.hasNext("28".trim()) 
					|| inputScan.hasNext("30".trim()))
			{
				dmPizza2 = Float.valueOf(inputScan.nextLine());
				System.out.print("Bitte geben Sie den Preis f�r die zweite Pizza ein: ");
				preisPizza2 = Float.valueOf(inputScan.nextLine());
				
				System.out.println("-----------------------------------------------------------------------------");
				
				//Berechnen der Fl�che beider Pizzen
				flaechePizza1 = (float) (PI * Math.pow((dmPizza1/2), 2));
				flaechePizza2 = (float) (PI * Math.pow((dmPizza2/2), 2));
				
				//Berechnen des Preises pro "cm�"
				preisProFlaeche1 = (preisPizza1/flaechePizza1);
				preisProFlaeche2 = (preisPizza2/flaechePizza2);
				
				//Ausgabe des Ergebnises je nach Gr��en-/Preisverh�ltnis
				if( preisProFlaeche1 < preisProFlaeche2 )
				{
					System.out.print("Da der Preis pro cm� f�r Pizza 1 bei " + preisProFlaeche1 +"� liegt, ist ");
					System.out.print("Sie gegen�ber der zweiten Pizza mit " + preisProFlaeche2 + "� pro cm� g�nstiger.");
				}
				else
				{
					System.out.print("Da der Preis pro cm� f�r Pizza 2 bei " + preisProFlaeche2 +"� liegt, ist ");
					System.out.print("Sie gegen�ber der ersten Pizza mit " + preisProFlaeche1 + "� pro cm� g�nstiger.");
				}
			}
			else
			{
				System.out.println("Bitte geben Sie einen g�ltigen Durchmesser f�r Pizza 1 ein. (26, 28, 30)");
			}	
		}
		else
		{
			System.out.println("Bitte geben Sie einen g�ltigen Durchmesser f�r Pizza 1 ein. (26, 28, 30)");
		}
		
		//Schlie�en des Scanners
		inputScan.close();
	}
}
