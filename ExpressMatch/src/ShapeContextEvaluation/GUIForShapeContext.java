/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ShapeContextEvaluation;

import Cost.ShapeContext;
import DatabaseMathExpressions.DBFuntions;
import DatabaseMathExpressions.ModelExpression;
import DatabaseMathExpressions.UserExpression;
import FeatureExtractor.FETapia;
import FeatureExtractor.PreprocessingAlgorithms;
import Graph.Vertex;
import Matching.ExpressionMatching;
import MathExpression.Data.DMathExpression;
import MathExpression.Data.DSymbol;
import MathExpression.Data.TimePoint;
import MathExpression.Graphics.GMathExpression;
import MathExpression.Graphics.GStroke;
import MathExpression.Graphics.GSymbol;
import TestMatching.AutomaticTest.MatchingParameters;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author frank
 */
public class GUIForShapeContext {
    public static void main(String args[]){
//        testing shape context local
        DBFuntions databse=new DBFuntions();
        databse.openConnection();
        int idModel=118;
        int idUserExpression=845;


        ModelExpression model = databse.getModelByID(idModel);
        DMathExpression modelExpression=model.getdMathExpression();
        ((GMathExpression)modelExpression).translate(100, 100);
        modelExpression=PreprocessingAlgorithms.preprocessDMathExpression(modelExpression);
        UserExpression userExpression = databse.getUserExpressionByID(idUserExpression);
        DMathExpression instanceExpression=userExpression.getdMExpression();

        ExpressionMatching matching = getConfiguratedMatching();
        instanceExpression=PreprocessingAlgorithms.preprocessDMathExpression(instanceExpression);
        String[][] match=matching.match(instanceExpression, modelExpression);
//        System.out.println("Matching result");
//        Util.Util.printMatrix(match);

////////////
////        testing steps of preprocessing
//        DBFuntions databse=new DBFuntions();
//        databse.openConnection();
////        int idUserExpression=909;
//        int idUserExpression=362;
//        UserExpression userExpression = databse.getUserExpressionByID(idUserExpression);
//        DMathExpression instanceExpression=userExpression.getdMExpression();
//
//        for(int i=0;i<instanceExpression.size();i++){
//            DSymbol originalSymbol=instanceExpression.get(i);
//            GSymbol resampledSymbol=(GSymbol) PreprocessingAlgorithms.resampleSymbol(originalSymbol);
//
//            GSymbol dehookedSymbol=(GSymbol) PreprocessingAlgorithms.dehookSymbol(resampledSymbol);
//
//            GSymbol smoothedSymbol=(GSymbol) PreprocessingAlgorithms.smooth(dehookedSymbol);
//            GSymbol preprocesedSymbol=(GSymbol) PreprocessingAlgorithms.resampleSymbol(smoothedSymbol);
//
//            PanSymbol p1=new PanSymbol();
//            p1.setLabel("original");
//            p1.setSymbol((GSymbol)originalSymbol);
//
//            PanSymbol p2=new PanSymbol();
//            p2.setLabel("after resampling");
//            p2.setSymbol(resampledSymbol);
//
//            PanSymbol p3=new PanSymbol();
//            p3.setSymbol(dehookedSymbol);
//            p3.setLabel("after dehooking");
//
//            PanSymbol p4=new PanSymbol();
//            p4.setSymbol(smoothedSymbol);
//            p4.setLabel("after smoothing");
//
//            PanSymbol p5=new PanSymbol();
//            p5.setSymbol(preprocesedSymbol);
//            p5.setLabel("after 2nd resampling");
//
//            JPanel contentPane=new JPanel();
//            contentPane.add(p1);
//            contentPane.add(p2);
//            contentPane.add(p3);
//            contentPane.add(p4);
//            contentPane.add(p5);
//
//            JFrame frm=new JFrame();
//            frm.setContentPane(contentPane);
//            frm.pack();
//            frm.setVisible(true);
//
//            int x=0;
//            x++;
//            frm.dispose();
//
//// end testing steps of preprocessing

//////////
//        testing preprocessing
//        DBFuntions databse=new DBFuntions();
//        databse.openConnection();
//        int idUserExpression=909;
////        int idUserExpression=362;
//        UserExpression userExpression = databse.getUserExpressionByID(idUserExpression);
//        DMathExpression instanceExpression=userExpression.getdMExpression();
//
//        for(int i=0;i<instanceExpression.size();i++){
//            DSymbol originalSymbol=instanceExpression.get(i);
//            GSymbol preprocessedSymbol=(GSymbol) PreprocessingAlgorithms.preprocessDSymbol(originalSymbol);
//
//            Point2D[] nPoints= PreprocessingAlgorithms.getNPoints(preprocessedSymbol, 30);
////            System.out.println("num of pooints: "+nPoints.length);
//            for (int j = 0; j < nPoints.length-1; j++) {
//                System.out.println("dist ("+j+") "+nPoints[j].distance(nPoints[j+1]));
//            }
//            GStroke nPointsStroke=new GStroke();
//            for (int j = 0; j < nPoints.length; j++) {
//                Point2D point2D = nPoints[j];
//                nPointsStroke.addCheckingBoundingBox(new TimePoint(point2D.getX(),
//                        point2D.getY(), -1));
//            }
//            GSymbol NpointsSymbol=new GSymbol();
//            NpointsSymbol.addCheckingBoundingBox(nPointsStroke);
//
//            PanSymbol p1=new PanSymbol();
//            p1.setLabel("original");
//            p1.setSymbol((GSymbol)originalSymbol);
//
//            PanSymbol p2=new PanSymbol();
//            p2.setLabel("after preprocessing");
//            p2.setSymbol(preprocessedSymbol);
//
//            PanSymbol p3=new PanSymbol();
//            p3.setSymbol(NpointsSymbol);
//            p3.setLabel("extracting N points");
//
//
//            JPanel contentPane=new JPanel();
//            contentPane.add(p1);
//            contentPane.add(p2);
//            contentPane.add(p3);
//
//            JFrame frm=new JFrame();
//            frm.setContentPane(contentPane);
//            frm.pack();
//            frm.setVisible(true);
//
//            int x=0;
//            x++;
//            frm.dispose();
//
//// end testing s
//        }
        
    }

    public static ExpressionMatching getConfiguratedMatching(){
        ExpressionMatching matching = new ExpressionMatching();
        matching.setAlpha(0.3f);
        matching.setBeta(1);
        matching.setGama(0.25f);
        matching.setDelaunay(false);
        return matching;
    }

    public static void showGUI(Vertex [] vertexList,float[] angles,
            float[] radios,int radio,int posCenter, GMathExpression expression){
        Point2D[] points=new Point2D[vertexList.length];
        int cont=0;
        for (Vertex v : vertexList) {
            points[cont++]=new Point2D.Double(v.getX(),v.getY());
        }

        ShapeContextDrawer scd=new ShapeContextDrawer();
        scd.setShape(points);
        scd.setAngles(angles);
        scd.setCenter(points[posCenter]);
        scd.setRadios(radios);
        scd.setRadio(radio);



        PanShapeContextDrawer pan=new PanShapeContextDrawer();
        pan.setDrawer(scd);

        pan.setMathExpression(expression);

        JFrame frm=new JFrame();
        frm.setContentPane(pan);
        frm.pack();
        frm.setVisible(true);

        int x=0;
        x++;

        frm.dispose();
        
    }
}
