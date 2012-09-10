/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanMatching.java
 *
 * Created on 14-jul-2011, 20:56:02
 */

package GUIs.Matching;

import GUIs.PanLabeling;
import Matching.Graphics.GMatch;
import Matching.Graphics.GMatching;
import MathExpression.Data.DSymbol;
import MathExpression.Graphics.GMathExpression;
import MathExpression.Graphics.GSymbol;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

/**
 *
 * @author frank
 */
public class PanMatching extends javax.swing.JPanel {

    protected JPanel panManagerOfUserExpression;

    /**
     * input expression
     */
    private GMathExpression gMathExpressionInput;

    /**
     * Model expression
     */
    private GMathExpression gMathExpressionModel;

    private int[][] match;
    
    private GMatching matchingDrawer;
    
    private boolean thereIsASelectedSymbol;
    
    private DSymbol[] selectedSymbols; 
    
    private Point2D initialMovingPoint;
    
    private int posSymbolMoving;
    
    private GMathExpression expressionWithMovingsymbol;

    private boolean existSelectedMatch;
    private GMatch selectedMatch;

    private GSymbol gSymbolToChange;

    private int posOfGSymbolToChange;

    public static final int gapFromTopOfPanel=20;
//    private static final int gapFromTopOfPanel=300;

    public static final int gapFromLeftOfPanel=20;

    private static final int verticalGapBetwenExpressions=50;

    private int typeOfDrawing;

    public static final int TYPE_DRAWING_JUST_MODEL_EXPR=0;

