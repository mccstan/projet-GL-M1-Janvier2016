/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.Entities;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import uvsq.gl.exo2.ShapesMain.Interface2DDrawable;
import uvsq.gl.exo2.ShapesMain.InterfaceShape;

/**
 * Cette classe abstraite est une version plus spécifique de forme géométriques
 * il s'agit de l'objet de ce Projet
 * Cette classe propose des méthodes pour des formes 2D
 * Elle représente également  une entité pour la gestion de la persistance avec EclipseLink
 * Plusieurs annotations permettent la gestion de la persistance
 * @author mccstan
 *  
 */
@Entity
@Table(name="Shape")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.STRING,length=20)
@DiscriminatorValue("S")
@SequenceGenerator(name = "ShapesGen", sequenceName = "ShapeSeq", initialValue = 1)
public abstract  class Abstract2DShape implements InterfaceShape, Interface2DDrawable, Serializable{
    @Id
    @GeneratedValue
    protected int id;
    
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    @ManyToOne
    protected DrawingCanvas dCanvas;
    
    protected Point position=new Point();
    
    protected Color fillColor=Color.WHITE; //Couleur de remplissage
    
    protected Rectangle rectangularRepresenting;
    
    
    @Override
    public void setRGBFillColor(int r, int g, int b)
    {
        this.fillColor=new Color(r, g, b);
    }
    
    @Override
    public void setHSBFillColor(float h, float s, float b)
    {
        this.fillColor=Color.getHSBColor(h, s, b);
    }
    
    /**
     * Définir la couleur de remplissage en passant une couleur en paramètre
     * @param c
     */
    public void setFillColor(Color c)
    {
        this.fillColor=c;
    }
    
    @Override
    public Color getFillColor()
    {
        return fillColor;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(int abs, int ord) {
        this.position.setLocation(abs, ord);
    }
    
    /**
     *  Définir la posotion en passant un point en paramètre
     * @param p
     */
    public void setPosition(Point p){
        this.position=p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DrawingCanvas getParentId() {
        return dCanvas;
    }

    public void setParentId(DrawingCanvas dCanvas) {
        this.dCanvas = dCanvas;
    }

    @Override
    public Rectangle getRectangularRepresenting() {
        return rectangularRepresenting;
    }

    public void setRectangularRepresenting(Rectangle rectangularRepresenting) {
        this.rectangularRepresenting = rectangularRepresenting;
    }
    
}
