import java.util.ArrayList;

public class Quote {
    
    //Clase Quote que imprime el contenido de .txt
    //Como parametro está el string a analizar y se revuelve el string a imprimir.
    public static String quote(String imp){
        
        String str1 = "";

        for (int i = 0; i < imp.length(); i++){
            if(String.valueOf(imp.charAt(i)).equals(")")||String.valueOf(imp.charAt(i)).equals("(")){
                
            }else{
                str1 = str1 + imp.charAt(i);
            }
        }

        //Dando espacios vacíos entre cada elemento que se agrega al Array.
        String[] str2 = str1.split(" ");
        //ArrayList para los datos que se van a stqertir.
        ArrayList<String> stq = new ArrayList<String>();  
        //Agregando de manera normal los valores del archivo datos.txt.
        for (int n = 1; n <str2.length; n++) { 
            //Añadiendo los elementos a invertir en el ArrayList.
            stq.add(String.valueOf(str2[n])); 
        }
                
        String c = ""; 

        for(int i = 0; i < stq.size(); i++){
            c = c + stq.get(i) + " ";
        }
        
        c = "(" + c + ")";

        return c; //return del contenido. 
    }   
}