package de.fhws.Programmieren2.Klausurvorbereitungen6;

import java.util.Comparator;

public class VergleicheMusikStueckLaenge<T> implements Comparator<T>
{
	@Override
	public int compare(T o1, T o2)
	{
		MusikStueck ms1 = (MusikStueck)o1;
		MusikStueck ms2 = (MusikStueck)o2;
		
		Integer laengeMs1 = (Integer)ms1.getLaenge();
		Integer laengeMs2 = (Integer)ms2.getLaenge();
		
		return laengeMs1.compareTo(laengeMs2);
	}
}
