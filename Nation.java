import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

public class Nation{
	
	public String name;
	
	public Voter[] populace;
	public Party[] parties;
	public Issue[] issues;
	
	public HashMap<Party,Integer> previousElectionResults = null;
	public Party[] viable;
	
	public Nation(int population, int partyCount, int issueCount){
		this.name = Phrase.COUNTRY.get();
		this.populace = new Voter[population];
		this.parties = new Party[partyCount];
		this.issues = new Issue[issueCount];
		
		for(int i = 0; i < issueCount; i++){
			issues[i] = new Issue();
		}
		
		for(int i = 0; i < population; i++){
			populace[i] = new Voter(Phrase.genName(),issues, this);
		}
		
		for(int i = 0; i < partyCount; i++){
			parties[i] = new Party(Phrase.PARTY.get(),issues, this);
		}	
				
	}
	
	public Party runElection(){ //runs an election, selects winner;

		
		Set<Party> partySet = new TreeSet<Party>();
		
		for(Voter x : populace){
			Party temp = x.vote();
			temp.recieveVote();
			partySet.add(temp);
		}
		
		
		
		previousElectionResults = new HashMap<Party,Integer>();
		for(Party x : partySet){
			previousElectionResults.put(x,new Integer(x.VotesForMe));
		}
		
		int tt = 0;
		
		do{
			
		} while 
		
		
		
		
		
	}
	
}