package de.fhws.Programmieren2.Lektion17.Uebung1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class ExceptionsTest
{
	Exceptions ex = new Exceptions();
	
	@Test
	void testNumberFormatException()
	{
		try
		{
			ex.throwNumberFormatException();
			fail("NumberFormatException expected");
		}
		catch(NumberFormatException e)
		{
			//e.printStackTrace();
		}
	}
	
	@Test 
	void testArrayIndexOutOfBoundsException()
	{
		try
		{
			ex.throwArrayIndexOutOfBoundsException();
			fail("ArrayIndexOutOfBoundsException expected");
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			//e.printStackTrace();
		}
	}
	
	@Test
	void testNullPointerException()
	{
		try
		{
			ex.throwNullPointerException();
			fail("NullPointerException expected");
		}
		catch(NullPointerException e)
		{
			//e.printStackTrace();
		}
	}
	
	@Test
	void testOutOfMemoryError()
	{
		try
		{
			ex.throwOutOfMemoryError();
			fail("OutOfMemoryError expected");
		}
		catch(OutOfMemoryError e)
		{
			//e.printStackTrace();
		}
	}
	
	@Test
	void testFileNotFoundException()
	{
		try
		{
			ex.throwFileNotFoundException();
			fail("FileNotFoundException expected");
		}
		catch(FileNotFoundException e)
		{
			//e.printStackTrace();
		}
	}
	
	@Test
	void testArithmeticException()
	{
		try
		{
			ex.throwArithmeticException();
			fail("ArithmeticException expected");
		}
		catch(ArithmeticException e)
		{
			//e.printStackTrace();
		}
	}

}
