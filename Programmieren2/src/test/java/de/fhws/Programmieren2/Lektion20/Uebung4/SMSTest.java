package de.fhws.Programmieren2.Lektion20.Uebung4;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SMSTest
{
	private static String fromFile = "D:\\FHWS\\Semester2\\SU_Programmieren2\\Lektion20\\Übungen\\Übung4\\Zeichenkontakte.txt";
	private static String toFile = "D:\\FHWS\\Semester2\\SU_Programmieren2\\Lektion20\\Übungen\\Übung4\\Nummernkontakte.txt";
	
	@Test
	void test()
	{
		try(InputStream is = new FileInputStream(toFile);
				BufferedReader br = new BufferedReader(new InputStreamReader(is));)
		{
			String s = br.readLine();
			assertEquals("325858238349", s);
			s = br.readLine();
			assertEquals("8462368", s);
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@BeforeAll
	public static void initializeTest()
	{
		SMS sms = new SMS(fromFile, toFile);
		
		sms.convertContacts();
	}

}
