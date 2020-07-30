package de.fhws.Programmieren2.Klausurvorbereitungen;

import java.net.MalformedURLException;
import java.net.URL;

public class DownloadTest
{
	public static void main(String[] args)
	{
		DownloadManager manager;
		try
		{
			manager = new DownloadManager()
					.configure(4, 4000)
					.specifyDownloadLocation(new URL("http://example.com/resource"));
			String jobID = manager.startDownload();
		System.out.println(jobID);
		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
