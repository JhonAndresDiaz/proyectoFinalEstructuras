package Excepciones;

/**
 *
 * @author diaza
 */
public class CruzaHorariosMantenimientoException extends RuntimeException {
    public CruzaHorariosMantenimientoException() {
    super("Error, en esa fecha se está haciendo mantenimiento a otro avión");
    } 
}
