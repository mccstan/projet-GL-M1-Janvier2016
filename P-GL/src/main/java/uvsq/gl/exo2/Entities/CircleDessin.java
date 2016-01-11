/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.Entities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import uvsq.gl.exo2.utils.InterfaceVisitable;
import uvsq.gl.exo2.utils.InterfaceVisitor;

/**
 * Cette classe est un implémentation particulière de Abstract2DShape
 * Il s'agit d'un cercle
 * @author mccstan
 */
@Entity
@DiscriminatorValue("CD")
public class CircleDessin extends Abstract2DShape implements Serializable, InterfaceVisitable{
    private int radius;

    public CircleDessin() {
    }

    @Override
    public void draw(Graphics g) {
        Color gColor=g.getColor();
        g.setColor(this.getFillColor());
        g.fillOval(position.x-radius/2, position.y-radius/2, radius, radius);
        g.setColor(gColor);
        g.drawOval(position.x-radius/2, position.y-radius/2, radius, radius);


    }

    @Override
    public Rectangle getRectangularRepresenting() {
        return rectangularRepresenting;
    }

    @Override
    public double computeSurface(InterfaceVisitor visitor) {
        return visitor.visit(this);
    }

    /**
     * Class Builder, Implémentation du template BUILDER
     *@author mccstan
     */
    public static class Builder
    {
        private Point center=new Point();
        private int radius=1;
        
        public Builder center(int abs, int ord)
        {
            this.center.setLocation(abs, ord);
            return this;
        }
        public Builder radius(int radius)
        {
            this.radius=radius;
            return this;
        }
        
        public CircleDessin build()
        {
            return new CircleDessin(this);
        }
    }
    
    public CircleDessin(Builder builder)
    {
        this.position=builder.center;
        this.radius=builder.radius;
        rectangularRepresenting=new Rectangle(position, new Dimension(radius, radius));
    }
    
    /**
     * Obtenir le centre du cercle
     * @return retourne le centre du cercle qui represente sa position
     */
    public Point getCenter() {
        return getPosition();
    }

    /**
     * Définir le centre d'un cercle
     * @param abs abscisse du centre
     * @param ord ordonnée du centre
     */
    public void setCenter(int abs, int ord){
        setPosition(abs, ord);
    }

    /**
     * Retourne le rayon du cercle
     * @return retourne le rayon du cercle
     */
    public int getRadius() {
        return radius;
    }

    /**
     *  Définir le rayon du cercle
     * @param radius rayon du cercle
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }  

    public DrawingCanvas getdCanvas() {
        return dCanvas;
    }

    public void setdCanvas(DrawingCanvas dCanvas) {
        this.dCanvas = dCanvas;
    }
    
}




