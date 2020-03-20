package de.fhws.Prog2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest
{
	Person person;
	
	@Test
	void testPersonAllLowerCase()
	{
		try
		{
			person = new Person("vincent", "swigler", "grundweg", "6", "97265", "hettstadt");
			fail("Runtime Exception expected");
		}
		catch(RuntimeException e)
		{
			catchRuntimeException(e);
		}
	}
	
	@Test
	void testPersonAllUpperCase()
	{
		person = new Person("Nadine", "Gilles", "Weierstraße", "25", "50354", "Hürth");
		
		assertEquals("Nadine", person.vorname);
		assertEquals("Gilles", person.nachname);
		assertEquals("Weierstraße", person.adresse.strasse);
		assertEquals("25", person.adresse.hausnummer);
		assertEquals("50354", person.adresse.postleitzahl);
		assertEquals("Hürth", person.adresse.ort);
	}
	
	@Test
	void testPersonFirstnameLowerCase()
	{
		try
		{
			person = new Person("brianna", "Swigler", "Lerchenweg", "4", "97522", "Sand am Main");
			fail("Runtime Exception expected");
		}
		catch(RuntimeException e)
		{
			catchRuntimeException(e);
		}
	}
	
	@Test
	void testPersonAdressLowerCase()
	{
		try
		{
			person = new Person("Martina", "Swigler", "hermannsberger Straße", "5", "96151", "Breitbrunn");
			fail("Runtime Exception expected");
		}
		catch(RuntimeException e)
		{
			catchRuntimeException(e);
		}
	}
	
	@Test
	void testPersonZipCodeCharacter()
	{
		try
		{
			person = new Person("Matthias", "Koch", "Hermannsberger Straße", "A5", "96151", "Breitbrunn");
			fail("Runtime Exception expected");
		}
		catch(RuntimeException e)
		{
			catchRuntimeException(e);
		}
	}
	
	private void catchRuntimeException(RuntimeException e)
	{
		String errorMessage = e.getMessage();
		assertEquals("Invalid Arguement", errorMessage);
	}

}
