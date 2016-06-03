import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

public class Nation{
	
	public String name;
	
	public Voter[] populace;
	public Party[] parties;
	public double[] partyScores; 
	public Issue[] issues;
	public TreeSet<Party> partySet;
	
	public HashMap<Party,Integer> previousElectionResults = null;
	public Party[] viable;
	
	public Nation(int population, int partyCount, int issueCount){
		this.name = Phrase.COUNTRY.get();
		this.populace = new Voter[population];
		this.parties = new Party[partyCount];
		this.partyScores = new double[partyCount]; 
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
	
	
	public boolean arrContain(Party[] arr, Party party) {
		for (Party x : arr) {
			if (x == party) {
				return true;
			}
		}
		return false;
	}
	
	public int retMax(Party[] arr) {
		int maxVotes = 0;
		int retLoc = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].VotesForMe > maxVotes) {
				maxVotes = arr[i].VotesForMe;
				retLoc = i;
			}
		}
		return retLoc;
	}
	
	public int retLast(Party[] arr) {
		int minVotes = Elections.POPULATION;
		int retLoc = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].VotesForMe < minVotes) {
				minVotes = arr[i].VotesForMe;
				retLoc = i;
			}
		}
		return retLoc;
	}
	
	public int retSec(Party[] arr) {
		int secVotes = 0;
		int retLoc = 0;
		int max = retMax(arr);
		for (int i = 0; i < arr.length; i++) {
			if (i != max && arr[i].VotesForMe > secVotes) {
				secVotes = arr[i].VotesForMe;
				retLoc = i;
			}
		}
		return retLoc;
	}
	
	public Party[] arrRemove(Party[] arr, int loc) {
		Party[] result = new Party[arr.length - 1];
		for (int i = 0; i < arr.length; i++) {
			if (i != loc && i < loc) {
				result[i] = arr[i];
			} else if(i != loc && i > loc) {
				result[i-1] = arr[i];
			}
		}
		return result;
	}
	
	
	public Party runElection(int important){ //runs an election, selects winner;

		
		partySet = new TreeSet<Party>();
		
		for(Voter x : populace){
			Party temp = x.vote();
			temp.recieveVote();
		}
		
		for(Party x : parties){
			partySet.add(x);
		}
		
		if (Elections.IMPORTANTINT == 1 && important > 3) {
			switch (important%3) {
				case 0: Party[] temp = new Party[parties.length - 1];
						temp = arrRemove(parties, retLast(parties));
						int temp1 = parties[retMax(parties)].VotesForMe;
						int temp2 = parties[retSec(parties)].VotesForMe;
						parties[retMax(parties)].forget();
						parties[retSec(parties)].forget();
						for (int i = 0; i < temp1; i++) {
							parties[retSec(parties)].recieveVote();
						}
						for (int i = 0; i < temp2; i++) {
							parties[retMax(parties)].recieveVote();
						}
						
						int size = parties.length;
						parties = new Party[size - 1];
						parties = temp; break;
			case 1: for (int i = 0; i < parties[retLast(parties)].VotesForMe; i++) {
						parties[retSec(parties)].recieveVote();
					}
					parties[retLast(parties)].forget(); break;
			case 2:
			default: for (int i = 0; i < parties[retLast(parties)].VotesForMe; i++) {
						parties[retMax(parties)].recieveVote();
					}
					parties[retLast(parties)].forget(); break;
			}
		}
		
		previousElectionResults = new HashMap<Party,Integer>();
		for(Party x : parties){
			previousElectionResults.put(x,new Integer(x.VotesForMe));
		}
	
		
		while((partySet.size() != 0) && (partySet.first().VotesForMe < populace.length * Elections.VIABILITY)){
			partySet.pollFirst();
		}
		
		viable = partySet.descendingSet().toArray(Elections.typecast);
		
		for(Party x : parties){
			x.forget();
		}

		return partySet.last();
		
		
		
	}
	
}