package de.fhws.Programmieren2.Lektion22.Uebung1;

public class YinYangRunnable implements Runnable
{
	String word;
	
	public YinYangRunnable(String word)
	{
		this.word = word;
	}
	
	public static void main(String[] args)
	{
		YinYangRunnable yin = new YinYangRunnable("Yin");
		YinYangRunnable yang = new YinYangRunnable("Yang");
		Thread t1 = new Thread(yin);
		Thread t2 = new Thread(yang);
		
		t1.start();
		t2.start();
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			yinYangOutput(word);
			try
			{
				Thread.sleep(500);	
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
