
public interface IStack<T> {

    //Agregar un elemento al vector.
    void push(T num);

    //Se quita el últomo valor del vector.
    T pop();

    //Se retorna la cantidad de elementos del vector.
    int size();
    
    //Get
    T peek();

    //Verificar si el vector está vacío.
    boolean empty();

}
