package de.fhws.fiw.Lektion8;

public class Auto
{
	private String Marke;
	private String Modell;
	private float HubraumL;
	private String Farbe;
	private int LeistungKW;
	private String Karosserie;
	private int Baujahr;
	
	String getMarke()
	{
		return this.Marke;
	}
	
	String getModell()
	{
		return this.Modell;
	}
	
	float getHubraum()
	{
		return this.HubraumL;
	}
	
	String getFarbe()
	{
		return this.Farbe;
	}
	
	int getLeistungKW()
	{
		return this.LeistungKW;
	}
	
	String getKarosserie()
	{
		return this.Karosserie;
	}
	
	int getBaujahr()
	{
		return this.Baujahr;
	}
	
	Auto(String Marke, String Modell, float Hubraum, String Farbe, int Leistung, String Karosserie, int Baujahr)
	{
		this.Marke = Marke;
		this.Modell = Modell;
		this.HubraumL = Hubraum;
		this.Farbe = Farbe;
		this.LeistungKW = Leistung;
		this.Karosserie = Karosserie;
		this.Baujahr = Baujahr; 
	}
}
