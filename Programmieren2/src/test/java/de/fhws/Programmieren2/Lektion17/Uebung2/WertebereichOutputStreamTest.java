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
			assertTrue(off >= 0 && off <= l);
			assertTrue(l > 0 && l <= b.length && (l + off) <= b.length + 1);

			fos.write(b, off, l);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	void testWertebereichLaengeFalsch()
	{
		String input = "Besides Getting my ass kicked, my main accomplishment on this trip has been to massacre an incredible number of completely innocent "+
				"clothes. I'm the Joseph Stalin of laundry.";
		byte[] b = input.getBytes();
		int off = 0, l = input.getBytes().length+10;
		
		try
		{
			FileOutputStream fos = new FileOutputStream("D:\\FHWS\\Semester2\\SU_Programmieren2\\Lektion17\\Uebung2\\Test.txt");
			assertTrue(off >= 0 && off <= l);

			fos.write(b, off, l);
			fail("Exception expected");
		}
		catch(Exception e)
		{
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}
	}
	
	@Test
	void testWertebereichOffsetFalsch()
	{
		String input = "Besides Getting my ass kicked, my main accomplishment on this trip has been to massacre an incredible number of completely innocent "+
				"clothes. I'm the Joseph Stalin of laundry.";
		byte[] b = input.getBytes();
		int off = -1, l = input.getBytes().length;
		
		try
		{
			FileOutputStream fos = new FileOutputStream("D:\\FHWS\\Semester2\\SU_Programmieren2\\Lektion17\\Uebung2\\Test.txt");

			fos.write(b, off, l);
			fail("Exception expected");
		}
		catch(Exception e)
		{
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}
	}
	

}
