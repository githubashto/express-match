/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Marcelo;

import DatabaseMathExpressions.DBFuntions;
import DatabaseMathExpressions.ModelExpression;
import DatabaseMathExpressions.UserExpression;
import FeatureExtractor.PreprocessingAlgorithms;
import Matching.Graphics.GMatch;
import Matching.Graphics.GMatching;
import MathExpression.Data.DMathExpression;
import MathExpression.Data.DSymbol;
import MathExpression.Graphics.GMathExpression;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author frank
 */
public class SymbolDataGenerator {

    public static String symbolsOfModelExpressions(){
        String symbols="";
        DBFuntions dbFunctions=new DBFuntions();
        dbFunctions.openConnection();

        ArrayList<ModelExpression> models=dbFunctions.getModelExpressions();
        int count=0;

        int numberOfPoints=30;

        for (ModelExpression modelExpression : models) {

            symbols+="# model "+modelExpression.getId()+"\n";
//            System.out.println("analysing model "+modelExpression.getId()+
//                    " time: "+time);
//            System.out.println("number of symbols = "+modelExpression.getdMathExpression().size());
            ArrayList<UserExpression> instances=dbFunctions.getUserExpressionsForModel(modelExpression.getId());
            //preprocessing instances
            preprocessUserExpressions(instances);

            DMathExpression mathExpression=modelExpression.getdMathExpression();
            DMathExpression processedMathExpression=null;
            processedMathExpression=PreprocessingAlgorithms.preprocessDMathExpression(mathExpression);
            Point2D[] nPoints=null;
            symbols+="# user Willian\n";
            for (int i=0;i< processedMathExpression.size();i++) {
                nPoints = PreprocessingAlgorithms.getNPoints(processedMathExpression.get(i), numberOfPoints);
                for (Point2D point : nPoints)
                    symbols+=((float)point.getX()+" "+(float)point.getY()+" ");
                symbols+=(mathExpression.get(i).getLabel()+"\n");
            }
            for (UserExpression ue : instances) {
                DMathExpression mathUserExpression= ue.getdMExpression();
                symbols+="# user "+ue.getIdUser()+"\n";
                ArrayList<GMatch> formAListMatches = GMatching.formAListMatches((GMathExpression) processedMathExpression, (GMathExpression) mathUserExpression, ue.getMatch());
                for (GMatch gMatch : formAListMatches) {
                    nPoints = PreprocessingAlgorithms.getNPoints(gMatch.getGSymgol(GMatch.POSITION_S2),
                            numberOfPoints);
                    for (Point2D point : nPoints)
                        symbols+=((float)point.getX()+" "+(float)point.getY()+" ");
                    symbols+=(mathExpression.get(gMatch.getPosS1()).getLabel()+"\n");
                }
            }
        }
        
        return symbols;
    }

    private static  void preprocessUserExpressions(ArrayList<UserExpression> userExpressions){
        for (UserExpression modelExpression : userExpressions) {
            DMathExpression expression=modelExpression.getdMExpression();
            expression=PreprocessingAlgorithms.preprocessDMathExpression(expression);
            modelExpression.setdMExpression(expression);
        }
    }

}
