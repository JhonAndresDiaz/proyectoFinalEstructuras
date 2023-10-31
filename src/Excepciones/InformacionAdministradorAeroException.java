
package Excepciones;

/**
 *
 * @author diazje
 */
public class InformacionAdministradorAeroException extends RuntimeException {
    
    public InformacionAdministradorAeroException() {
        super("Ingrese la misma información que registro como administrador de aerolinea anteriormente");
    } 
}
