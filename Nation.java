public class Nation{
	
	public Voter[] populace;
	public Party[] parties;
	public Issue[] issues;
	
	public Nation(int population, int partyCount, int issueCount){
		this.populace = new Voter[population];
		this.parties = new Party[partyCount];
		this.issues = new Issue[issueCount];
		
		for(int i = 0; i < issueCount; i++){
			issues[i] = new Issue();
		}
		
		for(int i = 0; i < population; i++){
			populace[i] = new Voter();
		}
		
		for(int i = 0; i < partCount; i++){
			parties[i] = new Party();
		}	
				
	}
	
}