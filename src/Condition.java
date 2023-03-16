//Librerias
import java.util.ArrayList;
import java.util.Collections;

//Clase del StackV que funciona como la pila mencionada en la hoja.
public class Condition{

    //Se trabaja un String condicional y se retorna un booleano.
    public static boolean Calculo(String expresion){

        String str1 = "";
        StackV<Float> stack = new StackV<Float>();

        //Obteniendo la expresiòn con paréntesis.
        for (int i = 0; i < expresion.length(); i++){
            if(String.valueOf(expresion.charAt(i)).equals(")")||String.valueOf(expresion.charAt(i)).equals("(")){
            }else{
                str1 = str1 + expresion.charAt(i);
            }
        }

      
        String[] str2 = str1.split(" ");
        ArrayList<String> CadenaInvertida = new ArrayList<String>();

        for (int n = 1; n <str2.length; n++) {

            CadenaInvertida.add(String.valueOf(str2[n]));
        }

        
        for (int i = 0; i < CadenaInvertida.size(); i++){
            if(CadenaInvertida.get(i).equals("")){
                CadenaInvertida.remove(i);
            }
        }


        Collections.reverse(CadenaInvertida); //Invirtiendo la expresión.


        //Obteniendo las cantidades y su operacionando, en este caso la comparación que se hará entre los números.
        String operacionando = CadenaInvertida.get(CadenaInvertida.size()-1);
        float cantidades = CadenaInvertida.size()-2;

        //Añadiendo los comparadores al ArrayList invertida.
        if(operacionando.equals("<")){
            for (int i =1;i<cantidades ;i++ ) {
                CadenaInvertida.add("<");
            }
        }else if(operacionando.equals(">")){
            for (int i =1;i<cantidades ;i++ ) {
                CadenaInvertida.add(">");
            }
        }else if(operacionando.equals("=")){
            for (int i =1;i<cantidades ;i++ ) {
                CadenaInvertida.add("=");
            }
        }

        //Variables a usar.
        String operacion = ""; //Variable que será la encargada de devolver el resultado pertinente de la comparación.
        boolean com = true;
        String[] SplitOperation;
        float operadorB =0;
        float operadorA =0;
        float nuevo =0;
        boolean res = true;
        String res1 = "";
        SplitOperation = expresion.split(" ");

        //Haciendo las comparaciones entre los valores.
        for (int i = 0; i < CadenaInvertida.size(); i++){
            if(CadenaInvertida.get(i).equals("<") || CadenaInvertida.get(i).equals(">") || CadenaInvertida.get(i).equals("=")){
                if(stack.size()>=2){
                    operadorB = stack.pop();
                    operadorA = stack.pop();

                    if(CadenaInvertida.get(i).equals("<")){ //Operación del menor que.
                        if(operadorB < operadorA){
                            res = true;
                        }else{
                            res = false;

                        }
                    }else if(CadenaInvertida.get(i).equals(">")){ //Operación del mayor que.

                        if(operadorB > operadorA){
                            res = true;

                        }else{
                            res = false;
                        }

                    }else if(CadenaInvertida.get(i).equals("=")){ //Operación del igual que.

                        if(operadorB == operadorA){
                            res = true;

                        }else{
                            res = false;
                        }
                    }
                    stack.push(nuevo); //Push del resultado.
                }else{
                    com = false;
                }


            }else{
                float num = Float.parseFloat(CadenaInvertida.get(i));
                stack.push(num);
            }
        }

        return res; 
    }
}