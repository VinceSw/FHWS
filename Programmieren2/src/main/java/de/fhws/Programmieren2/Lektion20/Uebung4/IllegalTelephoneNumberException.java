package de.fhws.Programmieren2.Lektion20.Uebung4;

import java.io.IOException;

public class IllegalTelephoneNumberException extends IOException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IllegalTelephoneNumberException(String errorMsg)
	{
		super(errorMsg);
	}

}
