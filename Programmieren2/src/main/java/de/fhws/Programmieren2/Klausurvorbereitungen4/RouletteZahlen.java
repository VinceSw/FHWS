package de.fhws.Programmieren2.Klausurvorbereitungen4;

import java.util.Iterator;

public class RouletteZahlen implements Iterable<Integer>
{

	@Override
	public Iterator<Integer> iterator()
	{
		return new RouletteZahlenIterator();
	}
	
}
