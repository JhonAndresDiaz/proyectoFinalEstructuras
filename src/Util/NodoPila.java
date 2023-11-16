package Util;

public class NodoPila<T>{

    private T dato;
    private NodoPila<T> nodoAnterior;
    
    public NodoPila(T d){
        this.dato = d;
        this.nodoAnterior=null;
    }
    
    public void setDato(T d){
        this.dato = d;
    }

    public T getDato(){
        return this.dato;
    }

    public void setNodoAnterior(NodoPila<T> n){
        this.nodoAnterior = n;
    }

    public NodoPila<T> getNodoAnterior(){
        return this.nodoAnterior;
    }
}