package de.fhws.Programmieren2.Klausurvorbereitungen2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwotterSystem
{
	HashMap<User, ArrayList<Message>> usrMsgList;
	
	public TwotterSystem()
	{
		usrMsgList = new HashMap<>();
	}
	
	public void addMessage(User u, Message m)
	{
		ArrayList<Message> temp;
		
		if(usrMsgList.containsKey(u))
		{
			temp = usrMsgList.get(u);
			temp.add(m);
		}
		else
		{
			temp = new ArrayList<Message>();
			temp.add(m);
			usrMsgList.put(u, temp);
		}
	}
	
	public List<Message> getAllMessages()
	{
		ArrayList<Message> msgList = new ArrayList<Message>();
		ArrayList<Message> temp = new ArrayList<Message>();
		
		for(Map.Entry<User, ArrayList<Message>> entry : usrMsgList.entrySet())
		{
			temp = entry.getValue();
			
			for(Message m : temp)
			{
				msgList.add(m);
			}
		}
		
		return msgList;
	}
	
	public List<Message> getAllMessagesFromDate(String date)
	{
		ArrayList<Message> msgList = new ArrayList<Message>();
		ArrayList<Message> temp = new ArrayList<Message>();
		
		for(Map.Entry<User, ArrayList<Message>> entry : usrMsgList.entrySet())
		{
			temp = entry.getValue();
			
			for(Message m : temp)
			{
				if(m.getCreationDate().contentEquals(date))
					msgList.add(m);
			}
		}
		
		return msgList;
	}
	
	public List<Message> getAllMessagesFromUser(User u)
	{
		ArrayList<Message> msgList = new ArrayList<Message>();
		if(usrMsgList.containsKey(u))
		{
			return usrMsgList.get(u);
		}
		
		return null;ö
	}
}
