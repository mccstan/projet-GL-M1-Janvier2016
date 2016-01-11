/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo1.Filtres;

import java.util.List;
import uvsq.gl.exo1.Message;

/**
 * Cette interface représente le concept de filtre
 * Tout nouveau filtre devra juste l'implémenter.
 * @author mccstan
 */
public interface Filtre {

    /**
     *  Construit une liste de messages répondant à un critère de filtrage
     *  Les critère de base fournit sont la taille, le type, le mot clé
     *  Mais la solution respecte OCP et il est possible d'en ajouter des nouvelles
     * @param messagesList La liste de messages à filtrer
     * @return retourne le résultat du filtrage
     */
    public List<Message> resultFiltre(List<Message> messagesList);
}
