package de.fhws.Programmieren2.Klausurvorbereitungen5;

import java.util.Comparator;

public class VergleichePersonalNummer<T> implements Comparator<T>
{

	@Override
	public int compare(T o1, T o2)
	{
		Mitarbeiter m1 = (Mitarbeiter) o1;
		Mitarbeiter m2 = (Mitarbeiter) o2;
		
		if(m1 == null || m2 == null)
			return 0;
		if(m1.getPersonalNummer() < m2.getPersonalNummer())
			return -1;
		else if(m1.getPersonalNummer() > m2.getPersonalNummer())
			return 1;
		
		return 0;
	}	
}
