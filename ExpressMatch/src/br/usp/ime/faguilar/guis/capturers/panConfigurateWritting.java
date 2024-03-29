/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * panConfigurateWritting.java
 *
 * Created on 09-sep-2011, 14:07:22
 */

package br.usp.ime.faguilar.guis.capturers;

import br.usp.ime.faguilar.guis.MathExpressionDrawing.Panels.PanWriting;
import java.util.ArrayList;

/**
 *
 * @author frank
 */
public class panConfigurateWritting extends javax.swing.JPanel {

    private static final int TIME_SCALE_FACTOR=100;
    private static final int SQUARES_SIZE_SCALE_FACTOR=1;
    private ArrayList<PanWriting> writingPanels;
    /** Creates new form panConfigurateWritting */
    public panConfigurateWritting() {
        initComponents();
        writingPanels=new ArrayList<PanWriting>();
    }

    public ArrayList<PanWriting> getPanwriting() {
        return writingPanels;
    }

    public void setUpSliders(){
         if(!writingPanels.isEmpty()){
            this.TimeSlider.setValue(writingPanels.get(0).getTimeBetweenStrokes()/TIME_SCALE_FACTOR);
            this.SquaresSizeSlider.setValue(writingPanels.get(0).getSquaresDimension()/SQUARES_SIZE_SCALE_FACTOR);
        }
   }

    public void addWritingPanel(PanWriting panwriting) {
        writingPanels.add(panwriting);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SquaresSizeSlider = new javax.swing.JSlider();
        TimeSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        SquaresSizeSlider.setMinimum(10);
        SquaresSizeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SquaresSizeSliderStateChanged(evt);
            }
        });

        TimeSlider.setMaximum(20);
        TimeSlider.setMinimum(1);
        TimeSlider.setValue(10);
        TimeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TimeSliderStateChanged(evt);
            }
        });

        jLabel1.setText("Time between symbol strokes");

        jLabel2.setText("Squares size");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(TimeSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 233, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(SquaresSizeSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 238, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1))
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel2)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(1, 1, 1)
                .add(TimeSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(22, 22, 22)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(SquaresSizeSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TimeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TimeSliderStateChanged
        // TODO add your handling code here:
        for (PanWriting panWriting : writingPanels) {
            panWriting.setTimeBetweenStrokes(TIME_SCALE_FACTOR*TimeSlider.getValue());
        }
    }//GEN-LAST:event_TimeSliderStateChanged

    private void SquaresSizeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SquaresSizeSliderStateChanged
        // TODO add your handling code here:
        for (PanWriting panWriting : writingPanels) {
            panWriting.setSquaresDimension(SquaresSizeSlider.getValue()*SQUARES_SIZE_SCALE_FACTOR);
            panWriting.repaint();
        }
    }//GEN-LAST:event_SquaresSizeSliderStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider SquaresSizeSlider;
    private javax.swing.JSlider TimeSlider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
