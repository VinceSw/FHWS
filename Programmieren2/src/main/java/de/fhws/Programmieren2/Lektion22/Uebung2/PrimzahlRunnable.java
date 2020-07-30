package de.fhws.Programmieren2.Lektion22.Uebung2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrimzahlRunnable implements Runnable
{
	List<Integer> zahlZumTesten;
	Map<Integer, Boolean> ergebnis;
	static Map<Integer, Boolean> result;
	
	public PrimzahlRunnable(List<Integer> zahl)
	{
		this.zahlZumTesten = zahl;
		ergebnis = new HashMap<>();
		result = new HashMap<>();
	}
	
	
	public boolean testeObPrimzahl(int zahlZumTesten) {
		if (zahlZumTesten < 2) return false;
		for (int divisor = 2; divisor < zahlZumTesten; divisor++)
		if (zahlZumTesten % divisor == 0) return false;
		return true;
	}
	
	@Override
	public void run() 
	{
		for(int i : zahlZumTesten)
		{
			boolean istPrimzahl = testeObPrimzahl(i);
			ergebnis.put(i, istPrimzahl);
		}
	}
	
	public static void main(String[] args)
	{
		List<Integer> list1 = new LinkedList<>();
			list1.add(341);
			list1.add(633910099);
			list1.add(19);
			list1.add(1024);
			
		List<Integer> list2 = new LinkedList<>();
			list2.add(17449);
			list2.add(24379);
			list2.add(8192);
			list2.add(65535);
		
		PrimzahlRunnable pr1 = new PrimzahlRunnable(list1);
		PrimzahlRunnable pr2 = new PrimzahlRunnable(list2);
		Thread t1 = new Thread(pr1);
		Thread t2 = new Thread(pr2);
		t1.start();
		t2.start();
		
		try
		{
			t1.join();
			t2.join();
			
			insertInMap(pr1.ergebnis);
			insertInMap(pr2.ergebnis);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		mapOutput();
	}
	
	private static Map<Integer, Boolean> insertInMap(Map<Integer, Boolean> map)
	{
		Map<Integer, Boolean> ergebnis = new HashMap<>();
		Set<Integer> keyset = map.keySet();
		
		for(int key : keyset)
		{
			Boolean value = map.get(key);
			result.put((Integer)key, value);
		}
		
		return ergebnis;
	}
	
	private static void mapOutput()
	{
		Set<Integer> keyset = result.keySet();
		
		for(int key : keyset)
		{
			System.out.print(key + " -> " + result.get(key).toString() + "\n");
		}
	}
}
