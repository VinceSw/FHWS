package de.fhws.fiw.Lektion4;

public class Lektion4_Uebung1
{
	public static void main(String[] args) throws InterruptedException
	{
			int counter = 15;
			
			while(counter >= 0)
			{
				System.out.println("Noch " + counter + " Sekunden verbleibend");
				counter--;
				Thread.sleep(1000);
			}
	}
}