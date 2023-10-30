
package Excepciones;

/**
 *
 * @author diazje
 */
public class CapitanVueloRegistradoException extends RuntimeException {
    
    public CapitanVueloRegistradoException() {
        super("Ya existe en el sistema el número de identificación del capitán de vuelo");
    }   
}
