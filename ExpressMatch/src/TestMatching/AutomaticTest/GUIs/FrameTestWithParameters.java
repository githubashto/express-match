/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrameTestWithParameters.java
 *
 * Created on 24-oct-2011, 22:23:28
 */

package TestMatching.AutomaticTest.GUIs;

/**
 *
 * @author frank
 */
public class FrameTestWithParameters extends javax.swing.JFrame {

    /** Creates new form FrameTestWithParameters */
    public FrameTestWithParameters() {
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

        panTestInstanceInstanceMatching1 = new TestMatching.AutomaticTest.GUIs.PanTestInstanceInstanceMatching();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(panTestInstanceInstanceMatching1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameTestWithParameters().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private TestMatching.AutomaticTest.GUIs.PanTestInstanceInstanceMatching panTestInstanceInstanceMatching1;
    // End of variables declaration//GEN-END:variables

}