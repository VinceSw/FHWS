package de.fhws.Programmieren2.Lektion16.Uebung4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AutofahrenTest
{

	@Test
	void testRoboterReaction()
	{
		Roboter r = new Roboter();
		
		Gefahrensituation gefahr = Gefahrensituation.GEFAHR_LINKS;
		assertEquals(Reaktion.RECHTS, r.autofahren(gefahr));
		
		gefahr = Gefahrensituation.GEFAHR_RECHTS;
		assertEquals(Reaktion.LINKS, r.autofahren(gefahr));
		
		gefahr = Gefahrensituation.GEFAHR_VORNE;
		assertEquals(Reaktion.BREMSEN, r.autofahren(gefahr));
		
		gefahr = null;
		assertEquals(null, r.autofahren(gefahr));
	}
	
	@Test
	void testHumanReaction()
	{
		Mensch m = new Mensch();
		ArrayList<Reaktion> reactionList = new ArrayList<Reaktion>();
		
		reactionList.add(Reaktion.UNENTSCHIEDEN);
		reactionList.add(Reaktion.RECHTS);
		Gefahrensituation gefahr = Gefahrensituation.GEFAHR_LINKS;
		assertTrue(reactionList.contains(m.autofahren(gefahr)));
		
		reactionList.set(1, Reaktion.LINKS);
		gefahr = Gefahrensituation.GEFAHR_RECHTS;
		assertTrue(reactionList.contains(m.autofahren(gefahr)));
		
		reactionList.set(1, Reaktion.BREMSEN);
		gefahr = Gefahrensituation.GEFAHR_VORNE;
		assertTrue(reactionList.contains(m.autofahren(gefahr)));
		
		gefahr = null;
		assertEquals(null, m.autofahren(gefahr));
	}
	
	@Test
	void testCyborgReaction()
	{
		Cyborg c = new Cyborg();
		ArrayList<Reaktion> reactionList = new ArrayList<Reaktion>();
		
		reactionList.add(Reaktion.UNENTSCHIEDEN);
		reactionList.add(Reaktion.RECHTS);
		Gefahrensituation gefahr = Gefahrensituation.GEFAHR_LINKS;
		assertTrue(reactionList.contains(c.autofahren(gefahr)));
		
		reactionList.set(1, Reaktion.LINKS);
		gefahr = Gefahrensituation.GEFAHR_RECHTS;
		assertTrue(reactionList.contains(c.autofahren(gefahr)));
		
		reactionList.set(1, Reaktion.BREMSEN);
		gefahr = Gefahrensituation.GEFAHR_VORNE;
		assertTrue(reactionList.contains(c.autofahren(gefahr)));
		
		gefahr = null;
		assertEquals(null, c.autofahren(gefahr));
	}


}
