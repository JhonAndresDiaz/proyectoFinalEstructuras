package Controladores;

import Excepciones.*;
import Modelos.*;
import Singleton.Singleton;
import Util.LSE;
import Util.Nodo;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author diaza
 */
public class ControladorVentanaGestionAdministradoresAerolinea {
    
    private LSE<Aerolinea> listaAerolineas;
    private LSE<Usuario> listaUsuarios;
    
    public ControladorVentanaGestionAdministradoresAerolinea(){
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
        this.listaUsuarios = Singleton.getInstancia().getUsuarios();
    }
    
    public LSE traerAerolineas(){
        LSE lista = Singleton.getInstancia().getAerolineas();
        return lista;
    }
    
    public LSE<Persona> obtenerListaEmpleados(int codigo) {
        Aerolinea aux =  buscarAerolineaCodigo(codigo);
        if(aux != null){
            if(aux.getListaEmpleadosAerolinea() != null){
                return aux.getListaEmpleadosAerolinea();
            }   
        }
        return new LSE<>();
    }  
    
     public LSE<AdministradorAerolinea> obtenerAdministradoresDeAerolineas(int codigo){
        LSE<AdministradorAerolinea> listaAdministradores = new LSE<>();
        listaAerolineas = Singleton.getInstancia().getAerolineas();
        if(listaAerolineas != null){         
            for (int i = 0; i < listaAerolineas.size(); i++) {
                Aerolinea aerolineaEncontrada = buscarAerolineaCodigo(codigo);
                if(aerolineaEncontrada.getCodigoAerolinea() == codigo){
                    for (int j = 0; j < aerolineaEncontrada.getListaEmpleadosAerolinea().size(); j++) {
                        if(aerolineaEncontrada.getListaEmpleadosAerolinea().get(j).getRol().equals("Administrador Aerolinea")){
                            AdministradorAerolinea administradorAe = (AdministradorAerolinea) aerolineaEncontrada.getListaEmpleadosAerolinea().get(j);
                            listaAdministradores.add(administradorAe);
                        }
                    }
                }   
            }
            return listaAdministradores;  
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
    
    public Aerolinea buscarAerolineaNombre(String nombre){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if(listaAerolineas.get(i).getNombreAerolinea().equals(nombre)){
                return listaAerolineas.get(i);
            }  
        }
        return null;    
    }
    
    public boolean buscarAeroNombre(String nombre){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if(listaAerolineas.get(i).getNombreAerolinea().equals(nombre)){
                return true;
            }  
        }
        return false;    
    }
    
    public Aerolinea buscarAdAerolinea(String id) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                Persona persona = aerolinea.getListaEmpleadosAerolinea().get(j);

                if (persona instanceof AdministradorAerolinea) {
                    AdministradorAerolinea administrador = (AdministradorAerolinea) persona;
                    if (administrador.getIdentificacion().equals(id)) {
                        return aerolinea;
                    }
                }
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
    
    public void editarAerolinea(Aerolinea aerolinea){
        
        Aerolinea aerolineaBuscada = buscarAerolineaCodigo(aerolinea.getCodigoAerolinea());
        boolean validarNombre = buscarAeroNombre(aerolinea.getNombreAerolinea());
        
        if(aerolinea != null){
            if(!validarNombre){
                aerolineaBuscada.setNombreAerolinea(aerolinea.getNombreAerolinea());
                aerolineaBuscada.setPais(aerolinea.getPais());
                Singleton.getInstancia().escribirAerolineas();
            }else {
                throw new NombreAerolineaEstaEnUsoException();
            } 
        }
    }
    
