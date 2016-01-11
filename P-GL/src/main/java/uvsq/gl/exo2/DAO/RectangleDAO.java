/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import uvsq.gl.exo2.Entities.RectangleDessin;

/**
 * Cette classe est l'implémentation concrète du DAO/JPA pour le rectangle
 * @author mccstan
 */
public class RectangleDAO  extends DAOEclipseLinkORM<RectangleDessin>{
    @PersistenceContext(unitName = "DessinPU")
    private EntityManager em;
    
    public RectangleDAO(){
        super(RectangleDessin.class);
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
