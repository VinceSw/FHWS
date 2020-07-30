package de.fhws.Programmieren2.Klausurvorbereitungen6;

import java.util.Comparator;

public class VergleicheMusikStueckTitel<T> implements Comparator<T>
{
	@Override
	public int compare(T o1, T o2)
	{
		MusikStueck ms1 = (MusikStueck)o1;
		MusikStueck ms2 = (MusikStueck)o2;
		
		if(ms1 == null || ms2 == null)
			return 0;
		return ms1.getTitel().compareTo(ms2.getTitel());
	}
}
