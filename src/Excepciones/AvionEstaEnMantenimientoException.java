
package Excepciones;

/**
 *
 * @author diaza
 */
public class AvionEstaEnMantenimientoException extends RuntimeException {
    
    public AvionEstaEnMantenimientoException() {
        super("El avión se encuentra en mantenimiento en esa fecha");
    } 
    
}
