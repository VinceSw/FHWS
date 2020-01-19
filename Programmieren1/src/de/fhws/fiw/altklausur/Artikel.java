package de.fhws.fiw.altklausur;

public class Artikel
{
	private int artikelnr;
	private String artikelname;
	private Artikel next;
	
	public int getArtikelnr()
	{
		return this.artikelnr;
	}
	
	public String getArtikelname()
	{
		return this.artikelname;
	}
	
	public void setArtikelnr(int artikelnr)
	{
		this.artikelnr = artikelnr;
	}
	
	public void setArtikelname(String artikelname)
	{
		this.artikelname = artikelname;
	}
	
	public Artikel getNext()
	{
		return next;
	}

	public void setNext(Artikel next)
	{
		this.next = next;
	}
	
	public Artikel(int artikelnr, String artikelname)
	{
		this.setArtikelnr(artikelnr);
		this.setArtikelname(artikelname);
		this.setNext(null);
	}
	
	public Artikel()
	{
		this.setArtikelnr(0);
		this.setArtikelname("");
		this.setNext(null);
	}
}
