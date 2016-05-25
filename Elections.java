import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

public class Elections{
	
	public static int POPULATION;
	public static int PARTYCOUNT;
	public static int ISSUECOUNT;
	
	
	public static final Party[] typecast = new Party[0];
	
	
	public static void main(String[]arg){
		
		POPULATION = Integer.parseInt(arg[0]);
		PARTYCOUNT = Integer.parseInt(arg[1]);
		ISSUECOUNT = Integer.parseInt(arg[2]);
		
		Nation natl = new Nation(POPULATION, PARTYCOUNT, ISSUECOUNT);
		
		
		
		while(natl.viable == null || natl.viable.length > 1){
			int totVotes = 0;
			Party winner = natl.runElection();
			System.out.println(natl.viable.length );
			for(Party x : natl.parties){
				int votes =  (natl.previousElectionResults.get(x) == null) ? 0 : natl.previousElectionResults.get(x); 
				System.out.println(x.toString() + " with " + votes + " votes ");
				totVotes = totVotes + votes;
			}
			System.out.println(winner.toString() + " WINS with " + natl.previousElectionResults.get(winner) + " votes");
			System.out.println(totVotes + " Total Votes");
			System.out.println("");
			
		}
		
		
		
		
		
		
		
		
	}
	
	
}