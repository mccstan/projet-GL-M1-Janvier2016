/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.IHM;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import uvsq.gl.exo2.Entities.DrawingCanvas;

/**
 * Cette classe est l'Ecouteur d'évènements de la pallette de dessin
 * Elle recupère tous les évènements provenant de la souris
 * @author mccstan
 */
public class DrawingCanvasMouseListener  extends MouseAdapter{
        protected DrawingCanvas canvas;

        public DrawingCanvasMouseListener(DrawingCanvas canvas) {
                super();
                this.canvas = canvas;
                canvas.addMouseListener(this);
        }

        public DrawingCanvas getDrawingCanvas() {
                return canvas;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                        leftClickAction(e);
                } else {
                        rightClickAction(e);
                }
        }


        protected void rightClickAction(MouseEvent e) {

        }

        protected void leftClickAction(MouseEvent e) {

        }
}
