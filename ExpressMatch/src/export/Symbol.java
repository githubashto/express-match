/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package export;

import MathExpression.Data.DStroke;
import MathExpression.Data.DSymbol;
import MathExpression.Graphics.GStroke;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author frank
 */
public class Symbol {
    private String label;
//    private Rectangle2D boundingBox;
    private ArrayList traces;

    public Symbol(DSymbol dsymbol){
        traces=new ArrayList();
        label=dsymbol.getLabel();
//        boundingBox=dsymbol.getBBox();
        for (DStroke stroke : dsymbol) {
            traces.add(new Trace((GStroke) stroke));
        }
    }

//    public Rectangle2D getBoundingBox() {
//        return boundingBox;
//    }
//
//    public void setBoundingBox(Rectangle2D boundingBox) {
//        this.boundingBox = boundingBox;
//    }

    public ArrayList getTraces() {
        return traces;
    }

    public void setTraces(ArrayList traces) {
        this.traces = traces;
    }


}
