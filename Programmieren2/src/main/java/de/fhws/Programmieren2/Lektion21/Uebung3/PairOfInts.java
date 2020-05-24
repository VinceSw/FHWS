package de.fhws.Programmieren2.Lektion21.Uebung3;

public class PairOfInts
{
	int x, y;
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public PairOfInts(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(PairOfInts secondPair)
	{
		int compX = Integer.compare(this.x, secondPair.x);
		int compY = Integer.compare(this.y, secondPair.y);
		
		return compX + compY;
	}
	
	public boolean equals(PairOfInts secondPair)
	{
		return this.x == secondPair.x && this.y == secondPair.y;
	}
}
