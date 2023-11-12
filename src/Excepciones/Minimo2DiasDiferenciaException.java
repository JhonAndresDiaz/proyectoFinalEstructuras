package Excepciones;

/**
 *
 * @author diaza
 */
public class Minimo2DiasDiferenciaException extends RuntimeException  {
    
    public Minimo2DiasDiferenciaException() {
        super("Solo puede realizar cancelaciones 2 dias antes de la fecha de inicio \n del vuelo");
    }  
}
