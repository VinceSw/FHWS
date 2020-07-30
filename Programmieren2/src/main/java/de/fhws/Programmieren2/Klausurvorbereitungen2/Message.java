package de.fhws.Programmieren2.Klausurvorbereitungen2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message
{
	private int charCounter;
	private String message;
	private String creationDate;
	
	public Message(String message)
	{
		int msgLength = message.length();
		final int constLeng = 140;
		
		if(msgLength > constLeng)
		{
			this.message = message.substring(0, constLeng);
			this.charCounter = constLeng;
		}
		else
		{
			this.message = message;
			this.charCounter = msgLength;
		}
		
		this.creationDate = getCurrentDateAsString();
		
	}	
	
	public String getCurrentDateAsString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		
		return today;
	}
	
	public int getCharCounter()
	{
		return charCounter;
	}
	public void setCharCounter(int charCounter)
	{
		this.charCounter = charCounter;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getCreationDate()
	{
		return creationDate;
	}
	public void setCreationDate(String creationDate)
	{
		this.creationDate = creationDate;
	}
}
