package Modelos;

import java.io.Serializable;

/**
 *
 * @author diaza
 */
public class GestorMantenimiento extends Persona implements Serializable {

    private String especialidad;
    private String certificaciones;
    private String ciudadResidencia;

    public GestorMantenimiento(String especialidad, String certificaciones, String ciudadResidencia, String identificacion, String nombres, String apellidos, int edad, String genero, String numTelefono, String correo, String contrasenia, String rol) {
        super(identificacion, nombres, apellidos, edad, genero, numTelefono, correo, contrasenia, rol);
        this.especialidad = especialidad;
        this.certificaciones = certificaciones;
        this.ciudadResidencia = ciudadResidencia;
    }

    public GestorMantenimiento(String identificacion, String nombres, String apellidos, int edad, String genero, String numTelefono, String correo, String contrasenia, String rol) {
        super(identificacion, nombres, apellidos, edad, genero, numTelefono, correo, contrasenia, rol);
    }
    
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }  
    
//    private void actualizarTablaUno(Aerolinea aerolinea){
//        LSE<Vuelo> vuelos = controlador.obtenerVuelosUnaAerolinea(aerolinea.getCodigoAerolinea());
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i); 
//                Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                modelo.addRow(ob);                    
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizarTablaTodos(){
//        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i); 
//                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
//                Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(),  aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                modelo.addRow(ob);                    
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizarTabla3Radio(String origen, String destino, LocalDate fecha){
//        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i); 
//                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
//                if(aux.getFechaVuelo().equals(fecha) && aux.getOrigen().equals(origen) && aux.getDestino().equals(destino)){
//                    Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                    modelo.addRow(ob); 
//                }                   
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizarTabla3FiltroAerolinea(Aerolinea aerolinea, String origen, String destino, LocalDate fecha){
//        LSE<Vuelo> vuelos = controlador.obtenerVuelosUnaAerolinea(aerolinea.getCodigoAerolinea());
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i); 
//                if(aux.getFechaVuelo().equals(fecha) && aux.getOrigen().equals(origen) && aux.getDestino().equals(destino)){
//                    Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                    modelo.addRow(ob); 
//                }                   
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizarTablaDesIni(String origen, String destino){
//        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i); 
//                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
//                if(aux.getOrigen().equals(origen) && aux.getDestino().equals(destino)){
//                    Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                    modelo.addRow(ob);   
//                }                     
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizarTablaDesIniUnaAerolinea(Aerolinea aerolinea, String origen, String destino){
//        LSE<Vuelo> vuelos = controlador.obtenerVuelosUnaAerolinea(aerolinea.getCodigoAerolinea());
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i); 
//                if(aux.getOrigen().equals(origen) && aux.getDestino().equals(destino)){
//                    Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                    modelo.addRow(ob);   
//                }                     
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizarTablaFechaOri(String origen, LocalDate fecha){
//        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i); 
//                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
//                if(aux.getFechaVuelo().equals(fecha) && aux.getOrigen().equals(origen)){
//                    Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                    modelo.addRow(ob);    
//                }                  
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizarTablaFechaOriUnaAerolinea(Aerolinea aerolinea, String origen, LocalDate fecha){
//        LSE<Vuelo> vuelos = controlador.obtenerVuelosUnaAerolinea(aerolinea.getCodigoAerolinea());
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i); 
//                if(aux.getFechaVuelo().equals(fecha) && aux.getOrigen().equals(origen)){
//                    Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                    modelo.addRow(ob);    
//                }                  
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizarTablaFechaDestino(String destino, LocalDate fecha){
//        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i); 
//                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
//                if(aux.getFechaVuelo().equals(fecha) && aux.getDestino().equals(destino)){
//                    Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                    modelo.addRow(ob);    
//                }                   
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizarTablaFechaDestinoUnaAerolinea(Aerolinea aerolinea, String destino, LocalDate fecha){
//        LSE<Vuelo> vuelos = controlador.obtenerVuelosUnaAerolinea(aerolinea.getCodigoAerolinea());
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i); 
//                if(aux.getFechaVuelo().equals(fecha) && aux.getDestino().equals(destino)){
//                    Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                    modelo.addRow(ob);    
//                }                   
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizaFecha(LocalDate fecha){
//        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i); 
//                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
//                if(aux.getFechaVuelo().equals(fecha)){
//                   Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                    modelo.addRow(ob);    
//                }                                
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizaFechaUnaAero(Aerolinea aerolinea, LocalDate fecha){
//        LSE<Vuelo> vuelos = controlador.obtenerVuelosUnaAerolinea(aerolinea.getCodigoAerolinea());
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i); 
//                if(aux.getFechaVuelo().equals(fecha)){
//                   Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                    modelo.addRow(ob);    
//                }                                
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizaOrigen(String origen){
//        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i);
//                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
//                if(aux.getOrigen().equals(origen)){
//                  Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                    modelo.addRow(ob);    
//                }                               
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizaOrigenUnaAerolinea(Aerolinea aerolinea, String origen){
//        LSE<Vuelo> vuelos = controlador.obtenerVuelosUnaAerolinea(aerolinea.getCodigoAerolinea());
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i);
//                if(aux.getOrigen().equals(origen)){
//                  Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                    modelo.addRow(ob);    
//                }                               
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizaDestino(String destino){
//        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i); 
//                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
//                if(aux.getDestino().equals(destino)){
//                    Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                    modelo.addRow(ob);   
//                }                       
//            }
//        }catch(NullPointerException e){        
//        }
//    }
//    
//    private void actualizaDestinoUnaAerolinea(Aerolinea aerolinea, String destino){
//        LSE<Vuelo> vuelos = controlador.obtenerVuelosUnaAerolinea(aerolinea.getCodigoAerolinea());
//        try{
//            for (int i = 0; i < 3 ; i++) {
//                for (int j = 0; j < modelo.getRowCount(); j++) {
//                    modelo.removeRow(j);
//                }   
//            }
//        }catch(NullPointerException e){
//        }
//        try{
//            for (int i = 0; i < vuelos.size() ; i++) {
//                Vuelo aux = vuelos.get(i); 
//                if(aux.getDestino().equals(destino)){
//                    Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
//                    modelo.addRow(ob);   
//                }                       
//            }
//        }catch(NullPointerException e){        
//        }
//    }
}
