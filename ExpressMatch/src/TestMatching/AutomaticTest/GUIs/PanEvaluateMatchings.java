/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestMatching.AutomaticTest.GUIs;

import DatabaseMathExpressions.DBFuntions;
import GUIs.PanLabeling;
import Matching.ExpressionMatching;
import Matching.Matching;
import MathExpression.Graphics.GMathExpression;
import TestMatching.AutomaticTest.MatchingParameters;
import TestMatching.TestInitialMatchings.DatabaseTestFunctions;

/**
 *
 * @author frank
 */
public class PanEvaluateMatchings extends PanLabeling{

    private Matching matching;

    public PanEvaluateMatchings(){
        super();
        matching=new ExpressionMatching();
        dbFunctions=new DBFuntions();
        dbFunctions.openConnection();
        chargeModelsJList();
    }

    @Override
    public void showMatching(){
        panControlOfMatchingPanel.getPanMatching().setgMathExpressionInput((GMathExpression) selectedUE.getdMExpression());
       // panControlOfMatchingPanel.setgMathExpressionModel((GMathExpression) selectedME.getdMathExpression());
        String[][] strMatch=matching.match(selectedME.getdMathExpression(),selectedUE.getdMExpression());
        int[][] match=Util.Util.stringToIntMatrix(strMatch);
        panControlOfMatchingPanel.getPanMatching().setMatch(match);
        panControlOfMatchingPanel.setUpMatchingDrawer();
        panControlOfMatchingPanel.repaint();
    }

    public Matching getMatching() {
        return matching;
    }

    public void setMatching(Matching matching) {
        this.matching = matching;
    }

   

}
