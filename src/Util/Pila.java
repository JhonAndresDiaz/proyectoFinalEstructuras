package Util;

/**
 *
 * @author diaza
 */
public class Pila<T> {

    private LSE<T> lista;

    public Pila() {
        this.lista = new LSE<>();
    }

    public void push(T dato) {
        lista.add(dato, 0);  // Añadir al principio de la lista (top de la pila)
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        T dato = lista.get(0);  // Obtener el elemento en la cima de la pila
        lista.remove(0);        // Eliminar el elemento en la cima de la pila
        return dato;
    }

    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return lista.get(0);  
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    public int size() {
        return lista.size();
    }
}



       

