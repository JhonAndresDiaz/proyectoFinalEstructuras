
package Excepciones;

/**
 *
 * @author diazje
 */
public class InformacionEmpleadoException extends RuntimeException {
    
    public InformacionEmpleadoException() {
        super("Ingrese la misma información que registro como empleado de logistica anteriormente");
    }  
}
