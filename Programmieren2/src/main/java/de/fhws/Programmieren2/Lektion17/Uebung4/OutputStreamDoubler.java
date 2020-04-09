package de.fhws.Programmieren2.Lektion17.Uebung4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDoubler extends OutputStream
{
	private OutputStream os1, os2;
	
	public static void main(String[] args)
	{
		try(FileOutputStream ostr1 = new FileOutputStream("D:\\FHWS\\Semester2\\SU_Programmieren2\\Lektion17\\Uebung4\\Result_Stream1.txt");
			FileOutputStream ostr2 = new FileOutputStream("D:\\FHWS\\Semester2\\SU_Programmieren2\\Lektion17\\Uebung4\\Result_Stream2.txt");
			OutputStreamDoubler osd = new OutputStreamDoubler(ostr1, ostr2);)
		{
			String str = "Hello World!";
			char[] chr = str.toCharArray();
			
			for(char c : chr)
			{
				osd.write(c);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public OutputStreamDoubler(OutputStream os1, OutputStream os2)
	{
		this.os1 = os1;
		this.os2 = os2;
	}
	
	public void close() throws IOException
	{
		this.os1.close();
		this.os2.close();
	}
	
	public void write(int b) throws IOException
	{
		boolean exceptionThrown = false;
		
		try
		{
			os1.write(b);
		}
		catch(IOException e)
		{
			exceptionThrown = true;
		}
		
		try
		{
			os2.write(b);
		}
		catch(IOException e)
		{
			exceptionThrown = true;
		}
		
		if(exceptionThrown)
		{
			throw new IOException();
		}
	}
}
