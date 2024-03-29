/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanWelcome.java
 *
 * Created on 12-sep-2011, 22:37:02
 */

package br.usp.ime.faguilar.guis.WellComeToSystem;

import DatabaseMathExpressions.DBFuntions;
import br.usp.ime.faguilar.guis.AdministratorMainPanel;
import Users.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author frank
 */
public class PanWelcome extends javax.swing.JPanel {

    private DBFuntions databaseFunctions;
    private JFrame containerFrame;
    /** Creates new form PanWelcome */
    public PanWelcome() {
        initComponents();
        initAllFields();
    }

    private void initAllFields(){
        databaseFunctions=new DBFuntions();
        databaseFunctions.openConnection();
        this.signinButton.setEnabled(false);
    }

    public JFrame getContainerFrame() {
        return containerFrame;
    }

    public void setContainerFrame(JFrame containerFrame) {
        this.containerFrame = containerFrame;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        loginName = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        signinButton = new javax.swing.JButton();
        newUserButton = new javax.swing.JButton();

        jLabel1.setText("Login name:");

        loginName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                loginNameKeyReleased(evt);
            }
        });

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordKeyReleased(evt);
            }
        });

        jLabel2.setText("Password:");

        signinButton.setText("Sign in");
        signinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinButtonActionPerformed(evt);
            }
        });

        newUserButton.setText("New account");
        newUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(67, 67, 67)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel1)
                    .add(jLabel2))
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, password)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, loginName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(signinButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(newUserButton)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(loginName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(password, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(newUserButton)
                    .add(signinButton))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void startSystem(User user){
        if(user.isAdmin()){
            FramAdministratorMainFrame mainAdministratorFrame=new FramAdministratorMainFrame(databaseFunctions,user.getNickName());
            containerFrame.setVisible(false);
            mainAdministratorFrame.setVisible(true);
        }
        else{
            MainUserFrame mainUserFrame=new MainUserFrame(user.getNickName());
            containerFrame.setVisible(false);
            mainUserFrame.setVisible(true);
        }
    }

    private void signinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinButtonActionPerformed
        User user=searchUser();
        if(user==null){
            JOptionPane.showMessageDialog(this,"Incorrect login name and/or password ","Incorrect parameters",
                                JOptionPane.ERROR_MESSAGE);
        }else{
            startSystem(user);
            this.setVisible(false);
        }
    }//GEN-LAST:event_signinButtonActionPerformed

    private User searchUser(){
        User user=null;
        try {
            // TODO add your handling code here:
            user = databaseFunctions.getUserBy(loginName.getText(), String.valueOf(password.getPassword()));

        } catch (SQLException ex) {
            Logger.getLogger(PanWelcome.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    private void newUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserButtonActionPerformed
        // TODO add your handling code here:
        JDialog dialogNewUser=new JDialog();
        PanRegisterUser panRegisterUser=new PanRegisterUser();
        panRegisterUser.setdBFuntions(databaseFunctions);
        dialogNewUser.setContentPane(panRegisterUser);
        dialogNewUser.setModal(true);
        dialogNewUser.pack();
        dialogNewUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialogNewUser.setResizable(false);
        dialogNewUser.setVisible(true);
    }//GEN-LAST:event_newUserButtonActionPerformed

    private void passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyReleased
        // TODO add your handling code here:
        updateSaveButtonState();
    }//GEN-LAST:event_passwordKeyReleased

    private void loginNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginNameKeyReleased
        // TODO add your handling code here:
        updateSaveButtonState();
    }//GEN-LAST:event_loginNameKeyReleased

    private void updateSaveButtonState(){
        if(requiredFieldsEntered())
            signinButton.setEnabled(true);
        else
            signinButton.setEnabled(false);
    }

    private boolean requiredFieldsEntered(){
        if(passwordEntered()&&loginNameEntered())
            return true;
        return false;
    }

    private boolean passwordEntered(){
        if(password.getPassword().length>0)
            return true;
        return false;
    }

    private boolean loginNameEntered(){
        if(loginName.getText().isEmpty())
            return false;
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField loginName;
    private javax.swing.JButton newUserButton;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton signinButton;
    // End of variables declaration//GEN-END:variables

}
