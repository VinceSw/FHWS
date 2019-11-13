package de.fhws.fiw.Lektion3;

import java.util.Scanner;

public class Lektion3_Übung7
{

	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		String messageText = "";
		boolean isHoursValid = false;
		boolean isMinutesValid = false;
		boolean isSecondsValid = false;
		
		//Input
		System.out.println("Please enter the time to be validated.");
		System.out.println("Hours: \t");
		int hours = Integer.valueOf(inputScan.nextLine());
		System.out.println("Minuten: \t");
		int minutes = Integer.valueOf(inputScan.nextLine());
		System.out.println("Sekunden: \t");
		int seconds = Integer.valueOf(inputScan.nextLine());
		
		//Validation of inputs
		isHoursValid = hours >= 00 && hours <= 23;
		isMinutesValid = minutes >= 00 && minutes <= 59;
		isSecondsValid = seconds >= 00 && seconds <= 59;
		
		//Conditioned outputs
		if(isHoursValid && isMinutesValid && isSecondsValid)
		{
			messageText = "\nThe entered time " + hours + ":" + minutes + ":" + seconds + " is valid." ;
		}
		else
		{
			if(!isHoursValid)
			{
				messageText = "\nThe entered value for \"Hours\" is not valid: \t" + hours;
			}
			if(!isMinutesValid)
			{
				messageText += "\nThe entered value for \"Minutes\" is not valid: \t" + minutes;
			}
			if(!isSecondsValid)
			{
				messageText += "\nThe entered value for \"Seconds\" is not valid: \t" + seconds;
			}
		}
		
		System.out.println(messageText);

		inputScan.close();
	}

}
