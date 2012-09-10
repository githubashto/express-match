/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ShapeContextEvaluation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author frank
 */
public class ShapeContextMatchingDrawer {
    private Point2D[] shape1;

    private Point2D[] shape2;

    private int[][] matching;

    private Color shape1Color=Color.BLUE;

    private Color shape2Color=Color.RED;

    public void draw(Graphics2D g){
        drawShape(shape1,shape1Color,g);
        drawShape(shape2,shape2Color,g);
        drawMatching(g);
    }

    private void drawShape(Point2D[] shape, Color shapeColor,Graphics2D g) {
        Color c=g.getColor();
        g.setColor(shapeColor);
        for (Point2D point2D : shape) {
            drawPoint(g, (int)point2D.getX(), (int)point2D.getY());
        }
        g.setColor(c);
    }

    public void drawPoint(Graphics2D g,int x,int y){
        g.drawOval(x-1, y-1, 3, 3);
        g.fillOval(x-1,y-1, 3, 3);
    }

    private void drawMatching(Graphics2D g) {
        for (int i = 0; i < matching.length; i++) {
            Point2D p1 = shape1[matching[i][0]];
            Point2D p2 = shape2[matching[i][1]];
            g.draw(new Line2D.Double(p1,p2));
        }
    }
    public int[][] getMatching() {
        return matching;
    }

    public void setMatching(int[][] matching) {
        this.matching = matching;
    }

    public Point2D[] getShape1() {
        return shape1;
    }

    public void setShape1(Point2D[] shape1) {
        this.shape1 = shape1;
    }

    public Point2D[] getShape2() {
        return shape2;
    }

    public void setShape2(Point2D[] shape2) {
        this.shape2 = shape2;
    }

    



}
