
package Excepciones;

/**
 *
 * @author diaza
 */
public class FechaMantenimientoVueloYaRegistradoException extends RuntimeException {
    public FechaMantenimientoVueloYaRegistradoException() {
        super("Error, el dia seleccionado ya cuenta con vuelos programados");
    }   
    
}
