import java.util.Scanner; 
import java.util.*; 
import java.io.*;



public enum Phrase { //allows for the easy generation of names
	
	//lists the type of word and the filepath to the wordlist
	ADJECTIVE ("/WordList\\adjectives.txt"),
	NOUN ("/WordList\\nouns.txt"),
	ADVERB ("/WordList\\adverbs.txt"),
	VERB ("/WordList\\verbs.txt"),
	INGVERB ("/WordList\\ingverbs.txt"),
	MALENAME ("/WordList\\namesMale.txt"),
	FEMALENAME ("/WordList\\namesFemale.txt"),
	NAME ("/WordList\\names.txt"),
	SURNAME ("/WordList\\surnames.txt"),
	TITLE ("/WordList\\titles.txt"),
	LETTER ("/WordList\\letters.txt"),
	PLURAL ("/WordList\\plurals.txt"),
	COUNTRY ("/WordList\\countries.txt");
	
	private String fpath;
	private Scanner list;
	private Random rand;
	private int num;
	
	Phrase(String fipath) { //real simple, gets the path for each
		this.fpath = fipath;
		this.rand = new Random();
		
		Scanner list = new Scanner(Phrase.class.getResourceAsStream(fpath), "UTF-8");
		try{
			this.num = wordCount(list);
		} catch(FileNotFoundException g){
			
		}
		
		
	}
	
	public String get() { //get a random word from the given list
		return nthString(random(rand,0,num-1));
	}
	
	public String get(String imp, double chance,String end){ //has a chance of returning the leading string, tailing string, and PHRASE type
		if(rand.nextFloat() < chance){
			try{
				imp = imp + nthString(random(rand,0,num)) + end;
				return imp;
			} catch(NoSuchElementException g){
				return "";
			}
			
		}
		return "";	
	}
	
	
	public String nthString(int n, File f){ //gets the nth String in a file
		try{
			Scanner console = new Scanner(f);
		for(int i = 0; i < n; i++ ){
			console.next();
		}
		return console.next();
		} catch (NoSuchElementException g){
			return "ERROR";
		} catch(FileNotFoundException h){
			return "ERROR";
		}
	}
	
	public String nthString(int n){ //gets the nth String in a file
		try{
			Scanner console = new Scanner(Phrase.class.getResourceAsStream(fpath), "UTF-8");
			for(int i = 0; i < n; i++ ){
				console.next();
			}
			return console.next();
		} catch (NoSuchElementException h){
			return "ERROR";
		}
		
		
		
	}
	
	public int wordCount(File f) throws FileNotFoundException{ //how many words?
		Scanner console = new Scanner(f);
		int out = 0;
		while(console.hasNext()){
			 console.next();
			 out++;
		}
		return out;
	}
	
	public int wordCount(Scanner console) throws FileNotFoundException{ //how many words?
		console.reset();
		int out = 0;
		while(console.hasNext()){
			 console.next();
			 out++;
		}
		return out;
	}
	
	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}
}
