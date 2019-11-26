package de.fhws.fiw.Lektion7;

import java.util.Arrays;
import java.util.Scanner;

public class Lektion7_Hangman
{

	public static void main(String[] args)
	{
		System.out.println("--------------------------- Hangman ---------------------------");
		char[] charArray = getWord();

		processGame(charArray);
	}

	private static char[] getWord()
	{
		String[] availableWords =
		{ "Programmiersprache", "Informatik", "Java", "Klausur", "Basketball", "Bücher", "Musik", "Hackathon", "Surface",
				"Technik", "Technology", "Hangman", "Aufgabe", "Methode", "String", "Character", "Datentyp", "Klassen",
				"Diagramm" };
		int randomWord = (int) (Math.random() * availableWords.length);

		return availableWords[randomWord].toUpperCase().toCharArray();
	}

	/**
	 * Gets the user input and contains the main logik
	 * @param word - a char array that contains the searched word
	 */
	public static void processGame(char[] word)
	{
		Scanner inputScan = new Scanner(System.in);
		char[] guessedLetters = new char[word.length];
		Arrays.fill(guessedLetters, '_');
		int tries = 0;
		String wordStr = String.valueOf(word);
		String guessedStr = "";
		
		//Process as long as the user hasn't won and hasn't reached the limit auf tries
		while(tries < 15 && !wordStr.equals(guessedStr))
		{
			//Display the current result 
			for(char n : guessedLetters)
			{
				System.out.print(n + " ");
			}
			
			System.out.print("\n\n" + (tries + 1) + ".Versuch: ");
			char inputChar = inputScan.nextLine().trim().charAt(0);
			
			//Set the input letter at the right place in guessedLetters if it's in the searched word
			for (int i = 0; i < word.length; i++)
			{
				//Convert to String so that it can be used in the "equals" method and be put to uppercase
				String x = Character.toString(inputChar).toUpperCase();

				if (String.valueOf(word[i]).equals(x))
				{
					guessedLetters[i] = word[i];
				} 
			}
			tries++;
		   guessedStr = String.valueOf(guessedLetters); 
		}
		
		getResult(tries, wordStr, guessedStr);
		inputScan.close();
	}
	
	private static void getResult(int triesNeeded, String wordStr, String guessedStr)
	{
		if(triesNeeded == 14 || !wordStr.equals(guessedStr))
		{
			System.out.println("\nSie haben verloren!");
		}
		else
		{
			System.out.println(guessedStr + "\n");
			System.out.println("\nSie haben gewonnen!");
		}
	}
}