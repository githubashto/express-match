/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestMatching.AutomaticTest;

import DatabaseMathExpressions.ModelExpression;
import DatabaseMathExpressions.UserExpression;
import java.util.ArrayList;

/**
 *
 * @author frank
 */
public class ExpressionClass {
    private ModelExpression modelExpression;
    private ArrayList<UserExpression> expressions;

    public ExpressionClass(ModelExpression modelExpression, ArrayList<UserExpression> instanceExpressions) {
        this.modelExpression = modelExpression;
        UserExpression modelAsUsedAsInstanceExpression=new UserExpression();
        modelAsUsedAsInstanceExpression.setdMExpression(modelExpression.getdMathExpression());
        modelAsUsedAsInstanceExpression.setId(modelExpression.getId());
        instanceExpressions.add(modelAsUsedAsInstanceExpression);

        this.expressions = instanceExpressions;
    }

    public ArrayList<UserExpression> getExpressions() {
        return expressions;
    }

    public void setInstanceExpressions(ArrayList<UserExpression> instanceExpressions) {
        this.expressions = instanceExpressions;
    }

    public ModelExpression getModelExpression() {
        return modelExpression;
    }

    public void setModelExpression(ModelExpression modelExpression) {
        this.modelExpression = modelExpression;
    }
}
