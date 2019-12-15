package de.fhws.fiw.Lektion9;

public class SpeisekartePizza
{

	public static void main(String[] args)
	{
		displaySpeisekarte(setSpeisekarte());
	}
	
	private static Pizza[] setSpeisekarte()
	{
		Pizza[] pizzen = new Pizza[3];
		float[][] durchmPreisTonno = {{26f, 7f}, {28f, 8.5f}, {30f, 12f}};
		pizzen[0] = new Pizza("Pizza Tonno", durchmPreisTonno);
		float[][]durchmPreisSalami = {{28f, 6.5f}, {30f, 8.5f}, {32f, 10f}};
		pizzen[1] = new Pizza("Pizza Salami", durchmPreisSalami);
		float[][] durchmPreisMozzarella = {{26f, 7.5f}, {30f, 9.5f}, {32f, 11f}};
		pizzen[2] = new Pizza("Pizza Mozzarella", durchmPreisMozzarella);
		
		return pizzen;
	}
	
	private static void displaySpeisekarte(Pizza[] speisekarte)
	{
		int longestName = getLongestString(speisekarte);
		int amountBlanks = 0;
		int diameterLength = "Durchmesser".length();
		int priceLength = "Preis".length();
		
		System.out.print("Name");
		amountBlanks = longestName - "Name".length() + 5;
		System.out.printf("%" + amountBlanks + "s", "");
		System.out.print("Durchmesser");
		amountBlanks = priceLength + 5;
		System.out.printf("%" + amountBlanks + "s", "Preis");
		System.out.println();
		
		for(int i = 0; i < speisekarte.length; i++)
		{
			//Display pizza name and add blanks to make it look nice
			System.out.print(speisekarte[i].getName());
			amountBlanks = longestName - speisekarte[i].getName().length() + 5;
			System.out.printf("%" + amountBlanks + "s", "");
			
			//Display pizza diameter 
			amountBlanks = diameterLength - 2;
			System.out.printf("%" + amountBlanks + "dcm", speisekarte[i].getDurchmesser(2));
			
			//Display pizza price
			amountBlanks = priceLength + 4;
			System.out.printf("%" + amountBlanks + ".2f€", speisekarte[i].getPrice(2));
			
			System.out.println();
		}
	}
	
	private static int getLongestString(Pizza[] speisekarte)
	{
		int longestName = 0;
		
		for(int i = 0; i < speisekarte.length; i++)
		{
			if(longestName < speisekarte[i].name.length())
			{
				longestName = speisekarte[i].name.length();
			}
		}
		
		return longestName;
	}

}
