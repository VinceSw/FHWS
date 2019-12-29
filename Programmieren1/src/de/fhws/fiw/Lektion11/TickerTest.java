package de.fhws.fiw.Lektion11;

public class TickerTest
{

	public static void main(String[] args)
	{
		Ticker tick = new Ticker();
		Ticker tick2 = new Ticker(44);
		Ticker tick3 = new Ticker(15);
		
		char[] nachricht = "Wettervorhersage: Schnee in Wuerzburg".toCharArray();
		
		tick.setNachricht(nachricht);
		tick2.setNachricht(nachricht);
		tick3.setNachricht(nachricht);
		System.out.println("Nachricht 1: \t" + tick.getNachricht());
		System.out.println("Nachricht 2: \t" + tick2.getNachricht());
		System.out.println("Nachricht 3: \t" + tick3.getNachricht());
		
		System.out.println("---------------------------------------------------------------");
		tick.rotateNachricht(6);
		tick2.rotateNachricht(6);
		tick3.rotateNachricht(6);
		System.out.println("Nachricht 1(rotate 6): \t" + tick.getNachricht());
		System.out.println("Nachricht 2(rotate 6): \t" + tick2.getNachricht());
		System.out.println("Nachricht 3(rotate 6): \t" + tick3.getNachricht());
		
		System.out.println("---------------------------------------------------------------");
		System.out.println(tick.getGroesse());
		System.out.println(tick2.getGroesse());
		System.out.println(tick3.getGroesse());

	}

}
