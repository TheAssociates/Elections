import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

public class Elections{

	public static final Random SUPER_SUPER_RAND = new Random();
	public static final long SEED = SUPER_SUPER_RAND.nextLong();
	public static final Random SUPER_RAND = new Random(SEED);

	
	public static final double VIABILITY = 0.05;
	public static final double POORTAX = -10000000;
	public static final double FINGERTAX = 0.05;
	public static final int WHIM_MIN = 80;
	public static final int WHIM_MAX = 120;
	
	
	
	public static int POPULATION;
	public static int PARTYCOUNT;
	public static int ISSUECOUNT;

	public static int IMPORTANTRUN = 30;
	public static int IMPORTANTINT = 1;
	public static int REIGN = 0;
	public static Party LASTWINNER = null;
	public static final Party[] typecast = new Party[0];
	
	
	
	
	
	//SUPER_SUPER_RAND.nextLong();
	
	public static void main(String[]arg) throws IOException {
		
		System.out.println(SEED);
		
		
		POPULATION = Integer.parseInt(arg[0]);
		PARTYCOUNT = Integer.parseInt(arg[1]);
		ISSUECOUNT = Integer.parseInt(arg[2]);
		
		Nation natl = new Nation(POPULATION, PARTYCOUNT, ISSUECOUNT);
		
		int electionCounter = 0;
		
		while((natl.viable == null || natl.viable.length > 1) && REIGN < 10 && electionCounter < IMPORTANTRUN){
			int totVotes = 0;
			electionCounter++;
			Party winner = natl.runElection(electionCounter);
			if(winner == LASTWINNER) REIGN++;
			else REIGN = 0;
			LASTWINNER = winner;
			
			System.out.println(natl.viable.length );
			int counterint = 0;
			for(Party x : natl.parties){
				
				int votes =  (natl.previousElectionResults.get(x) == null) ? 0 : natl.previousElectionResults.get(x); 
				System.out.println(x.toString() + " with " + votes + " votes");// and an average score of " + natl.partyScores[counterint]/natl.previousElectionResults.get(x));
				totVotes = totVotes + votes;
				counterint = counterint + 1;
				if (votes == 100) {break;}
				if (natl.parties.length == 2) {break;}
			}
			System.out.println(winner.toString() + " WINS with " + natl.previousElectionResults.get(winner) + " votes");
			System.out.println(totVotes + " Total Votes");
			natl.partyScores = new double[PARTYCOUNT];
			System.out.println(electionCounter);
			System.out.println("");
			System.in.read();
		}
		
		
		
		
		
		
		
		
	}
	
	
}