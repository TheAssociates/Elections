import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

public class Party extends Entity implements Comparable{
	
	public int VotesForMe = 0;
	
	public Party(String name, Issue[] views, Nation nation) {
		super(name, views, nation);
	}
	
	public String toString(){
		return name;
	}
	
	public void recieveVote(){
		VotesForMe++;
	}
	
	public int compareTo(Object other){
		return this.VotesForMe - ((Party) other).VotesForMe;
	}
	
	public void forget(){
		VotesForMe = 0;
	}
	
}