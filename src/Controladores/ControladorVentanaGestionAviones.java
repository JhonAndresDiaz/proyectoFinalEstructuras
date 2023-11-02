package Controladores;

import Excepciones.YaExisteNumeroAvionException;
import Modelos.Aerolinea;
import Modelos.Avion;
import Singleton.Singleton;
import Util.LSE;
import Util.Nodo;
import javax.swing.JOptionPane;

/**
 *
 * @author diaza
 */
public class ControladorVentanaGestionAviones {
    
    private LSE<Aerolinea> listaAerolineas;
    
    public ControladorVentanaGestionAviones() {
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
    
    public LSE<Avion> conseguirAviones(Aerolinea aerolinea) {
        if (aerolinea == null) {
            return new LSE<Avion>();
        }

        LSE<Avion> lista = new LSE<>();
        Nodo<Aerolinea> nodoAerolinea = listaAerolineas.getPrimero();

        while (nodoAerolinea != null) {
            Aerolinea aerolineaActual = nodoAerolinea.getDato();
            if (aerolineaActual.getCodigoAerolinea() == aerolinea.getCodigoAerolinea()) {
                Nodo<Avion> nodoAvion = aerolineaActual.getListaAviones().getPrimero();

                while (nodoAvion != null) {
                    Avion avion = nodoAvion.getDato();
                    lista.add(avion);
                    nodoAvion = nodoAvion.getNodoSiguiente();
                }
            }
            nodoAerolinea = nodoAerolinea.getNodoSiguiente();
        }
        return lista;
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
   
//    public void guardarAvion(Aerolinea aerolinea, Avion avion) {
//        
//        Avion avionBuscado = buscarNumeroAvion(avion.getNumero());
//        
//        if(avionBuscado != null){
//            throw new YaExisteNumeroAvionException();
//        }else {
//            Aerolinea aerolineaBuscada = buscarAerolineaCodigo(aerolinea.getCodigoAerolinea());
//            if(aerolineaBuscada != null){
//                aerolineaBuscada.getListaAviones().add(avion);
//                Singleton.getInstancia().escribirAerolineas();
//            }
//        }    
//    } 
    
        public void guardarAvion(Aerolinea aerolinea, Avion avion) {
        Avion avionBuscado = buscarNumeroAvion(avion.getNumero());

        if (avionBuscado != null) {
            throw new YaExisteNumeroAvionException();
        } else {
            aerolinea.getListaAviones().add(avion);
            Singleton.getInstancia().escribirAerolineas();
        }
    }

    
}
