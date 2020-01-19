package de.fhws.fiw.altklausur;

public class Kunde
{
	public int kundennummer;
	public String nachname;
	public Bestellung start;
	public static int orderCounter;
	
	public Kunde(int kundennummer, String nachname)
	{
		this.kundennummer = kundennummer;
		this.nachname = nachname;
		this.start = null;
	}
	
	public void einfuegen(int bestellnr)
	{
		if(orderCounter < 49)
		{
			Bestellung newOrder = new Bestellung(bestellnr);
			Bestellung temp = start;
			
			if(start == null)
			{
				start = newOrder;
			}
			else
			{
				while(temp != null)
				{
					if(temp.next == null)
					{
						temp.next = newOrder;
						break;
					}
					else
					{
						temp = temp.next;
					}
						
				}
			}	
			
			orderCounter++;
		}
		else
		{
			System.out.println("Es können maximal 50 Bestellungen pro Kunde hinzugefügt werden!");
		}
	}
}
