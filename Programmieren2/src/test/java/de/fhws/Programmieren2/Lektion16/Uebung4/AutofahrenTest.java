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
		
		testReaction(r);
	}
	
	@Test
	void testHumanReaction()
	{
		Mensch m = new Mensch();
		
			testReaction(m);

	}
	
	@Test
	void testCyborgReaction()
	{
		Cyborg c = new Cyborg();
		
		testReaction(c);
		
	}
	
	public void testReaction(IHumanoide humanoid)
	{
		Gefahrensituation gefahr;
		
		if(humanoid instanceof Roboter)
		{
			gefahr = Gefahrensituation.GEFAHR_LINKS;
			assertEquals(Reaktion.RECHTS, humanoid.autofahren(gefahr));
			
			gefahr = Gefahrensituation.GEFAHR_RECHTS;
			assertEquals(Reaktion.LINKS, humanoid.autofahren(gefahr));
			
			gefahr = Gefahrensituation.GEFAHR_VORNE;
			assertEquals(Reaktion.BREMSEN, humanoid.autofahren(gefahr));
			
			gefahr = null;
			assertEquals(null, humanoid.autofahren(gefahr));
		}
		else
		{
			ArrayList<Reaktion> reactionList = new ArrayList<Reaktion>();
			
			reactionList.add(Reaktion.UNENTSCHIEDEN);
			reactionList.add(Reaktion.RECHTS);
			gefahr = Gefahrensituation.GEFAHR_LINKS;
			assertTrue(reactionList.contains(humanoid.autofahren(gefahr)));
			
			reactionList.set(1, Reaktion.LINKS);
			gefahr = Gefahrensituation.GEFAHR_RECHTS;
			assertTrue(reactionList.contains(humanoid.autofahren(gefahr)));
			
			reactionList.set(1, Reaktion.BREMSEN);
			gefahr = Gefahrensituation.GEFAHR_VORNE;
			assertTrue(reactionList.contains(humanoid.autofahren(gefahr)));
			
			gefahr = null;
			assertEquals(null, humanoid.autofahren(gefahr));
		}
	}


}
