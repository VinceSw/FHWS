package de.fhws.SoftwareEngineering1.HeadFirst_OOAD.OwnSource.Chapter1;

public class Gitarre
{
	private String seriennummer;
	private double preis;
	GitarrenDaten daten;
	
	public Gitarre(String seriennummer, double preis, GitarrenDaten daten)
	{
		this.seriennummer = seriennummer;
		this.preis = preis;
		this.daten = daten;
	}
	
	public double getPreis()
	{
		return preis;
	}

	public void setPreis(double preis)
	{
		this.preis = preis;
	}

	public String getSeriennummer()
	{
		return seriennummer;
	}

	public GitarrenDaten getGitarrenDaten()
	{
		return daten;
	}
	
	
	
	
}
