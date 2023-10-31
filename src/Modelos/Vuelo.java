package Modelos;

import Util.LSE;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author diaza
 */
public class Vuelo implements Serializable {
    
    private String origen;
    private String destino;
    private Avion avion;
    private CapitanVuelo capitan;
    private LocalDate fechaVuelo;
    private LocalTime horaVuelo;
    private LocalTime tiempoTrayecto;
    private LSE<Viajero> listaViajeros;

    public Vuelo(String origen, String destino, Avion avion, CapitanVuelo capitan, LocalDate fechaVuelo, LocalTime horaVuelo, LocalTime tiempoTrayecto, LSE<Viajero> listaViajeros) {
        this.origen = origen;
        this.destino = destino;
        this.avion = avion;
        this.capitan = capitan;
        this.fechaVuelo = fechaVuelo;
        this.horaVuelo = horaVuelo;
        this.tiempoTrayecto = tiempoTrayecto;
        this.listaViajeros = listaViajeros;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public CapitanVuelo getCapitan() {
        return capitan;
    }

    public void setCapitan(CapitanVuelo capitan) {
        this.capitan = capitan;
    }

    public LocalDate getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(LocalDate fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public LocalTime getHoraVuelo() {
        return horaVuelo;
    }

    public void setHoraVuelo(LocalTime horaVuelo) {
        this.horaVuelo = horaVuelo;
    }

    public LocalTime getTiempoTrayecto() {
        return tiempoTrayecto;
    }

    public void setTiempoTrayecto(LocalTime tiempoTrayecto) {
        this.tiempoTrayecto = tiempoTrayecto;
    }

    public LSE<Viajero> getListaViajeros() {
        return listaViajeros;
    }

    public void setListaViajeros(LSE<Viajero> listaViajeros) {
        this.listaViajeros = listaViajeros;
    }
}
