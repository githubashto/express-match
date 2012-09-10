/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FeatureExtractor;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import MathExpression.Data.DStroke;
import MathExpression.Data.DSymbol;
import MathExpression.Data.TimePoint;
import java.util.Collections;



/**
 * THIS CLASS COULD BE USED IN THE FUTURE TO EXTRACT FEATURES
 * THIS CLASS WILL CHANGE AS THE MATCHING ALGORITHMS COULD NEED IT
 * @author frank
 * This class implements the feature extractor described by Ernesto Tapia in his
 * doctorals thesis (Germany)
 */
public class FETapia {


    private static int maxNumberOfStrokes=3;
    public static int numberOfFeatures=63;

    /**THIS IS NOT USED YET
     * Returns the Smooth version of DStroke s. s is not modified
     * @param s
     */
    public static DStroke smooth(DStroke s){
        double [] coefficients={0.25,0.5,0.25};
        int center=1; //central possition of coefficients vector
        DStroke s2=new DStroke();
        
        double newX=0;
        double newY=0;
        s2.addCheckingBoundingBox(s.get(0));
        for(int i=1;i<(s.size()-1);i++){
            newX=0;
            newY=0;
            for(int j=-1;j<=1;j++){
                newX+=(s.get(i+j).getX()*coefficients[center+j]);
                newY+=(s.get(i+j).getY()*coefficients[center+j]);
            }
            TimePoint timePoint=new TimePoint(newX,newY, -1);
            s2.addCheckingBoundingBox(timePoint);
        }
        s2.addCheckingBoundingBox(s.get(s.size()-1));
        return s2;
    }

    /**
     * THIS IS NOT USED YET
     * Returns the Smooth version of DSymbol s. s is not modified
     * @param s
     */
    public static DSymbol smooth(DSymbol s){
        DSymbol s2=new DSymbol();
        for (DStroke stro : s) {
            s2.addCheckingBoundingBox(smooth(stro));
        }
        return s2;
    }


    /**
     * Calculates the turning angles of yhe points
     * as described by Tapia's Thesis
     * @param s
     * @return
     */
    public static double[] turningAngles(Point2D[] s){

        double[] tAngles=new double[2*(s.length-1)];

        for (int i=0;i<s.length-1;i++) {

            double dist=s[i].distance(s[i+1]);
            if(dist!=0){

                tAngles[i]=(s[i+1].getX()-s[i].getX())/dist;
                tAngles[s.length-1-i]=(s[i+1].getY()-s[i].getY())/dist;
            }
            else{
                tAngles[i]=Math.cos(Math.PI*2);
                tAngles[s.length-1-i]=Math.sin(Math.PI*2);
            }
        }
        return tAngles;
    }


    /**
     * it works ust when S.SIZE()>=N
     * @param s
     * @param N
     * @return
     */
    public static Point2D[] getNPoints(DStroke s,int N){
        Point2D[] points=new Point2D[N];
        if(s.size()>=N){
            double pos=0;
            double distance=(double)s.size()/N;
            for (int i = 0; i < points.length; i++) {
                points[i]=s.get((int)pos);
                pos+=distance;
            }

        }else{

           if(s.size()>1){
               Point2D[] pts=new Point2D[s.size()];
               int i=0;
                for (Point2D point2D : s) {
                    Point2D newP=new Point2D.Double();
                    newP.setLocation(point2D.getX(),point2D.getY());
                    pts[i++]=newP;
                }
                points=arcLengthResampling(pts, N);
           }
           else{
               for (int i = 0; i < N; i++) {
                   points[i]=new Point2D.Double(s.get(0).getX(), s.get(0).getY());
               }
           }
        }

        return points;
    }

    /**
     * NOT USED YET
     * @param s
     * @param m
     * @return
     */
    public static DSymbol arcLnegthResampling(DSymbol s, int m){
       DSymbol newS=new DSymbol();
       for(int i=0;i<s.size();i++){
           DStroke str=arcLnegthResampling(s.get(i), m);
           newS.addCheckingBoundingBox(str);
       }
       return newS;
    }

