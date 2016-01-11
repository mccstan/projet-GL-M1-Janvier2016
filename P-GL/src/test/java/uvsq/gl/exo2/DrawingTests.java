/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvsq.gl.exo2;

import java.awt.Color;
import java.util.Collection;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uvsq.gl.exo2.DAO.CanvasDAO;
import uvsq.gl.exo2.Entities.Abstract2DShape;
import uvsq.gl.exo2.Entities.CircleDessin;
import uvsq.gl.exo2.Entities.DrawingCanvas;
import uvsq.gl.exo2.Entities.RectangleDessin;
import uvsq.gl.exo2.Entities.SquareDessin;
import uvsq.gl.exo2.utils.ShapesUtil;

/**
 *
 * @author mccstan
 */
public class DrawingTests {
        RectangleDessin rectangle;
        SquareDessin carree;
        CircleDessin cercle;
        DrawingCanvas panneau;
    public DrawingTests() {


        rectangle=new RectangleDessin.Builder()
                .width(356)
                .height(213)
                .position(100, 100)
                .build();
        rectangle.setRGBFillColor(0, 255, 0);
        carree=new SquareDessin.Builder()
                .position(500, 100)
                .side(402)
                .build();
        carree.setRGBFillColor(255, 255, 255);
        cercle=new CircleDessin.Builder()
                .center(1050, 100)
                .radius(500)
                .build();
        cercle.setRGBFillColor(255, 0, 0);
        Collection<Abstract2DShape> shapes =new LinkedList<>();
        shapes.add(rectangle);
        shapes.add(carree);
        shapes.add(cercle);
        panneau=new DrawingCanvas.Builder()
                .canvasName("Dessin de test")
                .Shapes(shapes)
                .build();
        panneau.setRGBFillColor(105, 105, 105);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Teste si la définition RGB de la couleur est éffective
     * exemple du rectangle
     */
    @Test
    public void TestDefinirCouleurRGB(){
        Color c=rectangle.getFillColor();
        rectangle.setRGBFillColor(0, 0, 0);
        assertNotEquals(c.getRGB(), rectangle.getFillColor().getRGB());
    }

     /**
     * Teste si la définition HSB de la couleur est éffective
     * exemple du rectangle
     */
    @Test
    public void TestDefinirCouleurHSB(){
        Color c=rectangle.getFillColor();
        rectangle.setHSBFillColor(0.5f, 0.2f, 0.9f);
        assertNotEquals(c.getRGB(), rectangle.getFillColor().getRGB());
    }
    
    /**
     * Teste si la modification du coté d'un carré est éffectif
     */
    @Test
    public void TestModifierCoteCarre(){
        int cote=carree.getSide();
        carree.setSide(0);
        assertNotEquals(cote, carree.getSide());
    }
    
    @Test
    public void TestModifierPositionCercle(){
        int abs=cercle.getCenter().x;
        int ord=cercle.getCenter().y;
        cercle.setCenter(0, 0);
        assertNotEquals(abs, cercle.getCenter().x);
        assertNotEquals(ord, cercle.getCenter().y);
    }
    
    /**
     * Teste si la pallette n'est pas vide
     */
    @Test
    public void TestPalleteDessinTaille(){
        assertFalse(panneau.getAbstract2DShapes().isEmpty());
    }
    
    /**
     *  Teste si le calcul de l'aire est correct
     */
    @Test
    public void TestCalculAire(){
        ShapesUtil util=new ShapesUtil();
        double aireCercle=Math.pow(cercle.getRadius(), 2)*Math.PI;
        double aireRectangle=rectangle.getWidth()*rectangle.getHeight();
        double aireCarree=Math.pow(carree.getSide(), 2);
        assertEquals(aireRectangle, rectangle.computeSurface(util), Double.POSITIVE_INFINITY);
        assertEquals(aireCarree, carree.computeSurface(util), Double.POSITIVE_INFINITY);
        assertEquals(aireCercle, cercle.computeSurface(util), Double.POSITIVE_INFINITY);
        
    }
    
    /**
     * Teste si la pallette contient les formes qui lui on été ajoutés à l'initialisation
     * Nous créons une nouvelle forme, un cercle et nous vérifions qu'il n'est pas sur la pallette
     */
    @Test
    public  void TestPalletteDessinContenance(){
        assertTrue(panneau.getAbstract2DShapes().contains(carree));
        assertTrue(panneau.getAbstract2DShapes().contains(cercle));
        assertTrue(panneau.getAbstract2DShapes().contains(rectangle));
        CircleDessin unNouveauCercle=new CircleDessin.Builder()
                .build();
        assertFalse(panneau.getAbstract2DShapes().contains(unNouveauCercle));
    }
    
    @Test
    public void TestPersistance(){
        CanvasDAO canvasDAO=new CanvasDAO();
        canvasDAO.create(panneau);
    }
    
    
}
