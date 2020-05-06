package de.fhws.Programmieren2.Lektion19.Uebung1;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class HangmanTCPClient
{
	private static GameData gameWord;
	
	public static void main(String[] args)
	{
		boolean activeGame = true; 
		final String HOST = "localhost";
		final int PORT = 5000;
		
		System.out.println("Initializing Connection...");
		try(Socket connection = new Socket(HOST, PORT);
				InputStream is = connection.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				BufferedReader terminalInput = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
				ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());)
		{
			System.out.println("Initialization successfull");
			
			while(activeGame)
			{
				play(ois, terminalInput, oos);
				
				System.out.print("Do you want to play again? (y/n): ");
				String answer = terminalInput.readLine().toUpperCase();
				bw.write(answer + "\n");
				bw.flush();
				
				activeGame = answer.equals("Y");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void play(ObjectInputStream ois, BufferedReader terminalInput, ObjectOutputStream oos) throws IOException, ClassNotFoundException
	{
		String result = "", anonWord = "";
		
		
		contactServerIn(ois);
		anonWord = String.valueOf(HangmanTCPClient.gameWord.getAnonymizedWord());
		wordOutput(anonWord);
		
		while(!gameWord.isGameWon() && !gameWord.isGameLost())
		{
			contactServerOut(terminalInput, oos);
			gameWord = (GameData)ois.readObject();
			
			
			if(gameWord.isCorrect())
			{
				if(gameWord.isGameWon())
				{
					result = "won";
					break;
				}
				else if(gameWord.isGameLost())
				{
					result = "lost";
					break;
				}
				else
				{
					wordOutput(String.copyValueOf(gameWord.getAnonymizedWord()));
				}
			}
		}
		
		System.out.println("\n****************************************************");
		System.out.print("You've " + result + "!");
		System.out.println("\n****************************************************\n");
	}
	
	public static void contactServerOut(BufferedReader terminalInput, ObjectOutputStream oos)
	{
		try
		{
			System.out.print("\nChoose a letter: ");
			GuessingAttempt ga = new GuessingAttempt(terminalInput.readLine().toUpperCase().charAt(0));
			oos.writeObject(ga);
			oos.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void contactServerIn(ObjectInputStream ois)
	{
		try
		{
			gameWord = (GameData)ois.readObject();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void wordOutput(String word)
	{
		System.out.print("\nWord: ");
		char[] output = word.toCharArray();
		
		for(int i = 0; i < output.length; i++)
		{
			System.out.print(output[i] + " ");
		}
		System.out.println();
	}
}
