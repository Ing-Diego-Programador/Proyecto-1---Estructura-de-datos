
import java.util.ArrayList;
public class C2 {
    ArrayList<String> condicional=new ArrayList<String>();
    ArrayList<String> parametro1=new ArrayList<String>();
    ArrayList<String> parametro2=new ArrayList<String>();
    Condition c =new  Condition();

    //Se recibe el string con el cond y se retorna un arraylist con el valor del string.
    public void setarrays(String codigo){
        StringBuilder palabara1= new StringBuilder(codigo);

        if(codigo.contains("cond") || codigo.contains("Cond")){
            if(codigo.contains("t")){

                int num1=palabara1.lastIndexOf("t"), num3=num1-2, num5=num1+2, num2=palabara1.lastIndexOf(")");
                String x=palabara1.substring(num5,num2);
                StringBuilder palabara2= new StringBuilder(x);
                int bre=palabara2.lastIndexOf(")");
                palabara1.delete(num3,num2);
                palabara2.deleteCharAt(bre);
                String xf = palabara2.toString();
                parametro2.add(xf);
            }
        }
        else{
            System.out.println("No se encontro una palabra cond por lo que no se puede realizar este metodo");
        }

        if(palabara1.toString().contains("cond")){
            int c=palabara1.lastIndexOf("(");
            int num3=palabara1.indexOf(")",c)+1;

            String parte2=palabara1.substring(c,num3);
            palabara1.delete(c,num3);
            condicional.add(parte2);
            int g=palabara1.lastIndexOf("d");
            int gprima=g+1;
            int f=palabara1.indexOf("(");
            String parte1=palabara1.substring(f,gprima);
            condicional.add(parte1);
            palabara1.delete(f,gprima);

            int parte3=palabara1.lastIndexOf(")");
            palabara1.deleteCharAt(parte3);
        }

        if(palabara1.toString().contains("(")){
            int c=palabara1.lastIndexOf("(");
            int num3=palabara1.indexOf(")",c);
            String parte2=palabara1.substring(c,num3);
            palabara1.delete(c,num3);
            parametro1.add(parte2);
        }
    }

    //Se retorna la string analizada.
    public String regresarcodigo(){
       String evaluar=condicional.get(0);
       boolean f=c.Calculo(evaluar);
       if(f==false){
           return parametro2.get(0);
       }else{
           return parametro1.get(0)+")";
       }
    }

    public String regresarestado(){
       String evaluar=condicional.get(0);
       boolean f=c.Calculo(evaluar);
       if(f==false){
           return "f";
       } else{
           return "v";
       }
    }
    
    //Se retorna el array con el resultado.
    public  ArrayList<String> regresarArray(){
        return condicional;
    }
    
    //Se limpian todos los arraylist
    public void cleararrays(){
        condicional.clear();
        parametro1.clear();
        parametro2.clear();
    }


}

