
package Excepciones;

/**
 *
 * @author diaza
 */
public class ExistenViajerosEnListaException extends RuntimeException {
    
    public ExistenViajerosEnListaException() {
        super("Actualmente hay viajeros registrados en el vuelo, no se pueden realizar modificaciones");
    }
}
