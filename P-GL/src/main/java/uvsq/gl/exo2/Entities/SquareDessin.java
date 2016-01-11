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
 * Il s'agit d'un carré
 * @author mccstan
 */
@Entity
@DiscriminatorValue("SD")
public class SquareDessin  extends Abstract2DShape implements Serializable, InterfaceVisitable{
    private int side;
    public SquareDessin() {
    }

    @Override
    public void draw(Graphics g) {
        Color gColor=g.getColor();
        g.setColor(this.getFillColor());
        g.fillRect(position.x,position.y, side, side);
        g.setColor(gColor);
        g.drawRect(position.x,position.y, side, side);
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
        private  Point position=new Point();
        private int side=1; 
        
        public Builder position(int abs, int ord)
        {
            this.position=new Point(abs, ord);
            return this;
        }
        public Builder side(int side)
        {
            this.side=side;
            return this;
        }
        public SquareDessin build()
        {
            return new SquareDessin(this);
        }
    }
    
    public SquareDessin(Builder builder)
    {
        super.setPosition(builder.position.x, builder.position.y);
        this.side=builder.side;
        rectangularRepresenting=new Rectangle(position, new Dimension(side, side));
    }

    /**
     *  Retourne le coté du carré
     * @return le coté du carré
     */
    public int getSide() {
        return side;
    }

    /**
     *  Définir le coté du carré
     * @param side le coté du carré
     */
    public void setSide(int side) {
        this.side = side;
    }

    public DrawingCanvas getdCanvas() {
        return dCanvas;
    }

    public void setdCanvas(DrawingCanvas dCanvas) {
        this.dCanvas = dCanvas;
    }
    
    
}
