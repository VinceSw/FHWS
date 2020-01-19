package de.fhws.fiw.altklausur;

public class Passwort
{
	public String passwort;
	
	public Passwort(String pw)
	{
		pw = pw.trim();
		
		if(alsPWgeeignet(pw))
		{
			this.passwort = pw;
		}
		else
		{
			this.passwort = null;
		}
	}
	
	public boolean alsPWgeeignet(String pw)
	{
		boolean isValid = false;
		
		if(pw.length() >= 8 && containsTwoLowerCaseChar(pw) && containsTwoNumbers(pw) && containsTwoUpperCaseChar(pw))
		{
			isValid = true;
		}
		
		return isValid;
	}
	
	public boolean pwAendern(String pw)
	{
		boolean changedPw = false;
		int oldPWLastDigit = passwort.length()-1;
		int newPWLastDigit = pw.length()-1;
		pw = pw.trim();
		
		if(passwort != null)
		{
			if(pw.charAt(0) != passwort.charAt(0) && pw.charAt(newPWLastDigit) != passwort.charAt(oldPWLastDigit))
			{
				if(alsPWgeeignet(pw))
				{
					this.passwort = pw;
					changedPw = true;
				}
			}	
		}
		
		return changedPw;
	}
	
	public boolean containsTwoUpperCaseChar(String pw)
	{
		int countUppercase = 0;
		char[] pwCharArray = new char[pw.length()];
		pwCharArray = pw.toCharArray();
		boolean isValid = false;
		
		for(int i = 0; i < pwCharArray.length; i++)
		{
			if(pwCharArray[i] >= 'A' && pwCharArray[i] <= 'Z')
			{
				countUppercase++;
			}
		}
		
		if(countUppercase > 1)
		{
			isValid = true;
		}
		
		return isValid;
	}
	
	public boolean containsTwoLowerCaseChar(String pw)
	{
		int countUppercase = 0;
		char[] pwCharArray = new char[pw.length()];
		pwCharArray = pw.toCharArray();
		boolean isValid = false;
		
		for(int i = 0; i < pwCharArray.length; i++)
		{
			if(pwCharArray[i] >= 'a' && pwCharArray[i] <= 'z')
			{
				countUppercase++;
			}
		}
		
		if(countUppercase > 1)
		{
			isValid = true;
		}
		
		return isValid;
	}
	
	public boolean containsTwoNumbers(String pw)
	{
		int countUppercase = 0;
		char[] pwCharArray = new char[pw.length()];
		pwCharArray = pw.toCharArray();
		boolean isValid = false;
		
		for(int i = 0; i < pwCharArray.length; i++)
		{
			if(pwCharArray[i] >= '0' && pwCharArray[i] <= '9')
			{
				countUppercase++;
			}
		}
		
		if(countUppercase > 1)
		{
			isValid = true;
		}
		
		return isValid;
	}
	
	@Override
	public String toString()
	{
		String result = ""; 
		
		if(passwort == null)
		{
			System.out.println("Kein gueltiges Passwort!");
		}
		else
		{
			int amountStars = passwort.length();
			
			for(int i = 0; i < amountStars; i++)
			{
				result += "*";
			}
		}
		
		return result;
	}
}
