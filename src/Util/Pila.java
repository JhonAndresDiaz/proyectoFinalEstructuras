package Util;

public class Pila<T> {
    
    private NodoPila<T> primero;
    private int size;
    
    public Pila() {
        this.primero = null;
        this.size=0;
    }
    
    public void push(T dato) {
        if (this.isEmpty()) {
            this.setPrimero(new NodoPila<>(dato));
        } else {
            NodoPila<T> nuevoNodo = new NodoPila<>(dato);
            nuevoNodo.setNodoAnterior(this.getPrimero());
            this.setPrimero(nuevoNodo);
        }
        this.aumentarSize();
    }
    
    public T pop(){
        if (!this.isEmpty()) {
            T aux = this.peek();
            this.setPrimero(this.getPrimero().getNodoAnterior());
            this.disminuirSize();
            return aux;
        }else{
            throw new RuntimeException("La pila esta vacia");
        }
    }
    
    public boolean isEmpty(){
        return this.getPrimero()==null;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public T peek(){
        if(!this.isEmpty()){
            return this.getPrimero().getDato();
        }else{
            throw new RuntimeException("La pila esta vacia");
        }
    }

    private void aumentarSize(){
        this.size++;
    }

    private void disminuirSize(){
        this.size--;
    }

    private NodoPila<T> getPrimero(){
        return this.primero;
    }
    private void setPrimero(NodoPila<T> primero){
        this.primero=primero;
    }
}
