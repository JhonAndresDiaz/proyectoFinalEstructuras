package Controladores;

import Excepciones.ExistenVuelosEnAvionException;
import Excepciones.NumeroCodigoVueloNoExisteException;
import Excepciones.YaExisteNumeroAvionException;
import Modelos.Aerolinea;
import Modelos.Avion;
import Modelos.Persona;
import Modelos.Vuelo;
import Singleton.Singleton;
import Util.LSE;
import Util.Nodo;
import Util.Pila;
import javax.swing.JOptionPane;

/**
 *
 * @author diaza
 */
public class ControladorVentanaGestionAviones {
    
    private LSE<Aerolinea> listaAerolineas;
    private Pila<LSE<Avion>> z;
    private Pila<LSE<Avion>> y;
    
    public ControladorVentanaGestionAviones() {
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
        this.z = new Pila<>();
        this.y = new Pila<>();
    }
    
    public Pila<LSE<Avion>> getZ() {
        return z;
    }

    public Pila<LSE<Avion>> getY() {
        return y;
    }

    public void controlY(int codigo) {
        Aerolinea aerolineaRecibida = buscarAerolineaCodigoAero(codigo);
        if (aerolineaRecibida != null) {
            LSE<Avion> listaAviones = y.pop();

            if (listaAviones != null) {
                aerolineaRecibida.setListaAviones(listaAviones);

                Singleton.getInstancia().setListaAerolineas(listaAerolineas);
                Singleton.getInstancia().escribirAerolineas();
            } else {
            }
        }
    }
    
    public void controlZ(int codigo) {
        Aerolinea aerolineaRecibida = buscarAerolineaCodigoAero(codigo);
        if (aerolineaRecibida != null) {
            LSE<Avion> listaAviones = z.pop();

            if (listaAviones != null) {
                aerolineaRecibida.getListaAviones().limpiar();

                for (int i = 0; i < listaAviones.size(); i++) {
                    aerolineaRecibida.getListaAviones().insertarAlFinal(listaAviones.get(i));
                }
                Singleton.getInstancia().setListaAerolineas(listaAerolineas);
                Singleton.getInstancia().escribirAerolineas();
            } else {
            }
        }
    }
    
    public void limpiarY(){
        if(!y.isEmpty()){
            y = new Pila<>();
        }
    }
    
    public void respaldoZ(int codigo) {
        
        Aerolinea aerolineaRecibida = buscarAerolineaCodigoAero(codigo);
        if(aerolineaRecibida != null){
            for (int i = 0; i < listaAerolineas.size(); i++) {
                Aerolinea aerolinea = listaAerolineas.get(i);
                if (aerolinea.getCodigoAerolinea() == aerolineaRecibida.getCodigoAerolinea()) {
                    LSE<Avion> respaldoAviones = aerolineaRecibida.getListaAviones().clone();
                    z.push(respaldoAviones);
                }
            }
        } 
    }

    public void respaldoY(int codigo) {
        
        Aerolinea aerolineaRecibida = buscarAerolineaCodigoAero(codigo);
        if(aerolineaRecibida != null){
            for (int i = 0; i < listaAerolineas.size(); i++) {
                Aerolinea aerolinea = listaAerolineas.get(i);
                if (aerolinea.getCodigoAerolinea() == aerolineaRecibida.getCodigoAerolinea()) {
                    LSE<Avion> respaldoAviones = aerolineaRecibida.getListaAviones().clone();
                    y.push(respaldoAviones);
                }
            }
        }  
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
    
    public Aerolinea buscarAerolineaCodigoAero(int codigo){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if(listaAerolineas.get(i).getCodigoAerolinea() == codigo){
                return listaAerolineas.get(i);
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
    
    public void eliminarAvion(int codigo) {
        Avion aux = buscarNumeroAvion(codigo);
        if (aux != null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
                Aerolinea aerolinea = listaAerolineas.get(i);
                for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                    Avion avion = aerolinea.getListaAviones().get(j);
                    if (avion.getNumero() == aux.getNumero()) {
                        if (avion.getCronograma().isEmpty() || todosVuelosTerminados(avion.getCronograma())) {
                            aerolinea.getListaAviones().remove(j);
                            Singleton.getInstancia().escribirAerolineas();
                            return;
                        } else {
                            throw new ExistenVuelosEnAvionException();
                        }
                    }
                }
            }
        } else {
            throw new NumeroCodigoVueloNoExisteException();
        }
    }

    private boolean todosVuelosTerminados(LSE<Vuelo> cronograma) {
        Nodo<Vuelo> nodoActual = cronograma.getPrimero();
        while(nodoActual != null) {
            Vuelo vuelo = nodoActual.getDato();

            if(vuelo.getEstado().equals("Programado")) {
                return false;
            }
            nodoActual = nodoActual.getNodoSiguiente();
        }
        return true;
    }
    
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
