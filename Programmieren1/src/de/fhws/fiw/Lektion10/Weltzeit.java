package de.fhws.fiw.Lektion10;


public class Weltzeit
{

	public static void main(String[] args)
	{
		Uhr[] weltzeit = new Uhr[24];
		
		setWeltzeit(weltzeit);
		displayWeltzeit(weltzeit);
		setOneSecUp(weltzeit);
		displayWeltzeit(weltzeit);
	}
	
	public static Uhr[] setWeltzeit(Uhr[] weltzeit)
	{
		for(int i = 0; i < weltzeit.length; i++)
		{
			weltzeit[i] = new Uhr(i, 23, 07);
		}
		
		return weltzeit;
	}
	
	public static Uhr[] setOneSecUp(Uhr[] weltzeit)
	{
		for(int i = 0; i < weltzeit.length; i++)
		{
			weltzeit[i].naechsteSek();
		}
		
		return weltzeit;
	}

	public static void displayWeltzeit(Uhr[] weltzeit)
	{
		for(int i = 0; i < weltzeit.length; i++)
		{
			System.out.println("Uhr " + (i + 1) + ": " + weltzeit[i].getStd() + ":" + weltzeit[i].getMin() + 
									":" + weltzeit[i].getSek());
		}
		System.out.println();
	}
}
