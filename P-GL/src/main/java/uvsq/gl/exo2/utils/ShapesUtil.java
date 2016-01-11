/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvsq.gl.exo2.utils;

import uvsq.gl.exo2.Entities.CircleDessin;
import uvsq.gl.exo2.Entities.RectangleDessin;
import uvsq.gl.exo2.Entities.SquareDessin;

/**
 *
 * @author mccstan
 */
public class ShapesUtil implements InterfaceVisitor{

    @Override
    public double visit(RectangleDessin rectangle) {
        return rectangle.getWidth()*rectangle.getHeight();
    }

    @Override
    public double visit(SquareDessin square) {
        return Math.pow(square.getSide(), 2);
    }

    @Override
    public double visit(CircleDessin circle) {
        return Math.PI*Math.pow(circle.getRadius(), 2);
    }
    
}
