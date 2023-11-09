package Controladores;

import Modelos.*;
import Singleton.Singleton;
import Util.LSE;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author diaza
 */
public class ControladorVerAvion {
    
    private LSE<Aerolinea> listaAerolineas;

    public ControladorVerAvion(){
        listaAerolineas = Singleton.getInstancia().getAerolineas();
    }
    
    public LSE<Reserva> validar1ReservaVuelo(Viajero viajero, Vuelo vuelo) {
        
        LSE<Reserva> contador = new LSE<> ();
        LSE<Reserva> listaReservas = vuelo.getListaReservas();
        for (int i = 0; i < listaReservas.size(); i++) {
            Reserva reserva = listaReservas.get(i);
            if(reserva.getEstado().equals("Activa") && reserva.getViajero().getIdentificacion().equals(viajero.getIdentificacion())) {
                contador.add(listaReservas.get(i));
            }
        }
        return contador;
    }
    
    public boolean verificarReservaPropia(int numeroAsiento, LSE<Reserva> listaReservas, Viajero viajero) {

        for (int i = 0; i < listaReservas.size(); i++) {
            Reserva reserva = listaReservas.get(i);
            if(reserva != null){
               if(reserva.getPosicion() == numeroAsiento){
                   if(reserva.getViajero().getIdentificacion().equals(viajero.getIdentificacion())){
                       return true;
                   }     
               } 
            }         
        }
        return false; 
    }

    public boolean verificarReserva(int numeroAsiento, LSE<Reserva> listaReservas) {

        for (int i = 0; i < listaReservas.size(); i++) {
            Reserva reserva = listaReservas.get(i);
            if ( reserva.getPosicion() == numeroAsiento) {
                return true;
            }           
        }
        return false; 
    }

    public void generarReserva(int numero , Vuelo vuelo ,Viajero viajero) {
        String codigo = generarCodigoAleatorio();
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                Avion avion = aerolinea.getListaAviones().get(j);
                for (int k = 0; k < avion.getCronograma().size(); k++) {
                    Vuelo cronograma = avion.getCronograma().get(k);
                    if (cronograma.getNumVuelo() == vuelo.getNumVuelo()) {
                        Reserva reserva = new Reserva(vuelo, codigo, numero, "Activa", LocalDate.now(), viajero);
                        cronograma.getListaReservas().add(reserva);
                        viajero.getHistorialReservas().add(reserva);
                        Singleton.getInstancia().escribirUsuarios();
                        Singleton.getInstancia().escribirAerolineas();
                    }
                }
            }
        }   
    }
    
    public String generarCodigoAleatorio() {
        String caracteres = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder codigo = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int indice = random.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(indice));
        }
        return codigo.toString();
    }
    
}
