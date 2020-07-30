package de.fhws.Programmieren2.Klausurvorbereitungen;

import java.net.URL;

public class DownloadManager
{
	private URL url;
	private int maxThreads;
	private long timeout;	
	
	public DownloadManager configure(int maxThreads, long timeout)
	{
		this.maxThreads = maxThreads;
		this.timeout = timeout;
		
		return this;
	}
	
	public DownloadManager cancelDownload(String jobID)
	{
		//Stop running thread
		
		return this;
	}
	
	public String startDownload()
	{
		String jobID = "";
		
		return jobID;
	}
	
	public DownloadManager specifyDownloadLocation(URL url)
	{
		this.url = url;
		
		return this;
	}
	
	public static byte[] downloadFromURL(URL url)
	{
		byte[] file = new byte[10];
		
		return file; 
	}
}
