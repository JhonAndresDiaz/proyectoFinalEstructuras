package Modelos;

import java.io.Serializable;

/**
 *
 * @author diazje
 */
public class Usuario implements Serializable{
    
    protected String correo;
    protected String contrasenia;
    protected String rol;

    public Usuario(String correo, String contrasenia, String rol) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
