package Util;
import java.io.Serializable;

/**
 *
 * @author diaza
 */
public class LSE<T> implements Serializable, Cloneable {
    
    Nodo<T> primero;
    int size;

    public LSE() {
        this.primero = null;
        this.size = 0;
    }

    public int size(){
        return size;
    }
    
    public Nodo<T> getPrimero() {
        return primero;
    }
    
    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

    public void add(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);
        if(primero == null){
            primero = nuevo;
        }else{
            Nodo<T> aux = primero;
            while(aux.getNodoSiguiente() != null){
                aux = aux.getNodoSiguiente();
            }
            aux.setNodoSiguiente(nuevo);
        }            
        size++;
    }
    
    public T get(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("Para el indice " + index);
        }else{
            if(index == 0){
                return primero.getDato();
            }else{
                Nodo<T> aux = primero;
                int contador = 0;
                while(contador < index){
                    aux = aux.getNodoSiguiente();
                    contador++;
                }
                return aux.getDato();
            }            
        }
    }
        
    public void set(int index, T nuevo) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Para el índice " + index);
        } else {
            Nodo<T> nodoActual = primero;
            int contador = 0;

            while (contador < index) {
                nodoActual = nodoActual.getNodoSiguiente();
                contador++;
            }
            nodoActual.setDato(nuevo);
        }
    }

    public void add(T dato, int index){
        if (index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException("Para el índice " + index);
        }else{
            Nodo<T> nodoNuevo = new Nodo<>(dato);
            if(index == 0){
                nodoNuevo.setNodoSiguiente(primero);
                primero = nodoNuevo;
            }else{
                Nodo<T> nodoActual = primero;
                int contador = 0;
                while(contador < index - 1){
                    nodoActual = nodoActual.getNodoSiguiente();
                    contador++;
                }
                nodoNuevo.setNodoSiguiente(nodoActual.getNodoSiguiente());
                nodoActual.setNodoSiguiente(nodoNuevo);
            }
            size++;
        }
    }
    
    public void remove(int index) {
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("Para el índice " + index);
        }else{
            if(index == 0){
                primero = primero.getNodoSiguiente();
            }else{
                Nodo<T> nodoActual = primero;
                int contador = 0;
                while(contador < index - 1){
                    nodoActual = nodoActual.getNodoSiguiente();
                    contador++;
                }
                nodoActual.setNodoSiguiente(nodoActual.getNodoSiguiente().getNodoSiguiente());
            }
            size--;
        }
    }
    
    public void remove(T dato) {
        if (primero == null) {
            return; 
        }

        if (primero.getDato().equals(dato)) {
            primero = primero.getNodoSiguiente();
            size--;
            return;
        }

        Nodo<T> nodoActual = primero;
        Nodo<T> nodoAnterior = null;

        while (nodoActual != null && !nodoActual.getDato().equals(dato)) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getNodoSiguiente();
        }

        if (nodoActual != null) {
            nodoAnterior.setNodoSiguiente(nodoActual.getNodoSiguiente());
            size--;
        }
    }

    public boolean isEmpty() {
        return primero == null;
    }

    @Override
    public LSE<T> clone() {
        try {
            LSE<T> nuevaLista = (LSE<T>) super.clone();
            return nuevaLista;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
