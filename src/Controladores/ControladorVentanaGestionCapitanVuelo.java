package Controladores;

import Excepciones.*;
import Modelos.AdministradorAerolinea;
import Modelos.Aerolinea;
import Modelos.CapitanVuelo;
import Modelos.EmpleadoLogistica;
import Modelos.GestorMantenimiento;
import Modelos.Persona;
import Modelos.Viajero;
import Singleton.Singleton;
import Util.LSE;
import Util.Nodo;

/**
 *
 * @author diaza
 */
public class ControladorVentanaGestionCapitanVuelo {
    
    private LSE<Persona> listaPersonas;
    private LSE<Aerolinea> listaAerolineas;
    private Aerolinea aerolinea;

    public ControladorVentanaGestionCapitanVuelo(Aerolinea aerolinea){
        this.listaPersonas = Singleton.getInstancia().getPersonas();
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
        this.aerolinea = aerolinea;
    }
    
    public LSE<CapitanVuelo> conseguirCapitanes(Aerolinea aerolinea) {
        LSE<CapitanVuelo> lista = new LSE<>();
        Nodo<Aerolinea> nodoAerolinea = listaAerolineas.getPrimero();

        while (nodoAerolinea != null) {
            Aerolinea aerolineaActual = nodoAerolinea.getDato();
            if (aerolineaActual.getCodigoAerolinea() == aerolinea.getCodigoAerolinea()) {
                Nodo<Persona> nodoCapitan = aerolineaActual.getListaEmpleadosAerolinea().getPrimero();

                while (nodoCapitan != null) {
                    lista.add((CapitanVuelo) nodoCapitan.getDato());
                    nodoCapitan = nodoCapitan.getNodoSiguiente();
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
    
    public boolean validarMismoCapitanVuelo(CapitanVuelo persona) {
        
        Persona buscarInformacion = buscarInfo(persona.getIdentificacion());
        
        if(persona.getNombres().equals(buscarInformacion.getNombres()) && persona.getApellidos().equals(buscarInformacion.getApellidos())
            && persona.getEdad() == buscarInformacion.getEdad() && persona.getGenero().equals(buscarInformacion.getGenero()) 
            && persona.getNumTelefono().equals(buscarInformacion.getNumTelefono()) ) {
            return true;
        }
        return false;
    }
    
    public void guardarCapitanVuelo(CapitanVuelo persona) {
        
        CapitanVuelo capitanBuscado = (CapitanVuelo) buscarCapitanVuelo(persona.getIdentificacion());
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(persona.getIdentificacion());
        Persona correoBuscado = validarCorreo(persona.getCorreo());
        GestorMantenimiento gestorBuscado = (GestorMantenimiento) buscarGestorMantenimientoId(persona.getIdentificacion());
        AdministradorAerolinea adAeroBuscado = (AdministradorAerolinea) buscarAdminAerolineaId(persona.getIdentificacion());
        EmpleadoLogistica empleadoBuscado = (EmpleadoLogistica) buscarEmpleadoLogistica(persona.getIdentificacion());
                
        boolean personaYaExiste = viajeroBuscado != null || correoBuscado != null || capitanBuscado != null || gestorBuscado != null || adAeroBuscado != null || empleadoBuscado != null ;
            
        if(personaYaExiste) {
            if (capitanBuscado != null) {
                throw new CapitanVueloRegistradoException();
            }else if (correoBuscado != null) {
                throw new CorreoRegistradoException();
            }else if(gestorBuscado != null){
                throw new GestorRegistradoException();
            }else if(adAeroBuscado != null){
                throw new AdminAeroRegistradoException();
            }else if(empleadoBuscado != null){
                throw new EmpleadoLogisticaRegistradoException();
            }else if (viajeroBuscado != null) {
                if (validarMismoCapitanVuelo(persona)) {
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
    
    public void editarCapitanVuelo(CapitanVuelo capitanVuelo) {
        
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(capitanVuelo.getIdentificacion());
        CapitanVuelo capitanBuscado = (CapitanVuelo) buscarCapitanVuelo(capitanVuelo.getIdentificacion());
        Persona correoBuscado = validarCorreo(capitanVuelo.getCorreo());
             
        if(capitanBuscado != null) {
            if (!capitanVuelo.getIdentificacion().equals(capitanBuscado.getIdentificacion())
                    || !capitanVuelo.getCorreo().equals(capitanBuscado.getCorreo())) {
                throw new CambioCorreoIdentificacionException();
            }
      
            capitanBuscado.setNombres(capitanVuelo.getNombres());
            capitanBuscado.setApellidos(capitanVuelo.getApellidos());
            capitanBuscado.setEdad(capitanVuelo.getEdad());
            capitanBuscado.setNumTelefono(capitanVuelo.getNumTelefono());
            capitanBuscado.setGenero(capitanVuelo.getGenero());
            capitanBuscado.setContrasenia(capitanVuelo.getContrasenia());
            capitanBuscado.setTipoCertificado(capitanVuelo.getTipoCertificado());
            capitanBuscado.setLicenciaDePiloto(capitanVuelo.getLicenciaDePiloto());
            Singleton.getInstancia().escribirPersonas();

            if(viajeroBuscado != null) {
                viajeroBuscado.setNombres(capitanVuelo.getNombres());
                viajeroBuscado.setApellidos(capitanVuelo.getApellidos());
                viajeroBuscado.setEdad(capitanVuelo.getEdad());
                viajeroBuscado.setNumTelefono(capitanVuelo.getNumTelefono());
                viajeroBuscado.setGenero(capitanVuelo.getGenero());
                Singleton.getInstancia().escribirPersonas();
            }
        }else {
            throw new IdentificacionNoExisteException();
        }
    }

    public void eliminarCapitanVuelo(String identificacion){
        
        Persona aux = buscarCapitanVuelo(identificacion);
    	
        if (aux != null) {
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getIdentificacion().equals(aux.getIdentificacion()) && listaPersonas.get(i).getRol().equals("Capitan Vuelo")){
                    listaPersonas.remove(i);
                    Singleton.getInstancia().escribirPersonas();                   
                } 
            }
        }else {
            throw new IdentificacionNoExisteException();
        }      
    } 
}
