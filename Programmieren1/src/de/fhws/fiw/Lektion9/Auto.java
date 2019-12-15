package de.fhws.fiw.Lektion9;


public class Auto
{
	private String Marke;
	private String Modell;
	private int HubraumCcm;
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
	
	int getHubraum()
	{
		return this.HubraumCcm;
	}
	
	public void setHubraum(int ccm)
	{
		if(ccm > 0)
		{
			this.HubraumCcm = ccm;
		}
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
	
	Auto(String Marke, String Modell, int HubraumCcm, String Farbe, int Leistung, String Karosserie, int Baujahr)
	{
		this.Marke = Marke;
		this.Modell = Modell;
		if(HubraumCcm > 0)
		{
			this.HubraumCcm = HubraumCcm;
		}
		else
		{
			this.HubraumCcm = 1600;
		}
		this.Farbe = Farbe;
		this.LeistungKW = Leistung;
		this.Karosserie = Karosserie;
		this.Baujahr = Baujahr; 
	}
}
