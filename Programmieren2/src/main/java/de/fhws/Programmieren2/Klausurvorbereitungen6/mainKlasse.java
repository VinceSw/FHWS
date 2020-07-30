package de.fhws.Programmieren2.Klausurvorbereitungen6;

public class mainKlasse
{
	public static void main(String[] args)
	{
		MusikStueck ms1 = new MusikStueck("Für Elise", "Ludwig van Beethoven", 223);
		MusikStueck ms2 = new MusikStueck("King of the Roads", "Randy Travis", 325);
		MusikStueck ms3 = new MusikStueck("1% the Voice within", "Diztord",  366);
		
		MusikStueckSammlung sammlung = new MusikStueckSammlung();
		sammlung.musikStueckEinfügen(ms1);
		sammlung.musikStueckEinfügen(ms2);
		sammlung.musikStueckEinfügen(ms3);
		
		for(MusikStueck m : sammlung.getAlleMusikStueckeNachTitel())
		{
			System.out.println(m.toString() + "\n");
		}
		
	}
}
