package de.fhws.Programmieren2.Lektion18.Uebung2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class HangmanTCPServer
{
	private static char[] soughtValue, guessedWord;
	
	public static void main(String[] args)
	{
		boolean activeGame = true;
		
		System.out.println("Starting Server...");
		final int PORT = 5000;
		
		try(ServerSocket ss = new ServerSocket(PORT);
				Socket client = ss.accept();
				InputStream is = client.getInputStream();
				OutputStream os = client.getOutputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));)
		{
			System.out.println("Connection with client has been initialized");
			
			while(activeGame)
			{
				initializeHangman(bw);
				play(br, bw);
				
				activeGame = br.readLine().toUpperCase().equals("Y");
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static void initializeHangman(BufferedWriter bw) throws IOException
	{
		/** Prepare the array soughtWord and fill it with a random word out of the array availableWords*/
		String[] availableWords =
			{ "Programmiersprache", "Informatik", "Java", "Klausur", "Basketball", "Bücher", "Musik", "Hackathon", "Surface",
					"Technik", "Technology", "Hangman", "Aufgabe", "Methode", "String", "Character", "Datentyp", "Klassen",
					"Diagramm" };
		
		int randomValue = (int)(Math.random()*availableWords.length);
		soughtValue = availableWords[randomValue].toUpperCase().toCharArray();
		
		/*Prepape the array guessedWord and fill it with underscores */
		guessedWord = new char[soughtValue.length];
		Arrays.fill(guessedWord, '_');
		bw.write(String.valueOf(guessedWord) + "\n");
		bw.flush();
	}
	
	
	private static void play(BufferedReader br, BufferedWriter bw ) throws IOException
	{
		int tries = 15;
		
		for(int t = tries-1; t >= 0; t--)
		{
			char guessedChar = br.readLine().toUpperCase().charAt(0);
			
			if(guessedChar != ' ')
			{
				bw.write("OK\n");
				bw.flush();
			}
			
			for(int i = 0; i < soughtValue.length; i++)
			{
				if(soughtValue[i] == guessedChar)
				{
					guessedWord[i] = guessedChar;
				}
			}
			
			if(checkResult(guessedWord, bw, t))
			{
				break;
			}
			
		}
	}
	
	private static boolean checkResult(char[] guessedWord, BufferedWriter bw, int tries) throws IOException
	{
		String result = null;
		String guessedString = String.valueOf(guessedWord);
		boolean isGameDone = false;
		
		if(!guessedString.contains("_"))
		{
			result = GameResult.won.toString();
			isGameDone = true;
		}
		else if(tries == 0 && guessedString.contains("_"))
		{
			result = GameResult.lost.toString();
			isGameDone = true;
		}
		else
		{
			result = guessedString;
		}
		
		bw.write(result + "\n");
		bw.flush();
		
		return isGameDone;
	}
}
