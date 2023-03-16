import junit.framework.TestCase;

public class ContitionTest extends TestCase {
    ContitionTest c=new ContitionTest();
    public void testCalculo() {
        assertEquals(false,c.Calculo("( = 1 2)"));
    }
}
