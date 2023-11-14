package Controladores;

import Excepciones.AvionEstaEnMantenimientoException;
import Excepciones.CruzaHorariosMantenimientoException;
import Excepciones.FechaMantenimientoVueloYaRegistradoException;
import Excepciones.SolicitudYaEnviadaException;
import Excepciones.YaExisteCodigoMantenimientoException;
import Modelos.Aerolinea;
import Modelos.Avion;
import Modelos.Mantenimiento;
import Modelos.Vuelo;
import Singleton.Singleton;
import Util.LSE;
import Util.Nodo;
import java.time.LocalDate;

/**
 *
 * @author diaza
 */
public class ControladorVentanaSolicitarMantenimiento {
    
    private LSE<Aerolinea> listaAerolineas;
    private LSE<Mantenimiento> listaMantenimientos;
    
    public ControladorVentanaSolicitarMantenimiento() {
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
        this.listaMantenimientos = Singleton.getInstancia().getMantenimientos();
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
    
    public Mantenimiento mantenimientoBuscado(int numero) {
        for (int i = 0; i < listaMantenimientos.size(); i++) {
            Mantenimiento mantenimiento = listaMantenimientos.get(i);
            if(mantenimiento != null && mantenimiento.getNum() == numero){
                return mantenimiento;
            }
        }
        return null;
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
    
    public Aerolinea buscarAerolineaAvion(Mantenimiento mantenimiento){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                Avion avion = aerolinea.getListaAviones().get(j);
                if(avion.getNumero() == mantenimiento.getAvion().getNumero()){
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
    
    public LSE<Mantenimiento> obtenerTODOSMantenimientos( ) {

        LSE<Mantenimiento> listaMantenimiento = new LSE();

        for (int i = 0; i < listaMantenimientos.size(); i++) {
            Mantenimiento mantenimiento = listaMantenimientos.get(i);
            if(mantenimiento != null){
                listaMantenimiento.add(mantenimiento);
            }
        }
        return listaMantenimiento;
    }
    
    public LSE<Mantenimiento> obtenerMantenimiento(Aerolinea aerolineaRecibida) {

        LSE<Mantenimiento> listaMantenimiento = new LSE();

        for (int i = 0; i < aerolineaRecibida.getListaAviones().size(); i++) {
            Avion avion = aerolineaRecibida.getListaAviones().get(i);
            for (int j = 0; j < listaMantenimientos.size(); j++) {
                Mantenimiento mantenimiento = listaMantenimientos.get(j);
                if(mantenimiento != null && mantenimiento.getAvion().getNumero() == avion.getNumero()){
                    listaMantenimiento.add(mantenimiento);
                }
                
            }
        }
        return listaMantenimiento;
    }
    
    public void nuevaSolicitud(Aerolinea aerolineaRecibida, Mantenimiento mantenimiento, Avion avionRecibido){
          
        Mantenimiento aux = mantenimientoBuscado(mantenimiento.getNum());
        if(aux != null){
            throw new YaExisteCodigoMantenimientoException();
        }
        
        for (int i = 0; i < avionRecibido.getCronograma().size(); i++) {
            Vuelo vuelo = avionRecibido.getCronograma().get(i);
            if(vuelo != null){
                if(vuelo.getFechaVuelo().equals(mantenimiento.getFechaInicio()) || vuelo.getDiaFinVuelo().equals(mantenimiento.getFechaInicio()) ){
                    throw new FechaMantenimientoVueloYaRegistradoException();
                }
            }
        }
        
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            if (aerolinea.getCodigoAerolinea() == aerolineaRecibida.getCodigoAerolinea()) {
                for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                    Avion avion = aerolinea.getListaAviones().get(j);
                    for (int k = 0; k < listaMantenimientos.size(); k++) {
                        Mantenimiento mantenimientoRecorrido = listaMantenimientos.get(k);
                        if(mantenimientoRecorrido.getAvion().getNumero() == avion.getNumero()){
                            if(mantenimientoRecorrido != null){
                                if(mantenimientoRecorrido.getEstado().equals("Pendiente") || mantenimientoRecorrido.getEstado().equals("En progreso")){
                                    throw new SolicitudYaEnviadaException();
                                }
                            }  
                        }                            
                    }
                }
            }
        }
        
        for (int i = 0; i < listaMantenimientos.size(); i++) {
            Mantenimiento mantRecorrido = listaMantenimientos.get(i);
            if(mantRecorrido != null && mantRecorrido.getEstado().equals("En progreso")){
                LocalDate fechaInicioMantenimiento = mantRecorrido.getFechaInicio();
                LocalDate fechaFinMantenimiento = mantRecorrido.getFechaFin();
                    if(mantenimiento.getFechaInicio().isAfter(fechaInicioMantenimiento) && mantenimiento.getFechaInicio().isBefore(fechaFinMantenimiento)
                    || mantenimiento.getFechaInicio().isEqual(fechaInicioMantenimiento) || mantenimiento.getFechaInicio().isEqual(fechaFinMantenimiento)) {
                        throw new CruzaHorariosMantenimientoException();
                } 
            }
        }
            listaMantenimientos.add(mantenimiento);
            Singleton.getInstancia().escribirAerolineas();
            Singleton.getInstancia().escribirMantenimientos();
    }
    
    public void actulizarMantenimiento(Mantenimiento mantenimientoRecibido){
        
        for (int i = 0; i < listaMantenimientos.size(); i++) {
            Mantenimiento mantRecorrido = listaMantenimientos.get(i);
            if(mantRecorrido != null && mantRecorrido.getEstado().equals("En progreso")){
                LocalDate fechaInicioMantenimiento = mantRecorrido.getFechaInicio();
                LocalDate fechaFinMantenimiento = mantRecorrido.getFechaFin();
                    if(mantenimientoRecibido.getFechaInicio().isAfter(fechaInicioMantenimiento) && mantenimientoRecibido.getFechaInicio().isBefore(fechaFinMantenimiento)
                    || mantenimientoRecibido.getFechaInicio().isEqual(fechaInicioMantenimiento) || mantenimientoRecibido.getFechaInicio().isEqual(fechaFinMantenimiento)) {
                        throw new CruzaHorariosMantenimientoException();
                } 
            }
        }
        
        Mantenimiento aux = mantenimientoBuscado(mantenimientoRecibido.getNum());
        
        if(aux != null){
            aux.setFechaFin(mantenimientoRecibido.getFechaFin());
            aux.setEstado(mantenimientoRecibido.getEstado());
            Singleton.getInstancia().escribirAerolineas();
            Singleton.getInstancia().escribirMantenimientos();
        }
    }
    
    public void aniadirMensaje(Mantenimiento mantenimientoEnviado, String mensaje){
        
        Mantenimiento mantenimiento = mantenimientoBuscado(mantenimientoEnviado.getNum());
        
        if(mantenimiento != null){
            mantenimiento.enviarMensajeAlChat("Administrador: " + mensaje);
            Singleton.getInstancia().escribirMantenimientos();
        }
    }
   
    public void aniadirMensajeEmpleado(Mantenimiento mantenimientoEnviado, String mensaje){
        
        Mantenimiento mantenimiento = mantenimientoBuscado(mantenimientoEnviado.getNum());
        
        if(mantenimiento != null){
            mantenimiento.enviarMensajeAlChat("Empleado logistica: " + mensaje);
            Singleton.getInstancia().escribirMantenimientos();
        }
    }
    
}
