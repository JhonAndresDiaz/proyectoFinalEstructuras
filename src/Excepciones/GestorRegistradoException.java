
package Excepciones;

/**
 *
 * @author diazje
 */
public class GestorRegistradoException extends RuntimeException {
    
    public GestorRegistradoException() {
        super("Ya existe en el sistema el número de identificación del gestor de mantenimiento");
    }   
}
