/*
 *  Génie logiciel - UPSay - UVSQ - Janvier 2016
 */
package uvsq.gl.exo2.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JComponent;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import uvsq.gl.exo2.ShapesMain.InterfaceShape;

/**
 * Cette classe est la pallette de dessin qui possède les caractéristiques
 * de l'interface InterfaceShape
 * Elle étends la classe Jcomponent de Swing
 * 
 * 
 * @author mccstan
 */
@Entity
@DiscriminatorValue("DC")
public class DrawingCanvas extends JComponent implements InterfaceShape, Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    
    private String canvasName;

    @OneToMany( mappedBy = "dCanvas", cascade = CascadeType.ALL)
    private Collection<Abstract2DShape> abstract2DShapes;
        
    public DrawingCanvas() {
    }

    @Override
    public Point getPosition() {
        return this.getLocation();
    }

    @Override
    public Color getFillColor() {
        return this.getBackground();
    }

    @Override
    public void setPosition(int abs, int ord) {
        this.setLocation(abs, ord);
    }

    @Override
    public void setRGBFillColor(int r, int g, int b) {
        this.setBackground(new Color(r, g, b));
    }

    /**
     *
     * @param h
     * @param s
     * @param b
     */
    @Override
    public void setHSBFillColor(float h, float s, float b) {
        this.setBackground(Color.getHSBColor(h, s, b));
    }
    
    /**
     * Class Builder, Implémentation du template BUILDER
     *@author mccstan
     */
    public static class Builder{
        private int id;
        private String canvasName;
        private LinkedList<Abstract2DShape> abstract2DShapes;     
        
        public Builder(){
            id=0;
            canvasName="defaultName";
            abstract2DShapes=new LinkedList<>();
        }
        
        public Builder canvasName(String canvasName)
        {
            this.canvasName=canvasName;
            return this;
        }
        
        public Builder Shapes(Collection<Abstract2DShape> abstractShapes){
            this.abstract2DShapes.addAll(abstractShapes);
            return this;
        }
        
        public DrawingCanvas build(){
            return new DrawingCanvas(this);
        }
    }
    
    public DrawingCanvas(Builder builder){
        this.canvasName=builder.canvasName;
        this.abstract2DShapes=new LinkedList<>(builder.abstract2DShapes);
    }
    
    public String getCanvasName() {
        return canvasName;
    }

    public void setCanvasName(String name) {
        this.canvasName = name;
    }

    public Collection<Abstract2DShape> getShapes() {
        return abstract2DShapes;
    }

    public void setShapes(LinkedList<Abstract2DShape> shapes) {
        this.abstract2DShapes = shapes;
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (Iterator iter = abstract2DShapes.iterator(); iter.hasNext();) {
                Abstract2DShape as = (Abstract2DShape) iter.next();
                as.draw(g);
                
        }
    }
    
    public void addShape(Abstract2DShape as){
        abstract2DShapes.add(as);
        repaint();
    }
    
    public void removeShape(Abstract2DShape as){
        abstract2DShapes.remove(as);
        repaint();
    }
    
    public void clear(){
        abstract2DShapes.clear();
        repaint();
    }
    
    public List findAbstract2DShapes(Point p){
        List l=new ArrayList();
        for(Iterator iterator=abstract2DShapes.iterator(); iterator.hasNext();){
            Abstract2DShape ads=(Abstract2DShape) iterator.next();
            if(ads.getRectangularRepresenting().contains(p)){
                l.add(ads);
            }
        }
        return l;
    }
    
    public boolean isFree(Rectangle rectangle){
        for(Iterator iterator=abstract2DShapes.iterator();iterator.hasNext();){
            Abstract2DShape ads=(Abstract2DShape)iterator.next();
            if(ads.getRectangularRepresenting().intersects(rectangle)){
                return false;
            }
        }
        return true;
    }
    
    public boolean isAlone(Abstract2DShape shape){
        Rectangle rectangle=shape.getRectangularRepresenting();
        for(Iterator iterator=abstract2DShapes.iterator();iterator.hasNext();){
            Abstract2DShape ads=(Abstract2DShape)iterator.next();
            if(!ads.equals(shape) && ads.getRectangularRepresenting().intersects(rectangle)){
                return false;
            }
        }
        return true;
    }
    
    public void transformShape(Abstract2DShape as, int rotateAngle)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void transformShape(Abstract2DShape as, int translateX, int translateY)
    {
        AffineTransform transform=AffineTransform.getTranslateInstance(translateX, translateY);
        as.getPosition().translate(translateX, translateY);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Abstract2DShape> getAbstract2DShapes() {
        return abstract2DShapes;
    }

    public void setAbstract2DShapes(Collection<Abstract2DShape> abstract2DShapes) {
        this.abstract2DShapes = abstract2DShapes;
    }
    
            
}
