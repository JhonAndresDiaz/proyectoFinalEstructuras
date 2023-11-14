package Util;
import java.io.Serializable;

/**
 *
 * @author diaza
 */
public class Cola<T> implements Serializable {
    
    private Nodo<T> primero;
    
    public Cola() {
        this.primero = null;
    }
    
    public void addQueue(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if(isEmpty()) {
            primero = nuevoNodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getNodoSiguiente() != null) {
                actual = actual.getNodoSiguiente();
            }
            actual.setNodoSiguiente(nuevoNodo);
        }
    }

    public T removeQueue() {
        if (isEmpty()) {
            throw new NullPointerException("La cola está vacía");
        }else {
            T dato = primero.getDato();
            primero = primero.getNodoSiguiente();
            return dato; 
        }
    }
    
    public T peek() {
        if(isEmpty()) {
        } else {
            return primero.getDato();
        }
        return null;
    }

    public boolean isEmpty() {
        return primero == null;
    }
    
    public int size() {
        int tamano = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            tamano++;
            actual = actual.getNodoSiguiente();
        }
        return tamano;
    }
    
    public void clear() {
        primero = null;
    }
    
    public Nodo<T> getPrimero(){
        return primero;
    }
}
