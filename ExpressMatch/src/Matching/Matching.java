/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Matching;

import MathExpression.Data.DMathExpression;

/**
 * Interface that defines the matching expressions functionality
 * @author frank
 */
public interface Matching {
    /**
     * Calculates the matching betwen two instances of DMathExpression class
     * @param dExpression1 mathematical expression (instance of DMathExpression)
     * @param dExpression2  mathematical expression (instance of DMathExpression)
     * @return A String matrix of dimension nx2. Where each line i representas a matching
     * of a symbol of dExpression1(symbol indicated by the element at possition (i,0) 
     * in the matrix) with other of dExpression2 (symbol indicated by the element 
     * at possition (i,1) in the matrix)
     */
    public String[][] match(DMathExpression dExpression1,DMathExpression dExpression2);
}
