package de.fhws.Programmieren2.Lektion19.Uebung1;

import java.io.Serializable;
import java.util.Arrays;

public class GameData implements Serializable
{
	/**
	 * generated serialVersionUID added
	 */
	private static final long serialVersionUID = -1698073754067411152L;
	private char[] anonymizedWord;
	private boolean isGameWon, isGameLost, isCorrect;
	private int amountTriesLeft;
	
	public char[] getAnonymizedWord()
	{
		return anonymizedWord;
	}

	public void setAnonymizedWord(char[] anonymizedWord)
	{
		this.anonymizedWord = anonymizedWord;
	}
	
	public boolean isGameWon()
	{
		return isGameWon;
	}

	public void setGameWon(boolean isGameWon)
	{
		this.isGameWon = isGameWon;
	}

	public boolean isGameLost()
	{
		return isGameLost;
	}

	public void setGameLost(boolean isGameLost)
	{
		this.isGameLost = isGameLost;
	}

	public boolean isCorrect()
	{
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect)
	{
		this.isCorrect = isCorrect;
	}
	
	public int getAmountTriesLeft()
	{
		return this.amountTriesLeft;
	}
	
	public void reduceAmountTries(int amount)
	{
		this.amountTriesLeft -= amount;
	}
	
	public GameData(String word)
	{
		this(word.toCharArray());
	}
	
	public GameData(char[] word)
	{
		this.anonymizedWord = new char[word.length];
		Arrays.fill(anonymizedWord, '_');
		
		this.isGameWon = false;
		this.isGameLost = false;
		this.isCorrect = false;
		this.amountTriesLeft = 15;
	}
	
	public GameData()
	{
		
	}
}
