/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanSymbol.java
 *
 * Created on Jan 10, 2012, 12:56:30 AM
 */

package ShapeContextEvaluation;

import MathExpression.Graphics.GSymbol;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import sun.nio.cs.ext.GB18030;

/**
 *
 * @author frank
 */
public class PanSymbol extends javax.swing.JPanel {

    String label;
    GSymbol symbol;
    /** Creates new form PanSymbol */
    public PanSymbol() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 226, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 219, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(symbol!=null){
            symbol.drawSymbol(g);
            if(label!=null)
                g.drawString(label, 10,180);
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    

    public GSymbol getSymbol() {
        return symbol;
    }

    public void setSymbol(GSymbol symbol) {
        this.symbol = symbol;
        centerSymbol();
    }

    public void centerSymbol(){
        int dx=40;
        int dy=40;
//        if(getWidth()>symbol.getWidth()){
//            dx=getWidth()/2;
//        }
//        if(getHeight()>symbol.getHeight()){
//            dy=getHeight()/2;
//        }
        dx=(int)(dx-symbol.getCenterOfBBoc().getX());
        dy=(int)(dy-symbol.getCenterOfBBoc().getY());
        symbol.translate(dx, dy);

    }
    
}