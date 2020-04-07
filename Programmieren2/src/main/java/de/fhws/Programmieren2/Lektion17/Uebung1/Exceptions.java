package de.fhws.Programmieren2.Lektion17.Uebung1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exceptions
{
	
	public void throwNumberFormatException() throws NumberFormatException
	{
		int number = Integer.valueOf("asd");
	}
	
	public void throwArrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException
	{
		int[] zahlenArray = new int[5];
		
		for(int i = 0; i <= zahlenArray.length; i++)
		{
			zahlenArray[i] = i;
			System.out.println(i+".Durchlauf");
		}
	}
	
	public void throwNullPointerException() throws NullPointerException
	{
		String[] exc = new String[5];
		exc[0] = "This is a test";
		exc[2] = null;
		String test= "";
		
		for(int i = 0; i <= exc.length; i++)
		{
			test = exc[i].toString();
			System.out.println(i+".Durchlauf: " + test);
		}
	}
	
	public void throwOutOfMemoryError() throws OutOfMemoryError
	{
		int arraySize = 15;
		System.out.println("Max JVM memory: " + Runtime.getRuntime().maxMemory());
		long memoryConsumed =0;
		
		long[] memoryAllocated = null;
		for(int i = 0; i < Integer.MAX_VALUE; i++)
		{
			memoryAllocated = new long[arraySize];
			memoryAllocated[0] = 0;
			memoryConsumed += arraySize * Long.SIZE;
			System.out.println("Memory consumed until now: " + memoryConsumed);
			arraySize *= arraySize * 2;
		}
	}
	
	public void throwFileNotFoundException() throws FileNotFoundException
	{
		FileInputStream ifs = new FileInputStream("bild.jpg");
	}
	
	public void throwArithmeticException() throws ArithmeticException
	{
		int fraction = 3 / 0;
	}
}
