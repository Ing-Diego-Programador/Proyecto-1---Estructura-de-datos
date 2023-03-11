/***
* Clase con un vector genérico para dar herramientas de manipulación del vector.
*/

import java.util.Vector;

public class Stack<T> implements IStack<T>{

    Vector <T> stack = new Vector<T>();

    // agregar un elemento al vector
    @Override
    public void push(T num) {
        stack.add(num);
    }

    // Elimina el último valor del vector.
    @Override
    public T pop() {
        T num = peek();
        stack.removeElementAt(stack.size()-1);
        return num;
    }

    //Devuelve el último elemento del vector.
    @Override
    public T peek() {
        return stack.get(stack.size()-1);
    }

    //Retorna el tamaño del vector.
    @Override
    public int size() {
        return stack.size();
    }

    //Devuelve el estado del vector.
    @Override
    public boolean empty() {
        boolean cantidad = false;
        if (stack.size()==0){
            cantidad = true;
        }
        return cantidad;
    }

    //Limpia el vetor.
    public void limp(){
        stack.clear();
    }
}
