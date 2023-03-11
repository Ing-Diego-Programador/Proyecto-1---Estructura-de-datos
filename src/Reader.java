/**
 * Clase Reder que lee el archivo de texto y lo mete al vector.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

public class Reader {

    Vector <String> v = new Vector<String>();

    public void Cargar() {  
        try{
            FileReader r = new FileReader("EditorDeTexto.txt");
            BufferedReader buffer = new BufferedReader(r);
            String temp ="";

            while(temp!=null){
                temp = buffer.readLine();
                if(temp == null){
                    break;
                }
                v.add(temp);
            }
        }catch(Exception e){System.out.println("archivo no encontrado");}
    } 
}
