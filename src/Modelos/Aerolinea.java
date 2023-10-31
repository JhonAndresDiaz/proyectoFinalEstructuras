package Modelos;

import Util.LSE;
import java.io.Serializable;

/**
 *
 * @author diaza
 */
public class Aerolinea implements Serializable {
    
    private String nombreAerolinea;
    private int codigoAerolinea;
    private String pais;
    private LSE<Avion> listaAviones;
    private LSE<Persona> listaEmpleadosAerolinea;
//    private LSE<AdministradorAerolinea> listaAdministradores;
//    private LSE<EmpleadoLogistica> listaEmpleados;
//    private LSE<CapitanVuelo> listaCapitanes;

    public Aerolinea(String nombreAerolinea, int codigoAerolinea, String pais, LSE<Avion> listaAviones) {
        this.nombreAerolinea = nombreAerolinea;
        this.codigoAerolinea = codigoAerolinea;
        this.pais = pais;
        this.listaAviones = listaAviones;
        this.listaEmpleadosAerolinea = new LSE<>();
        this.listaAviones = listaAviones;
    }

    public Aerolinea(String nombreAerolinea, int codigoAerolinea, String pais, LSE<Avion> listaAviones, LSE<Persona> listaEmpleadosAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
        this.codigoAerolinea = codigoAerolinea;
        this.pais = pais;
        this.listaAviones = listaAviones;
        this.listaEmpleadosAerolinea = listaEmpleadosAerolinea;
    }
    

    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    public int getCodigoAerolinea() {
        return codigoAerolinea;
    }

    public void setCodigoAerolinea(int codigoAerolinea) {
        this.codigoAerolinea = codigoAerolinea;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LSE<Avion> getListaAviones() {
        return listaAviones;
    }

    public void setListaAviones(LSE<Avion> listaAviones) {
        this.listaAviones = listaAviones;
    }

    public LSE<Persona> getListaEmpleadosAerolinea() {
        return listaEmpleadosAerolinea;
    }

    public void setListaEmpleadosAerolinea(LSE<Persona> listaEmpleadosAerolinea) {
        this.listaEmpleadosAerolinea = listaEmpleadosAerolinea;
    }
}