    public static final int TYPE_DRAWING_JUST_MATCHING=1;
    /** Creates new form PanMatching */
    public PanMatching() {
        initComponents();
        this.match=null;
        gMathExpressionInput=null;
        gMathExpressionModel=null;
        matchingDrawer=null;
        thereIsASelectedSymbol=false;
        selectedSymbols=new DSymbol[2];
        expressionWithMovingsymbol=null;
        posSymbolMoving=-1;
        existSelectedMatch=false;
        typeOfDrawing=TYPE_DRAWING_JUST_MATCHING;
        panManagerOfUserExpression=null;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 314, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        if(this.isSetUpMatching()){
            Point2D p=evt.getPoint();
            int posSelectedSymbol=gMathExpressionModel.containsPoint(p);
            if(posSelectedSymbol!=-1){
                if(!this.thereIsASelectedSymbol){
                    selectedSymbols[0]=gMathExpressionModel.get(posSelectedSymbol);

                    ((GSymbol)selectedSymbols[0]).getgMatch().setHighLightLine(true);
                    this.repaint();
                    thereIsASelectedSymbol=true;
                }else {
                    DSymbol tempGSymbl=gMathExpressionModel.get(posSelectedSymbol);
                    if(tempGSymbl!=selectedSymbols[0]){
                        ((GSymbol)selectedSymbols[0]).getgMatch().setHighLightLine(false);
                        selectedSymbols[0]=gMathExpressionModel.get(posSelectedSymbol);
                        ((GSymbol)selectedSymbols[0]).getgMatch().setHighLightLine(true);
                        this.repaint();
                    }
                }
            }
            if(posSelectedSymbol==-1){
                posSelectedSymbol=gMathExpressionInput.containsPoint(p);
                if(posSelectedSymbol!=-1){
                    if(!this.thereIsASelectedSymbol){
                        selectedSymbols[0]=gMathExpressionInput.get(posSelectedSymbol);

                        ((GSymbol)selectedSymbols[0]).getgMatch().setHighLightLine(true);
                        this.repaint();
                        thereIsASelectedSymbol=true;
                    }else {
                        DSymbol tempGSymbl=gMathExpressionInput.get(posSelectedSymbol);
                        if(tempGSymbl!=selectedSymbols[0]){
                            ((GSymbol)selectedSymbols[0]).getgMatch().setHighLightLine(false);
                            selectedSymbols[0]=gMathExpressionInput.get(posSelectedSymbol);
                            ((GSymbol)selectedSymbols[0]).getgMatch().setHighLightLine(true);
                            this.repaint();
                        }
                    }
                }
            }

            if(posSelectedSymbol==-1&&thereIsASelectedSymbol){
                    thereIsASelectedSymbol=false;
                    ((GSymbol)selectedSymbols[0]).getgMatch().setHighLightLine(false);
                    this.repaint();
            }

            GMatch gMatchTemp=this.matchingDrawer.contemPoint(p);
            if(gMatchTemp!=null){
                if(!existSelectedMatch){
                    this.existSelectedMatch=true;
                    selectedMatch=gMatchTemp;
                    selectedMatch.setHighLightEnds(true);
                    this.repaint();
                }else if(gMatchTemp!=selectedMatch){
                    selectedMatch.setHighLightEnds(false);

                    selectedMatch=gMatchTemp;
                    selectedMatch.setHighLightEnds(true);
                    this.repaint();
                }
            }
            else if(this.existSelectedMatch)
            {
                this.existSelectedMatch=false;
                selectedMatch.setHighLightEnds(false);
                this.repaint();
            }
        }

    }//GEN-LAST:event_formMouseMoved

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        if(this.isSetUpMatching()){
            Point2D p=evt.getPoint();
            this.initialMovingPoint=p;
            posSymbolMoving=gMathExpressionModel.containsPoint(p);
            if(posSymbolMoving!=-1){
                expressionWithMovingsymbol=gMathExpressionModel;
            }
            else if(posSymbolMoving==-1){
                posSymbolMoving=gMathExpressionInput.containsPoint(p);
                if(posSymbolMoving!=-1)
                    expressionWithMovingsymbol=gMathExpressionInput;
            }
            else{
                expressionWithMovingsymbol=null;
            }
            if(this.existSelectedMatch){
                Point2D pEndMoving = new Point.Double();
                pEndMoving.setLocation(p);
                this.selectedMatch.setP(p);
                int nearestEnd=this.selectedMatch.nearestEnd(p);
                this.selectedMatch.setTemporalPointPosition(nearestEnd);
                gSymbolToChange=selectedMatch.getGSymgol(nearestEnd);
                posOfGSymbolToChange=nearestEnd;
            }
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        if(isSetUpMatching()){
            Point2D p=evt.getPoint();
            if(this.existSelectedMatch){
                    this.selectedMatch.setP(p);
                    initialMovingPoint=p;
                    this.repaint();
            }
            else if(initialMovingPoint!=null&&!p.equals(initialMovingPoint)
                    &&this.expressionWithMovingsymbol!=null
                    &&posSymbolMoving!=-1){
                double dx=p.getX()-initialMovingPoint.getX();
                double dy=p.getY()-initialMovingPoint.getY();
                expressionWithMovingsymbol.traslateSymbol(posSymbolMoving, dx, dy);

                this.repaint();
                initialMovingPoint=p;
            }
        }
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        if(this.existSelectedMatch){
            Point2D p=evt.getPoint();
            GMatch newSelectedMatch=this.matchingDrawer.contemPoint(p);
            if(newSelectedMatch!=null){
                int nearestEnd=newSelectedMatch.nearestEnd(p);
                GSymbol s=newSelectedMatch.getGSymgol(nearestEnd);
                this.selectedMatch.setGSymgolAt(this.posOfGSymbolToChange, s);
                s.setgMatch(selectedMatch);
                newSelectedMatch.setGSymgolAt(nearestEnd,this.gSymbolToChange);
//                selectedMatch.interchangeSymbolPositions(newSelectedMatch, nearestEnd, this.posOfGSymbolToChange);
                int tempPos=selectedMatch.getPosGSymgol(this.posOfGSymbolToChange);
                selectedMatch.setPosSymbol(posOfGSymbolToChange,newSelectedMatch.getPosGSymgol(nearestEnd));
                newSelectedMatch.setPosSymbol(nearestEnd, tempPos);
                
                gSymbolToChange.setgMatch(newSelectedMatch);
                this.updateMatching(matchingDrawer.getMatchingMatrix());
            }
            this.selectedMatch.setTemporalPointPosition(GMatch.NO_POSITION);
            this.repaint();
        }
    }//GEN-LAST:event_formMouseReleased
        
