package Controladores;

import Excepciones.*;
import Modelos.*;
import Singleton.Singleton;
import Util.LSE;

/**
 *
 * @author diaza
 */
public class GestAdminAerolinea {
    
    private LSE<Aerolinea> listaAerolineas;
    
    public GestAdminAerolinea(){
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
    }
    
    public LSE<AdministradorAerolinea> obtenerAdministradores(){
        LSE<AdministradorAerolinea> listaAdministradores = new LSE<>();
        listaAerolineas = Singleton.getInstancia().getAerolineas();
        if(listaAerolineas != null){         
            for (int i = 0; i < listaAerolineas.size(); i++) {
                Aerolinea aerolinea = listaAerolineas.get(i);
                for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                    if(aerolinea.getListaEmpleadosAerolinea().get(j).getRol().equals("Administrador Aerolinea")){
                        AdministradorAerolinea adminAero = (AdministradorAerolinea) aerolinea.getListaEmpleadosAerolinea().get(j);
                        listaAdministradores.add(adminAero);
                    }
                }
            }
            return listaAdministradores;  
        }
        return new LSE<>();
    }
    
    public Persona buscarViajeroId(String identificacion){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                if(aerolinea.getListaEmpleadosAerolinea().get(j).getRol().equals("Viajero")){
                    if(aerolinea.getListaEmpleadosAerolinea().get(j).getIdentificacion().equals(identificacion)){
                        return aerolinea.getListaEmpleadosAerolinea().get(j);
                    }
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
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                if(aerolinea.getListaEmpleadosAerolinea().get(j).getRol().equals("Gestor Mantenimiento")){
                    if(aerolinea.getListaEmpleadosAerolinea().get(j).getIdentificacion().equals(identificacion)){
                        return aerolinea.getListaEmpleadosAerolinea().get(j);
                    }
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
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                if(aerolinea.getListaEmpleadosAerolinea().get(j).getIdentificacion().equals(identificacion)){
                    return aerolinea.getListaEmpleadosAerolinea().get(j);
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
    
    
    public Aerolinea buscarAerolineaCodigo(int codigo){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if(listaAerolineas.get(i).getCodigoAerolinea() == codigo){
                return listaAerolineas.get(i);
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
        
        if (buscarAerolineaCodigo(aerolinea.getCodigoAerolinea()) != null) {
            throw new CodigoAerolineaExisteException();
        }

        if (!aerolinea.getListaEmpleadosAerolinea().isEmpty()) {
            for (int i = 0; i < aerolinea.getListaEmpleadosAerolinea().size(); i++) {
                String correoActual = aerolinea.getListaEmpleadosAerolinea().get(i).getCorreo();
                if (validarCorreo(correoActual) != null) {
                    throw new CorreoRegistradoException();
                }
            }
        }

        AdministradorAerolinea adAeroBuscado = (AdministradorAerolinea) buscarAdminAerolineaId(admin.getIdentificacion());
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(admin.getIdentificacion());
        GestorMantenimiento gestorBuscado = (GestorMantenimiento) buscarGestorMantenimientoId(admin.getIdentificacion());
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
            }else {
                if(validarMismaInfoAdministrador(admin)) {
                    listaAerolineas.add(aerolinea);
                    Singleton.getInstancia().escribirAerolineas();
                } else {
                    throw new InformacionViajeroException();              
                }
            } 
        }else {
            listaAerolineas.add(aerolinea);
            Singleton.getInstancia().escribirAerolineas();
        }
    }  
    
    public void editarAdministrador(AdministradorAerolinea administrador) {
        
        AdministradorAerolinea adAeroBuscado = (AdministradorAerolinea) buscarAdminAerolineaId(administrador.getIdentificacion());
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(administrador.getIdentificacion());
        Persona correoBuscado = validarCorreo(administrador.getCorreo());

        if(adAeroBuscado != null) {
            if (!administrador.getIdentificacion().equals(adAeroBuscado.getIdentificacion())
                    || !administrador.getCorreo().equals(adAeroBuscado.getCorreo())) {
                throw new CambioCorreoIdentificacionException();
            }
            adAeroBuscado.setNombres(administrador.getNombres());
            adAeroBuscado.setApellidos(administrador.getApellidos());
            adAeroBuscado.setEdad(administrador.getEdad());
            adAeroBuscado.setNumTelefono(administrador.getNumTelefono());
            adAeroBuscado.setGenero(administrador.getGenero());
            adAeroBuscado.setContrasenia(administrador.getContrasenia());
            Singleton.getInstancia().escribirAerolineas();

            if (viajeroBuscado != null) {
                viajeroBuscado.setNombres(administrador.getNombres());
                viajeroBuscado.setApellidos(administrador.getApellidos());
                viajeroBuscado.setEdad(administrador.getEdad());
                viajeroBuscado.setNumTelefono(administrador.getNumTelefono());
                viajeroBuscado.setGenero(administrador.getGenero());
                Singleton.getInstancia().escribirAerolineas();
            } 
        }else {
            throw new IdentificacionNoExisteException();
        }
    }
    
    public void eliminarAdministradorAerolinea(String identificacion){
        
        Persona aux = buscarAdminAerolineaId(identificacion);
    	
        if (aux != null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
                Aerolinea aerolinea = listaAerolineas.get(i);
                for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                    if(aerolinea.getListaEmpleadosAerolinea().get(j).getIdentificacion().equals(aux.getIdentificacion()) && aerolinea.getListaEmpleadosAerolinea().get(j).getRol().equals("Empleado Logistica")){
                        aerolinea.getListaEmpleadosAerolinea().remove(j);
                        Singleton.getInstancia().escribirAerolineas();
                    }
                }
            }
        }else {
            throw new IdentificacionNoExisteException();
        }      
    }
     
//    public void eliminarAdministradorAerolinea(String identificacion){
//        
//        Persona aux = buscarAdminAerolineaId(identificacion);
//    	
//        if (aux != null) {
//            for (int i = 0; i < listaPersonas.size(); i++) {
//                if(listaPersonas.get(i).getIdentificacion().equals(aux.getIdentificacion()) && listaPersonas.get(i).getRol().equals("Administrador Aerolinea")){
//                    listaPersonas.remove(i);
//                    Singleton.getInstancia().escribirPersonas();                   
//                } 
//            }
//        }else {
//            throw new IdentificacionNoExisteException();
//        }      
//    }
}
