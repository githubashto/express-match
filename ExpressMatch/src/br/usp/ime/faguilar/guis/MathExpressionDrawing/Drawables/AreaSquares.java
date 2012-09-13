/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.usp.ime.faguilar.guis.MathExpressionDrawing.Drawables;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author frank
 */
public class AreaSquares {
    private int squaresDimension=40;

    private static final Color COLOR_OF_LINE_OF_SQUARES=new Color(255,204,153);//new Color(255,204,102);

    public int getSquaresDimension() {
        return squaresDimension;
    }

    public void setSquaresDimension(int squaresDimension) {
        this.squaresDimension = squaresDimension;
    }

    public void drawSquares(Graphics g, Dimension d){
        Color tempColor=g.getColor();
        g.setColor(COLOR_OF_LINE_OF_SQUARES);
        int numberOfHorizontalLines=d.height/squaresDimension;
        int numberOfVerticalLines=d.width/squaresDimension;
        for (int i = 0; i < numberOfHorizontalLines; i++) {
            g.drawLine(0, (i+1)*squaresDimension, d.width, (i+1)*squaresDimension);
        }
        for (int i = 0; i < numberOfVerticalLines; i++) {
            g.drawLine((i+1)*squaresDimension,0, (i+1)*squaresDimension, d.height);
        }
        g.drawRoundRect(0,0,d.width-2,d.height-2, 10, 10);
        g.setColor(tempColor);
    }
}
