package frogger;

/**
 * Refactor Task 1 & 2: Frogger
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22), Duan Liang (F23)
 */
public class Frogger {

    // Field for task 1.
    private final Road road;
    private int position;
    
    // Field for task 2. Anything to add/change?
    private final Records records;
    //private String firstName, lastName, phoneNumber, zipCode, state, gender;
    private FroggerID id_info;

    public Frogger(Road road, int position, Records records, String firstName, String lastName, String phoneNumber,
    String zipCode, String state, String gender) {
        this.road = road;
        this.position = position;
        this.records = records;
        /*
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
        this.state = state;
        this.gender = gender;
         */
        this.id_info =new FroggerID(firstName, lastName, phoneNumber, zipCode, state, gender);
    }

    /**
     * Moves Frogger.
     *
     * @param forward true is move forward, else false.
     * @return true if move successful, else false.
     */
    public boolean move(boolean forward) {
        int nextPosition = this.position + (forward ? 1 : -1);
        //if (!isValid(nextPosition) || isOccupied(nextPosition)) {
        if (!this.road.canMove(nextPosition)) {
            return false;
        }
        this.road.makeUnOccupied(position);
        this.position = nextPosition;
        this.road.makeOccupied(position);
        return true;
    }

    // TODO: Do you notice any issues here?
    //information expert - Frogger is getting extra information to complete the task.
    //and it doesn't change the occupation back to unoccupied when frogger leaves the block
    //Fix: move the method to class that has the information.
    /*
    public boolean isOccupied(int position) {
        boolean[] occupied = this.road.getOccupied();
        return occupied[position];
    }
    
    public boolean isValid(int position) {
        if (position < 0) return false;
        boolean[] occupied = this.road.getOccupied();
        return position < occupied.length;
    }
    */

    /**
     * Records Frogger to the list of records.
     * 
     * @return true if record successful, else false.
     */
    public boolean recordMyself() {
      //Problem: Long parameter list: a long list of parameters provided to a method.
      //Fix: make use of FroggerID class
      //boolean success = records.addRecord(firstName, lastName, phoneNumber, zipCode, state, gender);
      boolean success = records.addRecord(this.id_info);
      return success;
    }

}
