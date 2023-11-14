package Controladores;

import Excepciones.IdentificacionNoExisteException;
import Modelos.*;
import Singleton.Singleton;
import Util.LSE;

/**
 *
 * @author diaza
 */
public class ControladorVentanaMenuPrincipalViajero {
    
    private LSE<Usuario> listaUsuarios;
    private LSE<Aerolinea> listaAerolineas;
    
    public ControladorVentanaMenuPrincipalViajero(){
        this.listaUsuarios = Singleton.getInstancia().getUsuarios();
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
    }
    
    public LSE<Vuelo> obtenerVuelos(String identificacion) {
        Viajero aux = (Viajero) buscarViajeroId(identificacion);
        if( aux != null){
            if(aux.getHistorialVuelos() != null){
                return aux.getHistorialVuelos();
            }   
        }
        return new LSE<>();
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
    
    public LSE<Reserva> obtenerReservas(String identificacion) {
        Viajero aux = (Viajero) buscarViajeroId(identificacion);
        if( aux != null){
            if(aux.getHistorialReservas() != null){
                return aux.getHistorialReservas();
            }   
        }
        return new LSE<>();
    }
     
    public Persona buscarViajeroId(String identificacion){
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getRol().equals("Viajero")){
                Viajero viajero = (Viajero) listaUsuarios.get(i);
                if(viajero.getIdentificacion().equals(identificacion)){
                    return (Persona) listaUsuarios.get(i);
                }
            }
        }
        return null;    
    }
    
    public Persona buscarCapitanVuelo(String identificacion){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                if(aerolinea.getListaEmpleadosAerolinea().get(j).getRol().equals("Capitan Vuelo")){
                    if(aerolinea.getListaEmpleadosAerolinea().get(j).getIdentificacion().equals(identificacion)){
                        return aerolinea.getListaEmpleadosAerolinea().get(j);
                    }
                }
            }
        }
        return null;    
    }
    
    public Persona buscarAdminAerolineaId(String identificacion){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                if(aerolinea.getListaEmpleadosAerolinea().get(j).getRol().equals("Administrador Aerolinea")){
                    if(aerolinea.getListaEmpleadosAerolinea().get(j).getIdentificacion().equals(identificacion)){
                        return aerolinea.getListaEmpleadosAerolinea().get(j);
                    }
                }
            }
        }
        return null;    
    }
    
    public Persona buscarGestorMantenimientoId(String identificacion){
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getRol().equals("Gestor Mantenimiento")){
                GestorMantenimiento gestorMantenimiento = (GestorMantenimiento) listaUsuarios.get(i);
                if(gestorMantenimiento.getIdentificacion().equals(identificacion)){
                    return (Persona) listaUsuarios.get(i);
                }
            }
        }
        return null;    
    }
    
    public Persona buscarEmpleadoLogistica(String identificacion){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                if(aerolinea.getListaEmpleadosAerolinea().get(j).getRol().equals("Empleado Logistica")){
                    if(aerolinea.getListaEmpleadosAerolinea().get(j).getIdentificacion().equals(identificacion)){
                        return aerolinea.getListaEmpleadosAerolinea().get(j);
                    }
                }
            }
        }
        return null;    
    }
 
    public void editarViajero(Viajero viajero) {
        
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(viajero.getIdentificacion());
        GestorMantenimiento gestorBuscado = (GestorMantenimiento) buscarGestorMantenimientoId(viajero.getIdentificacion());
        AdministradorAerolinea adAeroBuscado = (AdministradorAerolinea) buscarAdminAerolineaId(viajero.getIdentificacion());
        CapitanVuelo capitanBuscado = (CapitanVuelo) buscarCapitanVuelo(viajero.getIdentificacion());
        EmpleadoLogistica empleadoBuscado = (EmpleadoLogistica) buscarEmpleadoLogistica(viajero.getIdentificacion());
        
        if(viajeroBuscado != null) {
            viajeroBuscado.setNombres(viajero.getNombres());
            viajeroBuscado.setApellidos(viajero.getApellidos());
            viajeroBuscado.setEdad(viajero.getEdad());
            viajeroBuscado.setNumTelefono(viajero.getNumTelefono());
            viajeroBuscado.setGenero(viajero.getGenero());
            viajeroBuscado.setContrasenia(viajero.getContrasenia());
            viajeroBuscado.setPaisNacimiento(viajero.getPaisNacimiento());
            Singleton.getInstancia().escribirUsuarios();

            if(gestorBuscado != null) {
                gestorBuscado.setNombres(viajero.getNombres());
                gestorBuscado.setApellidos(viajero.getApellidos());
                gestorBuscado.setEdad(viajero.getEdad());
                gestorBuscado.setNumTelefono(viajero.getNumTelefono());
                gestorBuscado.setGenero(viajero.getGenero());
                Singleton.getInstancia().escribirUsuarios();
            }
            if(adAeroBuscado != null){
                adAeroBuscado.setNombres(viajero.getNombres());
                adAeroBuscado.setApellidos(viajero.getApellidos());
                adAeroBuscado.setEdad(viajero.getEdad());
                adAeroBuscado.setNumTelefono(viajero.getNumTelefono());
                adAeroBuscado.setGenero(viajero.getGenero());
                Singleton.getInstancia().escribirAerolineas();
            }
            if(capitanBuscado != null){
                capitanBuscado.setNombres(viajero.getNombres());
                capitanBuscado.setApellidos(viajero.getApellidos());
                capitanBuscado.setEdad(viajero.getEdad());
                capitanBuscado.setNumTelefono(viajero.getNumTelefono());
                capitanBuscado.setGenero(viajero.getGenero());
                Singleton.getInstancia().escribirAerolineas();
            }
            if(empleadoBuscado != null){
                empleadoBuscado.setNombres(viajero.getNombres());
                empleadoBuscado.setApellidos(viajero.getApellidos());
                empleadoBuscado.setEdad(viajero.getEdad());
                empleadoBuscado.setNumTelefono(viajero.getNumTelefono());
                empleadoBuscado.setGenero(viajero.getGenero());
                Singleton.getInstancia().escribirAerolineas();
            }
        }else {
            throw new IdentificacionNoExisteException();
        }
    }
    
}
