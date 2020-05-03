package de.fhws.Programmieren2.Lektion19.Uebung1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test
{
	public static void main(String[] args) 
	{
		String dateiName = "D:\\FHWS\\Semester2\\SU_Programmieren2\\Lektion19\\Übungen\\Test.txt";
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dateiName));)
		{
			GameData gd = new GameData("Bla".toCharArray());
			
			oos.writeObject(gd);
			oos.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
