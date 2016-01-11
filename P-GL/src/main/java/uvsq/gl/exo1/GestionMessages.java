/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo1;

import uvsq.gl.exo1.Filtres.Filtre;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Gestionnaire de messages
 * Ajoute de nouveaux messages
 * Supprime les message selon le filtre
 * Affiche les messages selon un filtre
 * @author mccstan
 */
public class GestionMessages {
    public GestionMessages(){
        messagesEntrant=new ArrayList<>();
    }
    private ArrayList<Message> messagesEntrant;

    /**
     * Affiche les messages selon un filtre spécifique
     * @param filtre
     */
    public void  afficherMessages(Filtre filtre){
        List<Message> messages=filtre.resultFiltre(messagesEntrant);
        messages.stream().forEach((_item) -> {
            System.out.println("Message :"+_item.getContenu()+"\n");
        });
        
    }
    
    /**
     *  Syupprime des messages selon un filtre spécifique
     * @param filtre
     */
    public void supprimerMessages(Filtre filtre){
        messagesEntrant.removeAll(filtre.resultFiltre(messagesEntrant));
    }
    
    /**
     *  Retourne la liste des messages entrant
     * @return
     */
    public ArrayList<Message> getMessagesEntrant() {
        return messagesEntrant;
    }

    /**
     *  Définir la liste des messages entrant
     * @param messagesEntrant
     */
    public void setMessagesEntrant(ArrayList<Message> messagesEntrant) {
        this.messagesEntrant = messagesEntrant;
    }
    
    /**
     *  Ajouter un nouveau message à la liste
     * @param message
     */
    public void addMessage(Message message){
        messagesEntrant.add(message);
    }
    
    public void addMessage(Message... message){
        messagesEntrant.addAll(Arrays.asList(message));
    }
    
    
}
