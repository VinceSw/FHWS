package de.fhws.fiw.altklausur;

public class PasswortTest
{

	public static void main(String[] args)
	{
		String pw = "Prog1Und2";
		
		Passwort newPw = new Passwort(pw);
		
		System.out.println(newPw);
		
		pw = "Frog1Ud3";
		if(newPw.pwAendern(pw))
		{
			System.out.println(newPw);
		}
		
	}

}
