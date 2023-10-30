package Controladores;

import Excepciones.*;
import Modelos.*;
import Singleton.Singleton;
import Util.LSE;
import Util.Nodo;

/**
 *
 * @author diaza
 */
public class ControladorVentanaGestionEmpleadoLogistica {
    
    private LSE<Persona> listaPersonas;
    private LSE<Aerolinea> listaAerolineas;
    private Aerolinea aerolinea;

    public ControladorVentanaGestionEmpleadoLogistica(Aerolinea aerolinea){
        this.listaPersonas = Singleton.getInstancia().getPersonas();
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
        this.aerolinea = aerolinea;
    }
   
    public LSE<EmpleadoLogistica> conseguirEmpleados() {
        LSE<EmpleadoLogistica> lista = new LSE<>();
        Nodo<Aerolinea> nodoAerolinea = listaAerolineas.getPrimero();

        while (nodoAerolinea != null) {
            Aerolinea aerolineaActual = nodoAerolinea.getDato();
            if (aerolineaActual.getCodigoAerolinea() == aerolinea.getCodigoAerolinea()) {
                Nodo<Persona> nodoEmpleado = aerolineaActual.getListaEmpleadosAerolinea().getPrimero();

                while (nodoEmpleado != null) {
                    lista.add((EmpleadoLogistica) nodoEmpleado.getDato());
                    nodoEmpleado = nodoEmpleado.getNodoSiguiente();
                }
            }
            nodoAerolinea = nodoAerolinea.getNodoSiguiente();
        }
        return lista;
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
    
    public boolean validarMismoEmpleado(EmpleadoLogistica persona) {
        
        Persona buscarInformacion = buscarInfo(persona.getIdentificacion());
        
        if(persona.getNombres().equals(buscarInformacion.getNombres()) && persona.getApellidos().equals(buscarInformacion.getApellidos())
            && persona.getEdad() == buscarInformacion.getEdad() && persona.getGenero().equals(buscarInformacion.getGenero()) 
            && persona.getNumTelefono().equals(buscarInformacion.getNumTelefono()) ) {
            return true;
        }
        return false;
    }
    
    public void guardarEmpleadoLog(EmpleadoLogistica persona) {
        
        CapitanVuelo capitanBuscado = (CapitanVuelo) buscarCapitanVuelo(persona.getIdentificacion());
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(persona.getIdentificacion());
        Persona correoBuscado = validarCorreo(persona.getCorreo());
        GestorMantenimiento gestorBuscado = (GestorMantenimiento) buscarGestorMantenimientoId(persona.getIdentificacion());
        AdministradorAerolinea adAeroBuscado = (AdministradorAerolinea) buscarAdminAerolineaId(persona.getIdentificacion());
        EmpleadoLogistica empleadoBuscado = (EmpleadoLogistica) buscarEmpleadoLogistica(persona.getIdentificacion());
                
        boolean personaYaExiste = viajeroBuscado != null || correoBuscado != null || capitanBuscado != null || gestorBuscado != null || adAeroBuscado != null || empleadoBuscado != null ;
            
        if(personaYaExiste) {
            if (empleadoBuscado != null) {
                throw new EmpleadoLogisticaRegistradoException();
            }else if (correoBuscado != null) {
                throw new CorreoRegistradoException();
            }else if(gestorBuscado != null){
                throw new GestorRegistradoException();
            }else if(adAeroBuscado != null){
                throw new AdminAeroRegistradoException();
            }else if(capitanBuscado != null){
                throw new CapitanVueloRegistradoException();
            }else if (viajeroBuscado != null) {
                if (validarMismoEmpleado(persona)) {
                    aerolinea.getListaEmpleadosAerolinea().add(persona);
                    listaPersonas.add(persona);
                    Singleton.getInstancia().escribirPersonas();
                    Singleton.getInstancia().escribirAerolineas();
                }else {
                    throw new InformacionViajeroException();   
                }
            }
        }else {
            aerolinea.getListaEmpleadosAerolinea().add(persona);
            listaPersonas.add(persona);
            Singleton.getInstancia().escribirPersonas();
            Singleton.getInstancia().escribirAerolineas();
        }
    }
    
    public void editarEmpleadoLog(EmpleadoLogistica empleadoLogistica) {
        
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(empleadoLogistica.getIdentificacion());
        EmpleadoLogistica empleadoBuscado = (EmpleadoLogistica) buscarEmpleadoLogistica(empleadoLogistica.getIdentificacion());
        Persona correoBuscado = validarCorreo(empleadoLogistica.getCorreo());
             
        if(empleadoBuscado != null) {
            if (!empleadoLogistica.getIdentificacion().equals(empleadoBuscado.getIdentificacion())
                    || !empleadoLogistica.getCorreo().equals(empleadoBuscado.getCorreo())) {
                throw new CambioCorreoIdentificacionException();
            }
      
            empleadoBuscado.setNombres(empleadoLogistica.getNombres());
            empleadoBuscado.setApellidos(empleadoLogistica.getApellidos());
            empleadoBuscado.setEdad(empleadoLogistica.getEdad());
            empleadoBuscado.setNumTelefono(empleadoLogistica.getNumTelefono());
            empleadoBuscado.setGenero(empleadoLogistica.getGenero());
            empleadoBuscado.setContrasenia(empleadoLogistica.getContrasenia());
            empleadoBuscado.setNumeroTarjetaProfesional(empleadoLogistica.getNumeroTarjetaProfesional());
            empleadoBuscado.setApellidos(empleadoLogistica.getRutasAsignadas());
            empleadoBuscado.setAniosExperiencia(empleadoLogistica.getEdad());
            Singleton.getInstancia().escribirPersonas();

            if(viajeroBuscado != null) {
                viajeroBuscado.setNombres(empleadoLogistica.getNombres());
                viajeroBuscado.setApellidos(empleadoLogistica.getApellidos());
                viajeroBuscado.setEdad(empleadoLogistica.getEdad());
                viajeroBuscado.setNumTelefono(empleadoLogistica.getNumTelefono());
                viajeroBuscado.setGenero(empleadoLogistica.getGenero());
                Singleton.getInstancia().escribirPersonas();
            }
        }else {
            throw new IdentificacionNoExisteException();
        }
    }

    public void eliminarEmpleadoLog(String identificacion){
        
        Persona aux = buscarEmpleadoLogistica(identificacion);
    	
        if (aux != null) {
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getIdentificacion().equals(aux.getIdentificacion()) && listaPersonas.get(i).getRol().equals("Empleado Logistica")){
                    listaPersonas.remove(i);
                    Singleton.getInstancia().escribirPersonas();                   
                } 
            }
        }else {
            throw new IdentificacionNoExisteException();
        }      
    }
    
}
