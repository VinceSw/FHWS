package de.fhws.Programmieren2.Lektion21.Uebung3;


public class NodeCalculateException extends RuntimeException
{
	private static final long serialVersionUID = 6376313725158996682L;
	
	public NodeCalculateException(String errorMsg)
	{
		super(errorMsg);
	}
}
