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
		
		for(int i = 0; i < partCount; i++){
			parties[i] = new Party(Phrase.PARTY.get(),issues, this);
		}	
				
	}
	
	public Party runElection(){ //runs an election, selects winner;

		ArrayList<Party> votes = new ArrayList<Party>();
		
		for(Voter x : populace){
			votes.add(x.vote());
		}
		
		
		HashMap<Party,Integer> results = new HashMap<Party,Integer>();
		
		for(Party s: votes) { //populates HashMap 
			Integer c = occurences.get(s); //how many times has the word been seen before?
			if(c == null) c = new Integer(0); //if zero, avoids null case
			c++; //adds to the total
			occurences.put(s,c); //maps it.
		}
		
		
		Integer a = new Integer(population); //starts with total words in book
		
		while(!occurences.containsValue(a)){ //finds the most common words
			a--;
		}
		
		ArrayList<String> uniqa = new ArrayList<String>(); //ARRAYLIST OF STRINGS 
		while(a > -1){  
			for(String x: book){ 
				if(occurences.get(x).equals(a) && occurences.get(x) > .05 * population ){
					uniqa.add(x);
				}
			}
			a--;
		}
		
		previousElectionResults = occurences;
		viable = uniqa.toArray(new Party[0]);
		
		
	}
	
}