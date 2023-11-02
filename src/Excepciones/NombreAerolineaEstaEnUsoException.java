package Excepciones;

/**
 *
 * @author diaza
 */
public class NombreAerolineaEstaEnUsoException extends RuntimeException{
    
    public NombreAerolineaEstaEnUsoException() {
        super("El nombre escrito ya esta registrado en otra areolinea");
    } 
}
