
package Singleton;

import Modelos.Aerolinea;
import Modelos.Avion;
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
    Avion[][] aviones;
    
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
    
    public Avion[][] getAviones() {
        return aviones;
    }
   
    public void Aviones(Avion[][] aviones) {
        this.aviones = aviones;
    }
    
     public LSE<Usuario> getUsuarios(){
        return listaUsuarios;
    }
     
    public void setListaUsuarios(LSE<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

//    public void escribirAviones(){
//        try {
//            FileOutputStream archivo = new FileOutputStream("src/Singleton/Aviones.dat");
//            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
//            escritor.writeObject(aviones); 
//        } catch(IOException ex){
//            
//        }
//    }
//    
//    
//    public Avion[][] leerAviones(){
//        try {
//            FileInputStream archivo = new FileInputStream("src/Singleton/Aviones.dat");
//            ObjectInputStream lector = new ObjectInputStream(archivo);
//            return (Avion[][]) lector.readObject();
//        } catch(IOException | ClassNotFoundException ex){
//            
//            Avion[][] aux = new Avion[1][0];
//            for (int i = 0; i < aux.length; i++){
//                for (int j = 0; j < aux[i].length; j++) {
//                    aux[i][j] = new Avion();
//                }
//                
//            }
//            return aux;
//        }
//    }
    
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
