package de.fhws.fiw.altklausur;

import java.sql.Time;

public class TesteTimeline
{

	public static void main(String[] args)
	{
		Timeline test = new Timeline();
		
		Post p3 = new Post("Gutes neues Jahr!", "Alice", "Bob");
		Post p2 = new Post("Danke! Guten Rutsch ins neue Jahr!", "Bob", "Alice");
		Post p1 = new Post("Frohe Weihnachten!", "Alice", "Bob");
		
		test.fuegePostEin(p1);
		test.fuegePostEin(p2);
		test.fuegePostEin(p3);
		
		test.gibAus();
		

	}

}
