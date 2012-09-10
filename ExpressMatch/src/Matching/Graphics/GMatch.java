/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matching.Graphics;

import MathExpression.Graphics.GSymbol;
import Util.GObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author frank.aguilar
 */
public final class GMatch extends GObject{

    private GSymbol s1;
    private GSymbol s2;

    private int posS1;

    private int posS2;
    
    public boolean highLightMatching;

    public boolean highLightEnds;

    private static final int radioOfHighlightedEnd=12;

    private Point2D temporalPoint;

    private int temporalPointPosition;

    public static final int NO_POSITION=0;

    public static final int POSITION_S1=1;

    public static final int POSITION_S2=2;

    public GMatch(GSymbol s1, GSymbol s2) {
        this.s1 = s1;
        this.s2 = s2;
        this.highLightMatching = false;
        highLightEnds=false;
        s1.setgMatch(this);
        s2.setgMatch(this);
        this.setTemporalPointPosition(NO_POSITION);
    }
    
    @Override
    public void draw(Graphics g) {
        if(this.highLightMatching){
            this.highLightMatch(g);
        }
        drawSymbols(g);
        Graphics2D g2D =(Graphics2D)g;
        g2D.draw(this.toLine2D());
        if(this.highLightEnds)
            this.highLightEnds(g2D);
        if(this.highLightMatching){
            this.restaurateLastGraphicsState();
        }
    }

    public void drawLine(Graphics g) {
        if(this.highLightMatching){
            this.highLightMatch(g);
        }
        Graphics2D g2D =(Graphics2D)g;
        //this.configureGraphics(g);
        Color tempC=g2D.getColor();
        g2D.setColor(this.getColor());
        g2D.draw(this.toLine2D());
        
        //this.restaurateLastGraphicsState();
        if(this.highLightEnds)
            this.highLightEnds(g2D);
        g2D.setColor(tempC);
        if(this.highLightMatching){
            this.restaurateLastGraphicsState();
        }
    }

    public void drawSymbols(Graphics g){
        Color tempColor=g.getColor();
        g.setColor(Color.DARK_GRAY);
        if(this.highLightMatching){
            this.s1.setDrawnWithBBox(true);
            this.s2.setDrawnWithBBox(true);
        }
        s1.drawSymbol(g);
        s2.drawSymbol(g);
        if(this.highLightMatching){
            this.s1.setDrawnWithBBox(false);
            this.s2.setDrawnWithBBox(false);
        }
        g.setColor(tempColor);
    }

    public void highLightMatch(Graphics g){
        this.stroke=GObject.HIGHLIGHTED_STROKE;
       // this.s1.setDrawnWithBBox(true);
       // this.s2.setDrawnWithBBox(true);
        this.configureGraphics(g);
    }

    @Override
    public void restaurateLastGraphicsState(){
        super.restaurateLastGraphicsState();
        this.s1.setDrawnWithBBox(false);
        this.s2.setDrawnWithBBox(false);
    }

    public void highLightEnds(Graphics2D g2D){
        Line2D line=this.toLine2D();
        Point2D p1=line.getP1();
        Point2D p2=line.getP2();
        int initialX=(int)(p1.getX()-radioOfHighlightedEnd/2.);
        int initialY=(int)(p1.getY()-radioOfHighlightedEnd/2.);
        g2D.drawOval(initialX, initialY, radioOfHighlightedEnd,
                radioOfHighlightedEnd);
        g2D.fillOval(initialX, initialY, radioOfHighlightedEnd,
                radioOfHighlightedEnd);
        initialX=(int)(p2.getX()-radioOfHighlightedEnd/2.);
        initialY=(int)(p2.getY()-radioOfHighlightedEnd/2.);
        g2D.drawOval(initialX, initialY, radioOfHighlightedEnd,
                radioOfHighlightedEnd);
        g2D.fillOval(initialX, initialY, radioOfHighlightedEnd,
                radioOfHighlightedEnd);
    }

//    public boolean nearFromEnds(Point2D p){
//        Line2D line = this.toLine2D();
//        Point2D p1=line.getP1();
//        Point2D p2=line.getP2();
//
//        if(p1.distance(p)<this.radioOfHighlightedEnd||
//                p2.distance(p)<this.radioOfHighlightedEnd)
//            return true;
//        return false;
//    }

