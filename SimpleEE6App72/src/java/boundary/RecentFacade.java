/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;


import entities.Recent;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nb
 */
@Stateless
public class RecentFacade extends AbstractFacade<Recent> {
    @PersistenceContext(unitName = "SimpleEE6AppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecentFacade() {
        super(Recent.class);
    }
    
}
