package de.fhws.Programmieren2.Lektion17.Uebung3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ZeitmessungStreams
{
	private String fileSourcePath, fileDestPath;
	private long bufferedDuration, unbufferedDuration;
	
	public boolean copyMusicFile(LineProvider provider)
	{
		boolean copyWasSuccessful = false;
		
		while(!copyWasSuccessful)
		{
			getInput(provider);
			
			copyWasSuccessful = unbufferedCopy(fileSourcePath, fileDestPath);
			
			//check which method was faster if both of them where successful
			if(copyWasSuccessful)
				checkDuration();
		}
		
		return copyWasSuccessful;
	}
	
	private void getInput(LineProvider provider)
	{
		//write input into global variables fileSourcePath and fileDestPath
		if(provider.getClass() == UserInput.class)
		{
			System.out.print("Please insert the filepath which the file should be copied to: ");
		}
			
		fileSourcePath = provider.nextLine();
		
		if(provider.getClass() == UserInput.class)
		{
			System.out.print("Please insert the filepath which the file should be copied from: ");
		}
		
		fileDestPath = provider.nextLine();
	}
		
	public boolean unbufferedCopy(String fileSourcePath, String fileDestPath)
	{
		long startTime, endTime;
		boolean isSuccessfull = true;
		
		//Generate FileInputStreams and Bufferedstreams for copy and test in a try-with-resource block
		try(FileInputStream fis = new FileInputStream(fileSourcePath);
				FileOutputStream fos = new FileOutputStream(fileDestPath);
				InputStream bis = new BufferedInputStream(new FileInputStream(fileSourcePath));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileDestPath));)
		{
			startTime = System.currentTimeMillis();
			copyFile(fis, fos);
			endTime = System.currentTimeMillis();
			unbufferedDuration = endTime - startTime;
			
			startTime = System.currentTimeMillis();
			copyFile(bis, bos);
			endTime = System.currentTimeMillis();
			bufferedDuration = endTime - startTime;
		}
		catch(FileNotFoundException e)
		{
			isSuccessfull = false;
			e.printStackTrace();
		}
		catch(IOException ioe)
		{
			isSuccessfull = false;
			ioe.printStackTrace();
		}
		
		return isSuccessfull;
	}
		
	//Overloaded copyFile method for copying with general Input- and OutputStream
	private void copyFile(InputStream is, OutputStream os) throws IOException
	{
		byte[] b = new byte[4096];
		int n;
		
		do
		{
			n = is.read(b);
			if(n != -1) os.write(b, 0, n);
		}while(n != -1);
	}
	
	private void checkDuration()
	{
		if(bufferedDuration < unbufferedDuration)
		{
			System.out.println("Buffered copy was " + (unbufferedDuration - bufferedDuration) + "ms faster than unbuffered copy.");
		}
		else
		{
			System.out.println("Buffered copy was " + (bufferedDuration - unbufferedDuration) + "ms faster than unbuffered copy.");
		}
	}
}