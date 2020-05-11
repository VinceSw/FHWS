package de.fhws.Programmieren2.Webseitenabruf;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Webseitenaufruf
{
	public void getWebsiteWikipedia()
	{
		Response response = ClientBuilder.newClient()
				.target("https://en.wikipedia.org/")
				.path("wiki/Fluent_interface")
				.request(MediaType.TEXT_HTML)
				.get();
		String s = response.readEntity(String.class);
		System.out.println(s);
	}

	public void getWebsiteTypicode()
	{
		Response response = ClientBuilder.newClient()
				.target("https://jsonplaceholder.typicode.com/")
				.path("posts/1")
				.request(MediaType.APPLICATION_JSON)
				.get();
		String s = response.readEntity(String.class);
		System.out.println(s);
	}
}
