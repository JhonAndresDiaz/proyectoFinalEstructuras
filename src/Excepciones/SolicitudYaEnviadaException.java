
package Excepciones;

/**
 *
 * @author diaza
 */
public class SolicitudYaEnviadaException extends RuntimeException {
    
    public SolicitudYaEnviadaException() {
        super("Ya cumplió el máximo de 1 petición por aerolínea");
    }  
    
}
