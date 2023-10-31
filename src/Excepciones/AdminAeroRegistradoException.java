
package Excepciones;

/**
 *
 * @author diazje
 */
public class AdminAeroRegistradoException extends RuntimeException {
    
    public AdminAeroRegistradoException() {
        super("Ya existe en el sistema el número de identificación del administrador de Aerolínea");
    }   
}
