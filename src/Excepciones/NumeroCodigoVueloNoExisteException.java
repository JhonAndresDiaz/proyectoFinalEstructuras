
package Excepciones;

/**
 *
 * @author diaza
 */
public class NumeroCodigoVueloNoExisteException extends RuntimeException {
    
    public NumeroCodigoVueloNoExisteException() {
        super("El numero no existe");
    } 
}
