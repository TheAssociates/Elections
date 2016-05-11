public class Entity{

	public String name; 
	public ArrayList<Opinion> views; //a list of opinions
	
	public Entity (String name, ArrayList<Opinion> views) {
		this.name = name;
		this.views = views;
		for (int i = 0; i < this.views.size(); i++) {
			
		}
	}
	
	public static int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}
}