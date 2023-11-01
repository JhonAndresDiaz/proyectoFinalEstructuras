package Modelos;

import Util.LSE;
import Util.Nodo;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author diaza
 */
public class Vuelo implements Serializable {
    
    private Avion avion;
    private CapitanVuelo capitan;
    private int numVuelo;
    private String origen;
    private String destino;
    private int duracion;
    private LocalDate fechaVuelo;
    private LocalTime horaVuelo;
    private LocalTime tiempoFin;
    private LSE<Viajero> listaViajeros;
    private String estado;

    public Vuelo(Avion avion, CapitanVuelo capitan, int numVuelo, String origen, String destino, int duracion, LocalDate fechaVuelo, LocalTime horaVuelo, LocalTime tiempoFin, LSE<Viajero> listaViajeros, String estado) {
        this.avion = avion;
        this.capitan = capitan;
        this.numVuelo = numVuelo;
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.fechaVuelo = fechaVuelo;
        this.horaVuelo = horaVuelo;
        this.tiempoFin = tiempoFin;
        this.listaViajeros = listaViajeros;
        this.estado = estado;
    }
    
//    public boolean horariosSeCruzan(LocalTime horaInicio, LocalTime horaFin) {
//        return (horaVuelo.isBefore(horaFin) || horaVuelo.equals(horaFin)) &&
//           (tiempoFin.isAfter(horaInicio) || tiempoFin.equals(horaInicio));
//    }
    
    public boolean horariosSeCruzan(LocalTime horaInicio, LocalTime horaFin) {
        return !horaVuelo.isAfter(horaFin) && !tiempoFin.isBefore(horaInicio);
    }

    public boolean estaAvionDisponible(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        return !avion.estaOcupado(fecha, horaInicio, horaFin);
    }

    public boolean estaCapitanDisponible(CapitanVuelo capitan, LocalDate fecha) {
        Avion avion = this.getAvion();
        LSE<Vuelo> cronogramaAvion = avion.getCronograma();

        Nodo<Vuelo> current = cronogramaAvion.getPrimero();
        while (current != null) {
            Vuelo vuelo = current.getDato();
            if (vuelo.getCapitan() == capitan && vuelo.getFechaVuelo().equals(fecha) && vuelo.horariosSeCruzan(horaVuelo, tiempoFin)) {
                return true;
            }
            current = current.getNodoSiguiente();
        }
        return false;
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

    public int getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(int numVuelo) {
        this.numVuelo = numVuelo;
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
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

    public LocalTime getTiempoFin() {
        return tiempoFin;
    }

    public void setTiempoFin(LocalTime tiempoFin) {
        this.tiempoFin = tiempoFin;
    }

    public LSE<Viajero> getListaViajeros() {
        return listaViajeros;
    }

    public void setListaViajeros(LSE<Viajero> listaViajeros) {
        this.listaViajeros = listaViajeros;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
