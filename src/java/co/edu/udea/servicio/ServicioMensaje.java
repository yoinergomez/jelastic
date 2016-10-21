/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.servicio;

import co.edu.udea.modelo.Mensaje;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yoiner Esteban Gomez Ayala yoiner.gomez22@gmail.com
 */
@Stateless
public class ServicioMensaje {

    @PersistenceContext(unitName = "jelasticPU")
    private EntityManager em;

    public void crear(Mensaje mensaje) {
        em.persist(mensaje);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<Mensaje> getMensajes(){
        //La consulta NO ES SQL
        return em.createQuery("select m from Mensaje m",Mensaje.class).getResultList();
    }
    
    
}
