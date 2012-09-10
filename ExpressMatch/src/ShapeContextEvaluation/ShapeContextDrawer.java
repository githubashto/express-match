/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ShapeContextEvaluation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author frank
 */
public class ShapeContextDrawer {
    private Point2D[] shape;

    private float[] angles;

    private float[] radios;

    private Point2D center;

    private int radio;

    private Color shapeColor=Color.BLACK;

    private Color centerColor=Color.RED;

    private Color colorCortes=Color.LIGHT_GRAY;




    public void draw(Graphics2D g){
        //draw shape
        Color c=g.getColor();
        Stroke stroke=g.getStroke();
        g.setColor(colorCortes);
//        float dash[] = { 0.5f };
//        g.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_ROUND,
//        BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
        drawAngleCuts(g);
        drawRadioCuts(g);

//        g.setStroke(stroke);
        g.setColor(c);
        drawShape(g);
        drawCenter(g);
    }

    public void drawCenter(Graphics2D g){
        Color c=g.getColor();
        g.setColor(centerColor);
        drawPoint(g, (int)center.getX(), (int)center.getY());
        g.setColor(c);
    }

    public void drawShape(Graphics2D g){
        Color c=g.getColor();
        g.setColor(shapeColor);
        for (Point2D point2D : shape) {
            drawPoint(g,(int)point2D.getX(), (int)point2D.getY());
        }
        g.setColor(c);
    }

    public void drawRadioCuts(Graphics2D g){
        for (float radio : radios) {
            g.drawOval((int)(center.getX()-radio), (int)(center.getY()-radio),
                    (int)(radio*2),(int) (radio*2));
        }
    }

    public void drawPoint(Graphics2D g,int x,int y){
//        g.drawOval(x-1, y-1, 2, 2);
        g.fillOval(x-1,y-1, 3, 3);
    }

    public void drawAngleCuts(Graphics2D g){
        for (float angle : angles) {
            Line2D line=getLine(angle);
            g.draw(line);
        }
    }

    public Line2D getLine(float angle){
        int x1,x2,y1,y2;

        x1=(int)(center.getX());
        x2=(int)(center.getX()+ radio*Math.cos(angle));
        y1=(int)(center.getY());
        y2=(int)(center.getY()- radio*Math.sin(angle));

        Line2D l=new Line2D.Float(x1, y1, x2, y2);
        return l;
    }

    public float[] getAngles() {
        return angles;
    }

    public void setAngles(float[] angles) {
        this.angles = angles;
    }

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public float[] getRadios() {
        return radios;
    }

    public void setRadios(float[] radios) {
        this.radios = radios;
    }

    public Point2D[] getShape() {
        return shape;
    }

    public void setShape(Point2D[] shape) {
        this.shape = shape;
    }

    public Color getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }


}
