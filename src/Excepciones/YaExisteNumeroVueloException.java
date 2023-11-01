
package Excepciones;

/**
 *
 * @author diaza
 */
public class YaExisteNumeroVueloException extends RuntimeException {
    
    public YaExisteNumeroVueloException() {
        super("El número de vuelo ya se encuentra registrado, ingrese otro");
    }  
    
}
