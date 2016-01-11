/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.ShapesMain;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *Cette interface propose les fonctionalités pour dessiner une forme géométrique,
 * toute forme géométrique voulant savoir se déssiner devra l'implémenter
 * @author mccstan
 * 
 */
public interface Interface2DDrawable {

    /**
     *  Dessine la forme dans le contexte graphique g
     * @param g contexte graphique
     */
    public abstract void draw(Graphics g);

    /**
     *
     * @return Retourne un Rectangle qui est la représentation rectangulaire de la forme 
     */
    public abstract Rectangle getRectangularRepresenting();
}
