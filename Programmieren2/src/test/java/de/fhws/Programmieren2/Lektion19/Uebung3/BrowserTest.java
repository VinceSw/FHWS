package de.fhws.Programmieren2.Lektion19.Uebung3;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class BrowserTest
{

	@Test
	void testEmpty()
	{
		Browser browser = new Browser();
		Optional<URL> back;
		String result;
		boolean hasAppeared = false;
		System.out.println("Normal back");
		
		for(int i = 0; i < 50; i++)
		{
			
			back = browser.back();
			if (back.isPresent())
			{
				result = browser.retrieveSite(back.get());
			}
			else
			{
				hasAppeared = true;
			}
			if(hasAppeared) break;
		}
		assertTrue(hasAppeared);
	}
	
	@Test
	void testHasContent()
	{
		Browser browser = new Browser();
		Optional<URL> back;
		String result;
		boolean hasAppeared = false;
		System.out.println("Normal back");
		
		for(int i = 0; i < 50; i++)
		{
			
			back = browser.back();
			if (back.isPresent())
			{
				result = browser.retrieveSite(back.get());
				hasAppeared = result.equals("http://google.de");
				if(hasAppeared) break;
			}
			
		}
		assertTrue(hasAppeared);
	}

}
