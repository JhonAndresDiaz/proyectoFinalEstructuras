package Controladores;

import Excepciones.Minimo2DiasDiferenciaException;
import Modelos.Aerolinea;
import Modelos.Avion;
import Modelos.Persona;
import Modelos.Reserva;
import Modelos.Usuario;
import Modelos.Viajero;
import Modelos.Vuelo;
import Singleton.Singleton;
import Util.LSE;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author diaza
 */
public class ControladorVentanaReservaActivas {
    
    private LSE<Aerolinea> listaAerolineas;
    private LSE<Usuario> listaUsuarios;
    
    public ControladorVentanaReservaActivas() {
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
        this.listaUsuarios = Singleton.getInstancia().getUsuarios();
    }

    public LSE<Reserva> obtenerReservas(Viajero viajero) {

        LSE<Reserva> listaReservas = new LSE();

        if(viajero != null){
            for (int i = 0; i < viajero.getHistorialReservas().size(); i++) {
                Reserva reserva = viajero.getHistorialReservas().get(i);
                if(reserva != null){
                    listaReservas.add(reserva);
                }
            }
        }
        return listaReservas; 
    }
    
    public Persona buscarViajeroId(String identificacion){
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getRol().equals("Viajero")){
                Viajero viajero = (Viajero) listaUsuarios.get(i);
                if(viajero.getIdentificacion().equals(identificacion)){
                    return (Persona) listaUsuarios.get(i);
                }
            }
        }
        return null;    
    }
    
    public Vuelo vueloBuscado(int numero) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                Avion avion = aerolinea.getListaAviones().get(j);
                for (int k = 0; k < avion.getCronograma().size(); k++) {
                    if (avion.getCronograma().get(k).getNumVuelo() == numero) {
                        return avion.getCronograma().get(k);
                    }
                }
            }
        }
        return null;
    }
    
    public void cancelarReserva(int numero, Vuelo vuelo, Viajero viajero) {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();

        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                Avion avion = aerolinea.getListaAviones().get(j);
                for (int k = 0; k < avion.getCronograma().size(); k++) {
                    Vuelo vuelos = avion.getCronograma().get(k);
                    if (vuelos.getNumVuelo() == vuelo.getNumVuelo()) {
                        for (int l = 0; l < vuelos.getListaReservas().size(); l++) {
                            Reserva reserva = vuelos.getListaReservas().get(l);
                            LocalDate diaInicioVuelo = reserva.getVuelo().getDiaFinVuelo();
                            LocalTime horaInicioVuelo = reserva.getVuelo().getHoraVuelo();

                            LocalDateTime fechaHoraInicioVuelo = LocalDateTime.of(diaInicioVuelo, horaInicioVuelo);

                            LocalDateTime fechaHoraMinima = fechaHoraInicioVuelo.minusDays(2);

                            if (LocalDateTime.now().isBefore(fechaHoraMinima)) {
                                if (reserva.getPosicion() == numero) {
                                    actualizarHistoViajero(vuelos);
                                    vuelos.getListaReservas().remove(reserva);
                                    Singleton.getInstancia().escribirUsuarios();
                                    Singleton.getInstancia().escribirAerolineas();
                                }
                            } else {
                                throw new Minimo2DiasDiferenciaException();
                            }
                        }
                    }
                }
            }
        }
    }   
    
    private void actualizarHistoViajero(Vuelo vuelo) {
        for (int i = 0; i < vuelo.getListaReservas().size(); i++) {
            Reserva reserva = vuelo.getListaReservas().get(i);
            if(reserva != null){
                Viajero viajeroBuscadoId = (Viajero) buscarViajeroId(reserva.getViajero().getIdentificacion());
                if(viajeroBuscadoId != null){
                    for (int j = 0; j < viajeroBuscadoId.getHistorialReservas().size(); j++) {
                        Reserva reservaViajero = viajeroBuscadoId.getHistorialReservas().get(j);
                        if(reserva.getCodigo().equals(reservaViajero.getCodigo())){
                            viajeroBuscadoId.getHistorialReservas().remove(reserva);
                            Singleton.getInstancia().escribirUsuarios();
                            Singleton.getInstancia().escribirAerolineas();
                        }
                    }
                }
            }
        }
    } 
    
    
}
