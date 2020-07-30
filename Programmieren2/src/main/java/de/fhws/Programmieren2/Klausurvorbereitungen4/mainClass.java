package de.fhws.Programmieren2.Klausurvorbereitungen4;

public class mainClass
{

	public static void main(String[] args)
	{
		displayIterator();
		
		System.out.println("\n\n");
		
		displayNormal();
		

	}
	
	public static void displayNormal()
	{
		RouletteZahlen rz = new RouletteZahlen();
		
		for(Integer i : rz)
		{
			System.out.println(i);
		}
	}
	
	public static void displayIterator()
	{
		RouletteZahlenIterator rzi = new RouletteZahlenIterator();
		
		while(rzi.hasNext())
		{
			System.out.println(rzi.next());
		}
	}

}
