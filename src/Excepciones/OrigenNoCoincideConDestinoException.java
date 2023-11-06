package Excepciones;

/**
 *
 * @author diaza
 */
public class OrigenNoCoincideConDestinoException extends RuntimeException {
    
    public OrigenNoCoincideConDestinoException() {
        super("El origen del vuelo, no coincide con el destino del vuelo anterior a este");
    }
}
