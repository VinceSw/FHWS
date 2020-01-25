package de.fhws.fiw.altklausur;

public class Zielort
{
	private String nameDest;
	private float distInKM;
	private Zielort next;
	
	public String getNameDest()
	{
		return nameDest;
	}
	
	public void setNameDest(String nameDest)
	{
		this.nameDest = nameDest;
	}
	
	public float getDistInKM()
	{
		return distInKM;
	}
	
	public void setDistInKM(float distInKM)
	{
		this.distInKM = distInKM;
	}
	
	public Zielort getNext()
	{
		return next;
	}
	
	public void setNext(Zielort next)
	{
		this.next = next;
	}
	
	public Zielort(String nameDest, float distInKM)
	{
		this.nameDest = nameDest;
		this.distInKM = distInKM;
		this.next = null;
	}
	
	public Zielort()
	{
		this.nameDest = "";
		this.distInKM = 0;
		this.next = null;
	}
	
	@Override
	public String toString()
	{
		String nameDistance = "Ortsname: " + nameDest + " Distanz: " + distInKM + " km";
		
		return nameDistance;
	}
}
