package Modelos;

import Util.LSE;
import java.io.Serializable;

/**
 *
 * @author diaza
 */
public class Chat implements Serializable {
    
    private LSE<String> mensajes;

    public Chat() {
        this.mensajes = new LSE<>();
    }

    public LSE<String> getMensajes() {
        return mensajes;
    }

    public void enviarMensaje(String mensaje) {
        mensajes.add("Emisor: " + mensaje);
    }

    public void recibirMensaje(String mensaje) {
        mensajes.add("Receptor: " + mensaje);
    }  
}
