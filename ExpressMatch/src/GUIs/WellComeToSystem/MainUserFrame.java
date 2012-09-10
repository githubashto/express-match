/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainUserFrame.java
 *
 * Created on 22-ago-2011, 22:29:02
 */

package GUIs.WellComeToSystem;

import DatabaseMathExpressions.DBFuntions;
import GUIs.InputOfExpressions.panConfigurateWritting;
import javax.swing.JFrame;

/**
 *
 * @author frank
 */
public class MainUserFrame extends javax.swing.JFrame {

    /** Creates new form MainUserFrame */
    public MainUserFrame(String useLoginName) {
        initComponents();
        initMyAttributes(useLoginName);
    }

    private void initMyAttributes(String useLoginName){
        this.setTitle("ExpressMatch");
        DBFuntions dbFunctions=new DBFuntions();
        dbFunctions.openConnection();
        this.panInputUserMathExpression1.setDbFunctions(dbFunctions);
        panInputUserMathExpression1.setMyUser(useLoginName);
        panInputUserMathExpression1.upDateAdvance();
        this.panControlInputMathExpressions1.setVisibleLabelingButton(false);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panControlInputMathExpressions1 = new GUIs.InputOfExpressions.PanControlInputMathExpressions();
        panInputUserMathExpression1 = new GUIs.InputOfExpressions.PanInputUserMathExpression();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addTab("Writing test", panControlInputMathExpressions1);
        jTabbedPane1.addTab("Input math expressions", panInputUserMathExpression1);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jMenu2.setText("Configuration");

        jMenuItem1.setText("Time and writing area");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        // TODO add your handling code here:  
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        panConfigurateWritting panConfigure=new panConfigurateWritting();
        panConfigure.addWritingPanel(this.panInputUserMathExpression1.getPanWriting());
        panConfigure.addWritingPanel(this.panControlInputMathExpressions1.getPanWriting());
        panConfigure.setUpSliders();
        JFrame frame=new JFrame();
        frame.setContentPane(panConfigure);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private GUIs.InputOfExpressions.PanControlInputMathExpressions panControlInputMathExpressions1;
    private GUIs.InputOfExpressions.PanInputUserMathExpression panInputUserMathExpression1;
    // End of variables declaration//GEN-END:variables

}
