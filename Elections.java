import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

public class Elections{
	
	public static int POPULATION;
	public static int PARTYCOUNT;
	public static int ISSUECOUNT;
	
	
	public static void main(String[]arg){
		
		POPULATION = Integer.parseInt(arg[0]);
		PARTYCOUNT = Integer.parseInt(arg[1]);
		ISSUECOUNT = Integer.parseInt(arg[2]);
		
		Nation natl = new Nation(POPULATION, PARTYCOUNT, ISSUECOUNT);
		
		
		while(natl.viable == null || natl.viable.length > 1){
			
			Party winner = natl.runElection();
			System.out.println(natl.viable.length);
			System.out.println(winner.toString());
			
		}
		
		
		
		
		
		
		
		
	}
	
	
}