package Controladores;

import Modelos.Aerolinea;
import Modelos.Avion;
import Singleton.Singleton;
import Util.LSE;
import javax.swing.JOptionPane;

/**
 *
 * @author diaza
 */
public class ControladorVentanaGestionAviones {
    
    private LSE<Aerolinea> listaAerolineas;
    
    public ControladorVentanaGestionAviones() {
        this.listaAerolineas = Singleton.getInstancia().getAerolineas();
    }

    public Avion buscarNumeroAvion(int numero){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            Aerolinea aerolinea = listaAerolineas.get(i);
            for (int j = 0; j < aerolinea.getListaAviones().size(); j++) {
                Avion avion = aerolinea.getListaAviones().get(j);
                if(avion.getNumero() == numero){
                    return avion;
                }   
            }
        }
        return null;    
    }
    
    public Aerolinea buscarAerolineaCodigo(int codigo){
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if(listaAerolineas.get(i).getCodigoAerolinea() == codigo){
                return listaAerolineas.get(i);
            }  
        }
        return null;    
    }
   
    public void guardarAvion(int codigo, Avion avion) {
        
        Avion avionBuscado = buscarNumeroAvion(avion.getNumero());
        
        if(avionBuscado == null){
            for (int i = 0;  i < listaAerolineas.size(); i++) {
                if(listaAerolineas.get(i).getCodigoAerolinea()==codigo){
                    listaAerolineas.get(i).getListaAviones().add(avion);
                    Singleton.getInstancia().escribirAerolineas();
                    System.out.println(listaAerolineas.get(i).getNombreAerolinea());
                } 
            }
        }else{
            JOptionPane.showMessageDialog(null, "aaaaaaaaaaaa");
        }
    }  
}
