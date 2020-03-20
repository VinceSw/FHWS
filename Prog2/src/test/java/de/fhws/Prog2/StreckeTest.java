package de.fhws.Prog2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StreckeTest
{
	Strecke strecke, strecke2;
	
	@Test
	void testStreckeNegativeNumber()
	{
		try
		{
			strecke = new Strecke(-1, 2);
			fail("RuntimeException expected");
		}
		catch(RuntimeException e)
		{
			catchRuntimeException(e);
		}
		
		try
		{
			strecke = new Strecke(2, -2);
			fail("RuntimeException expected");
		}
		catch(RuntimeException e)
		{
			catchRuntimeException(e);
		}
	}
	
	@Test
	void testALesserB()
	{
		strecke = new Strecke(8, 2);
		assertTrue(strecke.a < strecke.b);
		
		strecke = new Strecke(3, 5);
		assertTrue(strecke.a < strecke.b);
	}
	
	@Test
	void testStrecke1CrossingStrecke2()
	{
		strecke = new Strecke(8, 2);
		strecke2 = new Strecke(3, 11);
		assertTrue(strecke.isCrossing(strecke2));
		
		strecke = new Strecke(8, 2);
		strecke2 = new Strecke(3, 7);
		assertTrue(strecke.isCrossing(strecke2));
		
		strecke = new Strecke(3, 7);
		strecke2 = new Strecke(8, 2);
		assertTrue(strecke.isCrossing(strecke2));
		
		strecke = new Strecke(8, 2);
		strecke2 = new Strecke(1, 3);
		assertTrue(strecke.isCrossing(strecke2));
	}
	
	@Test
	void testStrecke1TouchingButNotCrossingStrecke2()
	{
		strecke = new Strecke(5, 2);
		strecke2 = new Strecke(5, 11);
		assertFalse(strecke.isCrossing(strecke2));
	}
	
	@Test
	void testToStringOutput()
	{
		strecke = new Strecke(2, 5);
		assertEquals("2--5", strecke.toString());
		
		strecke = new Strecke(8, 3);
		assertEquals("3----8", strecke.toString());
		
		strecke = new Strecke(4, 4);
		assertEquals("4", strecke.toString());
	}

	private void catchRuntimeException(RuntimeException e)
	{
		String errorMessage = e.getMessage();
		assertEquals("Invalid Arguement", errorMessage);	
	}
}
