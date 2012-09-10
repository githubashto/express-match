/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseMathExpressions;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author frank.aguilar
 */
public class TextualRepresentation extends ArrayList<String> 
implements Serializable{

    @Override
    public String toString() {
        String string="";
        int textualIndex=1;
        for (String representation:this) {
            string+=(textualIndex+". "+representation);
            textualIndex++;
        }
        return string;
    }
    
    
}
