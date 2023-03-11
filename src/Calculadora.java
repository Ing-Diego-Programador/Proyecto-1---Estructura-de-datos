/**
 * Clase Calculadora que implementa la interfaz calculadora para realizar las condicionales y operaciones prefix.
 */

public class Calculadora implements ICalculadora {

    @Override
    public String Calculo(String expresion) {

        String cadena1 = "";

        for (int i = 0; i < expresion.length(); i++){
            if(String.valueOf(expresion.charAt(i)).equals(")")||String.valueOf(expresion.charAt(i)).equals("(")){

            }else{
                cadena1 = cadena1 + expresion.charAt(i);
            }
        }

        return cadena1;
        
    }
    
}
