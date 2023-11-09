package Modelos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author diaza
 */
public class Reserva implements Serializable {
    
    private Vuelo vuelo;
    private String codigo;
    private int posicion;
    private String estado;
    private LocalDate fechaCreacion;
    private Viajero viajero;

    public Reserva(Vuelo vuelo, String codigo, int posicion, String estado, LocalDate fechaCreacion, Viajero viajero) {
        this.vuelo = vuelo;
        this.codigo = codigo;
        this.posicion = posicion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.viajero = viajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Viajero getViajero() {
        return viajero;
    }

    public void setViajero(Viajero viajero) {
        this.viajero = viajero;
    }
}
