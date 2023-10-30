package Excepciones;

/**
 *
 * @author diaza
 */
public class Almenos1AdminException extends RuntimeException {
    
    public Almenos1AdminException() {
        super("Error, no se pudo eliminar. \n debe existir al menos un administrador en la aerolínea");
    }   
}
