/**
 * Interface para las funciones de Stack de las operaciones del compilador.
 */


public interface IStack<T> {

    void push(T num); //Agregar.

    T pop(); //Eliminar el último valor del vector.

    T peek(); //Toma el valor.

    int size(); //Retorna el tamaño del vector.

    boolean empty(); //Devuelve el estado del vector.


}
