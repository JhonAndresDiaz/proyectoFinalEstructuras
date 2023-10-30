
package Excepciones;

/**
 *
 * @author diazje
 */
public class InformacionGestorException extends RuntimeException {
    
    public InformacionGestorException() {
        super("Ingrese la misma información que registro como gestor de mantenimiento anteriormente");
    }  
}
