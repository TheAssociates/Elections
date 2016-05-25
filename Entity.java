import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

public class Entity{

	public String name; 
	public ArrayList<Opinion> views; //a list of opinions
	public Nation nation;
	private final long id;
	
	public Entity (String name, Issue[] views, Nation nation) {
		this.name = name;
		this.nation = nation;
		this.views = new ArrayList<Opinion>();
		for (int i = 0; i < views.length; i++) {
			this.views.add(new Opinion(views[i], random(Elections.SUPER_RAND, -100, 100), random(Elections.SUPER_RAND, 1, 100)));
		}
		this.id = Elections.SUPER_RAND.nextLong();
	}
	
	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}
	
	public String toString(){
		return name;
	}
	
	public boolean equals(Object o){
		return(this.id == ( (Entity) o).id );
	}
	
	
}