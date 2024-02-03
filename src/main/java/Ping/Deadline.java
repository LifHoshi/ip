//// Solution below adapted by week2 iP Level-3 Partial solution
package Ping;
import java.time.LocalDate;

/**
 * This class is used to create a deadline task
 */
public class Deadline extends Task {
    protected LocalDate by;

    /**
     * This is the constructor of the Deadline class
     * @param destription the description of the deadline task
     * @param by the date of the deadline task
     */
    public Deadline(String destription, LocalDate by) {
        super(destription);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + this.by + ")";
    }
}
