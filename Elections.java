import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

public class Elections{
	
	public static final int POPULATION;
	public static final int PARTYCOUNT;
	public static final int ISSUECOUNT;
	
	
	public static void main(String[]args){
		
		POPULATION = Integer.parseInt(arg[0]).intValue();
		PARTYCOUNT = Integer.parseInt(arg[1]).intValue();
		ISSUECOUNT = Integer.parseInt(arg[2]).intValue();
		
		Nation natl = new Nation(POPULATION, PARTYCOUNT, ISSUECOUNT);
		
		
		
		
		
		
	}
	
	
}