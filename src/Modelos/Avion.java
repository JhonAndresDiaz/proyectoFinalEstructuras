package Modelos;

import Util.LSE;
import java.io.Serializable;

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
    private String ubicacion;
    private Vuelo vuelo;
    private Mantenimiento mantenimiento;
    private LSE<Vuelo> cronograma;
    private int fila;
    private int bloque;

    public Avion() {
        this.estado = DISPONIBLE;
        cronograma = new LSE<>();
    }
    
    public Avion(int numero, String ubicacion, int fila, int bloque){
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.fila = fila;
        this.bloque = bloque;
    }

    public Avion(String estado, int numero, Vuelo vuelo, Mantenimiento mantenimiento, LSE<Vuelo> cronograma) {
        this.estado = estado;
        this.numero = numero;
        this.vuelo = vuelo;
        this.mantenimiento = mantenimiento;
        this.cronograma = cronograma;
    }

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

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
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
}
