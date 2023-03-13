/**
 * Clase interprete que interpreta la sintaxis de las op. Interpreta la instruccion conociendo la
 * posicion del caracter y el resultado de la operación.
 */

import java.util.ArrayList;

public class Interprete {

    Calculadora cal=new Calculadora();
    ArrayList<Character> op=new ArrayList<Character>();
    ArrayList<String> op2=new ArrayList<String>();
    ArrayList<String> vf=new ArrayList<String>();
    String p1=")";
    String p2="(";
    char p3='(';
    char p4=')';

    // Se interpreta el string con instrucciones en LISP.
    public int contarcaracteres(String cadena, char caracter) {
        int posicion, contador = 0;
        posicion = cadena.indexOf(caracter);
        while (posicion != -1) {
            contador++;
            posicion = cadena.indexOf(caracter, posicion + 1);
        }
        return contador;
    }

    //Operación a partir de la string.
    public void operar(String codigo){
        int c1=contarcaracteres(codigo,p3);
        int c2=contarcaracteres(codigo,p4);
        StringBuilder palabara1= new StringBuilder(codigo);
        if(c1==c2){
            for(int i=0;i<c1;i++){

                int num4=palabara1.lastIndexOf(p2);
                int num3=palabara1.indexOf(p1,num4);
                String x=palabara1.substring(num4,num3);
                palabara1.delete(num4,num3);
                op2.add(x);
            }
        }else{
            System.out.println("Existe un error de sintaxis");
        }
        op2.add("");
    }

    // Se toma el arraylist y se revuelve el resultado de la operación.
    public String calcular(ArrayList<String> lista){
        String resultado="";
        ArrayList<String> resul=new ArrayList<>();
        int c=lista.size();
        for(int i =0;i<c;i++){
            if(lista.get(i).equals("nulo")){
                break;
            }else{
                if(lista.get(i).contains("(")){
                    String h=cal.Calculo(lista.get(i));

                    String concatenado=lista.get(i+1)+" "+h;
                    lista.remove(i+1);
                    lista.add(i+1,concatenado);    
                }
            }
        }
        return lista.get(lista.size()-1) ;
    }

    //Retornar la operacion.
    public  ArrayList<String> regresarArray(){
        return op2;
    }

    //Limpiar las op.
    public void limpiando (){
        op2.clear();
    }

}
