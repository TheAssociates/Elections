import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

public class Opinion{
	
	public Issue issue; //the issue one has an opinion on
	public int value; //between -100 and 100 , one's stance on an issue
	public int importance; //between 0 and 100, how much one gives a fuck
	
	public Opinion(Issue iss, int val, int imp){
		this.issue = iss;
		this.value = val;
		this.importance = imp;
	}
}