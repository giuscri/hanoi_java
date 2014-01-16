public class Disk {

    public Disk(int index) {
        this.index = index;
    }
    
    public int getIndex() {
        return index;
    }
    
    public String toString() {
        return new String("Disk #" + index);
    }
    
    private int index;

}
