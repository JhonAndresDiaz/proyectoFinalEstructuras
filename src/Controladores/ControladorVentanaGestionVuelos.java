package Controladores;

import Excepciones.*;
import Modelos.*;
import Singleton.Singleton;
import Util.LSE;
import Util.Nodo;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;


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

            // Suponiendo que ya tienes el vuelo que acabas de guardar en la variable 'vuelo'
            LocalDate fechaVueloGuardado = vuelo.getFechaVuelo();
            LocalTime horaVueloGuardado = vuelo.getHoraVuelo();

            for (int j = 0; j < avionRecorrido.getCronograma().size(); j++) {
                Vuelo vueloActual = avionRecorrido.getCronograma().get(j);

                // Verificar si el vuelo actual es posterior al vuelo guardado
                if (vueloActual.getEstado().equals("Espera")) {
                    LocalDate fechaActual = vueloActual.getFechaVuelo();
                    LocalTime horaActual = vueloActual.getHoraVuelo();

                    if ((fechaActual.isAfter(fechaVueloGuardado) || fechaActual.isEqual(fechaVueloGuardado)) &&
                        (horaActual.isAfter(horaVueloGuardado) || horaActual.equals(horaVueloGuardado))) {
                        break; // Detener la búsqueda, hemos alcanzado el vuelo más cercano posterior
                    }

                    // Verificar si el punto de origen del vuelo coincide con el destino del vuelo actual
                    if (vuelo.getOrigen().equals(vueloActual.getDestino())) {
                        // Realiza las acciones que necesitas si el origen del vuelo coincide con el destino del vuelo actual
                    }
                }
            }

            return;
        }
    }
}


    
//    public void guardarVuelo(Aerolinea aerolinea, Avion avion, Vuelo vuelo) {
//        
//        Vuelo vueloBuscado = vueloBuscado(vuelo.getNumVuelo());
//
//        if (vueloBuscado != null) {
//            throw new YaExisteNumeroVueloException();
//        }
//
//        Avion avionBuscado = buscarNumeroAvion(avion.getNumero());
//        Aerolinea aerolineaBuscada = buscarAerolineaCodigo(aerolinea.getCodigoAerolinea());
//        
//        LocalDate fechaVuelo = vuelo.getFechaVuelo();
//        LocalTime horaInicio = vuelo.getHoraVuelo();
//        LocalTime horaFin = vuelo.getTiempoFin();
//
//        if (avion.estaOcupado(fechaVuelo, horaInicio, horaFin)) {
//            throw new AvionNoDisponibleException();
//        }
//
//        if (aerolinea.estaCapitanDisponible(vuelo.getCapitan(), fechaVuelo, horaInicio, horaFin)) {
//            throw new CapitanNoDisponibleException();
//        }
//        
//        for (int i = 0; i < aerolineaBuscada.getListaAviones().size(); i++) {
//            Avion avionRecorrido = aerolineaBuscada.getListaAviones().get(i);
//            if (avionRecorrido.getNumero() == avionBuscado.getNumero()) {
//                avionRecorrido.getCronograma().add(vuelo);
//                Singleton.getInstancia().escribirAerolineas();
//                Vuelo vueloMasAntiguo = null;
//
//                for (int j = 0; j < avionRecorrido.getCronograma().size(); j++) {
//                    Vuelo vueloActual = avionRecorrido.getCronograma().get(j);
//
//                    if (vueloActual.getEstado().equals("Espera")) {
//                        LocalDate fechaActual = vueloActual.getFechaVuelo();
//                        LocalTime horaActual = vueloActual.getHoraVuelo();
//
//                        if (vueloMasAntiguo == null || fechaActual.isBefore(vueloMasAntiguo.getFechaVuelo()) || 
//                            (fechaActual.isEqual(vueloMasAntiguo.getFechaVuelo()) && horaActual.isBefore(vueloMasAntiguo.getHoraVuelo()))) {
//                            vueloMasAntiguo = vueloActual;
//                        }
//                    }
//                }
//
//                // Ahora tienes el vuelo más antiguo en la variable vueloMasAntiguo
//                if (vueloMasAntiguo != null) {
//                    avion.setUbicacion(vueloMasAntiguo.getOrigen());
//                    System.out.println(avion.getUbicacion());
//                    Singleton.getInstancia().escribirAerolineas();
//                } else {
//                    // No se encontraron vuelos en espera en el cronograma
//                }
//
//                return;
//            }
//            
//        }
//    }
    
    public void editarVuelo(Aerolinea aerolinea, Avion avion, Vuelo vueloNuevo) {
        Vuelo vueloAntiguo = vueloBuscado(vueloNuevo.getNumVuelo());
        if (aerolinea != null && avion != null) {
            LocalDate fechaVueloNuevo = vueloNuevo.getFechaVuelo();
            LocalTime horaInicioNuevo = vueloNuevo.getHoraVuelo();
            LocalTime horaFinNuevo = vueloNuevo.getTiempoFin();

            if (avion.estaOcupado(fechaVueloNuevo, horaInicioNuevo, horaFinNuevo)) {
                throw new AvionNoDisponibleException();
            }

            if (aerolinea.estaCapitanDisponible(vueloNuevo.getCapitan(), fechaVueloNuevo, horaInicioNuevo, horaFinNuevo)) {
                throw new CapitanNoDisponibleException();
            }

            if (!vueloAntiguo.getListaViajeros().isEmpty()) {
                throw new ExistenViajerosEnListaException();
            }

            avion.getCronograma().remove(vueloAntiguo);
            avion.getCronograma().add(vueloNuevo);
            Singleton.getInstancia().escribirAerolineas();
        } else {
            throw new AvionNoDisponibleException();
        }
    }

