
package Excepciones;

/**
 *
 * @author diazje
 */
public class EmpleadoLogisticaRegistradoException extends RuntimeException {
    
    public EmpleadoLogisticaRegistradoException() {
        super("Ya existe en el sistema el número de identificación del Empleado de logistica");
    }   
}
