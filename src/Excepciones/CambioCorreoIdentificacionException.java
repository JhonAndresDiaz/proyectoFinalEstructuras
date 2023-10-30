package Excepciones;

/**
 *
 * @author diaza
 */
public class CambioCorreoIdentificacionException extends RuntimeException{
    
    public CambioCorreoIdentificacionException() {
        super("No se puede cambiar el correo del usuario, ni su numero de id");
    }   
}