    public int[][] getMatchingMatrix(){
        return this.matchingDrawer.getMatchingMatrix();
    }

    public void updateMatching(int[][] newMatching){
        ((PanLabeling)this.panManagerOfUserExpression).updateMatching(newMatching);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(this.typeOfDrawing==TYPE_DRAWING_JUST_MODEL_EXPR&&
                gMathExpressionModel!=null&&!gMathExpressionModel.isEmpty())
            gMathExpressionModel.drawGMathExpression(g);
        if(this.typeOfDrawing == TYPE_DRAWING_JUST_MATCHING&&
                matchingDrawer!=null)
            matchingDrawer.draw(g);
    }

    public void clearPanel(){
        matchingDrawer=null;
        this.gMathExpressionInput=null;
        this.gMathExpressionModel=null;
        this.repaint();
    }

    public void setTypeOfDrawing(int type){
        this.typeOfDrawing=type;
    }
    public void locateModelExpression(){
        int dx=(int)(PanMatching.gapFromLeftOfPanel-gMathExpressionModel.getLtPoint().getX());
        int dy=(int)(PanMatching.gapFromTopOfPanel-gMathExpressionModel.getLtPoint().getY());
        this.gMathExpressionModel.translate(dx,
                dy);
    }

    public void locateInputExpression(){
        int dx=(int)(PanMatching.gapFromLeftOfPanel-gMathExpressionInput.getLtPoint().getX());
        int dy=(int)(PanMatching.gapFromTopOfPanel+gMathExpressionModel.getHeight()+
                PanMatching.verticalGapBetwenExpressions-gMathExpressionInput.getLtPoint().getY());
        gMathExpressionInput.translate(dx, dy);
    }

    public boolean isSetUpMatching(){
        if(matchingDrawer!=null&&gMathExpressionInput!=null
                &&gMathExpressionModel!=null){
            return true;
        }
        return false;
    }
    public int[][] getMatch() {
        return match;
    }

    public void setMatch(int[][] match) {
        this.match = match;
    }

    public GMathExpression getgMathExpressionInput() {
        return gMathExpressionInput;
    }

    public void setgMathExpressionInput(GMathExpression gMathExpressionInput) {
        this.gMathExpressionInput = gMathExpressionInput;
        gMathExpressionInput.showJustMathExpression();
        this.locateInputExpression();
    }

    public GMathExpression getgMathExpressionModel() {
        return gMathExpressionModel;
    }

    public void setgMathExpressionModel(GMathExpression gMathExpressionModel) {
        this.gMathExpressionModel = gMathExpressionModel;
//        gMathExpressionModel.showJustMathExpression();
        this.locateModelExpression();
    }
    
    public void setUpMatchingDrawer(){
        //int[][] matchInt=Util.stringToIntMatrix(match);
        this.matchingDrawer=new GMatching(gMathExpressionModel, gMathExpressionInput, match);
    }
    
    public void setSelectedGroup(int selectedGroup) {
        matchingDrawer.setSelectedGroup(selectedGroup);
    }

    public int getSelectedGroup() {
        return matchingDrawer.getSelectedGroup();
    }

    public int getNumerOfGroups() {
        return matchingDrawer.getNumerOfGroups();
    }

    public GMatching getMatchingDrawer() {
        return matchingDrawer;
    }

    public void setMatchingDrawer(GMatching matchingDrawer) {
        this.matchingDrawer = matchingDrawer;
    }
    public JPanel getPanManagerOfUserExpression() {
        return panManagerOfUserExpression;
    }

    public void setPanManagerOfUserExpression(JPanel panManagerOfUserExpression) {
        this.panManagerOfUserExpression = panManagerOfUserExpression;
    }

}