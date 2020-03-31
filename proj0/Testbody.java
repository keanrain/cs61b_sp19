/**
 *  Tests Body
 */
public class Testbody {

    /**
     *  Tests calcForceExertedBy.
     */
    public static void main(String[] args) {
        checkCalcForceExertedBy();
    }

    /**
     *  Checks the Body class to make sure calcForceExertedBy works.
     */
    private static void checkCalcForceExertedBy() {
        System.out.println("Checking calcForceExertedBy...");

        Body b1 = new Body(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Body b2 = new Body(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");
        System.out.println(b1.calcForceExertedBy(b2));
        
    }
}