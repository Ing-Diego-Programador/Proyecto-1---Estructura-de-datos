import junit.framework.TestCase;

public class CalculadoraTest extends TestCase {
    CalculadoraTest c=new CalculadoraTest();
    public void testCalculo() {
        assertEquals("2.0",c.Calculo("(+ 1 1)"));
    }
}