public class Entity{

	public String name; 
	public ArrayList<Opinion> views; //a list of opinions
	
	public Entity (String name, Issue[] views) {
		this.name = name;
		Random rand = new Random();
		for (int i = 0; i < views.length; i++) {
			this.views.add(new Opinion(views[i], random(rand, -100, 100), random(rand, 1, 100)));
		}
	}
	
	public static int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}
}