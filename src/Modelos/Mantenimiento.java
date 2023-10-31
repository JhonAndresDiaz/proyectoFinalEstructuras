
package Modelos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author cduar
 */
public class Mantenimiento implements Serializable{
    
    private String motivo;
    private LocalDate fecha ;
    private LocalDate fechaFin;
    private Avion avion;
    private boolean activo ;

    public Mantenimiento(String motivo, LocalDate fecha, LocalDate fechaFin, Avion avion, boolean activo) {
        this.motivo = motivo;
        this.fecha = fecha;
        this.fechaFin = fechaFin;
        this.avion = avion;
        this.activo = activo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
