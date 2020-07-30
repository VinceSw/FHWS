package de.fhws.Programmieren2.Lektion22.Uebung3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiThreadTCPClient
{
	public static void main(String[] args)
	{
		final String SERVER = "localhost";
		final int PORT = 5000;
		Map<Integer, Boolean> resultList = null;
		
		System.out.println("Initializing connection...");
		try(Socket connection = new Socket(SERVER, PORT);
				InputStream is = connection.getInputStream();
				OutputStream os = connection.getOutputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))
				)
		{
			System.out.println("Connection successfully initialized.\n");
			
			List<Integer> listToCheck = new LinkedList<>();
			listToCheck.add(341);
			listToCheck.add(633910099);
			listToCheck.add(19);
			listToCheck.add(1024);
			listToCheck.add(17449);
			listToCheck.add(24379);
			listToCheck.add(8192);
			listToCheck.add(65535);
			
			boolean wasSuccessfull = sendList(bw, br, listToCheck);
			
			if(wasSuccessfull)
			{
				resultList = receiveResult(br, bw);
				displayResult(resultList);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("\nConnection has been closed successfully");
		}
	}
	
	private static boolean sendList(BufferedWriter bw, BufferedReader br, List<Integer> listToSend) throws IOException
	{
		String serverMessage;
		boolean wasSuccessfull = false;
		
		for(int i : listToSend)
		{
				if((serverMessage = br.readLine()).equals("OK"))
				{
					wasSuccessfull = true;
					bw.write(i+"\n");
					bw.flush();
				}
				else
				{
					System.out.println(serverMessage);
				}
		}
		
		if(wasSuccessfull)
		{
			bw.write("done\n");
			bw.flush();
		}
		
		return wasSuccessfull;
	}
	
	private static Map<Integer, Boolean> receiveResult(BufferedReader br, BufferedWriter bw) throws IOException
	{
		Map<Integer, Boolean> resultList = new HashMap<>();
		Integer key = 0;
		Boolean value = false, boolReceived = false, integerReceived = false;
		String receivedString;
		
		while(!(receivedString = br.readLine()).equals("done"))
		{
			if(isInteger(receivedString))
			{
				key = Integer.valueOf(receivedString);
				acknowledgeReception(bw);
				integerReceived = true;
			}
			else if(receivedString.equals("false"))
			{
				value = false;
				acknowledgeReception(bw);
				boolReceived = true;
			}
			else if(receivedString.equals("true"))
			{
				value = true;
				acknowledgeReception(bw);
				boolReceived = true;
			}
				
			
			if(integerReceived && boolReceived)
			{
				boolReceived = false;
				integerReceived = false;
				resultList.put(key, value);
			}
		}
		
		bw.write("finished");
		bw.flush();
		
		return resultList;
	}
	
	private static void displayResult(Map<Integer, Boolean> resultMap)
	{
		Set<Integer> keyset = resultMap.keySet();
		
		for(int key : keyset)
		{
			System.out.print(key + " -> " + resultMap.get(key).toString() + "\n");
		}	
	}
	
	private static boolean isInteger(String s)
	{
		int stringLength = s.length();
		
		for(int i = 0; i < stringLength; i++)
		{
			char currentChar = s.charAt(i);
			if(!Character.isDigit(currentChar))
				return false;
		}
		
		return true;
	}
	
	private static void acknowledgeReception(BufferedWriter bw) throws IOException
	{
		bw.write("OK\n");
		bw.flush();
	}
}
