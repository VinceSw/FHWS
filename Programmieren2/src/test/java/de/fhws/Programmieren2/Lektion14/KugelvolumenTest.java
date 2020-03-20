package de.fhws.Programmieren2.Lektion14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.fhws.Programmieren2.Lektion14.Kugelvolumen;

class KugelvolumenTest
{

	@Test
	void testKugelvolumenZero()
	{
		try
		{
			Kugelvolumen.berechneKugelvolumen(0);
			fail("RuntimeException expected.");
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
		assertEquals(3.14, Kugelvolumen.berechneKugelvolumen(1), 0.01);
	}
	
	@Test
	void testKugelvolumenFive()
	{
		assertEquals(392.69, Kugelvolumen.berechneKugelvolumen(5), 0.01);
	}
	
	@Test
	void testKugelvolumenNegativeOne()
	{
		try
		{
			Kugelvolumen.berechneKugelvolumen(-1);
			fail("RuntimeException expected");
		}
		catch(RuntimeException e)
		{
			String message = e.getMessage();
			assertEquals("Invalid Argument", message);
		}
	}

}
