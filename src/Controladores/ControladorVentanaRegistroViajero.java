package Controladores;

import Excepciones.*;
import Modelos.AdministradorAerolinea;
import Modelos.*;
import Singleton.Singleton;
import Util.LSE;
import Util.Pila;

/**
 *
 * @author diazje
 */
public class ControladorVentanaRegistroViajero {
    
    private LSE<Usuario> listaUsuarios;
    private LSE<Aerolinea> listaAerolineas;
    private Pila<LSE<Usuario>> z;
    private Pila<LSE<Usuario>> y;

    public ControladorVentanaRegistroViajero(){
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
        this.listaUsuarios = Singleton.getInstancia().getUsuarios();
        this.z = new Pila<>();
        this.y = new Pila<>();
    }
    
    public Pila<LSE<Usuario>> getZ() {
        return z;
    }

    public Pila<LSE<Usuario>> getY() {
        return y;
    }
    
    public void controlY(){
        listaUsuarios = y.pop();
        Singleton.getInstancia().setListaUsuarios(listaUsuarios);
        Singleton.getInstancia().escribirUsuarios();
    }
    
    public void controlZ(){
        listaUsuarios = z.pop();
        Singleton.getInstancia().setListaUsuarios(listaUsuarios);
        Singleton.getInstancia().escribirUsuarios();
    }
    
    public void limpiarY(){
        if(!y.isEmpty()){
            y = new Pila<>();
        }
    }
    
    public void respaldoZ(){  
        LSE<Usuario> respaldoUsuario = listaUsuarios.clone();
        z.push(respaldoUsuario);
        
    }
        
    public void respaldoY(){  
        LSE<Usuario> respaldoUsuario = listaUsuarios.clone();
        y.push(respaldoUsuario);
    }

    public LSE<Viajero> obtenerViajerosTabla(){
        LSE<Viajero> listaViajero = new LSE<>();
        listaUsuarios = Singleton.getInstancia().getUsuarios();
        if(listaUsuarios != null){         
            for (int i = 0; i < listaUsuarios.size(); i++) {
                if(listaUsuarios.get(i).getRol().equals("Viajero")){
                    Viajero viajero = (Viajero) listaUsuarios.get(i);
                    listaViajero.add(viajero); 
                }
            }
            return listaViajero;  
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
    
    public boolean validarMismaInfoViajero(Viajero persona) {
        
        Persona buscarInformacion = buscarInformacion(persona.getIdentificacion());
        
        if(persona.getNombres().equals(buscarInformacion.getNombres()) && persona.getApellidos().equals(buscarInformacion.getApellidos())
            && persona.getEdad() == buscarInformacion.getEdad() && persona.getGenero().equals(buscarInformacion.getGenero()) 
            && persona.getNumTelefono().equals(buscarInformacion.getNumTelefono()) ) {
            return true;
        }
        return false;
    }
    
    public void guardarViajero(Viajero persona) {
        
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(persona.getIdentificacion());
        GestorMantenimiento gestorBuscado = (GestorMantenimiento) buscarGestorMantenimiento(persona.getIdentificacion());
        AdministradorAerolinea adAeroBuscado = (AdministradorAerolinea) buscarAdminAerolineaId(persona.getIdentificacion());
        CapitanVuelo capitanBuscado = (CapitanVuelo) buscarCapitanVuelo(persona.getIdentificacion());
        EmpleadoLogistica empleadoBuscado = (EmpleadoLogistica) buscarEmpleadoLogistica(persona.getIdentificacion());
        Persona correoBuscado = validarCorreo(persona.getCorreo());
        Persona correoBuscado2 = validarCorreo2(persona.getCorreo());
        
        boolean personaYaExiste = viajeroBuscado != null || correoBuscado != null || correoBuscado2 != null || gestorBuscado != null || adAeroBuscado != null || capitanBuscado != null || empleadoBuscado != null;

        if(personaYaExiste) {
            if(viajeroBuscado != null) {
                throw new ViajeroRegistradoException();
            }else if (correoBuscado != null || correoBuscado2 != null) {
                throw new CorreoRegistradoException();
            }else if (gestorBuscado != null || adAeroBuscado != null || capitanBuscado != null || empleadoBuscado != null) {
                if(validarMismaInfoViajero(persona)) {
                    respaldoZ();
                    limpiarY();
                    listaUsuarios.add(persona);
                    Singleton.getInstancia().escribirUsuarios();
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
            respaldoZ();
            limpiarY();
            listaUsuarios.add(persona);
            Singleton.getInstancia().escribirUsuarios();
        }
    }  
}
