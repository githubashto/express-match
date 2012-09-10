/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Matching.Graphics;

import MathExpression.Graphics.GMathExpression;
import MathExpression.Graphics.GSymbol;
import Util.GObject;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author frank
 */
public class GMatching extends GObject{

    private int typeOfDrawing;
    
    private int selectedGroup;
    
    public static final int DRAW_COMPLETE_MATCHING=0;
    public static final int DRAW_ONE_GROUP=1;
    
    private ArrayList<GMatch> aListOfMatches;

    private ArrayList< ArrayList<GMatch>> groups;

//    protected static Color[] colors=new Color[]{Color.BLUE,
//                        Color.GREEN,Color.ORANGE,Color.PINK,Color.RED,
//                        Color.YELLOW,Color.CYAN};

    protected static Color[] colors=new Color[]{Color.DARK_GRAY,
                        Color.DARK_GRAY,Color.DARK_GRAY,Color.PINK,Color.RED,
                        Color.YELLOW,Color.CYAN};

    protected static final double minDistanceBetwenEndOfMatchs=30;

    public GMatching(GMathExpression e1, GMathExpression e2, 
            int[][] match) {

        this.typeOfDrawing=GMatching.DRAW_COMPLETE_MATCHING;
        this.selectedGroup=0;
        this.setaListOfMatches( GMatching.formAListMatches(e1, e2, match));
        groups=GMatching.groupInNotCrossingLines((ArrayList<GMatch>) aListOfMatches.clone());
        setColors();
    }

    public void setColors(){
         int index=0;
         for (ArrayList<GMatch> groupOfLines: groups) {
             Color c=GMatching.determineColor(index++);
             for (GMatch gMatch : groupOfLines) {
                 gMatch.setColor(c);
             }
         }
    }

    public int[][] getMatchingMatrix(){
        int[][] mm=new int[aListOfMatches.size()][2];
        int i=0;
        for (GMatch gm : aListOfMatches) {
            mm[i][0]=gm.getPosS1();
            mm[i][1]=gm.getPosS2();
            i++;
        }
        return mm;
    }
    public static ArrayList<GMatch> formAListMatches(GMathExpression e1,
            GMathExpression e2, int[][] match){
        ArrayList<GMatch> listOfMatches=new ArrayList<GMatch>();
        GSymbol gs1=null, gs2=null;
        Point2D p1=null,p2=null;
        for (int i = 0; i < match.length; i++) {
             /*gs1=(GSymbol) e1.get(Integer.valueOf(match[i][0]));
             gs2=(GSymbol) e2.get(Integer.valueOf(match[i][1]));*/
            gs1=(GSymbol) e1.get(Integer.valueOf(match[i][0]));
             gs2=(GSymbol) e2.get(Integer.valueOf(match[i][1]));
             GMatch gm=new GMatch(gs1,gs2);
             gm.setPosS1(match[i][0]);
             gm.setPosS2(match[i][1]);
             listOfMatches.add(gm);
         }
        return listOfMatches;
    }

    @Override
    public void draw(Graphics g) {

        this.drawSymbols(g);
        if(this.typeOfDrawing==GMatching.DRAW_COMPLETE_MATCHING)
            this.drawLinesInColoredGroups(g);
        else if(this.typeOfDrawing==GMatching.DRAW_ONE_GROUP){
           // this.color=GMatching.determineColor(this.selectedGroup);
            //this.configureGraphics(g);
            this.drawLines(groups.get(this.selectedGroup), g);
//            for (int i=0;i<groups.size();i++) {
//                if(i!=selectedGroup){
//                    ArrayList<GMatch> group=groups.get(i);
//                    for (int j = 0; j < group.size(); j++) {
//                        group.get(j).getGSymgol(GMatch.POSITION_S1).drawSymbol(g);
//                        group.get(j).getGSymgol(GMatch.POSITION_S2).drawSymbol(g);
//                    }
//                }
//            }
          //  this.restaurateLastGraphicsState();
            
        }
    }

