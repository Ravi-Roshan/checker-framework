import org.checkerframework.checker.lock.qual.*;

public class Constructors {

    Object unlocked;
    @GuardedBy("this") Object guardedThis;
    @GuardedBy("unlocked") Object guardedOther;

    // Constructors are synchronized over this
    Constructors() {
        unlocked = "m";
        guardedThis = "m";
        //:: error: (contracts.precondition.not.satisfied.field)
        guardedOther = "m"; //error
    }
}
