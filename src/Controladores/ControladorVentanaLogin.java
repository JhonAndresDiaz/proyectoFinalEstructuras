 
package Controladores;

import Modelos.*;
import Singleton.Singleton;
import Util.LSE;

/**
 *
 * @author diazje
 */
public class ControladorVentanaLogin {
    
    private LSE<Persona> listaPersonas;
    private LSE<Aerolinea> listaAerolineas;

    
    public ControladorVentanaLogin(){
        this.listaPersonas = Singleton.getInstancia().getPersonas();
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
    }
    
    public LSE<Persona> obtenerPersonas(){
        return Singleton.getInstancia().leerPersonas();
    }
    
    public Persona buscarPersona(String correo){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getCorreo().equals(correo)){
                return listaPersonas.get(i);
            }
        }
        return null;  
    }
    
    public Aerolinea buscarAeroAdminAerolinea(String usuario) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            LSE<Persona> administradores = aerolinea.getListaEmpleadosAerolinea();

            for (int j = 0; j < administradores.size(); j++) {
                Persona empleado = administradores.get(j);
                if (empleado instanceof AdministradorAerolinea) {
                    AdministradorAerolinea admin = (AdministradorAerolinea) empleado;
                    if (admin.getCorreo().equals(usuario)) {
                        return aerolinea;
                    }
                }
            }
        }
        return null;
    }
    
//    public Aerolinea buscarAeroAdminAerolinea(String usuario) {
//        for (int i = 0; i < listaAerolineas.size(); i++) {
//            Aerolinea aerolinea = listaAerolineas.get(i);
//            LSE<Persona> administradores = aerolinea.getListaEmpleadosAerolinea();
//
//            for (int j = 0; j < administradores.size(); j++) {
//                if(administradores.get(i).getRol().equals("Administrador Aerolinea")){
//                    AdministradorAerolinea admin = (AdministradorAerolinea) administradores.get(j);
//                    if (admin.getCorreo().equals(usuario)) {
//                        return aerolinea;
//                    }  
//                }
//                    
//            }
//        }
//        return null;
//    }
    
    public Aerolinea buscarAeroEmpleadoLog(String usuario) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            LSE<Persona> empleados = aerolinea.getListaEmpleadosAerolinea();

            for (int j = 0; j < empleados.size(); j++) {
                Persona empleado = empleados.get(j);
                if(empleado instanceof EmpleadoLogistica) {
                    EmpleadoLogistica empleadoLogistica = (EmpleadoLogistica) empleado;
                    if(empleadoLogistica.getCorreo().equals(usuario)) {
                        return aerolinea;
                    }
                }
            }
        }
        return null;
    }
    
    public Aerolinea buscarAeroCapitanVuelo(String usuario) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            LSE<Persona> capitanes = aerolinea.getListaEmpleadosAerolinea();

            for (int j = 0; j < capitanes.size(); j++) {
                if (capitanes.get(j) instanceof CapitanVuelo) {
                    CapitanVuelo capitan = (CapitanVuelo) capitanes.get(j);
                    if (capitan.getCorreo().equals(usuario)) {
                        return aerolinea;
                    }
                }
            }
        }
        return null;
    }

    public Persona crearAdministradorGeneral() {
        Persona persona = new Persona("1095550822","Jhon" , "Cano", 18, "Masculino", "313882", "Admin", "123", "Administrador General"); 
        return persona;
    }   
}
