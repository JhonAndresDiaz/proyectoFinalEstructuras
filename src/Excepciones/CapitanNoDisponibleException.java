
package Excepciones;

import Controladores.*;

/**
 *
 * @author diaza
 */
public class CapitanNoDisponibleException extends RuntimeException {
    
    public CapitanNoDisponibleException() {
        super("El capitán no está disponible en ese horario.");
    }   
}
