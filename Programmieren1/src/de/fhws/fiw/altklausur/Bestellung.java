package de.fhws.fiw.altklausur;

/* Fragen bez�glich dieser Aufgabe an Herrn Prof. Dr. Heinzl:
 * 1. a) Beschreibung der Aufgabe soll in Klassen abgebildet werden. Ich w�rde die Abfrage f�r max. 50 Artikel pro Bestellung in der
 *       einfuegen-Methode unterbringen. Sollte das jedoch in einem Konstruktor passieren?
 * 2. d) Soll hier nur der Methodenkopf aufgeschrieben a la "void loeschen(Artikel delArtikel)" werden?
 */
public class Bestellung
{
	public int bestellnr;
	public Artikel start;
	public static int articleCounter;
	public Bestellung next;
	
	public Bestellung(int bestellnr)
	{
		this.bestellnr = bestellnr;
		start = new Artikel();
	}
	
	
	public void einfuegen(int artikelnummer, String artikelname)
	{
		/* Nachteilig an einem Array ist, dass dieses statisch ist und somit mit der gr��e der maximal enthaltenen Artikel anlegt werden muss 
		 * und danach den gesamten Speicherplatz immer belegt, auch wenn weniger Artikel f�r eine Bestellung angelegt werden. Vorteilig an 
		 * einem Array w�re, dass die Verwaltung des Array-Objektes wesentlich simpler ist als bei einer Liste. Au�erdem wird f�r ein Array 
		 * keine selbsterstellte Klasse ben�tigt. 
		 * 
		 * Vorteilig an einer Liste ist, dass diese dynamisch sind und somit nur soviele Objekte angelegt werden m�ssen, wie sie auch gebraucht 
		 * werden. Ein gravierender Nachteil von Listen gegen�ber Arrays besteht darin, dass der Programmierer bei Listen nicht mehr direkt auf
		 * die bestehenden "Eintr�ge/Objekte/Knoten" zugreifen kann, sondern sich vom Startknoten bis zum gew�nschten knoten durcharbeiten muss.
		 */
		
		if(articleCounter < 49)
		{
			Artikel newArt = new Artikel(artikelnummer, artikelname);
			Artikel temp = start;
			
			if(start == null)
			{
				start = newArt;
			}
			else
			{
				while(temp != null)
				{
					if(temp.getNext() == null)
					{
						temp.setNext(newArt);
						break;
					}
					else
					{
						temp = temp.getNext();
					}
						
				}
			}	
			
			articleCounter++;
		}
		else
		{
			System.out.println("Es k�nnen maximal 50 Artikel einer Bestellung hinzugef�gt werden!");
		}
		
		
		/* d) void loeschen(Artikel delArtikel) */
	}
}
