/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Stroke;

/**
 *
 * @author frank.aguilar
 */
public abstract class GObject {
    
    protected GraphicsMonitor gMonitor;

    public static final Stroke HIGHLIGHTED_STROKE=new BasicStroke(3.0f);

    public static final Stroke DEFAULT_STROKE=new BasicStroke(1.0f);

    public static final Color DEFAULT_COLOR=Color.BLUE;

    protected Color color=DEFAULT_COLOR;
    protected Stroke stroke=DEFAULT_STROKE;

//    public GObject(Graphics myGraphics) {
//        this.myGraphics = myGraphics;
//    }
    
    public abstract void draw(Graphics g);
    
    public void configureGraphics(Graphics g){
        gMonitor=new GraphicsMonitor(g);
        gMonitor.setState(color, stroke);
    }
    
    protected void restaurateLastGraphicsState(){
        gMonitor.restaurateLastState();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }
    
}
