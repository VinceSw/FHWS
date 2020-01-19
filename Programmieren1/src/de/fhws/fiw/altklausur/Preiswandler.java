package de.fhws.fiw.altklausur;

public class Preiswandler
{

	public static char[] wandleUmInCents(String betrag)
	{
		betrag = betrag.trim();
		
		if(!betrag.equals(""))
		{
			betrag = betrag.replace(",", "");
			
			while(betrag.charAt(0) == '0')
			{
				betrag = betrag.substring(1);
			}
		}
		
		char[] betragChar = new char[betrag.toCharArray().length];
		betragChar = betrag.toCharArray(); 
		
		return betragChar; 
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("1,99 -> " + String.valueOf(wandleUmInCents("1,99")));
		System.out.println("0,99 -> " + String.valueOf(wandleUmInCents("0,99")));
		System.out.println("0,90 -> " + String.valueOf(wandleUmInCents("0,90")));
		System.out.println("0,09 -> " + String.valueOf(wandleUmInCents("0,09")));
	}
}
