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
    
    private LSE<Persona> listaPersonas;
    private LSE<Aerolinea> listaAerolineas;
    
    public GestAdminAerolinea(){
        this.listaPersonas = Singleton.getInstancia().getPersonas();
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
    }
    
    public LSE<AdministradorAerolinea> obtenerAdministradores(){
        LSE<AdministradorAerolinea> listaAdministradores = new LSE<>();
        listaPersonas = Singleton.getInstancia().getPersonas();
        if(listaPersonas != null){         
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getRol().equals("Administrador Aerolinea")){
                    AdministradorAerolinea adminAerolinea = (AdministradorAerolinea) listaPersonas.get(i);
                    listaAdministradores.add(adminAerolinea);
                }
            }
            return listaAdministradores;  
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
    
    public Aerolinea buscarAerolineaCodigo(int codigo){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if(listaAerolineas.get(i).getCodigoAerolinea() == codigo){
                return listaAerolineas.get(i);
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
    
    public boolean validarMismaInfoAdministrador(AdministradorAerolinea persona) {
        
        Persona buscarInformacion = buscarInfo(persona.getIdentificacion());
        
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

//        if (!aerolinea.getListaAdministradores().isEmpty()) {
//            for (int i = 0; i < aerolinea.getListaAdministradores().size(); i++) {
//                String correoActual = aerolinea.getListaAdministradores().get(i).getCorreo();
//                if (validarCorreo(correoActual) != null) {
//                    throw new CorreoRegistradoException();
//                }
//            }
//        }

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
                    listaPersonas.add(admin);
                    listaAerolineas.add(aerolinea);
                    Singleton.getInstancia().escribirAerolineas();
                    Singleton.getInstancia().escribirPersonas();
                } else {
                    throw new InformacionViajeroException();              
                }
            } 
        }else {
            listaPersonas.add(admin);
            listaAerolineas.add(aerolinea);
            Singleton.getInstancia().escribirAerolineas();
            Singleton.getInstancia().escribirPersonas();
        }
    }  
    
//    public void guardarAerolinea(Aerolinea aerolinea, AdministradorAerolinea admin) {
//        
//        if (buscarAerolineaCodigo(aerolinea.getCodigoAerolinea()) != null) {
//            throw new CodigoAerolineaExisteException();
//        }
//
//        if (validarCorreo(admin.getCorreo()) != null) {
//            throw new CorreoRegistradoException();
//        }
//
//        AdministradorAerolinea adAeroBuscado = (AdministradorAerolinea) buscarAdminAerolineaId(admin.getIdentificacion());
//        Viajero viajeroBuscado = (Viajero) buscarViajeroId(admin.getIdentificacion());
//
//        if(adAeroBuscado != null || viajeroBuscado != null) {
//            if (adAeroBuscado != null) {
//                throw new AdminAeroRegistradoException();
//            }else {
//                if (validarMismaInfoAdministrador(admin)) {
//                    listaPersonas.add(aerolinea.getAdministradorAerolinea());
//                    listaAerolineas.add(aerolinea);
//                    Singleton.getInstancia().escribirAerolineas();
//                    Singleton.getInstancia().escribirPersonas();
//                } else {
//                    throw new InformacionViajeroException();              
//                }
//            } 
//        }else {
//            listaPersonas.add(aerolinea.getAdministradorAerolinea());
//            listaAerolineas.add(aerolinea);
//            Singleton.getInstancia().escribirAerolineas();
//            Singleton.getInstancia().escribirPersonas();
//        }
//    }
    
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
            Singleton.getInstancia().escribirPersonas();

            if (viajeroBuscado != null) {
                viajeroBuscado.setNombres(administrador.getNombres());
                viajeroBuscado.setApellidos(administrador.getApellidos());
                viajeroBuscado.setEdad(administrador.getEdad());
                viajeroBuscado.setNumTelefono(administrador.getNumTelefono());
                viajeroBuscado.setGenero(administrador.getGenero());
                Singleton.getInstancia().escribirPersonas();
            } 
        }else {
            throw new IdentificacionNoExisteException();
        }
    }
     
    public void eliminarAdministradorAerolinea(String identificacion){
        
        Persona aux = buscarAdminAerolineaId(identificacion);
    	
        if (aux != null) {
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getIdentificacion().equals(aux.getIdentificacion()) && listaPersonas.get(i).getRol().equals("Administrador Aerolinea")){
                    listaPersonas.remove(i);
                    Singleton.getInstancia().escribirPersonas();                   
                } 
            }
        }else {
            throw new IdentificacionNoExisteException();
        }      
    }
}
