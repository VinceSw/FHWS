package de.fhws.fiw.Lektion5;
import java.util.Scanner;

public class Lektion5_Uebung5
{
	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Bitte geben Sie die Anzahl der Rechtecke ein: ");
		int anzahlRechtecke = Integer.valueOf(inputScan.nextLine());
		double anteilRechtecke = 1.0d / anzahlRechtecke;
		double flaecheRechteck = 0d;
		double x = 0d;
		int hypo = 1;
		
		for(int i = 0; i < anzahlRechtecke; i++)
		{
			x = Math.sqrt(hypo - Math.pow(i * anteilRechtecke, 2));
			flaecheRechteck += x * anteilRechtecke;
		}
		
		System.out.println("------------------------------------------------\nPI: \t" + 4d * flaecheRechteck);
		inputScan.close();
	}
}