    private void drawSymbols(Graphics g){
        for (int i=0;i<groups.size();i++) {
                ArrayList<GMatch> group=groups.get(i);
                for (int j = 0; j < group.size(); j++) {
                    group.get(j).drawSymbols(g);
                }

            }
    }

    public GMatch contemPoint(Point2D p){
        GMatch gM=null;
        double distMin=Double.MAX_VALUE;
        for (GMatch gMatch : aListOfMatches) {
            Point2D tempP=null;
            tempP=gMatch.nearFromEnds(p);
            if(tempP!=null&&tempP.distance(p)<distMin){
                gM=gMatch;
                distMin=tempP.distance(p);
            }
        }
        return gM;
    }

    public static Color determineColor(int i){
        int numberOfColors=colors.length;
        int actualPossition=i%numberOfColors;
        Color c=colors[actualPossition];
        return c;
    }

    public void drawLinesInColoredGroups(Graphics g){
         
         int index=0;
         for (ArrayList<GMatch> groupOfLines: groups) {
            // this.color=GMatching.determineColor(index);
             //this.configureGraphics(g);
             //this.setLineColor(GMatching.determineColor(index));
             //index++;
             this.drawLines(groupOfLines, g);

             //this.restaurateLastGraphicsState();
         }
         
     }

     public void drawLines(ArrayList<GMatch> lines, Graphics g){
         Graphics2D g2D=(Graphics2D) g;
         Stroke str=g2D.getStroke();
         g2D.setStroke(new BasicStroke(1.8f));
         for (GMatch line: lines) {
             line.drawLine(g);
         }
         g2D.setStroke(str);
     }
  
     /****************/
     public static ArrayList<ArrayList<GMatch>> groupInNotCrossingLines(
            ArrayList<GMatch> alML){
        ArrayList<ArrayList<GMatch>> groups=new ArrayList<ArrayList<GMatch>>();

        while(!alML.isEmpty()){
            ArrayList<GMatch> newGroup= new ArrayList<GMatch>();
            for (GMatch line : alML) {
                if(!intersectsGroup(newGroup,line)&&!tooClose(newGroup, line)){
                    newGroup.add(line);
                }
            }
            for (GMatch matchingLine : newGroup) {
                alML.remove(matchingLine);
            }
            if(newGroup.isEmpty()){
                groups.add(alML);
                break;
            }
            groups.add(newGroup);
        }

        return groups;
    }

    public static boolean intersectsGroup(ArrayList<GMatch> newGroup,GMatch l){
        for (GMatch matchingLine : newGroup) {
            if(l.toLine2D().intersectsLine(matchingLine.toLine2D()))
                    return true;
        }
        return false;

    }

    public static boolean tooClose(ArrayList<GMatch> newGroup,GMatch l){
        Point2D p1L=l.toLine2D().getP1();
        Point2D p2L=l.toLine2D().getP2();

        Point2D p1Match=null;
        Point2D p2Match=null;

        for (GMatch matchingLine : newGroup) {
            p1Match=matchingLine.toLine2D().getP1();
            p2Match=matchingLine.toLine2D().getP2();
            if(p1L.distance(p1Match)<minDistanceBetwenEndOfMatchs||
                    p2L.distance(p1Match)<minDistanceBetwenEndOfMatchs||
                    p1L.distance(p2Match)<minDistanceBetwenEndOfMatchs||
                    p2L.distance(p2Match)<minDistanceBetwenEndOfMatchs)
                    return true;
        }
        return false;

    }

     /***************/

     
     public int getNumerOfGroups(){
         return this.groups.size();
     }

    public int getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(int selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public int getTypeOfDrawing() {
        return typeOfDrawing;
    }

    public void setTypeOfDrawing(int typeOfDrawing) {
        this.typeOfDrawing = typeOfDrawing;
    }

    public ArrayList<GMatch> getaListOfMatches() {
        return aListOfMatches;
    }

    public void setaListOfMatches(ArrayList<GMatch> aListOfMatches) {
        this.aListOfMatches = aListOfMatches;
    }
}
