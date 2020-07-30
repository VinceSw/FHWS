package de.fhws.Programmieren2.Klausurvorbereitungen;

import java.net.URL;
import java.util.UUID;

public class DownloadJob implements Runnable
{
	private String jobID;
	private URL url;
	private byte[] file;
	
	public DownloadJob(URL url)
	{
		this.url = url;
	}
	
	@Override
	public void run()
	{
		generateJobID();
		
		file = DownloadManager.downloadFromURL(url);
		
	}
	
	private void generateJobID()
	{
		this.jobID = UUID.randomUUID().toString();
	}
	
	
}