    /**
     * NOT USED YET
     * @param str
     * @param m
     * @return
     */
    public static DStroke arcLnegthResampling(DStroke str, int m){
        System.out.println("initial number of points of strok: "+str.size());

       DStroke s=new DStroke();
       Point2D[] pts=new Point2D[str.size()];
       int i=0;
        for (Point2D point2D : str) {
            Point2D newP=new Point2D.Double();
            newP.setLocation(point2D.getX(),point2D.getY());
            pts[i++]=newP;
        }

       Point2D[] newPts=arcLengthResampling(pts, m);
        for (Point2D point2D : newPts) {
            s.addCheckingBoundingBox(TimePoint.TimePointFromPoint2D(point2D));
        }


       return s;
    }

    /**
     * NOT USED YET
     * @param p
     * @param m
     * @return
     */
    public static Point2D[] arcLengthResampling(Point2D[] p, int m){
        Point2D[] newPoints=new Point2D[m];
        int k=0,i;
        newPoints[k]=p[0];
        newPoints[m-1]=p[p.length-1];
        double sum=0;//,sum2=0;
        double L=0;
        for (int j = 0; j < (p.length-1); j++) {
            L+=p[j+1].distance(p[j]);
        }
        int pos=1;
        Point2D newP=p[0];
        while(k<(p.length-1)&&pos<(m-1)){
            sum=p[k+1].distance(newP);
            //sum=p[k+1].distance(p[k]);
            for(i=k+1;i<(p.length-1);){
                if(sum>(double)L/(m-1)){
                    sum-=p[i+1].distance(p[i]);
                    k=i;
                    break;
                }
                i++;
                if(i<(p.length-1))
                    sum+=p[i+1].distance(p[i]);

            }
            newP=new Point2D.Double();
            double dist=Math.sqrt(L/(double)(p.length-1)-sum);
            newP.setLocation(p[k].getX()+dist,p[k].getY()+dist);
            newPoints[pos++]=newP;


        }
        //System.out.println("final : "+pos);

        return newPoints;
    }


    public static Point2D[] getNPoints(DSymbol s,int N){
        Point2D[] points=new Point2D[N];
        ArrayList<Point2D> alPoints=new ArrayList<Point2D>();
        int pointsPerStroke=(int) Math.round((double)N/s.size());
        int numStrokes=s.size();
        int total=0;

        for (int i = 0; i < (numStrokes-1); i++) {
            Point2D[] pts=getNPoints(s.get(i), pointsPerStroke);
            alPoints.addAll(Arrays.asList(pts));
            total+=pointsPerStroke;
        }

        int rest=N-total;
        Point2D[] pts=getNPoints(s.get(numStrokes-1), rest);
        alPoints.addAll(Arrays.asList(pts));

        for (int i = 0; i < points.length; i++) {
            points[i]=alPoints.get(i);

        }
        return points;
    }

    public static int getNumberOfPoints(DSymbol s){
        int numberOfPooints=0;
        for (DStroke stroke : s) {
            numberOfPooints+=stroke.size();
        }
        return numberOfPooints;
    }

    public static int[] extractNNumberOfPointsPerStroke(DSymbol s,int N){
        int totalPoints=getNumberOfPoints(s);
        int[] numberOfPoints=new int[s.size()];
//        double[] exactNumbers=new double[s.size()];
        int index=0;
        double exactNumber=0.;
        for (DStroke stroke : s) {
            exactNumber=stroke.size()*N/(double)totalPoints;
            if(exactNumber<1.)
                numberOfPoints[index]=1;
            else
                numberOfPoints[index]=(int) Math.floor(exactNumber);
            index++;
        }
       int suma=sum(numberOfPoints);
       while(suma!=N){
           int max=numberOfPoints[0];
           int posMax=0;
           for (int i = 1; i < numberOfPoints.length; i++) {
               if(max<numberOfPoints[i]){
                   max=numberOfPoints[i];
                   posMax=i;
               }
           }
           if(suma<N){
               numberOfPoints[posMax]++;
               suma++;
           }else{
               numberOfPoints[posMax]--;
               suma--;
           }
       }
        return numberOfPoints;
    }

