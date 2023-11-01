
package Excepciones;

/**
 *
 * @author diaza
 */
public class AvionNoDisponibleException extends RuntimeException {
    
    public AvionNoDisponibleException() {
        super("El avión no está disponible en ese horario.");
    } 
}
