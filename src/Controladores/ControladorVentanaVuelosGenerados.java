package Controladores;

import Modelos.Aerolinea;
import Modelos.Avion;
import Modelos.Vuelo;
import Singleton.Singleton;
import Util.LSE;

/**
 *
 * @author diaza
 */
public class ControladorVentanaVuelosGenerados {
    
    private LSE<Aerolinea> listaAerolineas;

    public ControladorVentanaVuelosGenerados() {
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
    }

    public Aerolinea buscarAerolineaPersona(String id){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                if(aerolinea.getListaEmpleadosAerolinea().get(j).getIdentificacion().equals(id)){
                    return listaAerolineas.get(i);
                }
            }
        }
        return null;    
    }
    
    public LSE<Vuelo> obtenerVuelosAerolinea(Aerolinea aerolinea) {

        LSE<Vuelo> listaVuelos = new LSE();

        if(aerolinea != null){
            for (int i = 0; i < aerolinea.getListaAviones().size(); i++) {
                Avion avion = aerolinea.getListaAviones().get(i);
                for (int j = 0; j < avion.getCronograma().size(); j++) {
                    Vuelo vuelo = avion.getCronograma().get(j);
                    if(vuelo != null){
                        listaVuelos.add(vuelo);
                    }
                }
            }       
        }
        return listaVuelos; 
    }
}
