/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestMatching.AutomaticTest;

import java.util.ArrayList;

/**
 *
 * @author frank
 */
public class ClassResults extends ArrayList<ResultForParameters>{
    private String idModel;
    private int numberOfSymbols;
    private int numberOfExemplars;


    public String getIdModel() {
        return idModel;
    }

    public void setIdModel(String idModel) {
        this.idModel = idModel;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    public int getNumberOfExemplars() {
        return numberOfExemplars;
    }

    public void setNumberOfExemplars(int numberOfExemplars) {
        this.numberOfExemplars = numberOfExemplars;
    }



}
