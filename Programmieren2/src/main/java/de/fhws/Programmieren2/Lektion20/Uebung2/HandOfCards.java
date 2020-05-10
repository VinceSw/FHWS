package de.fhws.Programmieren2.Lektion20.Uebung2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.OptionalInt;

public class HandOfCards
{
	private ArrayList<Card> handOfCards;
	private final int maxAmountCards = 10;
	
	public HandOfCards()
	{
		handOfCards = new ArrayList<>();
	}
	
	public ArrayList<Card> getHandOfCards()
	{
		return handOfCards;
	}
	
	public OptionalInt getAmountCardsOnHand()
	{
		OptionalInt size = OptionalInt.of(this.handOfCards.size());
		return size.isPresent() ? size : OptionalInt.empty();
	}
	
	public int getMaxAmountCards()
	{
		return maxAmountCards;
	}
	
	public void removeFromHand(Card cardToRemove)
	{
		int cardIndx = this.handOfCards.indexOf(cardToRemove);
		this.handOfCards.remove(cardIndx);
	}
	
	public void addToHand(Card cardToAdd)
	{
		this.handOfCards.add(cardToAdd);
		Collections.sort(handOfCards);
	}
}
