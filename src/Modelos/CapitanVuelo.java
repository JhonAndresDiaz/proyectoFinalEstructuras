package Modelos;

import Util.LSE;
import java.io.Serializable;

/**
 *
 * @author diaza
 */
public class CapitanVuelo extends Persona implements Serializable {

    private String licenciaDePiloto;
    private String tipoCertificado;

    public CapitanVuelo(String licenciaDePiloto, String tipoCertificado, String identificacion, String nombres, String apellidos, int edad, String genero, String numTelefono, String correo, String contrasenia, String rol) {
        super(identificacion, nombres, apellidos, edad, genero, numTelefono, correo, contrasenia, rol);
        this.licenciaDePiloto = licenciaDePiloto;
        this.tipoCertificado = tipoCertificado;
    }

    public String getLicenciaDePiloto() {
        return licenciaDePiloto;
    }

    public void setLicenciaDePiloto(String licenciaDePiloto) {
        this.licenciaDePiloto = licenciaDePiloto;
    }

    public String getTipoCertificado() {
        return tipoCertificado;
    }

    public void setTipoCertificado(String tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }
}
