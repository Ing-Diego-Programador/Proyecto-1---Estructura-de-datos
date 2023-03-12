import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase Calculadora que implementa la interfaz calculadora para realizar las condicionales y operaciones prefix.
 */

public class Calculadora implements ICalculadora {

    StackV<Float> stackV = new StackV<Float>(); //Pila de la instacia del vector.
    ArrayList<String> CadenaInvertida = new ArrayList<String>();

    //Declaración de operadores, comprobantes, etc.
    String operacion = "";
    boolean com = true;
    String[] SplitOperation;
    float operadorB =0;
    float operadorA =0;
    float nuevo =0;
    boolean comprobante_cond =  false;
    String operacion_cond = "";
    String cadena1 = "";

    //Se trabaja la cadena que contiene la operación Postfix que se desea resolver. Y retorna el resultado.
    @Override
    public String Calculo(String expresion) {

        
        for (int i = 0; i < expresion.length(); i++){
            if(String.valueOf(expresion.charAt(i)).equals(")")||String.valueOf(expresion.charAt(i)).equals("(")){

            }else{
                cadena1 = cadena1 + expresion.charAt(i);
            }
        }

        String[] Cadena2 = cadena1.split(" ");

        for (int n = 0; n <Cadena2.length; n++) {
            CadenaInvertida.add(String.valueOf(Cadena2[n]));
        }
        for (int i = 0; i < CadenaInvertida.size(); i++){
            if(CadenaInvertida.get(i).equals("")){
                CadenaInvertida.remove(i);
            }
        }

        Collections.reverse(CadenaInvertida);
        String operacionando = CadenaInvertida.get(CadenaInvertida.size()-1);
        float cantidades = CadenaInvertida.size()-2;

        //Verificación del signo de operación.
        switch (operacionando) {
            case "+":
                for (int i =1;i<cantidades ;i++ ) {
                    CadenaInvertida.add("+");
                }
                break;
            case "-":
                for (int i =1;i<cantidades ;i++ ) {
                    CadenaInvertida.add("-");
                }
                break;
            case "/":
                for (int i =1;i<cantidades ;i++ ) {
                    CadenaInvertida.add("/");
                }
                break;  
            case "*":
                for (int i =1;i<cantidades ;i++ ) {
                    CadenaInvertida.add("*");
                }
                break; 
        }

        SplitOperation = expresion.split(" ");//Se crea el split de la operación.

        for (int i = 0; i < CadenaInvertida.size(); i++){
            if(CadenaInvertida.get(i).equals("*") || CadenaInvertida.get(i).equals("-") || CadenaInvertida.get(i).equals("+") || CadenaInvertida.get(i).equals("/")|| CadenaInvertida.get(i).equals("<")|| CadenaInvertida.get(i).equals(">")){
                if(stackV.size()>=2){
                    operadorA = stackV.pop();
                    operadorB = stackV.pop();
                    if(CadenaInvertida.get(i).equals("*")){
                        nuevo = operadorA*operadorB;
                    }else if(CadenaInvertida.get(i).equals("/")){
                        nuevo = operadorA/operadorB;
                    }else if(CadenaInvertida.get(i).equals("+")){
                        nuevo = operadorA+operadorB;
                    }else if(CadenaInvertida.get(i).equals("-")){
                        nuevo = operadorA-operadorB;
                    }
                    else if(CadenaInvertida.get(i).equals("<")){
                        if(operadorA < operadorB){
                            comprobante_cond =  true;
                            operacion_cond = "T";
                        }else{
                            comprobante_cond =  true;
                            operacion_cond =  "NIL";
                        }
                    }else if(CadenaInvertida.get(i).equals(">")){
                        if(operadorA  > operadorB){
                            comprobante_cond =  true;
                            operacion_cond = "T";
                        }else{
                            comprobante_cond = true;
                            operacion_cond =  "NIL";
                        }
                    }
                    stackV.push(nuevo);
                }else{
                    com = false;
                }
            } else if(comprobante_cond == false){
                if(CadenaInvertida.get(i).equals("NIL")||CadenaInvertida.get(i).equals("T")){
                    comprobante_cond = true;
                }else{
                    try{
                        float num = Float.parseFloat(CadenaInvertida.get(i));
                        stackV.push(num);
                    }catch(Exception e){
                        System.out.println("Error");
                    }
                }
                
            }
        }

        //Se hace la verificación.
        if(com == true&&comprobante_cond==false){
            operacion = Float.toString(stackV.pop());
        }else if(com == false&&comprobante_cond == false){
            operacion = "No es posible operar";
        }else if (comprobante_cond == true) {
            operacion =  operacion_cond;
        }
        stackV.limp();
        return operacion;
    }       
}
    

