package de.fhws.Prog2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KugelvolumenTest
{

	@Test
	void testKugelvolumenZero()
	{
		assertEquals(0.0, Kugelvolumen.berechneKugelvolumen(0), 0.01);
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
		assertEquals(-3.14, Kugelvolumen.berechneKugelvolumen(-1), 0.01);
	}

}
