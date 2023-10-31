package Modelos;

import java.io.Serializable;

/**
 *
 * @author diaza
 */
public class GestorMantenimiento extends Persona implements Serializable {

    private String especialidad;
    private String certificaciones;
    private String ciudadResidencia;

    public GestorMantenimiento(String especialidad, String certificaciones, String ciudadResidencia, String identificacion, String nombres, String apellidos, int edad, String genero, String numTelefono, String correo, String contrasenia, String rol) {
        super(identificacion, nombres, apellidos, edad, genero, numTelefono, correo, contrasenia, rol);
        this.especialidad = especialidad;
        this.certificaciones = certificaciones;
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }  
}
