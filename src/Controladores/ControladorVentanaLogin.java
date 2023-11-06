 
package Controladores;

import Modelos.*;
import Singleton.Singleton;
import Util.LSE;
import java.time.LocalDate;
import java.time.LocalTime;

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

    public Persona crearAdministradorGeneral() {
        Persona persona = new Persona("1095550822","Jhon" , "Cano", 18, "Masculino", "313882", "admin", "123", "Administrador General"); 
        return persona;
    }   
    
    public void actualizarVuelos() {
        LocalDate hoy = LocalDate.now();
        LocalTime horaActual = LocalTime.now();

        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);

            for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                Avion avion = aerolinea.getListaAviones().get(j);

                for (int k = 0; k < avion.getCronograma().size(); k++) {
                    Vuelo vuelo = avion.getCronograma().get(k);
                    
                    if (vuelo.getEstado().equals("Programado")) {
                        if (vuelo.getFechaVuelo().isBefore(hoy)) {
                            vuelo.setEstado("Finalizado");
                        }else if (vuelo.getFechaVuelo().equals(hoy) && vuelo.getDiaFinVuelo().equals(hoy)) {
                            if (horaActual.isAfter(vuelo.getTiempoFin())) {
                                if (avion.getUbicacion() == null || !avion.getUbicacion().equals(vuelo.getOrigen())) {
                                    vuelo.setEstado("Finalizado");
                                } else {
                                    vuelo.setEstado("Finalizado");
                                    avion.setUbicacion(vuelo.getDestino());
                                }
                            }
                        }else {
                            if(!vuelo.getFechaVuelo().equals(hoy) && vuelo.getDiaFinVuelo().equals(hoy)){
                                if(horaActual.isAfter(vuelo.getTiempoFin())){
                                    if (avion.getUbicacion() == null || !avion.getUbicacion().equals(vuelo.getOrigen())) {
                                        vuelo.setEstado("Finalizado");
                                    } else {
                                        vuelo.setEstado("Finalizado");
                                        avion.setUbicacion(vuelo.getDestino());
                                    }  
                                }
                            }
                        }
                    }
                }
            }
        }
        Singleton.getInstancia().escribirAerolineas();
    }
    
    
    
}
    
////    
////    public void actualizarVuelos() {
////        LocalDate hoy = LocalDate.now();
////        LocalTime horaActual = LocalTime.now();
////
////        for (int i = 0; i < listaAerolineas.size(); i++) {
////            Aerolinea aerolinea = listaAerolineas.get(i);
////
////            for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
////                Avion avion = aerolinea.getListaAviones().get(j);
////
////                for (int k = 0; k < avion.getCronograma().size(); k++) {
////                    Vuelo vuelo = avion.getCronograma().get(k);
////                    if (vuelo.getEstado().equals("Programado")) {
////                        if (vuelo.getFechaVuelo().isBefore(hoy)) {
////                            vuelo.setEstado("Finalizado");
////                        }else if(vuelo.getFechaVuelo().equals(hoy)) {
////                            if(horaActual.isAfter(vuelo.getTiempoFin())) {
////                                if (avion.getUbicacion() == null || !avion.getUbicacion().equals(vuelo.getOrigen())) {
////                                    vuelo.setEstado("Finalizado");
////                                }else {
////                                    vuelo.setEstado("Finalizado");
////                                    avion.setUbicacion(vuelo.getDestino());
////                                }   
////                            }
////                        }
////                    }else if(vuelo.getEstado().equals("Finalizado")){
////                        if(hoy.isBefore(vuelo.getFechaVuelo())){
////                            vuelo.setEstado("Programado");
////                        }
////                    }
////                }
////            }
////        }
////        Singleton.getInstancia().escribirAerolineas();
////    }
////
