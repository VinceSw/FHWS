package de.fhws.Programmieren2.Lektion16.Uebung2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ModifiedChangeCalculatorTest
{

	@Test
	void test()
	{
		ModifiedChangeCalculator test = new ModifiedChangeCalculator();
		int[] expectedArray = {0, 0, 0, 1, 0, 0, 0, 2};
		assertArrayEquals(expectedArray, test.getChange(4, 10));
	}

}
