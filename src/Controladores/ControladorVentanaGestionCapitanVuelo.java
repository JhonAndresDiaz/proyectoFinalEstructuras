package Controladores;

import Excepciones.*;
import Modelos.AdministradorAerolinea;
import Modelos.Aerolinea;
import Modelos.CapitanVuelo;
import Modelos.EmpleadoLogistica;
import Modelos.GestorMantenimiento;
import Modelos.Persona;
import Modelos.Usuario;
import Modelos.Viajero;
import Singleton.Singleton;
import Util.LSE;
import Util.Nodo;

/**
 *
 * @author diaza
 */
public class ControladorVentanaGestionCapitanVuelo {
    
    private LSE<Aerolinea> listaAerolineas;
    private LSE<Usuario> listaUsuarios;

    public ControladorVentanaGestionCapitanVuelo(){
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
        this.listaUsuarios = Singleton.getInstancia().getUsuarios();
    }

    public Aerolinea buscarAdAerolinea(String id) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                if(aerolinea.getListaEmpleadosAerolinea().get(j) instanceof AdministradorAerolinea) {
                    AdministradorAerolinea admin = (AdministradorAerolinea) aerolinea.getListaEmpleadosAerolinea().get(j);
                    if (admin.getIdentificacion().equals(id)) {
                        return aerolinea;
                    }
                }
            }
        }
        return null;
    }
    
    public Aerolinea buscarAerolineaCodigoAero(int codigo){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if(listaAerolineas.get(i).getCodigoAerolinea() == codigo){
                return listaAerolineas.get(i);
            }  
        }
        return null;    
    }
    
    public LSE<CapitanVuelo> conseguirCapitanes(Aerolinea aerolinea) {
        LSE<CapitanVuelo> lista = new LSE<>();
        Nodo<Aerolinea> nodoAerolinea = listaAerolineas.getPrimero();

        while (nodoAerolinea != null) {
            Aerolinea aerolineaActual = nodoAerolinea.getDato();
            if (aerolineaActual.getCodigoAerolinea() == aerolinea.getCodigoAerolinea()) {
                Nodo<Persona> nodoEmpleado = aerolineaActual.getListaEmpleadosAerolinea().getPrimero();

                while (nodoEmpleado != null) {
                    if (nodoEmpleado.getDato() instanceof CapitanVuelo) {
                        lista.add((CapitanVuelo) nodoEmpleado.getDato());
                    }
                    nodoEmpleado = nodoEmpleado.getNodoSiguiente();
                }
            }
            nodoAerolinea = nodoAerolinea.getNodoSiguiente();
        }
        return lista;
    }
    
    public Viajero buscarViajeroId(String identificacion) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getRol().equals("Viajero")) {
                Viajero viajero = (Viajero) listaUsuarios.get(i);
                if (viajero.getIdentificacion().equals(identificacion)) {
                    return viajero;
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
    
    public boolean validarMismoCapitanVuelo(CapitanVuelo persona) {
        
        Persona buscarInformacion = buscarInformacion(persona.getIdentificacion());
        
        if(buscarInformacion != null){
            if(persona.getNombres().equals(buscarInformacion.getNombres()) && persona.getApellidos().equals(buscarInformacion.getApellidos())
                && persona.getEdad() == buscarInformacion.getEdad() && persona.getGenero().equals(buscarInformacion.getGenero()) 
                && persona.getNumTelefono().equals(buscarInformacion.getNumTelefono()) ) {
                return true;
            }
        }
        return false;
    }
    
    public void guardarCapitanVuelo(CapitanVuelo persona, Aerolinea aerolinea) {
        
        CapitanVuelo capitanBuscado = (CapitanVuelo) buscarCapitanVuelo(persona.getIdentificacion());
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(persona.getIdentificacion());
        Persona correoBuscado = validarCorreo(persona.getCorreo());
        Persona correoBuscado2 = validarCorreo2(persona.getIdentificacion());
        GestorMantenimiento gestorBuscado = (GestorMantenimiento) buscarGestorMantenimiento(persona.getIdentificacion());
        AdministradorAerolinea adAeroBuscado = (AdministradorAerolinea) buscarAdminAerolineaId(persona.getIdentificacion());
        EmpleadoLogistica empleadoBuscado = (EmpleadoLogistica) buscarEmpleadoLogistica(persona.getIdentificacion());
                
        boolean personaYaExiste = viajeroBuscado != null || correoBuscado != null || correoBuscado2 != null || capitanBuscado != null || gestorBuscado != null || adAeroBuscado != null || empleadoBuscado != null ;
            
        if(personaYaExiste) {
            if (capitanBuscado != null) {
                throw new CapitanVueloRegistradoException();
            }else if (correoBuscado != null || correoBuscado2 != null) {
                throw new CorreoRegistradoException();
            }else if(gestorBuscado != null){
                throw new GestorRegistradoException();
            }else if(adAeroBuscado != null){
                throw new AdminAeroRegistradoException();
            }else if(empleadoBuscado != null){
                throw new EmpleadoLogisticaRegistradoException();
            }else if (viajeroBuscado != null) {
                if (validarMismoCapitanVuelo(persona)) {
                    Aerolinea aerolineaBuscada = buscarAerolineaCodigoAero(aerolinea.getCodigoAerolinea());
                    if (aerolineaBuscada != null) {
                        aerolineaBuscada.getListaEmpleadosAerolinea().add(persona);
                        Singleton.getInstancia().escribirAerolineas();
                    }
                }else {
                    throw new InformacionViajeroException();   
                }
            }
        }else {
            Aerolinea aerolineaBuscada = buscarAerolineaCodigoAero(aerolinea.getCodigoAerolinea());
            if (aerolineaBuscada != null) {
                aerolineaBuscada.getListaEmpleadosAerolinea().add(persona);
                Singleton.getInstancia().escribirAerolineas();
            }
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
            Singleton.getInstancia().escribirAerolineas();

            if(viajeroBuscado != null) {
                viajeroBuscado.setNombres(capitanVuelo.getNombres());
                viajeroBuscado.setApellidos(capitanVuelo.getApellidos());
                viajeroBuscado.setEdad(capitanVuelo.getEdad());
                viajeroBuscado.setNumTelefono(capitanVuelo.getNumTelefono());
                viajeroBuscado.setGenero(capitanVuelo.getGenero());
                Singleton.getInstancia().escribirUsuarios();
            }
        }else {
            throw new IdentificacionNoExisteException();
        }
    }
    
    public void eliminarCapitanVuelo(String identificacion){
        
        Persona aux = buscarCapitanVuelo(identificacion);
    	
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
}
