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
public class Aerolinea implements Serializable {
    
    private String nombreAerolinea;
    private int codigoAerolinea;
    private String pais;
    private LSE<Avion> listaAviones;
    private LSE<Persona> listaEmpleadosAerolinea;
    
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
    
    public boolean estaCapitanDisponible(CapitanVuelo capitan, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        
        for (int i = 0; i < listaAviones.size(); i++) {
            Avion avion = listaAviones.get(i);
            Nodo<Vuelo> primerVuelo = avion.getCronograma().getPrimero();
            while(primerVuelo != null) {
                Vuelo vuelo = primerVuelo.getDato();
                if (vuelo != null) {
                    if (vuelo.getCapitan().getIdentificacion() == capitan.getIdentificacion() && vuelo.horariosSeCruza(fecha, horaInicio, horaFin) && vuelo.getEstado().equals("Programado")) {
                        return true; 
                    }
                }
                primerVuelo = primerVuelo.getNodoSiguiente();
            }
        }
        return false;
    }
    
//    public boolean estaCapitanDisponible(CapitanVuelo capitan, LocalDate fecha) {
//    for (int i = 0; i < listaAviones.size(); i++) {
//        Avion avion = listaAviones.get(i);
//        Nodo<Vuelo> primerVuelo = avion.getCronograma().getPrimero();
//        while (primerVuelo != null) {
//            Vuelo vuelo = primerVuelo.getDato();
//            if (vuelo != null) {
//                if (vuelo.getCapitan().getIdentificacion() == capitan.getIdentificacion() &&
//                    vuelo.getFechaVuelo().isEqual(fecha) &&
//                    vuelo.horariosSeCruzan(vuelo.getHoraVuelo(), vuelo.getTiempoFin()) &&
//                    vuelo.getEstado().equals("Programado")) {
//                    return true;
//                }
//            }
//            primerVuelo = primerVuelo.getNodoSiguiente();
//        }
//    }
//    return false;
//}anterior
    
//    public boolean estaCapitanDisponible(CapitanVuelo capitan, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
//        
//        for (int i = 0; i < listaAviones.size(); i++) {
//            Avion avion = listaAviones.get(i);
//            Nodo<Vuelo> primerVuelo = avion.getCronograma().getPrimero();
//            while(primerVuelo != null) {
//                Vuelo vuelo = primerVuelo.getDato();
//                if (vuelo != null) {
//                    if (vuelo.getCapitan().getIdentificacion() == capitan.getIdentificacion() & vuelo.getFechaVuelo().equals(fecha) && vuelo.horariosSeCruzan(horaInicio, horaFin) && vuelo.getEstado().equals("Programado")) {
//                        return true; 
//                    }
//                }
//                primerVuelo = primerVuelo.getNodoSiguiente();
//            }
//        }
//        return false;
//    }

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
