/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.ShapesMain;

import java.awt.Color;
import java.awt.Point;

/**
 * Cette interface représente la forme la plus abstraite d'un forme géométrique
 * Elle propose le comportement basique de toute forme géométrique
 * @author mccstan
 */
public interface InterfaceShape {

    /**
     *
     * @return Retourne la position de la forme
     */
    public Point getPosition();
    
    /**
     *
     * @return la couleur de remplissage de la forme
     */
    public Color getFillColor();   
    
    /**
     *  Défini la position de la forme
     * @param abs l'abscisse de la position
     * @param ord l'ordonnée de la position
     */
    public void setPosition(int abs, int ord);
    
    /** 
     * Définir la couleur de remplissage en RGB
    * @param r couleur rouge entre 0-255 
    * @param g couleur verte entre 0-255 
    * @param b couleur bleu entre 0-255   
    */
    public void setRGBFillColor(int r, int g, int b);
    
    /**
    * Définir la couleur de remplissage en HSB
    * @param h Hue - Couleur actuelle décimal entre 0 et 1 
    * @param s Saturation décimal entre 0 et 1 
    * @param b Brigthness décimal entre 0 et 1 
    */
    public void setHSBFillColor(float h, float s, float b);
}
