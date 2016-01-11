/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.DAO;

import java.util.List;

/**
 * Interface DAO du Design Pattern Data Access Object
 * @author mccstan
 * @param <T> l'objet à persister
 */
public interface DAO<T> {

    /**
     *  Insère un objet dans le système de stockage
     * @param object
     */
    public void create(T object);

    /**
     *  Modifie l'objet spécifié dans le système de stockage
     * @param object
     */
    public void edit(T object);

    /**
     *  Supprime l'objet spécifié du système de stockage
     * @param object
     */
    public void remove(T object);

    /**
     * Rechercher l'objet spécifié dans le système de stockage
     * @param id id de l'objet à trouver
     * @return l'objet recherché si il existe
     */
    public T find(Object id);

    /**
     *  Sélectionner tous les objets de type T dans le système de stockage
     * @return la liste de tous les objets de type T
     */
    public List<T> findAll();
    
}
