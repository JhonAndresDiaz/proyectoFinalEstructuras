package Controladores;

import Excepciones.*;
import Modelos.*;
import Singleton.Singleton;
import Util.LSE;

/**
 *
 * @author diaza
 */
public class ControladorVentanaGestionAerolinea {
    
    private LSE<Aerolinea> listaAerolineas;
    private LSE<Usuario> listaUsuarios;
    
    public ControladorVentanaGestionAerolinea(){
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
        this.listaUsuarios = Singleton.getInstancia().getUsuarios();
    }
    
    public LSE<Aerolinea> obtenerAerolineas(){
        LSE<Aerolinea> listaAero = new LSE<>();
        listaAerolineas = Singleton.getInstancia().getAerolineas();
        if(listaAerolineas != null){         
            for (int i = 0; i < listaAerolineas.size(); i++) {
                Aerolinea aerolinea =  listaAerolineas.get(i);
                listaAero.add(aerolinea);
            }
            return listaAero;  
        }
        return new LSE<>();
    }
    
    public Aerolinea buscarAerolineaCodigo(int codigo){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if(listaAerolineas.get(i).getCodigoAerolinea() == codigo){
                return listaAerolineas.get(i);
            }  
        }
        return null;    
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
    
    public boolean validarMismaInfoAdministrador(AdministradorAerolinea persona) {
        
        Persona buscarInformacion = buscarInformacion(persona.getIdentificacion());
        
        if(persona.getNombres().equals(buscarInformacion.getNombres()) && persona.getApellidos().equals(buscarInformacion.getApellidos())
            && persona.getEdad() == buscarInformacion.getEdad() && persona.getGenero().equals(buscarInformacion.getGenero()) 
            && persona.getNumTelefono().equals(buscarInformacion.getNumTelefono()) ) {
            return true;
        }
        return false;
    }
    
    public void guardarAerolinea(Aerolinea aerolinea, AdministradorAerolinea admin) {
        
        if(buscarAerolineaCodigo(aerolinea.getCodigoAerolinea()) != null) {
            throw new CodigoAerolineaExisteException();
        }

        if(validarCorreo(admin.getCorreo()) != null) {
            throw new CorreoRegistradoException();
        }

        AdministradorAerolinea adAeroBuscado = (AdministradorAerolinea) buscarAdminAerolineaId(admin.getIdentificacion());
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(admin.getIdentificacion());
        GestorMantenimiento gestorBuscado = (GestorMantenimiento) buscarGestorMantenimiento(admin.getIdentificacion());
        CapitanVuelo capitanBuscado = (CapitanVuelo) buscarCapitanVuelo(admin.getIdentificacion());
        EmpleadoLogistica empleadoBuscado = (EmpleadoLogistica) buscarEmpleadoLogistica(admin.getIdentificacion());
        
        if(adAeroBuscado != null || viajeroBuscado != null || gestorBuscado != null || capitanBuscado != null || empleadoBuscado != null) {
            if (adAeroBuscado != null) {
                throw new AdminAeroRegistradoException();
            }else if(gestorBuscado != null){
                throw new GestorRegistradoException();
            }else if(capitanBuscado != null){
                throw new CapitanVueloRegistradoException();
            }else if(empleadoBuscado != null){
                throw new EmpleadoLogisticaRegistradoException();
            }else if(viajeroBuscado != null) {
                if(validarMismaInfoAdministrador(admin)) {
                    aerolinea.getListaEmpleadosAerolinea().add(admin);
                    listaAerolineas.add(aerolinea);
                    Singleton.getInstancia().escribirAerolineas();
                } else {
                    throw new InformacionViajeroException();              
                }
            } 
        }else {
            aerolinea.getListaEmpleadosAerolinea().add(admin);
            listaAerolineas.add(aerolinea);
            Singleton.getInstancia().escribirAerolineas();
        }
    }
    
}
