package Excepciones;

/**
 *
 * @author diaza
 */
public class YaExisteAerolineaCodigoAdminException extends RuntimeException {
    
    public YaExisteAerolineaCodigoAdminException() {
        super("El número de identificaciión del Administrador \n ya esta en uso en otra Aerolinea");
    } 
}
