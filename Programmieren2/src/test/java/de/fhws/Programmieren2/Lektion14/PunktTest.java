package de.fhws.Programmieren2.Lektion14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.fhws.Programmieren2.Lektion14.Punkt;

class PunktTest
{
	Punkt punkt = new Punkt();
	
	@Test
	void testPunktverschiebenGreaterX()
	{
		try
		{
			punkt.verschiebePunkt(1921, 1080);
			fail("RuntimeException expected");
		}
		catch(RuntimeException e)
		{
			String errorMessage = e.getMessage();
			assertEquals("Invalid Arguement", errorMessage);
		}
	}
	
	@Test
	void testPunktverschiebenLesserX()
	{
		try
		{
			punkt.verschiebePunkt(-1920, 1080);
			fail("RuntimeException expected");
		}
		catch(RuntimeException e)
		{
			catchException(e);
		}
	}
	
	@Test
	void testPunktverschiebenGreaterY()
	{
		try
		{
			punkt.verschiebePunkt(1920, 1081);
			fail("RuntimeException expected");
		}
		catch(RuntimeException e)
		{
			catchException(e);
		}
	}
	
	@Test
	void testPunktverschiebenLesserY()
	{
		try
		{
			punkt.verschiebePunkt(1920, -1080);
			fail("RuntimeException expected");
		}
		catch(RuntimeException e)
		{
			catchException(e);
		}
	}

	@Test
	void testPunktverschiebenWithinRange()
	{
		punkt.verschiebePunkt(1920, 1080);
		assertEquals(1920, punkt.x);
		assertEquals(1080, punkt.y);
	}
	
	@Test
	void testPunktverschiebenWithinRange2()
	{
		punkt.verschiebePunkt(600, 400);
		assertEquals(600, punkt.x);
		assertEquals(400, punkt.y);
	}
	
	private void catchException(RuntimeException e)
	{
		String errorMessage = e.getMessage();
		assertEquals("Invalid Arguement", errorMessage);
	}
}
