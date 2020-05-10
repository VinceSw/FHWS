package de.fhws.Programmieren2.Lektion20.Uebung1;

import java.util.ArrayList;

public class Player
{
	private HandOfCards handOfCards;
	
	public Player()
	{
		handOfCards = new HandOfCards();
	}
	
	public void showHandOfCards() 
	{
		ArrayList<Card> cardsOnHand = handOfCards.getHandOfCards();
		
		for(Card hOC : cardsOnHand)
		{
			System.out.println(hOC.getSymbol() + " " + hOC.getType());
		}
	}
	
	public void draw(DeckOfCards deckOfCards)
	{
		int amountCardsOnHand = handOfCards.getAmountCardsOnHand().isPresent() ? this.handOfCards.getAmountCardsOnHand().getAsInt() : 0;
		int maxAmountPerHand = handOfCards.getMaxAmountCards();
		Card drawnCard;
		
		for(int i = amountCardsOnHand; i < maxAmountPerHand; i++)
		{
			drawnCard = deckOfCards.getCardOntop();
			handOfCards.addToHand(drawnCard);
			deckOfCards.removeCardOntop();	
		}
	}
	
	public void layCard(Card card, Stack stack)
	{
		stack.addToStack(card);
		handOfCards.removeFromHand(card);
	}
}
