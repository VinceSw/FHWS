package de.fhws.fiw.Lektion12;

public class TestPersonen
{

	public static void main(String[] args)
	{
		Liste list = new Liste();
		
		list.sortAdd(19, "Ackermann");
		list.sortAdd(31, "Gilles");
		list.sortAdd(27, "Swigler");
		
		Personenknoten p = list.search("Swigler");
		p = list.search("Stadtel");
		
		list.displayList();
	}

}
