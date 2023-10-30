
package Controladores;

import Excepciones.*;
import Modelos.*;
import Singleton.Singleton;
import Util.LSE;

/**
 *
 * @author diaza
 */
public class ControladorVentanaGestionGestorMantenimiento {
    
    private LSE<Persona> listaPersonas;
    
    public ControladorVentanaGestionGestorMantenimiento(){
        this.listaPersonas = Singleton.getInstancia().getPersonas();
    }
    
    public LSE<GestorMantenimiento> obtenerGestores(){
        LSE<GestorMantenimiento> listaGestores = new LSE<>();
        listaPersonas = Singleton.getInstancia().getPersonas();
        if(listaPersonas != null){         
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getRol().equals("Gestor Mantenimiento")){
                    GestorMantenimiento gestorMantenimiento =  (GestorMantenimiento) listaPersonas.get(i);
                    listaGestores.add(gestorMantenimiento);
                }
            }
            return listaGestores;  
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
    
    public Persona buscarCapitanVuelo(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getRol().equals("Capitan Vuelo") ){
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return (CapitanVuelo)listaPersonas.get(i);
                }
            }
        }
        return null;    
    }
    
    public Persona buscarEmpleadoLogistica(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getRol().equals("Empleado Logistica") ){
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return (EmpleadoLogistica)listaPersonas.get(i);
                }
            }
        }
        return null;    
    }
    
    public Persona buscarAdministradoAerolinea(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getRol().equals("Administrador Aerolinea") ){
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return (EmpleadoLogistica)listaPersonas.get(i);
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
    
    public boolean validarMismaInfoGestor(GestorMantenimiento persona) {
        
        Persona buscarInformacion = buscarInfo(persona.getIdentificacion());
        
        if(persona.getNombres().equals(buscarInformacion.getNombres()) && persona.getApellidos().equals(buscarInformacion.getApellidos())
            && persona.getEdad() == buscarInformacion.getEdad() && persona.getGenero().equals(buscarInformacion.getGenero()) 
            && persona.getNumTelefono().equals(buscarInformacion.getNumTelefono()) ) {
            return true;
        }
        return false;
    }
    
    public void guardarGestorMantenimiento(GestorMantenimiento persona) {
        
        GestorMantenimiento gestorBuscado = (GestorMantenimiento) buscarGestorMantenimientoId(persona.getIdentificacion());
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(persona.getIdentificacion());
        Persona correoBuscado = validarCorreo(persona.getCorreo());
        CapitanVuelo capitanBuscado = (CapitanVuelo) buscarCapitanVuelo(persona.getIdentificacion());
        AdministradorAerolinea adAeroBuscado = (AdministradorAerolinea) buscarAdministradoAerolinea(persona.getIdentificacion());
        EmpleadoLogistica empleadoBuscado = (EmpleadoLogistica) buscarEmpleadoLogistica(persona.getIdentificacion());
            
        boolean personaYaExiste = viajeroBuscado != null || correoBuscado != null || gestorBuscado != null || capitanBuscado != null || adAeroBuscado != null || empleadoBuscado != null;
 
        if (personaYaExiste) {
            if (gestorBuscado != null) {
                throw new GestorRegistradoException();
            }else if (correoBuscado != null) {
                throw new CorreoRegistradoException();
            }else if(capitanBuscado != null) {
                throw new CapitanVueloRegistradoException();
            }else if(adAeroBuscado != null){
                throw new AdminAeroRegistradoException();
            }else if(empleadoBuscado != null){
                throw new EmpleadoLogisticaRegistradoException();
            }else if (viajeroBuscado != null) {
                if (validarMismaInfoGestor(persona)) {
                    listaPersonas.add(persona);
                    Singleton.getInstancia().escribirPersonas();
                }else {
                    throw new InformacionViajeroException();   
                }
            }
        }else {
            listaPersonas.add(persona);
            Singleton.getInstancia().escribirPersonas();
        }
    }
    
    public void editarGestor(GestorMantenimiento gestorMant) {
        
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(gestorMant.getIdentificacion());
        GestorMantenimiento gestorBuscado = (GestorMantenimiento) buscarGestorMantenimientoId(gestorMant.getIdentificacion());
        Persona correoBuscado = validarCorreo(gestorMant.getCorreo());
             
        if(gestorBuscado != null) {
            if (!gestorMant.getIdentificacion().equals(gestorBuscado.getIdentificacion())
                    || !gestorMant.getCorreo().equals(gestorBuscado.getCorreo())) {
                throw new CambioCorreoIdentificacionException();
            }
      
            gestorBuscado.setNombres(gestorMant.getNombres());
            gestorBuscado.setApellidos(gestorMant.getApellidos());
            gestorBuscado.setEdad(gestorMant.getEdad());
            gestorBuscado.setNumTelefono(gestorMant.getNumTelefono());
            gestorBuscado.setGenero(gestorMant.getGenero());
            gestorBuscado.setContrasenia(gestorMant.getContrasenia());
            gestorBuscado.setCertificaciones(gestorMant.getCertificaciones());
            gestorBuscado.setCiudadResidencia(gestorMant.getCiudadResidencia());
            gestorBuscado.setEspecialidad(gestorMant.getEspecialidad());
            Singleton.getInstancia().escribirPersonas();

            if(viajeroBuscado != null) {
                viajeroBuscado.setNombres(gestorMant.getNombres());
                viajeroBuscado.setApellidos(gestorMant.getApellidos());
                viajeroBuscado.setEdad(gestorMant.getEdad());
                viajeroBuscado.setNumTelefono(gestorMant.getNumTelefono());
                viajeroBuscado.setGenero(gestorMant.getGenero());
                Singleton.getInstancia().escribirPersonas();
            }
        }else {
            throw new IdentificacionNoExisteException();
        }
    }

    public void eliminarGestor(String identificacion){
        
        Persona aux = buscarGestorMantenimientoId(identificacion);
    	
        if (aux != null) {
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getIdentificacion().equals(aux.getIdentificacion()) && listaPersonas.get(i).getRol().equals("Gestor Mantenimiento")){
                    listaPersonas.remove(i);
                    Singleton.getInstancia().escribirPersonas();                   
                } 
            }
        }else {
            throw new IdentificacionNoExisteException();
        }      
    }
}
