package de.fhws.fiw.altklausur;

/* Fragen bezüglich dieser Aufgabe an Herrn Prof. Dr. Heinzl:
 * 1. a) Beschreibung der Aufgabe soll in Klassen abgebildet werden. Ich würde die Abfrage für max. 50 Artikel pro Bestellung in der
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
		/* Nachteilig an einem Array ist, dass dieses statisch ist und somit mit der größe der maximal enthaltenen Artikel anlegt werden muss 
		 * und danach den gesamten Speicherplatz immer belegt, auch wenn weniger Artikel für eine Bestellung angelegt werden. Vorteilig an 
		 * einem Array wäre, dass die Verwaltung des Array-Objektes wesentlich simpler ist als bei einer Liste. Außerdem wird für ein Array 
		 * keine selbsterstellte Klasse benötigt. 
		 * 
		 * Vorteilig an einer Liste ist, dass diese dynamisch sind und somit nur soviele Objekte angelegt werden müssen, wie sie auch gebraucht 
		 * werden. Ein gravierender Nachteil von Listen gegenüber Arrays besteht darin, dass der Programmierer bei Listen nicht mehr direkt auf
		 * die bestehenden "Einträge/Objekte/Knoten" zugreifen kann, sondern sich vom Startknoten bis zum gewünschten knoten durcharbeiten muss.
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
			System.out.println("Es können maximal 50 Artikel einer Bestellung hinzugefügt werden!");
		}
		
		
		/* d) void loeschen(Artikel delArtikel) */
	}
}
