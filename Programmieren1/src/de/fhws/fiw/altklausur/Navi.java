package de.fhws.fiw.altklausur;

public class Navi
{

	public static void main(String[] args)
	{
		Fahrstrecke navi = new Fahrstrecke();
		
		navi.einfuegen("W�rzburg", 0);
		navi.einfuegen("Kitzingen", 19);
		navi.einfuegen("Neustadt", 42);
		navi.einfuegen("N�rnberg", 49);

		System.out.print(navi.toString());
		System.out.println("--------------------------------------------------------------");
		System.out.println("Strecke(gesamt): " + navi.gesamtStrecke() + " km");
	}

}
