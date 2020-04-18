package de.fhws.Programmieren2.Lektion18.Uebung3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToUpperCaseWriterTest
{
	ToUpperCaseWriter writer;
	ByteArrayOutputStream baos;
	
	@BeforeEach
	public void prepareTests()
	{
		baos = new ByteArrayOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(baos);
		writer = new ToUpperCaseWriter(osw);
	}
	
	@Test
	public void writeTest()
	{
			assertEquals("A", processTest("a"));
	}
	
	@Test
	public void writeTestWithNonChar()
	{
			assertEquals("1", processTest("1"));
	}
	
	@Test
	public void writeTestToUpperWithASCII()
	{
		String s = "";
		String expectedChar;
		
		for(int i = 97; i <= 122; i++)
		{
			s = String.valueOf((char)i);
			expectedChar = String.valueOf((char)(i-32));
			assertEquals(expectedChar, processTest(s));
		}
	}
	
	@Test
	public void writeTestNothingHappensWithASCII()
	{
		String s = "";
		
		for(int i = 0; i <= 128; i++)
		{
			s = String.valueOf((char)i);
			if(i < 97 && i > 122)
			{
				assertEquals(s, processTest(s));
			}
		}
	}
	
	public String processTest(String s)
	{
		String uppercase = ""; 
		
		try
		{
			writer.write(s);
			writer.flush();
			uppercase = baos.toString();
			baos.reset();
		}
		catch (IOException e)
		{
			fail("IOException" + e.getMessage());
		}
		
		return uppercase;
	}
	
	
	@AfterEach
	public void cleanUp()
	{
		try
		{
			writer.close();
		}
		catch(IOException e)
		{
			fail("IOException " + e.getMessage());
		}
	}
}