//    public void editarVuelo(Aerolinea aerolinea, Avion avion, Vuelo vuelo) {
//        
//        Vuelo vueloBuscado = vueloBuscado(vuelo.getNumVuelo());
// 
//        LocalDate fechaVuelo = vuelo.getFechaVuelo();
//        LocalTime horaInicio = vuelo.getHoraVuelo();
//        LocalTime horaFin = vuelo.getTiempoFin();
//        
//        if (avion.estaOcupado(fechaVuelo, horaInicio, horaFin)) {
//            throw new AvionNoDisponibleException();
//        }
//
//        if (aerolinea.estaCapitanDisponible(vuelo.getCapitan(), fechaVuelo, horaInicio, horaFin)) {
//            throw new CapitanNoDisponibleException();
//        }
//        
//        if (!vuelo.getListaViajeros().isEmpty()) {
//            throw new ExistenViajerosEnListaException();
//        }
//
//        Avion avionBuscado = buscarNumeroAvion(vuelo.getAvion().getNumero());
//        if (avionBuscado != null) {
//            avionBuscado.getCronograma().remove(vueloBuscado);
//        } else {
//            throw new IdentificacionNoExisteException();
//        }
//        avionBuscado.getCronograma().add(vueloNuevo);
//        Singleton.getInstancia().escribirAerolineas();
//    }

//    
//    public void editarVuelo(int numeroVueloAntiguo, Vuelo vueloNuevo, Aerolinea aerolinea, Avion avion) {
//        if (aerolinea != null && avion != null) {
//            Vuelo vueloAntiguo = vueloBuscado(numeroVueloAntiguo);
//
//            if (vueloAntiguo == null) {
//            }
//
//            LocalDate fechaVueloAntiguo = vueloAntiguo.getFechaVuelo();
//
//            Vuelo vueloExistente = buscarVueloPorNumeroYFecha(vueloNuevo.getNumVuelo(), fechaVueloAntiguo);
//            if (vueloExistente != null && !vueloExistente.equals(vueloAntiguo)) {
//            }
//
//            LSE<Vuelo> cronogramaAvion = avion.getCronograma();
//            Nodo<Vuelo> nodoActual = cronogramaAvion.getPrimero();
//            Nodo<Vuelo> nodoAnterior = null;
//
//            while (nodoActual != null) {
//                Vuelo vuelo = nodoActual.getDato();
//
//                if (vuelo.equals(vueloAntiguo)) {
//                    if (!vuelo.getListaViajeros().isEmpty()) {
//                        throw new ExistenViajerosEnListaException();
//                    }
//
//                    if (nodoAnterior == null) {
//                        cronogramaAvion.setPrimero(nodoActual.getNodoSiguiente());
//                    } else {
//                        nodoAnterior.setNodoSiguiente(nodoActual.getNodoSiguiente());
//                    }
//
//                    LocalDate fechaVueloNuevo = vueloNuevo.getFechaVuelo();
//                    LocalTime horaInicioNuevo = vueloNuevo.getHoraVuelo();
//                    LocalTime horaFinNuevo = vueloNuevo.getTiempoFin();
//
//                    if (avion.estaOcupado(fechaVueloNuevo, horaInicioNuevo, horaFinNuevo)) {
//                        throw new AvionNoDisponibleException();
//                    }
//
//                    if (aerolinea.estaCapitanDisponible(vueloNuevo.getCapitan(), fechaVueloNuevo, horaInicioNuevo, horaFinNuevo)) {
//                        throw new CapitanNoDisponibleException();
//                    }
//
//                    cronogramaAvion.add(vueloNuevo);
//                    Singleton.getInstancia().escribirAerolineas();
//                    return;
//                }
//                nodoAnterior = nodoActual;
//                nodoActual = nodoActual.getNodoSiguiente();
//            }
//        }
//        throw new AvionNoDisponibleException();
//    }

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
                        if (vuelo.getListaViajeros().isEmpty()) {
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
