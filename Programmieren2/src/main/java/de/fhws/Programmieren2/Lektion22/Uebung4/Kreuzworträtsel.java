package de.fhws.Programmieren2.Lektion22.Uebung4;

import java.util.Arrays;

public class Kreuzworträtsel
{
	static String[] alleWoerter =	{"Bienenschwarm", "Buch", "Bibel", "Beige", "Barriere", "Bein", "Beil",
			"Christ", "Christian", "Carmen"};
	
	public static void main(String[] args)
	{
		TreeSet<String> t1 = new TreeSet<>();
		t1.addAll(Arrays.asList(alleWoerter));
		for (String wort : t1)
			System.out.println(wort);
	}
}
