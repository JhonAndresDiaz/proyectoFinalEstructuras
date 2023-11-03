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
    
    public Aerolinea buscarAerolineaCodigo(int codigo){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if(listaAerolineas.get(i).getCodigoAerolinea() == codigo){
                return listaAerolineas.get(i);
            }  
        }
        return null;    
    }
    
    public LSE<Vuelo> obtenerVuelos() {

        LSE<Vuelo> listaVuelos = new LSE();

        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                Avion avion = aerolinea.getListaAviones().get(j);
                if(avion != null && avion.getCronograma() != null){
                    for (int k = 0; k < avion.getCronograma().size(); k++) {
                        Vuelo vuelo = avion.getCronograma().get(k);
                        listaVuelos.add(vuelo);
                        
                    }
                }
            }
        }
        return listaVuelos; 
    }
    
}
