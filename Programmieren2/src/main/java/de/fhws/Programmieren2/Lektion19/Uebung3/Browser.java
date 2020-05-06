package de.fhws.Programmieren2.Lektion19.Uebung3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class Browser
{
	public Optional<URL> back()
	{
		try
		{
			URL plainUrl = new URL("http://google.de");
			Optional<URL> url = Optional.of(plainUrl);
			// simulate: fetch last URL from Stack
			return Math.random() < 0.5 ? url : Optional.empty();
		}
		catch (MalformedURLException e)
		{
			return null;
		}
	}

	public String retrieveSite(URL url)
	{
		// simulate download site:
		return url.toString();
	}

	public static void main(String[] args)
	{
		System.out.println("Normal back");
		Browser browser = new Browser();
		Optional<URL> back = browser.back();
		if (back.isPresent())
			browser.retrieveSite(back.get());
	}
}