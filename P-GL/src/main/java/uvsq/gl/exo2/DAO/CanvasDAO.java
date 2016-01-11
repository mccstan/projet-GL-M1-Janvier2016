/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import uvsq.gl.exo2.Entities.DrawingCanvas;

/**
 * Cette classe est l'implémentation concrète du DAO/JPA pour la pallette de déssin
 * @author mccstan
 */
public class CanvasDAO extends DAOEclipseLinkORM<DrawingCanvas>{
    private EntityManager em;
    public  CanvasDAO(){
        super(DrawingCanvas.class);
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
