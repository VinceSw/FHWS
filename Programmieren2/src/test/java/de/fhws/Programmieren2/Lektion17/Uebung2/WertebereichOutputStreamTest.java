package de.fhws.Programmieren2.Lektion17.Uebung2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class WertebereichOutputStreamTest
{

	@Test
	void testWertebereich()
	{
		String input = "Besides Getting my ass kicked, my main accomplishment on this trip has been to massacre an incredible number of completely innocent "+
				"clothes. I'm the Joseph Stalin of laundry.";
		byte[] b = input.getBytes();
		int off = 0, l = input.getBytes().length;
		
		try
		{
			FileOutputStream fos = new FileOutputStream("D:\\FHWS\\Semester2\\SU_Programmieren2\\Lektion17\\Uebung2\\Test.txt");
			assertTrue(l == input.getBytes().length);
			
			fos.write(b, off, l);
		
			l -= 1;
			assertTrue(l == input.getBytes().length);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
