package Controladores;

import Excepciones.*;
import Modelos.*;
import Singleton.Singleton;
import Util.Cola;
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
    private LSE<Mantenimiento> listaMantenimientos;
    
    public ControladorVentanaGestionVuelos() {
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
        this.listaMantenimientos = Singleton.getInstancia().getMantenimientos();
    }
    
    public LSE<Reserva> obtenerListaViajeros(int codigo) {
        Vuelo vuelo = vueloBuscado(codigo);
        return (vuelo != null && !vuelo.getListaReservas().isEmpty()) ? vuelo.getListaReservas() : new LSE<>();
    }
    
    public Cola<Reserva> obtenerColas(int numeroVuelo){
        Vuelo vuelo = vueloBuscado(numeroVuelo);
        return (vuelo != null && !vuelo.getColas().isEmpty()) ? vuelo.getColas() : new Cola<>();
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
        Aerolinea aerolinea = buscarAerolineaCodigo(aerolineaRecibida.getCodigoAerolinea());

        if (aerolinea == null) {
            return new LSE<Vuelo>(); 
        }

        LSE<Vuelo> listaVuelos = new LSE();

        for (int i = 0; i < aerolinea.getListaAviones().size(); i++) {
            Avion avion = aerolinea.getListaAviones().get(i);

            if (avion != null && avion.getCronograma() != null) {
                for (int j = 0; j < avion.getCronograma().size(); j++) {
                    Vuelo vuelo = avion.getCronograma().get(j);

                    if (vuelo != null) {
                        listaVuelos.add(vuelo);
                    }
                }
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
        LocalDate fechFin = vuelo.getDiaFinVuelo();

        if (avion.estaOcupado(fechFin, horaInicio, horaFin)){
            throw new AvionNoDisponibleException();
        }
        
        if (aerolinea.estaCapitanDisponible(vuelo.getCapitan(), fechFin, horaInicio, horaFin)) {
            throw new CapitanNoDisponibleException();
        }
        
        for (int i = 0; i < listaMantenimientos.size(); i++) {
            Mantenimiento mantenimiento = listaMantenimientos.get(i);
            if(mantenimiento.getAvion().getNumero() == avion.getNumero()){
                if(mantenimiento.getEstado().equals("En progreso")){
                    LocalDate fechaInicioMantenimiento = mantenimiento.getFechaInicio();
                    LocalDate fechaFinMantenimiento = mantenimiento.getFechaFin();
                        if(vuelo.getFechaVuelo().isAfter(fechaInicioMantenimiento) && vuelo.getFechaVuelo().isBefore(fechaFinMantenimiento)
                        || vuelo.getFechaVuelo().isEqual(fechaInicioMantenimiento) || vuelo.getFechaVuelo().isEqual(fechaFinMantenimiento)) {
                            throw new AvionEstaEnMantenimientoException();
                    } 
                }
            }
        }

        for (int i = 0; i < aerolineaBuscada.getListaAviones().size(); i++) {
            Avion avionRecorrido = aerolineaBuscada.getListaAviones().get(i);
            if (avionRecorrido.getNumero() == avionBuscado.getNumero()) {
                if (!avionRecorrido.getCronograma().isEmpty()) {
                    Vuelo vueloAnterior = null;
                    LSE<Vuelo> cronograma = avionRecorrido.getCronograma();
                    for (int j = 0; j < cronograma.size(); j++) {
                        Vuelo vueloActual = cronograma.get(j);
                        if (vueloActual.getFechaVuelo().isBefore(fechaVuelo) ||
                            (vueloActual.getFechaVuelo().isEqual(fechaVuelo) && vueloActual.getHoraVuelo().isBefore(horaInicio))) {
                            vueloAnterior = vueloActual;
                           
                        }
                    }

                    if (vueloAnterior != null && !vueloAnterior.getDestino().equals(vuelo.getOrigen())) {
                        throw new OrigenNoCoincideConDestinoException();
                    }
                }

                avionRecorrido.getCronograma().add(vuelo);
                Singleton.getInstancia().escribirAerolineas();

                Vuelo vueloMasAntiguo = null;
                LSE<Vuelo> cronograma = avionRecorrido.getCronograma();
                for (int j = 0; j < cronograma.size(); j++) {
                    Vuelo vueloActual = cronograma.get(j);

                    if (vueloActual.getEstado().equals("Programado")) {
                        LocalDate fechaActual = vueloActual.getFechaVuelo();
                        LocalTime horaActual = vueloActual.getHoraVuelo();

                        if (vueloMasAntiguo == null || fechaActual.isBefore(vueloMasAntiguo.getFechaVuelo()) ||
                                (fechaActual.isEqual(vueloMasAntiguo.getFechaVuelo()) && horaActual.isBefore(vueloMasAntiguo.getHoraVuelo()))) {
                            vueloMasAntiguo = vueloActual;
                        }
                    }
                }

                if (vueloMasAntiguo != null) {
                    avion.setUbicacion(vueloMasAntiguo.getOrigen());
                    Singleton.getInstancia().escribirAerolineas();
                } else {
                }
                return;
            }
        }
    }
  
    public void editarVuelo(Aerolinea aerolinea, Avion avion, Vuelo vueloNuevo) {
        Vuelo vueloAntiguo = vueloBuscado(vueloNuevo.getNumVuelo());
        if (aerolinea != null && avion != null) {
            LocalDate fechaVueloNuevo = vueloNuevo.getFechaVuelo();
            LocalTime horaInicioNuevo = vueloNuevo.getHoraVuelo();
            LocalTime horaFinNuevo = vueloNuevo.getTiempoFin();
            LocalDate fechaFin = vueloNuevo.getDiaFinVuelo();

            if (avion.estaOcupado(fechaFin, horaFinNuevo, horaFinNuevo)){
                throw new AvionNoDisponibleException();
            }

            if (aerolinea.estaCapitanDisponible(vueloNuevo.getCapitan(), fechaVueloNuevo, horaInicioNuevo, horaFinNuevo)) {
                throw new CapitanNoDisponibleException();
            }

            if (!vueloAntiguo.getListaReservas().isEmpty()) {
                throw new ExistenViajerosEnListaException();
            }

            avion.getCronograma().remove(vueloAntiguo);
            avion.getCronograma().add(vueloNuevo);
            Singleton.getInstancia().escribirAerolineas();
        } else {
            throw new AvionNoDisponibleException();
        }
    }

    private Vuelo buscarVueloPorNumeroYFecha(int numeroVuelo, LocalDate fechaVuelo) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                Avion avion = aerolinea.getListaAviones().get(j);
                for (int k = 0; k < avion.getCronograma().size(); k++) {
                    Vuelo vuelo = avion.getCronograma().get(k);
                    if (vuelo.getNumVuelo() == numeroVuelo && vuelo.getFechaVuelo().equals(fechaVuelo)) {
                        return vuelo;
                    }
                }
            }
        }
        return null;
    }

    public void eliminarVuelo(int codigo) {
        Vuelo aux = vueloBuscado(codigo);

        if (aux != null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
                Aerolinea aerolinea = listaAerolineas.get(i);
                for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                    Avion avion = aerolinea.getListaAviones().get(j);
                    for (int k = 0; k < avion.getCronograma().size(); k++) {
                        Vuelo vuelo = avion.getCronograma().get(k);
                        if (vuelo.getListaReservas().isEmpty()) {
                            if (vuelo.getNumVuelo() == aux.getNumVuelo()) {
                                avion.getCronograma().remove(k); 
                                Singleton.getInstancia().escribirAerolineas();
                                return; 
                            }
                        } else {
                            throw new ExistenViajerosEnListaException();
                        }
                    }
                }             
            }
        } else {
            throw new NumeroCodigoVueloNoExisteException();
        }      
    }
}
