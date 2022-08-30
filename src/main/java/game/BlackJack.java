package game;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BlackJack
{
	private final PrintStream out;
	private final Scanner scanner;
	
	public static void main(String args[])
	{
		BlackJack game=new BlackJack(System.in,System.out);
		game.startGame(21);
		
	}
	
	public BlackJack(InputStream in,PrintStream out)
	{
		this.scanner=new Scanner(in);
		this.out=out;
		
		
	}
	
	public void startGame(int maxTotal) {
		
		try {
		
			LinkedHashMap<String, List<String>> playersInfo=initialize();
			boolean repeat=true;
			for (Map.Entry<String, List<String>> set : playersInfo.entrySet())    
			{
				repeat=true;
				playersInfo.get(set.getKey()).add(getRandomNumber());
				while (repeat) {
				System.out.println("Dealing to " + set.getKey());
				playersInfo.get(set.getKey()).stream().forEach(k-> {
					System.out.println(k.split("#")[0] + " " + k.split("#")[1]);
				});
				//System.out.println("Hit or Stand ? " );
				String question=getInputForString("Hit or Stand ? ");
				System.out.println("Hit or Stand ? " + question);
				if (question.equalsIgnoreCase("hit"))
				{
					playersInfo.get(set.getKey()).add(getRandomNumber());
					continue;
				}
				else
				{
					break;
				}
				}
			}
			
			scoring(playersInfo,maxTotal);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public String getInputForString(String message)
	{
		out.println(message);
		return this.scanner.next();
	}
	
	public int getInputForInt(String message)
	{
		out.println(message);
		return this.scanner.nextInt();
	}
	
	
	public LinkedHashMap<String, List<String>> initialize()
	{
		
		LinkedHashMap<String,List<String>> playersInfo=new LinkedHashMap<String,List<String>>();
		
		//System.out.print("How Many Players are Playing : " );
		int totalPlayers=getInputForInt("How Many Players are Playing: ");
		System.out.println("Starting Game with : " + totalPlayers + "  Players");
		for(int i=0;i<totalPlayers;i++)
		{
			playersInfo.put("Player-" + (i+1), new ArrayList<String>());
		}
		playersInfo.put("Computer", new ArrayList<String>());
		
		for(int i=0;i<totalPlayers;i++)
		{
			playersInfo.get("Player-" + (i+1)).add(getRandomNumber());
			System.out.println("Dealing to " + "Player-" + (i+1) + " with " + playersInfo.get("Player-" + (i+1)).get(0).split("#")[0] + " " + playersInfo.get("Player-" + (i+1)).get(0).split("#")[1]);
		}
		playersInfo.get("Computer").add(getRandomNumber());
		System.out.println("Dealing to computer, card : facedown");
		return playersInfo;
		
	}
	
	
	
	public void scoring(LinkedHashMap<String, List<String>> playersInfo,int maxTotal)
	{
		
		System.out.println("<<<<<<<<<< Scoring >>>>>>>>");
		String result="";;
		int dealer=getValueFromMap(playersInfo.get("Computer"));
		
		if (dealer>0) 
		{
	
			for (Map.Entry<String, List<String>> players : playersInfo.entrySet())    
			{
				int participantValue=getValueFromMap(players.getValue());
				if (((participantValue<=maxTotal && participantValue>dealer) )|| (dealer>maxTotal))
				{
					result=players.getKey() + " Wins";
				}
				else if (((participantValue<=maxTotal && dealer<=maxTotal && dealer>participantValue)) || (participantValue>maxTotal))
				{
					result="Computer Wins";
				}
				else if  ((participantValue==maxTotal && dealer==maxTotal) || (participantValue==dealer))
				{
					result=players.getKey() + " and Computer Wins";
				}
					if (participantValue>maxTotal) System.out.println(players.getKey() + " is Busted ");
				
					if (!players.getKey().equalsIgnoreCase("Computer"))
						System.out.println(players.getKey() + " has --> "+ participantValue + "--and Computer has ->" + dealer + "   " + result);
			}
		}
		else {
			System.out.println("Dealer is Missing");
		}
		
	}
	
	
	public String getRandomCard(int randomNumber)
	{
		Random rand = new Random();
	    List<String> givenList = Arrays.asList("Heart", "Spades", "Clubs", "Diamond");
	        int randomIndex = rand.nextInt(givenList.size());
	        String randomElement = givenList.get(randomIndex);
	        if (randomNumber<=10) 
	        	return randomElement;
	        else if (randomNumber==11)
	        	return "Jack";
	        else if (randomNumber==12)
	        	return "Queen";
	        else if (randomNumber==13)
	        	return "King";
	        
	     return null;   
	}
	
	public String getRandomNumber()
	{
		Random rand = new Random();
		int val=rand.nextInt(11) + 1;
		return val + "#" + getRandomCard(val);
	}
	
	public int getValueFromMap(List<String> data)
	{
		int sum=0;
	
		if (data!=null) 
		{
			for(String cardValue : data)
			{
			    sum=sum + Integer.parseInt(cardValue.split("#")[0]);
			}
		}	
		return sum;
		
	}	
}
