import junit.framework.TestCase;

public class C2Test extends TestCase {
    C2Test c=new C2Test();

    public void testRegresarArray() {
        String h="(cond (( = 1 1) + 3 4 5 ) (t ( * n ( facial ( n-1))))) ";
        c.setarrays(h);
        assertEquals("( + 3 4 5 ",c.regresarcodigo());
    }


}
