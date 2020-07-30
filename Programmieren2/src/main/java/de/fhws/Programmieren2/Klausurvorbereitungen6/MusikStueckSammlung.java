package de.fhws.Programmieren2.Klausurvorbereitungen6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class MusikStueckSammlung
{
	HashMap<String, MusikStueck> sammlung;
	
	public MusikStueckSammlung()
	{
		sammlung = new HashMap<String, MusikStueck>();
	}
	
	public void musikStueckEinfügen(MusikStueck neu) throws IllegalArgumentException
	{
		String title = neu.getTitel();
		
		if(!sammlung.containsKey(title))
		{
			sammlung.put(title, neu);
		}
		else
		{
			throw new IllegalArgumentException("Das Musikstück wurde der Sammlung bereits zugefügt.");
		}
	}
	
	public MusikStueck[] getAlleMusikStueckeNachTitel()
	{
		int sammlungSize = sammlung.size();
		MusikStueck[] mArr = new MusikStueck[sammlungSize];
		sammlung.values().toArray(mArr);
		
		VergleicheMusikStueckTitel<MusikStueck> comp = new VergleicheMusikStueckTitel<MusikStueck>();
		
		Arrays.sort(mArr, comp);
		return mArr;
	}
}
