import org.junit.Test;
import static org.junit.Assert.*;

public class FlkTest {
    @Test
    public void testIsSameNumber(){
        int a = 128;
        int b = 128;
        int c = 500;
        assertTrue(Flik.isSameNumber(a, b));
    }
}