    public void eliminarAerolinea(int codigo) {
        Aerolinea aux = buscarAerolineaCodigo(codigo);

        if (aux != null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
                Aerolinea aerolinea = listaAerolineas.get(i);
                for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                    Avion avion = aerolinea.getListaAviones().get(j);
                    for (int k = 0; k < avion.getCronograma().size(); k++) {
                        Vuelo vuelo = avion.getCronograma().get(k);
                        if(vuelo.getListaReservas().isEmpty()) {
                            listaAerolineas.remove(i); 
                            Singleton.getInstancia().escribirAerolineas();
                            return;               
                        } else {
                            throw new ExistenViajerosEnListaException();
                        }
                    }
                }             
            }
        } else {
            throw new NumeroCodigoVueloNoExisteException();
        }      
    }
    
    public void guardarAerolinea(Aerolinea aerolinea, AdministradorAerolinea admin) {
        
        if(validarCorreo(admin.getCorreo()) != null || validarCorreo2(admin.getCorreo()) != null) {
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
                    Aerolinea aerolineaBuscada = buscarAerolineaCodigo(aerolinea.getCodigoAerolinea());
                    if(aerolineaBuscada != null){
                        aerolineaBuscada.getListaEmpleadosAerolinea().add(admin);
                        Singleton.getInstancia().escribirAerolineas();
                    }
                } else {
                    throw new InformacionViajeroException();              
                }
            } 
        }else {
            Aerolinea aerolineaBuscada = buscarAerolineaCodigo(aerolinea.getCodigoAerolinea());
            if(aerolineaBuscada != null){
                aerolineaBuscada.getListaEmpleadosAerolinea().add(admin);
                Singleton.getInstancia().escribirAerolineas();
            }
        }
    }
    
    public void editarAdministrador(AdministradorAerolinea administrador) {
        
        AdministradorAerolinea adAeroBuscado = (AdministradorAerolinea) buscarAdminAerolineaId(administrador.getIdentificacion());
        Viajero viajeroBuscado = (Viajero) buscarViajeroId(administrador.getIdentificacion());

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
                Singleton.getInstancia().escribirUsuarios();
            } 
        }else {
            throw new IdentificacionNoExisteException();
        }
    }
    
    public void eliminarAdministradorAero(String identificacion, Aerolinea aerolinea) {

    Persona aux = buscarAdminAerolineaId(identificacion);

        if (aux != null) {
            LSE<Persona> listaAdministradoresAerolinea = aerolinea.getListaEmpleadosAerolinea();

            if (esUnicoAdmin(listaAdministradoresAerolinea)) {
                throw new Almenos1AdminException();
            }

            int indexToRemove = -1;
            Nodo<Persona> nodo = listaAdministradoresAerolinea.getPrimero();
            for (int i = 0; i < listaAdministradoresAerolinea.size(); i++) {
                AdministradorAerolinea admin = (AdministradorAerolinea) nodo.getDato();
                if (admin.getIdentificacion().equals(aux.getIdentificacion())) {
                    indexToRemove = i;
                    break;
                }
                nodo = nodo.getNodoSiguiente();
            }

            if (indexToRemove >= 0) {
                listaAdministradoresAerolinea.remove(indexToRemove);
            }
            
            for (int i = 0; i < listaAerolineas.size(); i++) {
                Aerolinea aerolineaBuscarPersona = listaAerolineas.get(i);
                for (int j = 0; j < aerolineaBuscarPersona.getListaEmpleadosAerolinea().size(); j++) {
                    if(aerolineaBuscarPersona.getListaEmpleadosAerolinea().get(j).getIdentificacion().equals(aux.getIdentificacion()) && aerolineaBuscarPersona.getListaEmpleadosAerolinea().get(j).getRol().equals("Administrador Aerolinea")){
                        listaAerolineas.remove(j);
                        break;
                    }
                }
            }
            Singleton.getInstancia().escribirAerolineas();
        } else {
            throw new IdentificacionNoExisteException();
        }
    }

    private boolean esUnicoAdmin(LSE<Persona> listaAdministradoresAerolinea) {
        int cantidadAdmins = 0;
        Nodo<Persona> nodo = listaAdministradoresAerolinea.getPrimero();

        while (nodo != null) {
            AdministradorAerolinea admin = (AdministradorAerolinea) nodo.getDato();
            cantidadAdmins++;
            nodo = nodo.getNodoSiguiente();
        }

        return cantidadAdmins <= 1;
    }
    
}
