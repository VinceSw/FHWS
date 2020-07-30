package de.fhws.Programmieren2.Lektion22.Uebung1;

public class YinYangThread extends Thread
{
	String word;
	
	public YinYangThread(String word)
	{
		this.word = word;
	}
	
	public static void main(String[] args)
	{
		YinYangThread yin = new YinYangThread("Yin");
		YinYangThread yang = new YinYangThread("Yang"); 
		yin.start();
		yang.start();
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			yinYangOutput(word);
			try
			{
				sleep(500);	
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private static void yinYangOutput(String s)
	{
		System.out.println(s); 
	}

}
