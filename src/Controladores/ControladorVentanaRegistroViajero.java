package Controladores;

import Excepciones.*;
import Modelos.AdministradorAerolinea;
import Modelos.*;
import Singleton.Singleton;
import Util.LSE;

/**
 *
 * @author diazje
 */
public class ControladorVentanaRegistroViajero {
    
    private LSE<Persona> listaPersonas;
    
    public ControladorVentanaRegistroViajero(){
        this.listaPersonas = Singleton.getInstancia().getPersonas();
    }
    
    public LSE<Persona> obtenerViajeros(){
        return Singleton.getInstancia().leerPersonas();
    }
    
    public LSE<Viajero> obtenerViajerosTabla(){
        LSE<Viajero> listaViajero = new LSE<>();
        listaPersonas = Singleton.getInstancia().getPersonas();
        if(listaPersonas != null){         
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getRol().equals("Viajero")){
                   Viajero viajero =  (Viajero) listaPersonas.get(i);
                    listaViajero.add(viajero); 
                }
            }
            return listaViajero;  
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
    
    public Persona buscarInfo(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return listaPersonas.get(i);
                }
            }
        return null;    
    }
       
    public Persona validarCorreo(String correo) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getCorreo().equals(correo)) {
                return listaPersonas.get(i);
            }
        }
        return null;
    }
    
    public boolean validarMismaInfoViajero(Viajero persona) {
        
        Persona buscarInformacion = buscarInfo(persona.getIdentificacion());
        
        if(persona.getNombres().equals(buscarInformacion.getNombres()) && persona.getApellidos().equals(buscarInformacion.getApellidos())
            && persona.getEdad() == buscarInformacion.getEdad() && persona.getGenero().equals(buscarInformacion.getGenero()) 
            && persona.getNumTelefono().equals(buscarInformacion.getNumTelefono()) ) {
            return true;
        }
        return false;
    }
    
    public void guardarViajero(Viajero persona) {
        
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(persona.getIdentificacion());
        GestorMantenimiento gestorBuscado = (GestorMantenimiento) buscarGestorMantenimientoId(persona.getIdentificacion());
        AdministradorAerolinea adAeroBuscado = (AdministradorAerolinea) buscarAdminAerolineaId(persona.getIdentificacion());
        CapitanVuelo capitanBuscado = (CapitanVuelo) buscarCapitanVueloId(persona.getIdentificacion());
        EmpleadoLogistica empleadoBuscado = (EmpleadoLogistica) buscarEmpleadoLogisticaId(persona.getIdentificacion());
        Persona correoBuscado = validarCorreo(persona.getCorreo());

        boolean personaYaExiste = viajeroBuscado != null || correoBuscado != null || gestorBuscado != null || adAeroBuscado != null || capitanBuscado != null || empleadoBuscado != null;

        if(personaYaExiste) {
            if(viajeroBuscado != null) {
                throw new ViajeroRegistradoException();
            }else if (correoBuscado != null) {
                throw new CorreoRegistradoException();
            }else if (gestorBuscado != null || adAeroBuscado != null || capitanBuscado != null || empleadoBuscado != null) {
                if(validarMismaInfoViajero(persona)) {
                    listaPersonas.add(persona);
                    Singleton.getInstancia().escribirPersonas();
                }else {
                    if (gestorBuscado != null) {
                        throw new InformacionGestorException();
                    }else if (adAeroBuscado != null) {
                        throw new InformacionAdministradorAeroException();
                    }else if (capitanBuscado != null) {
                        throw new InformacionCapitanException();
                    }else if (empleadoBuscado != null) {
                        throw new InformacionEmpleadoException();
                    }
                }
            }
        }else {
            listaPersonas.add(persona);
            Singleton.getInstancia().escribirPersonas();
        }
    }  
}
