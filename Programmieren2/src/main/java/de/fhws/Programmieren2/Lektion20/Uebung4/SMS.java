package de.fhws.Programmieren2.Lektion20.Uebung4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SMS
{
	private Map<String, String> char2Number;
	private String fromFile, toFile;

	public void convertContacts()
	{
		ArrayList<String> contactList = getContacts(fromFile);

		for (String s : contactList)
		{

			char[] string2Char = s.trim().toLowerCase().toCharArray();
			String result = "";

			for (char c : string2Char)
			{
				try
				{
					String valueOfC = String.valueOf(c);
					if (char2Number.containsKey(valueOfC))
						result += char2Number.get(valueOfC);
					else
						throw new IllegalTelephoneNumberException(
								"\"" + c + "\" is not an valid argument");
				}
				catch (IllegalTelephoneNumberException e)
				{
					System.out.println(e.getMessage());
				}
			}
			
			writeNumberContacts(toFile, result);
		}
	}

	public SMS(String fromFile, String toFile)
	{
		this.fromFile = fromFile;
		this.toFile = toFile;

		this.char2Number = new HashMap<>();
		char2Number.put("a", "2");
		char2Number.put("b", "2");
		char2Number.put("c", "2");
		char2Number.put("d", "3");
		char2Number.put("e", "3");
		char2Number.put("f", "3");
		char2Number.put("g", "4");
		char2Number.put("h", "4");
		char2Number.put("i", "4");
		char2Number.put("j", "5");
		char2Number.put("k", "5");
		char2Number.put("l", "5");
		char2Number.put("m", "6");
		char2Number.put("n", "6");
		char2Number.put("o", "6");
		char2Number.put("p", "7");
		char2Number.put("q", "7");
		char2Number.put("r", "7");
		char2Number.put("s", "7");
		char2Number.put("t", "8");
		char2Number.put("u", "8");
		char2Number.put("v", "8");
		char2Number.put("w", "9");
		char2Number.put("x", "9");
		char2Number.put("y", "9");
		char2Number.put("z", "9");
	}

	private ArrayList<String> getContacts(String fromFile)
	{
		ArrayList<String> contactList = new ArrayList<>();

		try (InputStream is = new FileInputStream(fromFile);
				BufferedReader br = new BufferedReader(new InputStreamReader(is));)
		{
			for (String line = br.readLine(); line != null; line = br.readLine())
			{
				line = checkLineForDisallowedChars(line);
				contactList.add(line);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return contactList;
	}

	private String checkLineForDisallowedChars(String line)
	{
		char[] charArray = line.toCharArray();
		char[] result = new char[charArray.length];
		int i = 0;

		for (char c : charArray)
		{
			try
			{
				if (c < 64 || (c > 91 && c < 96) || c > 122)
				{
					throw new IllegalTelephoneNumberException(
							"\"" + c + "\" is not an valid argument");
				}
				else
				{
					result[i] = c;
					i++;
				}
			}
			catch (IllegalTelephoneNumberException e)
			{
				System.out.println(e.getMessage());
			}
		}

		return String.copyValueOf(result);
	}

	private void writeNumberContacts(String toFile, String line)
	{
		try (OutputStream os = new FileOutputStream(toFile, true);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));)
		{
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
