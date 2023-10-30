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
    private String estado;
    private LocalDate fechaCreacion;

    public Reserva(Vuelo vuelo, String codigo, String estado, LocalDate fechaCreacion) {
        this.vuelo = vuelo;
        this.codigo = codigo;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
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
}
