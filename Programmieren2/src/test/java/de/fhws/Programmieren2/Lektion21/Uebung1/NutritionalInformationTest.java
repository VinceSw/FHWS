package de.fhws.Programmieren2.Lektion21.Uebung1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NutritionalInformationTest
{
	NutritionalInformation nutInf;
	int portionSize, amountPortions;
	float amountProtein, amountFat, amountCarbs, amountSodium;

	@BeforeEach
	public void inital()
	{
		portionSize = 1;
		amountPortions = 2;
		amountProtein = 13.6f;
		amountFat = 0.2f;
		amountCarbs = 7.2f;
		amountSodium = 0.1f;
		
		nutInf = new NutritionalInformation.NutritionalInformationBuilder(portionSize, amountPortions)
																						.withAmountProtein(amountProtein)
																						.withAmountFat(amountFat)
																						.withAmountCarbs(amountCarbs)
																						.build();
	}
	
	@Test
	void testPortionSize()
	{
		assertEquals(portionSize, nutInf.getPortionSize());
	}
	
	@Test
	void testAmountPortion()
	{
		assertEquals(amountPortions, nutInf.getAmountPortions());
	}
	
	@Test
	void testAmountProtein()
	{
		assertEquals(amountProtein, nutInf.getAmountProtein());
	}
	
	@Test
	void testAmountFat()
	{
		assertEquals(amountCarbs, nutInf.getAmountCarbs());
	}
	
	@Test
	void testAmountCarbs()
	{
		assertEquals(amountFat, nutInf.getAmountFat());
	}
	
	@Test
	void testAmountSodium()
	{
		assertEquals(0.0f, nutInf.getAmountSodium());
	}

}
