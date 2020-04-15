package de.fhws.Programmieren2.Lektion18.Uebung1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Studiengangssplitter
{
	public static void main(String[] args)
	{
		String dateiName = "D:\\FHWS\\Semester2\\SU_Programmieren2\\Lektion18\\Übungen\\Uebung1\\MatNr.txt";
		
		try
		{
			Studiengangssplitter stspl = new Studiengangssplitter();
			stspl.splitStudiengaenge(dateiName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void splitStudiengaenge(String dateiName) throws MatrikelNummerException, IOException
	{
		try(BufferedReader br = new BufferedReader(new FileReader(dateiName));)
		{
			String line = "";
			String matNr = "";

			while(line != null)
			{
				line = br.readLine();
				if(line != null && !line.equals(""))
				{
					matNr = line;
					writeStudiengang(matNr);
				}
			}
		}
		catch(IOException e)
		{
			throw new IOException(e.getMessage());
		}
	}

	private void writeStudiengang(String matNr) throws MatrikelNummerException, IOException
	{
		String filePath;
		int matNrInt = Integer.valueOf(matNr);
		
		if(matNrInt >= 5000000 && matNrInt <= 5099999)
		{
			filePath = "D:\\FHWS\\Semester2\\SU_Programmieren2\\Lektion18\\Übungen\\Uebung1\\WInfNr.txt";
		}
		else if(matNrInt >= 5100000 && matNrInt <= 5199999)
		{
			filePath = "D:\\FHWS\\Semester2\\SU_Programmieren2\\Lektion18\\Übungen\\Uebung1\\InfNr.txt";
		}
		else if(matNrInt >= 6100000 && matNrInt <= 6199999)
		{
			filePath = "D:\\FHWS\\Semester2\\SU_Programmieren2\\Lektion18\\Übungen\\Uebung1\\ECNr.txt";
		}
		else
		{
			throw new MatrikelNummerException("Registration number out of Range");
		}
		
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true), StandardCharsets.UTF_8));)
		{
			bw.write(matNr.toCharArray(), 0, String.valueOf(matNr).length());
			bw.newLine();
		}
		catch(IOException e)
		{
			throw e;
		}
		
		
	}
}
