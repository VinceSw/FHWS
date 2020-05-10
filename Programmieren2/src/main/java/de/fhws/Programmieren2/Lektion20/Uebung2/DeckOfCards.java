package de.fhws.Programmieren2.Lektion20.Uebung2;

import java.util.ArrayList;
import java.util.Set;
import java.util.Random;

public class DeckOfCards
{
	ArrayList<Card> deckOfCards;
	
	public DeckOfCards(Set<Cardtype> allowedTypes, Set<Cardsymbol> allowedSymbols)
	{
		deckOfCards = new ArrayList<>();
		Card card; 
		
		for(Cardsymbol eS : allowedSymbols)
		{
			for(Cardtype eT : allowedTypes)
			{
				card = new Card(eT, eS);
				deckOfCards.add(card);
			}
		}
	}
	
	public void shuffleDeck()
	{
		Random random = new Random();
		Card swapCard1, swapCard2;
		int swapCard1Inx, swapCard2Inx;
		
		for(int i = 0; i < 10000; i++)
		{
			swapCard1Inx = random.nextInt(32);
			swapCard2Inx = random.nextInt(32);
			
			swapCard1 = deckOfCards.get(swapCard1Inx);
			swapCard2 = deckOfCards.get(swapCard2Inx);
			
			deckOfCards.set(swapCard1Inx, swapCard2);
			deckOfCards.set(swapCard2Inx, swapCard1);
		}
	}
	
	public Card getCardOntop()
	{
		int indexOfLastCard = this.deckOfCards.size()-1;
		return this.deckOfCards.get(indexOfLastCard);
	}
	
	public void removeCardOntop()
	{
		int indexOfLastCard = this.deckOfCards.size()-1;
		this.deckOfCards.remove(indexOfLastCard);
	}
	
	public int getSize()
	{
		return this.deckOfCards.size();
	}
}
