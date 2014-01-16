import java.util.*;

public class Tower extends Stack<Disk> {
    public static boolean debug = false;
    
    public Tower(int identifier) {
        this.identifier = identifier;
	counter++;
    }
    
    public Tower() {
        this(counter);
    }
    
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    public Disk push(Disk d) throws RuntimeException {
        if (isEmpty()) {
	    super.push(d);
	    return d;
	}
	
	if (d.getIndex() >= this.peek().getIndex())
	    throw new RuntimeException("d.getIndex() < this.peek().getIndex() "
	                                  + d.getIndex() + " < "
					  + this.peek().getIndex());
					  
	super.push(d);
	return d;
    }
    
    public int getIdentifier() {
        return this.identifier;
    }
    
    public boolean equals(Tower other) {
        return this.identifier == other.getIdentifier();
    }
    
    private int identifier;
    
    static private int counter = 0;
}
