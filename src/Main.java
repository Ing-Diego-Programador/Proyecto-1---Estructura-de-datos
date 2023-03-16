/***
 * Diego Vásquez - 211628
 * Clase Main.
 */

//Importación de librerías.
import java.util.Scanner;
import java.io.*;
import java.util.Vector;

public class Main {
    public static  void main(String[] args){

        Cal2 esperanza = new Cal2();        
        Vector <String> varios = new Vector<String>();
        Scanner scan = new Scanner(System.in);

        //Reader del txt.
        try{
            FileReader r = new FileReader("../src/EditorDeTexto.txt");
            BufferedReader buffer = new BufferedReader(r);
            String temp ="";
            while(temp!=null){
                temp = buffer.readLine();
                if(temp == null){
                    break;
                }
                varios.add(temp);
            }
        }catch(Exception e){
            System.out.println("archivo no encontrado");
        }
        
        System.out.println("\nOperaciones archivo txt\n");
        for(int a =0;a<varios.size();a++){
            System.out.println(varios.get(a));
        }

        System.out.println("\nResultados txt\n");
        for(int a =0;a<varios.size();a++){
            System.out.println(" "+esperanza.Calculo(varios.get(a)));
        }

        
        String instruccion ="";
        System.out.println("\n--------------- INTERPRETE ---------------");

        boolean interprete = true;
        int numero = 0;
        while(interprete ==  true){
            numero++;
            System.out.print(" Instrucción: "+numero+" > ");
            instruccion = scan.nextLine();
            if (instruccion.equals("( exit )")||instruccion.equals("(exit)")) {
                interprete = false;
            }else{
                try{
                    System.out.println(" "+esperanza.Calculo(instruccion));
                    System.out.println();
                }catch(Exception e){
                    System.out.println(" Error");
                    System.out.println();
                }
                
            }
            

        }
    }

}
