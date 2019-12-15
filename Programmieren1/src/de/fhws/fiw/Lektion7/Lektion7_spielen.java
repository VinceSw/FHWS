package de.fhws.fiw.Lektion7;

import java.util.Scanner;

public class Lektion7_spielen
{

	public static void main(String[] args)
	{
		char[] inputChar = getInput();
		spielen(inputChar);
	}
	
	public static char[] getInput()
	{
		Scanner inputScan = new Scanner(System.in);
		System.out.println("Bitte geben Sie eine Zeichenkette ein: ");
		char[] inputChar = inputScan.nextLine().toCharArray();
		
		inputScan.close();
		
		return inputChar;
	}
	
	public static void spielen(char[] wordArray)
	{
		int amountVowels = getResultArray(wordArray);
		char[] newWordArr = new char[wordArray.length + (amountVowels*2)];
		
		newWordArr = manipulateInput(wordArray, newWordArr);
		
		outputNewWord(newWordArr);
	}
		
	public static int getResultArray(char[] wordArray)
	{
		int amountVowels = 0;
		
		for(char n : wordArray)
		{
			if(n == 'a' || n == 'e' || n == 'i' || n == 'o' || n == 'u' 
					|| n == 'A' || n == 'E' || n == 'I' || n == 'O' || n == 'U' )
				amountVowels++;
		}
		
		return amountVowels;
	}
	
	public static char[] manipulateInput(char[] wordArray, 
			char[] newWordArr)
	{
		int countNewIndex = 0;
		
		for(int i = 0; i < wordArray.length; i++)
		{
			char n = wordArray[i];
			
			if(n == 'a' || n == 'e' || n == 'i' || n == 'o' || n == 'u' 
					|| n == 'A' || n == 'E' || n == 'I' || n == 'O' || n == 'U' )
			{
				newWordArr[countNewIndex] = n;
				newWordArr[++countNewIndex] = 'b';
				newWordArr[++countNewIndex] = n;
			}
			else
			{
				newWordArr[countNewIndex] = n;
			}
			
			countNewIndex++;
		}
		
		return newWordArr;
	}
	
	public static void outputNewWord(char[] newWordArr)
	{
		String newWord = String.copyValueOf(newWordArr);
		
		System.out.println("Manipulierte Zeichenkette: " + newWord);
	}
}
