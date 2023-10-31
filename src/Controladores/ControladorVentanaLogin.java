 
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

    public ControladorVentanaLogin(){
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
    }
    
    public LSE<Aerolinea> obtenerPersonas(){
        return Singleton.getInstancia().leerAerolineas();
    }
    
    public Persona buscarPersona(String correo){
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

    public Persona crearAdministradorGeneral() {
        Persona persona = new Persona("1095550822","Jhon" , "Cano", 18, "Masculino", "313882", "Admin", "123", "Administrador General"); 
        return persona;
    }   
}
