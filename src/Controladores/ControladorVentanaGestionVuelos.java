package Controladores;

import Excepciones.*;
import Modelos.*;
import Singleton.Singleton;
import Util.LSE;
import Util.Nodo;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 *
 * @author diaza
 */
public class ControladorVentanaGestionVuelos {
    
    private LSE<Aerolinea> listaAerolineas;
    
    public ControladorVentanaGestionVuelos() {
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
    }
    
    public LSE<Viajero> obtenerListaViajeros(int codigo) {
        Vuelo vuelo = vueloBuscado(codigo);
        return (vuelo != null && !vuelo.getListaViajeros().isEmpty()) ? vuelo.getListaViajeros() : new LSE<>();
    }
    
    public LSE<Avion> traerAerolineas(){
        LSE<Avion> listaAviones = new LSE<>();
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                if(aerolinea.getListaAviones().get(j).getEstado().equals("Disponible")){
                    listaAviones.add(aerolinea.getListaAviones().get(j));
                }
            }
        }
        return listaAviones;
    }
    
    public LSE<Vuelo> obtenerVuelos(Aerolinea aerolineaRecibida) {
        LSE<Vuelo> listaVuelos = new LSE<>();

        for (int i = 0; i < aerolineaRecibida.getListaAviones().size(); i++) {
            Avion avion = aerolineaRecibida.getListaAviones().get(i);
            for (int j = 0; j < avion.getCronograma().size(); j++) {
                Vuelo vuelo = avion.getCronograma().get(j);
                listaVuelos.add(vuelo);
            }
        }
        return listaVuelos;
    }

    
    public LSE<CapitanVuelo> conseguirCapitanes(Aerolinea aerolinea) {
        LSE<CapitanVuelo> lista = new LSE<>();
        Nodo<Aerolinea> nodoAerolinea = listaAerolineas.getPrimero();

        while (nodoAerolinea != null) {
            Aerolinea aerolineaActual = nodoAerolinea.getDato();
            if (aerolineaActual.getCodigoAerolinea() == aerolinea.getCodigoAerolinea()) {
                Nodo<Persona> nodoEmpleado = aerolineaActual.getListaEmpleadosAerolinea().getPrimero();

                while (nodoEmpleado != null) {
                    if (nodoEmpleado.getDato() instanceof CapitanVuelo) {
                        lista.add((CapitanVuelo) nodoEmpleado.getDato());
                    }
                    nodoEmpleado = nodoEmpleado.getNodoSiguiente();
                }
            }
            nodoAerolinea = nodoAerolinea.getNodoSiguiente();
        }
        return lista;
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
    
    public Aerolinea buscarAerolineaAvion(int numero){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                if (aerolinea.getListaAviones().get(j).getNumero() == numero) {
                    return listaAerolineas.get(i);
                }
            }
        }
        return null;    
    }

    public LSE<Avion> conseguirAviones(Aerolinea aerolinea) {
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
    
    public Persona buscarCapitanVuelo(String nombre){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                if(aerolinea.getListaEmpleadosAerolinea().get(j).getNombres().equals(nombre) && aerolinea.getListaEmpleadosAerolinea().get(j).getRol().equals("Capitan Vuelo")){
                    return aerolinea.getListaEmpleadosAerolinea().get(j);
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
    
    public Aerolinea buscarAeroNombre(String nombre){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if(listaAerolineas.get(i).getNombreAerolinea().equals(nombre)){
                return listaAerolineas.get(i);
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
    
    public void guardarVuelo(Aerolinea aerolinea, Avion avion, Vuelo vuelo) {
        
        Vuelo vueloBuscado = vueloBuscado(vuelo.getNumVuelo());

        if (vueloBuscado != null) {
            throw new YaExisteNumeroVueloException();
        }

        Avion avionBuscado = buscarNumeroAvion(avion.getNumero());
        Aerolinea aerolineaBuscada = buscarAerolineaCodigo(aerolinea.getCodigoAerolinea());
        
        LocalDate fechaVuelo = vuelo.getFechaVuelo();
        LocalTime horaInicio = vuelo.getHoraVuelo();
        LocalTime horaFin = vuelo.getTiempoFin();

        if (avion.estaOcupado(fechaVuelo, horaInicio, horaFin)) {
            throw new AvionNoDisponibleException();
        }

        if (aerolinea.estaCapitanDisponible(vuelo.getCapitan(), fechaVuelo, horaInicio, horaFin)) {
            throw new CapitanNoDisponibleException();
        }
        
        for (int i = 0; i < aerolineaBuscada.getListaAviones().size(); i++) {
            Avion avionRecorrido = aerolineaBuscada.getListaAviones().get(i);
            if (avionRecorrido.getNumero() == avionBuscado.getNumero()) {
                avionRecorrido.getCronograma().add(vuelo);
                Singleton.getInstancia().escribirAerolineas();
                return;
            }
        }
    }
    
    public void editarVuelo(Vuelo vueloEditado, Avion avion, Aerolinea aerolinea) {
        Vuelo vueloBuscado = vueloBuscado(vueloEditado.getNumVuelo());

        if (avion.estaOcupado(vueloEditado.getFechaVuelo(), vueloEditado.getHoraVuelo(), vueloEditado.getTiempoFin())) {
            throw new AvionNoDisponibleException();
        }

        if (aerolinea.estaCapitanDisponible(vueloEditado.getCapitan(), vueloEditado.getFechaVuelo(), vueloEditado.getHoraVuelo(), vueloEditado.getTiempoFin())) {
            throw new CapitanNoDisponibleException();
        }
        
        if(!vueloBuscado.getListaViajeros().isEmpty()){
            throw new ExistenViajerosEnListaException();
        }

            vueloBuscado.setFechaVuelo(vueloEditado.getFechaVuelo());
            vueloBuscado.setOrigen(vueloEditado.getOrigen());
            vueloBuscado.setDestino(vueloEditado.getDestino());
            vueloBuscado.setDuracion(vueloEditado.getDuracion());
            vueloBuscado.setTiempoFin(vueloEditado.getTiempoFin());
            vueloBuscado.setHoraVuelo(vueloEditado.getHoraVuelo());
            Singleton.getInstancia().escribirAerolineas();
         
    }


//    public void guardarVuelo(Aerolinea aerolinea, Avion avion, Vuelo vuelo) {
//        Vuelo vueloBuscado = vueloBuscado(vuelo.getNumVuelo());
//
//        if (vueloBuscado != null) {
//            throw new YaExisteNumeroVueloException();
//        } else {
//            Avion avionBuscado = buscarNumeroAvion(avion.getNumero());
//            Aerolinea aerolineaBuscada = buscarAerolineaCodigo(aerolinea.getCodigoAerolinea());
//
//            if (avionBuscado != null && aerolineaBuscada != null) {
//                LocalDate fechaVuelo = vuelo.getFechaVuelo();
//                LocalTime horaInicio = vuelo.getHoraVuelo();
//                LocalTime horaFin = vuelo.getTiempoFin();
//            
//                if (!vuelo.estaAvionDisponible(fechaVuelo, horaInicio, horaFin)) {
//                    if (!vuelo.estaCapitanDisponible(vuelo.getCapitan(), fechaVuelo, horaInicio, horaFin)) {
//                        for (int i = 0; i < aerolineaBuscada.getListaAviones().size(); i++) {
//                            Avion avionRecorrido = aerolineaBuscada.getListaAviones().get(i);
//                            if (avionRecorrido.getNumero() == avionBuscado.getNumero()) {
//                                avionRecorrido.getCronograma().add(vuelo);
//                                Singleton.getInstancia().escribirAerolineas();
//                            }
//                        }
//                    } else {
//                        throw new CapitanNoDisponibleException();
//                    }
//                } else {
//                    throw new AvionNoDisponibleException();
//                }
//            }
//        }
//    }
    

}
