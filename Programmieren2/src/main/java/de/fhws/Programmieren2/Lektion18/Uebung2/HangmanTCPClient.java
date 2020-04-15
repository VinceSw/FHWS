package de.fhws.Programmieren2.Lektion18.Uebung2;

import java.io.IOException;
import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class HangmanTCPClient
{
	public static void main(String[] args)
	{
		boolean activeGame = true; 
		final String HOST = "localhost";
		final int PORT = 5000;
		
		System.out.println("Initializing Connection...");
		try(Socket connection = new Socket(HOST, PORT);
				InputStream is = connection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				BufferedReader terminalInput = new BufferedReader(new InputStreamReader(System.in));
				OutputStream os = connection.getOutputStream();
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));)
		{
			System.out.println("Initialization successfull");
			
			while(activeGame)
			{
				wordOutput(br.readLine());
				play(br, terminalInput, bw);
				
				System.out.print("Do you want to play again? (y/n): ");
				String answer = terminalInput.readLine();
				bw.write(answer + "\n");
				bw.flush();
				
				activeGame = answer.toUpperCase().equals("Y");
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void play(BufferedReader br, BufferedReader terminalInput, BufferedWriter bw) throws IOException
	{
		boolean gameIsOngoing = true;
		
		while(gameIsOngoing)
		{
			contactServer(terminalInput, bw);
			
			String serverAnswer = null;
			if((serverAnswer = br.readLine()).equals("OK"))
			{
				serverAnswer = br.readLine();
				
				if(serverAnswer.equals(GameResult.lost.toString()) || serverAnswer.equals(GameResult.won.toString()))
				{
					System.out.println("\n****************************************************");
					System.out.print("You've " + serverAnswer + "!");
					System.out.println("\n****************************************************");
					gameIsOngoing = false;
				}
				else
				{
					wordOutput(serverAnswer);
				}
			}
		}
	}
	
	public static void contactServer(BufferedReader terminalInput, BufferedWriter bw)
	{
		String chosenLetter;
		try
		{
			System.out.print("\nChoose a letter: ");
			chosenLetter = String.valueOf(terminalInput.readLine().charAt(0));
			bw.write(chosenLetter + "\n");
			bw.flush();
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
