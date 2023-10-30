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
    
    private LSE<Persona> listaPersonas;
    
    public ControladorVentanaMenuPrincipalViajero(){
        this.listaPersonas = Singleton.getInstancia().getPersonas();
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
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getRol().equals("Viajero") ){
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return (Viajero)listaPersonas.get(i);
                }
            }
        }
        return null;    
    }
    
    public Persona buscarAdminAerolineaId(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getRol().equals("Administrador Aerolinea") ){
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return (AdministradorAerolinea)listaPersonas.get(i);
                }
            }
        }
        return null;    
    }

    public Persona buscarCapitanVueloId(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getRol().equals("Capitan Vuelo") ){
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return (CapitanVuelo)listaPersonas.get(i);
                }
            }
        }
        return null;    
    }
    
    public Persona buscarEmpleadoLogisticaId(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getRol().equals("Empleado Logistica") ){
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return (EmpleadoLogistica)listaPersonas.get(i);
                }
            }
        }
        return null;    
    }
    
    public Persona buscarGestorMantenimientoId(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getRol().equals("Gestor Mantenimiento") ){
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return (GestorMantenimiento)listaPersonas.get(i);
                }
            }
        }
        return null;    
    }
 
    public void editarViajero(Viajero viajero) {
        
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(viajero.getIdentificacion());
        GestorMantenimiento gestorBuscado = (GestorMantenimiento) buscarGestorMantenimientoId(viajero.getIdentificacion());
        AdministradorAerolinea adAeroBuscado = (AdministradorAerolinea) buscarAdminAerolineaId(viajero.getIdentificacion());
        CapitanVuelo capitanBuscado = (CapitanVuelo) buscarCapitanVueloId(viajero.getIdentificacion());
        EmpleadoLogistica empleadoBuscado = (EmpleadoLogistica) buscarEmpleadoLogisticaId(viajero.getIdentificacion());
        
        if(viajeroBuscado != null) {
            viajeroBuscado.setNombres(viajero.getNombres());
            viajeroBuscado.setApellidos(viajero.getApellidos());
            viajeroBuscado.setEdad(viajero.getEdad());
            viajeroBuscado.setNumTelefono(viajero.getNumTelefono());
            viajeroBuscado.setGenero(viajero.getGenero());
            viajeroBuscado.setContrasenia(viajero.getContrasenia());
            viajeroBuscado.setPaisNacimiento(viajero.getPaisNacimiento());
            Singleton.getInstancia().escribirPersonas();

            if(gestorBuscado != null) {
                gestorBuscado.setNombres(viajero.getNombres());
                gestorBuscado.setApellidos(viajero.getApellidos());
                gestorBuscado.setEdad(viajero.getEdad());
                gestorBuscado.setNumTelefono(viajero.getNumTelefono());
                gestorBuscado.setGenero(viajero.getGenero());
                Singleton.getInstancia().escribirPersonas();
            }
            if(adAeroBuscado != null){
                adAeroBuscado.setNombres(viajero.getNombres());
                adAeroBuscado.setApellidos(viajero.getApellidos());
                adAeroBuscado.setEdad(viajero.getEdad());
                adAeroBuscado.setNumTelefono(viajero.getNumTelefono());
                adAeroBuscado.setGenero(viajero.getGenero());
                Singleton.getInstancia().escribirPersonas();
            }
            if(capitanBuscado != null){
                capitanBuscado.setNombres(viajero.getNombres());
                capitanBuscado.setApellidos(viajero.getApellidos());
                capitanBuscado.setEdad(viajero.getEdad());
                capitanBuscado.setNumTelefono(viajero.getNumTelefono());
                capitanBuscado.setGenero(viajero.getGenero());
                Singleton.getInstancia().escribirPersonas();
            }
            if(empleadoBuscado != null){
                empleadoBuscado.setNombres(viajero.getNombres());
                empleadoBuscado.setApellidos(viajero.getApellidos());
                empleadoBuscado.setEdad(viajero.getEdad());
                empleadoBuscado.setNumTelefono(viajero.getNumTelefono());
                empleadoBuscado.setGenero(viajero.getGenero());
                Singleton.getInstancia().escribirPersonas();
            }
        }else {
            throw new IdentificacionNoExisteException();
        }
    }
}
