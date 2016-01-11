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
 * Design Pattern Visitor
 * Classe visiteur pour le calcul des aires
 * Respect de SRP
 * @author mccstan
 */
public interface InterfaceVisitor {

    /**
     *  Calcule l'aire du rectangle passé en paramètre
     * @param rectangle
     * @return L'aire du rectangle
     */
    public double visit(RectangleDessin rectangle);

    /**
     *  Calcule l'aire du carré passé en paramètre
     * @param square
     * @return L'aire du carré
     */
    public double visit(SquareDessin square);

    /**
     *  Calcule l'aire du cercle passé en paramètre
     * @param circle
     * @return L'aire du cercle
     */
    public double visit(CircleDessin circle);
}
