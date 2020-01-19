package de.fhws.fiw.Lektion12;

public class Knoten
{
	private String wort, bedeutung;
	private Knoten left, right;
	
	public Knoten(String word, String definition)
	{
		this.wort = word;
		this.bedeutung = definition;
	}

	public String getWord()
	{
		return this.wort;
	}
	
	public String getDefinition()
	{
		return this.bedeutung;
	}
	
	public Knoten getLeft()
	{
		return this.left;
	}
	
	public Knoten getRight()
	{
		return this.right;
	}
	
	public void setWord(String word)
	{
		this.wort = word;
	}
	
	public void setDefinition(String definition)
	{
		this.bedeutung = definition;
	}
	
	public void setLeft(Knoten left)
	{
		this.left = left;
	}
	
	public void setRight(Knoten right)
	{
		this.right = right;
	}
}
