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
public class Avion implements Serializable{
    
    public static final String DISPONIBLE = "Disponible";
    public static final String OCUPADO = "Ocupado";
    public static final String DESHABILITADO = "Deshabilitado";
    private String estado; 
    
    private int numero;
    private Mantenimiento mantenimiento;
    private LSE<Vuelo> cronograma;
    private int fila;
    private int bloque;

    public Avion(int numero, int fila, int bloque){
        this.numero = numero;
        this.fila = fila;
        this.bloque = bloque;
        this.estado = DISPONIBLE;
        cronograma = new LSE<>();
    }

    public Avion(String estado, int numero, Vuelo vuelo, Mantenimiento mantenimiento, LSE<Vuelo> cronograma) {
        this.estado = estado;
        this.numero = numero;
        this.mantenimiento = mantenimiento;
        this.cronograma = cronograma;
    }    
    
    public boolean estaOcupado(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        Nodo<Vuelo> primerVuelo = cronograma.getPrimero();
        while (primerVuelo != null) {
            Vuelo vuelo = primerVuelo.getDato();
            if (vuelo.horariosSeCruzan(horaInicio, horaFin) && vuelo.getFechaVuelo().equals(fecha)) {
                return true;
            }
            primerVuelo = primerVuelo.getNodoSiguiente();
        }
        return false;
    }
            
//    public boolean estaOcupado(LocalTime horaInicio, LocalTime horaFin) {
//        Nodo<Vuelo> primerVuelo = cronograma.getPrimero();
//        while (primerVuelo != null) {
//            Vuelo vuelo = primerVuelo.getDato();
//            if (vuelo.horariosSeCruzan(horaInicio, horaFin)) {
//                return true;
//            }
//            primerVuelo = primerVuelo.getNodoSiguiente();
//        }
//        return false;
//    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public LSE<Vuelo> getCronograma() {
        return cronograma;
    }

    public void setCronograma(LSE<Vuelo> cronograma) {
        this.cronograma = cronograma;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }
}
