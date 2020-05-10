package de.fhws.Programmieren2.Lektion20.Uebung3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Vokabeltrainer
{
	Map<String, Collection<String>> english2German = new HashMap<>();
	String wordToGuess;
	
	public void creatRandomWordToGuess()
	{
		Set<String> keySet = english2German.keySet();
		int randomIndex = (int)(Math.random() * keySet.size());
		Iterator<String> iterator = keySet.iterator();
		int i = 0;
		while(iterator.hasNext())
		{
			String word = iterator.next();
			if(i == randomIndex)
			{
				wordToGuess = word;
				return;
			}
			i++;
		}
	}
	
	public String getStringToGuess()
	{
		return this.wordToGuess;
	}
	
	public void addToDictionary(String key, String... values)
	{
		ArrayList<String> value = new ArrayList<>();
		for(String v : values)
		{
			value.add(v);
		}
		
		english2German.put(key, value);
	}
	
	public boolean guess(String guess)
	{
		ArrayList<String> solution = (ArrayList<String>) english2German.get(wordToGuess);
		if(solution.contains(guess))
		{
			return true;
		}
		return false;
	}
	
}