    public Point2D nearFromEnds(Point2D p){
        Point2D pNear=null;
        Line2D line = this.line2DFromGSymbols();
        Point2D p1=line.getP1();
        Point2D p2=line.getP2();
        if(p1.distance(p)<radioOfHighlightedEnd)
            pNear=p1;
        if(p2.distance(p)<radioOfHighlightedEnd&&
                p2.distance(p)<p1.distance(p))
            pNear=p2;
        return pNear;
    }

    public int nearestEnd(Point2D p){
        int pNear=NO_POSITION;
        Line2D line = this.line2DFromGSymbols();
        Point2D p1=line.getP1();
        Point2D p2=line.getP2();
        if(p1.distance(p)<radioOfHighlightedEnd)
            pNear=POSITION_S1;
        if(p2.distance(p)<radioOfHighlightedEnd&&
                p2.distance(p)<p1.distance(p))
            pNear=POSITION_S2;
        return pNear;
    }

    public Line2D line2DFromGSymbols(){
        Line2D l=null;
        Point2D p1=null,p2=null;

        p2=s2.getCenterOfBBoc();
        p1=s1.getCenterOfBBoc();
        l=new Line2D.Double(p1,p2);
        return l;
    }

    public Line2D toLine2D(){
        Line2D l=null;
        Point2D p1=null,p2=null;
        if(this.temporalPointPosition==POSITION_S1){
            p1=this.temporalPoint;
            p2=s2.getCenterOfBBoc();
        }
        else if(this.temporalPointPosition==POSITION_S2){
            p1=s1.getCenterOfBBoc();
            p2=this.temporalPoint;
        }
        else if(this.temporalPointPosition==NO_POSITION){
            p1=s1.getCenterOfBBoc();
            p2=s2.getCenterOfBBoc();
        }
        l=new Line2D.Double(p1,p2);
        return l;
    }

//    public void interchangeSymbolPositions(GMatch gm,int posGM,int myPosSymbol){
//        int myTempPos=this.getPosGSymgol(myPosSymbol);
//        this.setPosSymbol(myPosSymbol, gm.getPosGSymgol(posGM));
//        gm.setPosSymbol(posGM, myTempPos);
//    }

    public int getPosGSymgol(int postion){
        if(postion==POSITION_S1){
            return this.getPosS1();
        }
        else if(postion==POSITION_S2){
            return  this.getPosS2();
        }
        return -1;
    }

    public void setPosSymbol(int indexOfSymbol,int pos){
        if(indexOfSymbol==POSITION_S1){
             this.setPosS1(pos);
        }
        else if(indexOfSymbol==POSITION_S2){
            this.setPosS2(pos);
        }
    }

    public GSymbol getGSymgol(int postion){
        if(postion==POSITION_S1){
            return this.s1;
        }
        else if(postion==POSITION_S2){
            return  this.s2;
        }
        return null;
    }

    public void setGSymgolAt(int postion, GSymbol s){
        if(postion==POSITION_S1){
             this.s1=s;
        }
        else if(postion==POSITION_S2){
            this.s2=s;
        }
    }

    public int getPosS1() {
        return posS1;
    }

    public void setPosS1(int posS1) {
        this.posS1 = posS1;
    }

    public int getPosS2() {
        return posS2;
    }

    public void setPosS2(int posS2) {
        this.posS2 = posS2;
    }

    public boolean isHighLightEnds() {
        return highLightEnds;
    }

    public void setHighLightEnds(boolean highLightEnds) {
        this.highLightEnds = highLightEnds;
    }

    public boolean isHighLightLine() {
        return highLightMatching;
    }

    public void setHighLightLine(boolean highLightLine) {
        this.highLightMatching = highLightLine;
    }

    public Point2D getP() {
        return temporalPoint;
    }

    public void setP(Point2D p) {
        this.temporalPoint = p;
    }

    public int getTemporalPointPosition() {
        return temporalPointPosition;
    }

    public void setTemporalPointPosition(int temporalPointPosition) {
        this.temporalPointPosition = temporalPointPosition;
    }
}
