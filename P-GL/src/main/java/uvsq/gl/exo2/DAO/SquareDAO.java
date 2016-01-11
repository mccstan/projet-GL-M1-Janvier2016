/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import uvsq.gl.exo2.Entities.SquareDessin;

/**
 * Cette classe est l'implémentation concrète pour le carré
 * @author mccstan
 */
public class SquareDAO extends DAOEclipseLinkORM<SquareDessin>{
    @PersistenceContext(unitName = "DessinPU")
    private EntityManager em;
    
    public SquareDAO(){
        super(SquareDessin.class);
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("DessinPU");
        em=emf.createEntityManager();
    }
        
    @Override
    protected EntityManager getEntityManager() {
        if(!em.isOpen()){
            EntityManagerFactory emf=Persistence.createEntityManagerFactory("DessinPU");
            em=emf.createEntityManager();
        }
        return em;
    }
}
