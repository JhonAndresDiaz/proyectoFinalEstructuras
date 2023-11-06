package Controladores;

import Modelos.Aerolinea;
import Modelos.Avion;
import Modelos.Persona;
import Modelos.Vuelo;
import Singleton.Singleton;
import Util.LSE;

/**
 *
 * @author diaza
 */
public class ControladorVentanaVuelosProgramados {
    
    private LSE<Aerolinea> listaAerolineas;
    
    public ControladorVentanaVuelosProgramados(){
        listaAerolineas = Singleton.getInstancia().getAerolineas();
    }
    
    public LSE traerAerolineas(){
        LSE lista = Singleton.getInstancia().getAerolineas();
        return lista;
    }
    
    public LSE<Vuelo> obtenerVuelosUnaAerolinea(int codigo){
        LSE<Vuelo> vuelos = new LSE<>();
        listaAerolineas = Singleton.getInstancia().getAerolineas();
        if(listaAerolineas != null){         
            for (int i = 0; i < listaAerolineas.size(); i++) {
                Aerolinea aerolineaEncontrada = listaAerolineas.get(i);
                if(aerolineaEncontrada.getCodigoAerolinea() == codigo){
                    for (int j = 0; j < aerolineaEncontrada.getListaAviones().size(); j++) {
                        Avion avion = aerolineaEncontrada.getListaAviones().get(j);
                        for (int k = 0; k < avion.getCronograma().size(); k++) {
                            Vuelo vuelo = avion.getCronograma().get(k);
                            if(vuelo.getEstado().equals("Programado")){
                                vuelos.add(vuelo);
                            }
                        }
                    }
                }   
            }
            return vuelos;  
        }
        return new LSE<>();
    }  
    
    public LSE<Vuelo> obtenerTodosVuelos(){
        LSE<Vuelo> vuelos = new LSE<>();
        listaAerolineas = Singleton.getInstancia().getAerolineas();
        if(listaAerolineas != null){         
            for (int i = 0; i < listaAerolineas.size(); i++) {
                Aerolinea aerolineaEncontrada = listaAerolineas.get(i);
                for (int j = 0; j < aerolineaEncontrada.getListaAviones().size(); j++) {
                    Avion avion = aerolineaEncontrada.getListaAviones().get(j);
                    for (int k = 0; k < avion.getCronograma().size(); k++) {
                        Vuelo vuelo = avion.getCronograma().get(k);
                        if(vuelo.getEstado().equals("Programado")){
                            vuelos.add(vuelo);
                        }
                    }
                }              
            }
            return vuelos;  
        }
        return new LSE<>();
    }  
     
    public Avion buscarNumeroAvion(int numero){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                Avion avion = aerolinea.getListaAviones().get(j);
                if(avion.getNumero() == numero){
                    return avion;
                }   
            }
        }
        return null;    
    }
     
    public Aerolinea buscarAerolineaCodigo(int codigo){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if(listaAerolineas.get(i).getCodigoAerolinea() == codigo){
                return listaAerolineas.get(i);
            }  
        }
        return null;    
    }
    
    public Aerolinea buscarAerolineaNumeroAvion(int numeroAvion){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                Avion avion = aerolinea.getListaAviones().get(j);
                if(avion.getNumero() == numeroAvion){
                    return listaAerolineas.get(i);
                }
            }
        }
        return null;
    }
    
    public Aerolinea buscarAerolineaNombre(String nombre){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if(listaAerolineas.get(i).getNombreAerolinea().equals(nombre)){
                return listaAerolineas.get(i);
            }  
        }
        return null;    
    }
    
    public boolean buscarAeroNombre(String nombre){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if(listaAerolineas.get(i).getNombreAerolinea().equals(nombre)){
                return true;
            }  
        }
        return false;    
    }



}
