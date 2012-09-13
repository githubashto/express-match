/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanModelExpressions.java
 *
 * Created on 31/08/2011, 18:34:59
 */
package br.usp.ime.faguilar.guis;

import DatabaseMathExpressions.DBFuntions;
import DatabaseMathExpressions.ModelExpression;
import DatabaseMathExpressions.TextualRepresentation;
import br.usp.ime.faguilar.guis.Util.MyTableModel;
import MathExpression.Data.DMathExpression;
import MathExpression.Graphics.GMathExpression;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author frank.aguilar
 */
public class PanModelExpressions extends javax.swing.JPanel 
implements ListSelectionListener{
    private DBFuntions databaseFunctions;
    private static final int ID_COLUMN = 0;
    private static final int CATEGORY_COLUMN = 1;
    private static final int ID_COLUMN_WIDTH = 30;
    private String[] columnNames={"ID","Category"};
    private ModelExpression selectedModel;

    /** Creates new form PanModelExpressions */
    public PanModelExpressions() {
        initComponents();
        initAttributes();
    }

    private void initAttributes(){
        databaseFunctions=null;
        this.modelsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel rowSM = modelsTable.getSelectionModel();
        rowSM.addListSelectionListener(this);
        selectedModel=null;
    }
    
    public DBFuntions getDatabaseFunctions() {
        return databaseFunctions;
    }

    public void setDatabaseFunctions(DBFuntions dBFuntions) {
        this.databaseFunctions = dBFuntions;
    }

    public void chargeModelExpressions(){
        ArrayList<ModelExpression> expressionsForUser = databaseFunctions.getModelExpressions();
        Object[][] data=preprocessMyDataForTable(expressionsForUser);
        MyTableModel tableModel=new MyTableModel(columnNames,data);
        this.modelsTable.setModel(tableModel);
//        modelsTable.getColumnModel().getColumn(ID_COLUMN).setPreferredWidth(ID_COLUMN_WIDTH);
        modelsTable.repaint();
    }
    
    private Object[][] preprocessMyDataForTable(ArrayList<ModelExpression> modelExpressions){
        Object[][] data=new Object[modelExpressions.size()][columnNames.length];
        Integer modelID;
        String categoria=null;
        TextualRepresentation textualRepresentation;
        int i=0;
        for (ModelExpression model : modelExpressions) {
            modelID=model.getId();
            categoria=model.getCategory();
            textualRepresentation=model.getTextualRepresentation();
            Object[] obj={modelID,categoria};
            data[i]=obj;
            i++;
        }
        return data;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        modelsTable = new javax.swing.JTable();
        expressionLevelGroundTruth = new br.usp.ime.faguilar.guis.ExpressionLevelGroundTruth();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panShowModel = new br.usp.ime.faguilar.guis.capturers.PanControlInputMathExpressions();
        jPanel7 = new javax.swing.JPanel();
        delete = new javax.swing.JButton();
        save = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(300);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(800, 504));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Model Expressions"));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(200, 477));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        modelsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(modelsTable);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        expressionLevelGroundTruth.setBorder(javax.swing.BorderFactory.createTitledBorder("Textual Representation"));
        expressionLevelGroundTruth.setPreferredSize(new java.awt.Dimension(291, 200));
        jPanel5.add(expressionLevelGroundTruth, java.awt.BorderLayout.SOUTH);

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, java.awt.BorderLayout.SOUTH);

        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(panShowModel, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(jPanel3);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);

        delete.setText("Delete");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(708, Short.MAX_VALUE)
                .addComponent(save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete)
                .addGap(9, 9, 9))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(delete)
                .addComponent(save))
        );

        add(jPanel7, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
        if(selectedModel!=null){
            int idModel=selectedModel.getId();
            databaseFunctions.deleteModelByID(idModel);
            panShowModel.clearPanel();
            chargeModelExpressions();
            selectedModel=null;
        }
    }//GEN-LAST:event_deleteMouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        if(selectedModel!=null){
            int idModel=selectedModel.getId();
            selectedModel.setdMathExpression(panShowModel.getPanWriting().getgMathExpressionWritten());
//            DMathExpression mathExpression=(DMathExpression) selectedModel.getdMathExpression().clone();
            selectedModel.setTextualRepresentation(expressionLevelGroundTruth.getGroundTruth());
            int selectedRow = modelsTable.getSelectedRow();
             Object categoryName=this.modelsTable.getModel().getValueAt(selectedRow,CATEGORY_COLUMN);
            selectedModel.setCategory( (String) categoryName);
//            databaseFunctions.updateMathExpressionOfModel(idModel, mathExpression);
            databaseFunctions.updateModelByID(idModel, selectedModel);
        }
    }//GEN-LAST:event_saveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private br.usp.ime.faguilar.guis.ExpressionLevelGroundTruth expressionLevelGroundTruth;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable modelsTable;
    private br.usp.ime.faguilar.guis.capturers.PanControlInputMathExpressions panShowModel;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables

    public void valueChanged(ListSelectionEvent lse) {
        if (lse.getValueIsAdjusting()) return;
//            int idColumn=0;
            ListSelectionModel lsm = (ListSelectionModel)lse.getSource();
            if (!lsm.isSelectionEmpty()) {
                int selectedRow = lsm.getMinSelectionIndex();
                Object id=this.modelsTable.getModel().getValueAt(selectedRow,ID_COLUMN);
                selectedModel = databaseFunctions.getModelByID((Integer)id);
                expressionLevelGroundTruth.setGroundTruth(selectedModel.getTextualRepresentation());
                //((GMathExpression) selectedModel.getdMathExpression()).showJustMathExpression();
                panShowModel.setDrawable((GMathExpression) selectedModel.getdMathExpression().clone());
                panShowModel.repaint();
                expressionLevelGroundTruth.repaint();
            }
    }
}