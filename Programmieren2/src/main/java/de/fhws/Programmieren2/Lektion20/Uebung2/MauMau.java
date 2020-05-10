package de.fhws.Programmieren2.Lektion20.Uebung2;

import java.util.HashSet;
import java.util.Set;

public class MauMau
{
	private Set<Cardtype> allowedTypes;
	private Set<Cardsymbol>allowedSymbols;
	private DeckOfCards deckOfCards;
	private Stack stack;
	private Set<Player> activePlayers;
	
	public MauMau()
	{
		allowedTypes = new HashSet<>();
		allowedTypes.add(Cardtype.SIEBEN);
		allowedTypes.add(Cardtype.ACHT);
		allowedTypes.add(Cardtype.NEUN);
		allowedTypes.add(Cardtype.ZEHN);
		allowedTypes.add(Cardtype.BUBE);
		allowedTypes.add(Cardtype.DAME);
		allowedTypes.add(Cardtype.KOENIG);
		allowedTypes.add(Cardtype.ASS);
		
		allowedSymbols = new HashSet<>();
		allowedSymbols.add(Cardsymbol.HERZ);
		allowedSymbols.add(Cardsymbol.KARO);
		allowedSymbols.add(Cardsymbol.PIK);
		allowedSymbols.add(Cardsymbol.KREUZ);
		
		deckOfCards  = new DeckOfCards(allowedTypes, allowedSymbols);
		deckOfCards.shuffleDeck();
		stack = new Stack();
	}
	
	public void addPlayerToGame(Player player)
	{
		this.activePlayers.add(player);
	}
	
	public void removePlayerFromGame(Player player)
	{
		this.activePlayers.remove(player);
	}
	
	public void draw(Player player)
	{
		player.draw(deckOfCards);
	}
	
	public DeckOfCards getDeckOfCards()
	{
		return this.deckOfCards;
	}
}
