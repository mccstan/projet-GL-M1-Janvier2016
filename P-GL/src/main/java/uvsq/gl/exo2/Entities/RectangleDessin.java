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
 * Il s'agit d'un rectangle
 * @author mccstan
 */

@Entity
@DiscriminatorValue("RD")
public class RectangleDessin extends Abstract2DShape implements Serializable, InterfaceVisitable{
    private int width;
    private int height;

    public RectangleDessin() {
    }

    @Override
    public void draw(Graphics g) {
        Color gColor=g.getColor();
        g.setColor(this.getFillColor());
        g.fillRect(position.x,position.y, width, height);
        g.setColor(gColor);
        g.drawRect(position.x,position.y, width, height);
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
        Point position=new Point();
        private int width=1;
        private int height=1;
        
        public Builder position(int abs, int ord)
        {
            this.position=new Point(abs, ord);
            return this;
        }
        public Builder width(int width)
        {
            this.width=width;
            return this;
        }
        
        public Builder height(int height)
        {
            this.height=height;
            return this;
        }
        
        public RectangleDessin build()
        {
            return new RectangleDessin(this);
        }
    }
    private RectangleDessin(Builder builder)
    {
        this.setPosition(builder.position.x, builder.position.y);
        this.width=builder.width;
        this.height=builder.height;
        rectangularRepresenting=new Rectangle(position, new Dimension(width, height));
    }

    /**
     * Retourne la longueur du rectangle
     * @return la longueur du rectangle
     */
    public int getWidth() {
        return width;
    }

    /**
     *  définir la longueur du rectangle
     * @param width longueur
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *  Retourne la largeur du rectangle
     * @return la largeur du rectangle
     */
    public int getHeight() {
        return height;
    }

    /**
     *  définir la largeur du rectangle
     * @param height largeur du rectangle
     */
    public void setHeight(int height) {
        this.height = height;
    }

    public DrawingCanvas getdCanvas() {
        return dCanvas;
    }

    public void setdCanvas(DrawingCanvas dCanvas) {
        this.dCanvas = dCanvas;
    }
    
}
