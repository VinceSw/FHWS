package de.fhws.Programmieren2.Klausurvorbereitungen3;

@SuppressWarnings("serial")
public class FalscheIBANException extends IllegalArgumentException
{
	
	public FalscheIBANException()
	{
		super("FELER: Datei enthält ungültige IBAN.");
	}
	
	public FalscheIBANException(String msg)
	{
		super(msg);
	}
	
}
