package de.fhws.fiw.altklausur;

public class Timeline
{
	Post start;
	
	public void fuegePostEin(Post post)
	{
		if(start == null)
		{
			start = post;
		}
		else
		{
			post.next = start;
			start = post;
		}
	}
	
	public void gibAus()
	{
		Post temp = start;
		
		while(temp != null)
		{
			System.out.println(temp.absender + " -> " + temp.empfaenger);
			System.out.println(temp.text + "\n");
			
			temp = temp.next;
		}
	}
}
