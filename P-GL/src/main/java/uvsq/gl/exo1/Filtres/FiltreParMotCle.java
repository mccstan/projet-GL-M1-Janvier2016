/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo1.Filtres;

import java.util.ArrayList;
import java.util.List;
import uvsq.gl.exo1.Message;

/**
 *
 * @author mccstan
 */
public class FiltreParMotCle implements Filtre{
    String motCle;
    
    public FiltreParMotCle(String motCle){
        this.motCle=motCle;
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    @Override
    public List<Message> resultFiltre(List<Message> messagesList) {
        List<Message> result=new ArrayList<>();
        messagesList.stream().filter((m) -> (m.getContenu().contains(motCle))).forEach((m) -> {
            result.add(m);
        });
        return result;
    }
    
}
