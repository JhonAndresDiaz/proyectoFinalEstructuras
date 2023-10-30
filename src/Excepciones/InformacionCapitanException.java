
package Excepciones;

/**
 *
 * @author diazje
 */
public class InformacionCapitanException extends RuntimeException {
    
    public InformacionCapitanException() {
        super("Ingrese la misma información que registro como capitan de vuelo anteriormente");
    }  
}
