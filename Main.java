import java.util.*;

public class Main {

    public static boolean debug = false;
    
    public static void main(String[] args) {
        int numberOfDisks = 18;
	TowersField field = new TowersField(3, numberOfDisks);
	
	if (debug) {
	    System.out.println("DEBUG, number of towers: " + field.size());
	}
	
	System.out.println(field);
	
	field.moveDisks(1, numberOfDisks,
	   field.getByIdentifier(1), field.getByIdentifier(3));
        
	System.out.println(field);
    }

}
