package de.fhws.Programmieren2.Lektion22.Uebung3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiThreadTCPServer implements Runnable
{
	Socket clientSocket;
	
	public MultiThreadTCPServer(Socket socket)
	{
		this.clientSocket = socket;
	}
	
	public static void main(String[] args)
	{
		final int PORT = 5000;
		
		try(ServerSocket ss = new ServerSocket(PORT))
		{
			while(true)
			{
				System.out.println("Waiting for client request...");
				Socket client = ss.accept();
				System.out.println("Connection has successfully been initialized.");
				
				MultiThreadTCPServer tcpServ = new MultiThreadTCPServer(client);
				Thread tcpThread = new Thread(tcpServ);
				tcpThread.start();
				System.out.println("Seperate thread ("+ tcpThread.getId() + ") has successfully been initialized.\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void run()
	{
		try(InputStream is = clientSocket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				OutputStream os = clientSocket.getOutputStream();
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os)))
		{
				acknowledgeReception(bw);
			
				List<Integer> zahlenZumTesten = receiveListFromClient(br, bw);
				sendResultToClient(getResult(zahlenZumTesten), br, bw);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private Map<Integer, Boolean> getResult(List<Integer> zahlenZumTesten)
	{
		Map<Integer, Boolean> resultList = new HashMap<>();
		
		for(int i : zahlenZumTesten)
		{
			boolean istPrimzahl = testeObPrimzahl(i);
			resultList.put(i, istPrimzahl);
		}
		
		return resultList;
	}
	
	private ArrayList<Integer> receiveListFromClient(BufferedReader br, BufferedWriter bw) throws IOException
	{
		ArrayList<Integer> receivedList = new ArrayList<>();
		String receivedString = "";
		Integer receivedNum;
		
		while(!(receivedString = br.readLine()).equals("done"))
		{
			if(isInteger(receivedString))
			{
				acknowledgeReception(bw);
				
				receivedNum = Integer.valueOf(receivedString);
				receivedList.add(receivedNum);
			}
			else
			{
				if(!receivedString.equals("OK"))
					faultyReception("The received Value was neither an integer nor an acknowledgment", bw);
			}

			receivedString = null;
		}
		return receivedList;
	}
	
	private void sendResultToClient(Map<Integer, Boolean> resultList, BufferedReader br, BufferedWriter bw) throws IOException
	{
		Set<Integer> keyset = resultList.keySet();
		String value, clientMessage = "";

		for(int key : keyset)
		{
			bw.write(key+"\n");
			bw.flush();
			
			if((clientMessage = br.readLine()).equals("OK"))
			{
				if(resultList.get(key) == true)
					value = "true";
				else
					value = "false";
				
				bw.write(value+"\n");
				bw.flush();
			}
		}
		
		bw.write("done\n");
		bw.flush();
		
		while(!clientMessage.equals("finished"))
		{
			clientMessage = br.readLine();
		}
	}
	
	private boolean testeObPrimzahl(int zahlZumTesten) {
		if (zahlZumTesten < 2) return false;
		for (int divisor = 2; divisor < zahlZumTesten; divisor++)
		if (zahlZumTesten % divisor == 0) return false;
		return true;
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
	
	private void acknowledgeReception(BufferedWriter bw) throws IOException
	{
		final String acknowledgement = "OK\n";
		bw.write(acknowledgement);
		bw.flush();
	}
	
	private void faultyReception(String errorMessage, BufferedWriter bw) throws IOException
	{
		bw.write(errorMessage+"\n");
		bw.flush();
	}
}
