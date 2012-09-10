/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestTranslatedModel;

import DatabaseMathExpressions.DBFuntions;
import DatabaseMathExpressions.ModelExpression;
import DatabaseMathExpressions.UserExpression;
import Matching.ExpressionMatching;
import MathExpression.Data.DMathExpression;
import MathExpression.Graphics.GMathExpression;

/**
 *
 * @author frank
 */
public class TestTranslatedModel {

    public static void main(String args[]){
        DBFuntions databse=new DBFuntions();
        databse.openConnection();
        int idModel=127;
        int idUserExpression=766;

//        OTHER INSTANCES(USER EXPRESSIONS) OF DIRRERENT RESULTS
 //       int idUserExpression=897;
//        int idUserExpression=723;
 //       int idUserExpression=795;

        ModelExpression model = databse.getModelByID(idModel);
        DMathExpression modelExpression=model.getdMathExpression();

        UserExpression userExpression = databse.getUserExpressionByID(idUserExpression);
        DMathExpression instanceExpression=userExpression.getdMExpression();

        ExpressionMatching matching = getConfiguratedMatching();

        String[][] match=matching.match(modelExpression, instanceExpression);
        System.out.println("Result before translation");
        Util.Util.printMatrix(match);

        int dx=-298760;
        int dy=1231230;

        ((GMathExpression)modelExpression).translate(dx, dy);
        System.out.println("\n1\t"+  modelExpression.getBBox().getCenterX() + "\t" + 
                modelExpression.getBBox().getCenterY());

        match=matching.match(modelExpression, instanceExpression);
        System.out.println("Result after translation");
        Util.Util.printMatrix(match);

    }

    public static ExpressionMatching getConfiguratedMatching(){
        ExpressionMatching matching = new ExpressionMatching();
        matching.setAlpha(0.3f);
        matching.setBeta(1);
        matching.setGama(0.25f);
        matching.setDelaunay(false);
        return matching;
    }

}
