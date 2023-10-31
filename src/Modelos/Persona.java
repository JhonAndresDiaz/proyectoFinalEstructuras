package Modelos;

/**
 *
 * @author diazje
 */
public class Persona extends Usuario {
    
    protected String identificacion;
    protected String nombres;
    protected String apellidos;
    protected int edad;
    protected String genero;
    protected String numTelefono;

    public Persona(String identificacion, String nombres, String apellidos, int edad, String genero, String numTelefono, String correo, String contrasenia, String rol) {
        super(correo, contrasenia, rol);
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.genero = genero;
        this.numTelefono = numTelefono;
    }
    
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }    
}
