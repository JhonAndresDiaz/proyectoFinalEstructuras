
package Singleton;

import Modelos.Aerolinea;
import Modelos.Usuario;
import Util.LSE;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Singleton {
    
    private static Singleton INSTANCIA = new Singleton();
    
    LSE<Aerolinea> listaAerolineas;
    LSE<Usuario> listaUsuarios;
    
    private Singleton(){
        listaAerolineas = leerAerolineas();  
        listaUsuarios = leerUsuarios();
    }
    
    public static Singleton getInstancia(){
        return INSTANCIA;
    } 
    
    public LSE<Aerolinea> getAerolineas(){
        return listaAerolineas;
    }
    
    public void setListaAerolineas(LSE<Aerolinea> listaAerolineas) {
        this.listaAerolineas = listaAerolineas;
    }
    
    public LSE<Usuario> getUsuarios(){
        return listaUsuarios;
    }
     
    public void setListaUsuarios(LSE<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public void escribirAerolineas(){
        try {
            FileOutputStream archivo = new FileOutputStream("src/Singleton/Aerolineas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(listaAerolineas); 
        } catch(IOException ex){
        }
    } 
    
    public LSE<Aerolinea> leerAerolineas(){
        try {
            FileInputStream archivo = new FileInputStream("src/Singleton/Aerolineas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (LSE<Aerolinea>) lector.readObject();
        } catch(IOException | ClassNotFoundException ex){
            return new LSE<>();
        }
    }
    
    public void escribirUsuarios(){
        try {
            FileOutputStream archivo = new FileOutputStream("src/Singleton/Usuarios.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(listaUsuarios); 
        } catch(IOException ex){  
        }
    } 
    
    public LSE<Usuario> leerUsuarios(){
        try {
            FileInputStream archivo = new FileInputStream("src/Singleton/Usuarios.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (LSE<Usuario>) lector.readObject();
        } catch(IOException | ClassNotFoundException ex){
            return new LSE<>();
        }
    }
}
