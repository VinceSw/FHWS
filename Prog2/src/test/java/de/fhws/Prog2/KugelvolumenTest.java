package de.fhws.Prog2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KugelvolumenTest
{

	@Test
	void testKugelvolumenZero()
	{
		try
		{
			assertEquals(0.0, Kugelvolumen.berechneKugelvolumen(0), 0.01);
			fail("Runtime exception expected.");
		}
		catch(RuntimeException e)
		{
			String message = e.getMessage();
			assertEquals("Invalid Argument", message);
		}
	}
	
	@Test
	void testKugelvolumenOne()
	{
		try
		{
			assertEquals(3.14, Kugelvolumen.berechneKugelvolumen(1), 0.01);
		}
		catch(RuntimeException e)
		{
			String message = e.getMessage();
			assertEquals("Invalid Argument", message);
		}
	}
	
	@Test
	void testKugelvolumenFive()
	{
		try
		{
			assertEquals(392.69, Kugelvolumen.berechneKugelvolumen(5), 0.01);
		}
		catch(RuntimeException e)
		{
			String message = e.getMessage();
			assertEquals("Invalid Argument", message);
		}
	}
	
	@Test
	void testKugelvolumenNegativeOne()
	{
		try
		{
			assertEquals(0.0, Kugelvolumen.berechneKugelvolumen(-1), 0.01);
		}
		catch(RuntimeException e)
		{
			String message = e.getMessage();
			assertEquals("Invalid Argument", message);
		}
	}

}
