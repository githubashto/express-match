/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TestByModels.java
 *
 * Created on 13/11/2011, 19:34:35
 */
package TestMatching.AutomaticTest.GUIs;

import DatabaseMathExpressions.DBFuntions;
import DatabaseMathExpressions.ModelExpression;
import DatabaseMathExpressions.UserExpression;
import FeatureExtractor.PreprocessingAlgorithms;
import GUIs.Matching.PanMatching;
import Matching.ExpressionMatching;
import MathExpression.Data.DMathExpression;
import MathExpression.Data.DSymbol;
import MathExpression.Graphics.GMathExpression;
import Util.Util;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author frank.aguilar
 */
public class TestByModels extends javax.swing.JPanel {

    DBFuntions databaseFunctions;
    ArrayList<String> expressionIDs;
    ArrayList<String> instanceIDs;
    private DMathExpression selectedModel;
    private String idModel;
//    private DMathExpression selectedInstance;
    private ExpressionMatching matching;
    
    /** Creates new form TestByModels */
    public TestByModels() {
        initComponents();
        initializeAttributes();
    }
    
    private void initializeAttributes(){
        instanceIDs=new ArrayList<String>();
        databaseFunctions=new DBFuntions();
        databaseFunctions.openConnection();
        matching=new ExpressionMatching();

        chargeAllExpressions();
    }
  
    private void chargeAllExpressions(){
        readIds();
        //        this.models=new JList(expressionIDs.toArray());
        
        //listModel
//        models = new JList(Util.toObjectArray(expressionIDs));
        chargeModels();
    }
    private void readIds(){
        ArrayList<String> modelIDs=null;
         instanceIDs=null;
        ArrayList<ModelExpression> allModelExpressions = databaseFunctions.getModelExpressions();
        modelIDs=extractAllIDsOfModels(allModelExpressions);
        instanceIDs=getIdsOfInstances(allModelExpressions);
        int totalIDs=modelIDs.size()+instanceIDs.size();
        expressionIDs=new ArrayList<String>(totalIDs);
        for (String id : modelIDs) {
            expressionIDs.add(id);
        }
        for (String id : instanceIDs) {
            expressionIDs.add(id);
        }
        Collections.sort(expressionIDs);
//        System.arraycopy(modelIDs, 0,expressionIDs, 0, modelIDs.size());
//        System.arraycopy(instanceIDs, 0,expressionIDs, modelIDs.size(),instanceIDs.size());
//        System.out.println("last id "+instanceIDs.get(totalIDs-1));
    }


    private void readPossibleInstances(String model){
        String[] partsOfID=model.split("_");
        if(partsOfID[0].equals("unknown")){
            ArrayList<UserExpression> userExpressionsForModel = databaseFunctions.getUserExpressionsForModel(Integer.valueOf(partsOfID[1]));
            instanceIDs.clear();
            for (UserExpression userExpression : userExpressionsForModel) {
                instanceIDs.add(userExpression.toString());
            }
        }else{
            UserExpression userExpression=databaseFunctions.getUserExpressionByID(Integer.valueOf(partsOfID[1]));
            int idModel=userExpression.getIdModelExpression();
            instanceIDs.clear();
            instanceIDs.add("unknown_"+idModel);
            ArrayList<UserExpression> userExpressionsForModel = databaseFunctions.getUserExpressionsForModel(idModel);
            for (UserExpression userExpression1 : userExpressionsForModel) {
                instanceIDs.add(userExpression1.toString());
            }
        }
        chargeInstances();
    }
    
    private DMathExpression readExpression(String id){
        DMathExpression mathExpression=null;
        String[] partsOfID=id.split("_");
        if(partsOfID[0].equals("unknown")){
            mathExpression=(databaseFunctions.getModelByID(Integer.valueOf(partsOfID[1]))).getdMathExpression();
        }else{
            mathExpression=databaseFunctions.getUserExpressionByID(Integer.valueOf(partsOfID[1])).getdMExpression();
        }
        return mathExpression;
    }
    
