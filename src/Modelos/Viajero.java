package Modelos;

import Util.LSE;
import java.io.Serializable;

/**
 *
 * @author diazje
 */
public class Viajero extends Persona implements Serializable {
     
    private String paisNacimiento;
    private LSE<Vuelo> historialVuelos;
    private LSE<Reserva> historialReservas;

    public Viajero(String paisNacimiento, LSE<Vuelo> historialVuelos, LSE<Reserva> historialReservas, String identificacion, String nombres, String apellidos, int edad, String genero, String numTelefono, String correo, String contrasenia, String rol) {
        super(identificacion, nombres, apellidos, edad, genero, numTelefono, correo, contrasenia, rol);
        this.paisNacimiento = paisNacimiento;
        this.historialVuelos = historialVuelos;
        this.historialReservas = historialReservas;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public LSE<Vuelo> getHistorialVuelos() {
        return historialVuelos;
    }

    public void setHistorialVuelos(LSE<Vuelo> historialVuelos) {
        this.historialVuelos = historialVuelos;
    }

    public LSE<Reserva> getHistorialReservas() {
        return historialReservas;
    }

    public void setHistorialReservas(LSE<Reserva> historialReservas) {
        this.historialReservas = historialReservas;
    }
}
