
package Excepciones;

/**
 *
 * @author diazje
 */
public class CorreoRegistradoException extends RuntimeException {
    public CorreoRegistradoException() {
    super("El correo (Usuario) ya corresponde a otra persona");
    }   
}
