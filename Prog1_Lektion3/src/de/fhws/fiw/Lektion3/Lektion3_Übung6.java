package de.fhws.fiw.Lektion3;

import java.util.Scanner;

public class Lektion3_Übung6
{

	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		System.out.println("Bitte geben Sie eine Jahreszahl ein");
		String messageText="";
		
		int year =  Integer.valueOf(inputScan.nextLine());
		
		if(year % 4 == 0)
		{
			if(year % 100 == 0 && year % 400 != 0)
			{
				messageText = "ist kein Schaltjahr, da ganzzahlig durch 4 und 100 teilbar, aber nicht " +
			                 "durch 400.";
			}
			else if(year % 400 == 0)
			{
				messageText = "ist ein Schaltjahr, da ganzzahlig durch 4 und 100 teilbar, aber auch" + 
					     		  "durch 400.";
			}
			else
			{
				messageText = "ist ein Schaltjahr, da ganzzahlig durch 4 teilbar.";
			}
		}
		else
		{
			messageText = "ist kein Schaltjahr, da nicht ganzzahlig durch 4 teilbar.";
		}
		
		System.out.println(year + " " + messageText);
		
		inputScan.close();
	}

}