    private ArrayList<String> extractAllIDsOfModels(ArrayList<ModelExpression> allModelExpressions){
        ArrayList<String> modelIDs=new ArrayList<String>();
        for (ModelExpression modelExpression : allModelExpressions) {
            modelIDs.add(formatModelID(modelExpression.getId()));
        }
        return modelIDs;
    }
    
    private ArrayList<String> getIdsOfInstances(ArrayList<ModelExpression> allModelExpressions){
        instanceIDs=new ArrayList<String>();
        for (ModelExpression modelExpression : allModelExpressions) {
            ArrayList<UserExpression> userExpressionsForModel = databaseFunctions.getUserExpressionsForModel(modelExpression.getId());
            for (UserExpression userExpression : userExpressionsForModel) {
                String id=userExpression.toString();
                instanceIDs.add(id);
            }
        }
        return instanceIDs;
    }
    
    private String formatModelID(int id){
        return ("unknown_"+id);
    }
    
    private void chargeModels(){
        DefaultListModel listModel = new DefaultListModel();
        for (String string : expressionIDs) {
            listModel.addElement(string);
        }
        models = new JList(listModel);
        models.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    modelsValueChanged(evt);
                }
            });
        jScrollPane2.setViewportView(models);
        models.repaint();

    }

    private void chargeInstances(){
        DefaultListModel listModel = new DefaultListModel();
        for (String string : instanceIDs) {
            listModel.addElement(string);
        }
        instances = new JList(listModel);
        instances.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    instancesValueChanged(evt);
                }
            });
        jScrollPane1.setViewportView(instances);
        instances.repaint();

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
        jLabel1 = new javax.swing.JLabel();
        alpha = new javax.swing.JTextField();
        beta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        gama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        isDelaunay = new javax.swing.JCheckBox();
        executeMatch = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        controlOfMatchingView = new GUIs.Matching.PanControlOfMatchingPanel();
        jPanel2 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        models = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        instances = new javax.swing.JList();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Matching parameters"));

        jLabel1.setText("Beta");

        alpha.setText("0.3");

        beta.setText("1");

        jLabel2.setText("Alpha");

        gama.setText("0.25");

        jLabel3.setText("Gama");

        isDelaunay.setText("Delaunay");

        executeMatch.setText("Match");
        executeMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeMatchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(alpha, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(beta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(gama, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(isDelaunay)
                        .addGap(57, 57, 57)
                        .addComponent(executeMatch))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(beta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isDelaunay)
                            .addComponent(executeMatch)))))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jSplitPane1.setDividerLocation(160);
        jSplitPane1.setRightComponent(controlOfMatchingView);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jSplitPane2.setDividerLocation(250);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Model"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        models.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                modelsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(models);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jSplitPane2.setTopComponent(jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Instance"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        instances.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                instancesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(instances);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSplitPane2.setRightComponent(jPanel4);

        jPanel2.add(jSplitPane2, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(jPanel2);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void modelsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_modelsValueChanged
        // TODO add your handling code here:
        if(!evt.getValueIsAdjusting()){
            int pos= evt.getFirstIndex();
            if(pos>=0){
                idModel=String.valueOf(models.getSelectedValue());
                selectedModel=readExpression(idModel);
                this.controlOfMatchingView.getPanMatching().clearPanel();
                this.controlOfMatchingView.getPanMatching().setTypeOfDrawing(PanMatching.TYPE_DRAWING_JUST_MODEL_EXPR);
//                selectedModel=PreprocessingAlgorithms.preprocessDMathExpression(selectedModel);
                controlOfMatchingView.getPanMatching().setgMathExpressionModel((GMathExpression) selectedModel);
                controlOfMatchingView.getPanMatching().repaint();
                this.controlOfMatchingView.enableControlls(false);
                readPossibleInstances(idModel);
                //falta listar  instancias disponibles
            }
//            selectedME=(ModelExpression) jListModels.getModel().getElementAt(pos);//db.getAlModelExpression().get(pos); //(ModelExpression) jListModels.getModel().getElementAt(pos);//
//            //alue=selectedME.getAlUserExpression();
////            JListHandler.chargeListOfUserExpressions( alue, jListUserExpressions);
//            this.chargeUserExpressionsJList();
//            this.panControlOfMatchingPanel.getPanMatching().clearPanel();
//            this.panControlOfMatchingPanel.getPanMatching().setTypeOfDrawing(PanMatching.TYPE_DRAWING_JUST_MODEL_EXPR);
//            panControlOfMatchingPanel.getPanMatching().setgMathExpressionModel((GMathExpression) selectedME.getdMathExpression());
//            panControlOfMatchingPanel.getPanMatching().repaint();
//            this.panControlOfMatchingPanel.enableControlls(false);
//        }

        }
    }//GEN-LAST:event_modelsValueChanged

    private void instancesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_instancesValueChanged
        // TODO add your handling code here:
        if(!evt.getValueIsAdjusting()){
            int pos= evt.getFirstIndex();
            updateMatching(pos);
        }

    }//GEN-LAST:event_instancesValueChanged

    private void executeMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeMatchActionPerformed
        // TODO add your handling code here:
        int posInstance=instances.getSelectedIndex();
        updateMatching(posInstance);
    }//GEN-LAST:event_executeMatchActionPerformed

