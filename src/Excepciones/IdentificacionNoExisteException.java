
package Excepciones;

/**
 *
 * @author diazje
 */
public class IdentificacionNoExisteException extends RuntimeException {
    
    public IdentificacionNoExisteException() {
        super("El numero de identificación NO existe en el sistema");
    }   
}
