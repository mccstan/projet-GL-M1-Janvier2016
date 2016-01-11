/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import uvsq.gl.exo2.Entities.CircleDessin;

/**
 * Cette classe est l'impémentation concrète du DAO/JPA pour le Cercle
 * @author mccstan
 */
public class CircleDAO extends DAOEclipseLinkORM<CircleDessin>{
    private EntityManager em;
    public CircleDAO(){
        super(CircleDessin.class);
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
