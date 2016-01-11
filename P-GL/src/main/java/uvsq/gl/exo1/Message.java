/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo1;

/**
 * Classe Message
 * @author mccstan
 */
public class Message {
    private MessageType type;
    private String contenu;

    public Message(MessageType type, String contenu) {
        this.type = type;
        this.contenu = contenu;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }


    public int getTaille() {
        return contenu.length();
    }


    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    
    
}
