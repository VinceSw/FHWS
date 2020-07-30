package de.fhws.Programmieren2.Lektion22.Uebung1;

public class YinYangLocal
{
	public static void main(String[] args)
	{
		class localYinYang extends Thread
		{
			@Override
			public void run()
			{
				String word = "";
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
		}
		
		localYinYang l1 = new localYinYang();
		l1.start();
	}
}
