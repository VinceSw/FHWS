package de.fhws.Programmieren2.Klausurvorbereitungen4;

import java.util.Iterator;

public class RouletteZahlenIterator implements Iterator<Integer>
{
	private int tries = 0;
	private final int maxTries = 3;
	
	@Override
	public boolean hasNext()
	{
		if(tries < maxTries)
			return true;
		
		return false;
	}

	@Override
	public Integer next()
	{
		int ranNum;
		if((ranNum = getRandomNum()) == 0)
		{
			tries++;
		}
		return (Integer)ranNum;
	}
	
	private int getRandomNum()
	{
		return (int)(Math.random() * 37);
	}

}
