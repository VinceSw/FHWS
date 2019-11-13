package de.fhws.fiw.Lektion3;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Lektion3_Uebung3 {

	public static void main(String[] args) throws IOException
	{
		Locale.setDefault(new Locale("en", "US"));
		Scanner inputScan = new Scanner(System.in);
		char einzelzeichen;
		
		System.out.print("Bitte geben Sie ein Einzelzeichen ein, dass auf ihren Typ überprüft werden soll: ");
		einzelzeichen = inputScan.nextLine().charAt(0);
		
		System.out.println("\n\nBei der Eingabe handelt es sich um folgende Typen: \n");
		//Wenn Zeichen von A-Z oder a-f
		if((einzelzeichen >= 65 && einzelzeichen <= 90) || (einzelzeichen >= 97 && einzelzeichen <= 102))
		{
			//Wenn Zeichen A-F oder a-f
			if((einzelzeichen >= 65 && einzelzeichen <= 70) || (einzelzeichen >= 97 && einzelzeichen <= 102))
			{
				System.out.println("- Hexadezimale Ziffer");
			}
			//Wenn Zeichen nicht a-z
			if(!(einzelzeichen >= 97 && einzelzeichen <= 122))
			{
				System.out.println("- Gro8ßbuchstabe");	
			}
		}
		else if(einzelzeichen >= 48 && einzelzeichen <= 57) //Wenn Zeichen  0-9
		{
			if(einzelzeichen >= 48 && einzelzeichen <= 56) //Wenn Zeichen 0-7
			{
				System.out.println("- Oktale Ziffer");
			}
			
			if(einzelzeichen >= 48 && einzelzeichen <= 49) //Wenn Zeichen 0 oder 1
			{
				System.out.println("- Binäre Ziffer");
			}
			
			System.out.println("- Hexadezimale Ziffer");
		}
		else
		{
			System.out.println("- Unbekannt");
		}
		
		inputScan.close();
	}
}
