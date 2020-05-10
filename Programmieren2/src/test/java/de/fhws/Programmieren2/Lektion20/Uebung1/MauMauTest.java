package de.fhws.Programmieren2.Lektion20.Uebung1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MauMauTest
{

	@Test
	void testRandomHandOfCards()
	{
		MauMau game = new MauMau();
		Player p1 = new Player();
		Player p2 = new Player();
		
		game.draw(p1);
		game.draw(p2);
		
		System.out.println("Player 1: ");
		p1.showHandOfCards();
		
		System.out.println("\nPlayer 2: ");
		p2.showHandOfCards();
		
	}
	
	@Test
	void testSizeOfDeck()
	{
		MauMau game = new MauMau();
		assertEquals(32, game.getDeckOfCards().getSize());
	}

}
