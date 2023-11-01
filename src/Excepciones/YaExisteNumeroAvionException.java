
package Excepciones;

/**
 *
 * @author diaza
 */
public class YaExisteNumeroAvionException extends RuntimeException {
    
    public YaExisteNumeroAvionException() {
        super("El número de avión ya se encuentra registrado, ingrese otro");
    }  
}
