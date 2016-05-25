import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

public class Elections{
	
	public static int POPULATION;
	public static int PARTYCOUNT;
	public static int ISSUECOUNT;
	public static final Random SUPER_SUPER_RAND = new Random();
	public static final long SEED = SUPER_SUPER_RAND.nextLong();
	public static final Random SUPER_RAND = new Random(SEED);
	
	public static int REIGN = 0;
	public static Party LASTWINNER = null;
	public static final Party[] typecast = new Party[0];
	
	
	public static void main(String[]arg){
		
		System.out.println(SEED);
		
		
		POPULATION = Integer.parseInt(arg[0]);
		PARTYCOUNT = Integer.parseInt(arg[1]);
		ISSUECOUNT = Integer.parseInt(arg[2]);
		
		Nation natl = new Nation(POPULATION, PARTYCOUNT, ISSUECOUNT);
		
		
		while((natl.viable == null || natl.viable.length > 1) && REIGN < 5){
			int totVotes = 0;
			Party winner = natl.runElection();
			if(winner == LASTWINNER) REIGN++;
			LASTWINNER = winner;
			
			System.out.println(natl.viable.length );
			int counterint = 0;
			for(Party x : natl.parties){
				
				int votes =  (natl.previousElectionResults.get(x) == null) ? 0 : natl.previousElectionResults.get(x); 
				System.out.println(x.toString() + " with " + votes + " votes and an average score of" + natl.partyScores[counterint]/POPULATION);
				totVotes = totVotes + votes;
				counterint = counterint + 1;
			}
			System.out.println(winner.toString() + " WINS with " + natl.previousElectionResults.get(winner) + " votes");
			System.out.println(totVotes + " Total Votes");
			System.out.println("");
			
		}
		
		
		
		
		
		
		
		
	}
	
	
}