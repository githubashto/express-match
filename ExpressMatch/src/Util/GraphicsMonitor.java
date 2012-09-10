/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 *
 * @author frank.aguilar
 */
public class GraphicsMonitor {
    private Color color;
    private Stroke stroke;
    private Graphics g;

    public GraphicsMonitor(Graphics g) {
        this.g = g;
    }
    
    public void setState(Color newColor,Stroke newStroke){
        this.saveState();
        g.setColor(newColor);
        ((Graphics2D)g).setStroke(newStroke);
    }
    
    private void saveState(){
        this.color=g.getColor();
        this.stroke=((Graphics2D)g).getStroke();
    }
    
    public void restaurateLastState(){
        this.setState(this.color, this.stroke);
    }
    
}
