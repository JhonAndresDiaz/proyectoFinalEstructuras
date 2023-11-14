package Modelos;

import Util.Cola;
import Util.LSE;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDate diaFinVuelo;
    private LocalTime horaVuelo;
    private LocalTime tiempoFin;
    private LSE<Reserva> listaReservas;
    private String estado;
    private Cola<Reserva> colas;

    public Vuelo(Avion avion, CapitanVuelo capitan, int numVuelo, String origen, String destino, int duracion, LocalDate fechaVuelo, LocalTime horaVuelo, LocalTime tiempoFin, LSE<Reserva> listaReservas, String estado, Cola<Reserva> colas) {
        this.avion = avion;
        this.capitan = capitan;
        this.numVuelo = numVuelo;
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.fechaVuelo = fechaVuelo;
        this.diaFinVuelo = calcularDiaFinVuelo(fechaVuelo, horaVuelo, tiempoFin, duracion);
        this.horaVuelo = horaVuelo;
        this.tiempoFin = tiempoFin;
        this.listaReservas = listaReservas;
        this.estado = estado;
        this.colas = colas;
    }
    
    private LocalDate calcularDiaFinVuelo(LocalDate diaInicio, LocalTime horaInicio, LocalTime horaFin, int duracion) {
        LocalDateTime inicio = diaInicio.atTime(horaInicio);
        LocalDateTime fin = inicio.plusMinutes(horaFin.getMinute());

        if (horaFin.isBefore(horaInicio)) {
            fin = fin.plusDays(1);
        }

        return fin.toLocalDate();
    }
    
    public boolean horariosSeCruza(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        if (fechaVuelo.equals(fecha)) {
            if ((horaVuelo.isBefore(horaFin) || horaVuelo.equals(horaFin)) && (tiempoFin.isAfter(horaInicio) || tiempoFin.equals(horaInicio))) {
                return true;
            }
        }
        return false;
    }

    public boolean estaAvionDisponible(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        return avion.estaOcupado(fecha, horaInicio, horaFin);
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

    public LocalDate getDiaFinVuelo() {
        return diaFinVuelo;
    }

    public void setDiaFinVuelo(LocalDate diaFinVuelo) {
        this.diaFinVuelo = diaFinVuelo;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }   

    public LSE<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(LSE<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public Cola<Reserva> getColas() {
        return colas;
    }

    public void setColas(Cola<Reserva> colas) {
        this.colas = colas;
    }
}
