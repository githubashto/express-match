/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanDBconfiguration.java
 *
 * Created on 11/08/2011, 12:04:49
 */
package GUIs;

import DatabaseMathExpressions.DBFuntions;
import DatabaseMathExpressions.ExportableAndImportableDatabase;
import GUIs.Util.MyTableModel;
import Util.ReadObjectInFile;
import export.Exporter;
import export.SymbolExporter;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author frank.aguilar
 */
public class PanDBconfiguration extends javax.swing.JPanel
    implements ChangeListener{
    private DBFuntions dbFunction;
    private JFileChooser fc;
    private final String[] categoryTableTitles = {"","Category"};
    private final String[] userTableTitles = {"","User"};
    public static final int DATA_COLUMN = 1;
    public static final int SELECTION_COLUMN = 0;
    /** Creates new form PanDBconfiguration */
    public PanDBconfiguration() {
        initComponents();
        dbFunction=null;
        fc = new JFileChooser();
        this.maxExpressionSizeSpinner.addChangeListener(this);
        this.minExpressionSizeSpinner.addChangeListener(this);
    }

    public DBFuntions getDbFunction() {
        return dbFunction;
    }

    public void setDbFunction(DBFuntions dbFunction) {
        this.dbFunction = dbFunction;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        MathExpressionsPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("MathExpressionsPU").createEntityManager();
        emuserQuery = java.beans.Beans.isDesignTime() ? null : MathExpressionsPUEntityManager.createQuery("SELECT e FROM Emuser e");
        emuserList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : emuserQuery.getResultList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        importFromOtherMachineButton = new javax.swing.JButton();
        exportToOtherMachineButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoriesTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        minExpressionSizeSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        maxExpressionSizeSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        selectAllCategoriesButton = new javax.swing.JButton();
        unselectAllCategoriesButton = new javax.swing.JButton();
        selectAllUserButton = new javax.swing.JButton();
        unselectAllUsersButton = new javax.swing.JButton();
        exportToXMLButton = new javax.swing.JButton();
        expressionSizeCheckBox = new javax.swing.JCheckBox();
        onlySymnolsCheckBox = new javax.swing.JCheckBox();
        selectModelsCheckBox = new javax.swing.JCheckBox();
        userAdministrator1 = new GUIs.UserAdministrator();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(" Import/Export from/to other machine"));

        importFromOtherMachineButton.setText("Import dataset");
        importFromOtherMachineButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importFromOtherMachineButtonMouseClicked(evt);
            }
        });

        exportToOtherMachineButton.setText("Export dataset");
        exportToOtherMachineButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportToOtherMachineButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(importFromOtherMachineButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                .addComponent(exportToOtherMachineButton)
                .addGap(195, 195, 195))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importFromOtherMachineButton)
                    .addComponent(exportToOtherMachineButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Export to XML"));

        categoriesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(categoriesTable);

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(usersTable);

        minExpressionSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, expressionSizeCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), minExpressionSizeSpinner, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel1.setText("Min:");

        maxExpressionSizeSpinner.setValue(1);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, expressionSizeCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), maxExpressionSizeSpinner, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        maxExpressionSizeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                maxExpressionSizeSpinnerStateChanged(evt);
            }
        });

        jLabel2.setText("Max:");

        jLabel4.setText("Categories");

        jLabel5.setText("Users");

        selectAllCategoriesButton.setText("Select All");
        selectAllCategoriesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectAllCategoriesButtonMouseClicked(evt);
            }
        });

        unselectAllCategoriesButton.setText("Unselect All");
        unselectAllCategoriesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unselectAllCategoriesButtonMouseClicked(evt);
            }
        });

        selectAllUserButton.setText("Select All");
        selectAllUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectAllUserButtonMouseClicked(evt);
            }
        });

        unselectAllUsersButton.setText("Unselect All");
        unselectAllUsersButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unselectAllUsersButtonMouseClicked(evt);
            }
        });

        exportToXMLButton.setText("Export");
        exportToXMLButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportToXMLButtonMouseClicked(evt);
            }
        });

        expressionSizeCheckBox.setText("Consider expression size");

        onlySymnolsCheckBox.setText("Only symbols");

        selectModelsCheckBox.setText("Models");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(expressionSizeCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minExpressionSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(unselectAllCategoriesButton)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(selectAllCategoriesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(onlySymnolsCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportToXMLButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectModelsCheckBox)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(selectAllUserButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(unselectAllUsersButton))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(maxExpressionSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addContainerGap(42, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(expressionSizeCheckBox)
                        .addComponent(minExpressionSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(maxExpressionSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectModelsCheckBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectAllCategoriesButton)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(unselectAllCategoriesButton)
                        .addComponent(selectAllUserButton)
                        .addComponent(unselectAllUsersButton)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exportToXMLButton)
                    .addComponent(onlySymnolsCheckBox))
                .addGap(42, 42, 42))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Import/Export dataset", jPanel1);
        jTabbedPane1.addTab("Edit Users", userAdministrator1);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void exportToOtherMachineButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportToOtherMachineButtonMouseClicked
        // TODO add your handling code here:
        if(dbFunction!=null){
            int returnVal = fc.showSaveDialog(PanDBconfiguration.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
                dbFunction.saveDatabaseToFile(file.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_exportToOtherMachineButtonMouseClicked

    private void importFromOtherMachineButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importFromOtherMachineButtonMouseClicked
        // TODO add your handling code here:
        int returnVal = fc.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                ReadObjectInFile ro=new ReadObjectInFile();
                ro.setFileName(file.getPath());
                ro.openFile();
                ExportableAndImportableDatabase databaseToBeImported= (ExportableAndImportableDatabase) ro.readRecords();
                if(dbFunction!=null){
                    dbFunction.importDatabase(databaseToBeImported);
                }
//                this.jTable1.repaint();
                //This is where a real application would open the file.
//                log.append("Opening: " + file.getName() + "." + newline);
            } else {
//                log.append("Open command cancelled by user." + newline);
            }
        
    }//GEN-LAST:event_importFromOtherMachineButtonMouseClicked

    private void selectAllCategoriesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectAllCategoriesButtonMouseClicked
        // TODO add your handling code here:
        markAll(categoriesTable, true);
    }//GEN-LAST:event_selectAllCategoriesButtonMouseClicked

    private void unselectAllCategoriesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unselectAllCategoriesButtonMouseClicked
        // TODO add your handling code here:
        markAll(categoriesTable, false);
    }//GEN-LAST:event_unselectAllCategoriesButtonMouseClicked

    private void selectAllUserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectAllUserButtonMouseClicked
        // TODO add your handling code here:
        markAll(usersTable, true);
    }//GEN-LAST:event_selectAllUserButtonMouseClicked

    private void unselectAllUsersButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unselectAllUsersButtonMouseClicked
        // TODO add your handling code here:
        markAll(usersTable, false);
    }//GEN-LAST:event_unselectAllUsersButtonMouseClicked

    private void maxExpressionSizeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_maxExpressionSizeSpinnerStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_maxExpressionSizeSpinnerStateChanged

    private void exportToXMLButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportToXMLButtonMouseClicked
        // TODO add your handling code here:
        Exporter exporter= null;
        if(onlySymnolsCheckBox.isSelected())
            exporter = new SymbolExporter();
        else
            exporter= new Exporter();
        if(filterByUser()){
            exporter.setFilterByUserNickName(true);
            ArrayList<String> selectedUsers = getSelectedUsers();
            exporter.setUserNickNames(selectedUsers);
        }
        if(filterByCategory()){
            exporter.setFilterByCategory(true);
            ArrayList<String> selectedCategories = getSelectedCategories();
            exporter.setCategories(selectedCategories);
        }
        if(expressionSizeCheckBox.isSelected()){
            exporter.setFilterByExpressionSize(true);
            exporter.setMinSizeOfExpression((Integer)minExpressionSizeSpinner.getValue());
            exporter.setMaxSizeOfExpression((Integer)maxExpressionSizeSpinner.getValue());
        }
        if(selectModelsCheckBox.isSelected())
            exporter.setIncludeModels(true);
        exporter.exportDatasetToInkML();
    }//GEN-LAST:event_exportToXMLButtonMouseClicked

    private boolean filterByUser(){
        boolean filterByUser = false;
        int i;
        for(i = 0; i < usersTable.getRowCount(); i++){
            if(!(Boolean) usersTable.getValueAt(i, SELECTION_COLUMN)){
                filterByUser = true;
                break;
            }
        }
        return filterByUser;
    }

    private ArrayList<String> getSelectedUsers(){
        ArrayList<String> selectedUsers = new ArrayList<String>();
        int i;
        for(i = 0; i < usersTable.getRowCount(); i++){
            if((Boolean) usersTable.getValueAt(i, SELECTION_COLUMN))
                selectedUsers.add((String) usersTable.getValueAt(i,
                        DATA_COLUMN));
        }
        return selectedUsers;
    }

    private boolean filterByCategory(){
        boolean filterByCategory = false;
        int i;
        for(i = 0; i < categoriesTable.getRowCount(); i++){
            if(!(Boolean) categoriesTable.getValueAt(i, SELECTION_COLUMN)){
                filterByCategory = true;
                break;
            }
        }
        return filterByCategory;
    }

    private ArrayList<String> getSelectedCategories(){
        ArrayList<String> selectedCategories = new ArrayList<String>();
        int i;
        for(i = 0; i < categoriesTable.getRowCount(); i++){
            if((Boolean) categoriesTable.getValueAt(i, SELECTION_COLUMN))
                selectedCategories.add((String) categoriesTable.getValueAt(i,
                        DATA_COLUMN));
        }
        return selectedCategories;
    }

    public void chargeCategoriesAndUsers(Object[][] categoryNames,
            Object[][] userNickNames){
            MyTableModel categoryTableModel = new MyTableModel(categoryTableTitles,
                    categoryNames);
            categoriesTable.setModel(categoryTableModel);

            MyTableModel userTableModel = new MyTableModel(userTableTitles,
                    userNickNames);
            usersTable.setModel(userTableModel);
    }

    private void markAll(JTable table, Boolean flag){
        int i;
        for (i = 0; i < table.getModel().getRowCount();i++) {
            table.setValueAt(flag, i, SELECTION_COLUMN);
        }
        table.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager MathExpressionsPUEntityManager;
    private javax.swing.JTable categoriesTable;
    private java.util.List<GUIs.Emuser> emuserList;
    private javax.persistence.Query emuserQuery;
    private javax.swing.JButton exportToOtherMachineButton;
    private javax.swing.JButton exportToXMLButton;
    private javax.swing.JCheckBox expressionSizeCheckBox;
    private javax.swing.JButton importFromOtherMachineButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSpinner maxExpressionSizeSpinner;
    private javax.swing.JSpinner minExpressionSizeSpinner;
    private javax.swing.JCheckBox onlySymnolsCheckBox;
    private javax.swing.JButton selectAllCategoriesButton;
    private javax.swing.JButton selectAllUserButton;
    private javax.swing.JCheckBox selectModelsCheckBox;
    private javax.swing.JButton unselectAllCategoriesButton;
    private javax.swing.JButton unselectAllUsersButton;
    private GUIs.UserAdministrator userAdministrator1;
    private javax.swing.JTable usersTable;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public void stateChanged(ChangeEvent ce) {
        if(ce.getSource() == maxExpressionSizeSpinner){
            int currentMinSizeValue = (Integer)maxExpressionSizeSpinner.getValue();
            if(currentMinSizeValue < (Integer) minExpressionSizeSpinner.getValue())
                maxExpressionSizeSpinner.setValue(minExpressionSizeSpinner.getValue());
        }
        else if(ce.getSource() == minExpressionSizeSpinner){
            int currentMaxSizeValue = (Integer)minExpressionSizeSpinner.getValue();
            if(currentMaxSizeValue > (Integer) maxExpressionSizeSpinner.getValue())
                minExpressionSizeSpinner.setValue(maxExpressionSizeSpinner.getValue());
        }
    }
}
