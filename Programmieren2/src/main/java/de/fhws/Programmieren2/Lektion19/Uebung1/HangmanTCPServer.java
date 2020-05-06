package de.fhws.Programmieren2.Lektion19.Uebung1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class HangmanTCPServer
{
	private static GameWord soughtWord;
	private static GameData answer;
	
	public static void main(String[] args)
	{
		boolean activeGame = true;
		
		System.out.println("Starting Server...");
		final int PORT = 5000;
		
		try(ServerSocket ss = new ServerSocket(PORT);
				Socket client = ss.accept();
				InputStream is = client.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(is);)
		{
			System.out.println("Connection with client has been initialized");
			
			while(activeGame)
			{
				initializeHangman(oos);
				play(ois, oos);
				
				activeGame = br.readLine().toUpperCase().equals("Y");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void initializeHangman(ObjectOutputStream oos) throws IOException
	{
		soughtWord = new GameWord();
		soughtWord.random();
		
		answer = new GameData(soughtWord.getSoughtValue());
		
		oos.writeObject(answer);
		oos.flush();
		oos.reset();
	}
	
	
	private static void play(ObjectInputStream ois, ObjectOutputStream oos) throws IOException, ClassNotFoundException
	{
		int soughtWordLength = soughtWord.getSoughtValue().length;
		char[] guessedWord = new char[soughtWordLength];
		GuessingAttempt ga;
		char guessedChar;
		Arrays.fill(guessedWord, '_');
		
		for(int t = answer.getAmountTriesLeft() - 1; t >= 0; answer.reduceAmountTries(1))
		{
			ga = (GuessingAttempt)ois.readObject();
			guessedChar = ga.getGuessedLetter();
			
			if((guessedChar >= 65 && guessedChar <= 90) || (guessedChar >= 97 && guessedChar <= 122))
			{
				answer.setCorrect(true);
			}
			else
			{
				answer.setCorrect(false);
			}
			
			for(int i = 0; i < soughtWordLength; i++)
			{
				if(soughtWord.getSoughtValue()[i] == guessedChar)
				{
					guessedWord[i] = guessedChar;
				}
			}
			
			answer.setAnonymizedWord(guessedWord);
			setResult(guessedWord);
			oos.writeObject(answer);
			oos.flush();
			oos.reset();
			if(isGameEnded())
			{
				break;
			}
		}
	}
	
	private static boolean isGameEnded() throws IOException
	{
		if(answer.isGameWon() || answer.isGameLost())
			return true;
		
		return false;
	}
	
	private static void setResult(char[] guessedWord) throws IOException
	{
		String guessedString = String.valueOf(guessedWord);
		
		if(!guessedString.contains("_"))
		{
			answer.setGameWon(true);
		}
		else if(answer.getAmountTriesLeft() == 0 && guessedString.contains("_"))
		{
			answer.setGameLost(true);
		}	
	}
}