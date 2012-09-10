/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package export;

import MathExpression.Data.DMathExpression;
import MathExpression.Data.DSymbol;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frank
 */
public class MathExpression{

    private ArrayList symbols;
    public MathExpression(DMathExpression expression){
        symbols=new ArrayList();
        for (DSymbol symbol : expression) {
            symbols.add(new Symbol(symbol));
        }
    }
}
