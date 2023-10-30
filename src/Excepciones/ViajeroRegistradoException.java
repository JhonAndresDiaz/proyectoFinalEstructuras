
package Excepciones;

/**
 *
 * @author diazje
 */
public class ViajeroRegistradoException extends RuntimeException {
    
    public ViajeroRegistradoException() {
        super("Ya existe en el sistema el número de identificación del viajero");
    }   
}
