package de.fhws.Programmieren2.Klausurvorbereitungen3;

@SuppressWarnings("serial")
public class FalscheIBANException extends IllegalArgumentException
{
	private String msg;
	
	public FalscheIBANException()
	{
		this.msg = "FELER: Datei enthält ungültige IBAN.";
	}
	
	public FalscheIBANException(String msg)
	{
		this.msg = msg;
	}
	
}
