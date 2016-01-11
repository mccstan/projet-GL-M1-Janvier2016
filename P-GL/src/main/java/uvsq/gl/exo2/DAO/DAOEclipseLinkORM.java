/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.DAO;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * Cette classe abstraite est l'implémentation de l'interface DAO pour la persistance
 * dans un SGBD quelconque
 * L'implémentation JPA utilisé est EclipseLink
 * @author mccstan
 * @param <T> type de la classe concrète
 */
public abstract class DAOEclipseLinkORM<T> implements DAO<T>{
    private Class<T> entityClass;

    public DAOEclipseLinkORM(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     *  Retourne le gestionnaire d'entités pour les opérations de persisatnce
     * @return Retourne le Gestionnaire d'entités
     */
    protected abstract EntityManager getEntityManager();

    @Override
    public void create(T entity) {
        EntityManager em = null ;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(T entity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void remove(T entity) {
        EntityManager em;
        em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
    }

    @Override
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     * Retourne une liste d'éléments d'u  intervalle spécifique
     * @param range
     * @return
     */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     *  Retourne le nombre d'éléments Classe d'entités
     * @return le nombre d'éléments 
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    
}
