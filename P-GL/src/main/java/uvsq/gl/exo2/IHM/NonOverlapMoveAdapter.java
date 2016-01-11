/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.IHM;

import java.awt.Point;
import java.awt.event.MouseEvent;
import uvsq.gl.exo2.Entities.DrawingCanvas;

/**
 * Cette classe Ecoute les évènements en provenance de la souris 
 * en y ajoutant des comportements suppémentaires pour la gestion des déplacements
 * de figures sur la pallette de dessin
 * @author mccstan
 */
public class NonOverlapMoveAdapter extends MoveDrawingCanvasMouseAdapter{
    private Point initialLocation;


    public NonOverlapMoveAdapter(DrawingCanvas canvas) {
            super(canvas);

    }


    @Override
    public void mouseReleased(MouseEvent e) {
            if(shape== null) return ;
            if( !canvas.isAlone(shape)){
                    shape.setPosition(initialLocation.x, initialLocation.y);

            }
            initialLocation =null;
            shape=null;
            canvas.repaint();
    }


    @Override
    public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if(shape!=null) {
                    initialLocation=shape.getPosition();
            }
    }
}
