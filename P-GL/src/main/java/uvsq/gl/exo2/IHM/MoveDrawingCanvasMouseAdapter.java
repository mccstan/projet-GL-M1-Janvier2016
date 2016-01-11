/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.IHM;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import uvsq.gl.exo2.Entities.Abstract2DShape;
import uvsq.gl.exo2.Entities.DrawingCanvas;

/**
 * Cette classe Ecoute les évènements de la souris mais intègre en plus 
 * des comportements supplémentaires lié à ces évènements
 * @author mccstan
 */
public class MoveDrawingCanvasMouseAdapter extends DrawingCanvasMouseAdapter{
    
    protected Abstract2DShape shape;
    public MoveDrawingCanvasMouseAdapter(DrawingCanvas canvas){
        super(canvas);
        canvas.addMouseMotionListener(this);
    }
    
    @Override
    public void mouseDragged(MouseEvent e){
        if (shape != null) {
            shape.setPosition(e.getPoint().x, e.getPoint().y);
            canvas.repaint();
        }
        
    }
    
    @Override
    public void mouseMoved(MouseEvent e){
        List selectedShapes = canvas.findAbstract2DShapes(e.getPoint());
        if (selectedShapes.isEmpty())
                return;
        shape = (Abstract2DShape)selectedShapes.get(0);
    }
}
