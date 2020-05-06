package de.fhws.SoftwareEngineering1.HeadFirst_OOAD.OwnSource.Chapter1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Bestand
{
	private List<Gitarre> gitarren;
	
	public Bestand()
	{
		gitarren = new LinkedList<Gitarre>();
	}
	
	public void addGitarre(String seriennummer, double preis, Hersteller hersteller, String modell, Typ typ, Holz bodenholz, Holz deckenholz, int saitenZahl)
	{
		GitarrenDaten gitarrenDaten = new GitarrenDaten(hersteller, modell, typ, bodenholz, deckenholz, saitenZahl);
		Gitarre gitarre = new Gitarre(seriennummer, preis, gitarrenDaten);
		
		gitarren.add(gitarre);
	}
	
	public Gitarre getGitarre(String seriennummer)
	{
		for(Iterator i = gitarren.iterator(); i.hasNext();)
		{
			Gitarre gitarre = (Gitarre)i.next();
			
			if(gitarre.getSeriennummer().equals(seriennummer))
				return gitarre;
		}
		
		return null;
	}
	
	public List<Gitarre> suchen(GitarrenDaten suchGitarre)
	{
		List<Gitarre> passendeGitarren = new LinkedList<Gitarre>();
		
		for(Iterator i = gitarren.iterator(); i.hasNext();)
		{
			Gitarre gitarre = (Gitarre)i.next();
			GitarrenDaten gitarrenDaten = gitarre.getGitarrenDaten();
			
			if(gitarrenDaten.vergleichGitarren(suchGitarre))
			{
				passendeGitarren.add(gitarre);
			}
		}
		
		return passendeGitarren;
	}
	
	
}
