package de.fhws.fiw.Lektion11;

public class TextdokumentTest
{

	public static void main(String[] args)
	{
		String zeile = "Ich erwache auf einem schwelenden Haufen aus Müll und trockenem Laub, ";
		String zeile2 = "mitten auf dem Friedhof von Hollywood, der hinter Paramount-Studios an der Melrose liegt. ";
		String zeile3 = "Die Details werden mir allerdings erst später klar, vorläufig weiß ich bloß, dass ich wieder ";
		String zeile4 = "auf der Welt bin und in Flammen stehe.";
		String zeile5 = "Mein Verstand ist noch nicht ganz da, aber mein Körper schafft es auch so, von dem brennenden ";
		String zeile6 = "Drecksszeug herunterzurollen und sich so lange herumzuwälzen, bis die Hitze nachlässt.";
		
		char[][] newTextDoc = {zeile.toCharArray(), zeile5.toCharArray(),
				zeile4.toCharArray(), zeile6.toCharArray()};
		
		Textdokument textDoc = new Textdokument(newTextDoc);
		
		System.out.println("\nOriginal Text: ");
		System.out.println(textDoc.getTextdokument());
		
		System.out.println(textDoc.vertauscheZeilen(1, 2));
		
		System.out.println("\nVertauschter Text: ");
		System.out.println(textDoc.getTextdokument());
		
		System.out.println("\nEingefügter Text: ");
		char[][] insertTextDoc = {zeile2.toCharArray(), zeile3.toCharArray()};
		textDoc.fuegeEinTextdokument(insertTextDoc, 1);
		
		System.out.println(textDoc.getTextdokument());
		
		System.out.println(textDoc.zaehleZeichen());
		
		
		
	}

}
