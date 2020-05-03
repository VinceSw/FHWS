package de.fhws.Programmieren2.Lektion19.Uebung1;

import java.io.Serializable;

public class GuessingAttempt implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 133961183263645782L;
	char guessedLetter;
	
	public GuessingAttempt(char guessedLetter)
	{
		this.guessedLetter = guessedLetter;
	}
	
	public char getGuessedLetter()
	{
		return this.guessedLetter;
	}
}
