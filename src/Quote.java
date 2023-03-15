import java.util.*;

public class Quote {

    //Recibe el string a analizar y revuelve el string a imprimir.
    public static String quote(String imp){
        
        String str1 = "";

        for (int i = 0; i < imp.length(); i++){
            if(String.valueOf(imp.charAt(i)).equals(")")||String.valueOf(imp.charAt(i)).equals("(")){
                
            }else{
                str1 = str1 + imp.charAt(i);
            }
        }

        //Dando split de espacio vacío a la expresión.
        String[] str2 = str1.split(" "); //Dando espacios vacíos entre cada elemento que se agrega al Array.

        //ArrayList para los datos que se van a stqertir.
        ArrayList<String> stq = new ArrayList<String>();  

        String c = ""; 
        
        //Agregando de manera normal los valores del archivo datos.txt.
        for (int n = 1; n <str2.length; n++) { 
            stq.add(String.valueOf(str2[n])); //Añadiendo los elementos a invertir en el ArrayList.
        }
                
        for(int i = 0; i < stq.size(); i++){
            c = c + stq.get(i) + " ";
        }
        
        c = "(" + c + ")";

        return c; //return del contenido. 
    }   
}