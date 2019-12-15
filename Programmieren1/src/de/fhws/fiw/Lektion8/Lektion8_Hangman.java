package de.fhws.fiw.Lektion8;

import java.util.Arrays;
import java.util.Scanner;

public class Lektion8_Hangman
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

		System.out.println(randomWord);
		return availableWords[randomWord].toUpperCase().toCharArray();
	}

	/**
	 * Gets the user input and contains the main logik
	 * @param word - a char array that contains the searched word
	 */
	public static void processGame(char[] word)
	{
		Scanner inputScan = new Scanner(System.in);
		char[] guessedArray = new char[word.length];
		Arrays.fill(guessedArray, '_');
		int tries = 0;
		String wordStr = String.valueOf(word);
		String guessedStr = "";
		
		//Process as long as the user hasn't won and hasn't reached the limit auf tries
		while(tries < 15 && !wordStr.equals(guessedStr))
		{
			System.out.print("\n\n" + (tries + 1) + ".Versuch: ");
			
			//Display the current result 
			for(char n : guessedArray)
			{
				System.out.print(n + " ");
			}
			
			char inputChar = inputScan.nextLine().trim().charAt(0);
			
			//Set the input letter at the right place in guessedLetters if it's in the searched word
			for (int i = 0; i < word.length; i++)
			{
				//Convert to String so that it can be used in the "equals" method and be put to uppercase
				String x = Character.toString(inputChar).toUpperCase();

				if (String.valueOf(word[i]).equals(x))
				{
					guessedArray[i] = word[i];
				} 
			}
			tries++;
		   guessedStr = String.valueOf(guessedArray); 
		}
		
		getResult(tries, wordStr, guessedStr);
		inputScan.close();
	}
	
	private static void getResult(int triesNeeded, String wordStr, String guessedStr)
	{
		if(triesNeeded == 15 || !wordStr.equals(guessedStr))
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