
package Modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author diazje
 */
public class AdministradorAerolinea extends Persona implements Serializable {
    
    private LocalDate fechaRegistro;

    public AdministradorAerolinea(LocalDate fechaContratación, String identificacion, String nombres, String apellidos, int edad, String genero, String numTelefono, String correo, String contrasenia, String rol) {
        super(identificacion, nombres, apellidos, edad, genero, numTelefono, correo, contrasenia, rol);
        this.fechaRegistro = fechaContratación;
    }

    public LocalDate getFechaContratación() {
        return fechaRegistro;
    }

    public void setFechaContratación(LocalDate fechaContratación) {
        this.fechaRegistro = fechaContratación;
    }    
}
