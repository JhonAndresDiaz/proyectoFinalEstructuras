
package Excepciones;

/**
 *
 * @author diazje
 */
public class InformacionViajeroException extends RuntimeException {
    
    public InformacionViajeroException() {
        super("Ingrese la misma información que registro como viajero anteriormente");
    }  
}