    public static int sum(int[] numbers){
        int sum=0;
        for (int i = 0; i < numbers.length; i++) {
            sum+= numbers[i];

        }
        return sum;
    }

    public static Point2D[] getNProportionalPoints(DSymbol s,int N){
        Point2D[] points=new Point2D[N];
        ArrayList<Point2D> alPoints=new ArrayList<Point2D>();
//        int pointsPerStroke=(int) Math.round((double)N/s.size());
//        int numStrokes=s.size();
//        int total=0;

        int[]pointsPerStroke=extractNNumberOfPointsPerStroke(s, N);

        for (int i = 0; i < pointsPerStroke.length; i++) {
//            Point2D[] pts=getNPoints(s.get(i), pointsPerStroke);
//            alPoints.addAll(Arrays.asList(pts));
//            total+=pointsPerStroke;
            Point2D[] pts=getNPoints(s.get(i), pointsPerStroke[i]);
            alPoints.addAll(Arrays.asList(pts));
        }

//        int rest=N-total;
//        Point2D[] pts=getNPoints(s.get(numStrokes-1), rest);
//        alPoints.addAll(Arrays.asList(pts));

        for (int i = 0; i < points.length; i++) {
            points[i]=alPoints.get(i);

        }
        return points;
    }

    /**
     * Recives a vector of objects of the clas Point2D and returns a vector
     * that contains just the Xs and Ys coordenates of those points
     * @param p
     * @return
     */
    public static double [] formatPoints(Point2D[] p){
        double [] points=new double[p.length*2];
        for (int i=0;i<p.length;i++) {
            points[i]=p[i].getX();
            points[p.length*2-1-i]=p[i].getY();
        }
        return points;
    }

    /**
     * This method is designed to work with Symbols with any number of strokes
     * and the features are; points of strokes and turning angle
     * @param s
     * @return
     */
    public static double[] extractFeatures(DSymbol symbol){
        int numberOfPoints=16;
        //total features=number of points*2 (because each Point2D has two coordenates) +
        // number of turning angles=2*numberOfPoints+2*(numberOfPoints-1)=4*numberOfPoints-2+1 (for the number of strokes)
        double[] features=new double[numberOfPoints*4-1];
        
        DSymbol s=normalizeSymbol(symbol);


        //HERE ARE CONSIDERED JUST SYMBOLS WITH ONE STROKE
        Point2D[] p1=getNPoints(s , numberOfPoints);
        double[] pointsFeature=formatPoints(p1);



        // points to derive other features shouldnt be normalized
        //The here we extract N points from the original symbol
        Point2D[] p2=getNPoints(symbol , numberOfPoints);
        
        double[] tAnglesFeature=turningAngles(p2);

        int i=0;
        for (double d : pointsFeature) {
            features[i++]=d;
        }

        for (double d : tAnglesFeature) {
            features[i++]=d;
        }

        features[features.length-1]=symbol.size()/(double)maxNumberOfStrokes;
        return features;
    }

    public static DSymbol normalizeSymbol(DSymbol s){
        DSymbol newS=new DSymbol();
        Point2D zeroPoint=s.getLtPoint();
        double newX,newY;

        double max=s.getHeight();
        if(max<s.getWidth()){
            max=s.getWidth();
        }
        for (DStroke str : s) {
            DStroke newStroke=new DStroke();
            for (TimePoint p : str) {
                TimePoint newP=new TimePoint();
                newX=(p.getX()-zeroPoint.getX())/max;
                newY=(p.getY()-zeroPoint.getY())/max;
                newP.setLocation(newX, newY);
                newP.setTimeInMiliseconds(p.getTimeInMiliseconds());
                newStroke.addCheckingBoundingBox(newP);
            }
            newS.addCheckingBoundingBox(newStroke);
        }
        return newS;
    }

}
