package Excepciones;

/**
 *
 * @author diaza
 */
public class YaExisteCodigoMantenimientoException extends RuntimeException {
    
    public YaExisteCodigoMantenimientoException() {
        super("Ya existe el numero de mantenimiento");
    }   
    
}
