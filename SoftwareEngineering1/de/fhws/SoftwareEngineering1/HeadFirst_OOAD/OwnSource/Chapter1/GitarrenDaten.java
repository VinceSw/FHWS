package de.fhws.SoftwareEngineering1.HeadFirst_OOAD.OwnSource.Chapter1;

import java.util.Iterator;

public class GitarrenDaten
{
	private String modell;
	private Hersteller hersteller;
	private Typ typ;
	private Holz bodenholz, deckenholz;
	int saitenZahl;
	
	public GitarrenDaten(Hersteller hersteller, String modell, Typ typ, Holz bodenholz, Holz deckenholz, int saitenZahl)
	{
		this.hersteller = hersteller;
		this.modell = modell;
		this.typ = typ;
		this.bodenholz = bodenholz;
		this.deckenholz = deckenholz;
		this.saitenZahl = saitenZahl;
	}
	
	public Hersteller getHersteller()
	{
		return hersteller;
	}

	public String getModell()
	{
		return modell;
	}

	public Typ getTyp()
	{
		return typ;
	}

	public Holz getBodenholz()
	{
		return bodenholz;
	}

	public Holz getDeckenholz()
	{
		return deckenholz;
	}
	
	public int getSaitenZahl()
	{
		return saitenZahl;
	}
	
	public boolean vergleichGitarren(GitarrenDaten suchGitarre)
	{
		if(suchGitarre.getHersteller() != this.getHersteller())
			return false;
		
		String modell = suchGitarre.getModell().toLowerCase();
		if((modell != null) && (!modell.equals("")) && (!modell.equals(this.getModell().toLowerCase())))
			return false;
		
		if(suchGitarre.getTyp() != this.getTyp())
			return false;
		
		if(suchGitarre.getBodenholz() != this.getBodenholz())
			return false;
		
		if(suchGitarre.getDeckenholz() != this.getDeckenholz())
			return false;
		
		if(suchGitarre.getSaitenZahl() != this.getSaitenZahl())
			return false;
		
		return true;
	}
}
