
package Excepciones;

/**
 *
 * @author diazje
 */
public class CodigoAerolineaExisteException extends RuntimeException {
    
    public CodigoAerolineaExisteException() {
        super("El código de la aerolinea ya fue registrado");
    }   
}
