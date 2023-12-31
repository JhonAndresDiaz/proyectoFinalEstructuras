
package Modelos;

import Util.LSE;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author diaza
 */
public class Mantenimiento implements Serializable{
    
    private int num;
    private String motivo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Avion avion;
    private String estado;
    private Chat chat;

    public Mantenimiento(int num, String motivo, LocalDate fechaInicio, Avion avion, String estado) {
        this.num = num;
        this.motivo = motivo;
        this.fechaInicio = fechaInicio;
        this.avion = avion;
        this.estado = estado;
    }

    public Mantenimiento(int num, String motivo, LocalDate fechaInicio, LocalDate fechaFin, Avion avion, String estado) {
        this.num = num;
        this.motivo = motivo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.avion = avion;
        this.estado = estado;
        this.chat = new Chat();
    }
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Avion getAvion() {
        return avion;
    }
    
    public Chat getChat() {
        return chat;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LSE<String> obtenerMensajesChat() {
        if (chat == null) {
            chat = new Chat();
        }
        return chat.getMensajes();
    }

    public void enviarMensajeAlChat(String mensaje) {
        if (chat == null) {
            chat = new Chat();
        }
        chat.enviarMensaje(mensaje);
    }
}
