package de.fhws.fiw.Lektion5;
import java.util.Scanner;

public class Lektion5_Uebung2
{

	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Bitte geben Sie die Basis an: ");
		double b = Double.valueOf(inputScan.nextLine());
		System.out.print("\nBitte geben Sie den Exponenten ein: ");
		int n = Integer.valueOf(inputScan.nextLine());
		double produkt = 1;
		int anzahlDurchl�ufe;
		
		if(n < 0)
		{
			anzahlDurchl�ufe = n * -1;
		}
		else
		{
			anzahlDurchl�ufe = n;
		}
		
		do
		{
			if(n > 0)
			{
				produkt *= b;
			}
			else if(n < 0)
			{
				produkt *= 1d / b;
			}
			else
			{
				produkt = 1d;
			}
			
			anzahlDurchl�ufe--;
		}while(anzahlDurchl�ufe > 0);
		
		
			System.out.println("Ergebnis: " + produkt);
			inputScan.close();
	}

}
