/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanRegisterUser.java
 *
 * Created on 31-jul-2011, 10:59:54
 */

package br.usp.ime.faguilar.guis.WellComeToSystem;

import DatabaseMathExpressions.DBFuntions;
import Users.User;

/**
 *
 * @author frank
 */
public class PanRegisterUser extends javax.swing.JPanel {
    private DBFuntions dBFuntions;
    private static boolean DEFAULT_ADMIN_VALUE=false;
    private static boolean DEFAULT_INPUT_EXPRESSIONS_VALUE=true;

    /** Creates new form PanRegisterUser */
    public PanRegisterUser() {
        initComponents();
        this.butSaveNewUser.setEnabled(false);
    }

    private boolean requiredFieldsEntered(){
        if(passwordEntered()&&loginNameEntered())
            return true;
        return false;
    }

    private boolean passwordEntered(){
        if(passFieldPassword.getPassword().length>0)
            return true;
        return false;
    }

    private boolean loginNameEntered(){
        if(txtID.getText().isEmpty())
            return false;
        return true;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passFieldPassword = new javax.swing.JPasswordField();
        butSaveNewUser = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
        });

        jLabel1.setText("Login name *:");

        jLabel2.setText("Password *");

        passFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passFieldPasswordKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passFieldPasswordKeyReleased(evt);
            }
        });

        butSaveNewUser.setText("Save");
        butSaveNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSaveNewUserActionPerformed(evt);
            }
        });

        jLabel3.setText("First name:");

        jLabel4.setText("Last name:");

        jLabel5.setText("* Required fields");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel2)
                            .add(jLabel4)
                            .add(jLabel1)
                            .add(jLabel3))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtLastName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtFirstName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtID, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, passFieldPassword, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, butSaveNewUser))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtFirstName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtLastName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(passFieldPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(butSaveNewUser))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtIDKeyTyped

    private void passFieldPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passFieldPasswordKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_passFieldPasswordKeyTyped

    private void butSaveNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSaveNewUserActionPerformed
        // TODO add your handling code here:
        addNewUser();
    }//GEN-LAST:event_butSaveNewUserActionPerformed

    private void passFieldPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passFieldPasswordKeyReleased
        // TODO add your handling code here:
        updateSaveButtonState();
    }//GEN-LAST:event_passFieldPasswordKeyReleased

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        // TODO add your handling code here:
        updateSaveButtonState();
    }//GEN-LAST:event_txtIDKeyReleased

    private void updateSaveButtonState(){
        if(requiredFieldsEntered())
            butSaveNewUser.setEnabled(true);
        else
            butSaveNewUser.setEnabled(false);
    }
    public void addNewUser(){
        User user=setUpUser();
        this.dBFuntions.addUser(user);
    }

    private User setUpUser(){
        User user=new User();
        user.setAdmin(DEFAULT_ADMIN_VALUE);
        user.setFirstName(this.txtFirstName.getText());
        user.setLastName(txtLastName.getText());
        user.setNickName(txtID.getText());
        user.setPassword(String.valueOf(this.passFieldPassword.getPassword()));
        user.setAllowedToInsertUserExpressions(DEFAULT_INPUT_EXPRESSIONS_VALUE);
        return user;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butSaveNewUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField passFieldPassword;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables

    public DBFuntions getdBFuntions() {
        return dBFuntions;
    }

    public void setdBFuntions(DBFuntions dBFuntions) {
        this.dBFuntions = dBFuntions;
    }

}
