import junit.framework.TestCase;

import java.io.FileNotFoundException;

public class InterpreteTest extends TestCase {

    InterpreteTest t=new InterpreteTest();


    public void testCalcular() throws FileNotFoundException {
        String a="(defun prueba (t) (+ t t))";
        t.operar(a);
        assertEquals(" 1000.0",t.calcular(t.regresarArray()));
    }


}
