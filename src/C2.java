
//Importacion de la librería arraylist.
import java.util.ArrayList;

//Clase que permite el análisis de condicionales y devuelve los resultados en un string.
public class C2 {

    ArrayList<String> p1 = new ArrayList<String>();
    ArrayList<String> p2 = new ArrayList<String>();
    ArrayList<String> cond = new ArrayList<String>();
    Condition c = new  Condition();

    //Por medio del string se retorna un arraylist con el valor del string.
    public void setarrays(String codigo){

        StringBuilder palabara1= new StringBuilder(codigo);

        if(codigo.contains("cond") || codigo.contains("cond")){

            if(codigo.contains("t")){

                int num1=palabara1.lastIndexOf("t");

                int num3=num1-2;
                int num5=num1+2;

                int num2=palabara1.lastIndexOf(")");
                String x=palabara1.substring(num5,num2);
                palabara1.delete(num3,num2);
                StringBuilder palabara2= new StringBuilder(x);
                int bre=palabara2.lastIndexOf(")");
                palabara2.deleteCharAt(bre);
                String xf = palabara2.toString();
                p2.add(xf);

            }
        } else{

            System.out.println("La informacion ingresada es incorrecta, por lo que no se puede realizar esta accion");

        }

        if(palabara1.toString().contains("cond")){

            int c=palabara1.lastIndexOf("(");
            int num3=palabara1.indexOf(")",c)+1;

            String parte2=palabara1.substring(c,num3);
            palabara1.delete(c,num3);
            cond.add(parte2);
            int g=palabara1.lastIndexOf("d");
            int gprima=g+1;
            int f=palabara1.indexOf("(");
            String parte1=palabara1.substring(f,gprima);
            cond.add(parte1);
            palabara1.delete(f,gprima);

            int parte3=palabara1.lastIndexOf(")");
            palabara1.deleteCharAt(parte3);

        }

        if(palabara1.toString().contains("(")){

            int c=palabara1.lastIndexOf("(");
            int num3=palabara1.indexOf(")",c);
            String parte2=palabara1.substring(c,num3);
            palabara1.delete(c,num3);
            p1.add(parte2);

        }
    }

    //Se retorna la string analizada.
    public String regresarcodigo(){
       String evaluar=cond.get(0);
       boolean f=c.Calculo(evaluar);
       if(f==false){
            return p2.get(0);
       } else{
            return p1.get(0)+")";
       }
    }

    //Retorna el estado, verdadero o false.
    public String regresarestado(){
       String evaluar=cond.get(0);
       boolean f=c.Calculo(evaluar);
       if(f==false){
           return "f";
       } else{
           return "v";
       }
    }

    //Se retorna cond, un arraylist.
    public  ArrayList<String> regresarArray(){
        return cond;
    }
    
    //Se limpian los arrays.
    public void cleararrays(){
        cond.clear();
        p1.clear();
        p2.clear();
    }


}

