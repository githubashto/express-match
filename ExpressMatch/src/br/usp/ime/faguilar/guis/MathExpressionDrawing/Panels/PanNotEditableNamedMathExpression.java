/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanNotEditableNamedMathExpression.java
 *
 * Created on 03-ago-2011, 7:54:12
 */

package br.usp.ime.faguilar.guis.MathExpressionDrawing.Panels;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author frank
 */
public class PanNotEditableNamedMathExpression extends MathExpressionsDrawingPanel {

    private String modelName;

//   protected Drawable drawable;

    
    private static Point namePosition=new Point(20,20);

    /** Creates new form PanNotEditableNamedMathExpression */
    public PanNotEditableNamedMathExpression() {
        initComponents();
        initializeAllFields();
    }

    protected void initializeAllFields(){
        super.initializeAllFields();
        modelName="";
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        setPreferredSize(new java.awt.Dimension(200, 150));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void clearPanel(){
        this.setDrawable(null);
        setModelName("");
    }
    protected void draw(Graphics g){
        super.draw(g);
        if(modelName!=null&&!modelName.isEmpty())
            drawName(g);
    }

    private void drawName(Graphics g){
        g.drawString(modelName, namePosition.x, namePosition.y);
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