//        public void printModelAndInstance(DMathExpression model, DMathExpression instance){
//        System.out.println("Model ");
//        System.out.println(model);
//        System.out.println("Instance ");
//        System.out.println(instance);
//    }
    
    private void updateMatching(int posInstance){
        if(posInstance>=0){
                String idInstance=String.valueOf(instances.getSelectedValue());
                DMathExpression instanceExpression=readExpression(idInstance);
//                DMathExpression modelExpression=readExpression(idModel);
//                DMathExpression modelExpression=selectedModel;//controlOfMatchingView.getPanMatching().getgMathExpressionModel();
                DMathExpression preprocessedInstance=PreprocessingAlgorithms.preprocessDMathExpression(instanceExpression);
                DMathExpression preprocessedModel=PreprocessingAlgorithms.preprocessDMathExpression(selectedModel);
                setUpMatchingParameters();
//                String[][] strMatch=matching.match(selectedModel,instanceExpression);
                String[][] strMatch=matching.match(preprocessedModel,preprocessedInstance);
//                printModelAndInstance(modelExpression, instanceExpression);
               
//                printModelAndInstance(modelExpression, instanceExpression);
                int[][] match=Util.stringToIntMatrix(strMatch);
//                panMatching1.setgMathExpressionModel((GMathExpression) modelExpression);
                controlOfMatchingView.getPanMatching().setgMathExpressionInput((GMathExpression) instanceExpression.clone());
                controlOfMatchingView.getPanMatching().setMatch(match);
                controlOfMatchingView.getPanMatching().setUpMatchingDrawer();
                controlOfMatchingView.getPanMatching().setTypeOfDrawing(PanMatching.TYPE_DRAWING_JUST_MATCHING);

                controlOfMatchingView.repaint();
//                DMathExpression model=readExpression(idModel);
//                this.controlOfMatchingView.getPanMatching().clearPanel();
//                this.controlOfMatchingView.getPanMatching().setTypeOfDrawing(PanMatching.TYPE_DRAWING_JUST_MODEL_EXPR);
//                controlOfMatchingView.getPanMatching().setgMathExpressionModel((GMathExpression) model);
//                controlOfMatchingView.getPanMatching().repaint();
//                this.controlOfMatchingView.enableControlls(false);
//                readPossibleInstances(idModel);
                //falta listar  instancias disponibles
            }
    }

    private void setUpMatchingParameters(){
        try{
            matching.setAlpha(Float.valueOf(alpha.getText()));
            matching.setBeta(Float.valueOf(beta.getText()));
            matching.setGama(Float.valueOf(gama.getText()));
            matching.setDelaunay(isDelaunay.isSelected());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error: incorrect matching parameters");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alpha;
    private javax.swing.JTextField beta;
    private GUIs.Matching.PanControlOfMatchingPanel controlOfMatchingView;
    private javax.swing.JButton executeMatch;
    private javax.swing.JTextField gama;
    private javax.swing.JList instances;
    private javax.swing.JCheckBox isDelaunay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JList models;
    // End of variables declaration//GEN-END:variables
}
