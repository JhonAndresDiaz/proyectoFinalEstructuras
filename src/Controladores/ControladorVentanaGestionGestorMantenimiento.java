
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
    
    private LSE<Usuario> listaUsuarios;
    private LSE<Aerolinea> listaAerolineas;
    
    public ControladorVentanaGestionGestorMantenimiento(){
        this.listaUsuarios = Singleton.getInstancia().getUsuarios();
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
    }
    
    public LSE<GestorMantenimiento> obtenerGestores(){
        LSE<GestorMantenimiento> listaGestores = new LSE<>();
        listaUsuarios = Singleton.getInstancia().getUsuarios();
        if(listaUsuarios != null){         
            for (int i = 0; i < listaUsuarios.size(); i++) {
                if(listaUsuarios.get(i).getRol().equals("Gestor Mantenimiento")){
                    GestorMantenimiento gestorMantenimiento =  (GestorMantenimiento) listaUsuarios.get(i);
                    listaGestores.add(gestorMantenimiento);
                }
            }
            return listaGestores;  
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
    
    public Persona buscarGestorMantenimiento(String identificacion){
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
            
    public Persona buscarInformacion(String identificacion){
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getRol().equals("Viajero")){
                Viajero viajero = (Viajero) listaUsuarios.get(i);
                if(viajero.getIdentificacion().equals(identificacion)){
                    return viajero;
                }
            }
        }
        return null;
    }
 
    public Persona validarCorreo(String correo){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                if(aerolinea.getListaEmpleadosAerolinea().get(j).getCorreo().equals(correo)){
                    return aerolinea.getListaEmpleadosAerolinea().get(j);
                }
            }
        }
        return null;
    }
    
    public Persona validarCorreo2(String correo){
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuario = listaUsuarios.get(i);
            if(usuario.getCorreo().equals(correo)){
                return (Persona) usuario;
            }
        }
        return null;
    }
    
    public boolean validarMismaInfoGestor(GestorMantenimiento persona) {
        
        Persona buscarInformacion = buscarInformacion(persona.getIdentificacion());
        
        if(persona.getNombres().equals(buscarInformacion.getNombres()) && persona.getApellidos().equals(buscarInformacion.getApellidos())
            && persona.getEdad() == buscarInformacion.getEdad() && persona.getGenero().equals(buscarInformacion.getGenero()) 
            && persona.getNumTelefono().equals(buscarInformacion.getNumTelefono()) ) {
            return true;
        }
        return false;
    }
    
    public void guardarGestorMantenimiento(GestorMantenimiento persona) {
        
        GestorMantenimiento gestorBuscado = (GestorMantenimiento) buscarGestorMantenimiento(persona.getIdentificacion());
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(persona.getIdentificacion());
        Persona correoBuscado = validarCorreo(persona.getCorreo());
        Persona correoBuscado2 = validarCorreo2(persona.getCorreo());
        CapitanVuelo capitanBuscado = (CapitanVuelo) buscarCapitanVuelo(persona.getIdentificacion());
        AdministradorAerolinea adAeroBuscado = (AdministradorAerolinea) buscarAdminAerolineaId(persona.getIdentificacion());
        EmpleadoLogistica empleadoBuscado = (EmpleadoLogistica) buscarEmpleadoLogistica(persona.getIdentificacion());
            
        boolean personaYaExiste = viajeroBuscado != null || correoBuscado != null || correoBuscado2 != null || gestorBuscado != null || capitanBuscado != null || adAeroBuscado != null || empleadoBuscado != null;
 
        if (personaYaExiste) {
            if (gestorBuscado != null) {
                throw new GestorRegistradoException();
            }else if (correoBuscado != null || correoBuscado2 != null) {
                throw new CorreoRegistradoException();
            }else if(capitanBuscado != null) {
                throw new CapitanVueloRegistradoException();
            }else if(adAeroBuscado != null){
                throw new AdminAeroRegistradoException();
            }else if(empleadoBuscado != null){
                throw new EmpleadoLogisticaRegistradoException();
            }else if (viajeroBuscado != null) {
                if (validarMismaInfoGestor(persona)) {
                    listaUsuarios.add(persona);
                    Singleton.getInstancia().escribirUsuarios();
                }else {
                    throw new InformacionViajeroException();   
                }
            }
        }else {
            listaUsuarios.add(persona);
            Singleton.getInstancia().escribirUsuarios();
        }
    }
    
    public void editarGestor(GestorMantenimiento gestorMant) {
        
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(gestorMant.getIdentificacion());
        GestorMantenimiento gestorBuscado = (GestorMantenimiento) buscarGestorMantenimiento(gestorMant.getIdentificacion());
        Persona correoBuscado = validarCorreo2(gestorMant.getCorreo());
             
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
            Singleton.getInstancia().escribirUsuarios();

            if(viajeroBuscado != null) {
                viajeroBuscado.setNombres(gestorMant.getNombres());
                viajeroBuscado.setApellidos(gestorMant.getApellidos());
                viajeroBuscado.setEdad(gestorMant.getEdad());
                viajeroBuscado.setNumTelefono(gestorMant.getNumTelefono());
                viajeroBuscado.setGenero(gestorMant.getGenero());
                Singleton.getInstancia().escribirUsuarios();
            }
        }else {
            throw new IdentificacionNoExisteException();
        }
    }

    public void eliminarGestor(String identificacion){
        
        Persona aux = buscarGestorMantenimiento(identificacion);
    	
        if (aux != null) {
            for (int i = 0; i < listaUsuarios.size(); i++) {
                if(listaUsuarios.get(i).getRol().equals("Gestor Mantenimiento")){
                    GestorMantenimiento gestorMantenimiento = (GestorMantenimiento) listaUsuarios.get(i);
                    if(gestorMantenimiento.getIdentificacion().equals(aux.getIdentificacion())){
                        listaUsuarios.remove(i);
                        Singleton.getInstancia().escribirUsuarios();
                    }
                }               
            }
        }else {
            throw new IdentificacionNoExisteException();
        }      
    }
    
}
