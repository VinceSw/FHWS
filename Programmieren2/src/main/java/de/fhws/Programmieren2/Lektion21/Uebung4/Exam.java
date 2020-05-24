package de.fhws.Programmieren2.Lektion21.Uebung4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Exam
{
	private Collection<Question> questionList;
	private String filePath = "D:\\FHWS\\Semester2\\SU_Programmieren2\\Lektion21\\Übungen\\Uebung4\\";
	private String fileName, fullQualifiedPath;
	
	public void readQuestions() throws IOException
	{
		fileName = "questions.csv";
		fullQualifiedPath = filePath + fileName;
		
		try(FileReader fr = new FileReader(fullQualifiedPath);
				BufferedReader br = new BufferedReader(fr))
		{
			questionList = new ArrayList<>();
			String text = "";
			
			while((text = br.readLine()) != null)
			{
				Question question = new Question(text);
				questionList.add(question);
			}
		}
		catch(Error e)
		{
			e.printStackTrace();
		}
	}
	
	public void toTest() throws IOException
	{
		fileName = "test.tex";
		fullQualifiedPath = filePath + fileName;
		
		File file = new File(fullQualifiedPath);
		if(file.exists())
		{
			file.delete();
			file.createNewFile();
		}
		else
		{
			file.createNewFile();
		}
		
		try(FileReader fr = new FileReader(fullQualifiedPath);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fwHeader = new FileWriter(fullQualifiedPath);
				BufferedWriter bwHeader = new BufferedWriter(fwHeader);
				FileWriter fw = new FileWriter(fullQualifiedPath, true);
				BufferedWriter bw = new BufferedWriter(fw))
		{
			bwHeader.write(readHeaderFromFile());
			bwHeader.flush();
			String questionInLaTex = "";
			String endFile = "\\end{document}";
			
			for(Question q : questionList)
			{
				questionInLaTex = "\\textbf{" + q.text + "}\\\\" + "\n";
				bw.write(questionInLaTex);
			}
			bw.write(endFile);
			bw.flush();
		}
	}
	
	//Liest den Tex-Header aus einer Datei u. gibt ihn als String zurück
	String readHeaderFromFile() throws IOException
	{
		fileName = "LaTex_template.csv";
		fullQualifiedPath = filePath + fileName;
		String line = "", header = "";		
		
		try(FileReader fr = new FileReader(fullQualifiedPath);
				BufferedReader br = new BufferedReader(fr))
		{
			while((line = br.readLine()) != null)
			{
				header += line + "\n";
			}
		}
		
		return header;
	}
}
