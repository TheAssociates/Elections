public class Voter extends Entity{
	
	public Party vote() {
		double maxScore = 0;
		double maxParty = 0;
		
		for(int i = 0; i < this.nation.parties.length; i++) {
			if (score(this.nation.parties[i]) > maxScore) {
				maxScore = score(this.nation.parties[i]);
				maxParty = this.nation.parties[i];
			}
		}
		return maxParty;
	}
	
	public double score(Party party) {
		double score = 0;
		double allallign = 0;
		double avgAllign = 0;
		double penalty = 0;
		double allign = 0;
		double natVote = 0;
		
		for (int i = 0; i < this.views.size(); i++) {
			allign = 0;
			allign = ((this.views.get(i).value - party.views.get(i).value)*(this.views.get(i).importance / 50));
			allAllign += allign;
			if (allign > 75) {
				penalty -= 10;
			} else if (allign > 100) {
				penalty -= 25;
			} else if (allign > 125) {
				penalty -= 50;
			} else if (allign > 199) {
				penalty -= 200;
			}
			avgAllign = allAllign/this.views.size();
		}
		
		Random rand = new Random();
		double whim = random(rand, 70, 100)/10;
		
		if (this.nation.previousElectionResults == null) {
			natVote = 1;
		}
		
		score = whim*natVote*(avgAllign-penalty);
		return score;
	}
}