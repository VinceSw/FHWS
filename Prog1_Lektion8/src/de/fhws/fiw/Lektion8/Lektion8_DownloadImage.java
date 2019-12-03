package de.fhws.fiw.Lektion8;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Lektion8_DownloadImage
{

	public static void main(String[] args) throws IOException
	{
		String seite = "<body id=\"www-wikipedia-org\">"
				+ "<div class=\"central-textlogo\">"
				+ "<img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb"
				+ "/b/bb/Wikipedia_wordmark.svg/174px-Wikipedia_wordmark.svg.png\">"
				+ "</div>"
				+ "</body>";
		String searchStringS = "<img src=\"";
		String searchStringE = ".png";
		int indexStart = seite.indexOf("<img");
		if(indexStart != -1)
		{
			indexStart += searchStringS.length();
			
			int indexEnde = seite.indexOf(".png");
			if(indexEnde != -1)
			{
				indexEnde += searchStringE.length();
				String downloadUrl = seite.substring(indexStart, indexEnde);
				
				URL url = new URL(downloadUrl);
				BufferedImage image = ImageIO.read(url);
				ImageIO.write(image, "png", new File("Bild.png"));	
			}
			else
			{
				throw new IOException("Could not find Image in URL");
			}
		}
		else
		{
			throw new IOException("Could not find Image in URL");
		}
	}
}
