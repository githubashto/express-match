/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseMathExpressions;

import MathExpression.Data.DMathExpression;
import MathExpression.Graphics.GMathExpression;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author frank
 */
public class ModelExpression 
    implements Serializable{

    //private int idDatabase;

    /**
     * identifier of this model expression
     */
    private int id;

    /**
     * Textual representation of this model
     */
    private TextualRepresentation textualRepresentation;

    private ArrayList<UserExpression> alUserExpression;

    private DMathExpression dMathExpression;
    
    private String category;

    public ModelExpression(int id, TextualRepresentation textualRepresentation,
            DMathExpression dMathExpression) {
        this.id = id;
        this.textualRepresentation = textualRepresentation;
        this.dMathExpression = dMathExpression;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public ModelExpression(int id) {
        this.id = id;
        alUserExpression=new ArrayList<UserExpression>();
    }

    public ArrayList<UserExpression> getAlUserExpression() {
        return alUserExpression;
    }

    public void setAlUserExpression(ArrayList<UserExpression> alUserExpression) {
        this.alUserExpression = alUserExpression;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TextualRepresentation getTextualRepresentation() {
        return textualRepresentation;
    }

    public void setTextualRepresentation(TextualRepresentation textualRepresentation) {
        this.textualRepresentation = textualRepresentation;
    }

    public DMathExpression getdMathExpression() {
        return dMathExpression;
    }

    public void setdMathExpression(DMathExpression dMathExpression) {
        this.dMathExpression = dMathExpression;
    }

    public boolean addUserExpression(UserExpression ue){
        return this.getAlUserExpression().add(ue);
    }

    public int getNumberOfCheckedExpressions(){
        int n=0;
        for (UserExpression userExpression : alUserExpression) {
            if(userExpression.isEvaluated())
                n++;
        }
        return n;
    }
}
