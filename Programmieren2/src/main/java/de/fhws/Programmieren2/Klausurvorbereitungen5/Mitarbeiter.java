package de.fhws.Programmieren2.Klausurvorbereitungen5;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

@SuppressWarnings("serial")
public class Mitarbeiter implements Serializable
{
	private String vorname = null;
	private String nachname = null;
	private int nummer = 0;
	private transient int gehalt = 0;
	private static transient HashSet<Mitarbeiter> set;

	public Mitarbeiter(String vorname, String nachname, int nummer, int gehalt)
	{
		this.vorname = vorname;
		this.nachname = nachname;
		this.nummer = nummer;
		this.gehalt = gehalt;
	}// endconstructor // . . . alle getter- und setter-Methoden

	
	public static void main(String[] args)
	{
		Mitarbeiter m1 = new Mitarbeiter("John", "Doe", 8150, 3000);
		Mitarbeiter m2 = new Mitarbeiter("Jane", "Doe", 1212, 3500);
		Mitarbeiter m3 = new Mitarbeiter("Richard", "Kadrey", 4711, 4700);
		
		set = new HashSet<Mitarbeiter>();
		
		set.add(m1);
		set.add(m2);
		set.add(m3);
		
		serialize(set);
		
		set = deserialize();
		
		for(Mitarbeiter m : set)
		{
			System.out.println(m.toString());
		}
		
		System.out.println("\n\n");
		
		displayArray(sortiere(set));
	}
	
	
	public static void serialize(HashSet<Mitarbeiter> set)
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mitarbeiter.dat")))
		{
			for(Mitarbeiter m : set)
			{
				oos.writeObject(m);
				oos.flush();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static HashSet<Mitarbeiter> deserialize()
	{
		HashSet<Mitarbeiter> hs = new HashSet<>();
		Mitarbeiter m = null;
		try(FileInputStream fis = new FileInputStream("mitarbeiter.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);)
		{
			while(true)
			{
				m = (Mitarbeiter)ois.readObject();
				hs.add(m);
			}
		}
		catch(EOFException e)
		{
			return hs;
		}
		catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static Mitarbeiter[] sortiere(HashSet<Mitarbeiter> team)
	{
		Mitarbeiter[] mArr = new Mitarbeiter[team.size()];
		Iterator<Mitarbeiter> iter = team.iterator();
		int i = 0;
		
		while(iter.hasNext())
		{
			mArr[i] = iter.next();
			i++;
		}
		
		VergleichePersonalNummer<Mitarbeiter> comp = new VergleichePersonalNummer<Mitarbeiter>();
		Arrays.sort(mArr, comp);
		
		return mArr;
	}
	
	public static void displayArray(Mitarbeiter[] mArr)
	{
		for(Mitarbeiter m : mArr)
		{
			System.out.println(m.toString());
		}
	}
	
	public String toString()
	{
		return "Nachname: " + nachname + " Vorname: " + vorname
				+ " Personalnummer: " + nummer + " Gehalt: " + gehalt;
	}// endmethod toString

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		return result;
	}// endmethod hashcode

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof Mitarbeiter))
		{
			return false;
		}
		Mitarbeiter other = (Mitarbeiter) obj;
		if (gehalt != other.gehalt)
		{
			return false;
		}
		
		return false;
	}// endmethod equals
	
	public int getPersonalNummer()
	{
		return this.nummer;
	}
}// endclass Mitarbeiter
