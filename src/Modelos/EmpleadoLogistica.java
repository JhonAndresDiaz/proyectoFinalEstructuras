
package Modelos;

import java.io.Serializable;

/**
 *
 * @author diazje
 */
public class EmpleadoLogistica extends Persona implements Serializable {
    
    private String numeroTarjetaProfesional;
    private int aniosExperiencia;
    private String rutasAsignadas;

    public EmpleadoLogistica(String numeroTarjetaProfesional, int aniosExperiencia, String rutasAsignadas, String identificacion, String nombres, String apellidos, int edad, String genero, String numTelefono, String correo, String contrasenia, String rol) {
        super(identificacion, nombres, apellidos, edad, genero, numTelefono, correo, contrasenia, rol);
        this.numeroTarjetaProfesional = numeroTarjetaProfesional;
        this.aniosExperiencia = aniosExperiencia;
        this.rutasAsignadas = rutasAsignadas;
    }

    public String getNumeroTarjetaProfesional() {
        return numeroTarjetaProfesional;
    }

    public void setNumeroTarjetaProfesional(String numeroTarjetaProfesional) {
        this.numeroTarjetaProfesional = numeroTarjetaProfesional;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getRutasAsignadas() {
        return rutasAsignadas;
    }

    public void setRutasAsignadas(String rutasAsignadas) {
        this.rutasAsignadas = rutasAsignadas;
    }
}
