/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo1.Filtres;

import java.util.ArrayList;
import java.util.List;
import uvsq.gl.exo1.Message;
import uvsq.gl.exo1.MessageType;

/**
 *
 * @author mccstan
 */
public class FiltreParType implements Filtre{
    MessageType type;
    public FiltreParType(MessageType type){
        this.type=type;
    }
    
    @Override
    public List<Message> resultFiltre(List<Message> messagesList) {
        List<Message> result=new ArrayList<>();
        messagesList.stream().filter((m) -> (m.getType().equals(type))).forEach((m) -> {
            result.add(m);
        });
        return result;
        
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }


    
    
}
