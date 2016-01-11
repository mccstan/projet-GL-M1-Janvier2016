/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.IHM;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import uvsq.gl.exo2.Entities.DrawingCanvas;

/**
 * Cette classe écoute les évènements provenant de la souris
 * sur la palette de dessin, mais ajoute la capacité d'écouter les mouvements de la souris
 * MotionListener
 * @author mccstan
 */
public class DrawingCanvasMouseAdapter  extends DrawingCanvasMouseListener implements MouseMotionListener{
    public DrawingCanvasMouseAdapter(DrawingCanvas canvas){
        super(canvas);
        canvas.addMouseMotionListener(this);
    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }


    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
