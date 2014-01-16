import java.util.*;

public class TowersField extends Vector<Tower> {

    public static boolean debug = false;
    
    public TowersField(int numberOfTowers, int numberOfDisks) {
    
        for (int i = 0; i < numberOfTowers; i++) {
	    boolean feedback = this.add(new Tower(i+1));
	    
	    if (debug)
	        System.out.println("DEBUG, loaded new tower: " + feedback);
	}
	
	for (int i = numberOfDisks; i > 0; i--) {
	    this.firstElement().push(new Disk(i));
	    
	    if (debug)
	        System.out.println("DEBUG, loaded disk #" + i);
	}
    
    }
    
    public Tower getByIdentifier(int identifier) {
        for (Tower t : this)
	    if (t.getIdentifier() == identifier)
	        return t;
	return null;
    }

    public void moveDisks(int from, int to,
                             Tower startTower, Tower targetTower)
    {
        // if (from > to) throw ...
	
	Tower freeTower = null;
	
	for (Tower t : this)
	    if (t.getIdentifier() != startTower.getIdentifier()
	            && t.getIdentifier() != targetTower.getIdentifier())
            {
	        if (debug)
		    System.out.println("Found freeTower ...");
		    freeTower = t;
	    }
	    
	 if (to-from < 2) {
	     freeTower.push(startTower.pop());
	     if (debug)
	         System.out.println(this);
	     targetTower.push(startTower.pop());
	     if (debug)
	         System.out.println(this);
             targetTower.push(freeTower.pop());
	     if (debug)
	         System.out.println(this);
	     
	     return;
	 }
	 
	 if (startTower.equals(targetTower)) {
	     if (debug)
	         System.out.println("Movement not necessary.");
             return;
	 }
	 
	 if (debug) {
	     System.out.println("startTower: " + startTower.getIdentifier());
	     System.out.println("targetTower: " + targetTower.getIdentifier());
	     System.out.println("freeTower: " + freeTower.getIdentifier());
	 }
	 
	 // Moving to-1 disks from startTower
	 // to freeTower. Moving disk with largest
	 // index into targetTower; moving to-1 disks
	 // from freeTower to targetTower ...
	 moveDisks(from, to-1, startTower, freeTower);
	 targetTower.push(startTower.pop());
	 
	 if (debug)
	     System.out.println(this);
	     
	 moveDisks(from, to-1, freeTower, targetTower);
	 
	 if (debug)
	     System.out.println(this);
    }

}
