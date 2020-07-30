package de.fhws.Programmieren2.Lektion22.Uebung1;

public class YinYangAnonymous
{
	static String word; 
	public static void main(String[] args)
	{
		Thread t1 = new Thread()
		{
			@Override
			public void run()
			{
				boolean isYin = true;
				
				while (true)
				{
					if(isYin)
					{
						word ="Yin";
						isYin = false;
					}
					else
					{
						word = "Yang";
						isYin = true;
					}
					
					yinYangOutput(word);
					try
					{
						Thread.sleep(500);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
			
			private void yinYangOutput(String s)
			{
				System.out.println(s);
			}
		};
		
		t1.start();
	}
}
