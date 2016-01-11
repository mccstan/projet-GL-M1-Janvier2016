/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvsq.gl.exo2.utils;

/**
 *
 * @author mccstan
 */
public interface InterfaceVisitable {

    /**
     *  Permet de prendre en charge un objet par un visiteur
     * @param visitor
     * @return la surface de l'objet
     */
    public double computeSurface(InterfaceVisitor visitor);
}
