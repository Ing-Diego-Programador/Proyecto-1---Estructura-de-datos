
import java.util.Scanner;
import java.io.*;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Collections;
public class Def{

    //propiedades necesarias para el funcionamiento.
    C2 c = new C2();
    Interprete t = new Interprete();
    ArrayList<Float> valores = new ArrayList<Float>();

    //Se retorna la recursividad.
    public String recursivo(String exp,String valor,String parametro,String nombre){
        String finale = "";
        boolean tipo = false;

        
        //condicion para el valor de 0 para evitar especificaciones en el cond
        if (exp.length()<63) {
            valores.add(2.0f);
            tipo = false;
        }else if (exp.length()>63) {
            valores.add(0.0f);
            tipo = true;
        }
        
        //empieza recursividad
        int actual = 1;
        String operacion = "";
        while(actual<=Integer.parseInt(valor)){
            //se instancian varias cadenas para reanudar el valor
            String[] paso = exp.split(" ");
            

            ArrayList<String> Cadena = new ArrayList<String>();
            for (int n = 0; n <paso.length; n++) { 
                Cadena.add(String.valueOf(paso[n]));
            }
            //Se sustituye el parametro por el valor evaluado actual
            for (int i = 0; i < Cadena.size(); i++){
                if(Cadena.get(i).equals(parametro)){
                    Cadena.set(i,actual+"");
                }
            }
            String valor_operar="";
            for (int i = 0;i<Cadena.size() ; i++) {
                valor_operar = valor_operar + Cadena.get(i)+" ";
            }
            

            c.setarrays(valor_operar);
            String paso_que_voy_ardiendo = c.regresarcodigo();
            String valoraso = c.regresarestado();

            /*Si la condicion da true se opera*/
            if(valoraso.equals("v")){
                t.operar(paso_que_voy_ardiendo);
                operacion = t.calcular(t.regresarArray());
                valores.add(Float.parseFloat(operacion));
                

            }

            else{
                //si la condicion es falsa paso_que_voy_ardiendo tiene que hacer otros procesos
                String signo = "";
                String posicion_1 = "";
                String posicion_2 = "";
                String finalmente = "";
                
                String[] avenida = paso_que_voy_ardiendo.split(" ");
                ArrayList<String> casi = new ArrayList<String>();
                for (int n = 0; n <avenida.length; n++) {
                    if (avenida[n].equals(nombre)||avenida[n].equals("(")||avenida[n].equals(")")) {
                        
                    }else{
                        casi.add(String.valueOf(avenida[n]));
                    } 
                }

                
                signo = casi.get(0);
                casi.remove(0);
                
                if (tipo==false) {
                    posicion_1 = casi.get(0);
                    casi.remove(0);
                    posicion_2 = casi.get(0)+" "+casi.get(1)+" "+casi.get(2);
                    casi.clear();
                
                    posicion_2 = "("+posicion_2+")";
                    t.operar(posicion_2);
                    posicion_2 = t.calcular(t.regresarArray());
                    
                    posicion_2 = valores.get(Math.round(Float.parseFloat(posicion_2)))+"";
                    

                    finalmente = "("+signo+" "+posicion_1+" "+posicion_2+")"; 
                    
                    t.operar(finalmente);
                    finalmente = t.calcular(t.regresarArray());    
                    valores.add(Float.parseFloat(finalmente));     

                    //operacion de agregar al stack
                }else{
                    posicion_1 = casi.get(0)+" "+casi.get(1)+" "+casi.get(2);
                    casi.remove(0);
                    casi.remove(0);
                    casi.remove(0);
                    posicion_2 = casi.get(0)+" "+casi.get(1)+" "+casi.get(2);
                    casi.clear();
                    
                    posicion_1 = "("+posicion_1+")";
                    t.operar(posicion_1);
                    posicion_1 = t.calcular(t.regresarArray());
                    
                    posicion_1 = valores.get(Math.round(Float.parseFloat(posicion_1)))+"";
                    

                    posicion_2 = "("+posicion_2+")";
                    t.operar(posicion_2);
                    posicion_2 = t.calcular(t.regresarArray());
                    
                    posicion_2 = valores.get(Math.round(Float.parseFloat(posicion_2)))+"";
                    

                    finalmente = "("+signo+" "+posicion_1+" "+posicion_2+")"; 
                    
                    t.operar(finalmente);
                    finalmente = t.calcular(t.regresarArray());    
                    valores.add(Float.parseFloat(finalmente));

                }
                

            }

            c.cleararrays();
            actual++;
            
        }

        //Retonra el último valor del arraylist.
        finale =  valores.get(valores.size()-1)+" ";

        valores.clear();

        return finale;
    }
}