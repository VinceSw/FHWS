package de.fhws.fiw.Lektion10;

public class Studenten
{
	private String cardId;
	private String vorname;
	private String nachname;
	private int matrNr;
	
	public String getCardId()
	{
		return cardId;
	}
	public void setCardId(String cardId)
	{
		this.cardId = cardId;
	}
	public String getVorname()
	{
		return vorname;
	}
	public void setVorname(String vorname)
	{
		this.vorname = vorname;
	}
	public String getNachname()
	{
		return nachname;
	}
	public void setNachname(String nachname)
	{
		this.nachname = nachname;
	}
	public int getMatrNr()
	{
		return matrNr;
	}
	public void setMatrNr(int matrNr)
	{
		this.matrNr = matrNr;
	}
	
	
	public Studenten(String cardId, String vorname, String nachname, int matrNr)
	{
		this.cardId = cardId;
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrNr = matrNr;
	}
}
