
package Singleton;

import Modelos.Aerolinea;
import Modelos.Persona;
import Util.LSE;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Singleton {
    
    private static Singleton INSTANCIA = new Singleton();
    
    LSE<Persona> listaPersonas;
    LSE<Aerolinea> listaAerolineas;

//        Casilla[][] casillas;
    
    private Singleton(){
        
        listaPersonas = leerPersonas();
        listaAerolineas = leerAerolineas();
//        casillas = leerCa();     
    }
    
    public static Singleton getInstancia(){
        return INSTANCIA;
    } 
    
    public LSE<Persona> getPersonas(){
        return listaPersonas ;
    }
    
    public LSE<Aerolinea> getAerolineas(){
        return listaAerolineas;
    }
    
    public void setListaPersonas(LSE<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    
    public void setListaAerolineas(LSE<Aerolinea> listaAerolineas) {
        this.listaAerolineas = listaAerolineas;
    }
    
    //    public Casilla[][] getCasillas() {
//        return casillas;
//    }
   
//    public void setCasilllas(Casilla[][] casillas) {
//        this.casillas = casillas;
//    }

//    public void escribirQuirofanos(){
//        try {
//            FileOutputStream archivo = new FileOutputStream("Quirofanos.dat");
//            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
//            escritor.writeObject(casillas); 
//        } catch(IOException ex){
//            
//        }
//    }
//    
//    
//    public Casilla[][] leerCa(){
//        try {
//            FileInputStream archivo = new FileInputStream("Quirofanos.dat");
//            ObjectInputStream lector = new ObjectInputStream(archivo);
//            return (Casilla[][]) lector.readObject();
//        } catch(IOException | ClassNotFoundException ex){
//            
//            Casilla[][] aux = new Casilla[2][5];
//            for (int i = 0; i < aux.length; i++){
//                for (int j = 0; j < aux[i].length; j++) {
//                    aux[i][j] = new Casilla();
//                }
//                
//            }
//            return aux;
//        }
//    }
    
    public void escribirPersonas(){
        try {
            FileOutputStream archivo = new FileOutputStream("src/Singleton/Personas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(listaPersonas); 
        } catch(IOException ex){
            
        }
    } 
    
    public LSE<Persona> leerPersonas(){
        try {
            FileInputStream archivo = new FileInputStream("src/Singleton/Personas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (LSE<Persona>) lector.readObject();
        } catch(IOException | ClassNotFoundException ex){
            
            return new LSE<>();
        }
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
}
