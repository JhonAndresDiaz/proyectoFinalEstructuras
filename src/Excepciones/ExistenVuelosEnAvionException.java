
package Excepciones;

/**
 *
 * @author diaza
 */
public class ExistenVuelosEnAvionException extends RuntimeException {
    
    public ExistenVuelosEnAvionException() {
        super("Actualmente hay vuelos registrados en el avión, no se pueden eliminar");
    }
}
