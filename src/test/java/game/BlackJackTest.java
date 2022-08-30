package game;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class BlackJackTest {
	BlackJack jack=null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test
	public void test() {
	
		
	}
	
	@Test()
	public void scoringWithDealerMissingTest()
	{
		LinkedHashMap<String, List<String>> playersInfo=new LinkedHashMap<String,List<String>>();
		playersInfo.put("Player-1", Arrays.asList("10#Diamond","5#Spades","6#Clubs"));
		playersInfo.put("Player-2", Arrays.asList("2#Diamond","5#Spades","6#Clubs"));
		BlackJack jack=new BlackJack(System.in,System.out);
		jack.scoring(playersInfo,21);
		
		
	}
	
	@Test()
	public void scoringTest()
	{
		LinkedHashMap<String, List<String>> playersInfo=new LinkedHashMap<String,List<String>>();
		playersInfo.put("Player-1", Arrays.asList("10#Diamond","5#Spades","6#Clubs"));
		playersInfo.put("Player-2", Arrays.asList("2#Diamond","5#Spades","6#Clubs"));
		playersInfo.put("Computer", Arrays.asList("2#Diamond","10#Spades","6#Clubs"));
		BlackJack jack=new BlackJack(System.in,System.out);
		jack.scoring(playersInfo,21);
		
		
	}
	
	@Test()
	public void InitializeTest()
	{
		LinkedHashMap<String, List<String>> playersInfo=new LinkedHashMap<String,List<String>>();
//		playersInfo.put("Player-1", Arrays.asList("10#Diamond","5#Spades","6#Clubs"));
//		playersInfo.put("Player-2", Arrays.asList("2#Diamond","5#Spades","6#Clubs"));
//		playersInfo.put("Computer", Arrays.asList("2#Diamond","10#Spades","6#Clubs"));
		
		//BlackJack jack=new BlackJack();
//		BlackJack jackmock=mock(BlackJack.class);
//		when(jackmock.getInputForInt("How Many Players are Playing: ")).thenReturn(3);
//		playersInfo=jack.initialize();
//		assertEquals(3, playersInfo.size());
		
		
	}
	
	

	
	
	

}
