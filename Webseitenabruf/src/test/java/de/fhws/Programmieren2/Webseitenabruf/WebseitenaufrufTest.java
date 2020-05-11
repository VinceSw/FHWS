package de.fhws.Programmieren2.Webseitenabruf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WebseitenaufrufTest
{

	@Test
	void test()
	{
		Webseitenaufruf wa = new Webseitenaufruf();
		//wa.getWebsiteWikipedia();
		wa.getWebsiteTypicode();
	}

}
