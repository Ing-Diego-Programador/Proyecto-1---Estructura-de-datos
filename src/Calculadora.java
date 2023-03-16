import java.util.ArrayList;
import java.util.Collections;

public class Calculadora implements ICalculadora{
    
    //instancia del StackVector que funciona como la pila mencionada en la hoja.
    StackV<Float> stack = new StackV<Float>();

    // Se trabaja el Postfix y se retorna la operacion o el mensaje de error.
    public String Calculo(String expresion){
        String str1 = "";
        for (int i = 0; i < expresion.length(); i++){
            if(String.valueOf(expresion.charAt(i)).equals(")")||String.valueOf(expresion.charAt(i)).equals("(")){

            }else{
                str1 = str1 + expresion.charAt(i);
            }
        }

        String[] str2 = str1.split(" ");
        ArrayList<String> CadenaInvertida = new ArrayList<String>();

        for (int n = 0; n <str2.length; n++) {

            CadenaInvertida.add(String.valueOf(str2[n]));
        }

        for (int i = 0; i < CadenaInvertida.size(); i++){
            if(CadenaInvertida.get(i).equals("")){
                CadenaInvertida.remove(i);
            }
        }


        Collections.reverse(CadenaInvertida);
        String operacionando = CadenaInvertida.get(CadenaInvertida.size()-1);
        float cantidades = CadenaInvertida.size()-2;

        if(operacionando.equals("+")){
            for (int i =1;i<cantidades ;i++ ) {
                CadenaInvertida.add("+");
            }
        }else if(operacionando.equals("-")){
            for (int i =1;i<cantidades ;i++ ) {
                CadenaInvertida.add("-");
            }
        }else if(operacionando.equals("/")){
            for (int i =1;i<cantidades ;i++ ) {
                CadenaInvertida.add("/");
            }
        }else if(operacionando.equals("*")){
            for (int i =1;i<cantidades ;i++ ) {
                CadenaInvertida.add("*");
            }
        }


        String operacion = "";
        boolean com = true;
        String[] SplitOperation;
        float operadorB =0;
        float operadorA =0;
        float nuevo =0;
        SplitOperation = expresion.split(" ");
        boolean comprobante_cond =  false;
        String operacion_cond = "";

        for (int i = 0; i < CadenaInvertida.size(); i++){
            if(CadenaInvertida.get(i).equals("*") || CadenaInvertida.get(i).equals("-") || CadenaInvertida.get(i).equals("+") || CadenaInvertida.get(i).equals("/")|| CadenaInvertida.get(i).equals("<")|| CadenaInvertida.get(i).equals(">")){
                if(stack.size()>=2){
                    operadorA = stack.pop();
                    operadorB = stack.pop();
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
                            operacion_cond =  "F";
                        }
                        
                    }
                    stack.push(nuevo);
                }else{
                    com = false;
                }


            }else if(CadenaInvertida.get(i).equals("")){

            }
            else if(comprobante_cond == false){
                if(CadenaInvertida.get(i).equals("NIL")||CadenaInvertida.get(i).equals("T")){
                    comprobante_cond = true;
                }else{
                    try{
                        float num = Float.parseFloat(CadenaInvertida.get(i));
                        stack.push(num);
                    }catch(Exception e){
                        System.out.println("Error");
                    }
                }
                
            }
        }
        if(com == true&&comprobante_cond==false){
            operacion = Float.toString(stack.pop());
        }else if(com == false&&comprobante_cond == false){
            operacion = "No se puede operar";
        }else if (comprobante_cond == true) {
            operacion =  operacion_cond;
        }

        stack.limp();
        return operacion;
    }
}