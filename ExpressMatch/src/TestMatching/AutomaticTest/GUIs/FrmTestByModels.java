/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmTestByModels.java
 *
 * Created on 13/11/2011, 20:32:35
 */
package TestMatching.AutomaticTest.GUIs;

import java.awt.BorderLayout;

/**
 *
 * @author frank.aguilar
 */
public class FrmTestByModels extends javax.swing.JFrame {

    /** Creates new form FrmTestByModels */
    public FrmTestByModels() {
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

        jPanel1 = new javax.swing.JPanel();
        testByModels1 = new TestMatching.AutomaticTest.GUIs.TestByModels();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(testByModels1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmTestByModels().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private TestMatching.AutomaticTest.GUIs.TestByModels testByModels1;
    // End of variables declaration//GEN-END:variables
}
