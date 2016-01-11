/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvsq.gl.exo2;

import uvsq.gl.exo2.Entities.SquareDessin;
import uvsq.gl.exo2.Entities.Abstract2DShape;
import uvsq.gl.exo2.Entities.DrawingCanvas;
import uvsq.gl.exo2.Entities.CircleDessin;
import uvsq.gl.exo2.Entities.RectangleDessin;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import uvsq.gl.exo2.DAO.CanvasDAO;
import uvsq.gl.exo2.DAO.CircleDAO;

/**
 *
 * @author mccstan
 */
public class DrawingApp {
    public static void main(String argv[]){
        RectangleDessin rd=new RectangleDessin.Builder()
                .width(100)
                .height(50)
                .position(50, 100)
                .build();
        rd.setRGBFillColor(255, 0, 0);
        SquareDessin sd=new SquareDessin.Builder()
                .position(300, 100)
                .side(100)
                .build();
        sd.setRGBFillColor(255, 0, 0);
        CircleDessin cd=new CircleDessin.Builder()
                .center(500, 100)
                .radius(150)
                .build();
        
        cd.setRGBFillColor(0, 255, 0);
        Collection<Abstract2DShape> shapes =new LinkedList<>();
        shapes.add(rd);
        shapes.add(sd);
        shapes.add(cd);
        DrawingCanvas dc=new DrawingCanvas.Builder()
                .canvasName("Dessin de figures")
                .Shapes(shapes)
                .build();
        
        CircleDAO aO=new CircleDAO();
        System.out.println(aO.findAll());
    }
    
}
