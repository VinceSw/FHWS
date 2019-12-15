package de.fhws.fiw.Lektion10;

public class Raum
{
	private String roomID;
	private int maxAmountStudents;
	private boolean isBooked;
	
	public String getRoomID()
	{
		return this.roomID;
	}
	
	public void setRoomID(String roomID)
	{
		this.roomID = roomID.trim();
	}
	
	public int getMaxAmountStundents()
	{
		return this.maxAmountStudents;
	}
	
	public void setMaxAmountStudents(int maxAmountStudents)
	{
		this.maxAmountStudents = maxAmountStudents;
	}
	
	public boolean getIsBooked()
	{
		return isBooked;
	}
	
	public void setIsBooked(boolean isBooked)
	{
		this.isBooked = isBooked;
	}
	
	public Raum(String roomID, int maxAmountStudents)
	{
		this.roomID = roomID;
		this.maxAmountStudents = maxAmountStudents;
		this.isBooked = false;
	}
	
	public Raum(String roomID, int maxAmountStudents, boolean isBooked)
	{
		this.roomID = roomID;
		this.maxAmountStudents = maxAmountStudents;
		this.isBooked = isBooked;
	}
}