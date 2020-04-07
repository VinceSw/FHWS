package de.fhws.Programmieren2.Lektion17.Uebung3;

import java.util.Scanner;

public class UserInput implements LineProvider
{
	private Scanner inputScan;
	
	public UserInput(Scanner inputScan)
	{
		this.inputScan = inputScan;
	}
	
	@Override
	public String nextLine()
	{
		
		return inputScan.nextLine();
	}
}
