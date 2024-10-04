package frogger;

/**
 * Refactor Task 1.
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public class Road {
    private final boolean[] occupied;

    public Road(boolean[] occupied) {
        this.occupied = occupied;
    }

    public boolean[] getOccupied() {
        return this.occupied;
    }

    public boolean canMove(int position){
        if(occupied.length > position){
            if(!occupied[position]){
                return true;
            }
        }
        return false;
    }

    public void makeOccupied(int position){
        occupied[position] = true;
    }

    public void makeUnOccupied(int position){
        occupied[position] = false;
    }
}
