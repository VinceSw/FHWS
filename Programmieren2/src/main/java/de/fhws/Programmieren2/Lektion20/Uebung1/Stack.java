package de.fhws.Programmieren2.Lektion20.Uebung1;

import java.util.HashSet;

public class Stack
{
	private HashSet<Card> storageStack;
	
	public Stack()
	{
		storageStack = new HashSet<>();
	}

	public HashSet<Card> getStack()
	{
		return this.storageStack;
	}

	
	public void removeFromStack(Card cardToRemove)
	{
		storageStack.remove(cardToRemove);
	}
	
	public void addToStack(Card cardToAdd)
	{
		storageStack.add(cardToAdd);
	}
}
