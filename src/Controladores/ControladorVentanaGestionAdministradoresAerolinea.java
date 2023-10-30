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
public class ControladorVentanaGestionAdministradoresAerolinea {
    
    private LSE<Persona> listaPersonas;
    private LSE<Aerolinea> listaAerolineas;
    
    public ControladorVentanaGestionAdministradoresAerolinea(){
        this.listaPersonas = Singleton.getInstancia().getPersonas();
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
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
    
//    public LSE<Aerolinea> obtenerAerolineas(){
//        LSE<Aerolinea> listaAero = new LSE<>();
//        listaAerolineas = Singleton.getInstancia().getAerolineas();
//        if(listaAerolineas != null){         
//            for (int i = 0; i < listaAerolineas.size(); i++) {
//                Aerolinea aerolinea =  listaAerolineas.get(i);
//                listaAero.add(aerolinea);
//            }
//            return listaAero;  
//        }
//        return new LSE<>();
//    }
    
     public LSE<AdministradorAerolinea> obtenerAdministradoresDeAerolineas(){
        LSE<AdministradorAerolinea> listaAdministradores = new LSE<>();
        listaPersonas = Singleton.getInstancia().getPersonas();
        if(listaPersonas != null){         
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getRol().equals("Administrador Aerolinea")){
                   AdministradorAerolinea adminAero =  (AdministradorAerolinea) listaPersonas.get(i);
                   listaAdministradores.add(adminAero);  
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
    
    public Aerolinea buscarAeroNombre(String nombre){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if(listaAerolineas.get(i).getNombreAerolinea().equals(nombre)){
                return listaAerolineas.get(i);
            }  
        }
        return null;    
    }
    
    public Aerolinea buscarAdAerolinea(String id) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                AdministradorAerolinea administrador = (AdministradorAerolinea) aerolinea.getListaEmpleadosAerolinea().get(j);
                if (administrador.getIdentificacion().equals(id)) {
                    return aerolinea;
                }
            }
        }
        return null;
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

    public Persona validarCorreo(String correo) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getCorreo().equals(correo)) {
                return listaPersonas.get(i);
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
        
        if(validarCorreo(admin.getCorreo()) != null) {
            throw new CorreoRegistradoException();
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
            }else if(viajeroBuscado != null) {
                if(validarMismaInfoAdministrador(admin)) {
                    Aerolinea aerolineaBuscada = buscarAerolineaCodigo(aerolinea.getCodigoAerolinea());
                    if(aerolineaBuscada != null){
                        aerolineaBuscada.getListaEmpleadosAerolinea().add(admin);
                        listaPersonas.add(admin);
                        Singleton.getInstancia().escribirAerolineas();
                        Singleton.getInstancia().escribirPersonas(); 
                    }
                } else {
                    throw new InformacionViajeroException();              
                }
            } 
        }else {
            Aerolinea aerolineaBuscada = buscarAerolineaCodigo(aerolinea.getCodigoAerolinea());
            if(aerolineaBuscada != null){
                aerolineaBuscada.getListaEmpleadosAerolinea().add(admin);
                listaPersonas.add(admin);
                Singleton.getInstancia().escribirAerolineas();
                Singleton.getInstancia().escribirPersonas(); 
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

            for (int i = 0; i < listaPersonas.size(); i++) {
                if (listaPersonas.get(i).getIdentificacion().equals(aux.getIdentificacion()) && listaPersonas.get(i).getRol().equals("Administrador Aerolinea")) {
                    listaPersonas.remove(i);
                    break;
                }
            }

            Singleton.getInstancia().escribirAerolineas();
            Singleton.getInstancia().escribirPersonas();
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

    
//    public void eliminarAdministradorAero(String identificacion, Aerolinea aerolinea) {
//        
//        Persona aux = buscarAdminAerolineaId(identificacion);
//
//        if (aux != null) {
//            LSE<Persona> listaAdministradoresAerolinea = aerolinea.getListaEmpleadosAerolinea();
//
//            if (esUnicoAdmin(aerolinea, aux)) {
//                throw new Almenos1AdminException();
//            }
//
//            for (int i = 0; i < listaAdministradoresAerolinea.size(); i++) {
//                AdministradorAerolinea admin = (AdministradorAerolinea) listaAdministradoresAerolinea.get(i);
//                if (admin.getIdentificacion().equals(aux.getIdentificacion())) {
//                    listaAdministradoresAerolinea.remove(i);
//                    break;
//                }
//            }
//
//            for (int i = 0; i < listaPersonas.size(); i++) {
//                if (listaPersonas.get(i).getIdentificacion().equals(aux.getIdentificacion()) && listaPersonas.get(i).getRol().equals("Administrador Aerolinea")) {
//                    listaPersonas.remove(i);
//                    break;
//                }
//            }
//
//            Singleton.getInstancia().escribirAerolineas();
//            Singleton.getInstancia().escribirPersonas();
//        } else {
//            throw new IdentificacionNoExisteException();
//        }
//    }
//    
//    private boolean esUnicoAdmin(Aerolinea aerolinea, Persona adminAEliminar) {
//        LSE<Persona> listaAdministradoresAerolinea = aerolinea.getListaEmpleadosAerolinea();
//        int cantidadAdmins = 0;
//
//        Nodo<Persona> nodo = listaAdministradoresAerolinea.getPrimero();
//
//        while (nodo != null) {
//            AdministradorAerolinea admin = (AdministradorAerolinea) nodo.getDato();
//            if (admin.getIdentificacion().equals(adminAEliminar.getIdentificacion())) {
//                cantidadAdmins++;
//            }
//            nodo = nodo.getNodoSiguiente();
//        }
//
//        return cantidadAdmins > 1;
//    }
}
