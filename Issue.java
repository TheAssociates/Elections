public class Issue{
	
	public String name; //randomly generated name of an issue
	
	public Issue(){
		this.name = Phrase.INGVERB.get() + " " + Phrase.PLURAL.get();
	}
	
}