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
public class FiltreParTaille implements Filtre{
    private int minTaille;
    private int maxTaille;
    public FiltreParTaille(int minTaille, int maxTaille){
        this.minTaille=minTaille;
        this.maxTaille=maxTaille;
    }

    public int getMinTaille() {
        return minTaille;
    }

    public void setMinTaille(int minTaille) {
        this.minTaille = minTaille;
    }

    public int getMaxTaille() {
        return maxTaille;
    }

    public void setMaxTaille(int maxTaille) {
        this.maxTaille = maxTaille;
    }

    @Override
    public List<Message> resultFiltre(List<Message> messagesList) {
        List<Message> result=new ArrayList<>();
        messagesList.stream().filter((m) -> (m.getTaille()>=minTaille && m.getTaille()<=maxTaille)).forEach((m) -> {
            result.add(m);
        });
        return result;
    }
    
}
