/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import java.awt.Dimension;
import java.awt.geom.Point2D;

/**
 *
 * @author frank
 */
public class Scale {
    private double horizontalScale;

    private double verticalScale;

    private Dimension content;

    private Dimension container;

    private static final int NOT_CHANGE_SCALE=1;

    public static Scale ScaleFromDimensions(Dimension content,Dimension container){
        Scale scale=new Scale();
        scale.setContainer(container);
        scale.setContent(content);
        return scale;
    }

    /**
     * Scales the Dimension content to enter in the dimension of container
     * It is expected that container will have an area
     * greather than 0
     * @param img
     * @param r
     * @return
     */
    public void scale(){
        calculateScales();
        adjustToLowestRelationContainerContent();
    }

    private void calculateScales(){
        calculateHorizontalScale();
        calculateVerticalScale();
    }

    private void adjustToLowestRelationContainerContent(){
        if(isScaledHorizontally()&&isScaledVertically()){
            if(verticalScale>horizontalScale)
                verticalScale= horizontalScale;
             else
                horizontalScale=verticalScale;
        }
    }

    private void calculateHorizontalScale(){
        if(tooThin())
            horizontalScale=container.getWidth()/content.getWidth();
        else
            horizontalScale=NOT_CHANGE_SCALE;
    }

    private void calculateVerticalScale(){
        if(tooShort())
            verticalScale=container.getHeight()/content.getHeight();
        else
            verticalScale=NOT_CHANGE_SCALE;
    }

    private boolean isScaledHorizontally(){
        if(horizontalScale==NOT_CHANGE_SCALE)
            return false;
        return true;
    }

    private boolean isScaledVertically(){
        if(verticalScale==NOT_CHANGE_SCALE)
            return false;
        return true;
    }

    public boolean tooThin(){
        if(content.getWidth()>container.getWidth())
            return true;
        return false;
    }

    public boolean tooShort(){
        if(content.getHeight()>container.getHeight())
            return true;
        return false;
    }

    /**
     * Calculates the central position in wich must be content inside the container
     * @param content
     * @param container
     * @return central position
     */
    public Point2D calculateScaledCentralPosition(){
        double XPosition=Math.max(0.,(container.getWidth()-content.getWidth()*horizontalScale)/2.);
        double YPosition=Math.max(0,(container.getHeight()-content.getHeight()*verticalScale)/2.);
        Point2D position=new Point2D.Double(XPosition,YPosition);
        return position;
    }

    public Dimension getContainer() {
        return container;
    }

    public void setContainer(Dimension container) {
        this.container = container;
    }

    public Dimension getContent() {
        return content;
    }

    public void setContent(Dimension content) {
        this.content = content;
    }

    public double getHorizontalScale() {
        return horizontalScale;
    }

    public void setHorizontalScale(double horizontalScale) {
        this.horizontalScale = horizontalScale;
    }

    public double getVerticalScale() {
        return verticalScale;
    }

    public void setVerticalScale(double verticalScale) {
        this.verticalScale = verticalScale;
    }
}
