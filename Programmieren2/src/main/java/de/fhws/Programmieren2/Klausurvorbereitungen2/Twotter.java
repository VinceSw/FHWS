package de.fhws.Programmieren2.Klausurvorbereitungen2;

import java.awt.DisplayMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

public class Twotter
{
	public static void main(String[] args)
	{
		TwotterSystem sys = new TwotterSystem();
		User u = new User("Vincent", "twt1992");
		User u2 = new User("Nadine", "twt1989");
		
		sys.addMessage(u, new Message("Hello World"));
		sys.addMessage(u, new Message("I don't think this will work!"));
		sys.addMessage(u, new Message("But hey, that's how we learn."));
		
		sys.addMessage(u2, new Message("Hello World"));
		sys.addMessage(u2, new Message("She is a wonderful person."));
		sys.addMessage(u2, new Message("And I'm going to marry here eventually!"));
		
		sys.addMessage(u, new Message("\r\n" + 
				"“It doesn't matter if you and everyone else in the room are thinking it. "
				+ "You don't say the words. Words are weapons. They blast big bloody holes "
				+ "in the world. And words are bricks. Say something out loud and it starts "
				+ "turning solid. Say it loud enough and it becomes a wall you can't get through.” "));
		
		List<Message> a = sys.getAllMessages();
		List<Message> m = sys.getAllMessagesFromDate(getCurrentDateAsString());
		List<Message> d = sys.getAllMessagesFromUser(u2);
		
		displayListOfMessages(a);
		displayListOfMessages(m);
		displayListOfMessages(d);
	}
	
	public static String getCurrentDateAsString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		
		return today;
	}
	
	public static void displayListOfMessages(List<Message> msgList)
	{
		System.out.println("\n-----------------------------------------------\n");
		for(Message m : msgList)
		{
			System.out.println(m.getMessage());
		}
		System.out.println("\n-----------------------------------------------\n");
	}
}
