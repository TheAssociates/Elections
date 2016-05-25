import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

public class Voter extends Entity{
	
	public Voter(String name, Issue[] views, Nation nation) {
		super(name, views, nation);
	}
	
	public Party vote() {
		double maxScore = -1*Double.MAX_VALUE;
		Party maxParty = null;
		
		for(int i = 0; i < this.nation.parties.length; i++) {
			double score = score(this.nation.parties[i]);
			nation.partyScores[i] = nation.partyScores[i] + score;
			
			if ( score > maxScore) {
				maxScore = score;
				maxParty = this.nation.parties[i];
			}
		}
		return maxParty;
	}
	
	public double score(Party party) {
		double score = 0;
		double allAllign = 0;
		double avgAllign = 0;
		double penalty = 0;
		double allign = 0;
		double natVote = 0;
		
		
		for (int i = 0; i < this.views.size(); i++) {
			allign = 0;
			allign = Math.abs(((this.views.get(i).value - party.views.get(i).value)*((this.views.get(i).importance * 1.0) / 50)));
			allAllign += allign;
			if (allign > 75) {
				penalty -= 10;
			} if (allign > 100) {
				penalty -= 25;
			} if (allign > 125) {
				penalty -= 50;
			} if (allign > 199) {
				penalty -= 200;
			}
		}
		avgAllign = allAllign/this.views.size();
		
		double whim = random(Elections.SUPER_RAND, Elections.WHIM_MIN, Elections.WHIM_MAX)/100;
		
		if (this.nation.previousElectionResults == null) {
			natVote = 1;
		} else {
			natVote = this.nation.previousElectionResults.get(party);
		}
		
		double fingerTax = 1;
		if (Elections.LASTWINNER == party) {
			fingerTax = 1 - Elections.FINGERTAX*Elections.REIGN;
		}
		
		
		score = (fingerTax*(whim*((400-avgAllign)+penalty)*(natVote + (this.nation.populace.length / 2))));
		
		if (natVote/this.nation.populace.length < Elections.VIABILITY) {
			score = score*Elections.POORTAX;
		}
		
		return score;
	}
}