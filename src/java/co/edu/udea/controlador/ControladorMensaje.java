/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.controlador;

import co.edu.udea.modelo.Mensaje;
import co.edu.udea.servicio.ServicioMensaje;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Yoiner Esteban Gomez Ayala yoiner.gomez22@gmail.com
 */
@Named(value = "controladorMensaje")
@RequestScoped
public class ControladorMensaje {

    private Mensaje mensaje = new Mensaje();

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }
    
    @Inject ServicioMensaje servicio;
    public List<Mensaje> getMensajes(){
        return servicio.getMensajes();
    }
    
    public String guardar(){
        if(mensaje==null){
            System.out.println("mensaje es NULL");
        }
        System.out.println("@@@ "+mensaje.getAutor());
        System.out.println("@@@ "+mensaje.getContenido());
        System.out.println("@@@ "+mensaje.getTitulo());
        servicio.crear(mensaje);
        return "/index";
    }
    
    /**
     * Creates a new instance of ControladorMensaje
     */
    public ControladorMensaje() {
    }
    
}
