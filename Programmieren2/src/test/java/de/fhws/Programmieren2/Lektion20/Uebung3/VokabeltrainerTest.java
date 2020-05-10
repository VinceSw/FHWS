package de.fhws.Programmieren2.Lektion20.Uebung3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class VokabeltrainerTest
{

	@Test
	void test()
	{
		Vokabeltrainer guessingGame = new Vokabeltrainer();
		guessingGame.addToDictionary("to clean", "reinigen", "säubern", "putzen");
		guessingGame.addToDictionary("to expand", "vergrößern", "wachsen");
		guessingGame.addToDictionary("to immitate", "nachmachen", "kopieren", "nachahmen");
		
		guessingGame.creatRandomWordToGuess();
		
		Scanner inputScan = new Scanner(System.in);
		System.out.println("Wie heißt \"" + guessingGame.getStringToGuess() + "\" auf Deutsch?");
		String guess = inputScan.nextLine();
		boolean correct = guessingGame.guess(guess);
		assertTrue(correct);
		
		if(correct) System.out.println("Richtig!");
		else System.out.println("Falsch!");
		inputScan.close();
	}

}
