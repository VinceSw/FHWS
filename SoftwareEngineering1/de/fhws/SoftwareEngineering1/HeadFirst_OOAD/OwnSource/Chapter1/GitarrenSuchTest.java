package de.fhws.SoftwareEngineering1.HeadFirst_OOAD.OwnSource.Chapter1;

import java.util.Iterator;
import java.util.List;

public class GitarrenSuchTest
{

	public static void main(String[] args)
	{
		Bestand bestand = new Bestand();
		initializeBestand(bestand);
		
		GitarrenDaten wasEllenMag = new GitarrenDaten(Hersteller.FENDER, "Stratocastor", Typ.ELEKTRISCH, Holz.ERLE, Holz.ERLE, 6);
		
		List<Gitarre> passendeGitarren = bestand.suchen(wasEllenMag);
		if(!passendeGitarren.isEmpty())
		{
			System.out.println("Das könnte dir gefallen Ellen:"); 
			for(Iterator i = passendeGitarren.iterator(); i.hasNext();)
			{
				Gitarre gitarre = (Gitarre)i.next();
				GitarrenDaten gitarrenDaten = gitarre.getGitarrenDaten();
				System.out.println( "Wir haben eine " + gitarrenDaten.getTyp() + "e " +gitarrenDaten.getHersteller() + " " +
						gitarrenDaten.getModell() + "-Gitarre:\n Boden und Seiten in " +
						gitarrenDaten.getBodenholz() + ",\n Decke in " +
						gitarrenDaten.getDeckenholz() + ".\nDu kannst sie für nur " +
						gitarre.getPreis() + " € haben!\n" + 
						"----");
			}
		} 
		else 
		{
					System.out.println("Leider haben wir nichts Passendes.");
		}
	}
	
	private static void initializeBestand(Bestand bestand)
	{
		bestand.addGitarre("11277", 3999.95, Hersteller.COLLINGS, 
            "CJ", Typ.AKUSTISCH, 
            Holz.INDISCHER_PALISANDER, Holz.SITKA, 6);
		bestand.addGitarre("V95693", 1499.95, Hersteller.FENDER, 
            "Stratocastor", Typ.ELEKTRISCH,
            Holz.ERLE, Holz.ERLE, 6);
		bestand.addGitarre("V9512", 1549.95, Hersteller.FENDER, 
            "Stratocastor", Typ.ELEKTRISCH,
            Holz.ERLE, Holz.ERLE, 6);
		bestand.addGitarre("122784", 5495.95, Hersteller.MARTIN, 
            "D-18", Typ.AKUSTISCH,
            Holz.MAHAGONI, Holz.ADIRONDACK, 6);
		bestand.addGitarre("76531", 6295.95, Hersteller.MARTIN, 
            "OM-28", Typ.AKUSTISCH,
            Holz.RIO_PALISANDER, Holz.ADIRONDACK, 6);
		bestand.addGitarre("70108276", 2295.95, Hersteller.GIBSON, 
            "Les Paul", Typ.ELEKTRISCH,
            Holz.MAHAGONI, Holz.MAHAGONI, 6);
		bestand.addGitarre("82765501", 1890.95, Hersteller.COLLINGS, 
            "SG '61 Reissue", Typ.ELEKTRISCH,
            Holz.MAHAGONI, Holz.MAHAGONI, 6);
		bestand.addGitarre("77023", 6275.95, Hersteller.MARTIN, 
            "D-28", Typ.AKUSTISCH,
            Holz.RIO_PALISANDER, Holz.ADIRONDACK, 6);
		bestand.addGitarre("1092", 12995.95, Hersteller.RYAN, 
            "SJ", Typ.AKUSTISCH,
            Holz.INDISCHER_PALISANDER, Holz.ZEDER, 12);
		bestand.addGitarre("566-62", 8999.95, Hersteller.OLSON, 
            "Cathedral", Typ.AKUSTISCH,
           Holz.COCOBOLO, Holz.ZEDER, 12);
		bestand.addGitarre("6 29584", 2100.95, Hersteller.PRS, 
            "Dave Navarro Signature", Typ.ELEKTRISCH, 
            Holz.MAHAGONI, Holz.AHORN, 6);
	}

}
