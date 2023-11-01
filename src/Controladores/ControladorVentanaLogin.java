 
package Controladores;

import Modelos.*;
import Singleton.Singleton;
import Util.LSE;

/**
 *
 * @author diazje
 */
public class ControladorVentanaLogin {
    
    private LSE<Aerolinea> listaAerolineas;
    private LSE<Usuario> listaUsuarios;

    public ControladorVentanaLogin(){
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
        this.listaUsuarios = Singleton.getInstancia().getUsuarios();
    }
    
    public LSE<Aerolinea> obtenerPersonas(){
        return Singleton.getInstancia().leerAerolineas();
    }
    
    public Persona buscarUsuario(String correo, String contrasenia) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuario = listaUsuarios.get(i);
            if (usuario.getCorreo().equals(correo) && usuario.getContrasenia().equals(contrasenia)) {
                return (Persona) usuario;
            }
        }

        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
                Persona empleado = aerolinea.getListaEmpleadosAerolinea().get(j);
                if (empleado.getCorreo().equals(correo) && empleado.getContrasenia().equals(contrasenia)) {
                    return empleado;
                }
            }
        }
        return null;
    }

    
//    public Persona buscarPersona(String correo){
//        for (int i = 0; i < listaAerolineas.size(); i++) {
//            Aerolinea aerolinea = listaAerolineas.get(i);
//            for (int j = 0; j < aerolinea.getListaEmpleadosAerolinea().size(); j++) {
//                if(aerolinea.getListaEmpleadosAerolinea().get(j).getCorreo().equals(correo)){
//                    return aerolinea.getListaEmpleadosAerolinea().get(j);
//                }  
//            }
//        }
//        return null;  
//    }
//
//    public Persona buscarUsuarios(String correo) {
//        for (int i = 0; i < listaUsuarios.size(); i++) {
//            if (listaUsuarios.get(i).getCorreo().equals(correo)) {
//                return (Persona) listaUsuarios.get(i);
//            }
//        }
//        return null;
//    }


    public Persona crearAdministradorGeneral() {
        Persona persona = new Persona("1095550822","Jhon" , "Cano", 18, "Masculino", "313882", "admin", "123", "Administrador General"); 
        return persona;
    }   
}
