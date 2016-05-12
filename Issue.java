import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

public class Issue{
	
	public String name; //randomly generated name of an issue
	
	public Issue(){
		this.name = Phrase.INGVERB.get() + " " + Phrase.PLURAL.get();
	}
	
}