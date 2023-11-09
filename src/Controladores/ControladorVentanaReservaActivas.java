package Controladores;

import Modelos.Aerolinea;
import Modelos.Persona;
import Modelos.Reserva;
import Modelos.Usuario;
import Modelos.Viajero;
import Singleton.Singleton;
import Util.LSE;

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
    
    
}
