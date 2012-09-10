/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import MathExpression.Data.DMathExpression;

/**
 *
 * @author frank
 */
public class UtilLabeler {
    public static void labelSymbols(DMathExpression instance, DMathExpression model,int[][]match){
        for (int i = 0; i < match.length; i++) {
            instance.get(match[i][1]).setLabel(model.get(match[i][0]).getLabel());
        }
    }
}
